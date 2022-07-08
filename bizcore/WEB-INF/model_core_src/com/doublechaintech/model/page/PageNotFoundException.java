
package com.doublechaintech.model.page;
import com.doublechaintech.model.EntityNotFoundException;
public class PageNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public PageNotFoundException(String string) {
		super(string);
	}

}

