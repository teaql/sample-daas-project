
package com.doublechaintech.model.section;
import com.doublechaintech.model.EntityNotFoundException;

public class SectionVersionChangedException extends SectionManagerException {
	private static final long serialVersionUID = 1L;
	public SectionVersionChangedException(String string) {
		super(string);
	}


}


