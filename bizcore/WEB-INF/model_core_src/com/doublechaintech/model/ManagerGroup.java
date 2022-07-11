package com.doublechaintech.model;

import com.doublechaintech.model.community.CommunityManager;

import com.doublechaintech.model.family.FamilyManager;

import com.doublechaintech.model.kid.KidManager;

import com.doublechaintech.model.mobileapp.MobileAppManager;

import com.doublechaintech.model.page.PageManager;

import com.doublechaintech.model.pagetype.PageTypeManager;

import com.doublechaintech.model.slide.SlideManager;

import com.doublechaintech.model.uiaction.UiActionManager;

import com.doublechaintech.model.section.SectionManager;

import com.doublechaintech.model.userdomain.UserDomainManager;

import com.doublechaintech.model.userallowlist.UserAllowListManager;

import com.doublechaintech.model.secuser.SecUserManager;

import com.doublechaintech.model.userapp.UserAppManager;

import com.doublechaintech.model.quicklink.QuickLinkManager;

import com.doublechaintech.model.listaccess.ListAccessManager;

import com.doublechaintech.model.loginhistory.LoginHistoryManager;

import com.doublechaintech.model.candidatecontainer.CandidateContainerManager;

import com.doublechaintech.model.candidateelement.CandidateElementManager;

import com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityManager;

import com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityManager;

import com.doublechaintech.model.keypairidentity.KeyPairIdentityManager;

import com.doublechaintech.model.publickeytype.PublicKeyTypeManager;

import com.doublechaintech.model.treenode.TreeNodeManager;

import com.skynet.infrastructure.EventService;
import com.terapico.caf.baseelement.Event;

public class ManagerGroup {

  protected CommunityManager communityManager;

  protected FamilyManager familyManager;

  protected KidManager kidManager;

  protected MobileAppManager mobileAppManager;

  protected PageManager pageManager;

  protected PageTypeManager pageTypeManager;

  protected SlideManager slideManager;

  protected UiActionManager uiActionManager;

  protected SectionManager sectionManager;

  protected UserDomainManager userDomainManager;

  protected UserAllowListManager userAllowListManager;

  protected SecUserManager secUserManager;

  protected UserAppManager userAppManager;

  protected QuickLinkManager quickLinkManager;

  protected ListAccessManager listAccessManager;

  protected LoginHistoryManager loginHistoryManager;

  protected CandidateContainerManager candidateContainerManager;

  protected CandidateElementManager candidateElementManager;

  protected WechatWorkappIdentityManager wechatWorkappIdentityManager;

  protected WechatMiniappIdentityManager wechatMiniappIdentityManager;

  protected KeyPairIdentityManager keyPairIdentityManager;

  protected PublicKeyTypeManager publicKeyTypeManager;

  protected TreeNodeManager treeNodeManager;

  public CommunityManager getCommunityManager() {
    return this.communityManager;
  }

  public void setCommunityManager(CommunityManager manager) {
    this.communityManager = manager;
  }

  public FamilyManager getFamilyManager() {
    return this.familyManager;
  }

  public void setFamilyManager(FamilyManager manager) {
    this.familyManager = manager;
  }

  public KidManager getKidManager() {
    return this.kidManager;
  }

  public void setKidManager(KidManager manager) {
    this.kidManager = manager;
  }

  public MobileAppManager getMobileAppManager() {
    return this.mobileAppManager;
  }

  public void setMobileAppManager(MobileAppManager manager) {
    this.mobileAppManager = manager;
  }

  public PageManager getPageManager() {
    return this.pageManager;
  }

  public void setPageManager(PageManager manager) {
    this.pageManager = manager;
  }

  public PageTypeManager getPageTypeManager() {
    return this.pageTypeManager;
  }

  public void setPageTypeManager(PageTypeManager manager) {
    this.pageTypeManager = manager;
  }

  public SlideManager getSlideManager() {
    return this.slideManager;
  }

  public void setSlideManager(SlideManager manager) {
    this.slideManager = manager;
  }

  public UiActionManager getUiActionManager() {
    return this.uiActionManager;
  }

  public void setUiActionManager(UiActionManager manager) {
    this.uiActionManager = manager;
  }

  public SectionManager getSectionManager() {
    return this.sectionManager;
  }

  public void setSectionManager(SectionManager manager) {
    this.sectionManager = manager;
  }

  public UserDomainManager getUserDomainManager() {
    return this.userDomainManager;
  }

  public void setUserDomainManager(UserDomainManager manager) {
    this.userDomainManager = manager;
  }

  public UserAllowListManager getUserAllowListManager() {
    return this.userAllowListManager;
  }

  public void setUserAllowListManager(UserAllowListManager manager) {
    this.userAllowListManager = manager;
  }

  public SecUserManager getSecUserManager() {
    return this.secUserManager;
  }

  public void setSecUserManager(SecUserManager manager) {
    this.secUserManager = manager;
  }

  public UserAppManager getUserAppManager() {
    return this.userAppManager;
  }

  public void setUserAppManager(UserAppManager manager) {
    this.userAppManager = manager;
  }

  public QuickLinkManager getQuickLinkManager() {
    return this.quickLinkManager;
  }

  public void setQuickLinkManager(QuickLinkManager manager) {
    this.quickLinkManager = manager;
  }

  public ListAccessManager getListAccessManager() {
    return this.listAccessManager;
  }

  public void setListAccessManager(ListAccessManager manager) {
    this.listAccessManager = manager;
  }

  public LoginHistoryManager getLoginHistoryManager() {
    return this.loginHistoryManager;
  }

  public void setLoginHistoryManager(LoginHistoryManager manager) {
    this.loginHistoryManager = manager;
  }

  public CandidateContainerManager getCandidateContainerManager() {
    return this.candidateContainerManager;
  }

  public void setCandidateContainerManager(CandidateContainerManager manager) {
    this.candidateContainerManager = manager;
  }

  public CandidateElementManager getCandidateElementManager() {
    return this.candidateElementManager;
  }

  public void setCandidateElementManager(CandidateElementManager manager) {
    this.candidateElementManager = manager;
  }

  public WechatWorkappIdentityManager getWechatWorkappIdentityManager() {
    return this.wechatWorkappIdentityManager;
  }

  public void setWechatWorkappIdentityManager(WechatWorkappIdentityManager manager) {
    this.wechatWorkappIdentityManager = manager;
  }

  public WechatMiniappIdentityManager getWechatMiniappIdentityManager() {
    return this.wechatMiniappIdentityManager;
  }

  public void setWechatMiniappIdentityManager(WechatMiniappIdentityManager manager) {
    this.wechatMiniappIdentityManager = manager;
  }

  public KeyPairIdentityManager getKeyPairIdentityManager() {
    return this.keyPairIdentityManager;
  }

  public void setKeyPairIdentityManager(KeyPairIdentityManager manager) {
    this.keyPairIdentityManager = manager;
  }

  public PublicKeyTypeManager getPublicKeyTypeManager() {
    return this.publicKeyTypeManager;
  }

  public void setPublicKeyTypeManager(PublicKeyTypeManager manager) {
    this.publicKeyTypeManager = manager;
  }

  public TreeNodeManager getTreeNodeManager() {
    return this.treeNodeManager;
  }

  public void setTreeNodeManager(TreeNodeManager manager) {
    this.treeNodeManager = manager;
  }

  public void sendAllItems(ModelUserContext ctx) throws Exception {
    EventService eventService = ((ModelUserContextImpl) ctx).getEventService();
    if (eventService == null) {
      return;
    }

    Event event = new Event();
    event.setTarget("model.init");
    event.setMessage("begin");
    eventService.sendEvent(event);

    this.communityManager.sendAllItems(ctx);

    this.familyManager.sendAllItems(ctx);

    this.kidManager.sendAllItems(ctx);

    this.mobileAppManager.sendAllItems(ctx);

    this.pageManager.sendAllItems(ctx);

    this.pageTypeManager.sendAllItems(ctx);

    this.slideManager.sendAllItems(ctx);

    this.uiActionManager.sendAllItems(ctx);

    this.sectionManager.sendAllItems(ctx);

    this.userDomainManager.sendAllItems(ctx);

    this.userAllowListManager.sendAllItems(ctx);

    this.secUserManager.sendAllItems(ctx);

    this.userAppManager.sendAllItems(ctx);

    this.quickLinkManager.sendAllItems(ctx);

    this.listAccessManager.sendAllItems(ctx);

    this.loginHistoryManager.sendAllItems(ctx);

    this.candidateContainerManager.sendAllItems(ctx);

    this.candidateElementManager.sendAllItems(ctx);

    this.wechatWorkappIdentityManager.sendAllItems(ctx);

    this.wechatMiniappIdentityManager.sendAllItems(ctx);

    this.keyPairIdentityManager.sendAllItems(ctx);

    this.publicKeyTypeManager.sendAllItems(ctx);

    this.treeNodeManager.sendAllItems(ctx);

    event = new Event();
    event.setTarget("model.init");
    event.setMessage("end");
    eventService.sendEvent(event);
  }
}
