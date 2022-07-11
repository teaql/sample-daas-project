package com.doublechaintech.model.family;

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

public interface FamilyManager extends BaseManager {

  List<Family> searchFamilyList(ModelUserContext ctx, FamilyRequest pRequest);

  Family searchFamily(ModelUserContext ctx, FamilyRequest pRequest);

  public Family createFamily(ModelUserContext userContext, String name, String communityId)
      throws Exception;

  public Family updateFamily(
      ModelUserContext userContext,
      String familyId,
      int familyVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public Family loadFamily(ModelUserContext userContext, String familyId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public Family internalSaveFamily(ModelUserContext userContext, Family family) throws Exception;

  public Family internalSaveFamily(
      ModelUserContext userContext, Family family, Map<String, Object> option) throws Exception;

  public Family transferToAnotherCommunity(
      ModelUserContext userContext, String familyId, String anotherCommunityId) throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, Family newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, Family updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  KidManager getKidManager(ModelUserContext userContext, String familyId, String name,
  // int age ,String [] tokensExpr)  throws Exception;

  public Family addKid(
      ModelUserContext userContext, String familyId, String name, int age, String[] tokensExpr)
      throws Exception;

  public Family removeKid(
      ModelUserContext userContext,
      String familyId,
      String kidId,
      int kidVersion,
      String[] tokensExpr)
      throws Exception;

  public Family updateKid(
      ModelUserContext userContext,
      String familyId,
      String kidId,
      int kidVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByCommunity(ModelUserContext userContext, String communityId) throws Exception;

  public Object listPageByCommunity(
      ModelUserContext userContext, String communityId, int start, int count) throws Exception;
}
