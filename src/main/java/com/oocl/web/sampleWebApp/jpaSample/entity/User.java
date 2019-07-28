package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
  private static final int MAX_NAME_LENGTH = 60;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  public boolean checkNameLength(String name) throws IllegalArgumentException {
    return null == name || name.length()>MAX_NAME_LENGTH;
  }

  public User(String name) {
    if (!checkNameLength(name)) {
      this.name = name;
    }else {
      throw new IllegalArgumentException("bad name");
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
