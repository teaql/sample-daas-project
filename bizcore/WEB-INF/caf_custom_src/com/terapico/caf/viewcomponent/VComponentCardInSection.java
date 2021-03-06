package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
import java.util.List;

public class VComponentCardInSection extends BaseVC {
  protected String title;
  protected String brief;
  protected String imageUrl;
  protected String status;
  protected String flag;
  protected String level;
  protected String mode;
  protected String content;
  protected String displayMode;
  protected List<VComponentAction> actionList;
  private List<VComponentInfoListItem> infoList;

  public VComponentCardInSection() {
    super();
    this.setComponentType(VComponent.CARD_IN_SECTION);
  }

  public VComponentCardInSection id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentCardInSection linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentCardInSection title(String value) {
    this.title = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentCardInSection brief(String value) {
    this.brief = value;
    return this;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String value) {
    this.imageUrl = value;
  }

  public VComponentCardInSection imageUrl(String value) {
    this.imageUrl = value;
    return this;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String value) {
    this.status = value;
  }

  public VComponentCardInSection status(String value) {
    this.status = value;
    return this;
  }

  public String getFlag() {
    return this.flag;
  }

  public void setFlag(String value) {
    this.flag = value;
  }

  public VComponentCardInSection flag(String value) {
    this.flag = value;
    return this;
  }

  public String getLevel() {
    return this.level;
  }

  public void setLevel(String value) {
    this.level = value;
  }

  public VComponentCardInSection level(String value) {
    this.level = value;
    return this;
  }

  public String getMode() {
    return this.mode;
  }

  public void setMode(String value) {
    this.mode = value;
  }

  public VComponentCardInSection mode(String value) {
    this.mode = value;
    return this;
  }

  public List<VComponentAction> getActionList() {
    return this.actionList;
  }

  public void setActionList(List<VComponentAction> value) {
    this.actionList = value;
  }

  public VComponentCardInSection actionList(List<VComponentAction> value) {
    this.actionList = value;
    return this;
  }

  public VComponentCardInSection actionList(VComponentAction value) {
    ensureActionList().add(value);
    return this;
  }

  protected List<VComponentAction> ensureActionList() {
    if (this.actionList != null) {
      return this.actionList;
    }
    this.actionList = new ArrayList<>();
    return this.actionList;
  }

  public VComponentCardInSection setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section???title?????????String??????")) {
          setTitle((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section???brief?????????String??????")) {
          setBrief((String) value);
        }
        return this;
      case "imageUrl":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section???imageUrl?????????String??????")) {
          setImageUrl((String) value);
        }
        return this;
      case "status":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section???status?????????String??????")) {
          setStatus((String) value);
        }
        return this;
      case "flag":
        if (checkAttributeValueAssignable(value, String.class, "card_in_section???flag?????????String??????")) {
          setFlag((String) value);
        }
        return this;
      case "level":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section???level?????????String??????")) {
          setLevel((String) value);
        }
        return this;
      case "mode":
        if (checkAttributeValueAssignable(value, String.class, "card_in_section???mode?????????String??????")) {
          setMode((String) value);
        }
        return this;
      case "actionList":
        if (checkAttributeValueAssignableFromList(
            value,
            VComponentAction.class,
            "card_in_section???actionList?????????List<VComponentAction>??????")) {
          setActionList((List<VComponentAction>) value);
        }
        return this;
      default:
        throw new RuntimeException("card_in_section ????????????????????? " + stdAttrName);
    }
  }

  public List<VComponentInfoListItem> getInfoList() {
    return infoList;
  }

  public void setInfoList(List<VComponentInfoListItem> infoList) {
    this.infoList = infoList;
  }

  protected List<VComponentInfoListItem> ensureInfoList() {
    if (this.infoList != null) {
      return this.infoList;
    }
    this.infoList = new ArrayList<>();
    return this.infoList;
  }

  public VComponentCardInSection infoList(String id, String title, String value) {
    ensureInfoList().add(new VComponentInfoListItem().id(id).title(title).value(value));
    ensureInfoList().add(null);
    return this;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public VComponentCardInSection content(String content) {
    this.content = content;
    displayMode = "rich-text";
    return this;
  }

  public String getDisplayMode() {
    return displayMode;
  }

  public void setDisplayMode(String displayMode) {
    this.displayMode = displayMode;
  }
}
