package com.doublechaintech.model.community;

import com.doublechaintech.model.AccessKey;
import com.doublechaintech.model.ModelBaseUtils;
import com.doublechaintech.model.ModelUserContext;

import java.util.Map;

public class CommunityTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "community_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_NAME = "name";
  static final String COLUMN_ADDRESS = "address";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_NAME, COLUMN_ADDRESS, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {COLUMN_NAME, COLUMN_ADDRESS};

  public static void ensureTable(ModelUserContext userContext, Map<String, Object> result)
      throws Exception {
    ModelBaseUtils.ensureTable(
        userContext,
        result,
        "community_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"name", "varchar(100)", "", "名称", "", ""},
          new String[] {"address", "varchar(100)", "", "地址", "", ""},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "社区",
        new String[] {
          "create unique index idx4id_ver_of_community on community_data (id, version);",
          "create  index idx4version_of_community on community_data (version);"
        },
        new String[] {
          "alter table community_data add constraint pk4id_of_community_data primary key (id);", ""
        });
  }
}
