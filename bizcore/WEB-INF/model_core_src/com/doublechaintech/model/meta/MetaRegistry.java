package com.doublechaintech.model.meta;

import com.terapico.meta.MetaProvider;
import com.terapico.meta.EntityMeta;
import org.springframework.beans.factory.InitializingBean;
public class MetaRegistry implements InitializingBean {
  @Override
  public void afterPropertiesSet() throws Exception {
      registerCommunity();
      registerFamily();
      registerKid();
      registerMobileApp();
      registerPage();
      registerPageType();
      registerSlide();
      registerUiAction();
      registerSection();
      registerUserDomain();
      registerUserAllowList();
      registerSecUser();
      registerUserApp();
      registerQuickLink();
      registerListAccess();
      registerLoginHistory();
      registerCandidateContainer();
      registerCandidateElement();
      registerWechatWorkappIdentity();
      registerWechatMiniappIdentity();
      registerKeyPairIdentity();
      registerPublicKeyType();
      registerTreeNode();
      
  }



    public void  registerCommunity(){
        EntityMeta community = MetaProvider.entity("com.doublechaintech.model.community.Community")
                  
                        .with("features", "root,visible_all")
                  ;
                  community.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    community.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    community.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    community.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    community.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    community.property("address")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    community.property("address")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    community.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    community.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerFamily(){
        EntityMeta family = MetaProvider.entity("com.doublechaintech.model.family.Family")
                  
                        .with("features", "root,visible_all")
                  ;
                  family.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    family.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    family.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    family.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    family.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    family.property("community")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    family.property("community")
                        .with("parentType", "com.doublechaintech.model.community.Community");
                    
                    family.property("community")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    family.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    family.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerKid(){
        EntityMeta kid = MetaProvider.entity("com.doublechaintech.model.kid.Kid")
                  
                        .with("features", "root,visible_all")
                  ;
                  kid.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    kid.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    kid.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    kid.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    kid.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    kid.property("family")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    kid.property("family")
                        .with("parentType", "com.doublechaintech.model.family.Family");
                    
                    kid.property("family")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    kid.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    kid.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerMobileApp(){
        EntityMeta mobileApp = MetaProvider.entity("com.doublechaintech.model.mobileapp.MobileApp")
                  
                        .with("features", "root,visible_all")
                  ;
                  mobileApp.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    mobileApp.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    mobileApp.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    mobileApp.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    mobileApp.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    mobileApp.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    mobileApp.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerPage(){
        EntityMeta page = MetaProvider.entity("com.doublechaintech.model.page.Page")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4mobile_app", "页面管理")
                  ;
                  page.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    page.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    page.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    page.property("pageTitle")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    page.property("pageTitle")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    page.property("linkToUrl")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    page.property("linkToUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    page.property("pageType")
                      
                        .with("identified_by", "code")
                      
                        .with("features", "status")
                      ;
                    
                    page.property("pageType")
                        .with("parentType", "com.doublechaintech.model.pagetype.PageType");
                    
                    page.property("pageType")
                        .with("tokens", "SEARCH,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,CONSTANT,PERSISTENCE,SAMPLE_DATA_COUNT_INFER,PREFERENCE,ACTION,EXCEL_VIEW,TRANSFERABLE_CONSTANT,ADMINUI,VISIBLE_PARENT");

                    
                  
                    page.property("displayOrder")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      ;
                    
                    page.property("displayOrder")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    page.property("mobileApp")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    page.property("mobileApp")
                        .with("parentType", "com.doublechaintech.model.mobileapp.MobileApp");
                    
                    page.property("mobileApp")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    page.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    page.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerPageType(){
        EntityMeta pageType = MetaProvider.entity("com.doublechaintech.model.pagetype.PageType")
                  
                        .with("identified_by", "code")
                  
                        .with("features", "status")
                  ;
                  pageType.with("tokens", "SEARCH,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,CONSTANT,PERSISTENCE,SAMPLE_DATA_COUNT_INFER,PREFERENCE,ACTION,EXCEL_VIEW,TRANSFERABLE_CONSTANT,ADMINUI,VISIBLE_PARENT");
                  
                    pageType.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    pageType.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    pageType.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    pageType.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    pageType.property("code")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    pageType.property("code")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    pageType.property("mobileApp")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    pageType.property("mobileApp")
                        .with("parentType", "com.doublechaintech.model.mobileapp.MobileApp");
                    
                    pageType.property("mobileApp")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    pageType.property("footerTab")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    pageType.property("footerTab")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    pageType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    pageType.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerSlide(){
        EntityMeta slide = MetaProvider.entity("com.doublechaintech.model.slide.Slide")
                  
                        .with("features", "root,visible_all")
                  ;
                  slide.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    slide.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    slide.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    slide.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("displayOrder")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      ;
                    
                    slide.property("displayOrder")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("imageUrl")
                      
                        .with("parent", "string")
                      
                        .with("editor", "imageeditor")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    slide.property("imageUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,IMAGE,SEARCHABLE,UPDATE,SAMPLE_DATA,ATTACHMENT,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("videoUrl")
                      
                        .with("parent", "string")
                      
                        .with("editor", "imageeditor")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    slide.property("videoUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,IMAGE,SEARCHABLE,UPDATE,SAMPLE_DATA,ATTACHMENT,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("linkToUrl")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    slide.property("linkToUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    slide.property("page")
                        .with("parentType", "com.doublechaintech.model.page.Page");
                    
                    slide.property("page")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    slide.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    slide.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerUiAction(){
        EntityMeta uiAction = MetaProvider.entity("com.doublechaintech.model.uiaction.UiAction")
                  
                        .with("features", "root,visible_all")
                  ;
                  uiAction.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    uiAction.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    uiAction.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("code")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("code")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("icon")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("icon")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("title")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("title")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("displayOrder")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      ;
                    
                    uiAction.property("displayOrder")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("brief")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("brief")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("imageUrl")
                      
                        .with("parent", "string")
                      
                        .with("editor", "imageeditor")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("imageUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,IMAGE,SEARCHABLE,UPDATE,SAMPLE_DATA,ATTACHMENT,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("linkToUrl")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("linkToUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("extraData")
                      
                        .with("parent", "string_longtext")
                      
                        .with("type", "string_longtext")
                      
                        .with("features", "root,visible_all,string,longtext")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    uiAction.property("extraData")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,LONGTEXT,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    uiAction.property("page")
                        .with("parentType", "com.doublechaintech.model.page.Page");
                    
                    uiAction.property("page")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    uiAction.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    uiAction.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerSection(){
        EntityMeta section = MetaProvider.entity("com.doublechaintech.model.section.Section")
                  
                        .with("features", "root,visible_all")
                  ;
                  section.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    section.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    section.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("title")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    section.property("title")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("brief")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    section.property("brief")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("icon")
                      
                        .with("parent", "string")
                      
                        .with("editor", "imageeditor")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    section.property("icon")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,IMAGE,SEARCHABLE,UPDATE,SAMPLE_DATA,ATTACHMENT,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("displayOrder")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      ;
                    
                    section.property("displayOrder")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("viewGroup")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    section.property("viewGroup")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("linkToUrl")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    section.property("linkToUrl")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    section.property("page")
                        .with("parentType", "com.doublechaintech.model.page.Page");
                    
                    section.property("page")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    section.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    section.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerUserDomain(){
        EntityMeta userDomain = MetaProvider.entity("com.doublechaintech.model.userdomain.UserDomain")
                  
                        .with("features", "ootb,no_sample_data,iam")
                  
                        .with("zh_CN", "用户域")
                  ;
                  userDomain.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,DELETE,PERSISTENCE,VIEWDETAIL,IAM,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    userDomain.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    userDomain.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userDomain.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    userDomain.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userDomain.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    userDomain.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerUserAllowList(){
        EntityMeta userAllowList = MetaProvider.entity("com.doublechaintech.model.userallowlist.UserAllowList")
                  
                        .with("features", "syssetting")
                  
                        .with("zh_CN", "用户权限列表")
                  ;
                  userAllowList.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,PREFERENCE,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    userAllowList.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    userAllowList.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userAllowList.property("userIdentity")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "用户标识")
                      ;
                    
                    userAllowList.property("userIdentity")
                        .with("tokens", "SEARCH,MOBILE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userAllowList.property("userSpecialFunctions")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "用户特权")
                      ;
                    
                    userAllowList.property("userSpecialFunctions")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userAllowList.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    userAllowList.property("domain")
                        .with("parentType", "com.doublechaintech.model.userdomain.UserDomain");
                    
                    userAllowList.property("domain")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,DELETE,PERSISTENCE,VIEWDETAIL,IAM,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userAllowList.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    userAllowList.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerSecUser(){
        EntityMeta secUser = MetaProvider.entity("com.doublechaintech.model.secuser.SecUser")
                  
                        .with("identified_by", "login,email,mobile")
                  
                        .with("features", "ootb,custom_manager")
                  
                        .with("zh_CN", "安全用户")
                  ;
                  secUser.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    secUser.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    secUser.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("login")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "登录名")
                      ;
                    
                    secUser.property("login")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "手机")
                      ;
                    
                    secUser.property("mobile")
                        .with("tokens", "SEARCH,MOBILE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("email")
                      
                        .with("parent", "string")
                      
                        .with("editor", "emaileditor")
                      
                        .with("features", "root,visible_all,string,email")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "邮箱")
                      ;
                    
                    secUser.property("email")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,VIEWDETAIL,STRING,EMAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("pwd")
                      
                        .with("parent", "string")
                      
                        .with("editor", "passwordeditor")
                      
                        .with("features", "root,visible_all,string,password")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "密码")
                      ;
                    
                    secUser.property("pwd")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,PASSWORD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("weixinOpenid")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "微信openId")
                      ;
                    
                    secUser.property("weixinOpenid")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("weixinAppid")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "微信应用ID")
                      ;
                    
                    secUser.property("weixinAppid")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("accessToken")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "访问令牌")
                      ;
                    
                    secUser.property("accessToken")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("verificationCode")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      
                        .with("zh_CN", "验证码")
                      ;
                    
                    secUser.property("verificationCode")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("verificationCodeExpire")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "验证码有效期")
                      ;
                    
                    secUser.property("verificationCodeExpire")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    
                    secUser.property("lastLoginTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    secUser.property("domain")
                        .with("parentType", "com.doublechaintech.model.userdomain.UserDomain");
                    
                    secUser.property("domain")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,DELETE,PERSISTENCE,VIEWDETAIL,IAM,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    secUser.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    secUser.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerUserApp(){
        EntityMeta userApp = MetaProvider.entity("com.doublechaintech.model.userapp.UserApp")
                  
                        .with("features", "ootb,custom_manager")
                  
                        .with("zh_CN", "应用")
                  ;
                  userApp.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    userApp.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    userApp.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("title")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "标题")
                      ;
                    
                    userApp.property("title")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    userApp.property("secUser")
                        .with("parentType", "com.doublechaintech.model.secuser.SecUser");
                    
                    userApp.property("secUser")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("appIcon")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "图标")
                      ;
                    
                    userApp.property("appIcon")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("fullAccess")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "完全访问")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    userApp.property("fullAccess")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("permission")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "权限")
                      ;
                    
                    userApp.property("permission")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("appType")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "对象类型")
                      ;
                    
                    userApp.property("appType")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("appId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "对象ID")
                      ;
                    
                    userApp.property("appId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("ctxType")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "上下文类型")
                      ;
                    
                    userApp.property("ctxType")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("ctxId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "上下文类型")
                      ;
                    
                    userApp.property("ctxId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("location")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "位置")
                      ;
                    
                    userApp.property("location")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    userApp.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    userApp.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerQuickLink(){
        EntityMeta quickLink = MetaProvider.entity("com.doublechaintech.model.quicklink.QuickLink")
                  
                        .with("features", "ootb")
                  ;
                  quickLink.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    quickLink.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    quickLink.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    quickLink.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("icon")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    quickLink.property("icon")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("imagePath")
                      
                        .with("parent", "string")
                      
                        .with("editor", "imageeditor")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    quickLink.property("imagePath")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,IMAGE,SEARCHABLE,UPDATE,SAMPLE_DATA,ATTACHMENT,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("linkTarget")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      ;
                    
                    quickLink.property("linkTarget")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("searcheditor", "daterangepicker")
                      ;
                    
                    quickLink.property("createTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("app")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "应用")
                      ;
                    
                    quickLink.property("app")
                        .with("parentType", "com.doublechaintech.model.userapp.UserApp");
                    
                    quickLink.property("app")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    quickLink.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    quickLink.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerListAccess(){
        EntityMeta listAccess = MetaProvider.entity("com.doublechaintech.model.listaccess.ListAccess")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "列表访问控制")
                  ;
                  listAccess.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    listAccess.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    listAccess.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "名称")
                      ;
                    
                    listAccess.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("internalName")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "内部名称")
                      ;
                    
                    listAccess.property("internalName")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("readPermission")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可读")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    listAccess.property("readPermission")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("createPermission")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可创建")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    listAccess.property("createPermission")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("deletePermission")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可删除")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    listAccess.property("deletePermission")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("updatePermission")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可更新")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    listAccess.property("updatePermission")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("executionPermission")
                      
                        .with("editor", "booleaneditor")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可执行")
                      
                        .with("ignoreChecker", "true")
                      ;
                    
                    listAccess.property("executionPermission")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,BOOL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("app")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "应用")
                      ;
                    
                    listAccess.property("app")
                        .with("parentType", "com.doublechaintech.model.userapp.UserApp");
                    
                    listAccess.property("app")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    listAccess.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    listAccess.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerLoginHistory(){
        EntityMeta loginHistory = MetaProvider.entity("com.doublechaintech.model.loginhistory.LoginHistory")
                  
                        .with("features", "syslog")
                  
                        .with("zh_CN", "登录历史")
                  ;
                  loginHistory.with("tokens", "SEARCH,VISIBLE_CHILD,PERSISTENCE,LOG,SEARCHABLE,VIEWDETAIL,SAMPLE_DATA,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    loginHistory.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    loginHistory.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    loginHistory.property("loginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "登录时间")
                      ;
                    
                    loginHistory.property("loginTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    loginHistory.property("fromIp")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "来自IP")
                      ;
                    
                    loginHistory.property("fromIp")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    loginHistory.property("description")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "描述")
                      ;
                    
                    loginHistory.property("description")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    loginHistory.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    loginHistory.property("secUser")
                        .with("parentType", "com.doublechaintech.model.secuser.SecUser");
                    
                    loginHistory.property("secUser")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    loginHistory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    loginHistory.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerCandidateContainer(){
        EntityMeta candidateContainer = MetaProvider.entity("com.doublechaintech.model.candidatecontainer.CandidateContainer")
                  
                        .with("features", "internal,ootb")
                  
                        .with("zh_CN", "候选容器")
                  ;
                  candidateContainer.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    candidateContainer.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    candidateContainer.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateContainer.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "名称")
                      ;
                    
                    candidateContainer.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateContainer.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    candidateContainer.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerCandidateElement(){
        EntityMeta candidateElement = MetaProvider.entity("com.doublechaintech.model.candidateelement.CandidateElement")
                  
                        .with("features", "internal,ootb")
                  ;
                  candidateElement.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    candidateElement.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    candidateElement.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateElement.property("name")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "标题")
                      ;
                    
                    candidateElement.property("name")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateElement.property("type")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "类型")
                      ;
                    
                    candidateElement.property("type")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateElement.property("image")
                      
                        .with("parent", "string")
                      
                        .with("editor", "imageeditor")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "图像")
                      ;
                    
                    candidateElement.property("image")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,IMAGE,SEARCHABLE,UPDATE,SAMPLE_DATA,ATTACHMENT,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateElement.property("container")
                      
                        .with("features", "internal,ootb")
                      
                        .with("zh_CN", "容器")
                      ;
                    
                    candidateElement.property("container")
                        .with("parentType", "com.doublechaintech.model.candidatecontainer.CandidateContainer");
                    
                    candidateElement.property("container")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    candidateElement.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    candidateElement.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerWechatWorkappIdentity(){
        EntityMeta wechatWorkappIdentity = MetaProvider.entity("com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "企业微信认证")
                  ;
                  wechatWorkappIdentity.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    wechatWorkappIdentity.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    wechatWorkappIdentity.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatWorkappIdentity.property("corpId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "公司")
                      ;
                    
                    wechatWorkappIdentity.property("corpId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatWorkappIdentity.property("userId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "用户")
                      ;
                    
                    wechatWorkappIdentity.property("userId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatWorkappIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    wechatWorkappIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.model.secuser.SecUser");
                    
                    wechatWorkappIdentity.property("secUser")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatWorkappIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    
                    wechatWorkappIdentity.property("createTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatWorkappIdentity.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    
                    wechatWorkappIdentity.property("lastLoginTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatWorkappIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    wechatWorkappIdentity.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerWechatMiniappIdentity(){
        EntityMeta wechatMiniappIdentity = MetaProvider.entity("com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "微信小程序认证")
                  ;
                  wechatMiniappIdentity.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    wechatMiniappIdentity.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    wechatMiniappIdentity.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("openId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "openId")
                      ;
                    
                    wechatMiniappIdentity.property("openId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("appId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "应用ID")
                      ;
                    
                    wechatMiniappIdentity.property("appId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("unionId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "UnionID")
                      ;
                    
                    wechatMiniappIdentity.property("unionId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    wechatMiniappIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.model.secuser.SecUser");
                    
                    wechatMiniappIdentity.property("secUser")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    
                    wechatMiniappIdentity.property("createTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    
                    wechatMiniappIdentity.property("lastLoginTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    wechatMiniappIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    wechatMiniappIdentity.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerKeyPairIdentity(){
        EntityMeta keyPairIdentity = MetaProvider.entity("com.doublechaintech.model.keypairidentity.KeyPairIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "秘钥对认证")
                  ;
                  keyPairIdentity.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    keyPairIdentity.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    keyPairIdentity.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    keyPairIdentity.property("publicKey")
                      
                        .with("parent", "string_longtext")
                      
                        .with("type", "string_longtext")
                      
                        .with("features", "root,visible_all,string,longtext")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "公钥")
                      ;
                    
                    keyPairIdentity.property("publicKey")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,LONGTEXT,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    keyPairIdentity.property("keyType")
                      
                        .with("features", "root,visible_all")
                      
                        .with("zh_CN", "秘钥类型")
                      ;
                    
                    keyPairIdentity.property("keyType")
                        .with("parentType", "com.doublechaintech.model.publickeytype.PublicKeyType");
                    
                    keyPairIdentity.property("keyType")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    keyPairIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb,custom_manager")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    keyPairIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.model.secuser.SecUser");
                    
                    keyPairIdentity.property("secUser")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    keyPairIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("editor", "datepicker")
                      
                        .with("features", "root,visible_all,date,search_between,search_before,search_after,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("searcheditor", "daterangepicker")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    
                    keyPairIdentity.property("createTime")
                        .with("tokens", "SEARCH,DATE,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SEARCH_BEFORE,SEARCH_AFTER,SAMPLE_DATA,DATE_TIME,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    keyPairIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    keyPairIdentity.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerPublicKeyType(){
        EntityMeta publicKeyType = MetaProvider.entity("com.doublechaintech.model.publickeytype.PublicKeyType")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "公钥类型")
                  ;
                  publicKeyType.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    publicKeyType.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    publicKeyType.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    publicKeyType.property("keyAlg")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "加密算法")
                      ;
                    
                    publicKeyType.property("keyAlg")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    publicKeyType.property("signAlg")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "签名算法")
                      ;
                    
                    publicKeyType.property("signAlg")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    publicKeyType.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    publicKeyType.property("domain")
                        .with("parentType", "com.doublechaintech.model.userdomain.UserDomain");
                    
                    publicKeyType.property("domain")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,DELETE,PERSISTENCE,VIEWDETAIL,IAM,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    publicKeyType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    publicKeyType.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }

    public void  registerTreeNode(){
        EntityMeta treeNode = MetaProvider.entity("com.doublechaintech.model.treenode.TreeNode")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "节点")
                  ;
                  treeNode.with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");
                  
                    treeNode.property("id")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("type", "string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("value", "AB")
                      
                        .with("parent", "string")
                      
                        .with("ui_ignore", "true")
                      ;
                    
                    treeNode.property("id")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,IDENTIFIER,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    treeNode.property("nodeId")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "节点ID")
                      ;
                    
                    treeNode.property("nodeId")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    treeNode.property("nodeType")
                      
                        .with("editor", "defaulteditor")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("searcheditor", "defaulteditor")
                      
                        .with("zh_CN", "节点类型")
                      ;
                    
                    treeNode.property("nodeType")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,STRING,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    treeNode.property("leftValue")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      
                        .with("zh_CN", "左值")
                      ;
                    
                    treeNode.property("leftValue")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    treeNode.property("rightValue")
                      
                        .with("parent", "number")
                      
                        .with("editor", "numbereditor")
                      
                        .with("features", "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
                      
                        .with("zh_CN", "右值")
                      ;
                    
                    treeNode.property("rightValue")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,SEARCH_LESS_THAN,DELETE,PERSISTENCE,SEARCH_BETWEEN,VIEWDETAIL,NUMBER,SEARCH_GREATER_THAN,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
                    treeNode.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    treeNode.property("version")
                        .with("tokens", "SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,INT,SAMPLE_DATA,DELETE,PERSISTENCE,ENTITY_BASE,VIEWDETAIL,VERSION,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT");

                    
                  
    }


}

















