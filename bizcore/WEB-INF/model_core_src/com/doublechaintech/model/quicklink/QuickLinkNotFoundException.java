package com.doublechaintech.model.quicklink;

import com.doublechaintech.model.EntityNotFoundException;

public class QuickLinkNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public QuickLinkNotFoundException(String string) {
    super(string);
  }
}
