package com.doublechaintech.model.loginhistory;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class LoginHistoryManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public LoginHistoryManagerException(String string) {
    super(string);
  }

  public LoginHistoryManagerException(Message message) {
    super(message);
  }

  public LoginHistoryManagerException(List<Message> messageList) {
    super(messageList);
  }
}
