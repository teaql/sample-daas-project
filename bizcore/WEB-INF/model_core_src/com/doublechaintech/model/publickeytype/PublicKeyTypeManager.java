
package com.doublechaintech.model.publickeytype;
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




public interface PublicKeyTypeManager extends BaseManager{

		

  List<PublicKeyType> searchPublicKeyTypeList(ModelUserContext ctx, PublicKeyTypeRequest pRequest);
  PublicKeyType searchPublicKeyType(ModelUserContext ctx, PublicKeyTypeRequest pRequest);
	public PublicKeyType createPublicKeyType(ModelUserContext userContext, String keyAlg,String signAlg,String domainId) throws Exception;
	public PublicKeyType updatePublicKeyType(ModelUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicKeyType loadPublicKeyType(ModelUserContext userContext, String publicKeyTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public PublicKeyType internalSavePublicKeyType(ModelUserContext userContext, PublicKeyType publicKeyType) throws Exception;
	public PublicKeyType internalSavePublicKeyType(ModelUserContext userContext, PublicKeyType publicKeyType,Map<String,Object>option) throws Exception;

	public PublicKeyType transferToAnotherDomain(ModelUserContext userContext, String publicKeyTypeId, String anotherDomainId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, PublicKeyType newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, PublicKeyType updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  KeyPairIdentityManager getKeyPairIdentityManager(ModelUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId ,String [] tokensExpr)  throws Exception;

	public  PublicKeyType addKeyPairIdentity(ModelUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId , String [] tokensExpr)  throws Exception;
	public  PublicKeyType removeKeyPairIdentity(ModelUserContext userContext, String publicKeyTypeId, String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr)  throws Exception;
	public  PublicKeyType updateKeyPairIdentity(ModelUserContext userContext, String publicKeyTypeId, String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(ModelUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(ModelUserContext userContext,String domainId, int start, int count) throws Exception;
  




}


