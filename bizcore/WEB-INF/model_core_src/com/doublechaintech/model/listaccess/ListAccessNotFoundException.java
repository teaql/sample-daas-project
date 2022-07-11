package com.doublechaintech.model.listaccess;

import com.doublechaintech.model.EntityNotFoundException;

public class ListAccessNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public ListAccessNotFoundException(String string) {
    super(string);
  }
}
