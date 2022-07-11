package com.doublechaintech.model.community;

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

public interface CommunityManager extends BaseManager {

  List<Community> searchCommunityList(ModelUserContext ctx, CommunityRequest pRequest);

  Community searchCommunity(ModelUserContext ctx, CommunityRequest pRequest);

  public Community createCommunity(ModelUserContext userContext, String name, String address)
      throws Exception;

  public Community updateCommunity(
      ModelUserContext userContext,
      String communityId,
      int communityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public Community loadCommunity(
      ModelUserContext userContext, String communityId, String[] tokensExpr) throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public Community internalSaveCommunity(ModelUserContext userContext, Community community)
      throws Exception;

  public Community internalSaveCommunity(
      ModelUserContext userContext, Community community, Map<String, Object> option)
      throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, Community newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, Community updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  FamilyManager getFamilyManager(ModelUserContext userContext, String communityId, String
  // name ,String [] tokensExpr)  throws Exception;

  public Community addFamily(
      ModelUserContext userContext, String communityId, String name, String[] tokensExpr)
      throws Exception;

  public Community removeFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String[] tokensExpr)
      throws Exception;

  public Community updateFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

}
