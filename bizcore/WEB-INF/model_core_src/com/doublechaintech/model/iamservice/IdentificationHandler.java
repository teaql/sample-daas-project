package com.doublechaintech.model.iamservice;

import com.doublechaintech.model.ModelUserContext;

public interface IdentificationHandler {

  /** 完成认证 */
  LoginResult authenticate(ModelUserContext userContext, LoginContext loginContext);
  /** 绑定用户 */
  void bindWithSecUser(ModelUserContext userContext, LoginContext loginContext) throws Exception;
}
