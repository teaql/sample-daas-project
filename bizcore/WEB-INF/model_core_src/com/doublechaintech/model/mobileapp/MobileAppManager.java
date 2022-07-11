package com.doublechaintech.model.mobileapp;

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

public interface MobileAppManager extends BaseManager {

  List<MobileApp> searchMobileAppList(ModelUserContext ctx, MobileAppRequest pRequest);

  MobileApp searchMobileApp(ModelUserContext ctx, MobileAppRequest pRequest);

  public MobileApp createMobileApp(ModelUserContext userContext, String name) throws Exception;

  public MobileApp updateMobileApp(
      ModelUserContext userContext,
      String mobileAppId,
      int mobileAppVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public MobileApp loadMobileApp(
      ModelUserContext userContext, String mobileAppId, String[] tokensExpr) throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public MobileApp internalSaveMobileApp(ModelUserContext userContext, MobileApp mobileApp)
      throws Exception;

  public MobileApp internalSaveMobileApp(
      ModelUserContext userContext, MobileApp mobileApp, Map<String, Object> option)
      throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, MobileApp newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, MobileApp updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  PageManager getPageManager(ModelUserContext userContext, String mobileAppId, String
  // pageTitle, String linkToUrl, String pageTypeId, int displayOrder ,String [] tokensExpr)  throws
  // Exception;

  public MobileApp addPage(
      ModelUserContext userContext,
      String mobileAppId,
      String pageTitle,
      String linkToUrl,
      String pageTypeId,
      int displayOrder,
      String[] tokensExpr)
      throws Exception;

  public MobileApp removePage(
      ModelUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String[] tokensExpr)
      throws Exception;

  public MobileApp updatePage(
      ModelUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  PageTypeManager getPageTypeManager(ModelUserContext userContext, String mobileAppId,
  // String name, String code, boolean footerTab ,String [] tokensExpr)  throws Exception;

  public MobileApp addPageType(
      ModelUserContext userContext,
      String mobileAppId,
      String name,
      String code,
      boolean footerTab,
      String[] tokensExpr)
      throws Exception;

  public MobileApp removePageType(
      ModelUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String[] tokensExpr)
      throws Exception;

  public MobileApp updatePageType(
      ModelUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

}
