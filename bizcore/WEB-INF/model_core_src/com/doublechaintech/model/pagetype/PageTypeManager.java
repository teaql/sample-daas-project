package com.doublechaintech.model.pagetype;

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

public interface PageTypeManager extends BaseManager {

  public PageType loadPageTypeWithCode(
      ModelUserContext userContext, String code, Map<String, Object> tokens) throws Exception;

  List<PageType> searchPageTypeList(ModelUserContext ctx, PageTypeRequest pRequest);

  PageType searchPageType(ModelUserContext ctx, PageTypeRequest pRequest);

  public PageType createPageType(
      ModelUserContext userContext, String name, String code, String mobileAppId, boolean footerTab)
      throws Exception;

  public PageType updatePageType(
      ModelUserContext userContext,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public PageType loadPageType(ModelUserContext userContext, String pageTypeId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public PageType internalSavePageType(ModelUserContext userContext, PageType pageType)
      throws Exception;

  public PageType internalSavePageType(
      ModelUserContext userContext, PageType pageType, Map<String, Object> option) throws Exception;

  public PageType transferToAnotherMobileApp(
      ModelUserContext userContext, String pageTypeId, String anotherMobileAppId) throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, PageType newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, PageType updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByMobileApp(ModelUserContext userContext, String mobileAppId) throws Exception;

  public Object listPageByMobileApp(
      ModelUserContext userContext, String mobileAppId, int start, int count) throws Exception;
}
