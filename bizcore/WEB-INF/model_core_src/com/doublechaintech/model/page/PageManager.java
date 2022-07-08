
package com.doublechaintech.model.page;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.model.ModelUserContext;
import com.doublechaintech.model.BaseEntity;
import com.doublechaintech.model.BaseManager;
import com.doublechaintech.model.SmartList;




public interface PageManager extends BaseManager{

		

  List<Page> searchPageList(ModelUserContext ctx, PageRequest pRequest);
  Page searchPage(ModelUserContext ctx, PageRequest pRequest);
	public Page createPage(ModelUserContext userContext, String pageTitle,String linkToUrl,String pageTypeId,int displayOrder,String mobileAppId) throws Exception;
	public Page updatePage(ModelUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Page loadPage(ModelUserContext userContext, String pageId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public Page internalSavePage(ModelUserContext userContext, Page page) throws Exception;
	public Page internalSavePage(ModelUserContext userContext, Page page,Map<String,Object>option) throws Exception;

	public Page transferToAnotherPageType(ModelUserContext userContext, String pageId, String anotherPageTypeId)  throws Exception;
 	public Page transferToAnotherMobileApp(ModelUserContext userContext, String pageId, String anotherMobileAppId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, Page newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, Page updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SlideManager getSlideManager(ModelUserContext userContext, String pageId, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSlide(ModelUserContext userContext, String pageId, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSlide(ModelUserContext userContext, String pageId, String slideId, int slideVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSlide(ModelUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UiActionManager getUiActionManager(ModelUserContext userContext, String pageId, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData ,String [] tokensExpr)  throws Exception;

	public  Page addUiAction(ModelUserContext userContext, String pageId, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData , String [] tokensExpr)  throws Exception;
	public  Page removeUiAction(ModelUserContext userContext, String pageId, String uiActionId, int uiActionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateUiAction(ModelUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SectionManager getSectionManager(ModelUserContext userContext, String pageId, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSection(ModelUserContext userContext, String pageId, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSection(ModelUserContext userContext, String pageId, String sectionId, int sectionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSection(ModelUserContext userContext, String pageId, String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPageType(ModelUserContext userContext,String pageTypeId) throws Exception;
	public Object listPageByPageType(ModelUserContext userContext,String pageTypeId, int start, int count) throws Exception;
  
	public Object listByMobileApp(ModelUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(ModelUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  




}


