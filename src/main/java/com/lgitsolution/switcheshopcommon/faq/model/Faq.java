
package com.lgitsolution.switcheshopcommon.faq.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "faq")
public class Faq {

  /** The id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /** The question */
  @Column(name = "question")
  private String question;

  /** The answer */
  @Column(name = "answer", columnDefinition = "text")
  private String answer;

  /** The title */
  @Column(name = "title")
  private String title;

}
