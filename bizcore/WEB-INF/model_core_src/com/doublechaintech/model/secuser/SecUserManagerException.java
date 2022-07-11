package com.doublechaintech.model.secuser;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class SecUserManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public SecUserManagerException(String string) {
    super(string);
  }

  public SecUserManagerException(Message message) {
    super(message);
  }

  public SecUserManagerException(List<Message> messageList) {
    super(messageList);
  }
}
