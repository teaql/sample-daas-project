
package com.doublechaintech.model.family;















import com.doublechaintech.model.*;import com.doublechaintech.model.BaseViewPage;import com.doublechaintech.model.ModelUserContextImpl;import com.doublechaintech.model.community.CandidateCommunity;import com.doublechaintech.model.community.Community;import com.doublechaintech.model.family.Family;import com.doublechaintech.model.iamservice.*;import com.doublechaintech.model.kid.Kid;import com.doublechaintech.model.secuser.SecUser;import com.doublechaintech.model.services.IamService;import com.doublechaintech.model.tree.*;import com.doublechaintech.model.treenode.*;import com.doublechaintech.model.userapp.UserApp;import com.doublechaintech.model.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.model.search.Searcher;


public class FamilyManagerImpl extends CustomModelCheckerManager implements FamilyManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(ModelUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = FamilyTokens.start().withTokenFromListName(listName).done();
		Family  family = (Family) this.loadFamily(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = family.collectReferencesFromLists();
		familyDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, family, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new FamilyGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "Family";
	@Override
	public FamilyDAO daoOf(ModelUserContext userContext) {
		return familyDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws FamilyManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FamilyManagerException(message);

	}



 	protected Family saveFamily(ModelUserContext userContext, Family family, String [] tokensExpr) throws Exception{
 		//return getFamilyDAO().save(family, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveFamily(userContext, family, tokens);
 	}

 	protected Family saveFamilyDetail(ModelUserContext userContext, Family family) throws Exception{


 		return saveFamily(userContext, family, allTokens());
 	}

 	public Family loadFamily(ModelUserContext userContext, String familyId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfFamily(familyId);

		checkerOf(userContext).throwExceptionIfHasErrors( FamilyManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		Family family = loadFamily( userContext, familyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,family, tokens);
 	}


 	 public Family searchFamily(ModelUserContext userContext, String familyId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfFamily(familyId);

		checkerOf(userContext).throwExceptionIfHasErrors( FamilyManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		Family family = loadFamily( userContext, familyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,family, tokens);
 	}



 	protected Family present(ModelUserContext userContext, Family family, Map<String, Object> tokens) throws Exception {


		addActions(userContext,family,tokens);


		Family  familyToPresent = familyDaoOf(userContext).present(family, tokens);

		List<BaseEntity> entityListToNaming = familyToPresent.collectReferencesFromLists();
		familyDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,family,tokens);

		return  familyToPresent;


	}



 	public Family loadFamilyDetail(ModelUserContext userContext, String familyId) throws Exception{
 		Family family = loadFamily( userContext, familyId, allTokens());
 		return present(userContext,family, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{

        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((ModelUserContext)userContext,userApp.getAppId());

    }




 	public Object view(ModelUserContext userContext, String familyId) throws Exception{
 		Family family = loadFamily( userContext, familyId, viewTokens());
 		markVisited(userContext, family);
 		return present(userContext,family, viewTokens());

	 }
	 public Object summaryView(ModelUserContext userContext, String familyId) throws Exception{
		Family family = loadFamily( userContext, familyId, viewTokens());
		family.summarySuffix();
		markVisited(userContext, family);
 		return present(userContext,family, summaryTokens());

	}
	 public Object analyze(ModelUserContext userContext, String familyId) throws Exception{
		Family family = loadFamily( userContext, familyId, analyzeTokens());
		markVisited(userContext, family);
		return present(userContext,family, analyzeTokens());

	}
 	protected Family saveFamily(ModelUserContext userContext, Family family, Map<String,Object>tokens) throws Exception{
 	
 		return familyDaoOf(userContext).save(family, tokens);
 	}
 	protected Family loadFamily(ModelUserContext userContext, String familyId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfFamily(familyId);

		checkerOf(userContext).throwExceptionIfHasErrors( FamilyManagerException.class);



 		return familyDaoOf(userContext).load(familyId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(ModelUserContext userContext, Family family, Map<String, Object> tokens){
		super.addActions(userContext, family, tokens);








	}// end method of protected<T extends BaseEntity> void addActions(ModelUserContext userContext, Family family, Map<String, Object> tokens){








  @Override
  public List<Family> searchFamilyList(ModelUserContext ctx, FamilyRequest pRequest){
      pRequest.setUserContext(ctx);
      List<Family> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public Family searchFamily(ModelUserContext ctx, FamilyRequest pRequest){
    pRequest.limit(0, 1);
    List<Family> list = searchFamilyList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public Family createFamily(ModelUserContext userContext, String name,String communityId) throws Exception
	{





		checkerOf(userContext).checkNameOfFamily(name);


		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);



		Family family=createNewFamily();	

		family.setName(name);
			
		Community community = loadCommunity(userContext, communityId,emptyOptions());
		family.setCommunity(community);
		
		

		family = saveFamily(userContext, family, emptyOptions());
		
		onNewInstanceCreated(userContext, family);
		return family;


	}
	protected Family createNewFamily()
	{

		return new Family();
	}

	protected void checkParamsForUpdatingFamily(ModelUserContext userContext,String familyId, int familyVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfFamily(familyId);
		checkerOf(userContext).checkVersionOfFamily( familyVersion);


		if(Family.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfFamily(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);



	}



	public Family clone(ModelUserContext userContext, String fromFamilyId) throws Exception{

		return familyDaoOf(userContext).clone(fromFamilyId, this.allTokens());
	}

	public Family internalSaveFamily(ModelUserContext userContext, Family family) throws Exception
	{
		return internalSaveFamily(userContext, family, allTokens());

	}
	public Family internalSaveFamily(ModelUserContext userContext, Family family, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFamily(userContext, familyId, familyVersion, property, newValueExpr, tokensExpr);


		synchronized(family){
			//will be good when the family loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Family.
			if (family.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixFamily(family);
			family = saveFamily(userContext, family, options);
			return family;

		}

	}

	public Family updateFamily(ModelUserContext userContext,String familyId, int familyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFamily(userContext, familyId, familyVersion, property, newValueExpr, tokensExpr);



		Family family = loadFamily(userContext, familyId, allTokens());
		if(family.getVersion() != familyVersion){
			String message = "The target version("+family.getVersion()+") is not equals to version("+familyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(family){
			//will be good when the family loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Family.
			
			family.changeProperty(property, newValueExpr);
			family = saveFamily(userContext, family, tokens().done());
			return present(userContext,family, mergedAllTokens(tokensExpr));
			//return saveFamily(userContext, family, tokens().done());
		}

	}

	public Family updateFamilyProperty(ModelUserContext userContext,String familyId, int familyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFamily(userContext, familyId, familyVersion, property, newValueExpr, tokensExpr);

		Family family = loadFamily(userContext, familyId, allTokens());
		if(family.getVersion() != familyVersion){
			String message = "The target version("+family.getVersion()+") is not equals to version("+familyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(family){
			//will be good when the family loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Family.

			family.changeProperty(property, newValueExpr);
			
			family = saveFamily(userContext, family, tokens().done());
			return present(userContext,family, mergedAllTokens(tokensExpr));
			//return saveFamily(userContext, family, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FamilyTokens tokens(){
		return FamilyTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FamilyTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortKidListWith(Kid.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FamilyTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCommunity(ModelUserContext userContext, String familyId, String anotherCommunityId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFamily(familyId);
 		checkerOf(userContext).checkIdOfCommunity(anotherCommunityId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);

 	}
 	public Family transferToAnotherCommunity(ModelUserContext userContext, String familyId, String anotherCommunityId) throws Exception
 	{
 		checkParamsForTransferingAnotherCommunity(userContext, familyId,anotherCommunityId);
 
		Family family = loadFamily(userContext, familyId, allTokens());
		synchronized(family){
			//will be good when the family loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Community community = loadCommunity(userContext, anotherCommunityId, emptyOptions());
			family.updateCommunity(community);
			
			family = saveFamily(userContext, family, emptyOptions());

			return present(userContext,family, allTokens());

		}

 	}

	


	public CandidateCommunity requestCandidateCommunity(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCommunity result = new CandidateCommunity();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Community> candidateList = communityDaoOf(userContext).requestCandidateCommunityForFamily(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Community loadCommunity(ModelUserContext userContext, String newCommunityId, Map<String,Object> options) throws Exception
 	{
    
 		return communityDaoOf(userContext).load(newCommunityId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------



	public Family forgetByAll(ModelUserContext userContext, String familyId, int familyVersion) throws Exception {
		return forgetByAllInternal(userContext, familyId, familyVersion);
	}
	protected Family forgetByAllInternal(ModelUserContext userContext,
			String familyId, int familyVersion) throws Exception{

		return familyDaoOf(userContext).disconnectFromAll(familyId, familyVersion);
	}




	public int deleteAll(ModelUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FamilyManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}








	protected void checkParamsForAddingKid(ModelUserContext userContext, String familyId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfFamily(familyId);


		checkerOf(userContext).checkNameOfKid(name);


		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);



	}
	public  Family addKid(ModelUserContext userContext, String familyId, String name, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingKid(userContext,familyId,name,tokensExpr);

		Kid kid = createKid(userContext,name);

		Family family = loadFamily(userContext, familyId, emptyOptions());
		synchronized(family){
			//Will be good when the family loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			family.addKid( kid );
			family = saveFamily(userContext, family, tokens().withKidList().done());
			
			kidManagerOf(userContext).onNewInstanceCreated(userContext, kid);
			return present(userContext,family, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingKidProperties(ModelUserContext userContext, String familyId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFamily(familyId);
		checkerOf(userContext).checkIdOfKid(id);

		checkerOf(userContext).checkNameOfKid( name);


		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);


	}
	public  Family updateKidProperties(ModelUserContext userContext, String familyId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKidProperties(userContext,familyId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withKidListList()
				.searchKidListWith(Kid.ID_PROPERTY, tokens().is(), id).done();

		Family familyToUpdate = loadFamily(userContext, familyId, options);

		if(familyToUpdate.getKidList().isEmpty()){
			throw new FamilyManagerException("Kid is NOT FOUND with id: '"+id+"'");
		}

		Kid item = familyToUpdate.getKidList().first();
		beforeUpdateKidProperties(userContext,item, familyId,id,name,tokensExpr);
		item.updateName( name );


		//checkParamsForAddingKid(userContext,familyId,name, code, used,tokensExpr);
		Family family = saveFamily(userContext, familyToUpdate, tokens().withKidList().done());
		synchronized(family){
			return present(userContext,family, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateKidProperties(ModelUserContext userContext, Kid item, String familyId, String id,String name, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected Kid createKid(ModelUserContext userContext, String name) throws Exception{

		Kid kid = new Kid();
		
		
		kid.setName(name);
	
		
		return kid;


	}

	protected Kid createIndexedKid(String id, int version){

		Kid kid = new Kid();
		kid.setId(id);
		kid.setVersion(version);
		return kid;

	}

	protected void checkParamsForRemovingKidList(ModelUserContext userContext, String familyId,
			String kidIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfFamily(familyId);
		for(String kidIdItem: kidIds){
			checkerOf(userContext).checkIdOfKid(kidIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);

	}
	public  Family removeKidList(ModelUserContext userContext, String familyId,
			String kidIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingKidList(userContext, familyId,  kidIds, tokensExpr);


			Family family = loadFamily(userContext, familyId, allTokens());
			synchronized(family){
				//Will be good when the family loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				familyDaoOf(userContext).planToRemoveKidList(family, kidIds, allTokens());
				family = saveFamily(userContext, family, tokens().withKidList().done());
				deleteRelationListInGraph(userContext, family.getKidList());
				return present(userContext,family, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingKid(ModelUserContext userContext, String familyId,
		String kidId, int kidVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFamily( familyId);
		checkerOf(userContext).checkIdOfKid(kidId);
		checkerOf(userContext).checkVersionOfKid(kidVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);


	}
	public  Family removeKid(ModelUserContext userContext, String familyId,
		String kidId, int kidVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingKid(userContext,familyId, kidId, kidVersion,tokensExpr);

		Kid kid = createIndexedKid(kidId, kidVersion);
		Family family = loadFamily(userContext, familyId, allTokens());
		synchronized(family){
			//Will be good when the family loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			family.removeKid( kid );
			family = saveFamily(userContext, family, tokens().withKidList().done());
			deleteRelationInGraph(userContext, kid);
			return present(userContext,family, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingKid(ModelUserContext userContext, String familyId,
		String kidId, int kidVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfFamily( familyId);
		checkerOf(userContext).checkIdOfKid(kidId);
		checkerOf(userContext).checkVersionOfKid(kidVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);


	}
	public  Family copyKidFrom(ModelUserContext userContext, String familyId,
		String kidId, int kidVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingKid(userContext,familyId, kidId, kidVersion,tokensExpr);

		Kid kid = createIndexedKid(kidId, kidVersion);
		Family family = loadFamily(userContext, familyId, allTokens());
		synchronized(family){
			//Will be good when the family loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			family.copyKidFrom( kid );
			family = saveFamily(userContext, family, tokens().withKidList().done());
			
			kidManagerOf(userContext).onNewInstanceCreated(userContext, (Kid)family.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,family, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingKid(ModelUserContext userContext, String familyId, String kidId, int kidVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfFamily(familyId);
		checkerOf(userContext).checkIdOfKid(kidId);
		checkerOf(userContext).checkVersionOfKid(kidVersion);


		if(Kid.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfKid(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(FamilyManagerException.class);


	}

	public  Family updateKid(ModelUserContext userContext, String familyId, String kidId, int kidVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingKid(userContext, familyId, kidId, kidVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withKidList().searchKidListWith(Kid.ID_PROPERTY, tokens().equals(), kidId).done();



		Family family = loadFamily(userContext, familyId, loadTokens);

		synchronized(family){
			//Will be good when the family loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//family.removeKid( kid );
			//make changes to AcceleraterAccount.
			Kid kidIdVersionKey = createIndexedKid(kidId, kidVersion);

			Kid kid = family.findTheKid(kidIdVersionKey);
			if(kid == null){
				throw new FamilyManagerException(kidId+" is NOT FOUND" );
			}

			beforeUpdateKid(userContext, kid, familyId, kidId, kidVersion, property, newValueExpr,  tokensExpr);
			kid.changeProperty(property, newValueExpr);
			
			family = saveFamily(userContext, family, tokens().withKidList().done());
			kidManagerOf(userContext).onUpdated(userContext, kid, this, "updateKid");
			return present(userContext,family, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateKid(ModelUserContext userContext, Kid existed, String familyId, String kidId, int kidVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(ModelUserContext userContext, Family newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(ModelUserContext ctx) throws Exception{
    familyDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Family newFamily = this.createFamily(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newFamily
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
    key.put(UserApp.APP_TYPE_PROPERTY, Family.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(ModelUserContext userContext,SmartList<Family> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Community> communityList = ModelBaseUtils.collectReferencedObjectWithType(userContext, list, Community.class);
		userContext.getDAOGroup().enhanceList(communityList, Community.class);


    }
	
	public Object listByCommunity(ModelUserContext userContext,String communityId) throws Exception {
		return listPageByCommunity(userContext, communityId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCommunity(ModelUserContext userContext,String communityId, int start, int count) throws Exception {
		SmartList<Family> list = familyDaoOf(userContext).findFamilyByCommunity(communityId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		ModelCommonListOfViewPage page = new ModelCommonListOfViewPage();
		page.setClassOfList(Family.class);
		page.setContainerObject(Community.withId(communityId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("家庭列表");
		page.setRequestName("listByCommunity");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCommunity/%s/",  getBeanName(), communityId)));

		page.assemblerContent(userContext, "listByCommunity");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(ModelUserContext userContext, String familyId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		Family merchantObj = (Family) this.view(userContext, familyId);
    String merchantObjId = familyId;
    String linkToUrl =	"familyManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "家庭"+"详情";
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
				MapUtil.put("id", "3-community")
				    .put("fieldName", "community")
				    .put("label", "社区")
				    .put("type", "auto")
				    .put("linkToUrl", "communityManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"address\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("community", merchantObj.getCommunity());

		//处理 sectionList

		//处理Section：kidListSection
		Map kidListSection = ListofUtils.buildSection(
		    "kidListSection",
		    "孩子列表",
		    null,
		    "",
		    "__no_group",
		    "kidManager/listByFamily/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(kidListSection);

		result.put("kidListSection", ListofUtils.toShortList(merchantObj.getKidList(), "kid"));

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




