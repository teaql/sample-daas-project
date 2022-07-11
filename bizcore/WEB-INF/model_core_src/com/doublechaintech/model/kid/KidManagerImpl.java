package com.doublechaintech.model.kid;

import com.doublechaintech.model.*;
import com.doublechaintech.model.BaseViewPage;
import com.doublechaintech.model.ModelUserContextImpl;
import com.doublechaintech.model.family.CandidateFamily;
import com.doublechaintech.model.family.Family;
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

public class KidManagerImpl extends CustomModelCheckerManager
    implements KidManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "Kid";

  @Override
  public KidDAO daoOf(ModelUserContext userContext) {
    return kidDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws KidManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new KidManagerException(message);
  }

  protected Kid saveKid(ModelUserContext userContext, Kid kid, String[] tokensExpr)
      throws Exception {
    // return getKidDAO().save(kid, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveKid(userContext, kid, tokens);
  }

  protected Kid saveKidDetail(ModelUserContext userContext, Kid kid) throws Exception {

    return saveKid(userContext, kid, allTokens());
  }

  public Kid loadKid(ModelUserContext userContext, String kidId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfKid(kidId);

    checkerOf(userContext).throwExceptionIfHasErrors(KidManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    Kid kid = loadKid(userContext, kidId, tokens);
    // do some calc before sent to customer?
    return present(userContext, kid, tokens);
  }

  public Kid searchKid(
      ModelUserContext userContext, String kidId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfKid(kidId);

    checkerOf(userContext).throwExceptionIfHasErrors(KidManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    Kid kid = loadKid(userContext, kidId, tokens);
    // do some calc before sent to customer?
    return present(userContext, kid, tokens);
  }

  protected Kid present(ModelUserContext userContext, Kid kid, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, kid, tokens);

    Kid kidToPresent = kidDaoOf(userContext).present(kid, tokens);

    List<BaseEntity> entityListToNaming = kidToPresent.collectReferencesFromLists();
    kidDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, kid, tokens);

    return kidToPresent;
  }

  public Kid loadKidDetail(ModelUserContext userContext, String kidId) throws Exception {
    Kid kid = loadKid(userContext, kidId, allTokens());
    return present(userContext, kid, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((ModelUserContext) userContext, userApp.getAppId());
  }

  public Object view(ModelUserContext userContext, String kidId) throws Exception {
    Kid kid = loadKid(userContext, kidId, viewTokens());
    markVisited(userContext, kid);
    return present(userContext, kid, viewTokens());
  }

  public Object summaryView(ModelUserContext userContext, String kidId) throws Exception {
    Kid kid = loadKid(userContext, kidId, viewTokens());
    kid.summarySuffix();
    markVisited(userContext, kid);
    return present(userContext, kid, summaryTokens());
  }

  public Object analyze(ModelUserContext userContext, String kidId) throws Exception {
    Kid kid = loadKid(userContext, kidId, analyzeTokens());
    markVisited(userContext, kid);
    return present(userContext, kid, analyzeTokens());
  }

  protected Kid saveKid(ModelUserContext userContext, Kid kid, Map<String, Object> tokens)
      throws Exception {

    return kidDaoOf(userContext).save(kid, tokens);
  }

  protected Kid loadKid(ModelUserContext userContext, String kidId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfKid(kidId);

    checkerOf(userContext).throwExceptionIfHasErrors(KidManagerException.class);

    return kidDaoOf(userContext).load(kidId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      ModelUserContext userContext, Kid kid, Map<String, Object> tokens) {
    super.addActions(userContext, kid, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext,
    // Kid kid, Map<String, Object> tokens){

  @Override
  public List<Kid> searchKidList(ModelUserContext ctx, KidRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<Kid> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public Kid searchKid(ModelUserContext ctx, KidRequest pRequest) {
    pRequest.limit(0, 1);
    List<Kid> list = searchKidList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public Kid createKid(ModelUserContext userContext, String name, int age, String familyId)
      throws Exception {

    checkerOf(userContext).checkNameOfKid(name);
    checkerOf(userContext).checkAgeOfKid(age);

    checkerOf(userContext).throwExceptionIfHasErrors(KidManagerException.class);

    Kid kid = createNewKid();

    kid.setName(name);
    kid.setAge(age);

    Family family = loadFamily(userContext, familyId, emptyOptions());
    kid.setFamily(family);

    kid = saveKid(userContext, kid, emptyOptions());

    onNewInstanceCreated(userContext, kid);
    return kid;
  }

  protected Kid createNewKid() {

    return new Kid();
  }

  protected void checkParamsForUpdatingKid(
      ModelUserContext userContext,
      String kidId,
      int kidVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfKid(kidId);
    checkerOf(userContext).checkVersionOfKid(kidVersion);

    if (Kid.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfKid(parseString(newValueExpr));
    }
    if (Kid.AGE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAgeOfKid(parseInt(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(KidManagerException.class);
  }

  public Kid clone(ModelUserContext userContext, String fromKidId) throws Exception {

    return kidDaoOf(userContext).clone(fromKidId, this.allTokens());
  }

  public Kid internalSaveKid(ModelUserContext userContext, Kid kid) throws Exception {
    return internalSaveKid(userContext, kid, allTokens());
  }

  public Kid internalSaveKid(ModelUserContext userContext, Kid kid, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingKid(userContext, kidId, kidVersion, property, newValueExpr,
    // tokensExpr);

    synchronized (kid) {
      // will be good when the kid loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Kid.
      if (kid.isChanged()) {}

      // checkerOf(userContext).checkAndFixKid(kid);
      kid = saveKid(userContext, kid, options);
      return kid;
    }
  }

  public Kid updateKid(
      ModelUserContext userContext,
      String kidId,
      int kidVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingKid(userContext, kidId, kidVersion, property, newValueExpr, tokensExpr);

    Kid kid = loadKid(userContext, kidId, allTokens());
    if (kid.getVersion() != kidVersion) {
      String message =
          "The target version("
              + kid.getVersion()
              + ") is not equals to version("
              + kidVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (kid) {
      // will be good when the kid loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Kid.

      kid.changeProperty(property, newValueExpr);
      kid = saveKid(userContext, kid, tokens().done());
      return present(userContext, kid, mergedAllTokens(tokensExpr));
      // return saveKid(userContext, kid, tokens().done());
    }
  }

  public Kid updateKidProperty(
      ModelUserContext userContext,
      String kidId,
      int kidVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingKid(userContext, kidId, kidVersion, property, newValueExpr, tokensExpr);

    Kid kid = loadKid(userContext, kidId, allTokens());
    if (kid.getVersion() != kidVersion) {
      String message =
          "The target version("
              + kid.getVersion()
              + ") is not equals to version("
              + kidVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (kid) {
      // will be good when the kid loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Kid.

      kid.changeProperty(property, newValueExpr);

      kid = saveKid(userContext, kid, tokens().done());
      return present(userContext, kid, mergedAllTokens(tokensExpr));
      // return saveKid(userContext, kid, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected KidTokens tokens() {
    return KidTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return KidTokens.all();
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
    return KidTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherFamily(
      ModelUserContext userContext, String kidId, String anotherFamilyId) throws Exception {

    checkerOf(userContext).checkIdOfKid(kidId);
    checkerOf(userContext).checkIdOfFamily(anotherFamilyId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(KidManagerException.class);
  }

  public Kid transferToAnotherFamily(
      ModelUserContext userContext, String kidId, String anotherFamilyId) throws Exception {
    checkParamsForTransferingAnotherFamily(userContext, kidId, anotherFamilyId);

    Kid kid = loadKid(userContext, kidId, allTokens());
    synchronized (kid) {
      // will be good when the kid loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Family family = loadFamily(userContext, anotherFamilyId, emptyOptions());
      kid.updateFamily(family);

      kid = saveKid(userContext, kid, emptyOptions());

      return present(userContext, kid, allTokens());
    }
  }

  public CandidateFamily requestCandidateFamily(
      ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateFamily result = new CandidateFamily();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<Family> candidateList =
        familyDaoOf(userContext)
            .requestCandidateFamilyForKid(userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected Family loadFamily(
      ModelUserContext userContext, String newFamilyId, Map<String, Object> options)
      throws Exception {

    return familyDaoOf(userContext).load(newFamilyId, options);
  }

  // --------------------------------------------------------------

  public Kid forgetByAll(ModelUserContext userContext, String kidId, int kidVersion)
      throws Exception {
    return forgetByAllInternal(userContext, kidId, kidVersion);
  }

  protected Kid forgetByAllInternal(ModelUserContext userContext, String kidId, int kidVersion)
      throws Exception {

    return kidDaoOf(userContext).disconnectFromAll(kidId, kidVersion);
  }

  public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new KidManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(ModelUserContext userContext, Kid newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(ModelUserContext ctx) throws Exception {
    kidDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   Kid newKid = this.createKid(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newKid
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
    key.put(UserApp.APP_TYPE_PROPERTY, Kid.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(ModelUserContext userContext, SmartList<Kid> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Family> familyList =
        ModelBaseUtils.collectReferencedObjectWithType(userContext, list, Family.class);
    userContext.getDAOGroup().enhanceList(familyList, Family.class);
  }

  public Object listByFamily(ModelUserContext userContext, String familyId) throws Exception {
    return listPageByFamily(userContext, familyId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByFamily(
      ModelUserContext userContext, String familyId, int start, int count) throws Exception {
    SmartList<Kid> list =
        kidDaoOf(userContext).findKidByFamily(familyId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    ModelCommonListOfViewPage page = new ModelCommonListOfViewPage();
    page.setClassOfList(Kid.class);
    page.setContainerObject(Family.withId(familyId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("孩子列表");
    page.setRequestName("listByFamily");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByFamily/%s/", getBeanName(), familyId)));

    page.assemblerContent(userContext, "listByFamily");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(ModelUserContext userContext, String kidId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    Kid merchantObj = (Kid) this.view(userContext, kidId);
    String merchantObjId = kidId;
    String linkToUrl = "kidManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "孩子" + "详情";
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
        MapUtil.put("id", "3-age")
            .put("fieldName", "age")
            .put("label", "年龄")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("age", merchantObj.getAge());

    propList.add(
        MapUtil.put("id", "4-family")
            .put("fieldName", "family")
            .put("label", "家庭")
            .put("type", "auto")
            .put("linkToUrl", "familyManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("family", merchantObj.getFamily());

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
