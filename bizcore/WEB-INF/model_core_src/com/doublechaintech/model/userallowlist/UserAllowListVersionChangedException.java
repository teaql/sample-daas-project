package com.doublechaintech.model.userallowlist;

import com.doublechaintech.model.EntityNotFoundException;

public class UserAllowListVersionChangedException extends UserAllowListManagerException {
  private static final long serialVersionUID = 1L;

  public UserAllowListVersionChangedException(String string) {
    super(string);
  }
}
