package com.doublechaintech.model.uiaction;

import com.doublechaintech.model.EntityNotFoundException;

public class UiActionVersionChangedException extends UiActionManagerException {
  private static final long serialVersionUID = 1L;

  public UiActionVersionChangedException(String string) {
    super(string);
  }
}
