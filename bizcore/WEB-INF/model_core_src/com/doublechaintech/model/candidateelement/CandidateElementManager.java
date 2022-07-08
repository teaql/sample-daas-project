
package com.doublechaintech.model.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.model.ModelUserContext;
import com.doublechaintech.model.BaseEntity;
import com.doublechaintech.model.BaseManager;
import com.doublechaintech.model.SmartList;




public interface CandidateElementManager extends BaseManager{

		

  List<CandidateElement> searchCandidateElementList(ModelUserContext ctx, CandidateElementRequest pRequest);
  CandidateElement searchCandidateElement(ModelUserContext ctx, CandidateElementRequest pRequest);
	public CandidateElement createCandidateElement(ModelUserContext userContext, String name,String type,String image,String containerId) throws Exception;
	public CandidateElement updateCandidateElement(ModelUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(ModelUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public CandidateElement internalSaveCandidateElement(ModelUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(ModelUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;

	public CandidateElement transferToAnotherContainer(ModelUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, CandidateElement newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, CandidateElement updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByContainer(ModelUserContext userContext,String containerId) throws Exception;
	public Object listPageByContainer(ModelUserContext userContext,String containerId, int start, int count) throws Exception;
  




}


