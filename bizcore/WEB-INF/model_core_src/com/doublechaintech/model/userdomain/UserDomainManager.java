
package com.doublechaintech.model.userdomain;
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




public interface UserDomainManager extends BaseManager{

		

  List<UserDomain> searchUserDomainList(ModelUserContext ctx, UserDomainRequest pRequest);
  UserDomain searchUserDomain(ModelUserContext ctx, UserDomainRequest pRequest);
	public UserDomain createUserDomain(ModelUserContext userContext, String name) throws Exception;
	public UserDomain updateUserDomain(ModelUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserDomain loadUserDomain(ModelUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public UserDomain internalSaveUserDomain(ModelUserContext userContext, UserDomain userDomain) throws Exception;
	public UserDomain internalSaveUserDomain(ModelUserContext userContext, UserDomain userDomain,Map<String,Object>option) throws Exception;





	public void onNewInstanceCreated(ModelUserContext userContext, UserDomain newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, UserDomain updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAllowListManager getUserAllowListManager(ModelUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws Exception;

	public  UserDomain addUserAllowList(ModelUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions , String [] tokensExpr)  throws Exception;
	public  UserDomain removeUserAllowList(ModelUserContext userContext, String userDomainId, String userAllowListId, int userAllowListVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateUserAllowList(ModelUserContext userContext, String userDomainId, String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SecUserManager getSecUserManager(ModelUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  UserDomain addSecUser(ModelUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(ModelUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(ModelUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PublicKeyTypeManager getPublicKeyTypeManager(ModelUserContext userContext, String userDomainId, String keyAlg, String signAlg ,String [] tokensExpr)  throws Exception;

	public  UserDomain addPublicKeyType(ModelUserContext userContext, String userDomainId, String keyAlg, String signAlg , String [] tokensExpr)  throws Exception;
	public  UserDomain removePublicKeyType(ModelUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updatePublicKeyType(ModelUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/






}


