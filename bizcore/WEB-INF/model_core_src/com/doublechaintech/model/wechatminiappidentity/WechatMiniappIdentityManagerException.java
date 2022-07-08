
package com.doublechaintech.model.wechatminiappidentity;
//import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class WechatMiniappIdentityManagerException extends ModelException {
	private static final long serialVersionUID = 1L;
	public WechatMiniappIdentityManagerException(String string) {
		super(string);
	}
	public WechatMiniappIdentityManagerException(Message message) {
		super(message);
	}
	public WechatMiniappIdentityManagerException(List<Message> messageList) {
		super(messageList);
	}

}


