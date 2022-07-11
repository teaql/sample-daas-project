package com.doublechaintech.model.publickeytype;

import com.doublechaintech.model.AccessKey;
import com.doublechaintech.model.ModelBaseUtils;
import com.doublechaintech.model.ModelUserContext;

import java.util.Map;

public class PublicKeyTypeTable {

  public static AccessKey withId(Object value) {
    AccessKey accessKey = new AccessKey();
    accessKey.setColumnName(COLUMN_ID);
    accessKey.setValue(value);
    return accessKey;
  }
  // Add extra identifiers

  // only this package can use this, so the scope is default, not public, not private either nor
  // protected
  public static final String TABLE_NAME = "public_key_type_data";
  static final String COLUMN_ID = "id";
  static final String COLUMN_KEY_ALG = "key_alg";
  static final String COLUMN_SIGN_ALG = "sign_alg";
  static final String COLUMN_DOMAIN = "domain";
  static final String COLUMN_VERSION = "version";

  public static final String[] ALL_CLOUMNS = {
    COLUMN_ID, COLUMN_KEY_ALG, COLUMN_SIGN_ALG, COLUMN_DOMAIN, COLUMN_VERSION
  };
  public static final String[] NORMAL_CLOUMNS = {COLUMN_KEY_ALG, COLUMN_SIGN_ALG, COLUMN_DOMAIN};

  public static void ensureTable(ModelUserContext userContext, Map<String, Object> result)
      throws Exception {
    ModelBaseUtils.ensureTable(
        userContext,
        result,
        "public_key_type_data",
        new String[][] {
          new String[] {"id", "varchar(48)", " not null", "ID", "", ""},
          new String[] {"key_alg", "varchar(10)", "", "键 ALG", "", ""},
          new String[] {"sign_alg", "varchar(50)", "", "Alg迹象", "", ""},
          new String[] {"domain", "varchar(48)", "", "域", "user_domain_data", "id"},
          new String[] {"version", "int", "", "版本", "", ""}
        },
        "公钥类型",
        new String[] {
          "create unique index idx4id_ver_of_public_key_type on public_key_type_data (id, version);",
          "create  index idx4version_of_public_key_type on public_key_type_data (version);"
        },
        new String[] {
          "alter table public_key_type_data add constraint pk4id_of_public_key_type_data primary key (id);",
          "alter table public_key_type_data add constraint fk4domain_of_public_key_type_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
          ""
        });
  }
}
