package com.doublechaintech.model.family;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class FamilyManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public FamilyManagerException(String string) {
    super(string);
  }

  public FamilyManagerException(Message message) {
    super(message);
  }

  public FamilyManagerException(List<Message> messageList) {
    super(messageList);
  }
}
