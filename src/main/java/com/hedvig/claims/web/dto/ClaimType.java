package com.hedvig.claims.web.dto;

import java.util.ArrayList;

public class ClaimType {

  public String name;
  public String title;
  public ArrayList<ClaimDataType> requiredData = new ArrayList<ClaimDataType>();
  public ArrayList<ClaimDataType> optionalData = new ArrayList<ClaimDataType>();
  public boolean archive;

  public ClaimType(String name, String title, boolean archive) {
    this.name = name;
    this.title = title;
    this.archive = archive;
  }

  public void addRequiredData(ClaimDataType c) {
    this.requiredData.add(c);
  }

  public void addOptionalData(ClaimDataType c) {
    this.optionalData.add(c);
  }
}
