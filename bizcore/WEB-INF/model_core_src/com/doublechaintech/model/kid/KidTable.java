
package com.doublechaintech.model.kid;
import com.doublechaintech.model.AccessKey;
import com.doublechaintech.model.ModelBaseUtils;
import com.doublechaintech.model.ModelUserContext;

import java.util.Map;

public class KidTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="kid_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_FAMILY = "family";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_FAMILY,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_FAMILY};

	  public static void ensureTable(ModelUserContext userContext, Map<String, Object> result) throws Exception {
        ModelBaseUtils.ensureTable(userContext, result, "kid_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(3)","","名称","",""},
                new String[]{"family","varchar(48)","","家庭","family_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "孩子", new String[]{
                "create unique index idx4id_ver_of_kid on kid_data (id, version);",
                "create  index idx4version_of_kid on kid_data (version);"
         }, new String[]{
                "alter table kid_data add constraint pk4id_of_kid_data primary key (id);",
                "alter table kid_data add constraint fk4family_of_kid_data foreign key (family) references family_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


