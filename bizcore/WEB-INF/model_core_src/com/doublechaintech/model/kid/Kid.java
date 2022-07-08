
package com.doublechaintech.model.kid;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.model.search.*;
import com.doublechaintech.model.*;
import com.doublechaintech.model.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.model.family.Family;









@JsonSerialize(using = KidSerializer.class)
public class Kid extends BaseEntity implements  java.io.Serializable{







public void transferAllRelationshipsTo(Kid target){
     if(target == null){
       return;
     }
     
 }


	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FAMILY_PROPERTY                = "family"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Kid";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FAMILY_PROPERTY, "family", "家庭")
        .withType("family", Family.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,FAMILY_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(FAMILY_PROPERTY, Family.class);

    return parents;
  }
  /*
  public Kid want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Kid wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	name                ;
	protected		Family              	family              ;
	protected		int                 	version             ;

	



	public 	Kid(){
		// lazy load for all the properties
	}
	public 	static Kid withId(String id){
		Kid kid = new Kid();
		kid.setId(id);
		kid.setVersion(Integer.MAX_VALUE);
		kid.setChecked(true);
		return kid;
	}
	public 	static Kid refById(String id){
		return withId(id);
	}

  public Kid limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Kid limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Kid searchExample(){
    Kid kid = new Kid();
    		kid.setVersion(UNSET_INT);

    return kid;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
	public 	void clearFromAll(){
		setFamily( null );

		this.changed = true;
		setChecked(false);
	}  */
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {

		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}


	}

    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}


			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(FAMILY_PROPERTY.equals(property)){
			return getFamily();
		}

    		//other property not include here
		return super.propertyOf(property);
	}

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public Kid updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)){
        return this;
      }addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Kid orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Kid ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Kid addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { updateId(id);}
	}

	







	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public Kid updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;if (cn.hutool.core.util.ObjectUtil.equals(newName, oldName)){
        return this;
      }addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public Kid orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public Kid ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public Kid addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { updateName(name);}
	}

	







	public void setFamily(Family family){Family oldFamily = this.family;Family newFamily = family;this.family = newFamily;}
	public Family family(){
doLoad();
return getFamily();
}
	public Family getFamily(){
		return this.family;
	}
	public Kid updateFamily(Family family){Family oldFamily = this.family;Family newFamily = family;if(!shouldReplaceBy(newFamily, oldFamily)){return this;}this.family = newFamily;if (cn.hutool.core.util.ObjectUtil.equals(newFamily, oldFamily)){
        return this;
      }addPropertyChange(FAMILY_PROPERTY, oldFamily, newFamily);this.changed = true;setChecked(false);return this;}
	public Kid orderByFamily(boolean asc){
doAddOrderBy(FAMILY_PROPERTY, asc);
return this;
}
	public SearchCriteria createFamilyCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FAMILY_PROPERTY, operator, parameters);
}
	public Kid ignoreFamilyCriteria(){super.ignoreSearchProperty(FAMILY_PROPERTY);
return this;
}
	public Kid addFamilyCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFamilyCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFamily(Family family){
		if(family != null) { updateFamily(family);}
	}

	
  public  Kid updateFamilyByReferenceId(String familyId){ updateFamily(Family.refById(familyId)); return this;}
	public void clearFamily(){
		setFamily ( null );
		this.changed = true;
		setChecked(false);
	}
	







	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public Kid updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)){
        return this;
      }addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Kid orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Kid ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Kid addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		if(version >= 0) { updateVersion(version);}
	}

	








	public void collectReferences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getFamily(), internalType);


	}

	public List<BaseEntity>  collectReferencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();



		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FAMILY_PROPERTY, getFamily());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){

		super.copyTo(baseDest);
		if(baseDest instanceof Kid){


			Kid dest =(Kid)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setFamily(getFamily());
			dest.setVersion(getVersion());

		}

		return baseDest;
	}
	public BaseEntity mergeDataFrom(BaseEntity sourceEntity){


		if(sourceEntity instanceof Kid){


			Kid source = (Kid)sourceEntity;


			mergeId(source.getId());
			mergeName(source.getName());
			mergeFamily(source.getFamily());
			mergeVersion(source.getVersion());

		}

		return this;
	}

	public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity){

		//super.mergePrimitiveDataFrom(sourceEntity);
		if(sourceEntity instanceof Kid){


			Kid source =(Kid)sourceEntity;

			mergeId(source.getId());
			mergeName(source.getName());
			mergeVersion(source.getVersion());

		}
		return this;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFamily(), getVersion()};
	}



	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Kid{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getFamily() != null ){
 			stringBuilder.append("\tfamily='Family("+getFamily().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}




