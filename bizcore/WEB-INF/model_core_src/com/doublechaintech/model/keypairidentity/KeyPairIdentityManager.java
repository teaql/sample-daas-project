package com.doublechaintech.model.keypairidentity;

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

public interface KeyPairIdentityManager extends BaseManager {

  List<KeyPairIdentity> searchKeyPairIdentityList(
      ModelUserContext ctx, KeyPairIdentityRequest pRequest);

  KeyPairIdentity searchKeyPairIdentity(ModelUserContext ctx, KeyPairIdentityRequest pRequest);

  public KeyPairIdentity createKeyPairIdentity(
      ModelUserContext userContext, String publicKey, String keyTypeId, String secUserId)
      throws Exception;

  public KeyPairIdentity updateKeyPairIdentity(
      ModelUserContext userContext,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public KeyPairIdentity loadKeyPairIdentity(
      ModelUserContext userContext, String keyPairIdentityId, String[] tokensExpr) throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public KeyPairIdentity internalSaveKeyPairIdentity(
      ModelUserContext userContext, KeyPairIdentity keyPairIdentity) throws Exception;

  public KeyPairIdentity internalSaveKeyPairIdentity(
      ModelUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String, Object> option)
      throws Exception;

  public KeyPairIdentity transferToAnotherKeyType(
      ModelUserContext userContext, String keyPairIdentityId, String anotherKeyTypeId)
      throws Exception;

  public KeyPairIdentity transferToAnotherSecUser(
      ModelUserContext userContext, String keyPairIdentityId, String anotherSecUserId)
      throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, KeyPairIdentity newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, KeyPairIdentity updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByKeyType(ModelUserContext userContext, String keyTypeId) throws Exception;

  public Object listPageByKeyType(
      ModelUserContext userContext, String keyTypeId, int start, int count) throws Exception;

  public Object listBySecUser(ModelUserContext userContext, String secUserId) throws Exception;

  public Object listPageBySecUser(
      ModelUserContext userContext, String secUserId, int start, int count) throws Exception;
}
