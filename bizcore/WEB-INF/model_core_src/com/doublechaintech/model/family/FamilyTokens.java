package com.doublechaintech.model.family;

import com.doublechaintech.model.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.model.community.CommunityTokens;
import com.doublechaintech.model.kid.KidTokens;

public class FamilyTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "family";

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

  protected FamilyTokens() {
    // ensure not initialized outside the class
  }

  public static FamilyTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    FamilyTokens tokens = new FamilyTokens(options);
    return tokens;
  }

  protected FamilyTokens(Map<String, Object> options) {
    this.options = options;
  }

  public FamilyTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static FamilyTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected FamilyTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static FamilyTokens start() {
    return new FamilyTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public FamilyTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static FamilyTokens loadGroupTokens(String... groupNames) {
    FamilyTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COMMUNITY, groupNames, new String[] {"default"});

    addToken(tokens, KID_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      FamilyTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static FamilyTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withCommunity().withKidListIfViewGroupInclude(viewGroups);
  }

  public static FamilyTokens allTokens() {

    return start().withCommunity().withKidList();
  }

  public static FamilyTokens withoutListsTokens() {

    return start().withCommunity();
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

  public FamilyTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COMMUNITY = "community";

  public String getCommunity() {
    return COMMUNITY;
  }
  //
  public FamilyTokens withCommunity() {
    addSimpleOptions(COMMUNITY);
    return this;
  }

  public CommunityTokens withCommunityTokens() {
    // addSimpleOptions(COMMUNITY);
    return CommunityTokens.start();
  }

  protected static final String KID_LIST = "kidList";

  public String getKidList() {
    return KID_LIST;
  }

  public FamilyTokens withKidListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(KID_LIST);
    }
    return this;
  }

  public FamilyTokens withKidList() {
    addSimpleOptions(KID_LIST);
    return this;
  }

  public KidTokens withKidListTokens() {
    // addSimpleOptions(KID_LIST);
    return KidTokens.start();
  }

  public FamilyTokens analyzeKidList() {
    addSimpleOptions(KID_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeKidListEnabled() {

    if (checkOptions(this.options(), KID_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public FamilyTokens extractMoreFromKidList(String idsSeperatedWithComma) {
    addSimpleOptions(KID_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int kidListSortCounter = 0;

  public FamilyTokens sortKidListWith(String field, String descOrAsc) {
    addSortMoreOptions(KID_LIST, kidListSortCounter++, field, descOrAsc);
    return this;
  }

  private int kidListSearchCounter = 0;

  public FamilyTokens searchKidListWith(String field, String verb, String value) {

    withKidList();
    addSearchMoreOptions(KID_LIST, kidListSearchCounter++, field, verb, value);
    return this;
  }

  public FamilyTokens searchAllTextOfKidList(String verb, String value) {
    String field = "id|name";
    addSearchMoreOptions(KID_LIST, kidListSearchCounter++, field, verb, value);
    return this;
  }

  public FamilyTokens rowsPerPageOfKidList(int rowsPerPage) {
    addSimpleOptions(KID_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public FamilyTokens currentPageNumberOfKidList(int currentPageNumber) {
    addSimpleOptions(KID_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public FamilyTokens retainColumnsOfKidList(String[] columns) {
    addSimpleOptions(KID_LIST + "RetainColumns", columns);
    return this;
  }

  public FamilyTokens excludeColumnsOfKidList(String[] columns) {
    addSimpleOptions(KID_LIST + "ExcludeColumns", columns);
    return this;
  }

  public FamilyTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfKidList(verb, value);
    return this;
  }
}
