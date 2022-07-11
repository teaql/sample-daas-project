package com.doublechaintech.model.listaccess;

import com.doublechaintech.model.EntityNotFoundException;

public class ListAccessVersionChangedException extends ListAccessManagerException {
  private static final long serialVersionUID = 1L;

  public ListAccessVersionChangedException(String string) {
    super(string);
  }
}
