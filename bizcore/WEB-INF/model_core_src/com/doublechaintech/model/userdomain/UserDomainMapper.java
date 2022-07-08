
package com.doublechaintech.model.userdomain;
import com.doublechaintech.model.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.model.BaseRowMapper;

public class UserDomainMapper extends BaseRowMapper<UserDomain>{


  public static UserDomainMapper mapperForClass(Class<?> clazz){

    UserDomainMapper mapperForOverride=new UserDomainMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }


	protected UserDomain internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserDomain userDomain = getUserDomain();
		
 		setId(userDomain, rs, rowNumber);
 		setName(userDomain, rs, rowNumber);
 		setVersion(userDomain, rs, rowNumber);

    
		return userDomain;
	}

	protected UserDomain getUserDomain(){
    if(null==clazz){
      
      UserDomain entity = new UserDomain();
      
      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
	}
		
	protected void setId(UserDomain userDomain, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(UserDomainTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userDomain.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(UserDomain userDomain, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(UserDomainTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		userDomain.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(UserDomain userDomain, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(UserDomainTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userDomain.setVersion(version);
		}catch (SQLException e){

    }
	}
		


}


