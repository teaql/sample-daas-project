package com.doublechaintech.model.family;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.model.search.*;



import com.doublechaintech.model.community.Community;
import com.doublechaintech.model.kid.Kid;
import com.doublechaintech.model.community.CommunityRequest;
import com.doublechaintech.model.kid.KidRequest;



import java.util.stream.Collectors;
import static com.doublechaintech.model.family.Family.*;

public class FamilyRequest extends BaseRequest<Family> {
    public static FamilyRequest newInstance() {
        return new FamilyRequest().filterByVersion(QueryOperator.GREATER_THAN,0).selectId();
    }

    public FamilyRequest resultByClass(Class<? extends Family> clazz){
      overrideResultByClass(clazz);
      return this;
    }

    public FamilyRequest includeDarknessRows(){
      removeAllVersionCriteria();
      return this;
    }
    public FamilyRequest onlyDarknessRows(){
      return filterByVersion(QueryOperator.LESS_THAN,0);
    }


    public String getInternalType() {
        return "Family";
    }

    public FamilyRequest findWithJson(JsonNode jsonExpr){
        this.mergeClauses(jsonExpr);
        return this;
    }


    public FamilyRequest addDynamicProperty(String propertyName, BaseRequest request, String parentPropertyName) {
      getDynamicAttributes().add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
      return this;
    }

    public FamilyRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public FamilyRequest select(String... names) {
        super.select(names);
        return this;
    }

    public FamilyRequest selectAll() {return this.selectId().selectName().selectCommunity().selectVersion();
    }

    public FamilyRequest selectAny() {return selectAll().selectKidList(Q.kid().selectSelf());
        }

    public FamilyRequest selectSelf() {
      select(ID_PROPERTY);
      select(NAME_PROPERTY);
      select(COMMUNITY_PROPERTY);
      select(VERSION_PROPERTY);
    
      return this;
    }

    public FamilyRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public FamilyRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      if(pQueryOperator.isNoOperator()){
        return this;
      }
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

    protected static final String[] DATE_OR_TIME_FIELDS={};
    protected static final String[] ALL_SELF_FIELDS={ID_PROPERTY,NAME_PROPERTY,COMMUNITY_PROPERTY,VERSION_PROPERTY};

    @Override
    protected boolean isDateOrTimeField(String fieldName) {
      return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
    }

    @Override
    protected boolean isOneOfSelfField(String fieldName) {
      return super.isOneOf(fieldName, ALL_SELF_FIELDS);
    }


    public FamilyRequest where(JsonNode jsonNode) {
      this.addJsonFilter(jsonNode);
      return this;
    }

    public FamilyRequest comment(String comment) {
      return this;
    }

    public FamilyRequest enhance() {
      return this;
    }

    public FamilyRequest overrideClass(Class<? extends  Family> clazz ) {
      return this;
    }

    public FamilyRequest aggregate(String aggName, AggFunc fuc, String... properties) {
      super.aggregate(aggName, fuc, properties);
      return this;
    }

   public FamilyRequest groupBy(String retName, String propertyName) {
      super.groupBy(retName, SqlFunction.SELF, propertyName);
     return this;
   }

   public FamilyRequest groupBy(String propertyName) {
     super.groupBy(propertyName);
     return this;
   }

   public FamilyRequest groupBy(String ret, SqlFunction fun, String... properties) {
     super.groupBy(ret, fun, properties);
     return this;
   }

   public FamilyRequest count(){
      return countId("count");
   }

   
     public static FamilyRequest withId(String... id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public FamilyRequest filterById(String... id) {
          if (isEmptyParam(id)) {
            throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
          }
          return filterById(QueryOperator.IN, (Object[])id);
      }
    

















      public FamilyRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public FamilyRequest selectId(){
          return select(ID_PROPERTY);
      }

      public FamilyRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public FamilyRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
      public FamilyRequest orderByIdAscending(){
        addOrderBy(ID_PROPERTY, true);
        return this;
      }
      public FamilyRequest orderByIdDescending(){
        addOrderBy(ID_PROPERTY, false);
        return this;
      }

      
      public FamilyRequest countId(){
          return countId("countId");
      }

      public FamilyRequest countId(String aggName){
          return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
      }

     
      public FamilyRequest maxId(){
          return maxId("maxId");
      }

      public FamilyRequest maxId(String aggName){
          return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
      }

     
      public FamilyRequest minId(){
          return minId("minId");
      }

      public FamilyRequest minId(String aggName){
          return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
      }

     

      

      public FamilyRequest groupById() {
        return groupById(ID_PROPERTY);
      }

      public FamilyRequest groupById(String ret) {
        return groupBy(ret, ID_PROPERTY);
      }

      public FamilyRequest groupById(SqlFunction func) {
        return groupById(ID_PROPERTY, func);
      }


      public FamilyRequest groupById(String ret, SqlFunction func) {
        super.groupBy(ret, func, ID_PROPERTY);
        return this;
      }
   
      public FamilyRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }

     public FamilyRequest whereNameIsNull() {
          return where(NAME_PROPERTY,QueryOperator.IS_NULL);
        }

    public FamilyRequest whereNameIsNotNull() {
      return where(NAME_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public FamilyRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public FamilyRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public FamilyRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public FamilyRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
      public FamilyRequest orderByNameAscending(){
        addOrderBy(NAME_PROPERTY, true);
        return this;
      }
      public FamilyRequest orderByNameDescending(){
        addOrderBy(NAME_PROPERTY, false);
        return this;
      }

      
      public FamilyRequest countName(){
          return countName("countName");
      }

      public FamilyRequest countName(String aggName){
          return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
      }

     
      public FamilyRequest maxName(){
          return maxName("maxName");
      }

      public FamilyRequest maxName(String aggName){
          return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
      }

     
      public FamilyRequest minName(){
          return minName("minName");
      }

      public FamilyRequest minName(String aggName){
          return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
      }

     

      

      public FamilyRequest groupByName() {
        return groupByName(NAME_PROPERTY);
      }

      public FamilyRequest groupByName(String ret) {
        return groupBy(ret, NAME_PROPERTY);
      }

      public FamilyRequest groupByName(SqlFunction func) {
        return groupByName(NAME_PROPERTY, func);
      }


      public FamilyRequest groupByName(String ret, SqlFunction func) {
        super.groupBy(ret, func, NAME_PROPERTY);
        return this;
      }
   
      public FamilyRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }

     public FamilyRequest whereVersionIsNull() {
          return where(VERSION_PROPERTY,QueryOperator.IS_NULL);
        }

    public FamilyRequest whereVersionIsNotNull() {
      return where(VERSION_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public FamilyRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public FamilyRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public FamilyRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public FamilyRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
      public FamilyRequest orderByVersionAscending(){
        addOrderBy(VERSION_PROPERTY, true);
        return this;
      }
      public FamilyRequest orderByVersionDescending(){
        addOrderBy(VERSION_PROPERTY, false);
        return this;
      }

      
      public FamilyRequest countVersion(){
          return countVersion("countVersion");
      }

      public FamilyRequest countVersion(String aggName){
          return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
      }

     
      public FamilyRequest maxVersion(){
          return maxVersion("maxVersion");
      }

      public FamilyRequest maxVersion(String aggName){
          return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
      }

     
      public FamilyRequest minVersion(){
          return minVersion("minVersion");
      }

      public FamilyRequest minVersion(String aggName){
          return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
      }

     

      
      public FamilyRequest sumVersion(){
          return sumVersion("sumVersion");
      }

      public FamilyRequest sumVersion(String aggName){
          return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
      }

     

      public FamilyRequest groupByVersion() {
        return groupByVersion(VERSION_PROPERTY);
      }

      public FamilyRequest groupByVersion(String ret) {
        return groupBy(ret, VERSION_PROPERTY);
      }

      public FamilyRequest groupByVersion(SqlFunction func) {
        return groupByVersion(VERSION_PROPERTY, func);
      }


      public FamilyRequest groupByVersion(String ret, SqlFunction func) {
        super.groupBy(ret, func, VERSION_PROPERTY);
        return this;
      }
   


  

    
    public FamilyRequest filterByCommunity(CommunityRequest community){
        return filterByCommunity(community, Community::getId);
    }

    public FamilyRequest filterByCommunity(Community... community){
        if(isEmptyParam(community)){
          throw new IllegalArgumentException("filterByCommunity(Community... community)参数不能为空!");
        }
        return where(COMMUNITY_PROPERTY, QueryOperator.IN, (Object[])community);
    }

    public FamilyRequest selectCommunityId(){
       select(COMMUNITY_PROPERTY);
       return this;
    }

    public CommunityRequest upToCommunity(){
       return upToCommunity(CommunityRequest.newInstance());
    }

    public CommunityRequest upToCommunity(CommunityRequest community){
       community.aggregateChild(COMMUNITY_PROPERTY, this);
       this.groupByCommunity(community);
       return community;
    }


     public CommunityRequest endAtCommunity(String retName){
           return endAtCommunity(retName, CommunityRequest.newInstance());
        }

    public CommunityRequest endAtCommunity(String retName, CommunityRequest community){
       community.addDynamicProperty(retName, this, COMMUNITY_PROPERTY);
       return community;
    }

    public FamilyRequest filterByCommunity(String... community){
        if(isEmptyParam(community)){
           throw new IllegalArgumentException("filterByCommunity(String... community)参数不能为空!");
        }
        return where(COMMUNITY_PROPERTY, QueryOperator.IN, (Object[])community);
    }

    public FamilyRequest filterByCommunity(CommunityRequest community, IDRefine<Community> idRefine) {
        community.unlimited();
        return addSearchCriteria(createCommunityCriteria(community, idRefine));
    }

    public SearchCriteria createCommunityCriteria(CommunityRequest community, IDRefine<Community> idRefine) {
        return new RefinedIdInCriteria(community, COMMUNITY_PROPERTY, idRefine, Community.ID_PROPERTY);
    }




    

    
    public FamilyRequest selectCommunity(){
        return selectCommunity(CommunityRequest.newInstance().selectSelf());
    }

    public FamilyRequest selectCommunity(CommunityRequest community){
        selectParent(COMMUNITY_PROPERTY, community);
        return this;
    }
    

    public FamilyRequest unselectCommunity(){
        unselectParent(COMMUNITY_PROPERTY);
        return this;
    }

    public FamilyRequest groupByCommunity(CommunityRequest community){
        groupBy(COMMUNITY_PROPERTY, community);
        return this;
    }

    public FamilyRequest aggregateCommunity(CommunityRequest community){
        aggregateParent(COMMUNITY_PROPERTY, community);
        return this;
    }

    public FamilyRequest countCommunity(){
        return countCommunity("countCommunity");
    }

    public FamilyRequest countCommunity(String aggName){
        return aggregate(aggName, AggFunc.COUNT, COMMUNITY_PROPERTY);
    }

    public FamilyRequest groupByCommunity() {
      return groupByCommunity(COMMUNITY_PROPERTY);
    }

    public FamilyRequest groupByCommunity(String ret) {
      return groupBy(ret, COMMUNITY_PROPERTY);
    }

    public FamilyRequest whereCommunityIsNull() {
          return where(COMMUNITY_PROPERTY,QueryOperator.IS_NULL);
        }

    public FamilyRequest whereCommunityIsNotNull() {
      return where(COMMUNITY_PROPERTY,QueryOperator.IS_NOT_NULL);
    }

  


  

    public FamilyRequest hasKid() {
      return hasKid(KidRequest.newInstance());
    }

    public FamilyRequest hasKid(Kid... kid) {
       if (isEmptyParam(kid)){
          throw new IllegalArgumentException("hasKid(Kid... kid)参数不能为空!");
        }
        return hasKid(Q.kid().select(Kid.FAMILY_PROPERTY).filterById(QueryOperator.IN, (Object[])kid));
    }

    public FamilyRequest hasKid(String... kid) {
        return hasKid(Q.kid().select(Kid.FAMILY_PROPERTY).filterById(kid));
    }

    public FamilyRequest hasKid(KidRequest kid) {
        return hasKid(kid, $kid -> java.util.Optional.of($kid).map(Kid::getFamily).map(Family::getId).orElse(null));
    }

    public FamilyRequest hasKid(KidRequest kid, IDRefine<Kid> idRefine) {
        kid.select(Kid.FAMILY_PROPERTY);
        kid.unlimited();
        return addSearchCriteria(createKidCriteria(kid, idRefine));
    }


    public FamilyRequest hasKid(
        KidRequest kid, QueryOperator queryOperator, Object value) {
      return addSearchCriteria(
          new AggregationCriteria(
              kid, Kid.FAMILY_PROPERTY, queryOperator, value));
    }

    public SearchCriteria createKidCriteria(KidRequest kid, IDRefine<Kid> idRefine){
       return new RefinedIdInCriteria(kid, ID_PROPERTY, idRefine, Kid.FAMILY_PROPERTY);
    }

    public FamilyRequest selectKidList(KidRequest kid) {
        selectChild(Kid.FAMILY_PROPERTY, kid);
        return this;
    }

    public FamilyRequest selectKidList() {
        return selectKidList(KidRequest.newInstance().selectAll());
    }

    public FamilyRequest unselectKidList(){
        unselectChild(Kid.FAMILY_PROPERTY, Kid.class);
        return this;
    }


  



  




  public FamilyRequest aggregateKidList(KidRequest kid){
      aggregateChild(Kid.FAMILY_PROPERTY, kid);
      return this;
  }

  public FamilyRequest countKid(){
    return countKid("kidCount");
  }

  public FamilyRequest countKid(String retName){
    return countKid(retName, KidRequest.newInstance());
  }

  public FamilyRequest countKid(KidRequest kid) {
    return countKid("kidCount", kid);
  }

  public FamilyRequest countKid(String retName, KidRequest kid){
    kid.count();
    return statsFromKid(retName, kid);
  }

  public FamilyRequest statsFromKid(String retName, KidRequest kid){
    return addDynamicProperty(retName, kid, Kid.FAMILY_PROPERTY);
  }





   public FamilyRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
   public FamilyRequest statsOnly(){
    limit(0,0);
    return this;
  }

  public FamilyRequest unlimited() {
    super.unlimited();
    return this;
  }

  public FamilyRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }

}

