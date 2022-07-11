package com.doublechaintech.model.mobileapp;

import com.doublechaintech.model.EntityNotFoundException;

public class MobileAppNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public MobileAppNotFoundException(String string) {
    super(string);
  }
}
