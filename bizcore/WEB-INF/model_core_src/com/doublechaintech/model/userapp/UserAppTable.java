
package com.doublechaintech.model.userapp;
import com.doublechaintech.model.AccessKey;
import com.doublechaintech.model.ModelBaseUtils;
import com.doublechaintech.model.ModelUserContext;

import java.util.Map;

public class UserAppTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="user_app_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_APP_ICON = "app_icon";
	static final String COLUMN_FULL_ACCESS = "full_access";
	static final String COLUMN_PERMISSION = "permission";
	static final String COLUMN_APP_TYPE = "app_type";
	static final String COLUMN_APP_ID = "app_id";
	static final String COLUMN_CTX_TYPE = "ctx_type";
	static final String COLUMN_CTX_ID = "ctx_id";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_SEC_USER,COLUMN_APP_ICON,COLUMN_FULL_ACCESS,COLUMN_PERMISSION,COLUMN_APP_TYPE,COLUMN_APP_ID,COLUMN_CTX_TYPE,COLUMN_CTX_ID,COLUMN_LOCATION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_SEC_USER,COLUMN_APP_ICON,COLUMN_FULL_ACCESS,COLUMN_PERMISSION,COLUMN_APP_TYPE,COLUMN_APP_ID,COLUMN_CTX_TYPE,COLUMN_CTX_ID,COLUMN_LOCATION};

	  public static void ensureTable(ModelUserContext userContext, Map<String, Object> result) throws Exception {
        ModelBaseUtils.ensureTable(userContext, result, "user_app_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"title","varchar(300)","","标题","",""},
                new String[]{"sec_user","varchar(48)","","安全用户","sec_user_data","id"},
                new String[]{"app_icon","varchar(20)","","应用程序图标","",""},
                new String[]{"full_access","bool","","完全访问","",""},
                new String[]{"permission","varchar(20)","","许可","",""},
                new String[]{"app_type","varchar(100)","","应用程序类型","",""},
                new String[]{"app_id","varchar(100)","","应用程序Id","",""},
                new String[]{"ctx_type","varchar(100)","","Ctx类型","",""},
                new String[]{"ctx_id","varchar(100)","","Ctx Id","",""},
                new String[]{"location","varchar(200)","","位置","",""},
                new String[]{"version","int","","版本","",""}
            }, "应用", new String[]{
                "create unique index idx4id_ver_of_user_app on user_app_data (id, version);",
                "create  index idx4app_id_of_user_app on user_app_data (app_id);",
                "create  index idx4ctx_id_of_user_app on user_app_data (ctx_id);",
                "create  index idx4version_of_user_app on user_app_data (version);"
         }, new String[]{
                "alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);",
                "alter table user_app_data add constraint fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


