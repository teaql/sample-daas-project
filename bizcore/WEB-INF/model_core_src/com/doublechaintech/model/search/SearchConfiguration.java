package com.doublechaintech.model.search;

public class SearchConfiguration {
  public static final String MODEL_LOCAL = "local";
  private String model = MODEL_LOCAL;

  public String getModel() {
    return model;
  }

  public void setModel(String pModel) {
    model = pModel;
  }
}
