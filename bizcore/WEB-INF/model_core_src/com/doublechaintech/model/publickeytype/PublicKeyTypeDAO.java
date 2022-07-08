
package com.doublechaintech.model.publickeytype;
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

import com.doublechaintech.model.userdomain.UserDomain;
import com.doublechaintech.model.keypairidentity.KeyPairIdentity;

import com.doublechaintech.model.userdomain.UserDomainDAO;
import com.doublechaintech.model.keypairidentity.KeyPairIdentityDAO;


public interface PublicKeyTypeDAO extends BaseDAO{

	public SmartList<PublicKeyType> loadAll();
	public Stream<PublicKeyType> loadAllAsStream();
	public PublicKeyType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PublicKeyType> publicKeyTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public PublicKeyType present(PublicKeyType publicKeyType,Map<String,Object> options) throws Exception;
	public PublicKeyType clone(String id, Map<String,Object> options) throws Exception;

	

	public PublicKeyType save(PublicKeyType publicKeyType,Map<String,Object> options);
	public SmartList<PublicKeyType> savePublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList,Map<String,Object> options);
	public SmartList<PublicKeyType> removePublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList,Map<String,Object> options);
	public SmartList<PublicKeyType> findPublicKeyTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPublicKeyTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPublicKeyTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);

	public PublicKeyType disconnectFromAll(String publicKeyTypeId, int version) throws Exception;
	public void resetNextId();

	public KeyPairIdentityDAO getKeyPairIdentityDAO();
		
	
 	public SmartList<PublicKeyType> requestCandidatePublicKeyTypeForKeyPairIdentity(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PublicKeyType planToRemoveKeyPairIdentityList(PublicKeyType publicKeyType, String keyPairIdentityIds[], Map<String,Object> options)throws Exception;


	//disconnect PublicKeyType with sec_user in KeyPairIdentity
	public PublicKeyType planToRemoveKeyPairIdentityListWithSecUser(PublicKeyType publicKeyType, String secUserId, Map<String,Object> options)throws Exception;
	public int countKeyPairIdentityListWithSecUser(String publicKeyTypeId, String secUserId, Map<String,Object> options)throws Exception;
	

	public SmartList<PublicKeyType> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<PublicKeyType> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidatePublicKeyType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<PublicKeyType> findPublicKeyTypeByDomain(String userDomainId, Map<String,Object> options);
 	public int countPublicKeyTypeByDomain(String userDomainId, Map<String,Object> options);
 	public Map<String, Integer> countPublicKeyTypeByDomainIds(String[] ids, Map<String,Object> options);
 	public SmartList<PublicKeyType> findPublicKeyTypeByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 	public void analyzePublicKeyTypeByDomain(SmartList<PublicKeyType> resultList, String userDomainId, Map<String,Object> options);


 
	

	List<PublicKeyType> search(PublicKeyTypeRequest pRequest);
}


