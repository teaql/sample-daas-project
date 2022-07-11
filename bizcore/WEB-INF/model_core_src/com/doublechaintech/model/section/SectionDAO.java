package com.doublechaintech.model.section;

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

import com.doublechaintech.model.page.Page;

import com.doublechaintech.model.page.PageDAO;

public interface SectionDAO extends BaseDAO {

  public SmartList<Section> loadAll();

  public Stream<Section> loadAllAsStream();

  public Section load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<Section> sectionList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public Section present(Section section, Map<String, Object> options) throws Exception;

  public Section clone(String id, Map<String, Object> options) throws Exception;

  public Section save(Section section, Map<String, Object> options);

  public SmartList<Section> saveSectionList(
      SmartList<Section> sectionList, Map<String, Object> options);

  public SmartList<Section> removeSectionList(
      SmartList<Section> sectionList, Map<String, Object> options);

  public SmartList<Section> findSectionWithKey(MultipleAccessKey key, Map<String, Object> options);

  public int countSectionWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countSectionWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public Section disconnectFromAll(String sectionId, int version) throws Exception;

  public void resetNextId();

  public SmartList<Section> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<Section> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateSection executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<Section> findSectionByPage(String pageId, Map<String, Object> options);

  public int countSectionByPage(String pageId, Map<String, Object> options);

  public Map<String, Integer> countSectionByPageIds(String[] ids, Map<String, Object> options);

  public SmartList<Section> findSectionByPage(
      String pageId, int start, int count, Map<String, Object> options);

  public void analyzeSectionByPage(
      SmartList<Section> resultList, String pageId, Map<String, Object> options);

  List<Section> search(SectionRequest pRequest);
}
