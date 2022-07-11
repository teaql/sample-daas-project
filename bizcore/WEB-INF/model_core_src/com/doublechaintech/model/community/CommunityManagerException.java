package com.doublechaintech.model.community;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class CommunityManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public CommunityManagerException(String string) {
    super(string);
  }

  public CommunityManagerException(Message message) {
    super(message);
  }

  public CommunityManagerException(List<Message> messageList) {
    super(messageList);
  }
}
