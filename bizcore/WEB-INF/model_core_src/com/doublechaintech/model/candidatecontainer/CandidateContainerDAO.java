
package com.doublechaintech.model.candidatecontainer;
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

import com.doublechaintech.model.candidateelement.CandidateElement;

import com.doublechaintech.model.candidateelement.CandidateElementDAO;


public interface CandidateContainerDAO extends BaseDAO{

	public SmartList<CandidateContainer> loadAll();
	public Stream<CandidateContainer> loadAllAsStream();
	public CandidateContainer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CandidateContainer> candidateContainerList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public CandidateContainer present(CandidateContainer candidateContainer,Map<String,Object> options) throws Exception;
	public CandidateContainer clone(String id, Map<String,Object> options) throws Exception;

	

	public CandidateContainer save(CandidateContainer candidateContainer,Map<String,Object> options);
	public SmartList<CandidateContainer> saveCandidateContainerList(SmartList<CandidateContainer> candidateContainerList,Map<String,Object> options);
	public SmartList<CandidateContainer> removeCandidateContainerList(SmartList<CandidateContainer> candidateContainerList,Map<String,Object> options);
	public SmartList<CandidateContainer> findCandidateContainerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCandidateContainerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCandidateContainerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);

	public CandidateContainer disconnectFromAll(String candidateContainerId, int version) throws Exception;
	public void resetNextId();

	public CandidateElementDAO getCandidateElementDAO();
		
	
 	public SmartList<CandidateContainer> requestCandidateCandidateContainerForCandidateElement(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CandidateContainer planToRemoveCandidateElementList(CandidateContainer candidateContainer, String candidateElementIds[], Map<String,Object> options)throws Exception;



	public SmartList<CandidateContainer> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<CandidateContainer> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateCandidateContainer executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	

	List<CandidateContainer> search(CandidateContainerRequest pRequest);
}


