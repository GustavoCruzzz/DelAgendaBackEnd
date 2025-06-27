//package com.gustavocruz.DelAgenda.model;
//
//import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name="Permission")
//public class Permission implements GrantedAuthority ,Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long Id;
//
//@Column
//private String description;
//
//    @Override
//    public String getAuthority() {
//        return this.description;
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
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Permission that)) return false;
//        return getId() == that.getId() && Objects.equals(getDescription(), that.getDescription());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getDescription());
//    }
//}
