
package com.doublechaintech.model.pagetype;
import com.doublechaintech.model.EntityNotFoundException;

public class PageTypeVersionChangedException extends PageTypeManagerException {
	private static final long serialVersionUID = 1L;
	public PageTypeVersionChangedException(String string) {
		super(string);
	}


}


