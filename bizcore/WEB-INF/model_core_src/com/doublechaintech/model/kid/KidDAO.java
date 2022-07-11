package com.doublechaintech.model.kid;

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

public interface KidDAO extends BaseDAO {

  public SmartList<Kid> loadAll();

  public Stream<Kid> loadAllAsStream();

  public Kid load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<Kid> kidList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public Kid present(Kid kid, Map<String, Object> options) throws Exception;

  public Kid clone(String id, Map<String, Object> options) throws Exception;

  public Kid save(Kid kid, Map<String, Object> options);

  public SmartList<Kid> saveKidList(SmartList<Kid> kidList, Map<String, Object> options);

  public SmartList<Kid> removeKidList(SmartList<Kid> kidList, Map<String, Object> options);

  public SmartList<Kid> findKidWithKey(MultipleAccessKey key, Map<String, Object> options);

  public int countKidWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countKidWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public Kid disconnectFromAll(String kidId, int version) throws Exception;

  public void resetNextId();

  public SmartList<Kid> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<Kid> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateKid executeCandidatesQuery(CandidateQuery query, String sql, Object... parmeters)
      throws Exception;

  public SmartList<Kid> findKidByFamily(String familyId, Map<String, Object> options);

  public int countKidByFamily(String familyId, Map<String, Object> options);

  public Map<String, Integer> countKidByFamilyIds(String[] ids, Map<String, Object> options);

  public SmartList<Kid> findKidByFamily(
      String familyId, int start, int count, Map<String, Object> options);

  public void analyzeKidByFamily(
      SmartList<Kid> resultList, String familyId, Map<String, Object> options);

  List<Kid> search(KidRequest pRequest);
}
