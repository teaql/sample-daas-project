
package com.doublechaintech.model.publickeytype;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class PublicKeyTypeManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public PublicKeyTypeManagerException(String string) {
		super(string);
	}
	public PublicKeyTypeManagerException(Message message) {
		super(message);
	}
	public PublicKeyTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


