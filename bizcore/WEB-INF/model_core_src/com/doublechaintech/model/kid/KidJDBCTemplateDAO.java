
package com.doublechaintech.model.kid;

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

public class KidJDBCTemplateDAO extends ModelBaseDAOImpl implements KidDAO{

	protected FamilyDAO familyDAO;
	public void setFamilyDAO(FamilyDAO familyDAO){

 		if(familyDAO == null){
 			throw new IllegalStateException("Do not try to set familyDAO to null.");
 		}
	 	this.familyDAO = familyDAO;
 	}
 	public FamilyDAO getFamilyDAO(){
 		if(this.familyDAO == null){
 			throw new IllegalStateException("The familyDAO is not configured yet, please config it some where.");
 		}

	 	return this.familyDAO;
 	}



	/*
	protected Kid load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalKid(accessKey, options);
	}
	*/

	public SmartList<Kid> loadAll() {
	    return this.loadAll(getKidMapper());
	}

  public Stream<Kid> loadAllAsStream() {
      return this.loadAllAsStream(getKidMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public Kid load(String id,Map<String,Object> options) throws Exception{
		return loadInternalKid(KidTable.withId(id), options);
	}

	

	public Kid save(Kid kid,Map<String,Object> options){

		String methodName="save(Kid kid,Map<String,Object> options)";

		assertMethodArgumentNotNull(kid, methodName, "kid");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalKid(kid,options);
	}
	public Kid clone(String kidId, Map<String,Object> options) throws Exception{

		return clone(KidTable.withId(kidId),options);
	}

	protected Kid clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String kidId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		Kid newKid = loadInternalKid(accessKey, options);
		newKid.setVersion(0);
		
		


		saveInternalKid(newKid,options);

		return newKid;
	}

	



	protected void throwIfHasException(String kidId,int version,int count) throws Exception{
		if (count == 1) {
			throw new KidVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new KidNotFoundException(
					"The " + this.getTableName() + "(" + kidId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}








	public Kid disconnectFromAll(String kidId, int version) throws Exception{


		Kid kid = loadInternalKid(KidTable.withId(kidId), emptyOptions());
		kid.clearFromAll();
		this.saveKid(kid);
		return kid;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return KidTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "kid";
	}
	@Override
	protected String getBeanName() {

		return "kid";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return KidTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractFamilyEnabled(Map<String,Object> options){

	 	return checkOptions(options, KidTokens.FAMILY);
 	}

 	protected boolean isSaveFamilyEnabled(Map<String,Object> options){

 		return checkOptions(options, KidTokens.FAMILY);
 	}



 
		

	

	protected KidMapper getKidMapper(){
		return new KidMapper();
	}



	protected Kid extractKid(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Kid kid = loadSingleObject(accessKey, getKidMapper());
			return kid;
		}catch(EmptyResultDataAccessException e){
			throw new KidNotFoundException("Kid("+accessKey+") is not found!");
		}

	}




	protected Kid loadInternalKid(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		Kid kid = extractKid(accessKey, loadOptions);

 		if(isExtractFamilyEnabled(loadOptions)){
	 		extractFamily(kid, loadOptions);
 		}
 
		
		return kid;

	}

	

 	protected Kid extractFamily(Kid kid, Map<String,Object> options) throws Exception{
  

		if(kid.getFamily() == null){
			return kid;
		}
		String familyId = kid.getFamily().getId();
		if( familyId == null){
			return kid;
		}
		Family family = getFamilyDAO().load(familyId,options);
		if(family != null){
			kid.setFamily(family);
		}


 		return kid;
 	}

 
		

 
 	public SmartList<Kid> findKidByFamily(String familyId,Map<String,Object> options){

  		SmartList<Kid> resultList = queryWith(KidTable.COLUMN_FAMILY, familyId, options, getKidMapper());
		// analyzeKidByFamily(resultList, familyId, options);
		return resultList;
 	}
 	

 	public SmartList<Kid> findKidByFamily(String familyId, int start, int count,Map<String,Object> options){

 		SmartList<Kid> resultList =  queryWithRange(KidTable.COLUMN_FAMILY, familyId, options, getKidMapper(), start, count);
 		//analyzeKidByFamily(resultList, familyId, options);
 		return resultList;

 	}
 	public void analyzeKidByFamily(SmartList<Kid> resultList, String familyId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countKidByFamily(String familyId,Map<String,Object> options){

 		return countWith(KidTable.COLUMN_FAMILY, familyId, options);
 	}
 	@Override
	public Map<String, Integer> countKidByFamilyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KidTable.COLUMN_FAMILY, ids, options);
	}

 




	

	protected Kid saveKid(Kid  kid){
    

		
		if(!kid.isChanged()){
			return kid;
		}
		

    Beans.dbUtil().cacheCleanUp(kid);
		String SQL=this.getSaveKidSQL(kid);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveKidParameters(kid);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		kid.incVersion();
		kid.afterSave();
		return kid;

	}
	public SmartList<Kid> saveKidList(SmartList<Kid> kidList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitKidList(kidList);

		batchKidCreate((List<Kid>)lists[CREATE_LIST_INDEX]);
		batchKidUpdate((List<Kid>)lists[UPDATE_LIST_INDEX]);
		batchKidRemove((List<Kid>)lists[REMOVE_LIST_INDEX]);
		batchKidRecover((List<Kid>)lists[RECOVER_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(Kid kid:kidList){
			if(kid.isChanged()){
				kid.incVersion();
				kid.afterSave();
			}


		}


		return kidList;
	}

	public SmartList<Kid> removeKidList(SmartList<Kid> kidList,Map<String,Object> options){


		super.removeList(kidList, options);

		return kidList;


	}

	protected List<Object[]> prepareKidBatchCreateArgs(List<Kid> kidList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Kid kid:kidList ){
			Object [] parameters = prepareKidCreateParameters(kid);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareKidBatchUpdateArgs(List<Kid> kidList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Kid kid:kidList ){
			if(!kid.isChanged()){
				continue;
			}
			Object [] parameters = prepareKidUpdateParameters(kid);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareKidBatchRecoverArgs(List<Kid> kidList){

    List<Object[]> parametersList=new ArrayList<Object[]>();
    for(Kid kid:kidList ){
      if(!kid.isToRecover()){
        continue;
      }
      Object [] parameters = prepareRecoverParameters(kid);
      parametersList.add(parameters);

    }
    return parametersList;

  }
	protected List<Object[]> prepareKidBatchRemoveArgs(List<Kid> kidList){

  		List<Object[]> parametersList=new ArrayList<Object[]>();
  		for(Kid kid:kidList ){
  			if(!kid.isToRemove()){
  				continue;
  			}
  			Object [] parameters = prepareKidRemoveParameters(kid);
  			parametersList.add(parameters);

  		}
  		return parametersList;

  	}
	protected void batchKidCreate(List<Kid> kidList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareKidBatchCreateArgs(kidList);

		int affectedNumbers[] = batchUpdate(SQL, args);
	}


	protected void batchKidUpdate(List<Kid> kidList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareKidBatchUpdateArgs(kidList);

		int affectedNumbers[] = batchUpdate(SQL, args);
		checkBatchReturn(affectedNumbers);
	}
	protected void batchKidRemove(List<Kid> kidList){
  	String SQL=getRemoveSQL();
  	List<Object[]> args=prepareKidBatchRemoveArgs(kidList);
  	int affectedNumbers[] = batchRemove(SQL, args);
  	checkBatchReturn(affectedNumbers);
  }
  protected void batchKidRecover(List<Kid> kidList){
  	String SQL=getRecoverSQL();
  	List<Object[]> args=prepareKidBatchRecoverArgs(kidList);
  	int affectedNumbers[] = batchRecover(SQL, args);
  	checkBatchReturn(affectedNumbers);
  }


  

	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
  static final int REMOVE_LIST_INDEX=2;
  static final int RECOVER_LIST_INDEX=3;


	protected Object[] splitKidList(List<Kid> kidList){

		List<Kid> kidCreateList=new ArrayList<Kid>();
		List<Kid> kidUpdateList=new ArrayList<Kid>();
		List<Kid> kidRemoveList=new ArrayList<Kid>();
		List<Kid> kidRecoverList=new ArrayList<Kid>();

		for(Kid kid: kidList){
		  if(kid.isToRemove()){
    				kidRemoveList.add( kid);
    				continue;
    	}
      if(kid.isToRecover()){
        kidRecoverList.add( kid);
        continue;
      }
			if(isUpdateRequest(kid)){
			  if(kid.isChanged()){
				  kidUpdateList.add( kid);
				}
				continue;
			}

			if(kid.isChanged()){
			   kidCreateList.add(kid);
			}
		}

		return new Object[]{kidCreateList,
      kidUpdateList,
      kidRemoveList,
      kidRecoverList
    };
	}

	protected boolean isUpdateRequest(Kid kid){
 		return kid.getVersion() > 0;
 	}
 	protected String getSaveKidSQL(Kid kid){
 		if(kid.isToRemove()){
        return getRemoveSQL();
    }
 		if(isUpdateRequest(kid)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveKidParameters(Kid kid){
 		if(kid.isToRemove() ){
 			return prepareKidRemoveParameters(kid);
 		}
    if(kid.isToRecover() ){
      return prepareRecoverParameters(kid);
    }

 		if(isUpdateRequest(kid) ){
 			return prepareKidUpdateParameters(kid);
 		}
 		return prepareKidCreateParameters(kid);
 	}
 	protected Object[] prepareKidRemoveParameters(Kid kid){
    return super.prepareRemoveParameters(kid);
 	}


 	protected Object[] prepareKidUpdateParameters(Kid kid){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = kid.getName();
 		
 		if(kid.getFamily() != null){
 			parameters[1] = kid.getFamily().getId();
 		}
    
 		parameters[2] = kid.nextVersion();
 		parameters[3] = kid.getId();
 		parameters[4] = kid.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareKidCreateParameters(Kid kid){
		Object[] parameters = new Object[3];
        if(kid.getId() == null){
          String newKidId=getNextId();
          kid.setId(newKidId);
        }
		parameters[0] =  kid.getId();
 
 		parameters[1] = kid.getName();
 		
 		if(kid.getFamily() != null){
 			parameters[2] = kid.getFamily().getId();
 		}
 		

 		return parameters;
 	}

	protected Kid saveInternalKid(Kid kid, Map<String,Object> options){

 		if(isSaveFamilyEnabled(options)){
	 		saveFamily(kid, options);
 		}
 
   saveKid(kid);
		
		return kid;

	}



	//======================================================================================
	

 	protected Kid saveFamily(Kid kid, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(kid.getFamily() == null){
 			return kid;//do nothing when it is null
 		}

 		getFamilyDAO().save(kid.getFamily(),options);
 		return kid;

 	}
 

	

		

	public Kid present(Kid kid,Map<String, Object> options){


		return kid;

	}
		

	

	protected String getTableName(){
		return KidTable.TABLE_NAME;
	}



	public void enhanceList(List<Kid> kidList) {
		this.enhanceListInternal(kidList, this.getKidMapper());
	}

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Kid> kidList = ownerEntity.collectRefsWithType(Kid.INTERNAL_TYPE);
		this.enhanceList(kidList);

	}

	@Override
	public SmartList<Kid> findKidWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getKidMapper());

	}
	@Override
	public int countKidWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countKidWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<Kid> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getKidMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<Kid> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getKidMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateKid executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateKid result = new CandidateKid();
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
  public List<Kid> search(KidRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected KidMapper mapper() {
    return getKidMapper();
  }


  @Override
  protected KidMapper mapperForClazz(Class<?> clazz) {
		return KidMapper.mapperForClass(clazz);
	}
}


