
package com.doublechaintech.model;
import java.util.Map;

import com.doublechaintech.model.community.Community;
import com.doublechaintech.model.family.Family;
import com.doublechaintech.model.kid.Kid;
import com.doublechaintech.model.mobileapp.MobileApp;
import com.doublechaintech.model.page.Page;
import com.doublechaintech.model.pagetype.PageType;
import com.doublechaintech.model.slide.Slide;
import com.doublechaintech.model.uiaction.UiAction;
import com.doublechaintech.model.section.Section;
import com.doublechaintech.model.userdomain.UserDomain;
import com.doublechaintech.model.userallowlist.UserAllowList;
import com.doublechaintech.model.secuser.SecUser;
import com.doublechaintech.model.userapp.UserApp;
import com.doublechaintech.model.quicklink.QuickLink;
import com.doublechaintech.model.listaccess.ListAccess;
import com.doublechaintech.model.loginhistory.LoginHistory;
import com.doublechaintech.model.candidatecontainer.CandidateContainer;
import com.doublechaintech.model.candidateelement.CandidateElement;
import com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.model.keypairidentity.KeyPairIdentity;
import com.doublechaintech.model.publickeytype.PublicKeyType;
import com.doublechaintech.model.treenode.TreeNode;

public class BeanFactoryImpl{


	public Community createCommunity(Map<String,Object> options){
		return new Community();
	}


	public Family createFamily(Map<String,Object> options){
		return new Family();
	}


	public Kid createKid(Map<String,Object> options){
		return new Kid();
	}


	public MobileApp createMobileApp(Map<String,Object> options){
		return new MobileApp();
	}


	public Page createPage(Map<String,Object> options){
		return new Page();
	}


	public PageType createPageType(Map<String,Object> options){
		return new PageType();
	}


	public Slide createSlide(Map<String,Object> options){
		return new Slide();
	}


	public UiAction createUiAction(Map<String,Object> options){
		return new UiAction();
	}


	public Section createSection(Map<String,Object> options){
		return new Section();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserAllowList createUserAllowList(Map<String,Object> options){
		return new UserAllowList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}


	public WechatWorkappIdentity createWechatWorkappIdentity(Map<String,Object> options){
		return new WechatWorkappIdentity();
	}


	public WechatMiniappIdentity createWechatMiniappIdentity(Map<String,Object> options){
		return new WechatMiniappIdentity();
	}


	public KeyPairIdentity createKeyPairIdentity(Map<String,Object> options){
		return new KeyPairIdentity();
	}


	public PublicKeyType createPublicKeyType(Map<String,Object> options){
		return new PublicKeyType();
	}


	public TreeNode createTreeNode(Map<String,Object> options){
		return new TreeNode();
	}





}


















