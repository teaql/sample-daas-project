package com.doublechaintech.model.form;

import com.doublechaintech.model.ErrorMessageException;

public class DuplicatedFormException extends ErrorMessageException {
  public DuplicatedFormException(String message) {
    super(message);
  }

  public DuplicatedFormException(String message, Throwable cause) {
    super(message, cause);
  }

  public DuplicatedFormException(Throwable cause) {
    super(cause);
  }

  public DuplicatedFormException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

