
package com.doublechaintech.model.listaccess;
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




public interface ListAccessManager extends BaseManager{

		

  List<ListAccess> searchListAccessList(ModelUserContext ctx, ListAccessRequest pRequest);
  ListAccess searchListAccess(ModelUserContext ctx, ListAccessRequest pRequest);
	public ListAccess createListAccess(ModelUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception;
	public ListAccess updateListAccess(ModelUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(ModelUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public ListAccess internalSaveListAccess(ModelUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(ModelUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;

	public ListAccess transferToAnotherApp(ModelUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, ListAccess newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, ListAccess updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(ModelUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(ModelUserContext userContext,String appId, int start, int count) throws Exception;
  




}


