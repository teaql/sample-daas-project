
package com.doublechaintech.model.quicklink;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class QuickLinkManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public QuickLinkManagerException(String string) {
		super(string);
	}
	public QuickLinkManagerException(Message message) {
		super(message);
	}
	public QuickLinkManagerException(List<Message> messageList) {
		super(messageList);
	}

}


