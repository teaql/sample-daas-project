
package com.doublechaintech.model.kid;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class KidManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public KidManagerException(String string) {
		super(string);
	}
	public KidManagerException(Message message) {
		super(message);
	}
	public KidManagerException(List<Message> messageList) {
		super(messageList);
	}

}


