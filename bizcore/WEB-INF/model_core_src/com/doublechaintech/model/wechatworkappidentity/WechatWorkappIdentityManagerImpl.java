package com.doublechaintech.model.wechatworkappidentity;

import com.doublechaintech.model.*;
import com.doublechaintech.model.BaseViewPage;
import com.doublechaintech.model.ModelUserContextImpl;
import com.doublechaintech.model.iamservice.*;
import com.doublechaintech.model.secuser.CandidateSecUser;
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

public class WechatWorkappIdentityManagerImpl extends CustomModelCheckerManager
    implements WechatWorkappIdentityManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "WechatWorkappIdentity";

  @Override
  public WechatWorkappIdentityDAO daoOf(ModelUserContext userContext) {
    return wechatWorkappIdentityDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws WechatWorkappIdentityManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new WechatWorkappIdentityManagerException(message);
  }

  protected WechatWorkappIdentity saveWechatWorkappIdentity(
      ModelUserContext userContext,
      WechatWorkappIdentity wechatWorkappIdentity,
      String[] tokensExpr)
      throws Exception {
    // return getWechatWorkappIdentityDAO().save(wechatWorkappIdentity, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens);
  }

  protected WechatWorkappIdentity saveWechatWorkappIdentityDetail(
      ModelUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity) throws Exception {

    return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, allTokens());
  }

  public WechatWorkappIdentity loadWechatWorkappIdentity(
      ModelUserContext userContext, String wechatWorkappIdentityId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, tokens);
    // do some calc before sent to customer?
    return present(userContext, wechatWorkappIdentity, tokens);
  }

  public WechatWorkappIdentity searchWechatWorkappIdentity(
      ModelUserContext userContext,
      String wechatWorkappIdentityId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, tokens);
    // do some calc before sent to customer?
    return present(userContext, wechatWorkappIdentity, tokens);
  }

  protected WechatWorkappIdentity present(
      ModelUserContext userContext,
      WechatWorkappIdentity wechatWorkappIdentity,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, wechatWorkappIdentity, tokens);

    WechatWorkappIdentity wechatWorkappIdentityToPresent =
        wechatWorkappIdentityDaoOf(userContext).present(wechatWorkappIdentity, tokens);

    List<BaseEntity> entityListToNaming =
        wechatWorkappIdentityToPresent.collectReferencesFromLists();
    wechatWorkappIdentityDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, wechatWorkappIdentity, tokens);

    return wechatWorkappIdentityToPresent;
  }

  public WechatWorkappIdentity loadWechatWorkappIdentityDetail(
      ModelUserContext userContext, String wechatWorkappIdentityId) throws Exception {
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    return present(userContext, wechatWorkappIdentity, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((ModelUserContext) userContext, userApp.getAppId());
  }

  public Object view(ModelUserContext userContext, String wechatWorkappIdentityId)
      throws Exception {
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, viewTokens());
    markVisited(userContext, wechatWorkappIdentity);
    return present(userContext, wechatWorkappIdentity, viewTokens());
  }

  public Object summaryView(ModelUserContext userContext, String wechatWorkappIdentityId)
      throws Exception {
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, viewTokens());
    wechatWorkappIdentity.summarySuffix();
    markVisited(userContext, wechatWorkappIdentity);
    return present(userContext, wechatWorkappIdentity, summaryTokens());
  }

  public Object analyze(ModelUserContext userContext, String wechatWorkappIdentityId)
      throws Exception {
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, analyzeTokens());
    markVisited(userContext, wechatWorkappIdentity);
    return present(userContext, wechatWorkappIdentity, analyzeTokens());
  }

  protected WechatWorkappIdentity saveWechatWorkappIdentity(
      ModelUserContext userContext,
      WechatWorkappIdentity wechatWorkappIdentity,
      Map<String, Object> tokens)
      throws Exception {

    return wechatWorkappIdentityDaoOf(userContext).save(wechatWorkappIdentity, tokens);
  }

  protected WechatWorkappIdentity loadWechatWorkappIdentity(
      ModelUserContext userContext, String wechatWorkappIdentityId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

    return wechatWorkappIdentityDaoOf(userContext).load(wechatWorkappIdentityId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      ModelUserContext userContext,
      WechatWorkappIdentity wechatWorkappIdentity,
      Map<String, Object> tokens) {
    super.addActions(userContext, wechatWorkappIdentity, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext,
    // WechatWorkappIdentity wechatWorkappIdentity, Map<String, Object> tokens){

  @Override
  public List<WechatWorkappIdentity> searchWechatWorkappIdentityList(
      ModelUserContext ctx, WechatWorkappIdentityRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<WechatWorkappIdentity> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public WechatWorkappIdentity searchWechatWorkappIdentity(
      ModelUserContext ctx, WechatWorkappIdentityRequest pRequest) {
    pRequest.limit(0, 1);
    List<WechatWorkappIdentity> list = searchWechatWorkappIdentityList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public WechatWorkappIdentity createWechatWorkappIdentity(
      ModelUserContext userContext,
      String corpId,
      String userId,
      String secUserId,
      DateTime lastLoginTime)
      throws Exception {

    checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity(corpId);
    checkerOf(userContext).checkUserIdOfWechatWorkappIdentity(userId);
    checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentity(lastLoginTime);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);

    WechatWorkappIdentity wechatWorkappIdentity = createNewWechatWorkappIdentity();

    wechatWorkappIdentity.setCorpId(corpId);
    wechatWorkappIdentity.setUserId(userId);

    SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
    wechatWorkappIdentity.setSecUser(secUser);

    wechatWorkappIdentity.setCreateTime(userContext.now());
    wechatWorkappIdentity.setLastLoginTime(lastLoginTime);

    wechatWorkappIdentity =
        saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

    onNewInstanceCreated(userContext, wechatWorkappIdentity);
    return wechatWorkappIdentity;
  }

  protected WechatWorkappIdentity createNewWechatWorkappIdentity() {

    return new WechatWorkappIdentity();
  }

  protected void checkParamsForUpdatingWechatWorkappIdentity(
      ModelUserContext userContext,
      String wechatWorkappIdentityId,
      int wechatWorkappIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
    checkerOf(userContext).checkVersionOfWechatWorkappIdentity(wechatWorkappIdentityVersion);

    if (WechatWorkappIdentity.CORP_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCorpIdOfWechatWorkappIdentity(parseString(newValueExpr));
    }
    if (WechatWorkappIdentity.USER_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkUserIdOfWechatWorkappIdentity(parseString(newValueExpr));
    }

    if (WechatWorkappIdentity.LAST_LOGIN_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext)
          .checkLastLoginTimeOfWechatWorkappIdentity(parseTimestamp(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);
  }

  public WechatWorkappIdentity clone(
      ModelUserContext userContext, String fromWechatWorkappIdentityId) throws Exception {

    return wechatWorkappIdentityDaoOf(userContext)
        .clone(fromWechatWorkappIdentityId, this.allTokens());
  }

  public WechatWorkappIdentity internalSaveWechatWorkappIdentity(
      ModelUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity) throws Exception {
    return internalSaveWechatWorkappIdentity(userContext, wechatWorkappIdentity, allTokens());
  }

  public WechatWorkappIdentity internalSaveWechatWorkappIdentity(
      ModelUserContext userContext,
      WechatWorkappIdentity wechatWorkappIdentity,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingWechatWorkappIdentity(userContext, wechatWorkappIdentityId,
    // wechatWorkappIdentityVersion, property, newValueExpr, tokensExpr);

    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WechatWorkappIdentity.
      if (wechatWorkappIdentity.isChanged()) {}

      // checkerOf(userContext).checkAndFixWechatWorkappIdentity(wechatWorkappIdentity);
      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, options);
      return wechatWorkappIdentity;
    }
  }

  public WechatWorkappIdentity updateWechatWorkappIdentity(
      ModelUserContext userContext,
      String wechatWorkappIdentityId,
      int wechatWorkappIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingWechatWorkappIdentity(
        userContext,
        wechatWorkappIdentityId,
        wechatWorkappIdentityVersion,
        property,
        newValueExpr,
        tokensExpr);

    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    if (wechatWorkappIdentity.getVersion() != wechatWorkappIdentityVersion) {
      String message =
          "The target version("
              + wechatWorkappIdentity.getVersion()
              + ") is not equals to version("
              + wechatWorkappIdentityVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WechatWorkappIdentity.

      wechatWorkappIdentity.changeProperty(property, newValueExpr);
      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
      return present(userContext, wechatWorkappIdentity, mergedAllTokens(tokensExpr));
      // return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
    }
  }

  public WechatWorkappIdentity updateWechatWorkappIdentityProperty(
      ModelUserContext userContext,
      String wechatWorkappIdentityId,
      int wechatWorkappIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingWechatWorkappIdentity(
        userContext,
        wechatWorkappIdentityId,
        wechatWorkappIdentityVersion,
        property,
        newValueExpr,
        tokensExpr);

    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    if (wechatWorkappIdentity.getVersion() != wechatWorkappIdentityVersion) {
      String message =
          "The target version("
              + wechatWorkappIdentity.getVersion()
              + ") is not equals to version("
              + wechatWorkappIdentityVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WechatWorkappIdentity.

      wechatWorkappIdentity.changeProperty(property, newValueExpr);

      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
      return present(userContext, wechatWorkappIdentity, mergedAllTokens(tokensExpr));
      // return saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected WechatWorkappIdentityTokens tokens() {
    return WechatWorkappIdentityTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return WechatWorkappIdentityTokens.all();
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
    return WechatWorkappIdentityTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherSecUser(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherSecUserId)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
    checkerOf(userContext).checkIdOfSecUser(anotherSecUserId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);
  }

  public WechatWorkappIdentity transferToAnotherSecUser(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherSecUserId)
      throws Exception {
    checkParamsForTransferingAnotherSecUser(userContext, wechatWorkappIdentityId, anotherSecUserId);

    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());
      wechatWorkappIdentity.updateSecUser(secUser);

      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

      return present(userContext, wechatWorkappIdentity, allTokens());
    }
  }

  protected void checkParamsForTransferingAnotherSecUserWithLogin(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherLogin)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
    checkerOf(userContext).checkLoginOfSecUser(anotherLogin);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);
  }

  public WechatWorkappIdentity transferToAnotherSecUserWithLogin(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherLogin)
      throws Exception {
    checkParamsForTransferingAnotherSecUserWithLogin(
        userContext, wechatWorkappIdentityId, anotherLogin);
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
      wechatWorkappIdentity.updateSecUser(secUser);
      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

      return present(userContext, wechatWorkappIdentity, allTokens());
    }
  }

  protected void checkParamsForTransferingAnotherSecUserWithEmail(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherEmail)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
    checkerOf(userContext).checkEmailOfSecUser(anotherEmail);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);
  }

  public WechatWorkappIdentity transferToAnotherSecUserWithEmail(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherEmail)
      throws Exception {
    checkParamsForTransferingAnotherSecUserWithEmail(
        userContext, wechatWorkappIdentityId, anotherEmail);
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
      wechatWorkappIdentity.updateSecUser(secUser);
      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

      return present(userContext, wechatWorkappIdentity, allTokens());
    }
  }

  protected void checkParamsForTransferingAnotherSecUserWithMobile(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherMobile)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatWorkappIdentity(wechatWorkappIdentityId);
    checkerOf(userContext).checkMobileOfSecUser(anotherMobile);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentityManagerException.class);
  }

  public WechatWorkappIdentity transferToAnotherSecUserWithMobile(
      ModelUserContext userContext, String wechatWorkappIdentityId, String anotherMobile)
      throws Exception {
    checkParamsForTransferingAnotherSecUserWithMobile(
        userContext, wechatWorkappIdentityId, anotherMobile);
    WechatWorkappIdentity wechatWorkappIdentity =
        loadWechatWorkappIdentity(userContext, wechatWorkappIdentityId, allTokens());
    synchronized (wechatWorkappIdentity) {
      // will be good when the wechatWorkappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
      wechatWorkappIdentity.updateSecUser(secUser);
      wechatWorkappIdentity =
          saveWechatWorkappIdentity(userContext, wechatWorkappIdentity, emptyOptions());

      return present(userContext, wechatWorkappIdentity, allTokens());
    }
  }

  public CandidateSecUser requestCandidateSecUser(
      ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateSecUser result = new CandidateSecUser();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("login");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<SecUser> candidateList =
        secUserDaoOf(userContext)
            .requestCandidateSecUserForWechatWorkappIdentity(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected SecUser loadSecUser(
      ModelUserContext userContext, String newSecUserId, Map<String, Object> options)
      throws Exception {

    return secUserDaoOf(userContext).load(newSecUserId, options);
  }

  protected SecUser loadSecUserWithLogin(
      ModelUserContext userContext, String newLogin, Map<String, Object> options) throws Exception {

    return secUserDaoOf(userContext).loadByLogin(newLogin, options);
  }

  protected SecUser loadSecUserWithEmail(
      ModelUserContext userContext, String newEmail, Map<String, Object> options) throws Exception {

    return secUserDaoOf(userContext).loadByEmail(newEmail, options);
  }

  protected SecUser loadSecUserWithMobile(
      ModelUserContext userContext, String newMobile, Map<String, Object> options)
      throws Exception {

    return secUserDaoOf(userContext).loadByMobile(newMobile, options);
  }

  // --------------------------------------------------------------

  public WechatWorkappIdentity forgetByAll(
      ModelUserContext userContext,
      String wechatWorkappIdentityId,
      int wechatWorkappIdentityVersion)
      throws Exception {
    return forgetByAllInternal(userContext, wechatWorkappIdentityId, wechatWorkappIdentityVersion);
  }

  protected WechatWorkappIdentity forgetByAllInternal(
      ModelUserContext userContext,
      String wechatWorkappIdentityId,
      int wechatWorkappIdentityVersion)
      throws Exception {

    return wechatWorkappIdentityDaoOf(userContext)
        .disconnectFromAll(wechatWorkappIdentityId, wechatWorkappIdentityVersion);
  }

  public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new WechatWorkappIdentityManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(ModelUserContext userContext, WechatWorkappIdentity newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(ModelUserContext ctx) throws Exception {
    wechatWorkappIdentityDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   WechatWorkappIdentity newWechatWorkappIdentity =
    // this.createWechatWorkappIdentity(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newWechatWorkappIdentity
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
    key.put(UserApp.APP_TYPE_PROPERTY, WechatWorkappIdentity.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      ModelUserContext userContext, SmartList<WechatWorkappIdentity> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<SecUser> secUserList =
        ModelBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
    userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);
  }

  public Object listBySecUser(ModelUserContext userContext, String secUserId) throws Exception {
    return listPageBySecUser(userContext, secUserId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageBySecUser(
      ModelUserContext userContext, String secUserId, int start, int count) throws Exception {
    SmartList<WechatWorkappIdentity> list =
        wechatWorkappIdentityDaoOf(userContext)
            .findWechatWorkappIdentityBySecUser(secUserId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    ModelCommonListOfViewPage page = new ModelCommonListOfViewPage();
    page.setClassOfList(WechatWorkappIdentity.class);
    page.setContainerObject(SecUser.withId(secUserId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("企业微信认证列表");
    page.setRequestName("listBySecUser");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/", getBeanName(), secUserId)));

    page.assemblerContent(userContext, "listBySecUser");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(ModelUserContext userContext, String wechatWorkappIdentityId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    WechatWorkappIdentity merchantObj =
        (WechatWorkappIdentity) this.view(userContext, wechatWorkappIdentityId);
    String merchantObjId = wechatWorkappIdentityId;
    String linkToUrl = "wechatWorkappIdentityManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "企业微信认证" + "详情";
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
        MapUtil.put("id", "2-corpId")
            .put("fieldName", "corpId")
            .put("label", "公司标识")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("corpId", merchantObj.getCorpId());

    propList.add(
        MapUtil.put("id", "3-userId")
            .put("fieldName", "userId")
            .put("label", "用户Id")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("userId", merchantObj.getUserId());

    propList.add(
        MapUtil.put("id", "4-secUser")
            .put("fieldName", "secUser")
            .put("label", "安全用户")
            .put("type", "auto")
            .put("linkToUrl", "secUserManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
            .into_map());
    result.put("secUser", merchantObj.getSecUser());

    propList.add(
        MapUtil.put("id", "5-createTime")
            .put("fieldName", "createTime")
            .put("label", "创建于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("createTime", merchantObj.getCreateTime());

    propList.add(
        MapUtil.put("id", "6-lastLoginTime")
            .put("fieldName", "lastLoginTime")
            .put("label", "最后登录时间")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastLoginTime", merchantObj.getLastLoginTime());

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
