package com.doublechaintech.model.kid;


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
import static com.doublechaintech.model.kid.Kid.*;

public class KidRequest extends BaseRequest<Kid> {
    public static KidRequest newInstance() {
        return new KidRequest().filterByVersion(QueryOperator.GREATER_THAN,0).selectId();
    }

    public KidRequest resultByClass(Class<? extends Kid> clazz){
      overrideResultByClass(clazz);
      return this;
    }

    public KidRequest includeDarknessRows(){
      removeAllVersionCriteria();
      return this;
    }
    public KidRequest onlyDarknessRows(){
      return filterByVersion(QueryOperator.LESS_THAN,0);
    }


    public String getInternalType() {
        return "Kid";
    }

    public KidRequest findWithJson(JsonNode jsonExpr){
        this.mergeClauses(jsonExpr);
        return this;
    }


    public KidRequest addDynamicProperty(String propertyName, BaseRequest request, String parentPropertyName) {
      getDynamicAttributes().add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
      return this;
    }

    public KidRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public KidRequest select(String... names) {
        super.select(names);
        return this;
    }

    public KidRequest selectAll() {return this.selectId().selectName().selectFamily().selectVersion();
    }

    public KidRequest selectAny() {return selectAll();
        }

    public KidRequest selectSelf() {
      select(ID_PROPERTY);
      select(NAME_PROPERTY);
      select(FAMILY_PROPERTY);
      select(VERSION_PROPERTY);
    
      return this;
    }

    public KidRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public KidRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      if(pQueryOperator.isNoOperator()){
        return this;
      }
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

    protected static final String[] DATE_OR_TIME_FIELDS={};
    protected static final String[] ALL_SELF_FIELDS={ID_PROPERTY,NAME_PROPERTY,FAMILY_PROPERTY,VERSION_PROPERTY};

    @Override
    protected boolean isDateOrTimeField(String fieldName) {
      return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
    }

    @Override
    protected boolean isOneOfSelfField(String fieldName) {
      return super.isOneOf(fieldName, ALL_SELF_FIELDS);
    }


    public KidRequest where(JsonNode jsonNode) {
      this.addJsonFilter(jsonNode);
      return this;
    }

    public KidRequest comment(String comment) {
      return this;
    }

    public KidRequest enhance() {
      return this;
    }

    public KidRequest overrideClass(Class<? extends  Kid> clazz ) {
      return this;
    }

    public KidRequest aggregate(String aggName, AggFunc fuc, String... properties) {
      super.aggregate(aggName, fuc, properties);
      return this;
    }

   public KidRequest groupBy(String retName, String propertyName) {
      super.groupBy(retName, SqlFunction.SELF, propertyName);
     return this;
   }

   public KidRequest groupBy(String propertyName) {
     super.groupBy(propertyName);
     return this;
   }

   public KidRequest groupBy(String ret, SqlFunction fun, String... properties) {
     super.groupBy(ret, fun, properties);
     return this;
   }

   public KidRequest count(){
      return countId("count");
   }

   
     public static KidRequest withId(String... id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public KidRequest filterById(String... id) {
          if (isEmptyParam(id)) {
            throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
          }
          return filterById(QueryOperator.IN, (Object[])id);
      }
    

















      public KidRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KidRequest selectId(){
          return select(ID_PROPERTY);
      }

      public KidRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public KidRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
      public KidRequest orderByIdAscending(){
        addOrderBy(ID_PROPERTY, true);
        return this;
      }
      public KidRequest orderByIdDescending(){
        addOrderBy(ID_PROPERTY, false);
        return this;
      }

      
      public KidRequest countId(){
          return countId("countId");
      }

      public KidRequest countId(String aggName){
          return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
      }

     
      public KidRequest maxId(){
          return maxId("maxId");
      }

      public KidRequest maxId(String aggName){
          return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
      }

     
      public KidRequest minId(){
          return minId("minId");
      }

      public KidRequest minId(String aggName){
          return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
      }

     

      

      public KidRequest groupById() {
        return groupById(ID_PROPERTY);
      }

      public KidRequest groupById(String ret) {
        return groupBy(ret, ID_PROPERTY);
      }

      public KidRequest groupById(SqlFunction func) {
        return groupById(ID_PROPERTY, func);
      }


      public KidRequest groupById(String ret, SqlFunction func) {
        super.groupBy(ret, func, ID_PROPERTY);
        return this;
      }
   
      public KidRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }

     public KidRequest whereNameIsNull() {
          return where(NAME_PROPERTY,QueryOperator.IS_NULL);
        }

    public KidRequest whereNameIsNotNull() {
      return where(NAME_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public KidRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KidRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public KidRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public KidRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
      public KidRequest orderByNameAscending(){
        addOrderBy(NAME_PROPERTY, true);
        return this;
      }
      public KidRequest orderByNameDescending(){
        addOrderBy(NAME_PROPERTY, false);
        return this;
      }

      
      public KidRequest countName(){
          return countName("countName");
      }

      public KidRequest countName(String aggName){
          return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
      }

     
      public KidRequest maxName(){
          return maxName("maxName");
      }

      public KidRequest maxName(String aggName){
          return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
      }

     
      public KidRequest minName(){
          return minName("minName");
      }

      public KidRequest minName(String aggName){
          return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
      }

     

      

      public KidRequest groupByName() {
        return groupByName(NAME_PROPERTY);
      }

      public KidRequest groupByName(String ret) {
        return groupBy(ret, NAME_PROPERTY);
      }

      public KidRequest groupByName(SqlFunction func) {
        return groupByName(NAME_PROPERTY, func);
      }


      public KidRequest groupByName(String ret, SqlFunction func) {
        super.groupBy(ret, func, NAME_PROPERTY);
        return this;
      }
   
      public KidRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }

     public KidRequest whereVersionIsNull() {
          return where(VERSION_PROPERTY,QueryOperator.IS_NULL);
        }

    public KidRequest whereVersionIsNotNull() {
      return where(VERSION_PROPERTY,QueryOperator.IS_NOT_NULL);
    }
    

















      public KidRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public KidRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public KidRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }
      @Deprecated
      public KidRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
      public KidRequest orderByVersionAscending(){
        addOrderBy(VERSION_PROPERTY, true);
        return this;
      }
      public KidRequest orderByVersionDescending(){
        addOrderBy(VERSION_PROPERTY, false);
        return this;
      }

      
      public KidRequest countVersion(){
          return countVersion("countVersion");
      }

      public KidRequest countVersion(String aggName){
          return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
      }

     
      public KidRequest maxVersion(){
          return maxVersion("maxVersion");
      }

      public KidRequest maxVersion(String aggName){
          return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
      }

     
      public KidRequest minVersion(){
          return minVersion("minVersion");
      }

      public KidRequest minVersion(String aggName){
          return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
      }

     

      
      public KidRequest sumVersion(){
          return sumVersion("sumVersion");
      }

      public KidRequest sumVersion(String aggName){
          return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
      }

     

      public KidRequest groupByVersion() {
        return groupByVersion(VERSION_PROPERTY);
      }

      public KidRequest groupByVersion(String ret) {
        return groupBy(ret, VERSION_PROPERTY);
      }

      public KidRequest groupByVersion(SqlFunction func) {
        return groupByVersion(VERSION_PROPERTY, func);
      }


      public KidRequest groupByVersion(String ret, SqlFunction func) {
        super.groupBy(ret, func, VERSION_PROPERTY);
        return this;
      }
   


  

    
    public KidRequest filterByFamily(FamilyRequest family){
        return filterByFamily(family, Family::getId);
    }

    public KidRequest filterByFamily(Family... family){
        if(isEmptyParam(family)){
          throw new IllegalArgumentException("filterByFamily(Family... family)参数不能为空!");
        }
        return where(FAMILY_PROPERTY, QueryOperator.IN, (Object[])family);
    }

    public KidRequest selectFamilyId(){
       select(FAMILY_PROPERTY);
       return this;
    }

    public FamilyRequest upToFamily(){
       return upToFamily(FamilyRequest.newInstance());
    }

    public FamilyRequest upToFamily(FamilyRequest family){
       family.aggregateChild(FAMILY_PROPERTY, this);
       this.groupByFamily(family);
       return family;
    }


     public FamilyRequest endAtFamily(String retName){
           return endAtFamily(retName, FamilyRequest.newInstance());
        }

    public FamilyRequest endAtFamily(String retName, FamilyRequest family){
       family.addDynamicProperty(retName, this, FAMILY_PROPERTY);
       return family;
    }

    public KidRequest filterByFamily(String... family){
        if(isEmptyParam(family)){
           throw new IllegalArgumentException("filterByFamily(String... family)参数不能为空!");
        }
        return where(FAMILY_PROPERTY, QueryOperator.IN, (Object[])family);
    }

    public KidRequest filterByFamily(FamilyRequest family, IDRefine<Family> idRefine) {
        family.unlimited();
        return addSearchCriteria(createFamilyCriteria(family, idRefine));
    }

    public SearchCriteria createFamilyCriteria(FamilyRequest family, IDRefine<Family> idRefine) {
        return new RefinedIdInCriteria(family, FAMILY_PROPERTY, idRefine, Family.ID_PROPERTY);
    }




    

    
    public KidRequest selectFamily(){
        return selectFamily(FamilyRequest.newInstance().selectSelf());
    }

    public KidRequest selectFamily(FamilyRequest family){
        selectParent(FAMILY_PROPERTY, family);
        return this;
    }
    

    public KidRequest unselectFamily(){
        unselectParent(FAMILY_PROPERTY);
        return this;
    }

    public KidRequest groupByFamily(FamilyRequest family){
        groupBy(FAMILY_PROPERTY, family);
        return this;
    }

    public KidRequest aggregateFamily(FamilyRequest family){
        aggregateParent(FAMILY_PROPERTY, family);
        return this;
    }

    public KidRequest countFamily(){
        return countFamily("countFamily");
    }

    public KidRequest countFamily(String aggName){
        return aggregate(aggName, AggFunc.COUNT, FAMILY_PROPERTY);
    }

    public KidRequest groupByFamily() {
      return groupByFamily(FAMILY_PROPERTY);
    }

    public KidRequest groupByFamily(String ret) {
      return groupBy(ret, FAMILY_PROPERTY);
    }

    public KidRequest whereFamilyIsNull() {
          return where(FAMILY_PROPERTY,QueryOperator.IS_NULL);
        }

    public KidRequest whereFamilyIsNotNull() {
      return where(FAMILY_PROPERTY,QueryOperator.IS_NOT_NULL);
    }

  


  



  




   public KidRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
   public KidRequest statsOnly(){
    limit(0,0);
    return this;
  }

  public KidRequest unlimited() {
    super.unlimited();
    return this;
  }

  public KidRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }

}

