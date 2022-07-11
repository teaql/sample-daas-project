package com.doublechaintech.model.secuser;

import com.doublechaintech.model.EntityNotFoundException;

public class SecUserVersionChangedException extends SecUserManagerException {
  private static final long serialVersionUID = 1L;

  public SecUserVersionChangedException(String string) {
    super(string);
  }
}
