package com.doublechaintech.model.userallowlist;

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

import com.doublechaintech.model.userdomain.UserDomainDAO;

public interface UserAllowListDAO extends BaseDAO {

  public SmartList<UserAllowList> loadAll();

  public Stream<UserAllowList> loadAllAsStream();

  public UserAllowList load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<UserAllowList> userAllowListList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public UserAllowList present(UserAllowList userAllowList, Map<String, Object> options)
      throws Exception;

  public UserAllowList clone(String id, Map<String, Object> options) throws Exception;

  public UserAllowList save(UserAllowList userAllowList, Map<String, Object> options);

  public SmartList<UserAllowList> saveUserAllowListList(
      SmartList<UserAllowList> userAllowListList, Map<String, Object> options);

  public SmartList<UserAllowList> removeUserAllowListList(
      SmartList<UserAllowList> userAllowListList, Map<String, Object> options);

  public SmartList<UserAllowList> findUserAllowListWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countUserAllowListWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countUserAllowListWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public UserAllowList disconnectFromAll(String userAllowListId, int version) throws Exception;

  public void resetNextId();

  public SmartList<UserAllowList> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<UserAllowList> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateUserAllowList executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<UserAllowList> findUserAllowListByDomain(
      String userDomainId, Map<String, Object> options);

  public int countUserAllowListByDomain(String userDomainId, Map<String, Object> options);

  public Map<String, Integer> countUserAllowListByDomainIds(
      String[] ids, Map<String, Object> options);

  public SmartList<UserAllowList> findUserAllowListByDomain(
      String userDomainId, int start, int count, Map<String, Object> options);

  public void analyzeUserAllowListByDomain(
      SmartList<UserAllowList> resultList, String userDomainId, Map<String, Object> options);

  List<UserAllowList> search(UserAllowListRequest pRequest);
}
