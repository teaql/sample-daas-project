
package com.doublechaintech.model.family;
import com.doublechaintech.model.AccessKey;
import com.doublechaintech.model.ModelBaseUtils;
import com.doublechaintech.model.ModelUserContext;

import java.util.Map;

public class FamilyTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="family_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_COMMUNITY = "community";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_COMMUNITY,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_COMMUNITY};

	  public static void ensureTable(ModelUserContext userContext, Map<String, Object> result) throws Exception {
        ModelBaseUtils.ensureTable(userContext, result, "family_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(100)","","名称","",""},
                new String[]{"community","varchar(48)","","社区","community_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "家庭", new String[]{
                "create unique index idx4id_ver_of_family on family_data (id, version);",
                "create  index idx4version_of_family on family_data (version);"
         }, new String[]{
                "alter table family_data add constraint pk4id_of_family_data primary key (id);",
                "alter table family_data add constraint fk4community_of_family_data foreign key (community) references community_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


