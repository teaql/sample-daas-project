package com.doublechaintech.model;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class ModelObjectChecker extends ModelChecker{
	protected void markAsChecked(BaseEntity baseEntity) {
    if (baseEntity == null){
      return;
    }
    baseEntity.setChecked(true);
	}

	protected boolean isChecked(BaseEntity baseEntity) {
    if (baseEntity == null) {
      return false;
    }
    if (!baseEntity.isChanged()){
      return true;
    }
    return baseEntity.isChecked();
	}

	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		ModelChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		ModelObjectChecker apply(BaseEntity targetEntity);
	}

	protected boolean isReferenceObject(BaseEntity target) {

		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}

		return true;

	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		return true;

	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}

	}

	public <T> ModelObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> ModelObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {


    if(target.isToRemove()){
      return this;
    }


		if (!(target.isChanged() || target.isMustCheck())) {
			return this;
		}

		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();

		return this;
	}
	public  ModelChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {

		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {

		return Arrays.asList(args).stream().collect(Collectors.joining(""));

	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public ModelObjectChecker checkAndFixCommunity(BaseEntity communityAsBaseEntity){

		if( isChecked(communityAsBaseEntity) ){
			return this;
		}
		markAsChecked(communityAsBaseEntity);
		commonObjectPropertyCheck(communityAsBaseEntity,"id",this::checkIdOfCommunity);
		commonObjectPropertyCheck(communityAsBaseEntity,"name",this::checkNameOfCommunity);
		commonObjectPropertyCheck(communityAsBaseEntity,"address",this::checkAddressOfCommunity);
		commonObjectPropertyCheck(communityAsBaseEntity,"version",this::checkVersionOfCommunity);
		commonObjectPropertyCheck(communityAsBaseEntity,"familyList",this::checkFamilyListOfCommunity);
		return this;

	}

	public ModelObjectChecker checkAndFixFamily(BaseEntity familyAsBaseEntity){

		if( isChecked(familyAsBaseEntity) ){
			return this;
		}
		markAsChecked(familyAsBaseEntity);
		commonObjectPropertyCheck(familyAsBaseEntity,"id",this::checkIdOfFamily);
		commonObjectPropertyCheck(familyAsBaseEntity,"name",this::checkNameOfFamily);
		commonObjectPropertyCheck(familyAsBaseEntity,"community",this::checkCommunityOfFamily);
		commonObjectPropertyCheck(familyAsBaseEntity,"version",this::checkVersionOfFamily);
		commonObjectPropertyCheck(familyAsBaseEntity,"kidList",this::checkKidListOfFamily);
		return this;

	}

	public ModelObjectChecker checkAndFixKid(BaseEntity kidAsBaseEntity){

		if( isChecked(kidAsBaseEntity) ){
			return this;
		}
		markAsChecked(kidAsBaseEntity);
		commonObjectPropertyCheck(kidAsBaseEntity,"id",this::checkIdOfKid);
		commonObjectPropertyCheck(kidAsBaseEntity,"name",this::checkNameOfKid);
		commonObjectPropertyCheck(kidAsBaseEntity,"family",this::checkFamilyOfKid);
		commonObjectPropertyCheck(kidAsBaseEntity,"version",this::checkVersionOfKid);
		return this;

	}

	public ModelObjectChecker checkAndFixMobileApp(BaseEntity mobileAppAsBaseEntity){

		if( isChecked(mobileAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(mobileAppAsBaseEntity);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"id",this::checkIdOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"name",this::checkNameOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"version",this::checkVersionOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"pageList",this::checkPageListOfMobileApp);
		commonObjectPropertyCheck(mobileAppAsBaseEntity,"pageTypeList",this::checkPageTypeListOfMobileApp);
		return this;

	}

	public ModelObjectChecker checkAndFixPage(BaseEntity pageAsBaseEntity){

		if( isChecked(pageAsBaseEntity) ){
			return this;
		}
		markAsChecked(pageAsBaseEntity);
		commonObjectPropertyCheck(pageAsBaseEntity,"id",this::checkIdOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"pageTitle",this::checkPageTitleOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"pageType",this::checkPageTypeOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"displayOrder",this::checkDisplayOrderOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"mobileApp",this::checkMobileAppOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"version",this::checkVersionOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"slideList",this::checkSlideListOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"uiActionList",this::checkUiActionListOfPage);
		commonObjectPropertyCheck(pageAsBaseEntity,"sectionList",this::checkSectionListOfPage);
		return this;

	}

	public ModelObjectChecker checkAndFixPageType(BaseEntity pageTypeAsBaseEntity){

		if( isChecked(pageTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(pageTypeAsBaseEntity);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"id",this::checkIdOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"name",this::checkNameOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"code",this::checkCodeOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"mobileApp",this::checkMobileAppOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"footerTab",this::checkFooterTabOfPageType);
		commonObjectPropertyCheck(pageTypeAsBaseEntity,"version",this::checkVersionOfPageType);
		return this;

	}

	public ModelObjectChecker checkAndFixSlide(BaseEntity slideAsBaseEntity){

		if( isChecked(slideAsBaseEntity) ){
			return this;
		}
		markAsChecked(slideAsBaseEntity);
		commonObjectPropertyCheck(slideAsBaseEntity,"id",this::checkIdOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"name",this::checkNameOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"displayOrder",this::checkDisplayOrderOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"imageUrl",this::checkImageUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"videoUrl",this::checkVideoUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"page",this::checkPageOfSlide);
		commonObjectPropertyCheck(slideAsBaseEntity,"version",this::checkVersionOfSlide);
		return this;

	}

	public ModelObjectChecker checkAndFixUiAction(BaseEntity uiActionAsBaseEntity){

		if( isChecked(uiActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(uiActionAsBaseEntity);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"id",this::checkIdOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"code",this::checkCodeOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"icon",this::checkIconOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"title",this::checkTitleOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"displayOrder",this::checkDisplayOrderOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"brief",this::checkBriefOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"imageUrl",this::checkImageUrlOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"extraData",this::checkExtraDataOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"page",this::checkPageOfUiAction);
		commonObjectPropertyCheck(uiActionAsBaseEntity,"version",this::checkVersionOfUiAction);
		return this;

	}

	public ModelObjectChecker checkAndFixSection(BaseEntity sectionAsBaseEntity){

		if( isChecked(sectionAsBaseEntity) ){
			return this;
		}
		markAsChecked(sectionAsBaseEntity);
		commonObjectPropertyCheck(sectionAsBaseEntity,"id",this::checkIdOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"title",this::checkTitleOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"brief",this::checkBriefOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"icon",this::checkIconOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"displayOrder",this::checkDisplayOrderOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"viewGroup",this::checkViewGroupOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"linkToUrl",this::checkLinkToUrlOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"page",this::checkPageOfSection);
		commonObjectPropertyCheck(sectionAsBaseEntity,"version",this::checkVersionOfSection);
		return this;

	}

	public ModelObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userAllowListList",this::checkUserAllowListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"publicKeyTypeList",this::checkPublicKeyTypeListOfUserDomain);
		return this;

	}

	public ModelObjectChecker checkAndFixUserAllowList(BaseEntity userAllowListAsBaseEntity){

		if( isChecked(userAllowListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAllowListAsBaseEntity);
		commonObjectPropertyCheck(userAllowListAsBaseEntity,"id",this::checkIdOfUserAllowList);
		commonObjectPropertyCheck(userAllowListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserAllowList);
		commonObjectPropertyCheck(userAllowListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserAllowList);
		commonObjectPropertyCheck(userAllowListAsBaseEntity,"domain",this::checkDomainOfUserAllowList);
		commonObjectPropertyCheck(userAllowListAsBaseEntity,"version",this::checkVersionOfUserAllowList);
		return this;

	}

	public ModelObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatWorkappIdentityList",this::checkWechatWorkappIdentityListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatMiniappIdentityList",this::checkWechatMiniappIdentityListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"keyPairIdentityList",this::checkKeyPairIdentityListOfSecUser);
		return this;

	}

	public ModelObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appType",this::checkAppTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appId",this::checkAppIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"ctxType",this::checkCtxTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"ctxId",this::checkCtxIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		return this;

	}

	public ModelObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public ModelObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public ModelObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public ModelObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public ModelObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}

	public ModelObjectChecker checkAndFixWechatWorkappIdentity(BaseEntity wechatWorkappIdentityAsBaseEntity){

		if( isChecked(wechatWorkappIdentityAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatWorkappIdentityAsBaseEntity);
		commonObjectPropertyCheck(wechatWorkappIdentityAsBaseEntity,"id",this::checkIdOfWechatWorkappIdentity);
		commonObjectPropertyCheck(wechatWorkappIdentityAsBaseEntity,"corpId",this::checkCorpIdOfWechatWorkappIdentity);
		commonObjectPropertyCheck(wechatWorkappIdentityAsBaseEntity,"userId",this::checkUserIdOfWechatWorkappIdentity);
		commonObjectPropertyCheck(wechatWorkappIdentityAsBaseEntity,"secUser",this::checkSecUserOfWechatWorkappIdentity);
		commonObjectPropertyAssign(wechatWorkappIdentityAsBaseEntity,"createTime",this::assignCreateTimeOfWechatWorkappIdentity);
		commonObjectPropertyCheck(wechatWorkappIdentityAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatWorkappIdentity);
		commonObjectPropertyCheck(wechatWorkappIdentityAsBaseEntity,"version",this::checkVersionOfWechatWorkappIdentity);
		return this;

	}

	public ModelObjectChecker checkAndFixWechatMiniappIdentity(BaseEntity wechatMiniappIdentityAsBaseEntity){

		if( isChecked(wechatMiniappIdentityAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatMiniappIdentityAsBaseEntity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"id",this::checkIdOfWechatMiniappIdentity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"openId",this::checkOpenIdOfWechatMiniappIdentity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"appId",this::checkAppIdOfWechatMiniappIdentity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"unionId",this::checkUnionIdOfWechatMiniappIdentity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"secUser",this::checkSecUserOfWechatMiniappIdentity);
		commonObjectPropertyAssign(wechatMiniappIdentityAsBaseEntity,"createTime",this::assignCreateTimeOfWechatMiniappIdentity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatMiniappIdentity);
		commonObjectPropertyCheck(wechatMiniappIdentityAsBaseEntity,"version",this::checkVersionOfWechatMiniappIdentity);
		return this;

	}

	public ModelObjectChecker checkAndFixKeyPairIdentity(BaseEntity keyPairIdentityAsBaseEntity){

		if( isChecked(keyPairIdentityAsBaseEntity) ){
			return this;
		}
		markAsChecked(keyPairIdentityAsBaseEntity);
		commonObjectPropertyCheck(keyPairIdentityAsBaseEntity,"id",this::checkIdOfKeyPairIdentity);
		commonObjectPropertyCheck(keyPairIdentityAsBaseEntity,"publicKey",this::checkPublicKeyOfKeyPairIdentity);
		commonObjectPropertyCheck(keyPairIdentityAsBaseEntity,"keyType",this::checkKeyTypeOfKeyPairIdentity);
		commonObjectPropertyCheck(keyPairIdentityAsBaseEntity,"secUser",this::checkSecUserOfKeyPairIdentity);
		commonObjectPropertyAssign(keyPairIdentityAsBaseEntity,"createTime",this::assignCreateTimeOfKeyPairIdentity);
		commonObjectPropertyCheck(keyPairIdentityAsBaseEntity,"version",this::checkVersionOfKeyPairIdentity);
		return this;

	}

	public ModelObjectChecker checkAndFixPublicKeyType(BaseEntity publicKeyTypeAsBaseEntity){

		if( isChecked(publicKeyTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(publicKeyTypeAsBaseEntity);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"id",this::checkIdOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"keyAlg",this::checkKeyAlgOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"signAlg",this::checkSignAlgOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"domain",this::checkDomainOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"version",this::checkVersionOfPublicKeyType);
		commonObjectPropertyCheck(publicKeyTypeAsBaseEntity,"keyPairIdentityList",this::checkKeyPairIdentityListOfPublicKeyType);
		return this;

	}

	public ModelObjectChecker checkAndFixTreeNode(BaseEntity treeNodeAsBaseEntity){

		if( isChecked(treeNodeAsBaseEntity) ){
			return this;
		}
		markAsChecked(treeNodeAsBaseEntity);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"id",this::checkIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeId",this::checkNodeIdOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"nodeType",this::checkNodeTypeOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"leftValue",this::checkLeftValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"rightValue",this::checkRightValueOfTreeNode);
		commonObjectPropertyCheck(treeNodeAsBaseEntity,"version",this::checkVersionOfTreeNode);
		return this;

	}


	public ModelObjectChecker checkFamilyListOfCommunity(List<BaseEntity> familyList){
		AtomicInteger index = new AtomicInteger();
		familyList.stream().forEach(family->
			commonObjectElementCheck(family,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFamily));
		return this;
	}

	public ModelObjectChecker checkKidListOfFamily(List<BaseEntity> kidList){
		AtomicInteger index = new AtomicInteger();
		kidList.stream().forEach(kid->
			commonObjectElementCheck(kid,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKid));
		return this;
	}

	public static final String COMMUNITY_OF_FAMILY = "family.community";


	public ModelObjectChecker checkCommunityOfFamily(BaseEntity communityAsBaseEntity){

		if(communityAsBaseEntity == null){
			checkBaseEntityReference(communityAsBaseEntity,true,COMMUNITY_OF_FAMILY);
			return this;
		}
		checkAndFixCommunity(communityAsBaseEntity);
		return this;
	}


	public static final String FAMILY_OF_KID = "kid.family";


	public ModelObjectChecker checkFamilyOfKid(BaseEntity familyAsBaseEntity){

		if(familyAsBaseEntity == null){
			checkBaseEntityReference(familyAsBaseEntity,true,FAMILY_OF_KID);
			return this;
		}
		checkAndFixFamily(familyAsBaseEntity);
		return this;
	}


	public ModelObjectChecker checkPageListOfMobileApp(List<BaseEntity> pageList){
		AtomicInteger index = new AtomicInteger();
		pageList.stream().forEach(page->
			commonObjectElementCheck(page,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPage));
		return this;
	}

	public ModelObjectChecker checkPageTypeListOfMobileApp(List<BaseEntity> pageTypeList){
		AtomicInteger index = new AtomicInteger();
		pageTypeList.stream().forEach(pageType->
			commonObjectElementCheck(pageType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPageType));
		return this;
	}

	public ModelObjectChecker checkSlideListOfPage(List<BaseEntity> slideList){
		AtomicInteger index = new AtomicInteger();
		slideList.stream().forEach(slide->
			commonObjectElementCheck(slide,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSlide));
		return this;
	}

	public ModelObjectChecker checkUiActionListOfPage(List<BaseEntity> uiActionList){
		AtomicInteger index = new AtomicInteger();
		uiActionList.stream().forEach(uiAction->
			commonObjectElementCheck(uiAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUiAction));
		return this;
	}

	public ModelObjectChecker checkSectionListOfPage(List<BaseEntity> sectionList){
		AtomicInteger index = new AtomicInteger();
		sectionList.stream().forEach(section->
			commonObjectElementCheck(section,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSection));
		return this;
	}

	public static final String PAGE_TYPE_OF_PAGE = "page.page_type";


	public ModelObjectChecker checkPageTypeOfPage(BaseEntity pageTypeAsBaseEntity){

		if(pageTypeAsBaseEntity == null){
			checkBaseEntityReference(pageTypeAsBaseEntity,true,PAGE_TYPE_OF_PAGE);
			return this;
		}
		checkAndFixPageType(pageTypeAsBaseEntity);
		return this;
	}


	public static final String MOBILE_APP_OF_PAGE = "page.mobile_app";


	public ModelObjectChecker checkMobileAppOfPage(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public static final String MOBILE_APP_OF_PAGE_TYPE = "page_type.mobile_app";


	public ModelObjectChecker checkMobileAppOfPageType(BaseEntity mobileAppAsBaseEntity){

		if(mobileAppAsBaseEntity == null){
			checkBaseEntityReference(mobileAppAsBaseEntity,true,MOBILE_APP_OF_PAGE_TYPE);
			return this;
		}
		checkAndFixMobileApp(mobileAppAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SLIDE = "slide.page";


	public ModelObjectChecker checkPageOfSlide(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SLIDE);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_UI_ACTION = "ui_action.page";


	public ModelObjectChecker checkPageOfUiAction(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_UI_ACTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public static final String PAGE_OF_SECTION = "section.page";


	public ModelObjectChecker checkPageOfSection(BaseEntity pageAsBaseEntity){

		if(pageAsBaseEntity == null){
			checkBaseEntityReference(pageAsBaseEntity,true,PAGE_OF_SECTION);
			return this;
		}
		checkAndFixPage(pageAsBaseEntity);
		return this;
	}


	public ModelObjectChecker checkUserAllowListListOfUserDomain(List<BaseEntity> userAllowListList){
		AtomicInteger index = new AtomicInteger();
		userAllowListList.stream().forEach(userAllowList->
			commonObjectElementCheck(userAllowList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserAllowList));
		return this;
	}

	public ModelObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public ModelObjectChecker checkPublicKeyTypeListOfUserDomain(List<BaseEntity> publicKeyTypeList){
		AtomicInteger index = new AtomicInteger();
		publicKeyTypeList.stream().forEach(publicKeyType->
			commonObjectElementCheck(publicKeyType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixPublicKeyType));
		return this;
	}

	public static final String DOMAIN_OF_USER_ALLOW_LIST = "user_allow_list.domain";


	public ModelObjectChecker checkDomainOfUserAllowList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_ALLOW_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public ModelObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public ModelObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public ModelObjectChecker checkWechatWorkappIdentityListOfSecUser(List<BaseEntity> wechatWorkappIdentityList){
		AtomicInteger index = new AtomicInteger();
		wechatWorkappIdentityList.stream().forEach(wechatWorkappIdentity->
			commonObjectElementCheck(wechatWorkappIdentity,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatWorkappIdentity));
		return this;
	}

	public ModelObjectChecker checkWechatMiniappIdentityListOfSecUser(List<BaseEntity> wechatMiniappIdentityList){
		AtomicInteger index = new AtomicInteger();
		wechatMiniappIdentityList.stream().forEach(wechatMiniappIdentity->
			commonObjectElementCheck(wechatMiniappIdentity,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatMiniappIdentity));
		return this;
	}

	public ModelObjectChecker checkKeyPairIdentityListOfSecUser(List<BaseEntity> keyPairIdentityList){
		AtomicInteger index = new AtomicInteger();
		keyPairIdentityList.stream().forEach(keyPairIdentity->
			commonObjectElementCheck(keyPairIdentity,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKeyPairIdentity));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public ModelObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public ModelObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public ModelObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public ModelObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public ModelObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public ModelObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public ModelObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public ModelObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public ModelObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTITY = "wechat_workapp_identity.sec_user";


	public ModelObjectChecker checkSecUserOfWechatWorkappIdentity(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_WORKAPP_IDENTITY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTITY = "wechat_miniapp_identity.sec_user";


	public ModelObjectChecker checkSecUserOfWechatMiniappIdentity(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_MINIAPP_IDENTITY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String KEY_TYPE_OF_KEY_PAIR_IDENTITY = "key_pair_identity.key_type";


	public ModelObjectChecker checkKeyTypeOfKeyPairIdentity(BaseEntity keyTypeAsBaseEntity){

		if(keyTypeAsBaseEntity == null){
			checkBaseEntityReference(keyTypeAsBaseEntity,true,KEY_TYPE_OF_KEY_PAIR_IDENTITY);
			return this;
		}
		checkAndFixPublicKeyType(keyTypeAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_KEY_PAIR_IDENTITY = "key_pair_identity.sec_user";


	public ModelObjectChecker checkSecUserOfKeyPairIdentity(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_KEY_PAIR_IDENTITY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public ModelObjectChecker checkKeyPairIdentityListOfPublicKeyType(List<BaseEntity> keyPairIdentityList){
		AtomicInteger index = new AtomicInteger();
		keyPairIdentityList.stream().forEach(keyPairIdentity->
			commonObjectElementCheck(keyPairIdentity,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixKeyPairIdentity));
		return this;
	}

	public static final String DOMAIN_OF_PUBLIC_KEY_TYPE = "public_key_type.domain";


	public ModelObjectChecker checkDomainOfPublicKeyType(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_PUBLIC_KEY_TYPE);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}

	public ModelObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public ModelObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}
	public ModelObjectChecker assignCreateTimeOfWechatWorkappIdentity(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public ModelObjectChecker assignCreateTimeOfWechatMiniappIdentity(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public ModelObjectChecker assignCreateTimeOfKeyPairIdentity(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}

}

