
package com.doublechaintech.model.quicklink;















import com.doublechaintech.model.*;import com.doublechaintech.model.BaseViewPage;import com.doublechaintech.model.ModelUserContextImpl;import com.doublechaintech.model.iamservice.*;import com.doublechaintech.model.secuser.SecUser;import com.doublechaintech.model.services.IamService;import com.doublechaintech.model.tree.*;import com.doublechaintech.model.treenode.*;import com.doublechaintech.model.userapp.CandidateUserApp;import com.doublechaintech.model.userapp.UserApp;import com.doublechaintech.model.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.model.search.Searcher;


public class QuickLinkManagerImpl extends CustomModelCheckerManager implements QuickLinkManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "QuickLink";
	@Override
	public QuickLinkDAO daoOf(ModelUserContext userContext) {
		return quickLinkDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws QuickLinkManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new QuickLinkManagerException(message);

	}



 	protected QuickLink saveQuickLink(ModelUserContext userContext, QuickLink quickLink, String [] tokensExpr) throws Exception{
 		//return getQuickLinkDAO().save(quickLink, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveQuickLink(userContext, quickLink, tokens);
 	}

 	protected QuickLink saveQuickLinkDetail(ModelUserContext userContext, QuickLink quickLink) throws Exception{


 		return saveQuickLink(userContext, quickLink, allTokens());
 	}

 	public QuickLink loadQuickLink(ModelUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);

		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}


 	 public QuickLink searchQuickLink(ModelUserContext userContext, String quickLinkId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);

		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,quickLink, tokens);
 	}



 	protected QuickLink present(ModelUserContext userContext, QuickLink quickLink, Map<String, Object> tokens) throws Exception {


		addActions(userContext,quickLink,tokens);


		QuickLink  quickLinkToPresent = quickLinkDaoOf(userContext).present(quickLink, tokens);

		List<BaseEntity> entityListToNaming = quickLinkToPresent.collectReferencesFromLists();
		quickLinkDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,quickLink,tokens);

		return  quickLinkToPresent;


	}



 	public QuickLink loadQuickLinkDetail(ModelUserContext userContext, String quickLinkId) throws Exception{
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, allTokens());
 		return present(userContext,quickLink, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{

        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((ModelUserContext)userContext,userApp.getAppId());

    }




 	public Object view(ModelUserContext userContext, String quickLinkId) throws Exception{
 		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, viewTokens());
 		markVisited(userContext, quickLink);
 		return present(userContext,quickLink, viewTokens());

	 }
	 public Object summaryView(ModelUserContext userContext, String quickLinkId) throws Exception{
		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, viewTokens());
		quickLink.summarySuffix();
		markVisited(userContext, quickLink);
 		return present(userContext,quickLink, summaryTokens());

	}
	 public Object analyze(ModelUserContext userContext, String quickLinkId) throws Exception{
		QuickLink quickLink = loadQuickLink( userContext, quickLinkId, analyzeTokens());
		markVisited(userContext, quickLink);
		return present(userContext,quickLink, analyzeTokens());

	}
 	protected QuickLink saveQuickLink(ModelUserContext userContext, QuickLink quickLink, Map<String,Object>tokens) throws Exception{
 	
 		return quickLinkDaoOf(userContext).save(quickLink, tokens);
 	}
 	protected QuickLink loadQuickLink(ModelUserContext userContext, String quickLinkId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);

		checkerOf(userContext).throwExceptionIfHasErrors( QuickLinkManagerException.class);



 		return quickLinkDaoOf(userContext).load(quickLinkId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(ModelUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){
		super.addActions(userContext, quickLink, tokens);








	}// end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext, QuickLink quickLink, Map<String, Object> tokens){








  @Override
  public List<QuickLink> searchQuickLinkList(ModelUserContext ctx, QuickLinkRequest pRequest){
      pRequest.setUserContext(ctx);
      List<QuickLink> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public QuickLink searchQuickLink(ModelUserContext ctx, QuickLinkRequest pRequest){
    pRequest.limit(0, 1);
    List<QuickLink> list = searchQuickLinkList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public QuickLink createQuickLink(ModelUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception
	{





		checkerOf(userContext).checkNameOfQuickLink(name);
		checkerOf(userContext).checkIconOfQuickLink(icon);
		checkerOf(userContext).checkImagePathOfQuickLink(imagePath);
		checkerOf(userContext).checkLinkTargetOfQuickLink(linkTarget);


		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);



		QuickLink quickLink=createNewQuickLink();	

		quickLink.setName(name);
		quickLink.setIcon(icon);
		quickLink.setImagePath(imagePath);
		quickLink.setLinkTarget(linkTarget);
		quickLink.setCreateTime(userContext.now());
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		quickLink.setApp(app);
		
		

		quickLink = saveQuickLink(userContext, quickLink, emptyOptions());
		
		onNewInstanceCreated(userContext, quickLink);
		return quickLink;


	}
	protected QuickLink createNewQuickLink()
	{

		return new QuickLink();
	}

	protected void checkParamsForUpdatingQuickLink(ModelUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
		checkerOf(userContext).checkVersionOfQuickLink( quickLinkVersion);


		if(QuickLink.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfQuickLink(parseString(newValueExpr));
		

		}
		if(QuickLink.ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIconOfQuickLink(parseString(newValueExpr));
		

		}
		if(QuickLink.IMAGE_PATH_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImagePathOfQuickLink(parseString(newValueExpr));
		

		}
		if(QuickLink.LINK_TARGET_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkTargetOfQuickLink(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);



	}



	public QuickLink clone(ModelUserContext userContext, String fromQuickLinkId) throws Exception{

		return quickLinkDaoOf(userContext).clone(fromQuickLinkId, this.allTokens());
	}

	public QuickLink internalSaveQuickLink(ModelUserContext userContext, QuickLink quickLink) throws Exception
	{
		return internalSaveQuickLink(userContext, quickLink, allTokens());

	}
	public QuickLink internalSaveQuickLink(ModelUserContext userContext, QuickLink quickLink, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);


		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			if (quickLink.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixQuickLink(quickLink);
			quickLink = saveQuickLink(userContext, quickLink, options);
			return quickLink;

		}

	}

	public QuickLink updateQuickLink(ModelUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);



		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.
			
			quickLink.changeProperty(property, newValueExpr);
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}

	public QuickLink updateQuickLinkProperty(ModelUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingQuickLink(userContext, quickLinkId, quickLinkVersion, property, newValueExpr, tokensExpr);

		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		if(quickLink.getVersion() != quickLinkVersion){
			String message = "The target version("+quickLink.getVersion()+") is not equals to version("+quickLinkVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to QuickLink.

			quickLink.changeProperty(property, newValueExpr);
			
			quickLink = saveQuickLink(userContext, quickLink, tokens().done());
			return present(userContext,quickLink, mergedAllTokens(tokensExpr));
			//return saveQuickLink(userContext, quickLink, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected QuickLinkTokens tokens(){
		return QuickLinkTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return QuickLinkTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return QuickLinkTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(ModelUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfQuickLink(quickLinkId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(QuickLinkManagerException.class);

 	}
 	public QuickLink transferToAnotherApp(ModelUserContext userContext, String quickLinkId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, quickLinkId,anotherAppId);
 
		QuickLink quickLink = loadQuickLink(userContext, quickLinkId, allTokens());
		synchronized(quickLink){
			//will be good when the quickLink loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());
			quickLink.updateApp(app);
			
			quickLink = saveQuickLink(userContext, quickLink, emptyOptions());

			return present(userContext,quickLink, allTokens());

		}

 	}

	


	public CandidateUserApp requestCandidateApp(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForQuickLink(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected UserApp loadUserApp(ModelUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{
    
 		return userAppDaoOf(userContext).load(newAppId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------



	public QuickLink forgetByAll(ModelUserContext userContext, String quickLinkId, int quickLinkVersion) throws Exception {
		return forgetByAllInternal(userContext, quickLinkId, quickLinkVersion);
	}
	protected QuickLink forgetByAllInternal(ModelUserContext userContext,
			String quickLinkId, int quickLinkVersion) throws Exception{

		return quickLinkDaoOf(userContext).disconnectFromAll(quickLinkId, quickLinkVersion);
	}




	public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new QuickLinkManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}








	public void onNewInstanceCreated(ModelUserContext userContext, QuickLink newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(ModelUserContext ctx) throws Exception{
    quickLinkDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(ModelUserContextImpl userContext) {
    return this;
  }

	public void onAuthenticationFailed(ModelUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(ModelUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   QuickLink newQuickLink = this.createQuickLink(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newQuickLink
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(ModelUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, QuickLink.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(ModelUserContext userContext,SmartList<QuickLink> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<UserApp> appList = ModelBaseUtils.collectReferencedObjectWithType(userContext, list, UserApp.class);
		userContext.getDAOGroup().enhanceList(appList, UserApp.class);


    }
	
	public Object listByApp(ModelUserContext userContext,String appId) throws Exception {
		return listPageByApp(userContext, appId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByApp(ModelUserContext userContext,String appId, int start, int count) throws Exception {
		SmartList<QuickLink> list = quickLinkDaoOf(userContext).findQuickLinkByApp(appId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		ModelCommonListOfViewPage page = new ModelCommonListOfViewPage();
		page.setClassOfList(QuickLink.class);
		page.setContainerObject(UserApp.withId(appId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("快速链接列表");
		page.setRequestName("listByApp");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByApp/%s/",  getBeanName(), appId)));

		page.assemblerContent(userContext, "listByApp");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(ModelUserContext userContext, String quickLinkId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		QuickLink merchantObj = (QuickLink) this.view(userContext, quickLinkId);
    String merchantObjId = quickLinkId;
    String linkToUrl =	"quickLinkManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "快速链接"+"详情";
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
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-icon")
				    .put("fieldName", "icon")
				    .put("label", "图标")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("icon", merchantObj.getIcon());

		propList.add(
				MapUtil.put("id", "4-imagePath")
				    .put("fieldName", "imagePath")
				    .put("label", "图片路径")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("imagePath", merchantObj.getImagePath());

		propList.add(
				MapUtil.put("id", "5-linkTarget")
				    .put("fieldName", "linkTarget")
				    .put("label", "链接的目标")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("linkTarget", merchantObj.getLinkTarget());

		propList.add(
				MapUtil.put("id", "6-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

		propList.add(
				MapUtil.put("id", "7-app")
				    .put("fieldName", "app")
				    .put("label", "应用程序")
				    .put("type", "auto")
				    .put("linkToUrl", "userAppManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"app_icon\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("app", merchantObj.getApp());

		//处理 sectionList

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

  










}




