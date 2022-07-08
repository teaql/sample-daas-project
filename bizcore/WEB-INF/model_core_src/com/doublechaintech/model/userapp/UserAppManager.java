
package com.doublechaintech.model.userapp;
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




public interface UserAppManager extends BaseManager{

		

  List<UserApp> searchUserAppList(ModelUserContext ctx, UserAppRequest pRequest);
  UserApp searchUserApp(ModelUserContext ctx, UserAppRequest pRequest);
	public UserApp createUserApp(ModelUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String appType,String appId,String ctxType,String ctxId,String location) throws Exception;
	public UserApp updateUserApp(ModelUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(ModelUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public UserApp internalSaveUserApp(ModelUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(ModelUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;

	public UserApp transferToAnotherSecUser(ModelUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, UserApp newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, UserApp updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  QuickLinkManager getQuickLinkManager(ModelUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget ,String [] tokensExpr)  throws Exception;

	public  UserApp addQuickLink(ModelUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget , String [] tokensExpr)  throws Exception;
	public  UserApp removeQuickLink(ModelUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateQuickLink(ModelUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ListAccessManager getListAccessManager(ModelUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;

	public  UserApp addListAccess(ModelUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(ModelUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(ModelUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySecUser(ModelUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(ModelUserContext userContext,String secUserId, int start, int count) throws Exception;
  




}


