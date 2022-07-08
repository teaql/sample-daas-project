
package com.doublechaintech.model.candidatecontainer;
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




public interface CandidateContainerManager extends BaseManager{

		

  List<CandidateContainer> searchCandidateContainerList(ModelUserContext ctx, CandidateContainerRequest pRequest);
  CandidateContainer searchCandidateContainer(ModelUserContext ctx, CandidateContainerRequest pRequest);
	public CandidateContainer createCandidateContainer(ModelUserContext userContext, String name) throws Exception;
	public CandidateContainer updateCandidateContainer(ModelUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(ModelUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public CandidateContainer internalSaveCandidateContainer(ModelUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(ModelUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;





	public void onNewInstanceCreated(ModelUserContext userContext, CandidateContainer newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, CandidateContainer updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CandidateElementManager getCandidateElementManager(ModelUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;

	public  CandidateContainer addCandidateElement(ModelUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(ModelUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(ModelUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/






}


