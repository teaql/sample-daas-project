
package com.doublechaintech.model.loginhistory;
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




public interface LoginHistoryManager extends BaseManager{

		

  List<LoginHistory> searchLoginHistoryList(ModelUserContext ctx, LoginHistoryRequest pRequest);
  LoginHistory searchLoginHistory(ModelUserContext ctx, LoginHistoryRequest pRequest);
	public LoginHistory createLoginHistory(ModelUserContext userContext, String fromIp,String description,String secUserId) throws Exception;
	public LoginHistory updateLoginHistory(ModelUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(ModelUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public LoginHistory internalSaveLoginHistory(ModelUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(ModelUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;

	public LoginHistory transferToAnotherSecUser(ModelUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, LoginHistory newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, LoginHistory updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(ModelUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(ModelUserContext userContext,String secUserId, int start, int count) throws Exception;
  




}


