
package com.doublechaintech.model.loginhistory;















import com.doublechaintech.model.*;import com.doublechaintech.model.BaseViewPage;import com.doublechaintech.model.ModelUserContextImpl;import com.doublechaintech.model.iamservice.*;import com.doublechaintech.model.secuser.CandidateSecUser;import com.doublechaintech.model.secuser.SecUser;import com.doublechaintech.model.services.IamService;import com.doublechaintech.model.tree.*;import com.doublechaintech.model.treenode.*;import com.doublechaintech.model.userapp.UserApp;import com.doublechaintech.model.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.model.search.Searcher;


public class LoginHistoryManagerImpl extends CustomModelCheckerManager implements LoginHistoryManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "LoginHistory";
	@Override
	public LoginHistoryDAO daoOf(ModelUserContext userContext) {
		return loginHistoryDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws LoginHistoryManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LoginHistoryManagerException(message);

	}



 	protected LoginHistory saveLoginHistory(ModelUserContext userContext, LoginHistory loginHistory, String [] tokensExpr) throws Exception{
 		//return getLoginHistoryDAO().save(loginHistory, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveLoginHistory(userContext, loginHistory, tokens);
 	}

 	protected LoginHistory saveLoginHistoryDetail(ModelUserContext userContext, LoginHistory loginHistory) throws Exception{


 		return saveLoginHistory(userContext, loginHistory, allTokens());
 	}

 	public LoginHistory loadLoginHistory(ModelUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);

		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}


 	 public LoginHistory searchLoginHistory(ModelUserContext userContext, String loginHistoryId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);

		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}



 	protected LoginHistory present(ModelUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens) throws Exception {


		addActions(userContext,loginHistory,tokens);


		LoginHistory  loginHistoryToPresent = loginHistoryDaoOf(userContext).present(loginHistory, tokens);

		List<BaseEntity> entityListToNaming = loginHistoryToPresent.collectReferencesFromLists();
		loginHistoryDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,loginHistory,tokens);

		return  loginHistoryToPresent;


	}



 	public LoginHistory loadLoginHistoryDetail(ModelUserContext userContext, String loginHistoryId) throws Exception{
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, allTokens());
 		return present(userContext,loginHistory, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{

        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((ModelUserContext)userContext,userApp.getAppId());

    }




 	public Object view(ModelUserContext userContext, String loginHistoryId) throws Exception{
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, viewTokens());
 		markVisited(userContext, loginHistory);
 		return present(userContext,loginHistory, viewTokens());

	 }
	 public Object summaryView(ModelUserContext userContext, String loginHistoryId) throws Exception{
		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, viewTokens());
		loginHistory.summarySuffix();
		markVisited(userContext, loginHistory);
 		return present(userContext,loginHistory, summaryTokens());

	}
	 public Object analyze(ModelUserContext userContext, String loginHistoryId) throws Exception{
		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, analyzeTokens());
		markVisited(userContext, loginHistory);
		return present(userContext,loginHistory, analyzeTokens());

	}
 	protected LoginHistory saveLoginHistory(ModelUserContext userContext, LoginHistory loginHistory, Map<String,Object>tokens) throws Exception{
 	
 		return loginHistoryDaoOf(userContext).save(loginHistory, tokens);
 	}
 	protected LoginHistory loadLoginHistory(ModelUserContext userContext, String loginHistoryId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);

		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);



 		return loginHistoryDaoOf(userContext).load(loginHistoryId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(ModelUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
		super.addActions(userContext, loginHistory, tokens);








	}// end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){








  @Override
  public List<LoginHistory> searchLoginHistoryList(ModelUserContext ctx, LoginHistoryRequest pRequest){
      pRequest.setUserContext(ctx);
      List<LoginHistory> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public LoginHistory searchLoginHistory(ModelUserContext ctx, LoginHistoryRequest pRequest){
    pRequest.limit(0, 1);
    List<LoginHistory> list = searchLoginHistoryList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public LoginHistory createLoginHistory(ModelUserContext userContext, String fromIp,String description,String secUserId) throws Exception
	{





		checkerOf(userContext).checkFromIpOfLoginHistory(fromIp);
		checkerOf(userContext).checkDescriptionOfLoginHistory(description);


		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);



		LoginHistory loginHistory=createNewLoginHistory();	

		loginHistory.setLoginTime(userContext.now());
		loginHistory.setFromIp(fromIp);
		loginHistory.setDescription(description);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		loginHistory.setSecUser(secUser);
		
		

		loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
		
		onNewInstanceCreated(userContext, loginHistory);
		return loginHistory;


	}
	protected LoginHistory createNewLoginHistory()
	{

		return new LoginHistory();
	}

	protected void checkParamsForUpdatingLoginHistory(ModelUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory( loginHistoryVersion);


		if(LoginHistory.FROM_IP_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromIpOfLoginHistory(parseString(newValueExpr));
		

		}
		if(LoginHistory.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLoginHistory(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);



	}



	public LoginHistory clone(ModelUserContext userContext, String fromLoginHistoryId) throws Exception{

		return loginHistoryDaoOf(userContext).clone(fromLoginHistoryId, this.allTokens());
	}

	public LoginHistory internalSaveLoginHistory(ModelUserContext userContext, LoginHistory loginHistory) throws Exception
	{
		return internalSaveLoginHistory(userContext, loginHistory, allTokens());

	}
	public LoginHistory internalSaveLoginHistory(ModelUserContext userContext, LoginHistory loginHistory, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);


		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			if (loginHistory.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixLoginHistory(loginHistory);
			loginHistory = saveLoginHistory(userContext, loginHistory, options);
			return loginHistory;

		}

	}

	public LoginHistory updateLoginHistory(ModelUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);



		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			loginHistory.changeProperty(property, newValueExpr);
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}

	public LoginHistory updateLoginHistoryProperty(ModelUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);

		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.

			loginHistory.changeProperty(property, newValueExpr);
			
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LoginHistoryTokens tokens(){
		return LoginHistoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LoginHistoryTokens.all();
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
		return LoginHistoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(ModelUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}
 	public LoginHistory transferToAnotherSecUser(ModelUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, loginHistoryId,anotherSecUserId);
 
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());
			loginHistory.updateSecUser(secUser);
			
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(ModelUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);

 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}

 	public LoginHistory transferToAnotherSecUserWithLogin(ModelUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, loginHistoryId,anotherLogin);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			loginHistory.updateSecUser(secUser);
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(ModelUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);

 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}

 	public LoginHistory transferToAnotherSecUserWithEmail(ModelUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, loginHistoryId,anotherEmail);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			loginHistory.updateSecUser(secUser);
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(ModelUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);

 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);

 	}

 	public LoginHistory transferToAnotherSecUserWithMobile(ModelUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, loginHistoryId,anotherMobile);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			loginHistory.updateSecUser(secUser);
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());

			return present(userContext,loginHistory, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForLoginHistory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SecUser loadSecUser(ModelUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{
    
 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	  
 	}
 	
 	protected SecUser loadSecUserWithLogin(ModelUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(ModelUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(ModelUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------



	public LoginHistory forgetByAll(ModelUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		return forgetByAllInternal(userContext, loginHistoryId, loginHistoryVersion);
	}
	protected LoginHistory forgetByAllInternal(ModelUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{

		return loginHistoryDaoOf(userContext).disconnectFromAll(loginHistoryId, loginHistoryVersion);
	}




	public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LoginHistoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}








	public void onNewInstanceCreated(ModelUserContext userContext, LoginHistory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(ModelUserContext ctx) throws Exception{
    loginHistoryDaoOf(ctx).loadAllAsStream().forEach(
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
		//   LoginHistory newLoginHistory = this.createLoginHistory(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLoginHistory
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
    key.put(UserApp.APP_TYPE_PROPERTY, LoginHistory.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(ModelUserContext userContext,SmartList<LoginHistory> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SecUser> secUserList = ModelBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listBySecUser(ModelUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(ModelUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<LoginHistory> list = loginHistoryDaoOf(userContext).findLoginHistoryBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		ModelCommonListOfViewPage page = new ModelCommonListOfViewPage();
		page.setClassOfList(LoginHistory.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("登录历史列表");
		page.setRequestName("listBySecUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/",  getBeanName(), secUserId)));

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
 	public Object wxappview(ModelUserContext userContext, String loginHistoryId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		LoginHistory merchantObj = (LoginHistory) this.view(userContext, loginHistoryId);
    String merchantObjId = loginHistoryId;
    String linkToUrl =	"loginHistoryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "登录历史"+"详情";
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
				MapUtil.put("id", "2-loginTime")
				    .put("fieldName", "loginTime")
				    .put("label", "登录时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("loginTime", merchantObj.getLoginTime());

		propList.add(
				MapUtil.put("id", "3-fromIp")
				    .put("fieldName", "fromIp")
				    .put("label", "来自IP")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("fromIp", merchantObj.getFromIp());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "5-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "安全用户")
				    .put("type", "auto")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

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




