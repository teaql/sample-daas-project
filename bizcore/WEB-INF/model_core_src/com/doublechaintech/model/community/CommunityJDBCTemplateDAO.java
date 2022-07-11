package com.doublechaintech.model.community;

import com.doublechaintech.model.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.model.ModelBaseDAOImpl;
import com.doublechaintech.model.BaseEntity;
import com.doublechaintech.model.SmartList;
import com.doublechaintech.model.AccessKey;
import com.doublechaintech.model.DateKey;
import com.doublechaintech.model.StatsInfo;
import com.doublechaintech.model.StatsItem;

import com.doublechaintech.model.MultipleAccessKey;
import com.doublechaintech.model.ModelUserContext;

import com.doublechaintech.model.family.Family;

import com.doublechaintech.model.family.FamilyDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class CommunityJDBCTemplateDAO extends ModelBaseDAOImpl implements CommunityDAO {

  protected FamilyDAO familyDAO;

  public void setFamilyDAO(FamilyDAO familyDAO) {

    if (familyDAO == null) {
      throw new IllegalStateException("Do not try to set familyDAO to null.");
    }
    this.familyDAO = familyDAO;
  }

  public FamilyDAO getFamilyDAO() {
    if (this.familyDAO == null) {
      throw new IllegalStateException(
          "The familyDAO is not configured yet, please config it some where.");
    }

    return this.familyDAO;
  }

  /*
  protected Community load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalCommunity(accessKey, options);
  }
  */

  public SmartList<Community> loadAll() {
    return this.loadAll(getCommunityMapper());
  }

  public Stream<Community> loadAllAsStream() {
    return this.loadAllAsStream(getCommunityMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public Community load(String id, Map<String, Object> options) throws Exception {
    return loadInternalCommunity(CommunityTable.withId(id), options);
  }

  public Community save(Community community, Map<String, Object> options) {

    String methodName = "save(Community community,Map<String,Object> options)";

    assertMethodArgumentNotNull(community, methodName, "community");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalCommunity(community, options);
  }

  public Community clone(String communityId, Map<String, Object> options) throws Exception {

    return clone(CommunityTable.withId(communityId), options);
  }

  protected Community clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String communityId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    Community newCommunity = loadInternalCommunity(accessKey, options);
    newCommunity.setVersion(0);

    if (isSaveFamilyListEnabled(options)) {
      for (Family item : newCommunity.getFamilyList()) {
        item.setVersion(0);
      }
    }

    saveInternalCommunity(newCommunity, options);

    return newCommunity;
  }

  protected void throwIfHasException(String communityId, int version, int count) throws Exception {
    if (count == 1) {
      throw new CommunityVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new CommunityNotFoundException(
          "The " + this.getTableName() + "(" + communityId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public Community disconnectFromAll(String communityId, int version) throws Exception {

    Community community = loadInternalCommunity(CommunityTable.withId(communityId), emptyOptions());
    community.clearFromAll();
    this.saveCommunity(community);
    return community;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return CommunityTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "community";
  }

  @Override
  protected String getBeanName() {

    return "community";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return CommunityTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractFamilyListEnabled(Map<String, Object> options) {
    return checkOptions(options, CommunityTokens.FAMILY_LIST);
  }

  protected boolean isAnalyzeFamilyListEnabled(Map<String, Object> options) {
    return CommunityTokens.of(options).analyzeFamilyListEnabled();
  }

  protected boolean isSaveFamilyListEnabled(Map<String, Object> options) {
    return checkOptions(options, CommunityTokens.FAMILY_LIST);
  }

  protected CommunityMapper getCommunityMapper() {
    return new CommunityMapper();
  }

  protected Community extractCommunity(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      Community community = loadSingleObject(accessKey, getCommunityMapper());
      return community;
    } catch (EmptyResultDataAccessException e) {
      throw new CommunityNotFoundException("Community(" + accessKey + ") is not found!");
    }
  }

  protected Community loadInternalCommunity(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    Community community = extractCommunity(accessKey, loadOptions);

    if (isExtractFamilyListEnabled(loadOptions)) {
      extractFamilyList(community, loadOptions);
    }

    if (isAnalyzeFamilyListEnabled(loadOptions)) {
      analyzeFamilyList(community, loadOptions);
    }

    return community;
  }

  protected void enhanceFamilyList(SmartList<Family> familyList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Community extractFamilyList(Community community, Map<String, Object> options) {

    if (community == null) {
      return null;
    }
    if (community.getId() == null) {
      return community;
    }

    SmartList<Family> familyList = getFamilyDAO().findFamilyByCommunity(community.getId(), options);
    if (familyList != null) {
      enhanceFamilyList(familyList, options);
      community.setFamilyList(familyList);
    }

    return community;
  }

  protected Community analyzeFamilyList(Community community, Map<String, Object> options) {

    if (community == null) {
      return null;
    }
    if (community.getId() == null) {
      return community;
    }

    SmartList<Family> familyList = community.getFamilyList();
    if (familyList != null) {
      getFamilyDAO().analyzeFamilyByCommunity(familyList, community.getId(), options);
    }

    return community;
  }

  protected Community saveCommunity(Community community) {

    if (!community.isChanged()) {
      return community;
    }

    Beans.dbUtil().cacheCleanUp(community);
    String SQL = this.getSaveCommunitySQL(community);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveCommunityParameters(community);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    community.incVersion();
    community.afterSave();
    return community;
  }

  public SmartList<Community> saveCommunityList(
      SmartList<Community> communityList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitCommunityList(communityList);

    batchCommunityCreate((List<Community>) lists[CREATE_LIST_INDEX]);
    batchCommunityUpdate((List<Community>) lists[UPDATE_LIST_INDEX]);
    batchCommunityRemove((List<Community>) lists[REMOVE_LIST_INDEX]);
    batchCommunityRecover((List<Community>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (Community community : communityList) {
      if (community.isChanged()) {
        community.incVersion();
        community.afterSave();
      }
    }

    return communityList;
  }

  public SmartList<Community> removeCommunityList(
      SmartList<Community> communityList, Map<String, Object> options) {

    super.removeList(communityList, options);

    return communityList;
  }

  protected List<Object[]> prepareCommunityBatchCreateArgs(List<Community> communityList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Community community : communityList) {
      Object[] parameters = prepareCommunityCreateParameters(community);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareCommunityBatchUpdateArgs(List<Community> communityList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Community community : communityList) {
      if (!community.isChanged()) {
        continue;
      }
      Object[] parameters = prepareCommunityUpdateParameters(community);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareCommunityBatchRecoverArgs(List<Community> communityList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Community community : communityList) {
      if (!community.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(community);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareCommunityBatchRemoveArgs(List<Community> communityList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Community community : communityList) {
      if (!community.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareCommunityRemoveParameters(community);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchCommunityCreate(List<Community> communityList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareCommunityBatchCreateArgs(communityList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchCommunityUpdate(List<Community> communityList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareCommunityBatchUpdateArgs(communityList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchCommunityRemove(List<Community> communityList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareCommunityBatchRemoveArgs(communityList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchCommunityRecover(List<Community> communityList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareCommunityBatchRecoverArgs(communityList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitCommunityList(List<Community> communityList) {

    List<Community> communityCreateList = new ArrayList<Community>();
    List<Community> communityUpdateList = new ArrayList<Community>();
    List<Community> communityRemoveList = new ArrayList<Community>();
    List<Community> communityRecoverList = new ArrayList<Community>();

    for (Community community : communityList) {
      if (community.isToRemove()) {
        communityRemoveList.add(community);
        continue;
      }
      if (community.isToRecover()) {
        communityRecoverList.add(community);
        continue;
      }
      if (isUpdateRequest(community)) {
        if (community.isChanged()) {
          communityUpdateList.add(community);
        }
        continue;
      }

      if (community.isChanged()) {
        communityCreateList.add(community);
      }
    }

    return new Object[] {
      communityCreateList, communityUpdateList, communityRemoveList, communityRecoverList
    };
  }

  protected boolean isUpdateRequest(Community community) {
    return community.getVersion() > 0;
  }

  protected String getSaveCommunitySQL(Community community) {
    if (community.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(community)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveCommunityParameters(Community community) {
    if (community.isToRemove()) {
      return prepareCommunityRemoveParameters(community);
    }
    if (community.isToRecover()) {
      return prepareRecoverParameters(community);
    }

    if (isUpdateRequest(community)) {
      return prepareCommunityUpdateParameters(community);
    }
    return prepareCommunityCreateParameters(community);
  }

  protected Object[] prepareCommunityRemoveParameters(Community community) {
    return super.prepareRemoveParameters(community);
  }

  protected Object[] prepareCommunityUpdateParameters(Community community) {
    Object[] parameters = new Object[5];

    parameters[0] = community.getName();

    parameters[1] = community.getAddress();

    parameters[2] = community.nextVersion();
    parameters[3] = community.getId();
    parameters[4] = community.getVersion();

    return parameters;
  }

  protected Object[] prepareCommunityCreateParameters(Community community) {
    Object[] parameters = new Object[3];
    if (community.getId() == null) {
      String newCommunityId = getNextId();
      community.setId(newCommunityId);
    }
    parameters[0] = community.getId();

    parameters[1] = community.getName();

    parameters[2] = community.getAddress();

    return parameters;
  }

  protected Community saveInternalCommunity(Community community, Map<String, Object> options) {

    saveCommunity(community);

    if (isSaveFamilyListEnabled(options)) {
      saveFamilyList(community, options);
      // removeFamilyList(community, options);
      // Not delete the record

    }

    return community;
  }

  // ======================================================================================

  public Community planToRemoveFamilyList(
      Community community, String familyIds[], Map<String, Object> options) throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(Family.COMMUNITY_PROPERTY, community.getId());
    key.put(Family.ID_PROPERTY, familyIds);

    SmartList<Family> externalFamilyList = getFamilyDAO().findFamilyWithKey(key, options);
    if (externalFamilyList == null) {
      return community;
    }
    if (externalFamilyList.isEmpty()) {
      return community;
    }

    for (Family familyItem : externalFamilyList) {

      familyItem.clearFromAll();
    }

    SmartList<Family> familyList = community.getFamilyList();
    familyList.addAllToRemoveList(externalFamilyList);
    return community;
  }

  protected Community saveFamilyList(Community community, Map<String, Object> options) {

    SmartList<Family> familyList = community.getFamilyList();
    if (familyList == null) {
      // null list means nothing
      return community;
    }
    SmartList<Family> mergedUpdateFamilyList = new SmartList<Family>();

    mergedUpdateFamilyList.addAll(familyList);
    if (familyList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateFamilyList.addAll(familyList.getToRemoveList());
      familyList.removeAll(familyList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getFamilyDAO().saveFamilyList(mergedUpdateFamilyList, options);

    if (familyList.getToRemoveList() != null) {
      familyList.removeAll(familyList.getToRemoveList());
    }

    return community;
  }

  protected Community removeFamilyList(Community community, Map<String, Object> options) {

    SmartList<Family> familyList = community.getFamilyList();
    if (familyList == null) {
      return community;
    }

    SmartList<Family> toRemoveFamilyList = familyList.getToRemoveList();

    if (toRemoveFamilyList == null) {
      return community;
    }
    if (toRemoveFamilyList.isEmpty()) {
      return community; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getFamilyDAO().removeFamilyList(toRemoveFamilyList, options);

    return community;
  }

  public Community present(Community community, Map<String, Object> options) {

    presentFamilyList(community, options);

    return community;
  }

  // Using java8 feature to reduce the code significantly
  protected Community presentFamilyList(Community community, Map<String, Object> options) {

    SmartList<Family> familyList = community.getFamilyList();
    SmartList<Family> newList =
        presentSubList(
            community.getId(),
            familyList,
            options,
            getFamilyDAO()::countFamilyByCommunity,
            getFamilyDAO()::findFamilyByCommunity);

    community.setFamilyList(newList);

    return community;
  }

  public SmartList<Community> requestCandidateCommunityForFamily(
      ModelUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        CommunityTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getCommunityMapper());
  }

  protected String getTableName() {
    return CommunityTable.TABLE_NAME;
  }

  public void enhanceList(List<Community> communityList) {
    this.enhanceListInternal(communityList, this.getCommunityMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<Community> communityList = ownerEntity.collectRefsWithType(Community.INTERNAL_TYPE);
    this.enhanceList(communityList);
  }

  @Override
  public SmartList<Community> findCommunityWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getCommunityMapper());
  }

  @Override
  public int countCommunityWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countCommunityWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<Community> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getCommunityMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<Community> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getCommunityMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateCommunity executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateCommunity result = new CandidateCommunity();
    int pageNo = Math.max(1, query.getPageNo());
    result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
    result.setOwnerId(query.getOwnerId());
    result.setFilterKey(query.getFilterKey());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
    result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

    SmartList candidateList = queryList(sql, parmeters);
    this.alias(candidateList);
    result.setCandidates(candidateList);
    int offSet = (pageNo - 1) * query.getPageSize();
    if (candidateList.size() > query.getPageSize()) {
      result.setTotalPage(pageNo + 1);
    } else {
      result.setTotalPage(pageNo);
    }
    return result;
  }

  public Map<String, Integer> countBySql(String sql, Object[] params) {
    if (params == null || params.length == 0) {
      return new HashMap<>();
    }
    List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
    if (result == null || result.isEmpty()) {
      return new HashMap<>();
    }
    Map<String, Integer> cntMap = new HashMap<>();
    for (Map<String, Object> data : result) {
      String key = String.valueOf(data.get("id"));
      Number value = (Number) data.get("count");
      cntMap.put(key, value.intValue());
    }
    this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
    return cntMap;
  }

  public Integer singleCountBySql(String sql, Object[] params) {
    Integer cnt = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
    logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
    return cnt;
  }

  public BigDecimal summaryBySql(String sql, Object[] params) {
    BigDecimal cnt = this.getJdbcTemplate().queryForObject(sql, params, BigDecimal.class);
    logSQLAndParameters("summaryBySql", sql, params, cnt + "");
    return cnt == null ? BigDecimal.ZERO : cnt;
  }

  public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
    List<T> result = this.getJdbcTemplate().queryForList(sql, params, claxx);
    logSQLAndParameters("queryForList", sql, params, result.size() + " items");
    return result;
  }

  public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
    Map<String, Object> result = null;
    try {
      result = this.getJdbcTemplate().queryForMap(sql, params);
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
      // 空结果，返回null
    }
    logSQLAndParameters(
        "queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
    return result;
  }

  public <T> T queryForObject(String sql, Object[] params, Class<T> claxx)
      throws DataAccessException {
    T result = null;
    try {
      result = this.getJdbcTemplate().queryForObject(sql, params, claxx);
    } catch (org.springframework.dao.EmptyResultDataAccessException e) {
      // 空结果，返回null
    }
    logSQLAndParameters(
        "queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
    return result;
  }

  public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
    List<Map<String, Object>> result = getJdbcTemplate().queryForList(sql, params);
    logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
    return result;
  }

  public synchronized int updateBySql(String sql, Object[] params) {
    int result = getJdbcTemplate().update(sql, params);
    logSQLAndParameters("updateBySql", sql, params, result + " items");
    return result;
  }

  public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
    getJdbcTemplate().query(sql, args, callback);
  }

  public void executeSql(String sql) {
    logSQLAndParameters("executeSql", sql, new Object[] {}, "");
    getJdbcTemplate().execute(sql);
  }

  @Override
  public List<Community> search(CommunityRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected CommunityMapper mapper() {
    return getCommunityMapper();
  }

  @Override
  protected CommunityMapper mapperForClazz(Class<?> clazz) {
    return CommunityMapper.mapperForClass(clazz);
  }
}
