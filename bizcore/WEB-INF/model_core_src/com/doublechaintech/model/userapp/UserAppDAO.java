
package com.doublechaintech.model.userapp;
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

import com.doublechaintech.model.listaccess.ListAccess;
import com.doublechaintech.model.secuser.SecUser;
import com.doublechaintech.model.quicklink.QuickLink;

import com.doublechaintech.model.listaccess.ListAccessDAO;
import com.doublechaintech.model.quicklink.QuickLinkDAO;
import com.doublechaintech.model.secuser.SecUserDAO;


public interface UserAppDAO extends BaseDAO{

	public SmartList<UserApp> loadAll();
	public Stream<UserApp> loadAllAsStream();
	public UserApp load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserApp> userAppList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public UserApp present(UserApp userApp,Map<String,Object> options) throws Exception;
	public UserApp clone(String id, Map<String,Object> options) throws Exception;

	

	public UserApp save(UserApp userApp,Map<String,Object> options);
	public SmartList<UserApp> saveUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> removeUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> findUserAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);

	public UserApp disconnectFromAll(String userAppId, int version) throws Exception;
	public void resetNextId();

	public QuickLinkDAO getQuickLinkDAO();
		
	public ListAccessDAO getListAccessDAO();
		
	
 	public SmartList<UserApp> requestCandidateUserAppForQuickLink(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserApp> requestCandidateUserAppForListAccess(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserApp planToRemoveQuickLinkList(UserApp userApp, String quickLinkIds[], Map<String,Object> options)throws Exception;


	public UserApp planToRemoveListAccessList(UserApp userApp, String listAccessIds[], Map<String,Object> options)throws Exception;



	public SmartList<UserApp> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<UserApp> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateUserApp executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public int countUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countUserAppBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAppBySecUser(SmartList<UserApp> resultList, String secUserId, Map<String,Object> options);


 
	
	

	List<UserApp> search(UserAppRequest pRequest);
}


