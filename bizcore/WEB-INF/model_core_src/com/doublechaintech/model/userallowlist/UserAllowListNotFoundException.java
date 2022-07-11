package com.doublechaintech.model.userallowlist;

import com.doublechaintech.model.EntityNotFoundException;

public class UserAllowListNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public UserAllowListNotFoundException(String string) {
    super(string);
  }
}
