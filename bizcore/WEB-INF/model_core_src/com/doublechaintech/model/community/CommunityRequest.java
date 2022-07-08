package com.doublechaintech.model.community;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.model.search.*;



import com.doublechaintech.model.family.Family;
import com.doublechaintech.model.family.FamilyRequest;



import java.util.stream.Collectors;
import static com.doublechaintech.model.community.Community.*;

public class CommunityRequest extends BaseRequest<Community> {
    public static CommunityRequest newInstance() {
        return new CommunityRequest().filterByVersion(QueryOperator.GREATER_THAN,0).selectId();
    }

    public CommunityRequest resultByClass(Class<? extends Community> clazz){
      overrideResultByClass(clazz);
      return this;
    }

    public CommunityRequest includeDarknessRows(){
      removeAllVersionCriteria();
      return this;
    }
    public CommunityRequest onlyDarknessRows(){
      return filterByVersion(QueryOperator.LESS_THAN,0);
    }


    public String getInternalType() {
        return "Community";
    }

    public CommunityRequest findWithJson(JsonNode jsonExpr){
        this.mergeClauses(jsonExpr);
        return this;
    }


    public CommunityRequest addDynamicProperty(String propertyName, BaseRequest request, String parentPropertyName) {
      getDynamicAttributes().add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
      return this;
    }

    public CommunityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CommunityRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CommunityRequest selectAll() {return this.selectId().selectName().selectAddress().selectVersion();
    }

    public CommunityRequest selectAny() {return selectAll().selectFamilyList(Q.family().selectSelf());
        }

    public CommunityRequest selectSelf() {
      select(ID_PROPERTY);
      select(NAME_PROPERTY);
      select(ADDRESS_PROPERTY);
      select(VERSION_PROPERTY);
    
      return this;
    }

    public CommunityRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CommunityRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      if(pQueryOperator.isNoOperator()){
        return this;
      }
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

    protected static final String[] DATE_OR_TIME_FIELDS={};
    protected static final String[] ALL_SELF_FIELDS={ID_PROPERTY,NAME_PROPERTY,ADDRESS_PROPERTY,VERSION_PROPERTY};

    @Override
    protected boolean isDateOrTimeField(String fieldName) {
      return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
    }

    @Override
    protected boolean isOneOfSelfField(String fieldName) {
      return super.isOneOf(fieldName, ALL_SELF_FIELDS);
    }


    public CommunityRequest where(JsonNode jsonNode) {
      this.addJsonFilter(jsonNode);
      return this;
    }

    public CommunityRequest comment(String comment) {
      return this;
    }

    public CommunityRequest enhance() {
      return this;
    }

    public CommunityRequest overrideClass(Class<? extends  Community> clazz ) {
      return this;
    }

    public CommunityRequest aggregate(String aggName, AggFunc fuc, String... properties) {
      super.aggregate(aggName, fuc, properties);
      return this;
    }

   public CommunityRequest groupBy(String retName, String propertyName) {
      super.groupBy(retName, SqlFunction.SELF, propertyName);
     return this;
   }

   public CommunityRequest groupBy(String propertyName) {
     super.groupBy(propertyName);
     return this;
   }

   public CommunityRequest groupBy(String ret, SqlFunction fun, String... properties) {
     super.groupBy(ret, fun, properties);
     return this;
   }

   public CommunityRequest count(){
      return countId("count");
   }

   
     public static CommunityRequest withId(String... id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CommunityRequest filterById(String... id) {
          if (isEmptyParam(id)) {
            throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
          }
          return filterById(QueryOperator.IN, (Object[])id);
      }
    

















      public CommunityRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CommunityRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CommunityRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public CommunityRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
      public CommunityRequest orderByIdAscending(){
        addOrderBy(ID_PROPERTY, true);
        return this;
      }
      public CommunityRequest orderByIdDescending(){
        addOrderBy(ID_PROPERTY, false);
        return this;
      }

      
      public CommunityRequest countId(){
          return countId("countId");
      }

      public CommunityRequest countId(String aggName){
          return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
      }

     
      public CommunityRequest maxId(){
          return maxId("maxId");
      }

      public CommunityRequest maxId(String aggName){
          return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
      }

     
      public CommunityRequest minId(){
          return minId("minId");
      }

      public CommunityRequest minId(String aggName){
          return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
      }

     

      

      public CommunityRequest groupById() {
        return groupById(ID_PROPERTY);
      }

      public CommunityRequest groupById(String ret) {
        return groupBy(ret, ID_PROPERTY);
      }

      public CommunityRequest groupById(SqlFunction func) {
        return groupById(ID_PROPERTY, func);
      }


      public CommunityRequest groupById(String ret, SqlFunction func) {
        super.groupBy(ret, func, ID_PROPERTY);
        return this;
      }
   
      public CommunityRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }

     public CommunityRequest whereNameIsNull() {
          return where(NAME_PROPERTY,QueryOperator.IS_NULL);
        }

    public CommunityRequest whereNameIsNotNull() {
      return where(NAME_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public CommunityRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CommunityRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public CommunityRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public CommunityRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
      public CommunityRequest orderByNameAscending(){
        addOrderBy(NAME_PROPERTY, true);
        return this;
      }
      public CommunityRequest orderByNameDescending(){
        addOrderBy(NAME_PROPERTY, false);
        return this;
      }

      
      public CommunityRequest countName(){
          return countName("countName");
      }

      public CommunityRequest countName(String aggName){
          return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
      }

     
      public CommunityRequest maxName(){
          return maxName("maxName");
      }

      public CommunityRequest maxName(String aggName){
          return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
      }

     
      public CommunityRequest minName(){
          return minName("minName");
      }

      public CommunityRequest minName(String aggName){
          return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
      }

     

      

      public CommunityRequest groupByName() {
        return groupByName(NAME_PROPERTY);
      }

      public CommunityRequest groupByName(String ret) {
        return groupBy(ret, NAME_PROPERTY);
      }

      public CommunityRequest groupByName(SqlFunction func) {
        return groupByName(NAME_PROPERTY, func);
      }


      public CommunityRequest groupByName(String ret, SqlFunction func) {
        super.groupBy(ret, func, NAME_PROPERTY);
        return this;
      }
   
      public CommunityRequest filterByAddress(String address) {
          
          if (address == null) {
              return this;
          }
          
          return filterByAddress(QueryOperator.EQUAL, address);
      }

     public CommunityRequest whereAddressIsNull() {
          return where(ADDRESS_PROPERTY,QueryOperator.IS_NULL);
        }

    public CommunityRequest whereAddressIsNotNull() {
      return where(ADDRESS_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public CommunityRequest filterByAddress(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CommunityRequest selectAddress(){
          return select(ADDRESS_PROPERTY);
      }

      public CommunityRequest unselectAddress(){
          return unselect(ADDRESS_PROPERTY);
      }

      public SearchCriteria getAddressSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public CommunityRequest orderByAddress(boolean asc){
          addOrderBy(ADDRESS_PROPERTY, asc);
          return this;
      }
      public CommunityRequest orderByAddressAscending(){
        addOrderBy(ADDRESS_PROPERTY, true);
        return this;
      }
      public CommunityRequest orderByAddressDescending(){
        addOrderBy(ADDRESS_PROPERTY, false);
        return this;
      }

      
      public CommunityRequest countAddress(){
          return countAddress("countAddress");
      }

      public CommunityRequest countAddress(String aggName){
          return aggregate(aggName, AggFunc.COUNT, ADDRESS_PROPERTY);
      }

     
      public CommunityRequest maxAddress(){
          return maxAddress("maxAddress");
      }

      public CommunityRequest maxAddress(String aggName){
          return aggregate(aggName, AggFunc.MAX, ADDRESS_PROPERTY);
      }

     
      public CommunityRequest minAddress(){
          return minAddress("minAddress");
      }

      public CommunityRequest minAddress(String aggName){
          return aggregate(aggName, AggFunc.MIN, ADDRESS_PROPERTY);
      }

     

      

      public CommunityRequest groupByAddress() {
        return groupByAddress(ADDRESS_PROPERTY);
      }

      public CommunityRequest groupByAddress(String ret) {
        return groupBy(ret, ADDRESS_PROPERTY);
      }

      public CommunityRequest groupByAddress(SqlFunction func) {
        return groupByAddress(ADDRESS_PROPERTY, func);
      }


      public CommunityRequest groupByAddress(String ret, SqlFunction func) {
        super.groupBy(ret, func, ADDRESS_PROPERTY);
        return this;
      }
   
      public CommunityRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }

     public CommunityRequest whereVersionIsNull() {
          return where(VERSION_PROPERTY,QueryOperator.IS_NULL);
        }

    public CommunityRequest whereVersionIsNotNull() {
      return where(VERSION_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public CommunityRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CommunityRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CommunityRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public CommunityRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
      public CommunityRequest orderByVersionAscending(){
        addOrderBy(VERSION_PROPERTY, true);
        return this;
      }
      public CommunityRequest orderByVersionDescending(){
        addOrderBy(VERSION_PROPERTY, false);
        return this;
      }

      
      public CommunityRequest countVersion(){
          return countVersion("countVersion");
      }

      public CommunityRequest countVersion(String aggName){
          return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
      }

     
      public CommunityRequest maxVersion(){
          return maxVersion("maxVersion");
      }

      public CommunityRequest maxVersion(String aggName){
          return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
      }

     
      public CommunityRequest minVersion(){
          return minVersion("minVersion");
      }

      public CommunityRequest minVersion(String aggName){
          return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
      }

     

      
      public CommunityRequest sumVersion(){
          return sumVersion("sumVersion");
      }

      public CommunityRequest sumVersion(String aggName){
          return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
      }

     

      public CommunityRequest groupByVersion() {
        return groupByVersion(VERSION_PROPERTY);
      }

      public CommunityRequest groupByVersion(String ret) {
        return groupBy(ret, VERSION_PROPERTY);
      }

      public CommunityRequest groupByVersion(SqlFunction func) {
        return groupByVersion(VERSION_PROPERTY, func);
      }


      public CommunityRequest groupByVersion(String ret, SqlFunction func) {
        super.groupBy(ret, func, VERSION_PROPERTY);
        return this;
      }
   


  


  

    public CommunityRequest hasFamily() {
      return hasFamily(FamilyRequest.newInstance());
    }

    public CommunityRequest hasFamily(Family... family) {
       if (isEmptyParam(family)){
          throw new IllegalArgumentException("hasFamily(Family... family)参数不能为空!");
        }
        return hasFamily(Q.family().select(Family.COMMUNITY_PROPERTY).filterById(QueryOperator.IN, (Object[])family));
    }

    public CommunityRequest hasFamily(String... family) {
        return hasFamily(Q.family().select(Family.COMMUNITY_PROPERTY).filterById(family));
    }

    public CommunityRequest hasFamily(FamilyRequest family) {
        return hasFamily(family, $family -> java.util.Optional.of($family).map(Family::getCommunity).map(Community::getId).orElse(null));
    }

    public CommunityRequest hasFamily(FamilyRequest family, IDRefine<Family> idRefine) {
        family.select(Family.COMMUNITY_PROPERTY);
        family.unlimited();
        return addSearchCriteria(createFamilyCriteria(family, idRefine));
    }


    public CommunityRequest hasFamily(
        FamilyRequest family, QueryOperator queryOperator, Object value) {
      return addSearchCriteria(
          new AggregationCriteria(
              family, Family.COMMUNITY_PROPERTY, queryOperator, value));
    }

    public SearchCriteria createFamilyCriteria(FamilyRequest family, IDRefine<Family> idRefine){
       return new RefinedIdInCriteria(family, ID_PROPERTY, idRefine, Family.COMMUNITY_PROPERTY);
    }

    public CommunityRequest selectFamilyList(FamilyRequest family) {
        selectChild(Family.COMMUNITY_PROPERTY, family);
        return this;
    }

    public CommunityRequest selectFamilyList() {
        return selectFamilyList(FamilyRequest.newInstance().selectAll());
    }

    public CommunityRequest unselectFamilyList(){
        unselectChild(Family.COMMUNITY_PROPERTY, Family.class);
        return this;
    }


  



  




  public CommunityRequest aggregateFamilyList(FamilyRequest family){
      aggregateChild(Family.COMMUNITY_PROPERTY, family);
      return this;
  }

  public CommunityRequest countFamily(){
    return countFamily("familyCount");
  }

  public CommunityRequest countFamily(String retName){
    return countFamily(retName, FamilyRequest.newInstance());
  }

  public CommunityRequest countFamily(FamilyRequest family) {
    return countFamily("familyCount", family);
  }

  public CommunityRequest countFamily(String retName, FamilyRequest family){
    family.count();
    return statsFromFamily(retName, family);
  }

  public CommunityRequest statsFromFamily(String retName, FamilyRequest family){
    return addDynamicProperty(retName, family, Family.COMMUNITY_PROPERTY);
  }





   public CommunityRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
   public CommunityRequest statsOnly(){
    limit(0,0);
    return this;
  }

  public CommunityRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CommunityRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }

}

