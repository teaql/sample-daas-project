package com.doublechaintech.model.search;

public class Q {
  static final String VERSION_PROPERTY = "version";

  public static com.doublechaintech.model.community.CommunityRequest community() {
    return com.doublechaintech.model.community.CommunityRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.community.CommunityRequest communityWithIdField() {
    return com.doublechaintech.model.community.CommunityRequest.newInstance();
  }

  public static com.doublechaintech.model.community.CommunityRequest community(String id) {
    return community().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.family.FamilyRequest family() {
    return com.doublechaintech.model.family.FamilyRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.family.FamilyRequest familyWithIdField() {
    return com.doublechaintech.model.family.FamilyRequest.newInstance();
  }

  public static com.doublechaintech.model.family.FamilyRequest family(String id) {
    return family().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.kid.KidRequest kid() {
    return com.doublechaintech.model.kid.KidRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.kid.KidRequest kidWithIdField() {
    return com.doublechaintech.model.kid.KidRequest.newInstance();
  }

  public static com.doublechaintech.model.kid.KidRequest kid(String id) {
    return kid().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.mobileapp.MobileAppRequest mobileApp() {
    return com.doublechaintech.model.mobileapp.MobileAppRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.mobileapp.MobileAppRequest mobileAppWithIdField() {
    return com.doublechaintech.model.mobileapp.MobileAppRequest.newInstance();
  }

  public static com.doublechaintech.model.mobileapp.MobileAppRequest mobileApp(String id) {
    return mobileApp().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.page.PageRequest page() {
    return com.doublechaintech.model.page.PageRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.page.PageRequest pageWithIdField() {
    return com.doublechaintech.model.page.PageRequest.newInstance();
  }

  public static com.doublechaintech.model.page.PageRequest page(String id) {
    return page().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.pagetype.PageTypeRequest pageType() {
    return com.doublechaintech.model.pagetype.PageTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.pagetype.PageTypeRequest pageTypeWithIdField() {
    return com.doublechaintech.model.pagetype.PageTypeRequest.newInstance();
  }

  public static com.doublechaintech.model.pagetype.PageTypeRequest pageType(String id) {
    return pageType().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.slide.SlideRequest slide() {
    return com.doublechaintech.model.slide.SlideRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.slide.SlideRequest slideWithIdField() {
    return com.doublechaintech.model.slide.SlideRequest.newInstance();
  }

  public static com.doublechaintech.model.slide.SlideRequest slide(String id) {
    return slide().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.uiaction.UiActionRequest uiAction() {
    return com.doublechaintech.model.uiaction.UiActionRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.uiaction.UiActionRequest uiActionWithIdField() {
    return com.doublechaintech.model.uiaction.UiActionRequest.newInstance();
  }

  public static com.doublechaintech.model.uiaction.UiActionRequest uiAction(String id) {
    return uiAction().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.section.SectionRequest section() {
    return com.doublechaintech.model.section.SectionRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.section.SectionRequest sectionWithIdField() {
    return com.doublechaintech.model.section.SectionRequest.newInstance();
  }

  public static com.doublechaintech.model.section.SectionRequest section(String id) {
    return section().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.userdomain.UserDomainRequest userDomain() {
    return com.doublechaintech.model.userdomain.UserDomainRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.userdomain.UserDomainRequest userDomainWithIdField() {
    return com.doublechaintech.model.userdomain.UserDomainRequest.newInstance();
  }

  public static com.doublechaintech.model.userdomain.UserDomainRequest userDomain(String id) {
    return userDomain().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.userallowlist.UserAllowListRequest userAllowList() {
    return com.doublechaintech.model.userallowlist.UserAllowListRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.userallowlist.UserAllowListRequest
      userAllowListWithIdField() {
    return com.doublechaintech.model.userallowlist.UserAllowListRequest.newInstance();
  }

  public static com.doublechaintech.model.userallowlist.UserAllowListRequest userAllowList(
      String id) {
    return userAllowList().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.secuser.SecUserRequest secUser() {
    return com.doublechaintech.model.secuser.SecUserRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.secuser.SecUserRequest secUserWithIdField() {
    return com.doublechaintech.model.secuser.SecUserRequest.newInstance();
  }

  public static com.doublechaintech.model.secuser.SecUserRequest secUser(String id) {
    return secUser().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.userapp.UserAppRequest userApp() {
    return com.doublechaintech.model.userapp.UserAppRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.userapp.UserAppRequest userAppWithIdField() {
    return com.doublechaintech.model.userapp.UserAppRequest.newInstance();
  }

  public static com.doublechaintech.model.userapp.UserAppRequest userApp(String id) {
    return userApp().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.quicklink.QuickLinkRequest quickLink() {
    return com.doublechaintech.model.quicklink.QuickLinkRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.quicklink.QuickLinkRequest quickLinkWithIdField() {
    return com.doublechaintech.model.quicklink.QuickLinkRequest.newInstance();
  }

  public static com.doublechaintech.model.quicklink.QuickLinkRequest quickLink(String id) {
    return quickLink().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.listaccess.ListAccessRequest listAccess() {
    return com.doublechaintech.model.listaccess.ListAccessRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.listaccess.ListAccessRequest listAccessWithIdField() {
    return com.doublechaintech.model.listaccess.ListAccessRequest.newInstance();
  }

  public static com.doublechaintech.model.listaccess.ListAccessRequest listAccess(String id) {
    return listAccess().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.loginhistory.LoginHistoryRequest loginHistory() {
    return com.doublechaintech.model.loginhistory.LoginHistoryRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.loginhistory.LoginHistoryRequest
      loginHistoryWithIdField() {
    return com.doublechaintech.model.loginhistory.LoginHistoryRequest.newInstance();
  }

  public static com.doublechaintech.model.loginhistory.LoginHistoryRequest loginHistory(String id) {
    return loginHistory().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.candidatecontainer.CandidateContainerRequest
      candidateContainer() {
    return com.doublechaintech.model.candidatecontainer.CandidateContainerRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.candidatecontainer.CandidateContainerRequest
      candidateContainerWithIdField() {
    return com.doublechaintech.model.candidatecontainer.CandidateContainerRequest.newInstance();
  }

  public static com.doublechaintech.model.candidatecontainer.CandidateContainerRequest
      candidateContainer(String id) {
    return candidateContainer().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.candidateelement.CandidateElementRequest
      candidateElement() {
    return com.doublechaintech.model.candidateelement.CandidateElementRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.candidateelement.CandidateElementRequest
      candidateElementWithIdField() {
    return com.doublechaintech.model.candidateelement.CandidateElementRequest.newInstance();
  }

  public static com.doublechaintech.model.candidateelement.CandidateElementRequest candidateElement(
      String id) {
    return candidateElement().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityRequest
      wechatWorkappIdentity() {
    return com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityRequest
      wechatWorkappIdentityWithIdField() {
    return com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityRequest
        .newInstance();
  }

  public static com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityRequest
      wechatWorkappIdentity(String id) {
    return wechatWorkappIdentity().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityRequest
      wechatMiniappIdentity() {
    return com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityRequest
      wechatMiniappIdentityWithIdField() {
    return com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityRequest
        .newInstance();
  }

  public static com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityRequest
      wechatMiniappIdentity(String id) {
    return wechatMiniappIdentity().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.keypairidentity.KeyPairIdentityRequest keyPairIdentity() {
    return com.doublechaintech.model.keypairidentity.KeyPairIdentityRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.keypairidentity.KeyPairIdentityRequest
      keyPairIdentityWithIdField() {
    return com.doublechaintech.model.keypairidentity.KeyPairIdentityRequest.newInstance();
  }

  public static com.doublechaintech.model.keypairidentity.KeyPairIdentityRequest keyPairIdentity(
      String id) {
    return keyPairIdentity().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.publickeytype.PublicKeyTypeRequest publicKeyType() {
    return com.doublechaintech.model.publickeytype.PublicKeyTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.publickeytype.PublicKeyTypeRequest
      publicKeyTypeWithIdField() {
    return com.doublechaintech.model.publickeytype.PublicKeyTypeRequest.newInstance();
  }

  public static com.doublechaintech.model.publickeytype.PublicKeyTypeRequest publicKeyType(
      String id) {
    return publicKeyType().withId(id).selectSelf();
  }

  public static com.doublechaintech.model.treenode.TreeNodeRequest treeNode() {
    return com.doublechaintech.model.treenode.TreeNodeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.model.treenode.TreeNodeRequest treeNodeWithIdField() {
    return com.doublechaintech.model.treenode.TreeNodeRequest.newInstance();
  }

  public static com.doublechaintech.model.treenode.TreeNodeRequest treeNode(String id) {
    return treeNode().withId(id).selectSelf();
  }
}
