package com.jcf.syslibrary.entities;

import com.jcf.syslibrary.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "user_id")
  private UUID userId;

  private String username;
  private String password;

  private String firstName;
  private String lastName;
  private String email;
  private String phone;

  @OneToMany
  @JoinTable(
    name = "tb_users_address",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "address_id")
  )
  private List<Address> address;

  @OneToMany
  @JoinTable(
    name = "tb_users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<Role> roles;

  public boolean isLoginCorrect(UserRequestDTO loginRequest, PasswordEncoder passwordEncoder) {
    return username.equals(loginRequest.username()) && passwordEncoder.matches(loginRequest.password(), this.password);
  }
}
