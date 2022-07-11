package com.doublechaintech.model.mobileapp;

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
import com.doublechaintech.model.page.Page;

import com.doublechaintech.model.page.PageDAO;
import com.doublechaintech.model.pagetype.PageTypeDAO;

public interface MobileAppDAO extends BaseDAO {

  public SmartList<MobileApp> loadAll();

  public Stream<MobileApp> loadAllAsStream();

  public MobileApp load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<MobileApp> mobileAppList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public MobileApp present(MobileApp mobileApp, Map<String, Object> options) throws Exception;

  public MobileApp clone(String id, Map<String, Object> options) throws Exception;

  public MobileApp save(MobileApp mobileApp, Map<String, Object> options);

  public SmartList<MobileApp> saveMobileAppList(
      SmartList<MobileApp> mobileAppList, Map<String, Object> options);

  public SmartList<MobileApp> removeMobileAppList(
      SmartList<MobileApp> mobileAppList, Map<String, Object> options);

  public SmartList<MobileApp> findMobileAppWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countMobileAppWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countMobileAppWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public MobileApp disconnectFromAll(String mobileAppId, int version) throws Exception;

  public void resetNextId();

  public PageDAO getPageDAO();

  public PageTypeDAO getPageTypeDAO();

  public SmartList<MobileApp> requestCandidateMobileAppForPage(
      ModelUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<MobileApp> requestCandidateMobileAppForPageType(
      ModelUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public MobileApp planToRemovePageList(
      MobileApp mobileApp, String pageIds[], Map<String, Object> options) throws Exception;

  // disconnect MobileApp with page_type in Page
  public MobileApp planToRemovePageListWithPageType(
      MobileApp mobileApp, String pageTypeId, Map<String, Object> options) throws Exception;

  public int countPageListWithPageType(
      String mobileAppId, String pageTypeId, Map<String, Object> options) throws Exception;

  public MobileApp planToRemovePageTypeList(
      MobileApp mobileApp, String pageTypeIds[], Map<String, Object> options) throws Exception;

  public SmartList<MobileApp> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<MobileApp> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateMobileApp executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  List<MobileApp> search(MobileAppRequest pRequest);
}
