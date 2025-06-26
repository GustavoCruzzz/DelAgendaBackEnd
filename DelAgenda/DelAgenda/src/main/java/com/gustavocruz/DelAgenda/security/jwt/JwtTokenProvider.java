package com.gustavocruz.DelAgenda.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gustavocruz.DelAgenda.data.dto.security.TokenDTO;
import com.gustavocruz.DelAgenda.exceptions.InvalidJwtAuthenticationException;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {

   @Value("${security.jwt.token.secret-key:secret}")
   private String secretKey = "secret";



   @Value("${security.jwt.token.expire-lenght:3600000}")
   private long validityInMilliseconds = 3600000;


   @Autowired
   private UserDetailsService userDetailsService;

   Algorithm algorithm = null;

   @PostConstruct
    protected void init(){

      secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());

      algorithm = Algorithm.HMAC256(secretKey.getBytes());
   }

   public TokenDTO createAccessToken(String username, List<String> roles){
      Date now = new Date();
      Date validity = new Date(now.getTime() + validityInMilliseconds);
      String accessToken = getAccessToken(username, roles, now, validity);
      String refreshToken = getRefreshToken(username, roles, now);
      return new TokenDTO(username, true, now, validity, accessToken, refreshToken);
   }

   private String getRefreshToken(String username, List<String> roles, Date now) {
      Date refreshTokenvalidity = new Date(now.getTime() + validityInMilliseconds);
      return JWT.create().withClaim("roles", roles).withIssuedAt(now).withExpiresAt(refreshTokenvalidity).withSubject(username).sign(algorithm).toString();
   }

   private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
      String issueUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

      return JWT.create().withClaim("roles", roles).withIssuedAt(now).withExpiresAt(validity).withSubject(username).withIssuer(issueUrl).sign(algorithm).toString();
   }

   public Authentication getAuthentication(String token){
      DecodedJWT decodedJWT = decodedToken(token);
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(decodedJWT.getSubject());
      return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

   }

   private DecodedJWT decodedToken(String token) {
   Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
      JWTVerifier verifier = JWT.require(alg).build();
      DecodedJWT decodedJWT = verifier.verify(token);
      return decodedJWT;

   }

   public String resolveToken(HttpServletRequest request){
      String bearerToken = request.getHeader("Authorization");
      if(StringUtils.isEmpty(bearerToken) && bearerToken.startsWith("Bearar ")){
         return bearerToken.substring("Bearer ".length());
      } else{
         throw new InvalidJwtAuthenticationException("Invalid JWT Token");
      }

   }

   public boolean validateToken(String token) {
      DecodedJWT decodedJWT = decodedToken(token);
      try {
         if (decodedJWT.getExpiresAt().before(new Date())) {
            return false;
         }
         return true;
      } catch (Exception e) {
         throw new InvalidJwtAuthenticationException("Expired or invalid JWT Token");
      }
   }
}
