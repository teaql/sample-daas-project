package com.doublechaintech.model.treenode;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class TreeNodeManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public TreeNodeManagerException(String string) {
    super(string);
  }

  public TreeNodeManagerException(Message message) {
    super(message);
  }

  public TreeNodeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
