
package com.doublechaintech.model.slide;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class SlideManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public SlideManagerException(String string) {
		super(string);
	}
	public SlideManagerException(Message message) {
		super(message);
	}
	public SlideManagerException(List<Message> messageList) {
		super(messageList);
	}

}


