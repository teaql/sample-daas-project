package com.doublechaintech.model.publickeytype;

import com.doublechaintech.model.AccessKey;

import com.doublechaintech.model.BaseGridViewGenerator;

public class PublicKeyTypeGridViewGenerator extends BaseGridViewGenerator {

  private static final long serialVersionUID = 1L;

  protected void throwExceptionIfListNotFount(String listName) {
    String message = String.format("List '%s' is not found for PublicKeyType", listName);
    throw new IllegalArgumentException(message);
  }

  protected String[] getHeaderKeys(String listName) {

    if (PublicKeyType.KEY_PAIR_IDENTITY_LIST.equals(listName)) {
      return new String[] {"id", "public_key", "key_type", "sec_user", "create_time", "version"};
    }

    throwExceptionIfListNotFount(listName);
    return new String[] {}; // place holder, code will never go here!!!
  }

  protected String getObjectKey(String listName) {
    if (PublicKeyType.KEY_PAIR_IDENTITY_LIST.equals(listName)) {
      return "key_pair_identity";
    }

    throwExceptionIfListNotFount(listName);
    return ""; // place holder, code will never go here!!!
  }
}
