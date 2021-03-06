package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
import java.util.List;

public class VComponentSection extends BaseVC {
  protected String title;
  protected String brief;
  protected String icon;
  protected String viewGroup;
  protected String displayMode;
  protected Boolean horizontal;
  private List<VComponentAction> actionList;

  public VComponentSection() {
    super();
    this.setComponentType(VComponent.SECTION);
  }

  public VComponentSection id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentSection linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentSection title(String value) {
    this.title = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentSection brief(String value) {
    this.brief = value;
    return this;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String value) {
    this.icon = value;
  }

  public VComponentSection icon(String value) {
    this.icon = value;
    return this;
  }

  public String getViewGroup() {
    return this.viewGroup;
  }

  public void setViewGroup(String value) {
    this.viewGroup = value;
  }

  public VComponentSection viewGroup(String value) {
    this.viewGroup = value;
    return this;
  }

  public String getDisplayMode() {
    return this.displayMode;
  }

  public void setDisplayMode(String value) {
    this.displayMode = value;
  }

  public VComponentSection displayMode(String value) {
    this.displayMode = value;
    return this;
  }

  public Boolean getHorizontal() {
    return this.horizontal;
  }

  public void setHorizontal(Boolean value) {
    this.horizontal = value;
  }

  public VComponentSection horizontal(Boolean value) {
    this.horizontal = value;
    return this;
  }

  public List<VComponentAction> getActionList() {
    return actionList;
  }

  public void setActionList(List<VComponentAction> actionList) {
    this.actionList = actionList;
  }

  public VComponentSection setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(value, String.class, "section???title?????????String??????")) {
          setTitle((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(value, String.class, "section???brief?????????String??????")) {
          setBrief((String) value);
        }
        return this;
      case "icon":
        if (checkAttributeValueAssignable(value, String.class, "section???icon?????????String??????")) {
          setIcon((String) value);
        }
        return this;
      case "viewGroup":
        if (checkAttributeValueAssignable(value, String.class, "section???viewGroup?????????String??????")) {
          setViewGroup((String) value);
        }
        return this;
      case "displayMode":
        if (checkAttributeValueAssignable(value, String.class, "section???displayMode?????????String??????")) {
          setDisplayMode((String) value);
        }
        return this;
      case "horizontal":
        if (checkAttributeValueAssignable(value, Boolean.class, "section???horizontal?????????Boolean??????")) {
          setHorizontal((Boolean) value);
        }
        return this;
      default:
        throw new RuntimeException("section ????????????????????? " + stdAttrName);
    }
  }

  public VComponentSection actionList(List<VComponentAction> value) {
    this.actionList = value;
    return this;
  }

  public VComponentSection actionList(VComponentAction value) {
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
}
