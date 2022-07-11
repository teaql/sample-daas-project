package com.doublechaintech.model.page;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class PageManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public PageManagerException(String string) {
    super(string);
  }

  public PageManagerException(Message message) {
    super(message);
  }

  public PageManagerException(List<Message> messageList) {
    super(messageList);
  }
}
