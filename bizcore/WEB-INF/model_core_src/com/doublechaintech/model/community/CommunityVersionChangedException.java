
package com.doublechaintech.model.community;
import com.doublechaintech.model.EntityNotFoundException;

public class CommunityVersionChangedException extends CommunityManagerException {
	private static final long serialVersionUID = 1L;
	public CommunityVersionChangedException(String string) {
		super(string);
	}


}


