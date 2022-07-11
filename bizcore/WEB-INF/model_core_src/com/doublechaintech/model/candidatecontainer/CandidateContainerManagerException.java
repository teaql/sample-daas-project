package com.doublechaintech.model.candidatecontainer;
// import com.doublechaintech.model.EntityNotFoundException;
import com.doublechaintech.model.ModelException;
import com.doublechaintech.model.Message;
import java.util.List;

public class CandidateContainerManagerException extends ModelException {
  private static final long serialVersionUID = 1L;

  public CandidateContainerManagerException(String string) {
    super(string);
  }

  public CandidateContainerManagerException(Message message) {
    super(message);
  }

  public CandidateContainerManagerException(List<Message> messageList) {
    super(messageList);
  }
}
