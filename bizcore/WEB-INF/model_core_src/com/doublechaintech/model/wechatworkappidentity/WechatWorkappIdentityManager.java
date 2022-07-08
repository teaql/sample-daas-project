
package com.doublechaintech.model.wechatworkappidentity;
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




public interface WechatWorkappIdentityManager extends BaseManager{

		

  List<WechatWorkappIdentity> searchWechatWorkappIdentityList(ModelUserContext ctx, WechatWorkappIdentityRequest pRequest);
  WechatWorkappIdentity searchWechatWorkappIdentity(ModelUserContext ctx, WechatWorkappIdentityRequest pRequest);
	public WechatWorkappIdentity createWechatWorkappIdentity(ModelUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatWorkappIdentity updateWechatWorkappIdentity(ModelUserContext userContext,String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatWorkappIdentity loadWechatWorkappIdentity(ModelUserContext userContext, String wechatWorkappIdentityId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public WechatWorkappIdentity internalSaveWechatWorkappIdentity(ModelUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity) throws Exception;
	public WechatWorkappIdentity internalSaveWechatWorkappIdentity(ModelUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity,Map<String,Object>option) throws Exception;

	public WechatWorkappIdentity transferToAnotherSecUser(ModelUserContext userContext, String wechatWorkappIdentityId, String anotherSecUserId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, WechatWorkappIdentity newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, WechatWorkappIdentity updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(ModelUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(ModelUserContext userContext,String secUserId, int start, int count) throws Exception;
  




}


