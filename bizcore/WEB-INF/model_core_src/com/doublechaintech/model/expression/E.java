package com.doublechaintech.model.expression;
public class E {

  public static com.doublechaintech.model.community.CommunityExpression<com.doublechaintech.model.community.Community> community(){
    return new com.doublechaintech.model.community.CommunityExpression<com.doublechaintech.model.community.Community>() {
      @Override
      public com.doublechaintech.model.community.Community eval(com.doublechaintech.model.community.Community community) {
        return community;
      }
    };
  }

  public static com.doublechaintech.model.community.CommunityExpression<com.doublechaintech.model.community.Community> community(com.doublechaintech.model.community.Community community){
      return new com.doublechaintech.model.community.CommunityExpression<com.doublechaintech.model.community.Community>() {
        @Override
        public com.doublechaintech.model.community.Community $getRoot() {
          return community;
        }

        @Override
        public com.doublechaintech.model.community.Community eval(com.doublechaintech.model.community.Community community) {
          return community;
        }
      };
    }

  public static com.doublechaintech.model.family.FamilyExpression<com.doublechaintech.model.family.Family> family(){
    return new com.doublechaintech.model.family.FamilyExpression<com.doublechaintech.model.family.Family>() {
      @Override
      public com.doublechaintech.model.family.Family eval(com.doublechaintech.model.family.Family family) {
        return family;
      }
    };
  }

  public static com.doublechaintech.model.family.FamilyExpression<com.doublechaintech.model.family.Family> family(com.doublechaintech.model.family.Family family){
      return new com.doublechaintech.model.family.FamilyExpression<com.doublechaintech.model.family.Family>() {
        @Override
        public com.doublechaintech.model.family.Family $getRoot() {
          return family;
        }

        @Override
        public com.doublechaintech.model.family.Family eval(com.doublechaintech.model.family.Family family) {
          return family;
        }
      };
    }

  public static com.doublechaintech.model.kid.KidExpression<com.doublechaintech.model.kid.Kid> kid(){
    return new com.doublechaintech.model.kid.KidExpression<com.doublechaintech.model.kid.Kid>() {
      @Override
      public com.doublechaintech.model.kid.Kid eval(com.doublechaintech.model.kid.Kid kid) {
        return kid;
      }
    };
  }

  public static com.doublechaintech.model.kid.KidExpression<com.doublechaintech.model.kid.Kid> kid(com.doublechaintech.model.kid.Kid kid){
      return new com.doublechaintech.model.kid.KidExpression<com.doublechaintech.model.kid.Kid>() {
        @Override
        public com.doublechaintech.model.kid.Kid $getRoot() {
          return kid;
        }

        @Override
        public com.doublechaintech.model.kid.Kid eval(com.doublechaintech.model.kid.Kid kid) {
          return kid;
        }
      };
    }

  public static com.doublechaintech.model.mobileapp.MobileAppExpression<com.doublechaintech.model.mobileapp.MobileApp> mobileApp(){
    return new com.doublechaintech.model.mobileapp.MobileAppExpression<com.doublechaintech.model.mobileapp.MobileApp>() {
      @Override
      public com.doublechaintech.model.mobileapp.MobileApp eval(com.doublechaintech.model.mobileapp.MobileApp mobileApp) {
        return mobileApp;
      }
    };
  }

  public static com.doublechaintech.model.mobileapp.MobileAppExpression<com.doublechaintech.model.mobileapp.MobileApp> mobileApp(com.doublechaintech.model.mobileapp.MobileApp mobileApp){
      return new com.doublechaintech.model.mobileapp.MobileAppExpression<com.doublechaintech.model.mobileapp.MobileApp>() {
        @Override
        public com.doublechaintech.model.mobileapp.MobileApp $getRoot() {
          return mobileApp;
        }

        @Override
        public com.doublechaintech.model.mobileapp.MobileApp eval(com.doublechaintech.model.mobileapp.MobileApp mobileApp) {
          return mobileApp;
        }
      };
    }

  public static com.doublechaintech.model.page.PageExpression<com.doublechaintech.model.page.Page> page(){
    return new com.doublechaintech.model.page.PageExpression<com.doublechaintech.model.page.Page>() {
      @Override
      public com.doublechaintech.model.page.Page eval(com.doublechaintech.model.page.Page page) {
        return page;
      }
    };
  }

  public static com.doublechaintech.model.page.PageExpression<com.doublechaintech.model.page.Page> page(com.doublechaintech.model.page.Page page){
      return new com.doublechaintech.model.page.PageExpression<com.doublechaintech.model.page.Page>() {
        @Override
        public com.doublechaintech.model.page.Page $getRoot() {
          return page;
        }

        @Override
        public com.doublechaintech.model.page.Page eval(com.doublechaintech.model.page.Page page) {
          return page;
        }
      };
    }

  public static com.doublechaintech.model.pagetype.PageTypeExpression<com.doublechaintech.model.pagetype.PageType> pageType(){
    return new com.doublechaintech.model.pagetype.PageTypeExpression<com.doublechaintech.model.pagetype.PageType>() {
      @Override
      public com.doublechaintech.model.pagetype.PageType eval(com.doublechaintech.model.pagetype.PageType pageType) {
        return pageType;
      }
    };
  }

  public static com.doublechaintech.model.pagetype.PageTypeExpression<com.doublechaintech.model.pagetype.PageType> pageType(com.doublechaintech.model.pagetype.PageType pageType){
      return new com.doublechaintech.model.pagetype.PageTypeExpression<com.doublechaintech.model.pagetype.PageType>() {
        @Override
        public com.doublechaintech.model.pagetype.PageType $getRoot() {
          return pageType;
        }

        @Override
        public com.doublechaintech.model.pagetype.PageType eval(com.doublechaintech.model.pagetype.PageType pageType) {
          return pageType;
        }
      };
    }

  public static com.doublechaintech.model.slide.SlideExpression<com.doublechaintech.model.slide.Slide> slide(){
    return new com.doublechaintech.model.slide.SlideExpression<com.doublechaintech.model.slide.Slide>() {
      @Override
      public com.doublechaintech.model.slide.Slide eval(com.doublechaintech.model.slide.Slide slide) {
        return slide;
      }
    };
  }

  public static com.doublechaintech.model.slide.SlideExpression<com.doublechaintech.model.slide.Slide> slide(com.doublechaintech.model.slide.Slide slide){
      return new com.doublechaintech.model.slide.SlideExpression<com.doublechaintech.model.slide.Slide>() {
        @Override
        public com.doublechaintech.model.slide.Slide $getRoot() {
          return slide;
        }

        @Override
        public com.doublechaintech.model.slide.Slide eval(com.doublechaintech.model.slide.Slide slide) {
          return slide;
        }
      };
    }

  public static com.doublechaintech.model.uiaction.UiActionExpression<com.doublechaintech.model.uiaction.UiAction> uiAction(){
    return new com.doublechaintech.model.uiaction.UiActionExpression<com.doublechaintech.model.uiaction.UiAction>() {
      @Override
      public com.doublechaintech.model.uiaction.UiAction eval(com.doublechaintech.model.uiaction.UiAction uiAction) {
        return uiAction;
      }
    };
  }

  public static com.doublechaintech.model.uiaction.UiActionExpression<com.doublechaintech.model.uiaction.UiAction> uiAction(com.doublechaintech.model.uiaction.UiAction uiAction){
      return new com.doublechaintech.model.uiaction.UiActionExpression<com.doublechaintech.model.uiaction.UiAction>() {
        @Override
        public com.doublechaintech.model.uiaction.UiAction $getRoot() {
          return uiAction;
        }

        @Override
        public com.doublechaintech.model.uiaction.UiAction eval(com.doublechaintech.model.uiaction.UiAction uiAction) {
          return uiAction;
        }
      };
    }

  public static com.doublechaintech.model.section.SectionExpression<com.doublechaintech.model.section.Section> section(){
    return new com.doublechaintech.model.section.SectionExpression<com.doublechaintech.model.section.Section>() {
      @Override
      public com.doublechaintech.model.section.Section eval(com.doublechaintech.model.section.Section section) {
        return section;
      }
    };
  }

  public static com.doublechaintech.model.section.SectionExpression<com.doublechaintech.model.section.Section> section(com.doublechaintech.model.section.Section section){
      return new com.doublechaintech.model.section.SectionExpression<com.doublechaintech.model.section.Section>() {
        @Override
        public com.doublechaintech.model.section.Section $getRoot() {
          return section;
        }

        @Override
        public com.doublechaintech.model.section.Section eval(com.doublechaintech.model.section.Section section) {
          return section;
        }
      };
    }

  public static com.doublechaintech.model.userdomain.UserDomainExpression<com.doublechaintech.model.userdomain.UserDomain> userDomain(){
    return new com.doublechaintech.model.userdomain.UserDomainExpression<com.doublechaintech.model.userdomain.UserDomain>() {
      @Override
      public com.doublechaintech.model.userdomain.UserDomain eval(com.doublechaintech.model.userdomain.UserDomain userDomain) {
        return userDomain;
      }
    };
  }

  public static com.doublechaintech.model.userdomain.UserDomainExpression<com.doublechaintech.model.userdomain.UserDomain> userDomain(com.doublechaintech.model.userdomain.UserDomain userDomain){
      return new com.doublechaintech.model.userdomain.UserDomainExpression<com.doublechaintech.model.userdomain.UserDomain>() {
        @Override
        public com.doublechaintech.model.userdomain.UserDomain $getRoot() {
          return userDomain;
        }

        @Override
        public com.doublechaintech.model.userdomain.UserDomain eval(com.doublechaintech.model.userdomain.UserDomain userDomain) {
          return userDomain;
        }
      };
    }

  public static com.doublechaintech.model.userallowlist.UserAllowListExpression<com.doublechaintech.model.userallowlist.UserAllowList> userAllowList(){
    return new com.doublechaintech.model.userallowlist.UserAllowListExpression<com.doublechaintech.model.userallowlist.UserAllowList>() {
      @Override
      public com.doublechaintech.model.userallowlist.UserAllowList eval(com.doublechaintech.model.userallowlist.UserAllowList userAllowList) {
        return userAllowList;
      }
    };
  }

  public static com.doublechaintech.model.userallowlist.UserAllowListExpression<com.doublechaintech.model.userallowlist.UserAllowList> userAllowList(com.doublechaintech.model.userallowlist.UserAllowList userAllowList){
      return new com.doublechaintech.model.userallowlist.UserAllowListExpression<com.doublechaintech.model.userallowlist.UserAllowList>() {
        @Override
        public com.doublechaintech.model.userallowlist.UserAllowList $getRoot() {
          return userAllowList;
        }

        @Override
        public com.doublechaintech.model.userallowlist.UserAllowList eval(com.doublechaintech.model.userallowlist.UserAllowList userAllowList) {
          return userAllowList;
        }
      };
    }

  public static com.doublechaintech.model.secuser.SecUserExpression<com.doublechaintech.model.secuser.SecUser> secUser(){
    return new com.doublechaintech.model.secuser.SecUserExpression<com.doublechaintech.model.secuser.SecUser>() {
      @Override
      public com.doublechaintech.model.secuser.SecUser eval(com.doublechaintech.model.secuser.SecUser secUser) {
        return secUser;
      }
    };
  }

  public static com.doublechaintech.model.secuser.SecUserExpression<com.doublechaintech.model.secuser.SecUser> secUser(com.doublechaintech.model.secuser.SecUser secUser){
      return new com.doublechaintech.model.secuser.SecUserExpression<com.doublechaintech.model.secuser.SecUser>() {
        @Override
        public com.doublechaintech.model.secuser.SecUser $getRoot() {
          return secUser;
        }

        @Override
        public com.doublechaintech.model.secuser.SecUser eval(com.doublechaintech.model.secuser.SecUser secUser) {
          return secUser;
        }
      };
    }

  public static com.doublechaintech.model.userapp.UserAppExpression<com.doublechaintech.model.userapp.UserApp> userApp(){
    return new com.doublechaintech.model.userapp.UserAppExpression<com.doublechaintech.model.userapp.UserApp>() {
      @Override
      public com.doublechaintech.model.userapp.UserApp eval(com.doublechaintech.model.userapp.UserApp userApp) {
        return userApp;
      }
    };
  }

  public static com.doublechaintech.model.userapp.UserAppExpression<com.doublechaintech.model.userapp.UserApp> userApp(com.doublechaintech.model.userapp.UserApp userApp){
      return new com.doublechaintech.model.userapp.UserAppExpression<com.doublechaintech.model.userapp.UserApp>() {
        @Override
        public com.doublechaintech.model.userapp.UserApp $getRoot() {
          return userApp;
        }

        @Override
        public com.doublechaintech.model.userapp.UserApp eval(com.doublechaintech.model.userapp.UserApp userApp) {
          return userApp;
        }
      };
    }

  public static com.doublechaintech.model.quicklink.QuickLinkExpression<com.doublechaintech.model.quicklink.QuickLink> quickLink(){
    return new com.doublechaintech.model.quicklink.QuickLinkExpression<com.doublechaintech.model.quicklink.QuickLink>() {
      @Override
      public com.doublechaintech.model.quicklink.QuickLink eval(com.doublechaintech.model.quicklink.QuickLink quickLink) {
        return quickLink;
      }
    };
  }

  public static com.doublechaintech.model.quicklink.QuickLinkExpression<com.doublechaintech.model.quicklink.QuickLink> quickLink(com.doublechaintech.model.quicklink.QuickLink quickLink){
      return new com.doublechaintech.model.quicklink.QuickLinkExpression<com.doublechaintech.model.quicklink.QuickLink>() {
        @Override
        public com.doublechaintech.model.quicklink.QuickLink $getRoot() {
          return quickLink;
        }

        @Override
        public com.doublechaintech.model.quicklink.QuickLink eval(com.doublechaintech.model.quicklink.QuickLink quickLink) {
          return quickLink;
        }
      };
    }

  public static com.doublechaintech.model.listaccess.ListAccessExpression<com.doublechaintech.model.listaccess.ListAccess> listAccess(){
    return new com.doublechaintech.model.listaccess.ListAccessExpression<com.doublechaintech.model.listaccess.ListAccess>() {
      @Override
      public com.doublechaintech.model.listaccess.ListAccess eval(com.doublechaintech.model.listaccess.ListAccess listAccess) {
        return listAccess;
      }
    };
  }

  public static com.doublechaintech.model.listaccess.ListAccessExpression<com.doublechaintech.model.listaccess.ListAccess> listAccess(com.doublechaintech.model.listaccess.ListAccess listAccess){
      return new com.doublechaintech.model.listaccess.ListAccessExpression<com.doublechaintech.model.listaccess.ListAccess>() {
        @Override
        public com.doublechaintech.model.listaccess.ListAccess $getRoot() {
          return listAccess;
        }

        @Override
        public com.doublechaintech.model.listaccess.ListAccess eval(com.doublechaintech.model.listaccess.ListAccess listAccess) {
          return listAccess;
        }
      };
    }

  public static com.doublechaintech.model.loginhistory.LoginHistoryExpression<com.doublechaintech.model.loginhistory.LoginHistory> loginHistory(){
    return new com.doublechaintech.model.loginhistory.LoginHistoryExpression<com.doublechaintech.model.loginhistory.LoginHistory>() {
      @Override
      public com.doublechaintech.model.loginhistory.LoginHistory eval(com.doublechaintech.model.loginhistory.LoginHistory loginHistory) {
        return loginHistory;
      }
    };
  }

  public static com.doublechaintech.model.loginhistory.LoginHistoryExpression<com.doublechaintech.model.loginhistory.LoginHistory> loginHistory(com.doublechaintech.model.loginhistory.LoginHistory loginHistory){
      return new com.doublechaintech.model.loginhistory.LoginHistoryExpression<com.doublechaintech.model.loginhistory.LoginHistory>() {
        @Override
        public com.doublechaintech.model.loginhistory.LoginHistory $getRoot() {
          return loginHistory;
        }

        @Override
        public com.doublechaintech.model.loginhistory.LoginHistory eval(com.doublechaintech.model.loginhistory.LoginHistory loginHistory) {
          return loginHistory;
        }
      };
    }

  public static com.doublechaintech.model.candidatecontainer.CandidateContainerExpression<com.doublechaintech.model.candidatecontainer.CandidateContainer> candidateContainer(){
    return new com.doublechaintech.model.candidatecontainer.CandidateContainerExpression<com.doublechaintech.model.candidatecontainer.CandidateContainer>() {
      @Override
      public com.doublechaintech.model.candidatecontainer.CandidateContainer eval(com.doublechaintech.model.candidatecontainer.CandidateContainer candidateContainer) {
        return candidateContainer;
      }
    };
  }

  public static com.doublechaintech.model.candidatecontainer.CandidateContainerExpression<com.doublechaintech.model.candidatecontainer.CandidateContainer> candidateContainer(com.doublechaintech.model.candidatecontainer.CandidateContainer candidateContainer){
      return new com.doublechaintech.model.candidatecontainer.CandidateContainerExpression<com.doublechaintech.model.candidatecontainer.CandidateContainer>() {
        @Override
        public com.doublechaintech.model.candidatecontainer.CandidateContainer $getRoot() {
          return candidateContainer;
        }

        @Override
        public com.doublechaintech.model.candidatecontainer.CandidateContainer eval(com.doublechaintech.model.candidatecontainer.CandidateContainer candidateContainer) {
          return candidateContainer;
        }
      };
    }

  public static com.doublechaintech.model.candidateelement.CandidateElementExpression<com.doublechaintech.model.candidateelement.CandidateElement> candidateElement(){
    return new com.doublechaintech.model.candidateelement.CandidateElementExpression<com.doublechaintech.model.candidateelement.CandidateElement>() {
      @Override
      public com.doublechaintech.model.candidateelement.CandidateElement eval(com.doublechaintech.model.candidateelement.CandidateElement candidateElement) {
        return candidateElement;
      }
    };
  }

  public static com.doublechaintech.model.candidateelement.CandidateElementExpression<com.doublechaintech.model.candidateelement.CandidateElement> candidateElement(com.doublechaintech.model.candidateelement.CandidateElement candidateElement){
      return new com.doublechaintech.model.candidateelement.CandidateElementExpression<com.doublechaintech.model.candidateelement.CandidateElement>() {
        @Override
        public com.doublechaintech.model.candidateelement.CandidateElement $getRoot() {
          return candidateElement;
        }

        @Override
        public com.doublechaintech.model.candidateelement.CandidateElement eval(com.doublechaintech.model.candidateelement.CandidateElement candidateElement) {
          return candidateElement;
        }
      };
    }

  public static com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityExpression<com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity> wechatWorkappIdentity(){
    return new com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityExpression<com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity>() {
      @Override
      public com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity eval(com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity wechatWorkappIdentity) {
        return wechatWorkappIdentity;
      }
    };
  }

  public static com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityExpression<com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity> wechatWorkappIdentity(com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity wechatWorkappIdentity){
      return new com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityExpression<com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity>() {
        @Override
        public com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity $getRoot() {
          return wechatWorkappIdentity;
        }

        @Override
        public com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity eval(com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity wechatWorkappIdentity) {
          return wechatWorkappIdentity;
        }
      };
    }

  public static com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityExpression<com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity> wechatMiniappIdentity(){
    return new com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityExpression<com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity>() {
      @Override
      public com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity eval(com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity wechatMiniappIdentity) {
        return wechatMiniappIdentity;
      }
    };
  }

  public static com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityExpression<com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity> wechatMiniappIdentity(com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity wechatMiniappIdentity){
      return new com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityExpression<com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity>() {
        @Override
        public com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity $getRoot() {
          return wechatMiniappIdentity;
        }

        @Override
        public com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity eval(com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity wechatMiniappIdentity) {
          return wechatMiniappIdentity;
        }
      };
    }

  public static com.doublechaintech.model.keypairidentity.KeyPairIdentityExpression<com.doublechaintech.model.keypairidentity.KeyPairIdentity> keyPairIdentity(){
    return new com.doublechaintech.model.keypairidentity.KeyPairIdentityExpression<com.doublechaintech.model.keypairidentity.KeyPairIdentity>() {
      @Override
      public com.doublechaintech.model.keypairidentity.KeyPairIdentity eval(com.doublechaintech.model.keypairidentity.KeyPairIdentity keyPairIdentity) {
        return keyPairIdentity;
      }
    };
  }

  public static com.doublechaintech.model.keypairidentity.KeyPairIdentityExpression<com.doublechaintech.model.keypairidentity.KeyPairIdentity> keyPairIdentity(com.doublechaintech.model.keypairidentity.KeyPairIdentity keyPairIdentity){
      return new com.doublechaintech.model.keypairidentity.KeyPairIdentityExpression<com.doublechaintech.model.keypairidentity.KeyPairIdentity>() {
        @Override
        public com.doublechaintech.model.keypairidentity.KeyPairIdentity $getRoot() {
          return keyPairIdentity;
        }

        @Override
        public com.doublechaintech.model.keypairidentity.KeyPairIdentity eval(com.doublechaintech.model.keypairidentity.KeyPairIdentity keyPairIdentity) {
          return keyPairIdentity;
        }
      };
    }

  public static com.doublechaintech.model.publickeytype.PublicKeyTypeExpression<com.doublechaintech.model.publickeytype.PublicKeyType> publicKeyType(){
    return new com.doublechaintech.model.publickeytype.PublicKeyTypeExpression<com.doublechaintech.model.publickeytype.PublicKeyType>() {
      @Override
      public com.doublechaintech.model.publickeytype.PublicKeyType eval(com.doublechaintech.model.publickeytype.PublicKeyType publicKeyType) {
        return publicKeyType;
      }
    };
  }

  public static com.doublechaintech.model.publickeytype.PublicKeyTypeExpression<com.doublechaintech.model.publickeytype.PublicKeyType> publicKeyType(com.doublechaintech.model.publickeytype.PublicKeyType publicKeyType){
      return new com.doublechaintech.model.publickeytype.PublicKeyTypeExpression<com.doublechaintech.model.publickeytype.PublicKeyType>() {
        @Override
        public com.doublechaintech.model.publickeytype.PublicKeyType $getRoot() {
          return publicKeyType;
        }

        @Override
        public com.doublechaintech.model.publickeytype.PublicKeyType eval(com.doublechaintech.model.publickeytype.PublicKeyType publicKeyType) {
          return publicKeyType;
        }
      };
    }

  public static com.doublechaintech.model.treenode.TreeNodeExpression<com.doublechaintech.model.treenode.TreeNode> treeNode(){
    return new com.doublechaintech.model.treenode.TreeNodeExpression<com.doublechaintech.model.treenode.TreeNode>() {
      @Override
      public com.doublechaintech.model.treenode.TreeNode eval(com.doublechaintech.model.treenode.TreeNode treeNode) {
        return treeNode;
      }
    };
  }

  public static com.doublechaintech.model.treenode.TreeNodeExpression<com.doublechaintech.model.treenode.TreeNode> treeNode(com.doublechaintech.model.treenode.TreeNode treeNode){
      return new com.doublechaintech.model.treenode.TreeNodeExpression<com.doublechaintech.model.treenode.TreeNode>() {
        @Override
        public com.doublechaintech.model.treenode.TreeNode $getRoot() {
          return treeNode;
        }

        @Override
        public com.doublechaintech.model.treenode.TreeNode eval(com.doublechaintech.model.treenode.TreeNode treeNode) {
          return treeNode;
        }
      };
    }

}



