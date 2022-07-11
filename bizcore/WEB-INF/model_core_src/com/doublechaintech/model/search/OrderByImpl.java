package com.doublechaintech.model.search;

import com.doublechaintech.model.BaseEntity;
import com.doublechaintech.model.DBUtil;

public class OrderByImpl implements OrderBy {
  BaseEntity example;
  String property;
  boolean asc;

  public OrderByImpl(BaseEntity example, String property, boolean asc) {
    this.example = example;
    this.property = property;
    this.asc = asc;
  }

  public String toSql() {
    return DBUtil.getColumnRefer(example, property) + " " + (asc ? "asc" : "desc");
  }
}
