
package com.doublechaintech.model.userallowlist;
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




public interface UserAllowListManager extends BaseManager{

		

  List<UserAllowList> searchUserAllowListList(ModelUserContext ctx, UserAllowListRequest pRequest);
  UserAllowList searchUserAllowList(ModelUserContext ctx, UserAllowListRequest pRequest);
	public UserAllowList createUserAllowList(ModelUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception;
	public UserAllowList updateUserAllowList(ModelUserContext userContext,String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserAllowList loadUserAllowList(ModelUserContext userContext, String userAllowListId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public UserAllowList internalSaveUserAllowList(ModelUserContext userContext, UserAllowList userAllowList) throws Exception;
	public UserAllowList internalSaveUserAllowList(ModelUserContext userContext, UserAllowList userAllowList,Map<String,Object>option) throws Exception;

	public UserAllowList transferToAnotherDomain(ModelUserContext userContext, String userAllowListId, String anotherDomainId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, UserAllowList newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, UserAllowList updated, Object actor, String methodName) throws Exception {};


  public UserAllowList updateUserRole(ModelUserContext ctx, String userIdentity, String roleName, boolean add) throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDomain(ModelUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(ModelUserContext userContext,String domainId, int start, int count) throws Exception;
  




}


