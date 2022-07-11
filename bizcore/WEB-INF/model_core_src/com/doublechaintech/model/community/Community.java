package com.doublechaintech.model.community;

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

@JsonSerialize(using = CommunitySerializer.class)
public class Community extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(Community target) {
    if (target == null) {
      return;
    }
    target.addFamilyList(this.getFamilyList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String ADDRESS_PROPERTY = "address";
  public static final String VERSION_PROPERTY = "version";

  public static final String FAMILY_LIST = "familyList";

  public static final String INTERNAL_TYPE = "Community";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ADDRESS_PROPERTY, "address", "地址")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(FAMILY_LIST, "community", "家庭列表").withType("family", Family.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {ID_PROPERTY, NAME_PROPERTY, ADDRESS_PROPERTY, VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(FAMILY_LIST, "community");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(FAMILY_LIST, Family.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();

    return parents;
  }
  /*
  public Community want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Community wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getName();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String address;
  protected int version;

  protected SmartList<Family> mFamilyList;

  public Community() {
    // lazy load for all the properties
  }

  public static Community withId(String id) {
    Community community = new Community();
    community.setId(id);
    community.setVersion(Integer.MAX_VALUE);
    community.setChecked(true);
    return community;
  }

  public static Community refById(String id) {
    return withId(id);
  }

  public Community limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public Community limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static Community searchExample() {
    Community community = new Community();
    community.setVersion(UNSET_INT);

    return community;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (ADDRESS_PROPERTY.equals(property)) {
      changeAddressProperty(newValueExpr);
    }
  }

  protected void changeNameProperty(String newValueExpr) {

    String oldValue = getName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateName(newValue);
    this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAddressProperty(String newValueExpr) {

    String oldValue = getAddress();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAddress(newValue);
    this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (ADDRESS_PROPERTY.equals(property)) {
      return getAddress();
    }
    if (FAMILY_LIST.equals(property)) {
      List<BaseEntity> list =
          getFamilyList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public Community updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Community orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public Community ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public Community addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    this.name = newName;
  }

  public String name() {
    doLoad();
    return getName();
  }

  public String getName() {
    return this.name;
  }

  public Community updateName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    if (!shouldReplaceBy(newName, oldName)) {
      return this;
    }
    this.name = newName;
    if (cn.hutool.core.util.ObjectUtil.equals(newName, oldName)) {
      return this;
    }
    addPropertyChange(NAME_PROPERTY, oldName, newName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Community orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public Community ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public Community addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setAddress(String address) {
    String oldAddress = this.address;
    String newAddress = trimString(address);
    this.address = newAddress;
  }

  public String address() {
    doLoad();
    return getAddress();
  }

  public String getAddress() {
    return this.address;
  }

  public Community updateAddress(String address) {
    String oldAddress = this.address;
    String newAddress = trimString(address);
    if (!shouldReplaceBy(newAddress, oldAddress)) {
      return this;
    }
    this.address = newAddress;
    if (cn.hutool.core.util.ObjectUtil.equals(newAddress, oldAddress)) {
      return this;
    }
    addPropertyChange(ADDRESS_PROPERTY, oldAddress, newAddress);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Community orderByAddress(boolean asc) {
    doAddOrderBy(ADDRESS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAddressCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ADDRESS_PROPERTY, operator, parameters);
  }

  public Community ignoreAddressCriteria() {
    super.ignoreSearchProperty(ADDRESS_PROPERTY);
    return this;
  }

  public Community addAddressCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAddressCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAddress(String address) {
    if (address != null) {
      updateAddress(address);
    }
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public Community updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Community orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public Community ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public Community addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<Family> getFamilyList() {
    if (this.mFamilyList == null) {
      this.mFamilyList = new SmartList<Family>();
      this.mFamilyList.setListInternalName(FAMILY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mFamilyList;
  }

  public SmartList<Family> familyList() {

    doLoadChild(FAMILY_LIST);

    return getFamilyList();
  }

  public void setFamilyList(SmartList<Family> familyList) {
    for (Family family : familyList) {
      family.setCommunity(this);
    }

    this.mFamilyList = familyList;
    this.mFamilyList.setListInternalName(FAMILY_LIST);
  }

  public Community addFamily(Family family) {
    family.updateCommunity(this);
    getFamilyList().add(family);
    return this;
  }

  public Community addFamilyList(SmartList<Family> familyList) {
    for (Family family : familyList) {
      family.updateCommunity(this);
    }

    Map<String, Family> mapById = familyList.mapWithId();
    getFamilyList().removeIf(item -> mapById.get(item.getId()) != null);
    getFamilyList().addAll(familyList);
    return this;
  }

  public void mergeFamilyList(SmartList<Family> familyList) {
    if (familyList == null) {
      return;
    }
    if (familyList.isEmpty()) {
      return;
    }
    addFamilyList(familyList);
  }

  public Family removeFamily(Family familyIndex) {

    int index = getFamilyList().indexOf(familyIndex);
    if (index < 0) {
      String message =
          "Family("
              + familyIndex.getId()
              + ") with version='"
              + familyIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Family family = getFamilyList().get(index);
    // family.clearCommunity(); //disconnect with Community
    family.clearFromAll(); // disconnect with Community

    boolean result = getFamilyList().planToRemove(family);
    if (!result) {
      String message =
          "Family("
              + familyIndex.getId()
              + ") with version='"
              + familyIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return family;
  }
  // 断舍离
  public void breakWithFamily(Family family) {

    if (family == null) {
      return;
    }
    family.setCommunity(null);
    // getFamilyList().remove();

  }

  public boolean hasFamily(Family family) {

    return getFamilyList().contains(family);
  }

  public void copyFamilyFrom(Family family) {

    Family familyInList = findTheFamily(family);
    Family newFamily = new Family();
    familyInList.copyTo(newFamily);
    newFamily.setVersion(0); // will trigger copy
    getFamilyList().add(newFamily);
    addItemToFlexiableObject(COPIED_CHILD, newFamily);
  }

  public Family findTheFamily(Family family) {

    int index = getFamilyList().indexOf(family);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Family(" + family.getId() + ") with version='" + family.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getFamilyList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpFamilyList() {
    getFamilyList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {}

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getFamilyList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getFamilyList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, FAMILY_LIST, getFamilyList());
    if (!getFamilyList().isEmpty()) {
      appendKeyValuePair(result, "familyCount", getFamilyList().getTotalCount());
      appendKeyValuePair(result, "familyCurrentPageNumber", getFamilyList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof Community) {

      Community dest = (Community) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setAddress(getAddress());
      dest.setVersion(getVersion());
      dest.setFamilyList(getFamilyList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof Community) {

      Community source = (Community) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeAddress(source.getAddress());
      mergeVersion(source.getVersion());
      mergeFamilyList(source.getFamilyList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof Community) {

      Community source = (Community) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeAddress(source.getAddress());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getAddress(), getVersion()};
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("Community{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\taddress='" + getAddress() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
