package com.doublechaintech.model.community;

import com.doublechaintech.model.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.model.family.FamilyTokens;

public class CommunityTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "community";

  public static boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    if (options == null) {
      return false; // completely no option here
    }
    if (options.containsKey(ALL)) {
      // danger, debug only, might load the entire database!, really terrible
      return true;
    }
    String ownerKey = getOwnerObjectKey();
    Object ownerObject = (String) options.get(ownerKey);
    if (ownerObject == null) {
      return false;
    }
    if (!ownerObject.equals(OWNER_OBJECT_NAME)) { // is the owner?
      return false;
    }

    if (options.containsKey(optionToCheck)) {
      // options.remove(optionToCheck);
      // consume the key, can not use any more to extract the data with the same token.
      return true;
    }

    return false;
  }

  protected CommunityTokens() {
    // ensure not initialized outside the class
  }

  public static CommunityTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    CommunityTokens tokens = new CommunityTokens(options);
    return tokens;
  }

  protected CommunityTokens(Map<String, Object> options) {
    this.options = options;
  }

  public CommunityTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static CommunityTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected CommunityTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static CommunityTokens start() {
    return new CommunityTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public CommunityTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static CommunityTokens loadGroupTokens(String... groupNames) {
    CommunityTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }

    addToken(tokens, FAMILY_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      CommunityTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null) {
      return;
    }

    for (String groupName : pGroupNames) {
      for (String g : fieldGroups) {
        if (Objects.equals(groupName, g)) {
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

  public static CommunityTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withFamilyListIfViewGroupInclude(viewGroups);
  }

  public static CommunityTokens allTokens() {

    return start().withFamilyList();
  }

  public static CommunityTokens withoutListsTokens() {

    return start();
  }

  public static Map<String, Object> all() {
    return allTokens().done();
  }

  public static Map<String, Object> withoutLists() {
    return withoutListsTokens().done();
  }

  public static Map<String, Object> empty() {
    return start().done();
  }

  public CommunityTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String FAMILY_LIST = "familyList";

  public String getFamilyList() {
    return FAMILY_LIST;
  }

  public CommunityTokens withFamilyListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(FAMILY_LIST);
    }
    return this;
  }

  public CommunityTokens withFamilyList() {
    addSimpleOptions(FAMILY_LIST);
    return this;
  }

  public FamilyTokens withFamilyListTokens() {
    // addSimpleOptions(FAMILY_LIST);
    return FamilyTokens.start();
  }

  public CommunityTokens analyzeFamilyList() {
    addSimpleOptions(FAMILY_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeFamilyListEnabled() {

    if (checkOptions(this.options(), FAMILY_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public CommunityTokens extractMoreFromFamilyList(String idsSeperatedWithComma) {
    addSimpleOptions(FAMILY_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int familyListSortCounter = 0;

  public CommunityTokens sortFamilyListWith(String field, String descOrAsc) {
    addSortMoreOptions(FAMILY_LIST, familyListSortCounter++, field, descOrAsc);
    return this;
  }

  private int familyListSearchCounter = 0;

  public CommunityTokens searchFamilyListWith(String field, String verb, String value) {

    withFamilyList();
    addSearchMoreOptions(FAMILY_LIST, familyListSearchCounter++, field, verb, value);
    return this;
  }

  public CommunityTokens searchAllTextOfFamilyList(String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(FAMILY_LIST, familyListSearchCounter++, field, verb, value);
    return this;
  }

  public CommunityTokens rowsPerPageOfFamilyList(int rowsPerPage) {
    addSimpleOptions(FAMILY_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public CommunityTokens currentPageNumberOfFamilyList(int currentPageNumber) {
    addSimpleOptions(FAMILY_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public CommunityTokens retainColumnsOfFamilyList(String[] columns) {
    addSimpleOptions(FAMILY_LIST + "RetainColumns", columns);
    return this;
  }

  public CommunityTokens excludeColumnsOfFamilyList(String[] columns) {
    addSimpleOptions(FAMILY_LIST + "ExcludeColumns", columns);
    return this;
  }

  public CommunityTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfFamilyList(verb, value);
    return this;
  }
}
