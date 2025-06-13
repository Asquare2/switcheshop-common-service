
package com.lgitsolution.switcheshopcommon.attribute.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="attribute")
public class Attribute {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  /** The name. */
  @Column(name = "name")
  private String name;
  
  /** The status. */
  @Column(name = "status")
  private int status;
  
  /** The display name , that will be show on customer end. */
  @Column(name = "display_name")
  private String displayName;
  
  // Mapping to the other table
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "attribute_id", referencedColumnName = "id")
  @OrderBy("id DESC")
  private List<AttributeOption> attributeOptionList = new ArrayList<AttributeOption>();

}
