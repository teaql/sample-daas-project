package com.doublechaintech.model.community;

import com.doublechaintech.model.EntityNotFoundException;

public class CommunityNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public CommunityNotFoundException(String string) {
    super(string);
  }
}
