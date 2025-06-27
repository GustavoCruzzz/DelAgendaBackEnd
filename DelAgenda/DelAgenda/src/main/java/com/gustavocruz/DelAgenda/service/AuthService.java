/*package com.gustavocruz.DelAgenda.service;

import com.gustavocruz.DelAgenda.data.dto.security.AccountCredentialsDTO;
import com.gustavocruz.DelAgenda.data.dto.security.TokenDTO;
import com.gustavocruz.DelAgenda.repository.UserRepository;
import com.gustavocruz.DelAgenda.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenProvider tokenProvider;

  @Autowired
  private UserRepository repository;

  public ResponseEntity<TokenDTO> signIn(AccountCredentialsDTO credentials){
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
      var user = repository.findByUsername(credentials.getUsername());
      if(user == null){
          throw new UsernameNotFoundException("Username "+credentials.getUsername()+" not found !");
      }
      var tokenResponse = tokenProvider.createAccessToken(credentials.getUsername(), user.getRoles());
      return ResponseEntity.ok(tokenResponse);
  }

    public ResponseEntity<TokenDTO> refreshToken(String username, String refreshToken){

        var user = repository.findByUsername(username);
        TokenDTO token;
        if(user != null){
            token = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found !");
        }

        return ResponseEntity.ok(token);
        }

    private String generateHashedPassword(String password){
      PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder("", 8, 185000, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", pbkdf2Encoder);
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);

        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
        return passwordEncoder.encode(password);

    }
}
*/