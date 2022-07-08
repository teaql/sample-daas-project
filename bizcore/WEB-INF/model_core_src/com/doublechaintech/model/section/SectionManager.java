
package com.doublechaintech.model.section;
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




public interface SectionManager extends BaseManager{

		

  List<Section> searchSectionList(ModelUserContext ctx, SectionRequest pRequest);
  Section searchSection(ModelUserContext ctx, SectionRequest pRequest);
	public Section createSection(ModelUserContext userContext, String title,String brief,String icon,int displayOrder,String viewGroup,String linkToUrl,String pageId) throws Exception;
	public Section updateSection(ModelUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Section loadSection(ModelUserContext userContext, String sectionId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public Section internalSaveSection(ModelUserContext userContext, Section section) throws Exception;
	public Section internalSaveSection(ModelUserContext userContext, Section section,Map<String,Object>option) throws Exception;

	public Section transferToAnotherPage(ModelUserContext userContext, String sectionId, String anotherPageId)  throws Exception;
 



	public void onNewInstanceCreated(ModelUserContext userContext, Section newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, Section updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(ModelUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(ModelUserContext userContext,String pageId, int start, int count) throws Exception;
  




}


