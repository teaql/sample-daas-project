
package com.doublechaintech.model.userallowlist;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class UserAllowListManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public UserAllowListManagerException(String string) {
		super(string);
	}
	public UserAllowListManagerException(Message message) {
		super(message);
	}
	public UserAllowListManagerException(List<Message> messageList) {
		super(messageList);
	}

}


