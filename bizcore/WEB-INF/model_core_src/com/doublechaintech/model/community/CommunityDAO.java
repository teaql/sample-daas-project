
package com.doublechaintech.model.community;
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

import com.doublechaintech.model.family.Family;

import com.doublechaintech.model.family.FamilyDAO;


public interface CommunityDAO extends BaseDAO{

	public SmartList<Community> loadAll();
	public Stream<Community> loadAllAsStream();
	public Community load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Community> communityList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Community present(Community community,Map<String,Object> options) throws Exception;
	public Community clone(String id, Map<String,Object> options) throws Exception;

	

	public Community save(Community community,Map<String,Object> options);
	public SmartList<Community> saveCommunityList(SmartList<Community> communityList,Map<String,Object> options);
	public SmartList<Community> removeCommunityList(SmartList<Community> communityList,Map<String,Object> options);
	public SmartList<Community> findCommunityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCommunityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCommunityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);

	public Community disconnectFromAll(String communityId, int version) throws Exception;
	public void resetNextId();

	public FamilyDAO getFamilyDAO();
		
	
 	public SmartList<Community> requestCandidateCommunityForFamily(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Community planToRemoveFamilyList(Community community, String familyIds[], Map<String,Object> options)throws Exception;



	public SmartList<Community> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<Community> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateCommunity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	

	List<Community> search(CommunityRequest pRequest);
}


