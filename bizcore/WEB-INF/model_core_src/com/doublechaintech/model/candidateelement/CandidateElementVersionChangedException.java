package com.doublechaintech.model.candidateelement;

import com.doublechaintech.model.EntityNotFoundException;

public class CandidateElementVersionChangedException extends CandidateElementManagerException {
  private static final long serialVersionUID = 1L;

  public CandidateElementVersionChangedException(String string) {
    super(string);
  }
}
