package com.doublechaintech.model.kid;

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

public interface KidManager extends BaseManager {

  List<Kid> searchKidList(ModelUserContext ctx, KidRequest pRequest);

  Kid searchKid(ModelUserContext ctx, KidRequest pRequest);

  public Kid createKid(ModelUserContext userContext, String name, int age, String familyId)
      throws Exception;

  public Kid updateKid(
      ModelUserContext userContext,
      String kidId,
      int kidVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public Kid loadKid(ModelUserContext userContext, String kidId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public Kid internalSaveKid(ModelUserContext userContext, Kid kid) throws Exception;

  public Kid internalSaveKid(ModelUserContext userContext, Kid kid, Map<String, Object> option)
      throws Exception;

  public Kid transferToAnotherFamily(
      ModelUserContext userContext, String kidId, String anotherFamilyId) throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, Kid newCreated) throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, Kid updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByFamily(ModelUserContext userContext, String familyId) throws Exception;

  public Object listPageByFamily(
      ModelUserContext userContext, String familyId, int start, int count) throws Exception;
}
