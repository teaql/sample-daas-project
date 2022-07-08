
package com.doublechaintech.model.userdomain;















import com.doublechaintech.model.*;import com.doublechaintech.model.BaseViewPage;import com.doublechaintech.model.ModelUserContextImpl;import com.doublechaintech.model.iamservice.*;import com.doublechaintech.model.publickeytype.PublicKeyType;import com.doublechaintech.model.secuser.SecUser;import com.doublechaintech.model.services.IamService;import com.doublechaintech.model.tree.*;import com.doublechaintech.model.treenode.*;import com.doublechaintech.model.userallowlist.UserAllowList;import com.doublechaintech.model.userapp.UserApp;import com.doublechaintech.model.userdomain.UserDomain;import com.doublechaintech.model.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.model.search.Searcher;


public class UserDomainManagerImpl extends CustomModelCheckerManager implements UserDomainManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "UserDomain";
	@Override
	public UserDomainDAO daoOf(ModelUserContext userContext) {
		return userDomainDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws UserDomainManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new UserDomainManagerException(message);

	}



 	protected UserDomain saveUserDomain(ModelUserContext userContext, UserDomain userDomain, String [] tokensExpr) throws Exception{
 		//return getUserDomainDAO().save(userDomain, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveUserDomain(userContext, userDomain, tokens);
 	}

 	protected UserDomain saveUserDomainDetail(ModelUserContext userContext, UserDomain userDomain) throws Exception{


 		return saveUserDomain(userContext, userDomain, allTokens());
 	}

 	public UserDomain loadUserDomain(ModelUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfUserDomain(userDomainId);

		checkerOf(userContext).throwExceptionIfHasErrors( UserDomainManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userDomain, tokens);
 	}


 	 public UserDomain searchUserDomain(ModelUserContext userContext, String userDomainId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfUserDomain(userDomainId);

		checkerOf(userContext).throwExceptionIfHasErrors( UserDomainManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userDomain, tokens);
 	}



 	protected UserDomain present(ModelUserContext userContext, UserDomain userDomain, Map<String, Object> tokens) throws Exception {


		addActions(userContext,userDomain,tokens);


		UserDomain  userDomainToPresent = userDomainDaoOf(userContext).present(userDomain, tokens);

		List<BaseEntity> entityListToNaming = userDomainToPresent.collectReferencesFromLists();
		userDomainDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,userDomain,tokens);

		return  userDomainToPresent;


	}



 	public UserDomain loadUserDomainDetail(ModelUserContext userContext, String userDomainId) throws Exception{
 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, allTokens());
 		return present(userContext,userDomain, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{

        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((ModelUserContext)userContext,userApp.getAppId());

    }




 	public Object view(ModelUserContext userContext, String userDomainId) throws Exception{
 		UserDomain userDomain = loadUserDomain( userContext, userDomainId, viewTokens());
 		markVisited(userContext, userDomain);
 		return present(userContext,userDomain, viewTokens());

	 }
	 public Object summaryView(ModelUserContext userContext, String userDomainId) throws Exception{
		UserDomain userDomain = loadUserDomain( userContext, userDomainId, viewTokens());
		userDomain.summarySuffix();
		markVisited(userContext, userDomain);
 		return present(userContext,userDomain, summaryTokens());

	}
	 public Object analyze(ModelUserContext userContext, String userDomainId) throws Exception{
		UserDomain userDomain = loadUserDomain( userContext, userDomainId, analyzeTokens());
		markVisited(userContext, userDomain);
		return present(userContext,userDomain, analyzeTokens());

	}
 	protected UserDomain saveUserDomain(ModelUserContext userContext, UserDomain userDomain, Map<String,Object>tokens) throws Exception{
 	
 		return userDomainDaoOf(userContext).save(userDomain, tokens);
 	}
 	protected UserDomain loadUserDomain(ModelUserContext userContext, String userDomainId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfUserDomain(userDomainId);

		checkerOf(userContext).throwExceptionIfHasErrors( UserDomainManagerException.class);



 		return userDomainDaoOf(userContext).load(userDomainId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(ModelUserContext userContext, UserDomain userDomain, Map<String, Object> tokens){
		super.addActions(userContext, userDomain, tokens);








	}// end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext, UserDomain userDomain, Map<String, Object> tokens){








  @Override
  public List<UserDomain> searchUserDomainList(ModelUserContext ctx, UserDomainRequest pRequest){
      pRequest.setUserContext(ctx);
      List<UserDomain> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public UserDomain searchUserDomain(ModelUserContext ctx, UserDomainRequest pRequest){
    pRequest.limit(0, 1);
    List<UserDomain> list = searchUserDomainList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public UserDomain createUserDomain(ModelUserContext userContext, String name) throws Exception
	{





		checkerOf(userContext).checkNameOfUserDomain(name);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);



		UserDomain userDomain=createNewUserDomain();	

		userDomain.setName(name);

		userDomain = saveUserDomain(userContext, userDomain, emptyOptions());
		
		onNewInstanceCreated(userContext, userDomain);
		return userDomain;


	}
	protected UserDomain createNewUserDomain()
	{

		return new UserDomain();
	}

	protected void checkParamsForUpdatingUserDomain(ModelUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkVersionOfUserDomain( userDomainVersion);


		if(UserDomain.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfUserDomain(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);



	}



	public UserDomain clone(ModelUserContext userContext, String fromUserDomainId) throws Exception{

		return userDomainDaoOf(userContext).clone(fromUserDomainId, this.allTokens());
	}

	public UserDomain internalSaveUserDomain(ModelUserContext userContext, UserDomain userDomain) throws Exception
	{
		return internalSaveUserDomain(userContext, userDomain, allTokens());

	}
	public UserDomain internalSaveUserDomain(ModelUserContext userContext, UserDomain userDomain, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingUserDomain(userContext, userDomainId, userDomainVersion, property, newValueExpr, tokensExpr);


		synchronized(userDomain){
			//will be good when the userDomain loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserDomain.
			if (userDomain.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixUserDomain(userDomain);
			userDomain = saveUserDomain(userContext, userDomain, options);
			return userDomain;

		}

	}

	public UserDomain updateUserDomain(ModelUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserDomain(userContext, userDomainId, userDomainVersion, property, newValueExpr, tokensExpr);



		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		if(userDomain.getVersion() != userDomainVersion){
			String message = "The target version("+userDomain.getVersion()+") is not equals to version("+userDomainVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userDomain){
			//will be good when the userDomain loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserDomain.
			
			userDomain.changeProperty(property, newValueExpr);
			userDomain = saveUserDomain(userContext, userDomain, tokens().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
			//return saveUserDomain(userContext, userDomain, tokens().done());
		}

	}

	public UserDomain updateUserDomainProperty(ModelUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserDomain(userContext, userDomainId, userDomainVersion, property, newValueExpr, tokensExpr);

		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		if(userDomain.getVersion() != userDomainVersion){
			String message = "The target version("+userDomain.getVersion()+") is not equals to version("+userDomainVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userDomain){
			//will be good when the userDomain loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserDomain.

			userDomain.changeProperty(property, newValueExpr);
			
			userDomain = saveUserDomain(userContext, userDomain, tokens().done());
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
			//return saveUserDomain(userContext, userDomain, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected UserDomainTokens tokens(){
		return UserDomainTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserDomainTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserAllowListListWith(UserAllowList.ID_PROPERTY,sortDesc())
		.sortSecUserListWith(SecUser.ID_PROPERTY,sortDesc())
		.sortPublicKeyTypeListWith(PublicKeyType.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserDomainTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------



	public UserDomain forgetByAll(ModelUserContext userContext, String userDomainId, int userDomainVersion) throws Exception {
		return forgetByAllInternal(userContext, userDomainId, userDomainVersion);
	}
	protected UserDomain forgetByAllInternal(ModelUserContext userContext,
			String userDomainId, int userDomainVersion) throws Exception{

		return userDomainDaoOf(userContext).disconnectFromAll(userDomainId, userDomainVersion);
	}




	public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserDomainManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}








	protected void checkParamsForAddingUserAllowList(ModelUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserDomain(userDomainId);


		checkerOf(userContext).checkUserIdentityOfUserAllowList(userIdentity);

		checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList(userSpecialFunctions);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);



	}
	public  UserDomain addUserAllowList(ModelUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingUserAllowList(userContext,userDomainId,userIdentity, userSpecialFunctions,tokensExpr);

		UserAllowList userAllowList = createUserAllowList(userContext,userIdentity, userSpecialFunctions);

		UserDomain userDomain = loadUserDomain(userContext, userDomainId, emptyOptions());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.addUserAllowList( userAllowList );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withUserAllowListList().done());
			
			userAllowListManagerOf(userContext).onNewInstanceCreated(userContext, userAllowList);
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAllowListProperties(ModelUserContext userContext, String userDomainId,String id,String userIdentity,String userSpecialFunctions,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkIdOfUserAllowList(id);

		checkerOf(userContext).checkUserIdentityOfUserAllowList( userIdentity);
		checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList( userSpecialFunctions);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain updateUserAllowListProperties(ModelUserContext userContext, String userDomainId, String id,String userIdentity,String userSpecialFunctions, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserAllowListProperties(userContext,userDomainId,id,userIdentity,userSpecialFunctions,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAllowListListList()
				.searchUserAllowListListWith(UserAllowList.ID_PROPERTY, tokens().is(), id).done();

		UserDomain userDomainToUpdate = loadUserDomain(userContext, userDomainId, options);

		if(userDomainToUpdate.getUserAllowListList().isEmpty()){
			throw new UserDomainManagerException("UserAllowList is NOT FOUND with id: '"+id+"'");
		}

		UserAllowList item = userDomainToUpdate.getUserAllowListList().first();
		beforeUpdateUserAllowListProperties(userContext,item, userDomainId,id,userIdentity,userSpecialFunctions,tokensExpr);
		item.updateUserIdentity( userIdentity );
		item.updateUserSpecialFunctions( userSpecialFunctions );


		//checkParamsForAddingUserAllowList(userContext,userDomainId,name, code, used,tokensExpr);
		UserDomain userDomain = saveUserDomain(userContext, userDomainToUpdate, tokens().withUserAllowListList().done());
		synchronized(userDomain){
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateUserAllowListProperties(ModelUserContext userContext, UserAllowList item, String userDomainId, String id,String userIdentity,String userSpecialFunctions, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected UserAllowList createUserAllowList(ModelUserContext userContext, String userIdentity, String userSpecialFunctions) throws Exception{

		UserAllowList userAllowList = new UserAllowList();
		
		
		userAllowList.setUserIdentity(userIdentity);		
		userAllowList.setUserSpecialFunctions(userSpecialFunctions);
	
		
		return userAllowList;


	}

	protected UserAllowList createIndexedUserAllowList(String id, int version){

		UserAllowList userAllowList = new UserAllowList();
		userAllowList.setId(id);
		userAllowList.setVersion(version);
		return userAllowList;

	}

	protected void checkParamsForRemovingUserAllowListList(ModelUserContext userContext, String userDomainId,
			String userAllowListIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		for(String userAllowListIdItem: userAllowListIds){
			checkerOf(userContext).checkIdOfUserAllowList(userAllowListIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);

	}
	public  UserDomain removeUserAllowListList(ModelUserContext userContext, String userDomainId,
			String userAllowListIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingUserAllowListList(userContext, userDomainId,  userAllowListIds, tokensExpr);


			UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
			synchronized(userDomain){
				//Will be good when the userDomain loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userDomainDaoOf(userContext).planToRemoveUserAllowListList(userDomain, userAllowListIds, allTokens());
				userDomain = saveUserDomain(userContext, userDomain, tokens().withUserAllowListList().done());
				deleteRelationListInGraph(userContext, userDomain.getUserAllowListList());
				return present(userContext,userDomain, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingUserAllowList(ModelUserContext userContext, String userDomainId,
		String userAllowListId, int userAllowListVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserDomain( userDomainId);
		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).checkVersionOfUserAllowList(userAllowListVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain removeUserAllowList(ModelUserContext userContext, String userDomainId,
		String userAllowListId, int userAllowListVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingUserAllowList(userContext,userDomainId, userAllowListId, userAllowListVersion,tokensExpr);

		UserAllowList userAllowList = createIndexedUserAllowList(userAllowListId, userAllowListVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.removeUserAllowList( userAllowList );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withUserAllowListList().done());
			deleteRelationInGraph(userContext, userAllowList);
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingUserAllowList(ModelUserContext userContext, String userDomainId,
		String userAllowListId, int userAllowListVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserDomain( userDomainId);
		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).checkVersionOfUserAllowList(userAllowListVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain copyUserAllowListFrom(ModelUserContext userContext, String userDomainId,
		String userAllowListId, int userAllowListVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingUserAllowList(userContext,userDomainId, userAllowListId, userAllowListVersion,tokensExpr);

		UserAllowList userAllowList = createIndexedUserAllowList(userAllowListId, userAllowListVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userDomain.copyUserAllowListFrom( userAllowList );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withUserAllowListList().done());
			
			userAllowListManagerOf(userContext).onNewInstanceCreated(userContext, (UserAllowList)userDomain.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingUserAllowList(ModelUserContext userContext, String userDomainId, String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
		checkerOf(userContext).checkVersionOfUserAllowList(userAllowListVersion);


		if(UserAllowList.USER_IDENTITY_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserIdentityOfUserAllowList(parseString(newValueExpr));
		}
		
		if(UserAllowList.USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}

	public  UserDomain updateUserAllowList(ModelUserContext userContext, String userDomainId, String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingUserAllowList(userContext, userDomainId, userAllowListId, userAllowListVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withUserAllowListList().searchUserAllowListListWith(UserAllowList.ID_PROPERTY, tokens().equals(), userAllowListId).done();



		UserDomain userDomain = loadUserDomain(userContext, userDomainId, loadTokens);

		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userDomain.removeUserAllowList( userAllowList );
			//make changes to AcceleraterAccount.
			UserAllowList userAllowListIdVersionKey = createIndexedUserAllowList(userAllowListId, userAllowListVersion);

			UserAllowList userAllowList = userDomain.findTheUserAllowList(userAllowListIdVersionKey);
			if(userAllowList == null){
				throw new UserDomainManagerException(userAllowListId+" is NOT FOUND" );
			}

			beforeUpdateUserAllowList(userContext, userAllowList, userDomainId, userAllowListId, userAllowListVersion, property, newValueExpr,  tokensExpr);
			userAllowList.changeProperty(property, newValueExpr);
			
			userDomain = saveUserDomain(userContext, userDomain, tokens().withUserAllowListList().done());
			userAllowListManagerOf(userContext).onUpdated(userContext, userAllowList, this, "updateUserAllowList");
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateUserAllowList(ModelUserContext userContext, UserAllowList existed, String userDomainId, String userAllowListId, int userAllowListVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingSecUser(ModelUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserDomain(userDomainId);


		checkerOf(userContext).checkLoginOfSecUser(login);

		checkerOf(userContext).checkMobileOfSecUser(mobile);

		checkerOf(userContext).checkEmailOfSecUser(email);

		checkerOf(userContext).checkPwdOfSecUser(pwd);

		checkerOf(userContext).checkWeixinOpenidOfSecUser(weixinOpenid);

		checkerOf(userContext).checkWeixinAppidOfSecUser(weixinAppid);

		checkerOf(userContext).checkAccessTokenOfSecUser(accessToken);

		checkerOf(userContext).checkVerificationCodeOfSecUser(verificationCode);

		checkerOf(userContext).checkVerificationCodeExpireOfSecUser(verificationCodeExpire);

		checkerOf(userContext).checkLastLoginTimeOfSecUser(lastLoginTime);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);



	}
	public  UserDomain addSecUser(ModelUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingSecUser(userContext,userDomainId,login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime,tokensExpr);

		SecUser secUser = createSecUser(userContext,login, mobile, email, pwd, weixinOpenid, weixinAppid, accessToken, verificationCode, verificationCodeExpire, lastLoginTime);

		UserDomain userDomain = loadUserDomain(userContext, userDomainId, emptyOptions());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.addSecUser( secUser );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			
			secUserManagerOf(userContext).onNewInstanceCreated(userContext, secUser);
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSecUserProperties(ModelUserContext userContext, String userDomainId,String id,String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkIdOfSecUser(id);

		checkerOf(userContext).checkLoginOfSecUser( login);
		checkerOf(userContext).checkMobileOfSecUser( mobile);
		checkerOf(userContext).checkEmailOfSecUser( email);
		checkerOf(userContext).checkPwdOfSecUser( pwd);
		checkerOf(userContext).checkWeixinOpenidOfSecUser( weixinOpenid);
		checkerOf(userContext).checkWeixinAppidOfSecUser( weixinAppid);
		checkerOf(userContext).checkAccessTokenOfSecUser( accessToken);
		checkerOf(userContext).checkVerificationCodeOfSecUser( verificationCode);
		checkerOf(userContext).checkVerificationCodeExpireOfSecUser( verificationCodeExpire);
		checkerOf(userContext).checkLastLoginTimeOfSecUser( lastLoginTime);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain updateSecUserProperties(ModelUserContext userContext, String userDomainId, String id,String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSecUserProperties(userContext,userDomainId,id,login,mobile,email,pwd,weixinOpenid,weixinAppid,accessToken,verificationCode,verificationCodeExpire,lastLoginTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSecUserListList()
				.searchSecUserListWith(SecUser.ID_PROPERTY, tokens().is(), id).done();

		UserDomain userDomainToUpdate = loadUserDomain(userContext, userDomainId, options);

		if(userDomainToUpdate.getSecUserList().isEmpty()){
			throw new UserDomainManagerException("SecUser is NOT FOUND with id: '"+id+"'");
		}

		SecUser item = userDomainToUpdate.getSecUserList().first();
		beforeUpdateSecUserProperties(userContext,item, userDomainId,id,login,mobile,email,pwd,weixinOpenid,weixinAppid,accessToken,verificationCode,verificationCodeExpire,lastLoginTime,tokensExpr);
		item.updateLogin( login );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updatePwd( pwd );
		item.updateWeixinOpenid( weixinOpenid );
		item.updateWeixinAppid( weixinAppid );
		item.updateAccessToken( accessToken );
		item.updateVerificationCode( verificationCode );
		item.updateVerificationCodeExpire( verificationCodeExpire );
		item.updateLastLoginTime( lastLoginTime );


		//checkParamsForAddingSecUser(userContext,userDomainId,name, code, used,tokensExpr);
		UserDomain userDomain = saveUserDomain(userContext, userDomainToUpdate, tokens().withSecUserList().done());
		synchronized(userDomain){
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateSecUserProperties(ModelUserContext userContext, SecUser item, String userDomainId, String id,String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected SecUser createSecUser(ModelUserContext userContext, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime) throws Exception{

		SecUser secUser = new SecUser();
		
		
		secUser.setLogin(login);		
		secUser.setMobile(mobile);		
		secUser.setEmail(email);		
		secUser.setClearTextOfPwd(pwd);		
		secUser.setWeixinOpenid(weixinOpenid);		
		secUser.setWeixinAppid(weixinAppid);		
		secUser.setAccessToken(accessToken);		
		secUser.setVerificationCode(verificationCode);		
		secUser.setVerificationCodeExpire(verificationCodeExpire);		
		secUser.setLastLoginTime(lastLoginTime);
	
		
		return secUser;


	}

	protected SecUser createIndexedSecUser(String id, int version){

		SecUser secUser = new SecUser();
		secUser.setId(id);
		secUser.setVersion(version);
		return secUser;

	}

	protected void checkParamsForRemovingSecUserList(ModelUserContext userContext, String userDomainId,
			String secUserIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		for(String secUserIdItem: secUserIds){
			checkerOf(userContext).checkIdOfSecUser(secUserIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);

	}
	public  UserDomain removeSecUserList(ModelUserContext userContext, String userDomainId,
			String secUserIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSecUserList(userContext, userDomainId,  secUserIds, tokensExpr);


			UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
			synchronized(userDomain){
				//Will be good when the userDomain loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userDomainDaoOf(userContext).planToRemoveSecUserList(userDomain, secUserIds, allTokens());
				userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
				deleteRelationListInGraph(userContext, userDomain.getSecUserList());
				return present(userContext,userDomain, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSecUser(ModelUserContext userContext, String userDomainId,
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserDomain( userDomainId);
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser(secUserVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain removeSecUser(ModelUserContext userContext, String userDomainId,
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSecUser(userContext,userDomainId, secUserId, secUserVersion,tokensExpr);

		SecUser secUser = createIndexedSecUser(secUserId, secUserVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.removeSecUser( secUser );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			deleteRelationInGraph(userContext, secUser);
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSecUser(ModelUserContext userContext, String userDomainId,
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserDomain( userDomainId);
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser(secUserVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain copySecUserFrom(ModelUserContext userContext, String userDomainId,
		String secUserId, int secUserVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSecUser(userContext,userDomainId, secUserId, secUserVersion,tokensExpr);

		SecUser secUser = createIndexedSecUser(secUserId, secUserVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userDomain.copySecUserFrom( secUser );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			
			secUserManagerOf(userContext).onNewInstanceCreated(userContext, (SecUser)userDomain.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSecUser(ModelUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser(secUserVersion);


		if(SecUser.LOGIN_PROPERTY.equals(property)){
			checkerOf(userContext).checkLoginOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.MOBILE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMobileOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.EMAIL_PROPERTY.equals(property)){
			checkerOf(userContext).checkEmailOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.PWD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPwdOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.WEIXIN_OPENID_PROPERTY.equals(property)){
			checkerOf(userContext).checkWeixinOpenidOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.WEIXIN_APPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkWeixinAppidOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.ACCESS_TOKEN_PROPERTY.equals(property)){
			checkerOf(userContext).checkAccessTokenOfSecUser(parseString(newValueExpr));
		}
		
		if(SecUser.VERIFICATION_CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkVerificationCodeOfSecUser(parseInt(newValueExpr));
		}
		
		if(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)){
			checkerOf(userContext).checkVerificationCodeExpireOfSecUser(parseTimestamp(newValueExpr));
		}
		
		if(SecUser.LAST_LOGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkLastLoginTimeOfSecUser(parseTimestamp(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}

	public  UserDomain updateSecUser(ModelUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSecUser(userContext, userDomainId, secUserId, secUserVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSecUserList().searchSecUserListWith(SecUser.ID_PROPERTY, tokens().equals(), secUserId).done();



		UserDomain userDomain = loadUserDomain(userContext, userDomainId, loadTokens);

		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userDomain.removeSecUser( secUser );
			//make changes to AcceleraterAccount.
			SecUser secUserIdVersionKey = createIndexedSecUser(secUserId, secUserVersion);

			SecUser secUser = userDomain.findTheSecUser(secUserIdVersionKey);
			if(secUser == null){
				throw new UserDomainManagerException(secUserId+" is NOT FOUND" );
			}

			beforeUpdateSecUser(userContext, secUser, userDomainId, secUserId, secUserVersion, property, newValueExpr,  tokensExpr);
			secUser.changeProperty(property, newValueExpr);
			
			userDomain = saveUserDomain(userContext, userDomain, tokens().withSecUserList().done());
			secUserManagerOf(userContext).onUpdated(userContext, secUser, this, "updateSecUser");
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateSecUser(ModelUserContext userContext, SecUser existed, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingPublicKeyType(ModelUserContext userContext, String userDomainId, String keyAlg, String signAlg,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUserDomain(userDomainId);


		checkerOf(userContext).checkKeyAlgOfPublicKeyType(keyAlg);

		checkerOf(userContext).checkSignAlgOfPublicKeyType(signAlg);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);



	}
	public  UserDomain addPublicKeyType(ModelUserContext userContext, String userDomainId, String keyAlg, String signAlg, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingPublicKeyType(userContext,userDomainId,keyAlg, signAlg,tokensExpr);

		PublicKeyType publicKeyType = createPublicKeyType(userContext,keyAlg, signAlg);

		UserDomain userDomain = loadUserDomain(userContext, userDomainId, emptyOptions());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.addPublicKeyType( publicKeyType );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withPublicKeyTypeList().done());
			
			publicKeyTypeManagerOf(userContext).onNewInstanceCreated(userContext, publicKeyType);
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPublicKeyTypeProperties(ModelUserContext userContext, String userDomainId,String id,String keyAlg,String signAlg,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkIdOfPublicKeyType(id);

		checkerOf(userContext).checkKeyAlgOfPublicKeyType( keyAlg);
		checkerOf(userContext).checkSignAlgOfPublicKeyType( signAlg);


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain updatePublicKeyTypeProperties(ModelUserContext userContext, String userDomainId, String id,String keyAlg,String signAlg, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPublicKeyTypeProperties(userContext,userDomainId,id,keyAlg,signAlg,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPublicKeyTypeListList()
				.searchPublicKeyTypeListWith(PublicKeyType.ID_PROPERTY, tokens().is(), id).done();

		UserDomain userDomainToUpdate = loadUserDomain(userContext, userDomainId, options);

		if(userDomainToUpdate.getPublicKeyTypeList().isEmpty()){
			throw new UserDomainManagerException("PublicKeyType is NOT FOUND with id: '"+id+"'");
		}

		PublicKeyType item = userDomainToUpdate.getPublicKeyTypeList().first();
		beforeUpdatePublicKeyTypeProperties(userContext,item, userDomainId,id,keyAlg,signAlg,tokensExpr);
		item.updateKeyAlg( keyAlg );
		item.updateSignAlg( signAlg );


		//checkParamsForAddingPublicKeyType(userContext,userDomainId,name, code, used,tokensExpr);
		UserDomain userDomain = saveUserDomain(userContext, userDomainToUpdate, tokens().withPublicKeyTypeList().done());
		synchronized(userDomain){
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdatePublicKeyTypeProperties(ModelUserContext userContext, PublicKeyType item, String userDomainId, String id,String keyAlg,String signAlg, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected PublicKeyType createPublicKeyType(ModelUserContext userContext, String keyAlg, String signAlg) throws Exception{

		PublicKeyType publicKeyType = new PublicKeyType();
		
		
		publicKeyType.setKeyAlg(keyAlg);		
		publicKeyType.setSignAlg(signAlg);
	
		
		return publicKeyType;


	}

	protected PublicKeyType createIndexedPublicKeyType(String id, int version){

		PublicKeyType publicKeyType = new PublicKeyType();
		publicKeyType.setId(id);
		publicKeyType.setVersion(version);
		return publicKeyType;

	}

	protected void checkParamsForRemovingPublicKeyTypeList(ModelUserContext userContext, String userDomainId,
			String publicKeyTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		for(String publicKeyTypeIdItem: publicKeyTypeIds){
			checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);

	}
	public  UserDomain removePublicKeyTypeList(ModelUserContext userContext, String userDomainId,
			String publicKeyTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPublicKeyTypeList(userContext, userDomainId,  publicKeyTypeIds, tokensExpr);


			UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
			synchronized(userDomain){
				//Will be good when the userDomain loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userDomainDaoOf(userContext).planToRemovePublicKeyTypeList(userDomain, publicKeyTypeIds, allTokens());
				userDomain = saveUserDomain(userContext, userDomain, tokens().withPublicKeyTypeList().done());
				deleteRelationListInGraph(userContext, userDomain.getPublicKeyTypeList());
				return present(userContext,userDomain, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPublicKeyType(ModelUserContext userContext, String userDomainId,
		String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserDomain( userDomainId);
		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).checkVersionOfPublicKeyType(publicKeyTypeVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain removePublicKeyType(ModelUserContext userContext, String userDomainId,
		String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPublicKeyType(userContext,userDomainId, publicKeyTypeId, publicKeyTypeVersion,tokensExpr);

		PublicKeyType publicKeyType = createIndexedPublicKeyType(publicKeyTypeId, publicKeyTypeVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userDomain.removePublicKeyType( publicKeyType );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withPublicKeyTypeList().done());
			deleteRelationInGraph(userContext, publicKeyType);
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPublicKeyType(ModelUserContext userContext, String userDomainId,
		String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUserDomain( userDomainId);
		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).checkVersionOfPublicKeyType(publicKeyTypeVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}
	public  UserDomain copyPublicKeyTypeFrom(ModelUserContext userContext, String userDomainId,
		String publicKeyTypeId, int publicKeyTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPublicKeyType(userContext,userDomainId, publicKeyTypeId, publicKeyTypeVersion,tokensExpr);

		PublicKeyType publicKeyType = createIndexedPublicKeyType(publicKeyTypeId, publicKeyTypeVersion);
		UserDomain userDomain = loadUserDomain(userContext, userDomainId, allTokens());
		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			userDomain.copyPublicKeyTypeFrom( publicKeyType );
			userDomain = saveUserDomain(userContext, userDomain, tokens().withPublicKeyTypeList().done());
			
			publicKeyTypeManagerOf(userContext).onNewInstanceCreated(userContext, (PublicKeyType)userDomain.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPublicKeyType(ModelUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfUserDomain(userDomainId);
		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).checkVersionOfPublicKeyType(publicKeyTypeVersion);


		if(PublicKeyType.KEY_ALG_PROPERTY.equals(property)){
			checkerOf(userContext).checkKeyAlgOfPublicKeyType(parseString(newValueExpr));
		}
		
		if(PublicKeyType.SIGN_ALG_PROPERTY.equals(property)){
			checkerOf(userContext).checkSignAlgOfPublicKeyType(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(UserDomainManagerException.class);


	}

	public  UserDomain updatePublicKeyType(ModelUserContext userContext, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPublicKeyType(userContext, userDomainId, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPublicKeyTypeList().searchPublicKeyTypeListWith(PublicKeyType.ID_PROPERTY, tokens().equals(), publicKeyTypeId).done();



		UserDomain userDomain = loadUserDomain(userContext, userDomainId, loadTokens);

		synchronized(userDomain){
			//Will be good when the userDomain loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userDomain.removePublicKeyType( publicKeyType );
			//make changes to AcceleraterAccount.
			PublicKeyType publicKeyTypeIdVersionKey = createIndexedPublicKeyType(publicKeyTypeId, publicKeyTypeVersion);

			PublicKeyType publicKeyType = userDomain.findThePublicKeyType(publicKeyTypeIdVersionKey);
			if(publicKeyType == null){
				throw new UserDomainManagerException(publicKeyTypeId+" is NOT FOUND" );
			}

			beforeUpdatePublicKeyType(userContext, publicKeyType, userDomainId, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr,  tokensExpr);
			publicKeyType.changeProperty(property, newValueExpr);
			
			userDomain = saveUserDomain(userContext, userDomain, tokens().withPublicKeyTypeList().done());
			publicKeyTypeManagerOf(userContext).onUpdated(userContext, publicKeyType, this, "updatePublicKeyType");
			return present(userContext,userDomain, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdatePublicKeyType(ModelUserContext userContext, PublicKeyType existed, String userDomainId, String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(ModelUserContext userContext, UserDomain newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(ModelUserContext ctx) throws Exception{
    userDomainDaoOf(ctx).loadAllAsStream().forEach(
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
		//   UserDomain newUserDomain = this.createUserDomain(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newUserDomain
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
    key.put(UserApp.APP_TYPE_PROPERTY, UserDomain.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(ModelUserContext userContext,SmartList<UserDomain> list) throws Exception {
    	if (list == null || list.isEmpty()){
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
 	public Object wxappview(ModelUserContext userContext, String userDomainId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		UserDomain merchantObj = (UserDomain) this.view(userContext, userDomainId);
    String merchantObjId = userDomainId;
    String linkToUrl =	"userDomainManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "用户域"+"详情";
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

		//处理 sectionList

		//处理Section：secUserListSection
		Map secUserListSection = ListofUtils.buildSection(
		    "secUserListSection",
		    "安全用户列表",
		    null,
		    "",
		    "__no_group",
		    "secUserManager/listByDomain/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(secUserListSection);

		result.put("secUserListSection", ListofUtils.toShortList(merchantObj.getSecUserList(), "secUser"));

		//处理Section：publicKeyTypeListSection
		Map publicKeyTypeListSection = ListofUtils.buildSection(
		    "publicKeyTypeListSection",
		    "公钥类型列表",
		    null,
		    "",
		    "__no_group",
		    "publicKeyTypeManager/listByDomain/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(publicKeyTypeListSection);

		result.put("publicKeyTypeListSection", ListofUtils.toShortList(merchantObj.getPublicKeyTypeList(), "publicKeyType"));

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




