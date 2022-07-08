
package com.doublechaintech.model.keypairidentity;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class KeyPairIdentityManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public KeyPairIdentityManagerException(String string) {
		super(string);
	}
	public KeyPairIdentityManagerException(Message message) {
		super(message);
	}
	public KeyPairIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


