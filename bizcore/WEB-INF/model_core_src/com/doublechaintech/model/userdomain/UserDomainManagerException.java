package com.doublechaintech.model.userdomain;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class UserDomainManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public UserDomainManagerException(String string) {
    super(string);
  }

  public UserDomainManagerException(Message message) {
    super(message);
  }

  public UserDomainManagerException(List<Message> messageList) {
    super(messageList);
  }
}
