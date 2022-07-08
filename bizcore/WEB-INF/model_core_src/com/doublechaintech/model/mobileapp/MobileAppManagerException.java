
package com.doublechaintech.model.mobileapp;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class MobileAppManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public MobileAppManagerException(String string) {
		super(string);
	}
	public MobileAppManagerException(Message message) {
		super(message);
	}
	public MobileAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


