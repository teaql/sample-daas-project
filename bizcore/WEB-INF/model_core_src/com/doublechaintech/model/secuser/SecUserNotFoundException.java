package com.doublechaintech.model.secuser;

import com.doublechaintech.model.EntityNotFoundException;

public class SecUserNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public SecUserNotFoundException(String string) {
    super(string);
  }
}
