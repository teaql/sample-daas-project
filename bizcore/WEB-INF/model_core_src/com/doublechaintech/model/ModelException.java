
package com.doublechaintech.model;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize(using = ModelExceptionJsonSerializer.class)
public class ModelException extends com.terapico.BusinessException implements MessageContainer {
    static final long serialVersionUID = -1;
	@Override
	public String getMessage() {

    	String pMessage = super.getMessage();

    	if(this.getErrorMessageList().size()<=0) {
    		return pMessage;
    	}


		StringBuilder stringBuilder=new StringBuilder();
		if (pMessage != null) {
			stringBuilder.append(pMessage).append(':');
		}

		for(Message message: getErrorMessageList()) {
			stringBuilder.append(message.getBody());
		}


		return stringBuilder.toString();
	}
    public ModelException() {
        super();
    }


    public ModelException(String message) {
        super(message);
    }
    public ModelException(Message message) {
    	super();
        this.addErrorMessage(message);
    }
	public ModelException(List<Message> messageList) {
        super();
        this.addErrorMessages(messageList);
    }



    public ModelException(String message, Throwable cause) {
        super(message, cause);
    }


    public ModelException(Throwable cause) {
        super(cause);
    }
	private List<Message> errorMessageList;

    public List<Message> getErrorMessageList() {

    	ensureErrorList();

		return errorMessageList;
	}
	public void setErrorMessageList(List<Message> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	protected void ensureErrorList(){
		if(errorMessageList ==  null){
			errorMessageList =  new ArrayList<Message>();
		}
	}

	public void addErrorMessage(Message errorMessage) {
		ensureErrorList();
		errorMessageList.add(errorMessage);

	}
	public void addErrorMessages(List<Message> messageList) {
		ensureErrorList();
		errorMessageList.addAll(messageList);

	}
	public boolean hasErrors(){
		if(errorMessageList == null){
			return false;
		}
		if(errorMessageList.isEmpty()){
			return false;
		}
		return true;
	}


}

