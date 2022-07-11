package com.doublechaintech.model.candidatecontainer;

import com.doublechaintech.model.EntityNotFoundException;

public class CandidateContainerNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public CandidateContainerNotFoundException(String string) {
    super(string);
  }
}
