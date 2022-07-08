
package com.doublechaintech.model.slide;
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




public interface SlideManager extends BaseManager{

		

  List<Slide> searchSlideList(ModelUserContext ctx, SlideRequest pRequest);
  Slide searchSlide(ModelUserContext ctx, SlideRequest pRequest);
	public Slide createSlide(ModelUserContext userContext, String name,int displayOrder,String imageUrl,String videoUrl,String linkToUrl,String pageId) throws Exception;
	public Slide updateSlide(ModelUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Slide loadSlide(ModelUserContext userContext, String slideId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public Slide internalSaveSlide(ModelUserContext userContext, Slide slide) throws Exception;
	public Slide internalSaveSlide(ModelUserContext userContext, Slide slide,Map<String,Object>option) throws Exception;

	public Slide transferToAnotherPage(ModelUserContext userContext, String slideId, String anotherPageId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, Slide newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, Slide updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(ModelUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(ModelUserContext userContext,String pageId, int start, int count) throws Exception;
  




}


