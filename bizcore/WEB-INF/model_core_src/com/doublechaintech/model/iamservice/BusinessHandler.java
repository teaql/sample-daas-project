package com.doublechaintech.model.iamservice;

import com.doublechaintech.model.ModelUserContext;

public interface BusinessHandler {

	void onAuthenticationFailed(ModelUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateNewUserLogged(ModelUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateUserLogged(ModelUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

  default Object onLogout(ModelUserContext userContext, BusinessHandler bizHandler) throws Exception {
		return null;
	}
}

















