package com.doublechaintech.model.candidateelement;

import com.doublechaintech.model.*;
import com.doublechaintech.model.BaseViewPage;
import com.doublechaintech.model.ModelUserContextImpl;
import com.doublechaintech.model.candidatecontainer.CandidateCandidateContainer;
import com.doublechaintech.model.candidatecontainer.CandidateContainer;
import com.doublechaintech.model.iamservice.*;
import com.doublechaintech.model.secuser.SecUser;
import com.doublechaintech.model.services.IamService;
import com.doublechaintech.model.tree.*;
import com.doublechaintech.model.treenode.*;
import com.doublechaintech.model.userapp.UserApp;
import com.doublechaintech.model.utils.ModelAssurance;
import com.terapico.caf.BlobObject;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.model.search.Searcher;

public class CandidateElementManagerImpl extends CustomModelCheckerManager
    implements CandidateElementManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "CandidateElement";

  @Override
  public CandidateElementDAO daoOf(ModelUserContext userContext) {
    return candidateElementDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws CandidateElementManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new CandidateElementManagerException(message);
  }

  protected CandidateElement saveCandidateElement(
      ModelUserContext userContext, CandidateElement candidateElement, String[] tokensExpr)
      throws Exception {
    // return getCandidateElementDAO().save(candidateElement, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveCandidateElement(userContext, candidateElement, tokens);
  }

  protected CandidateElement saveCandidateElementDetail(
      ModelUserContext userContext, CandidateElement candidateElement) throws Exception {

    return saveCandidateElement(userContext, candidateElement, allTokens());
  }

  public CandidateElement loadCandidateElement(
      ModelUserContext userContext, String candidateElementId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);

    checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, tokens);
    // do some calc before sent to customer?
    return present(userContext, candidateElement, tokens);
  }

  public CandidateElement searchCandidateElement(
      ModelUserContext userContext,
      String candidateElementId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);

    checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, tokens);
    // do some calc before sent to customer?
    return present(userContext, candidateElement, tokens);
  }

  protected CandidateElement present(
      ModelUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, candidateElement, tokens);

    CandidateElement candidateElementToPresent =
        candidateElementDaoOf(userContext).present(candidateElement, tokens);

    List<BaseEntity> entityListToNaming = candidateElementToPresent.collectReferencesFromLists();
    candidateElementDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, candidateElement, tokens);

    return candidateElementToPresent;
  }

  public CandidateElement loadCandidateElementDetail(
      ModelUserContext userContext, String candidateElementId) throws Exception {
    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, allTokens());
    return present(userContext, candidateElement, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((ModelUserContext) userContext, userApp.getAppId());
  }

  public Object view(ModelUserContext userContext, String candidateElementId) throws Exception {
    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, viewTokens());
    markVisited(userContext, candidateElement);
    return present(userContext, candidateElement, viewTokens());
  }

  public Object summaryView(ModelUserContext userContext, String candidateElementId)
      throws Exception {
    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, viewTokens());
    candidateElement.summarySuffix();
    markVisited(userContext, candidateElement);
    return present(userContext, candidateElement, summaryTokens());
  }

  public Object analyze(ModelUserContext userContext, String candidateElementId) throws Exception {
    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, analyzeTokens());
    markVisited(userContext, candidateElement);
    return present(userContext, candidateElement, analyzeTokens());
  }

  protected CandidateElement saveCandidateElement(
      ModelUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens)
      throws Exception {

    return candidateElementDaoOf(userContext).save(candidateElement, tokens);
  }

  protected CandidateElement loadCandidateElement(
      ModelUserContext userContext, String candidateElementId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);

    checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);

    return candidateElementDaoOf(userContext).load(candidateElementId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      ModelUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens) {
    super.addActions(userContext, candidateElement, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext,
    // CandidateElement candidateElement, Map<String, Object> tokens){

  @Override
  public List<CandidateElement> searchCandidateElementList(
      ModelUserContext ctx, CandidateElementRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<CandidateElement> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public CandidateElement searchCandidateElement(
      ModelUserContext ctx, CandidateElementRequest pRequest) {
    pRequest.limit(0, 1);
    List<CandidateElement> list = searchCandidateElementList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public CandidateElement createCandidateElement(
      ModelUserContext userContext, String name, String type, String image, String containerId)
      throws Exception {

    checkerOf(userContext).checkNameOfCandidateElement(name);
    checkerOf(userContext).checkTypeOfCandidateElement(type);
    checkerOf(userContext).checkImageOfCandidateElement(image);

    checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);

    CandidateElement candidateElement = createNewCandidateElement();

    candidateElement.setName(name);
    candidateElement.setType(type);
    candidateElement.setImage(image);

    CandidateContainer container = loadCandidateContainer(userContext, containerId, emptyOptions());
    candidateElement.setContainer(container);

    candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());

    onNewInstanceCreated(userContext, candidateElement);
    return candidateElement;
  }

  protected CandidateElement createNewCandidateElement() {

    return new CandidateElement();
  }

  protected void checkParamsForUpdatingCandidateElement(
      ModelUserContext userContext,
      String candidateElementId,
      int candidateElementVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
    checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);

    if (CandidateElement.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfCandidateElement(parseString(newValueExpr));
    }
    if (CandidateElement.TYPE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTypeOfCandidateElement(parseString(newValueExpr));
    }
    if (CandidateElement.IMAGE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkImageOfCandidateElement(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);
  }

  public CandidateElement clone(ModelUserContext userContext, String fromCandidateElementId)
      throws Exception {

    return candidateElementDaoOf(userContext).clone(fromCandidateElementId, this.allTokens());
  }

  public CandidateElement internalSaveCandidateElement(
      ModelUserContext userContext, CandidateElement candidateElement) throws Exception {
    return internalSaveCandidateElement(userContext, candidateElement, allTokens());
  }

  public CandidateElement internalSaveCandidateElement(
      ModelUserContext userContext, CandidateElement candidateElement, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingCandidateElement(userContext, candidateElementId,
    // candidateElementVersion, property, newValueExpr, tokensExpr);

    synchronized (candidateElement) {
      // will be good when the candidateElement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to CandidateElement.
      if (candidateElement.isChanged()) {}

      // checkerOf(userContext).checkAndFixCandidateElement(candidateElement);
      candidateElement = saveCandidateElement(userContext, candidateElement, options);
      return candidateElement;
    }
  }

  public CandidateElement updateCandidateElement(
      ModelUserContext userContext,
      String candidateElementId,
      int candidateElementVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCandidateElement(
        userContext,
        candidateElementId,
        candidateElementVersion,
        property,
        newValueExpr,
        tokensExpr);

    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, allTokens());
    if (candidateElement.getVersion() != candidateElementVersion) {
      String message =
          "The target version("
              + candidateElement.getVersion()
              + ") is not equals to version("
              + candidateElementVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (candidateElement) {
      // will be good when the candidateElement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to CandidateElement.

      candidateElement.changeProperty(property, newValueExpr);
      candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
      return present(userContext, candidateElement, mergedAllTokens(tokensExpr));
      // return saveCandidateElement(userContext, candidateElement, tokens().done());
    }
  }

  public CandidateElement updateCandidateElementProperty(
      ModelUserContext userContext,
      String candidateElementId,
      int candidateElementVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCandidateElement(
        userContext,
        candidateElementId,
        candidateElementVersion,
        property,
        newValueExpr,
        tokensExpr);

    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, allTokens());
    if (candidateElement.getVersion() != candidateElementVersion) {
      String message =
          "The target version("
              + candidateElement.getVersion()
              + ") is not equals to version("
              + candidateElementVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (candidateElement) {
      // will be good when the candidateElement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to CandidateElement.

      candidateElement.changeProperty(property, newValueExpr);

      candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
      return present(userContext, candidateElement, mergedAllTokens(tokensExpr));
      // return saveCandidateElement(userContext, candidateElement, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected CandidateElementTokens tokens() {
    return CandidateElementTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return CandidateElementTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return CandidateElementTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherContainer(
      ModelUserContext userContext, String candidateElementId, String anotherContainerId)
      throws Exception {

    checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
    checkerOf(userContext)
        .checkIdOfCandidateContainer(anotherContainerId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);
  }

  public CandidateElement transferToAnotherContainer(
      ModelUserContext userContext, String candidateElementId, String anotherContainerId)
      throws Exception {
    checkParamsForTransferingAnotherContainer(userContext, candidateElementId, anotherContainerId);

    CandidateElement candidateElement =
        loadCandidateElement(userContext, candidateElementId, allTokens());
    synchronized (candidateElement) {
      // will be good when the candidateElement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      CandidateContainer container =
          loadCandidateContainer(userContext, anotherContainerId, emptyOptions());
      candidateElement.updateContainer(container);

      candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());

      return present(userContext, candidateElement, allTokens());
    }
  }

  public CandidateCandidateContainer requestCandidateContainer(
      ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateCandidateContainer result = new CandidateCandidateContainer();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<CandidateContainer> candidateList =
        candidateContainerDaoOf(userContext)
            .requestCandidateCandidateContainerForCandidateElement(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected CandidateContainer loadCandidateContainer(
      ModelUserContext userContext, String newContainerId, Map<String, Object> options)
      throws Exception {

    return candidateContainerDaoOf(userContext).load(newContainerId, options);
  }

  // --------------------------------------------------------------

  public CandidateElement forgetByAll(
      ModelUserContext userContext, String candidateElementId, int candidateElementVersion)
      throws Exception {
    return forgetByAllInternal(userContext, candidateElementId, candidateElementVersion);
  }

  protected CandidateElement forgetByAllInternal(
      ModelUserContext userContext, String candidateElementId, int candidateElementVersion)
      throws Exception {

    return candidateElementDaoOf(userContext)
        .disconnectFromAll(candidateElementId, candidateElementVersion);
  }

  public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new CandidateElementManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(ModelUserContext userContext, CandidateElement newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(ModelUserContext ctx) throws Exception {
    candidateElementDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
  }

  // -----------------------------------//  登录部分处理 \\-----------------------------------
  @Override
  protected BusinessHandler getLoginProcessBizHandler(ModelUserContextImpl userContext) {
    return this;
  }

  public void onAuthenticationFailed(
      ModelUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // by default, failed is failed, nothing can do
  }
  // when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd
  // party service.
  public void onAuthenticateNewUserLogged(
      ModelUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // Generally speaking, when authenticated user logined, we will create a new account for
    // him/her.
    // you need do it like :
    // First, you should create new data such as:
    //   CandidateElement newCandidateElement = this.createCandidateElement(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newCandidateElement
    //   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(),
    // ...
    // Also, set it into loginContext:
    //   loginContext.getLoginTarget().setUserApp(userApp);
    // and in most case, this should be considered as "login success"
    //   loginResult.setSuccess(true);
    //
    // Since many of detailed info were depending business requirement, So,
    throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
  }

  protected SmartList<UserApp> getRelatedUserAppList(
      ModelUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, CandidateElement.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      ModelUserContext userContext, SmartList<CandidateElement> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<CandidateContainer> containerList =
        ModelBaseUtils.collectReferencedObjectWithType(userContext, list, CandidateContainer.class);
    userContext.getDAOGroup().enhanceList(containerList, CandidateContainer.class);
  }

  public Object listByContainer(ModelUserContext userContext, String containerId) throws Exception {
    return listPageByContainer(userContext, containerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByContainer(
      ModelUserContext userContext, String containerId, int start, int count) throws Exception {
    SmartList<CandidateElement> list =
        candidateElementDaoOf(userContext)
            .findCandidateElementByContainer(containerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    ModelCommonListOfViewPage page = new ModelCommonListOfViewPage();
    page.setClassOfList(CandidateElement.class);
    page.setContainerObject(CandidateContainer.withId(containerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("候选人元素列表");
    page.setRequestName("listByContainer");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByContainer/%s/", getBeanName(), containerId)));

    page.assemblerContent(userContext, "listByContainer");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(ModelUserContext userContext, String candidateElementId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    CandidateElement merchantObj = (CandidateElement) this.view(userContext, candidateElementId);
    String merchantObjId = candidateElementId;
    String linkToUrl = "candidateElementManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "候选人元素" + "详情";
    Map result = new HashMap();
    List propList = new ArrayList();
    List sections = new ArrayList();

    propList.add(
        MapUtil.put("id", "1-id")
            .put("fieldName", "id")
            .put("label", "ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("id", merchantObj.getId());

    propList.add(
        MapUtil.put("id", "2-name")
            .put("fieldName", "name")
            .put("label", "名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("name", merchantObj.getName());

    propList.add(
        MapUtil.put("id", "3-type")
            .put("fieldName", "type")
            .put("label", "类型")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("type", merchantObj.getType());

    propList.add(
        MapUtil.put("id", "4-image")
            .put("fieldName", "image")
            .put("label", "图片")
            .put("type", "image")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("image", merchantObj.getImage());

    propList.add(
        MapUtil.put("id", "5-container")
            .put("fieldName", "container")
            .put("label", "容器")
            .put("type", "auto")
            .put("linkToUrl", "candidateContainerManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("container", merchantObj.getContainer());

    // 处理 sectionList

    result.put("propList", propList);
    result.put("sectionList", sections);
    result.put("pageTitle", pageTitle);
    result.put("linkToUrl", linkToUrl);

    vscope
        .field("propList", SerializeScope.EXCLUDE())
        .field("sectionList", SerializeScope.EXCLUDE())
        .field("pageTitle", SerializeScope.EXCLUDE())
        .field("linkToUrl", SerializeScope.EXCLUDE());
    userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
    return BaseViewPage.serialize(result, vscope);
  }
}
