package com.doublechaintech.model.community;

import com.doublechaintech.model.*;
import com.doublechaintech.model.BaseViewPage;
import com.doublechaintech.model.ModelUserContextImpl;
import com.doublechaintech.model.community.Community;
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

public class CommunityManagerImpl extends CustomModelCheckerManager
    implements CommunityManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(ModelUserContext userContext, String id, String listName)
      throws Exception {

    Map<String, Object> tokens = CommunityTokens.start().withTokenFromListName(listName).done();
    Community community = (Community) this.loadCommunity(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = community.collectReferencesFromLists();
    communityDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, community, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new CommunityGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "Community";

  @Override
  public CommunityDAO daoOf(ModelUserContext userContext) {
    return communityDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws CommunityManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new CommunityManagerException(message);
  }

  protected Community saveCommunity(
      ModelUserContext userContext, Community community, String[] tokensExpr) throws Exception {
    // return getCommunityDAO().save(community, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveCommunity(userContext, community, tokens);
  }

  protected Community saveCommunityDetail(ModelUserContext userContext, Community community)
      throws Exception {

    return saveCommunity(userContext, community, allTokens());
  }

  public Community loadCommunity(
      ModelUserContext userContext, String communityId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    Community community = loadCommunity(userContext, communityId, tokens);
    // do some calc before sent to customer?
    return present(userContext, community, tokens);
  }

  public Community searchCommunity(
      ModelUserContext userContext, String communityId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    Community community = loadCommunity(userContext, communityId, tokens);
    // do some calc before sent to customer?
    return present(userContext, community, tokens);
  }

  protected Community present(
      ModelUserContext userContext, Community community, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, community, tokens);

    Community communityToPresent = communityDaoOf(userContext).present(community, tokens);

    List<BaseEntity> entityListToNaming = communityToPresent.collectReferencesFromLists();
    communityDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, community, tokens);

    return communityToPresent;
  }

  public Community loadCommunityDetail(ModelUserContext userContext, String communityId)
      throws Exception {
    Community community = loadCommunity(userContext, communityId, allTokens());
    return present(userContext, community, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((ModelUserContext) userContext, userApp.getAppId());
  }

  public Object view(ModelUserContext userContext, String communityId) throws Exception {
    Community community = loadCommunity(userContext, communityId, viewTokens());
    markVisited(userContext, community);
    return present(userContext, community, viewTokens());
  }

  public Object summaryView(ModelUserContext userContext, String communityId) throws Exception {
    Community community = loadCommunity(userContext, communityId, viewTokens());
    community.summarySuffix();
    markVisited(userContext, community);
    return present(userContext, community, summaryTokens());
  }

  public Object analyze(ModelUserContext userContext, String communityId) throws Exception {
    Community community = loadCommunity(userContext, communityId, analyzeTokens());
    markVisited(userContext, community);
    return present(userContext, community, analyzeTokens());
  }

  protected Community saveCommunity(
      ModelUserContext userContext, Community community, Map<String, Object> tokens)
      throws Exception {

    return communityDaoOf(userContext).save(community, tokens);
  }

  protected Community loadCommunity(
      ModelUserContext userContext, String communityId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfCommunity(communityId);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);

    return communityDaoOf(userContext).load(communityId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      ModelUserContext userContext, Community community, Map<String, Object> tokens) {
    super.addActions(userContext, community, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext,
    // Community community, Map<String, Object> tokens){

  @Override
  public List<Community> searchCommunityList(ModelUserContext ctx, CommunityRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<Community> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public Community searchCommunity(ModelUserContext ctx, CommunityRequest pRequest) {
    pRequest.limit(0, 1);
    List<Community> list = searchCommunityList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public Community createCommunity(ModelUserContext userContext, String name, String address)
      throws Exception {

    checkerOf(userContext).checkNameOfCommunity(name);
    checkerOf(userContext).checkAddressOfCommunity(address);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);

    Community community = createNewCommunity();

    community.setName(name);
    community.setAddress(address);

    community = saveCommunity(userContext, community, emptyOptions());

    onNewInstanceCreated(userContext, community);
    return community;
  }

  protected Community createNewCommunity() {

    return new Community();
  }

  protected void checkParamsForUpdatingCommunity(
      ModelUserContext userContext,
      String communityId,
      int communityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);
    checkerOf(userContext).checkVersionOfCommunity(communityVersion);

    if (Community.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfCommunity(parseString(newValueExpr));
    }
    if (Community.ADDRESS_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAddressOfCommunity(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community clone(ModelUserContext userContext, String fromCommunityId) throws Exception {

    return communityDaoOf(userContext).clone(fromCommunityId, this.allTokens());
  }

  public Community internalSaveCommunity(ModelUserContext userContext, Community community)
      throws Exception {
    return internalSaveCommunity(userContext, community, allTokens());
  }

  public Community internalSaveCommunity(
      ModelUserContext userContext, Community community, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingCommunity(userContext, communityId, communityVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (community) {
      // will be good when the community loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Community.
      if (community.isChanged()) {}

      // checkerOf(userContext).checkAndFixCommunity(community);
      community = saveCommunity(userContext, community, options);
      return community;
    }
  }

  public Community updateCommunity(
      ModelUserContext userContext,
      String communityId,
      int communityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCommunity(
        userContext, communityId, communityVersion, property, newValueExpr, tokensExpr);

    Community community = loadCommunity(userContext, communityId, allTokens());
    if (community.getVersion() != communityVersion) {
      String message =
          "The target version("
              + community.getVersion()
              + ") is not equals to version("
              + communityVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (community) {
      // will be good when the community loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Community.

      community.changeProperty(property, newValueExpr);
      community = saveCommunity(userContext, community, tokens().done());
      return present(userContext, community, mergedAllTokens(tokensExpr));
      // return saveCommunity(userContext, community, tokens().done());
    }
  }

  public Community updateCommunityProperty(
      ModelUserContext userContext,
      String communityId,
      int communityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCommunity(
        userContext, communityId, communityVersion, property, newValueExpr, tokensExpr);

    Community community = loadCommunity(userContext, communityId, allTokens());
    if (community.getVersion() != communityVersion) {
      String message =
          "The target version("
              + community.getVersion()
              + ") is not equals to version("
              + communityVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (community) {
      // will be good when the community loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Community.

      community.changeProperty(property, newValueExpr);

      community = saveCommunity(userContext, community, tokens().done());
      return present(userContext, community, mergedAllTokens(tokensExpr));
      // return saveCommunity(userContext, community, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected CommunityTokens tokens() {
    return CommunityTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return CommunityTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().sortFamilyListWith(Family.ID_PROPERTY, sortDesc()).done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return CommunityTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public Community forgetByAll(
      ModelUserContext userContext, String communityId, int communityVersion) throws Exception {
    return forgetByAllInternal(userContext, communityId, communityVersion);
  }

  protected Community forgetByAllInternal(
      ModelUserContext userContext, String communityId, int communityVersion) throws Exception {

    return communityDaoOf(userContext).disconnectFromAll(communityId, communityVersion);
  }

  public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new CommunityManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingFamily(
      ModelUserContext userContext, String communityId, String name, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);

    checkerOf(userContext).checkNameOfFamily(name);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community addFamily(
      ModelUserContext userContext, String communityId, String name, String[] tokensExpr)
      throws Exception {
    checkParamsForAddingFamily(userContext, communityId, name, tokensExpr);

    Family family = createFamily(userContext, name);

    Community community = loadCommunity(userContext, communityId, emptyOptions());
    synchronized (community) {
      // Will be good when the community loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      community.addFamily(family);
      community = saveCommunity(userContext, community, tokens().withFamilyList().done());

      familyManagerOf(userContext).onNewInstanceCreated(userContext, family);
      return present(userContext, community, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingFamilyProperties(
      ModelUserContext userContext, String communityId, String id, String name, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);
    checkerOf(userContext).checkIdOfFamily(id);

    checkerOf(userContext).checkNameOfFamily(name);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community updateFamilyProperties(
      ModelUserContext userContext, String communityId, String id, String name, String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingFamilyProperties(userContext, communityId, id, name, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withFamilyListList()
            .searchFamilyListWith(Family.ID_PROPERTY, tokens().is(), id)
            .done();

    Community communityToUpdate = loadCommunity(userContext, communityId, options);

    if (communityToUpdate.getFamilyList().isEmpty()) {
      throw new CommunityManagerException("Family is NOT FOUND with id: '" + id + "'");
    }

    Family item = communityToUpdate.getFamilyList().first();
    beforeUpdateFamilyProperties(userContext, item, communityId, id, name, tokensExpr);
    item.updateName(name);

    // checkParamsForAddingFamily(userContext,communityId,name, code, used,tokensExpr);
    Community community =
        saveCommunity(userContext, communityToUpdate, tokens().withFamilyList().done());
    synchronized (community) {
      return present(userContext, community, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateFamilyProperties(
      ModelUserContext userContext,
      Family item,
      String communityId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected Family createFamily(ModelUserContext userContext, String name) throws Exception {

    Family family = new Family();

    family.setName(name);

    return family;
  }

  protected Family createIndexedFamily(String id, int version) {

    Family family = new Family();
    family.setId(id);
    family.setVersion(version);
    return family;
  }

  protected void checkParamsForRemovingFamilyList(
      ModelUserContext userContext, String communityId, String familyIds[], String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);
    for (String familyIdItem : familyIds) {
      checkerOf(userContext).checkIdOfFamily(familyIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community removeFamilyList(
      ModelUserContext userContext, String communityId, String familyIds[], String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingFamilyList(userContext, communityId, familyIds, tokensExpr);

    Community community = loadCommunity(userContext, communityId, allTokens());
    synchronized (community) {
      // Will be good when the community loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      communityDaoOf(userContext).planToRemoveFamilyList(community, familyIds, allTokens());
      community = saveCommunity(userContext, community, tokens().withFamilyList().done());
      deleteRelationListInGraph(userContext, community.getFamilyList());
      return present(userContext, community, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);
    checkerOf(userContext).checkIdOfFamily(familyId);
    checkerOf(userContext).checkVersionOfFamily(familyVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community removeFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingFamily(userContext, communityId, familyId, familyVersion, tokensExpr);

    Family family = createIndexedFamily(familyId, familyVersion);
    Community community = loadCommunity(userContext, communityId, allTokens());
    synchronized (community) {
      // Will be good when the community loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      community.removeFamily(family);
      community = saveCommunity(userContext, community, tokens().withFamilyList().done());
      deleteRelationInGraph(userContext, family);
      return present(userContext, community, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);
    checkerOf(userContext).checkIdOfFamily(familyId);
    checkerOf(userContext).checkVersionOfFamily(familyVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community copyFamilyFrom(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingFamily(userContext, communityId, familyId, familyVersion, tokensExpr);

    Family family = createIndexedFamily(familyId, familyVersion);
    Community community = loadCommunity(userContext, communityId, allTokens());
    synchronized (community) {
      // Will be good when the community loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      community.copyFamilyFrom(family);
      community = saveCommunity(userContext, community, tokens().withFamilyList().done());

      familyManagerOf(userContext)
          .onNewInstanceCreated(
              userContext, (Family) community.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, community, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCommunity(communityId);
    checkerOf(userContext).checkIdOfFamily(familyId);
    checkerOf(userContext).checkVersionOfFamily(familyVersion);

    if (Family.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfFamily(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CommunityManagerException.class);
  }

  public Community updateFamily(
      ModelUserContext userContext,
      String communityId,
      String familyId,
      int familyVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingFamily(
        userContext, communityId, familyId, familyVersion, property, newValueExpr, tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withFamilyList()
            .searchFamilyListWith(Family.ID_PROPERTY, tokens().equals(), familyId)
            .done();

    Community community = loadCommunity(userContext, communityId, loadTokens);

    synchronized (community) {
      // Will be good when the community loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // community.removeFamily( family );
      // make changes to AcceleraterAccount.
      Family familyIdVersionKey = createIndexedFamily(familyId, familyVersion);

      Family family = community.findTheFamily(familyIdVersionKey);
      if (family == null) {
        throw new CommunityManagerException(familyId + " is NOT FOUND");
      }

      beforeUpdateFamily(
          userContext,
          family,
          communityId,
          familyId,
          familyVersion,
          property,
          newValueExpr,
          tokensExpr);
      family.changeProperty(property, newValueExpr);

      community = saveCommunity(userContext, community, tokens().withFamilyList().done());
      familyManagerOf(userContext).onUpdated(userContext, family, this, "updateFamily");
      return present(userContext, community, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateFamily(
      ModelUserContext userContext,
      Family existed,
      String communityId,
      String familyId,
      int familyVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(ModelUserContext userContext, Community newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(ModelUserContext ctx) throws Exception {
    communityDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   Community newCommunity = this.createCommunity(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newCommunity
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
    key.put(UserApp.APP_TYPE_PROPERTY, Community.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(ModelUserContext userContext, SmartList<Community> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(ModelUserContext userContext, String communityId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    Community merchantObj = (Community) this.view(userContext, communityId);
    String merchantObjId = communityId;
    String linkToUrl = "communityManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "社区" + "详情";
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
        MapUtil.put("id", "3-address")
            .put("fieldName", "address")
            .put("label", "地址")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("address", merchantObj.getAddress());

    // 处理 sectionList

    // 处理Section：familyListSection
    Map familyListSection =
        ListofUtils.buildSection(
            "familyListSection",
            "家庭列表",
            null,
            "",
            "__no_group",
            "familyManager/listByCommunity/" + merchantObjId + "/",
            "auto");
    sections.add(familyListSection);

    result.put("familyListSection", ListofUtils.toShortList(merchantObj.getFamilyList(), "family"));

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
