package com.terapico.caf.appview;

import com.terapico.changerequest.CRSpec;
import com.terapico.utils.CollectionUtils;
import com.terapico.utils.MapUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRGroupData {
  protected String id;
  protected String name; // : person_info.male,       > group的命名保证整个CR中不重复即可
  protected String title; // : 男方信息
  protected boolean hidden; //
  protected List<CRFieldData> fieldList;
  protected List<CRAction> actionList;
  protected Map<String, CRAction> actions;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isHidden() {
    return hidden;
  }

  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  public List<CRFieldData> getFieldList() {
    return fieldList;
  }

  public void setFieldList(List<CRFieldData> fieldList) {
    this.fieldList = fieldList;
  }

  public List<CRAction> getActionList() {
    return actionList;
  }

  public void setActionList(List<CRAction> actionList) {
    this.actionList = actionList;
  }

  public Map<String, CRAction> getActions() {
    return actions;
  }

  public void setActions(Map<String, CRAction> actions) {
    this.actions = actions;
  }

  /*
   * ******** ********** ************
   */
  public void addField(CRFieldData fieldData) {
    ensureFieldList().add(fieldData);
  }

  protected List<CRFieldData> ensureFieldList() {
    if (this.getFieldList() == null) {
      this.setFieldList(new ArrayList<>());
    }
    return this.getFieldList();
  }

  public void addAction(CRSpec crSpec, String code, String title, String url) {
    CRAction action = new CRAction();
    action.setCode(code);
    action.setTitle(title);
    action.setLinkToUrl(url);

    ensureActionList().add(action);
    ensureActions().put(code, action);
  }

  protected List<CRAction> ensureActionList() {
    if (actionList == null) {
      actionList = new ArrayList<>();
    }
    return actionList;
  }

  protected Map<String, CRAction> ensureActions() {
    if (actions == null) {
      actions = new HashMap<>();
    }
    return actions;
  }

  public CRFieldSelector tryField(String fieldId, String fieldName) {
    return new CRFieldSelector(this, fieldId, fieldName, false);
  }

  public CRFieldSelector ensureField(String fieldId, String fieldName) {
    return new CRFieldSelector(this, fieldId, fieldName, true);
  }

  public void addPreviousExistsInList(List<Object> existsRecordList) {
    if (existsRecordList == null || existsRecordList.isEmpty()) {
      return;
    }
    CRFieldData data = makeCrFieldDataByExistsList(existsRecordList);
    fieldList.add(0, data);
  }


  public void addNextExistsInList(List<Object> existsRecordList) {
    if (existsRecordList == null || existsRecordList.isEmpty()) {
      return;
    }
    CRFieldData data = makeCrFieldDataByExistsList(existsRecordList);
    fieldList.add(data);
  }

  protected CRFieldData makeCrFieldDataByExistsList(List<Object> existsRecordList) {
    CRFieldData data = new CRFieldData();
    data.setDisabled(true);
    data.setType("display-field");

    data.setValue(
            MapUtil.put(
                    "kids",
                    CollectionUtils.toList(
                            MapUtil.put("id", 1)
                                    .put("type", "listof")
                                    .put("list", existsRecordList)
                                    .into_map())
            ).into_map());
    data.setRequired(false);
    return data;
  }
}
