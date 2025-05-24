
package com.lgitsolution.switcheshopcommon.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lgitsolution.switcheshopcommon.common.dto.ModuleAccess;
import com.lgitsolution.switcheshopcommon.common.util.Utility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "system_users")
public class SystemUser implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "username", length = 50)
  private String userName;

  @Column(name = "password", length = 500)
  private String password;

  @Column(name = "full_name", length = 50)
  private String fullName;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "module_access")
  private String moduleAccess;

  @Column(name = "role", length = 50)
  private String role;

  @Column(name = "address", length = 250)
  private String address;

  @Column(name = "city", length = 50)
  private String city;

  @Column(name = "mobile", length = 20)
  private String mobile;

  @Column(name = "identity_proof", length = 50)
  private String identityProof;

  @Column(name = "multi_media")
  private String multiMedia;

  @Column(name = "created_at")
  private LocalDate createdAt;

  @Column(name = "modified_at")
  private LocalDate modifiedAt;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column(name = "is_system_user", nullable = false)
  private Boolean isSystemUser = true;

  @Column(name = "company_id", nullable = false)
  private String companyId = "";

  @Column(name = "client_id", nullable = false)
  private Integer clientId = -1;

  @jakarta.persistence.Transient
  private Map<String, ModuleAccess> moduleAccessMap = new HashMap<String, ModuleAccess>();

  @jakarta.persistence.Transient
  public void setModuleAccessMap(Map<String, ModuleAccess> moduleAccessMap) {
    this.moduleAccessMap = moduleAccessMap;
    setModuleAccess(Utility.getModuleAccessJsonString(moduleAccessMap));
  }

  @jakarta.persistence.Transient
  public Map<String, ModuleAccess> getModuleAccessMap(Map<String, ModuleAccess> moduleAccessMap) {
    return this.moduleAccessMap;
  }

  public void setModuleAccess(String moduleAccess) {
    this.moduleAccessMap = Utility.getModuleAccessObject(moduleAccess);
    this.moduleAccess = moduleAccess;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
