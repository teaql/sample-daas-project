
package com.doublechaintech.model.family;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.model.search.*;
import com.doublechaintech.model.*;
import com.doublechaintech.model.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.model.community.Community;
import com.doublechaintech.model.kid.Kid;









@JsonSerialize(using = FamilySerializer.class)
public class Family extends BaseEntity implements  java.io.Serializable{







public void transferAllRelationshipsTo(Family target){
     if(target == null){
       return;
     }
     target.addKidList(this.getKidList());
 }


	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String COMMUNITY_PROPERTY             = "community"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String KID_LIST                                 = "kidList"           ;

	public static final String INTERNAL_TYPE="Family";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COMMUNITY_PROPERTY, "community", "社区")
        .withType("community", Community.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(KID_LIST, "family", "孩子列表")
        .withType("kid", Kid.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,COMMUNITY_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(KID_LIST, "family");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(KID_LIST, Kid.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMMUNITY_PROPERTY, Community.class);

    return parents;
  }
  /*
  public Family want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Family wants(Class<? extends BaseEntity>... classes) {
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
	protected		Community           	community           ;
	protected		int                 	version             ;

	
	protected		SmartList<Kid>      	mKidList            ;



	public 	Family(){
		// lazy load for all the properties
	}
	public 	static Family withId(String id){
		Family family = new Family();
		family.setId(id);
		family.setVersion(Integer.MAX_VALUE);
		family.setChecked(true);
		return family;
	}
	public 	static Family refById(String id){
		return withId(id);
	}

  public Family limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Family limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Family searchExample(){
    Family family = new Family();
    		family.setVersion(UNSET_INT);

    return family;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
	public 	void clearFromAll(){
		setCommunity( null );

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
		if(COMMUNITY_PROPERTY.equals(property)){
			return getCommunity();
		}
		if(KID_LIST.equals(property)){
			List<BaseEntity> list = getKidList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public Family updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)){
        return this;
      }addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Family orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Family ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Family addIdCriteria(QueryOperator operator, Object... parameters){
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
	public Family updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;if (cn.hutool.core.util.ObjectUtil.equals(newName, oldName)){
        return this;
      }addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public Family orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public Family ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public Family addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { updateName(name);}
	}

	







	public void setCommunity(Community community){Community oldCommunity = this.community;Community newCommunity = community;this.community = newCommunity;}
	public Community community(){
doLoad();
return getCommunity();
}
	public Community getCommunity(){
		return this.community;
	}
	public Family updateCommunity(Community community){Community oldCommunity = this.community;Community newCommunity = community;if(!shouldReplaceBy(newCommunity, oldCommunity)){return this;}this.community = newCommunity;if (cn.hutool.core.util.ObjectUtil.equals(newCommunity, oldCommunity)){
        return this;
      }addPropertyChange(COMMUNITY_PROPERTY, oldCommunity, newCommunity);this.changed = true;setChecked(false);return this;}
	public Family orderByCommunity(boolean asc){
doAddOrderBy(COMMUNITY_PROPERTY, asc);
return this;
}
	public SearchCriteria createCommunityCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COMMUNITY_PROPERTY, operator, parameters);
}
	public Family ignoreCommunityCriteria(){super.ignoreSearchProperty(COMMUNITY_PROPERTY);
return this;
}
	public Family addCommunityCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCommunityCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCommunity(Community community){
		if(community != null) { updateCommunity(community);}
	}

	
  public  Family updateCommunityByReferenceId(String communityId){ updateCommunity(Community.refById(communityId)); return this;}
	public void clearCommunity(){
		setCommunity ( null );
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
	public Family updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)){
        return this;
      }addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Family orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Family ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Family addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		if(version >= 0) { updateVersion(version);}
	}

	








	public  SmartList<Kid> getKidList(){
		if(this.mKidList == null){
			this.mKidList = new SmartList<Kid>();
			this.mKidList.setListInternalName (KID_LIST );
			//有名字，便于做权限控制
		}

		return this.mKidList;
	}

  public  SmartList<Kid> kidList(){
    
    doLoadChild(KID_LIST);
    
    return getKidList();
  }


	public  void setKidList(SmartList<Kid> kidList){
		for( Kid kid:kidList){
			kid.setFamily(this);
		}

		this.mKidList = kidList;
		this.mKidList.setListInternalName (KID_LIST );

	}

	public  Family addKid(Kid kid){
		kid.updateFamily(this);
		getKidList().add(kid);
		return this;
	}
	public  Family addKidList(SmartList<Kid> kidList){
		for( Kid kid:kidList){
			kid.updateFamily(this);
		}

    Map<String,Kid> mapById=kidList.mapWithId();
    getKidList().removeIf(item->mapById.get(item.getId())!=null);
		getKidList().addAll(kidList);
		return this;
	}
	public  void mergeKidList(SmartList<Kid> kidList){
		if(kidList==null){
			return;
		}
		if(kidList.isEmpty()){
			return;
		}
		addKidList( kidList );

	}
	public  Kid removeKid(Kid kidIndex){

		int index = getKidList().indexOf(kidIndex);
        if(index < 0){
        	String message = "Kid("+kidIndex.getId()+") with version='"+kidIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Kid kid = getKidList().get(index);
        // kid.clearFamily(); //disconnect with Family
        kid.clearFromAll(); //disconnect with Family

		boolean result = getKidList().planToRemove(kid);
        if(!result){
        	String message = "Kid("+kidIndex.getId()+") with version='"+kidIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return kid;


	}
	//断舍离
	public  void breakWithKid(Kid kid){

		if(kid == null){
			return;
		}
		kid.setFamily(null);
		//getKidList().remove();

	}

	public  boolean hasKid(Kid kid){

		return getKidList().contains(kid);

	}

	public void copyKidFrom(Kid kid) {

		Kid kidInList = findTheKid(kid);
		Kid newKid = new Kid();
		kidInList.copyTo(newKid);
		newKid.setVersion(0);//will trigger copy
		getKidList().add(newKid);
		addItemToFlexiableObject(COPIED_CHILD, newKid);
	}

	public  Kid findTheKid(Kid kid){

		int index =  getKidList().indexOf(kid);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Kid("+kid.getId()+") with version='"+kid.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getKidList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpKidList(){
		getKidList().clear();
	}





	public void collectReferences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCommunity(), internalType);


	}

	public List<BaseEntity>  collectReferencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getKidList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getKidList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, COMMUNITY_PROPERTY, getCommunity());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, KID_LIST, getKidList());
		if(!getKidList().isEmpty()){
			appendKeyValuePair(result, "kidCount", getKidList().getTotalCount());
			appendKeyValuePair(result, "kidCurrentPageNumber", getKidList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){

		super.copyTo(baseDest);
		if(baseDest instanceof Family){


			Family dest =(Family)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setCommunity(getCommunity());
			dest.setVersion(getVersion());
			dest.setKidList(getKidList());

		}

		return baseDest;
	}
	public BaseEntity mergeDataFrom(BaseEntity sourceEntity){


		if(sourceEntity instanceof Family){


			Family source = (Family)sourceEntity;


			mergeId(source.getId());
			mergeName(source.getName());
			mergeCommunity(source.getCommunity());
			mergeVersion(source.getVersion());
			mergeKidList(source.getKidList());

		}

		return this;
	}

	public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity){

		//super.mergePrimitiveDataFrom(sourceEntity);
		if(sourceEntity instanceof Family){


			Family source =(Family)sourceEntity;

			mergeId(source.getId());
			mergeName(source.getName());
			mergeVersion(source.getVersion());

		}
		return this;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getCommunity(), getVersion()};
	}



	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Family{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getCommunity() != null ){
 			stringBuilder.append("\tcommunity='Community("+getCommunity().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}




