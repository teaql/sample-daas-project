
package com.doublechaintech.model.wechatminiappidentity;
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




public interface WechatMiniappIdentityManager extends BaseManager{

		

  List<WechatMiniappIdentity> searchWechatMiniappIdentityList(ModelUserContext ctx, WechatMiniappIdentityRequest pRequest);
  WechatMiniappIdentity searchWechatMiniappIdentity(ModelUserContext ctx, WechatMiniappIdentityRequest pRequest);
	public WechatMiniappIdentity createWechatMiniappIdentity(ModelUserContext userContext, String openId,String appId,String unionId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatMiniappIdentity updateWechatMiniappIdentity(ModelUserContext userContext,String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentity loadWechatMiniappIdentity(ModelUserContext userContext, String wechatMiniappIdentityId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public WechatMiniappIdentity internalSaveWechatMiniappIdentity(ModelUserContext userContext, WechatMiniappIdentity wechatMiniappIdentity) throws Exception;
	public WechatMiniappIdentity internalSaveWechatMiniappIdentity(ModelUserContext userContext, WechatMiniappIdentity wechatMiniappIdentity,Map<String,Object>option) throws Exception;

	public WechatMiniappIdentity transferToAnotherSecUser(ModelUserContext userContext, String wechatMiniappIdentityId, String anotherSecUserId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, WechatMiniappIdentity newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, WechatMiniappIdentity updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(ModelUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(ModelUserContext userContext,String secUserId, int start, int count) throws Exception;
  




}


