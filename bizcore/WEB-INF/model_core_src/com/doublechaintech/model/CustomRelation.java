
package com.doublechaintech.model;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Family"                                , BaseRelation.TRUST_CHAIN_ALL, "community");
		//replaceGenericRelation("Kid"                                   , BaseRelation.TRUST_CHAIN_ALL, "family");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "pageType");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("PageType"                              , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("Slide"                                 , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UiAction"                              , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("Section"                               , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UserAllowList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");
		//replaceGenericRelation("WechatWorkappIdentity"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("WechatMiniappIdentity"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("KeyPairIdentity"                       , BaseRelation.TRUST_CHAIN_ALL, "keyType");
		//replaceGenericRelation("KeyPairIdentity"                       , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("PublicKeyType"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] familyRelatedObjectNames = {"community:Community"};
		//replaceRelationIndex("Family",familyRelatedObjectNames);

		//String [] kidRelatedObjectNames = {"family:Family"};
		//replaceRelationIndex("Kid",kidRelatedObjectNames);

		//String [] pageRelatedObjectNames = {"page_type:PageType","mobile_app:MobileApp"};
		//replaceRelationIndex("Page",pageRelatedObjectNames);

		//String [] pageTypeRelatedObjectNames = {"mobile_app:MobileApp"};
		//replaceRelationIndex("PageType",pageTypeRelatedObjectNames);

		//String [] slideRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Slide",slideRelatedObjectNames);

		//String [] uiActionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("UiAction",uiActionRelatedObjectNames);

		//String [] sectionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Section",sectionRelatedObjectNames);

		//String [] userAllowListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserAllowList",userAllowListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		//String [] wechatWorkappIdentityRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatWorkappIdentity",wechatWorkappIdentityRelatedObjectNames);

		//String [] wechatMiniappIdentityRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatMiniappIdentity",wechatMiniappIdentityRelatedObjectNames);

		//String [] keyPairIdentityRelatedObjectNames = {"key_type:PublicKeyType","sec_user:SecUser"};
		//replaceRelationIndex("KeyPairIdentity",keyPairIdentityRelatedObjectNames);

		//String [] publicKeyTypeRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("PublicKeyType",publicKeyTypeRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}





















