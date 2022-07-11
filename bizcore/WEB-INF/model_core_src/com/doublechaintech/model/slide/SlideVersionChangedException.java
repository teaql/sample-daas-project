package com.doublechaintech.model.slide;

import com.doublechaintech.model.EntityNotFoundException;

public class SlideVersionChangedException extends SlideManagerException {
  private static final long serialVersionUID = 1L;

  public SlideVersionChangedException(String string) {
    super(string);
  }
}
