
package com.doublechaintech.model.userapp;
import com.doublechaintech.model.EntityNotFoundException;
public class UserAppNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserAppNotFoundException(String string) {
		super(string);
	}

}

