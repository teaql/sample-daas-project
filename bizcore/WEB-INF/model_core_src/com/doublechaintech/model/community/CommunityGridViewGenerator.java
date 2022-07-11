package com.doublechaintech.model.community;

import com.doublechaintech.model.AccessKey;

import com.doublechaintech.model.BaseGridViewGenerator;

public class CommunityGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for Community", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (Community.FAMILY_LIST.equals(listName)) {
      return new String[] {"id", "name", "community", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (Community.FAMILY_LIST.equals(listName)) {
      return "family";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
