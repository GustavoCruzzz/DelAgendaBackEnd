//package com.gustavocruz.DelAgenda.model;
//
//import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "users")
//public class User implements UserDetails, Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//
//    @Column(name = "user_name", unique = true)
//    private String userName;
//
//    @Column
//    private String password;
//
//    @Column
//    private Boolean account_non_expired;
//
//    @Column
//    private Boolean account_non_locked;
//
//    @Column
//    private Boolean credentials_non_expired;
//
//    @Column
//    private Boolean enabled;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_user")}, inverseJoinColumns = {@JoinColumn(name = "id_permission")})
//    private List<Permission> permissions;
//
//    public User() {}
//
//    public List<String> getRoles(){
//        List<String> roles = new ArrayList<>();
//        for(Permission permission: permissions){
//            roles.add(permission.getDescription());
//        }
//        return roles;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.permissions;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.account_non_expired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.account_non_locked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.credentials_non_expired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUser_name() {
//        return userName;
//    }
//
//    public void setUser_name(String user_name) {
//        this.userName = user_name;
//    }
//
//    public Boolean getAccount_non_expired() {
//        return account_non_expired;
//    }
//
//    public void setAccount_non_expired(Boolean account_non_expired) {
//        this.account_non_expired = account_non_expired;
//    }
//
//    public Boolean getAccount_non_locked() {
//        return account_non_locked;
//    }
//
//    public void setAccount_non_locked(Boolean account_non_locked) {
//        this.account_non_locked = account_non_locked;
//    }
//
//    public Boolean getCredentials_non_expired() {
//        return credentials_non_expired;
//    }
//
//    public void setCredentials_non_expired(Boolean credentials_non_expired) {
//        this.credentials_non_expired = credentials_non_expired;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public List<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(List<Permission> permissions) {
//        this.permissions = permissions;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof User user)) return false;
//        return getId() == user.getId() && Objects.equals(getUser_name(), user.getUser_name()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getAccount_non_expired(), user.getAccount_non_expired()) && Objects.equals(getAccount_non_locked(), user.getAccount_non_locked()) && Objects.equals(getCredentials_non_expired(), user.getCredentials_non_expired()) && Objects.equals(isEnabled(), user.isEnabled()) && Objects.equals(getPermissions(), user.getPermissions());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getUser_name(), getPassword(), getAccount_non_expired(), getAccount_non_locked(), getCredentials_non_expired(), isEnabled(), getPermissions());
//    }
//}
