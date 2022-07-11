package com.doublechaintech.model.search;

import java.util.List;

public class AggregationResult {
  private String name;
  private List<AggregationItem> data;

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public List<AggregationItem> getData() {
    return data;
  }

  public void setData(List<AggregationItem> pData) {
    data = pData;
  }
}
