
package com.doublechaintech.model.secuser;
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




public interface SecUserManager extends BaseManager{

		


	public SecUser loadSecUserWithLogin(ModelUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithEmail(ModelUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithMobile(ModelUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

  List<SecUser> searchSecUserList(ModelUserContext ctx, SecUserRequest pRequest);
  SecUser searchSecUser(ModelUserContext ctx, SecUserRequest pRequest);
	public SecUser createSecUser(ModelUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;
	public SecUser updateSecUser(ModelUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(ModelUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public SecUser internalSaveSecUser(ModelUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(ModelUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;

	public SecUser transferToAnotherDomain(ModelUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, SecUser newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, SecUser updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAppManager getUserAppManager(ModelUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String appType, String appId, String ctxType, String ctxId, String location ,String [] tokensExpr)  throws Exception;

	public  SecUser addUserApp(ModelUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String appType, String appId, String ctxType, String ctxId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(ModelUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(ModelUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(ModelUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;

	public  SecUser addLoginHistory(ModelUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(ModelUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(ModelUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentityManager getWechatWorkappIdentityManager(ModelUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatWorkappIdentity(ModelUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentity(ModelUserContext userContext, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentity(ModelUserContext userContext, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentityManager getWechatMiniappIdentityManager(ModelUserContext userContext, String secUserId, String openId, String appId, String unionId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatMiniappIdentity(ModelUserContext userContext, String secUserId, String openId, String appId, String unionId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentity(ModelUserContext userContext, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentity(ModelUserContext userContext, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  KeyPairIdentityManager getKeyPairIdentityManager(ModelUserContext userContext, String secUserId, String publicKey, String keyTypeId ,String [] tokensExpr)  throws Exception;

	public  SecUser addKeyPairIdentity(ModelUserContext userContext, String secUserId, String publicKey, String keyTypeId , String [] tokensExpr)  throws Exception;
	public  SecUser removeKeyPairIdentity(ModelUserContext userContext, String secUserId, String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateKeyPairIdentity(ModelUserContext userContext, String secUserId, String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(ModelUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(ModelUserContext userContext,String domainId, int start, int count) throws Exception;
  




}


