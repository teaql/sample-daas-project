package com.doublechaintech.model.pagetype;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class PageTypeManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public PageTypeManagerException(String string) {
    super(string);
  }

  public PageTypeManagerException(Message message) {
    super(message);
  }

  public PageTypeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
