
package com.doublechaintech.model.wechatworkappidentity;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class WechatWorkappIdentityManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public WechatWorkappIdentityManagerException(String string) {
		super(string);
	}
	public WechatWorkappIdentityManagerException(Message message) {
		super(message);
	}
	public WechatWorkappIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


