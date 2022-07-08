
package com.doublechaintech.model.page;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.model.BaseDAO;
import com.doublechaintech.model.BaseEntity;
import com.doublechaintech.model.SmartList;
import com.doublechaintech.model.MultipleAccessKey;
import com.doublechaintech.model.ModelUserContext;

import com.doublechaintech.model.pagetype.PageType;
import com.doublechaintech.model.slide.Slide;
import com.doublechaintech.model.section.Section;
import com.doublechaintech.model.mobileapp.MobileApp;
import com.doublechaintech.model.uiaction.UiAction;

import com.doublechaintech.model.slide.SlideDAO;
import com.doublechaintech.model.uiaction.UiActionDAO;
import com.doublechaintech.model.mobileapp.MobileAppDAO;
import com.doublechaintech.model.section.SectionDAO;
import com.doublechaintech.model.pagetype.PageTypeDAO;


public interface PageDAO extends BaseDAO{

	public SmartList<Page> loadAll();
	public Stream<Page> loadAllAsStream();
	public Page load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Page> pageList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Page present(Page page,Map<String,Object> options) throws Exception;
	public Page clone(String id, Map<String,Object> options) throws Exception;

	

	public Page save(Page page,Map<String,Object> options);
	public SmartList<Page> savePageList(SmartList<Page> pageList,Map<String,Object> options);
	public SmartList<Page> removePageList(SmartList<Page> pageList,Map<String,Object> options);
	public SmartList<Page> findPageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);

	public Page disconnectFromAll(String pageId, int version) throws Exception;
	public void resetNextId();

	public SlideDAO getSlideDAO();
		
	public UiActionDAO getUiActionDAO();
		
	public SectionDAO getSectionDAO();
		
	
 	public SmartList<Page> requestCandidatePageForSlide(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Page> requestCandidatePageForUiAction(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Page> requestCandidatePageForSection(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Page planToRemoveSlideList(Page page, String slideIds[], Map<String,Object> options)throws Exception;


	public Page planToRemoveUiActionList(Page page, String uiActionIds[], Map<String,Object> options)throws Exception;


	public Page planToRemoveSectionList(Page page, String sectionIds[], Map<String,Object> options)throws Exception;



	public SmartList<Page> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<Page> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidatePage executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Page> findPageByPageType(String pageTypeId, Map<String,Object> options);
 	public int countPageByPageType(String pageTypeId, Map<String,Object> options);
 	public Map<String, Integer> countPageByPageTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Page> findPageByPageType(String pageTypeId, int start, int count, Map<String,Object> options);
 	public void analyzePageByPageType(SmartList<Page> resultList, String pageTypeId, Map<String,Object> options);


 
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, Map<String,Object> options);
 	public int countPageByMobileApp(String mobileAppId, Map<String,Object> options);
 	public Map<String, Integer> countPageByMobileAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<Page> findPageByMobileApp(String mobileAppId, int start, int count, Map<String,Object> options);
 	public void analyzePageByMobileApp(SmartList<Page> resultList, String mobileAppId, Map<String,Object> options);


 
	
	
	

	List<Page> search(PageRequest pRequest);
}


