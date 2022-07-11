package com.doublechaintech.model.family;

import com.doublechaintech.model.AccessKey;

import com.doublechaintech.model.BaseGridViewGenerator;

public class FamilyGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for Family", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (Family.KID_LIST.equals(listName)) {
      return new String[] {"id", "name", "age", "family", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (Family.KID_LIST.equals(listName)) {
      return "kid";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
