
package com.doublechaintech.model.page;
import com.doublechaintech.model.EntityNotFoundException;

public class PageVersionChangedException extends PageManagerException {
	private static final long serialVersionUID = 1L;
	public PageVersionChangedException(String string) {
		super(string);
	}


}


