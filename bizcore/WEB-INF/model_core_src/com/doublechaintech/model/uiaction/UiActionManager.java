package com.doublechaintech.model.uiaction;

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

public interface UiActionManager extends BaseManager {

  List<UiAction> searchUiActionList(ModelUserContext ctx, UiActionRequest pRequest);

  UiAction searchUiAction(ModelUserContext ctx, UiActionRequest pRequest);

  public UiAction createUiAction(
      ModelUserContext userContext,
      String code,
      String icon,
      String title,
      int displayOrder,
      String brief,
      String imageUrl,
      String linkToUrl,
      String extraData,
      String pageId)
      throws Exception;

  public UiAction updateUiAction(
      ModelUserContext userContext,
      String uiActionId,
      int uiActionVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public UiAction loadUiAction(ModelUserContext userContext, String uiActionId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(ModelUserContext ctx) throws Exception;

  public UiAction internalSaveUiAction(ModelUserContext userContext, UiAction uiAction)
      throws Exception;

  public UiAction internalSaveUiAction(
      ModelUserContext userContext, UiAction uiAction, Map<String, Object> option) throws Exception;

  public UiAction transferToAnotherPage(
      ModelUserContext userContext, String uiActionId, String anotherPageId) throws Exception;

  public void onNewInstanceCreated(ModelUserContext userContext, UiAction newCreated)
      throws Exception;

  public default void onUpdated(
      ModelUserContext userContext, UiAction updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByPage(ModelUserContext userContext, String pageId) throws Exception;

  public Object listPageByPage(ModelUserContext userContext, String pageId, int start, int count)
      throws Exception;
}
