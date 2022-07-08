
package com.doublechaintech.model.listaccess;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class ListAccessManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public ListAccessManagerException(String string) {
		super(string);
	}
	public ListAccessManagerException(Message message) {
		super(message);
	}
	public ListAccessManagerException(List<Message> messageList) {
		super(messageList);
	}

}


