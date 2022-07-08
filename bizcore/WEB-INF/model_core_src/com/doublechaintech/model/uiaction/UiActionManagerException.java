
package com.doublechaintech.model.uiaction;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class UiActionManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public UiActionManagerException(String string) {
		super(string);
	}
	public UiActionManagerException(Message message) {
		super(message);
	}
	public UiActionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


