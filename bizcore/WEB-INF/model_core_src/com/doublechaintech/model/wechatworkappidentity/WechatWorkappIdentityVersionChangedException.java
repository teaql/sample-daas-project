package com.doublechaintech.model.wechatworkappidentity;

import com.doublechaintech.model.EntityNotFoundException;

public class WechatWorkappIdentityVersionChangedException
    extends WechatWorkappIdentityManagerException {
  private static final long serialVersionUID = 1L;

  public WechatWorkappIdentityVersionChangedException(String string) {
    super(string);
  }
}
