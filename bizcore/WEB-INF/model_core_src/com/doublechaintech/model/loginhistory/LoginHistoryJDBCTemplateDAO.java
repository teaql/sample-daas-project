
package com.doublechaintech.model.loginhistory;

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


import com.doublechaintech.model.secuser.SecUser;

import com.doublechaintech.model.secuser.SecUserDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class LoginHistoryJDBCTemplateDAO extends ModelBaseDAOImpl implements LoginHistoryDAO{

	protected SecUserDAO secUserDAO;
	public void setSecUserDAO(SecUserDAO secUserDAO){

 		if(secUserDAO == null){
 			throw new IllegalStateException("Do not try to set secUserDAO to null.");
 		}
	 	this.secUserDAO = secUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
 		if(this.secUserDAO == null){
 			throw new IllegalStateException("The secUserDAO is not configured yet, please config it some where.");
 		}

	 	return this.secUserDAO;
 	}



	/*
	protected LoginHistory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLoginHistory(accessKey, options);
	}
	*/

	public SmartList<LoginHistory> loadAll() {
	    return this.loadAll(getLoginHistoryMapper());
	}

  public Stream<LoginHistory> loadAllAsStream() {
      return this.loadAllAsStream(getLoginHistoryMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public LoginHistory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLoginHistory(LoginHistoryTable.withId(id), options);
	}

	

	public LoginHistory save(LoginHistory loginHistory,Map<String,Object> options){

		String methodName="save(LoginHistory loginHistory,Map<String,Object> options)";

		assertMethodArgumentNotNull(loginHistory, methodName, "loginHistory");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalLoginHistory(loginHistory,options);
	}
	public LoginHistory clone(String loginHistoryId, Map<String,Object> options) throws Exception{

		return clone(LoginHistoryTable.withId(loginHistoryId),options);
	}

	protected LoginHistory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String loginHistoryId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		LoginHistory newLoginHistory = loadInternalLoginHistory(accessKey, options);
		newLoginHistory.setVersion(0);
		
		


		saveInternalLoginHistory(newLoginHistory,options);

		return newLoginHistory;
	}

	



	protected void throwIfHasException(String loginHistoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LoginHistoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LoginHistoryNotFoundException(
					"The " + this.getTableName() + "(" + loginHistoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}








	public LoginHistory disconnectFromAll(String loginHistoryId, int version) throws Exception{


		LoginHistory loginHistory = loadInternalLoginHistory(LoginHistoryTable.withId(loginHistoryId), emptyOptions());
		loginHistory.clearFromAll();
		this.saveLoginHistory(loginHistory);
		return loginHistory;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return LoginHistoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "login_history";
	}
	@Override
	protected String getBeanName() {

		return "loginHistory";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return LoginHistoryTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){

	 	return checkOptions(options, LoginHistoryTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){

 		return checkOptions(options, LoginHistoryTokens.SECUSER);
 	}



 
		

	

	protected LoginHistoryMapper getLoginHistoryMapper(){
		return new LoginHistoryMapper();
	}



	protected LoginHistory extractLoginHistory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LoginHistory loginHistory = loadSingleObject(accessKey, getLoginHistoryMapper());
			return loginHistory;
		}catch(EmptyResultDataAccessException e){
			throw new LoginHistoryNotFoundException("LoginHistory("+accessKey+") is not found!");
		}

	}




	protected LoginHistory loadInternalLoginHistory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		LoginHistory loginHistory = extractLoginHistory(accessKey, loadOptions);

 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(loginHistory, loadOptions);
 		}
 
		
		return loginHistory;

	}

	

 	protected LoginHistory extractSecUser(LoginHistory loginHistory, Map<String,Object> options) throws Exception{
  

		if(loginHistory.getSecUser() == null){
			return loginHistory;
		}
		String secUserId = loginHistory.getSecUser().getId();
		if( secUserId == null){
			return loginHistory;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			loginHistory.setSecUser(secUser);
		}


 		return loginHistory;
 	}

 
		

 
 	public SmartList<LoginHistory> findLoginHistoryBySecUser(String secUserId,Map<String,Object> options){

  		SmartList<LoginHistory> resultList = queryWith(LoginHistoryTable.COLUMN_SEC_USER, secUserId, options, getLoginHistoryMapper());
		// analyzeLoginHistoryBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	

 	public SmartList<LoginHistory> findLoginHistoryBySecUser(String secUserId, int start, int count,Map<String,Object> options){

 		SmartList<LoginHistory> resultList =  queryWithRange(LoginHistoryTable.COLUMN_SEC_USER, secUserId, options, getLoginHistoryMapper(), start, count);
 		//analyzeLoginHistoryBySecUser(resultList, secUserId, options);
 		return resultList;

 	}
 	public void analyzeLoginHistoryBySecUser(SmartList<LoginHistory> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(LoginHistory.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem loginTimeStatsItem = new StatsItem();
		//LoginHistory.LOGIN_TIME_PROPERTY
		loginTimeStatsItem.setDisplayName("登录历史");
		loginTimeStatsItem.setInternalName(formatKeyForDateLine(LoginHistory.LOGIN_TIME_PROPERTY));
		loginTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(LoginHistory.LOGIN_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(loginTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countLoginHistoryBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(LoginHistoryTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countLoginHistoryBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LoginHistoryTable.COLUMN_SEC_USER, ids, options);
	}

 




	

	protected LoginHistory saveLoginHistory(LoginHistory  loginHistory){
    

		
		if(!loginHistory.isChanged()){
			return loginHistory;
		}
		

    Beans.dbUtil().cacheCleanUp(loginHistory);
		String SQL=this.getSaveLoginHistorySQL(loginHistory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLoginHistoryParameters(loginHistory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		loginHistory.incVersion();
		loginHistory.afterSave();
		return loginHistory;

	}
	public SmartList<LoginHistory> saveLoginHistoryList(SmartList<LoginHistory> loginHistoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLoginHistoryList(loginHistoryList);

		batchLoginHistoryCreate((List<LoginHistory>)lists[CREATE_LIST_INDEX]);
		batchLoginHistoryUpdate((List<LoginHistory>)lists[UPDATE_LIST_INDEX]);
		batchLoginHistoryRemove((List<LoginHistory>)lists[REMOVE_LIST_INDEX]);
		batchLoginHistoryRecover((List<LoginHistory>)lists[RECOVER_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(LoginHistory loginHistory:loginHistoryList){
			if(loginHistory.isChanged()){
				loginHistory.incVersion();
				loginHistory.afterSave();
			}


		}


		return loginHistoryList;
	}

	public SmartList<LoginHistory> removeLoginHistoryList(SmartList<LoginHistory> loginHistoryList,Map<String,Object> options){


		super.removeList(loginHistoryList, options);

		return loginHistoryList;


	}

	protected List<Object[]> prepareLoginHistoryBatchCreateArgs(List<LoginHistory> loginHistoryList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LoginHistory loginHistory:loginHistoryList ){
			Object [] parameters = prepareLoginHistoryCreateParameters(loginHistory);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareLoginHistoryBatchUpdateArgs(List<LoginHistory> loginHistoryList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LoginHistory loginHistory:loginHistoryList ){
			if(!loginHistory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLoginHistoryUpdateParameters(loginHistory);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareLoginHistoryBatchRecoverArgs(List<LoginHistory> loginHistoryList){

    List<Object[]> parametersList=new ArrayList<Object[]>();
    for(LoginHistory loginHistory:loginHistoryList ){
      if(!loginHistory.isToRecover()){
        continue;
      }
      Object [] parameters = prepareRecoverParameters(loginHistory);
      parametersList.add(parameters);

    }
    return parametersList;

  }
	protected List<Object[]> prepareLoginHistoryBatchRemoveArgs(List<LoginHistory> loginHistoryList){

  		List<Object[]> parametersList=new ArrayList<Object[]>();
  		for(LoginHistory loginHistory:loginHistoryList ){
  			if(!loginHistory.isToRemove()){
  				continue;
  			}
  			Object [] parameters = prepareLoginHistoryRemoveParameters(loginHistory);
  			parametersList.add(parameters);

  		}
  		return parametersList;

  	}
	protected void batchLoginHistoryCreate(List<LoginHistory> loginHistoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLoginHistoryBatchCreateArgs(loginHistoryList);

		int affectedNumbers[] = batchUpdate(SQL, args);
	}


	protected void batchLoginHistoryUpdate(List<LoginHistory> loginHistoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLoginHistoryBatchUpdateArgs(loginHistoryList);

		int affectedNumbers[] = batchUpdate(SQL, args);
		checkBatchReturn(affectedNumbers);
	}
	protected void batchLoginHistoryRemove(List<LoginHistory> loginHistoryList){
  	String SQL=getRemoveSQL();
  	List<Object[]> args=prepareLoginHistoryBatchRemoveArgs(loginHistoryList);
  	int affectedNumbers[] = batchRemove(SQL, args);
  	checkBatchReturn(affectedNumbers);
  }
  protected void batchLoginHistoryRecover(List<LoginHistory> loginHistoryList){
  	String SQL=getRecoverSQL();
  	List<Object[]> args=prepareLoginHistoryBatchRecoverArgs(loginHistoryList);
  	int affectedNumbers[] = batchRecover(SQL, args);
  	checkBatchReturn(affectedNumbers);
  }


  

	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
  static final int REMOVE_LIST_INDEX=2;
  static final int RECOVER_LIST_INDEX=3;


	protected Object[] splitLoginHistoryList(List<LoginHistory> loginHistoryList){

		List<LoginHistory> loginHistoryCreateList=new ArrayList<LoginHistory>();
		List<LoginHistory> loginHistoryUpdateList=new ArrayList<LoginHistory>();
		List<LoginHistory> loginHistoryRemoveList=new ArrayList<LoginHistory>();
		List<LoginHistory> loginHistoryRecoverList=new ArrayList<LoginHistory>();

		for(LoginHistory loginHistory: loginHistoryList){
		  if(loginHistory.isToRemove()){
    				loginHistoryRemoveList.add( loginHistory);
    				continue;
    	}
      if(loginHistory.isToRecover()){
        loginHistoryRecoverList.add( loginHistory);
        continue;
      }
			if(isUpdateRequest(loginHistory)){
			  if(loginHistory.isChanged()){
				  loginHistoryUpdateList.add( loginHistory);
				}
				continue;
			}

			if(loginHistory.isChanged()){
			   loginHistoryCreateList.add(loginHistory);
			}
		}

		return new Object[]{loginHistoryCreateList,
      loginHistoryUpdateList,
      loginHistoryRemoveList,
      loginHistoryRecoverList
    };
	}

	protected boolean isUpdateRequest(LoginHistory loginHistory){
 		return loginHistory.getVersion() > 0;
 	}
 	protected String getSaveLoginHistorySQL(LoginHistory loginHistory){
 		if(loginHistory.isToRemove()){
        return getRemoveSQL();
    }
 		if(isUpdateRequest(loginHistory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveLoginHistoryParameters(LoginHistory loginHistory){
 		if(loginHistory.isToRemove() ){
 			return prepareLoginHistoryRemoveParameters(loginHistory);
 		}
    if(loginHistory.isToRecover() ){
      return prepareRecoverParameters(loginHistory);
    }

 		if(isUpdateRequest(loginHistory) ){
 			return prepareLoginHistoryUpdateParameters(loginHistory);
 		}
 		return prepareLoginHistoryCreateParameters(loginHistory);
 	}
 	protected Object[] prepareLoginHistoryRemoveParameters(LoginHistory loginHistory){
    return super.prepareRemoveParameters(loginHistory);
 	}


 	protected Object[] prepareLoginHistoryUpdateParameters(LoginHistory loginHistory){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = loginHistory.getLoginTime();
 		
 		parameters[1] = loginHistory.getFromIp();
 		
 		parameters[2] = loginHistory.getDescription();
 		
 		if(loginHistory.getSecUser() != null){
 			parameters[3] = loginHistory.getSecUser().getId();
 		}
    
 		parameters[4] = loginHistory.nextVersion();
 		parameters[5] = loginHistory.getId();
 		parameters[6] = loginHistory.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareLoginHistoryCreateParameters(LoginHistory loginHistory){
		Object[] parameters = new Object[5];
        if(loginHistory.getId() == null){
          String newLoginHistoryId=getNextId();
          loginHistory.setId(newLoginHistoryId);
        }
		parameters[0] =  loginHistory.getId();
 
 		parameters[1] = loginHistory.getLoginTime();
 		
 		parameters[2] = loginHistory.getFromIp();
 		
 		parameters[3] = loginHistory.getDescription();
 		
 		if(loginHistory.getSecUser() != null){
 			parameters[4] = loginHistory.getSecUser().getId();
 		}
 		

 		return parameters;
 	}

	protected LoginHistory saveInternalLoginHistory(LoginHistory loginHistory, Map<String,Object> options){

 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(loginHistory, options);
 		}
 
   saveLoginHistory(loginHistory);
		
		return loginHistory;

	}



	//======================================================================================
	

 	protected LoginHistory saveSecUser(LoginHistory loginHistory, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(loginHistory.getSecUser() == null){
 			return loginHistory;//do nothing when it is null
 		}

 		getSecUserDAO().save(loginHistory.getSecUser(),options);
 		return loginHistory;

 	}
 

	

		

	public LoginHistory present(LoginHistory loginHistory,Map<String, Object> options){


		return loginHistory;

	}
		

	

	protected String getTableName(){
		return LoginHistoryTable.TABLE_NAME;
	}



	public void enhanceList(List<LoginHistory> loginHistoryList) {
		this.enhanceListInternal(loginHistoryList, this.getLoginHistoryMapper());
	}

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LoginHistory> loginHistoryList = ownerEntity.collectRefsWithType(LoginHistory.INTERNAL_TYPE);
		this.enhanceList(loginHistoryList);

	}

	@Override
	public SmartList<LoginHistory> findLoginHistoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getLoginHistoryMapper());

	}
	@Override
	public int countLoginHistoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countLoginHistoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<LoginHistory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLoginHistoryMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<LoginHistory> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getLoginHistoryMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLoginHistory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLoginHistory result = new CandidateLoginHistory();
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
  public List<LoginHistory> search(LoginHistoryRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected LoginHistoryMapper mapper() {
    return getLoginHistoryMapper();
  }


  @Override
  protected LoginHistoryMapper mapperForClazz(Class<?> clazz) {
		return LoginHistoryMapper.mapperForClass(clazz);
	}
}


