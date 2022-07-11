package com.doublechaintech.model.kid;

import com.doublechaintech.model.EntityNotFoundException;

public class KidVersionChangedException extends KidManagerException {
  private static final long serialVersionUID = 1L;

  public KidVersionChangedException(String string) {
    super(string);
  }
}
