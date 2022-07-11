package com.doublechaintech.model.family;

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

import com.doublechaintech.model.community.Community;
import com.doublechaintech.model.kid.Kid;

import com.doublechaintech.model.community.CommunityDAO;
import com.doublechaintech.model.kid.KidDAO;

public interface FamilyDAO extends BaseDAO {

  public SmartList<Family> loadAll();

  public Stream<Family> loadAllAsStream();

  public Family load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<Family> familyList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public Family present(Family family, Map<String, Object> options) throws Exception;

  public Family clone(String id, Map<String, Object> options) throws Exception;

  public Family save(Family family, Map<String, Object> options);

  public SmartList<Family> saveFamilyList(
      SmartList<Family> familyList, Map<String, Object> options);

  public SmartList<Family> removeFamilyList(
      SmartList<Family> familyList, Map<String, Object> options);

  public SmartList<Family> findFamilyWithKey(MultipleAccessKey key, Map<String, Object> options);

  public int countFamilyWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countFamilyWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public Family disconnectFromAll(String familyId, int version) throws Exception;

  public void resetNextId();

  public KidDAO getKidDAO();

  public SmartList<Family> requestCandidateFamilyForKid(
      ModelUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public Family planToRemoveKidList(Family family, String kidIds[], Map<String, Object> options)
      throws Exception;

  public SmartList<Family> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<Family> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateFamily executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<Family> findFamilyByCommunity(String communityId, Map<String, Object> options);

  public int countFamilyByCommunity(String communityId, Map<String, Object> options);

  public Map<String, Integer> countFamilyByCommunityIds(String[] ids, Map<String, Object> options);

  public SmartList<Family> findFamilyByCommunity(
      String communityId, int start, int count, Map<String, Object> options);

  public void analyzeFamilyByCommunity(
      SmartList<Family> resultList, String communityId, Map<String, Object> options);

  List<Family> search(FamilyRequest pRequest);
}
