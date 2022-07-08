
package com.doublechaintech.model.family;

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


import com.doublechaintech.model.community.Community;
import com.doublechaintech.model.kid.Kid;

import com.doublechaintech.model.community.CommunityDAO;
import com.doublechaintech.model.kid.KidDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class FamilyJDBCTemplateDAO extends ModelBaseDAOImpl implements FamilyDAO{

	protected CommunityDAO communityDAO;
	public void setCommunityDAO(CommunityDAO communityDAO){

 		if(communityDAO == null){
 			throw new IllegalStateException("Do not try to set communityDAO to null.");
 		}
	 	this.communityDAO = communityDAO;
 	}
 	public CommunityDAO getCommunityDAO(){
 		if(this.communityDAO == null){
 			throw new IllegalStateException("The communityDAO is not configured yet, please config it some where.");
 		}

	 	return this.communityDAO;
 	}

	protected KidDAO kidDAO;
	public void setKidDAO(KidDAO kidDAO){

 		if(kidDAO == null){
 			throw new IllegalStateException("Do not try to set kidDAO to null.");
 		}
	 	this.kidDAO = kidDAO;
 	}
 	public KidDAO getKidDAO(){
 		if(this.kidDAO == null){
 			throw new IllegalStateException("The kidDAO is not configured yet, please config it some where.");
 		}

	 	return this.kidDAO;
 	}



	/*
	protected Family load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFamily(accessKey, options);
	}
	*/

	public SmartList<Family> loadAll() {
	    return this.loadAll(getFamilyMapper());
	}

  public Stream<Family> loadAllAsStream() {
      return this.loadAllAsStream(getFamilyMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public Family load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFamily(FamilyTable.withId(id), options);
	}

	

	public Family save(Family family,Map<String,Object> options){

		String methodName="save(Family family,Map<String,Object> options)";

		assertMethodArgumentNotNull(family, methodName, "family");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalFamily(family,options);
	}
	public Family clone(String familyId, Map<String,Object> options) throws Exception{

		return clone(FamilyTable.withId(familyId),options);
	}

	protected Family clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String familyId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		Family newFamily = loadInternalFamily(accessKey, options);
		newFamily.setVersion(0);
		
		

 		if(isSaveKidListEnabled(options)){
 			for(Kid item: newFamily.getKidList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalFamily(newFamily,options);

		return newFamily;
	}

	



	protected void throwIfHasException(String familyId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FamilyVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FamilyNotFoundException(
					"The " + this.getTableName() + "(" + familyId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}








	public Family disconnectFromAll(String familyId, int version) throws Exception{


		Family family = loadInternalFamily(FamilyTable.withId(familyId), emptyOptions());
		family.clearFromAll();
		this.saveFamily(family);
		return family;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return FamilyTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "family";
	}
	@Override
	protected String getBeanName() {

		return "family";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return FamilyTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractCommunityEnabled(Map<String,Object> options){

	 	return checkOptions(options, FamilyTokens.COMMUNITY);
 	}

 	protected boolean isSaveCommunityEnabled(Map<String,Object> options){

 		return checkOptions(options, FamilyTokens.COMMUNITY);
 	}



 
		

	protected boolean isExtractKidListEnabled(Map<String,Object> options){
 		return checkOptions(options,FamilyTokens.KID_LIST);
 	}
 	protected boolean isAnalyzeKidListEnabled(Map<String,Object> options){
 		return FamilyTokens.of(options).analyzeKidListEnabled();
 	}

	protected boolean isSaveKidListEnabled(Map<String,Object> options){
		return checkOptions(options, FamilyTokens.KID_LIST);

 	}

		

	

	protected FamilyMapper getFamilyMapper(){
		return new FamilyMapper();
	}



	protected Family extractFamily(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Family family = loadSingleObject(accessKey, getFamilyMapper());
			return family;
		}catch(EmptyResultDataAccessException e){
			throw new FamilyNotFoundException("Family("+accessKey+") is not found!");
		}

	}




	protected Family loadInternalFamily(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		Family family = extractFamily(accessKey, loadOptions);

 		if(isExtractCommunityEnabled(loadOptions)){
	 		extractCommunity(family, loadOptions);
 		}
 
		
		if(isExtractKidListEnabled(loadOptions)){
	 		extractKidList(family, loadOptions);
 		}

 		
 		if(isAnalyzeKidListEnabled(loadOptions)){
	 		analyzeKidList(family, loadOptions);
 		}
 		
		
		return family;

	}

	

 	protected Family extractCommunity(Family family, Map<String,Object> options) throws Exception{
  

		if(family.getCommunity() == null){
			return family;
		}
		String communityId = family.getCommunity().getId();
		if( communityId == null){
			return family;
		}
		Community community = getCommunityDAO().load(communityId,options);
		if(community != null){
			family.setCommunity(community);
		}


 		return family;
 	}

 
		
	protected void enhanceKidList(SmartList<Kid> kidList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected Family extractKidList(Family family, Map<String,Object> options){
    

		if(family == null){
			return null;
		}
		if(family.getId() == null){
			return family;
		}



		SmartList<Kid> kidList = getKidDAO().findKidByFamily(family.getId(),options);
		if(kidList != null){
			enhanceKidList(kidList,options);
			family.setKidList(kidList);
		}

		return family;
  
	}

	protected Family analyzeKidList(Family family, Map<String,Object> options){
     
		if(family == null){
			return null;
		}
		if(family.getId() == null){
			return family;
		}



		SmartList<Kid> kidList = family.getKidList();
		if(kidList != null){
			getKidDAO().analyzeKidByFamily(kidList, family.getId(), options);

		}

		return family;
    
	}

		

 
 	public SmartList<Family> findFamilyByCommunity(String communityId,Map<String,Object> options){

  		SmartList<Family> resultList = queryWith(FamilyTable.COLUMN_COMMUNITY, communityId, options, getFamilyMapper());
		// analyzeFamilyByCommunity(resultList, communityId, options);
		return resultList;
 	}
 	

 	public SmartList<Family> findFamilyByCommunity(String communityId, int start, int count,Map<String,Object> options){

 		SmartList<Family> resultList =  queryWithRange(FamilyTable.COLUMN_COMMUNITY, communityId, options, getFamilyMapper(), start, count);
 		//analyzeFamilyByCommunity(resultList, communityId, options);
 		return resultList;

 	}
 	public void analyzeFamilyByCommunity(SmartList<Family> resultList, String communityId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countFamilyByCommunity(String communityId,Map<String,Object> options){

 		return countWith(FamilyTable.COLUMN_COMMUNITY, communityId, options);
 	}
 	@Override
	public Map<String, Integer> countFamilyByCommunityIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FamilyTable.COLUMN_COMMUNITY, ids, options);
	}

 




	

	protected Family saveFamily(Family  family){
    

		
		if(!family.isChanged()){
			return family;
		}
		

    Beans.dbUtil().cacheCleanUp(family);
		String SQL=this.getSaveFamilySQL(family);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFamilyParameters(family);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		family.incVersion();
		family.afterSave();
		return family;

	}
	public SmartList<Family> saveFamilyList(SmartList<Family> familyList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFamilyList(familyList);

		batchFamilyCreate((List<Family>)lists[CREATE_LIST_INDEX]);
		batchFamilyUpdate((List<Family>)lists[UPDATE_LIST_INDEX]);
		batchFamilyRemove((List<Family>)lists[REMOVE_LIST_INDEX]);
		batchFamilyRecover((List<Family>)lists[RECOVER_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(Family family:familyList){
			if(family.isChanged()){
				family.incVersion();
				family.afterSave();
			}


		}


		return familyList;
	}

	public SmartList<Family> removeFamilyList(SmartList<Family> familyList,Map<String,Object> options){


		super.removeList(familyList, options);

		return familyList;


	}

	protected List<Object[]> prepareFamilyBatchCreateArgs(List<Family> familyList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Family family:familyList ){
			Object [] parameters = prepareFamilyCreateParameters(family);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareFamilyBatchUpdateArgs(List<Family> familyList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Family family:familyList ){
			if(!family.isChanged()){
				continue;
			}
			Object [] parameters = prepareFamilyUpdateParameters(family);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareFamilyBatchRecoverArgs(List<Family> familyList){

    List<Object[]> parametersList=new ArrayList<Object[]>();
    for(Family family:familyList ){
      if(!family.isToRecover()){
        continue;
      }
      Object [] parameters = prepareRecoverParameters(family);
      parametersList.add(parameters);

    }
    return parametersList;

  }
	protected List<Object[]> prepareFamilyBatchRemoveArgs(List<Family> familyList){

  		List<Object[]> parametersList=new ArrayList<Object[]>();
  		for(Family family:familyList ){
  			if(!family.isToRemove()){
  				continue;
  			}
  			Object [] parameters = prepareFamilyRemoveParameters(family);
  			parametersList.add(parameters);

  		}
  		return parametersList;

  	}
	protected void batchFamilyCreate(List<Family> familyList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFamilyBatchCreateArgs(familyList);

		int affectedNumbers[] = batchUpdate(SQL, args);
	}


	protected void batchFamilyUpdate(List<Family> familyList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFamilyBatchUpdateArgs(familyList);

		int affectedNumbers[] = batchUpdate(SQL, args);
		checkBatchReturn(affectedNumbers);
	}
	protected void batchFamilyRemove(List<Family> familyList){
  	String SQL=getRemoveSQL();
  	List<Object[]> args=prepareFamilyBatchRemoveArgs(familyList);
  	int affectedNumbers[] = batchRemove(SQL, args);
  	checkBatchReturn(affectedNumbers);
  }
  protected void batchFamilyRecover(List<Family> familyList){
  	String SQL=getRecoverSQL();
  	List<Object[]> args=prepareFamilyBatchRecoverArgs(familyList);
  	int affectedNumbers[] = batchRecover(SQL, args);
  	checkBatchReturn(affectedNumbers);
  }


  

	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
  static final int REMOVE_LIST_INDEX=2;
  static final int RECOVER_LIST_INDEX=3;


	protected Object[] splitFamilyList(List<Family> familyList){

		List<Family> familyCreateList=new ArrayList<Family>();
		List<Family> familyUpdateList=new ArrayList<Family>();
		List<Family> familyRemoveList=new ArrayList<Family>();
		List<Family> familyRecoverList=new ArrayList<Family>();

		for(Family family: familyList){
		  if(family.isToRemove()){
    				familyRemoveList.add( family);
    				continue;
    	}
      if(family.isToRecover()){
        familyRecoverList.add( family);
        continue;
      }
			if(isUpdateRequest(family)){
			  if(family.isChanged()){
				  familyUpdateList.add( family);
				}
				continue;
			}

			if(family.isChanged()){
			   familyCreateList.add(family);
			}
		}

		return new Object[]{familyCreateList,
      familyUpdateList,
      familyRemoveList,
      familyRecoverList
    };
	}

	protected boolean isUpdateRequest(Family family){
 		return family.getVersion() > 0;
 	}
 	protected String getSaveFamilySQL(Family family){
 		if(family.isToRemove()){
        return getRemoveSQL();
    }
 		if(isUpdateRequest(family)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveFamilyParameters(Family family){
 		if(family.isToRemove() ){
 			return prepareFamilyRemoveParameters(family);
 		}
    if(family.isToRecover() ){
      return prepareRecoverParameters(family);
    }

 		if(isUpdateRequest(family) ){
 			return prepareFamilyUpdateParameters(family);
 		}
 		return prepareFamilyCreateParameters(family);
 	}
 	protected Object[] prepareFamilyRemoveParameters(Family family){
    return super.prepareRemoveParameters(family);
 	}


 	protected Object[] prepareFamilyUpdateParameters(Family family){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = family.getName();
 		
 		if(family.getCommunity() != null){
 			parameters[1] = family.getCommunity().getId();
 		}
    
 		parameters[2] = family.nextVersion();
 		parameters[3] = family.getId();
 		parameters[4] = family.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareFamilyCreateParameters(Family family){
		Object[] parameters = new Object[3];
        if(family.getId() == null){
          String newFamilyId=getNextId();
          family.setId(newFamilyId);
        }
		parameters[0] =  family.getId();
 
 		parameters[1] = family.getName();
 		
 		if(family.getCommunity() != null){
 			parameters[2] = family.getCommunity().getId();
 		}
 		

 		return parameters;
 	}

	protected Family saveInternalFamily(Family family, Map<String,Object> options){

 		if(isSaveCommunityEnabled(options)){
	 		saveCommunity(family, options);
 		}
 
   saveFamily(family);
		
		if(isSaveKidListEnabled(options)){
	 		saveKidList(family, options);
	 		//removeKidList(family, options);
	 		//Not delete the record

 		}
		
		return family;

	}



	//======================================================================================
	

 	protected Family saveCommunity(Family family, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(family.getCommunity() == null){
 			return family;//do nothing when it is null
 		}

 		getCommunityDAO().save(family.getCommunity(),options);
 		return family;

 	}
 

	
	public Family planToRemoveKidList(Family family, String kidIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Kid.FAMILY_PROPERTY, family.getId());
		key.put(Kid.ID_PROPERTY, kidIds);

		SmartList<Kid> externalKidList = getKidDAO().
				findKidWithKey(key, options);
		if(externalKidList == null){
			return family;
		}
		if(externalKidList.isEmpty()){
			return family;
		}

		for(Kid kidItem: externalKidList){

			kidItem.clearFromAll();
		}


		SmartList<Kid> kidList = family.getKidList();
		kidList.addAllToRemoveList(externalKidList);
		return family;

	}



		
	protected Family saveKidList(Family family, Map<String,Object> options){
    



		SmartList<Kid> kidList = family.getKidList();
		if(kidList == null){
			//null list means nothing
			return family;
		}
		SmartList<Kid> mergedUpdateKidList = new SmartList<Kid>();


		mergedUpdateKidList.addAll(kidList);
		if(kidList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateKidList.addAll(kidList.getToRemoveList());
			kidList.removeAll(kidList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getKidDAO().saveKidList(mergedUpdateKidList,options);

		if(kidList.getToRemoveList() != null){
			kidList.removeAll(kidList.getToRemoveList());
		}


		return family;

	}

	protected Family removeKidList(Family family, Map<String,Object> options){


		SmartList<Kid> kidList = family.getKidList();
		if(kidList == null){
			return family;
		}

		SmartList<Kid> toRemoveKidList = kidList.getToRemoveList();

		if(toRemoveKidList == null){
			return family;
		}
		if(toRemoveKidList.isEmpty()){
			return family;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getKidDAO().removeKidList(toRemoveKidList,options);

		return family;

	}








		

	public Family present(Family family,Map<String, Object> options){

		presentKidList(family,options);

		return family;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected Family presentKidList(
			Family family,
			Map<String, Object> options) {
    
		SmartList<Kid> kidList = family.getKidList();
				SmartList<Kid> newList= presentSubList(family.getId(),
				kidList,
				options,
				getKidDAO()::countKidByFamily,
				getKidDAO()::findKidByFamily
				);


		family.setKidList(newList);


		return family;
	}
		

	
    public SmartList<Family> requestCandidateFamilyForKid(ModelUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(FamilyTable.COLUMN_NAME, FamilyTable.COLUMN_COMMUNITY, filterKey, pageNo, pageSize, getFamilyMapper());
    }
		

	protected String getTableName(){
		return FamilyTable.TABLE_NAME;
	}



	public void enhanceList(List<Family> familyList) {
		this.enhanceListInternal(familyList, this.getFamilyMapper());
	}

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Family> familyList = ownerEntity.collectRefsWithType(Family.INTERNAL_TYPE);
		this.enhanceList(familyList);

	}

	@Override
	public SmartList<Family> findFamilyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getFamilyMapper());

	}
	@Override
	public int countFamilyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countFamilyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<Family> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFamilyMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<Family> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getFamilyMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateFamily executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateFamily result = new CandidateFamily();
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
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	

  @Override
  public List<Family> search(FamilyRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected FamilyMapper mapper() {
    return getFamilyMapper();
  }


  @Override
  protected FamilyMapper mapperForClazz(Class<?> clazz) {
		return FamilyMapper.mapperForClass(clazz);
	}
}


