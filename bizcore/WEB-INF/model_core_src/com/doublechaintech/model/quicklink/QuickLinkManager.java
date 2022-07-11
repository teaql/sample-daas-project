package com.doublechaintech.model.quicklink;

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

public interface QuickLinkManager extends BaseManager {

  List<QuickLink> searchQuickLinkList(ModelUserContext ctx, QuickLinkRequest pRequest);

  QuickLink searchQuickLink(ModelUserContext ctx, QuickLinkRequest pRequest);

  public QuickLink createQuickLink(
      ModelUserContext userContext,
      String name,
      String icon,
      String imagePath,
      String linkTarget,
      String appId)
      throws Exception;

  public QuickLink updateQuickLink(
      ModelUserContext userContext,
      String quickLinkId,
      int quickLinkVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public QuickLink loadQuickLink(
      ModelUserContext userContext, String quickLinkId, String[] tokensExpr) throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public QuickLink internalSaveQuickLink(ModelUserContext userContext, QuickLink quickLink)
      throws Exception;

  public QuickLink internalSaveQuickLink(
      ModelUserContext userContext, QuickLink quickLink, Map<String, Object> option)
      throws Exception;

  public QuickLink transferToAnotherApp(
      ModelUserContext userContext, String quickLinkId, String anotherAppId) throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, QuickLink newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, QuickLink updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByApp(ModelUserContext userContext, String appId) throws Exception;

  public Object listPageByApp(ModelUserContext userContext, String appId, int start, int count)
      throws Exception;
}
