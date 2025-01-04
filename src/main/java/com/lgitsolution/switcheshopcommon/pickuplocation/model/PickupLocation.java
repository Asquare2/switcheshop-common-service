
package com.lgitsolution.switcheshopcommon.pickuplocation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pickup_location")
public class PickupLocation {

  @Id
  private Long id;

  @Column(name = "pickup_location")
  private String pickupLocation;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;

  @Column(name = "pincode")
  private String pincode;

  @Column(name = "address_1")
  private String address;

  @Column(name = "address_2")
  private String address2;

  @Column(name = "is_verified")
  private Integer isVerified;

  @Column(name = "is_primary")
  private Integer isPrimary;

}
