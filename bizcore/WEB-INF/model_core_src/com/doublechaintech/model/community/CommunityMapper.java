
package com.doublechaintech.model.community;
import com.doublechaintech.model.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.model.BaseRowMapper;

public class CommunityMapper extends BaseRowMapper<Community>{


  public static CommunityMapper mapperForClass(Class<?> clazz){

    CommunityMapper mapperForOverride=new CommunityMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }


	protected Community internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Community community = getCommunity();
		
 		setId(community, rs, rowNumber);
 		setName(community, rs, rowNumber);
 		setAddress(community, rs, rowNumber);
 		setVersion(community, rs, rowNumber);

    
		return community;
	}

	protected Community getCommunity(){
    if(null==clazz){
      
      Community entity = new Community();
      
      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
	}
		
	protected void setId(Community community, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CommunityTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		community.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(Community community, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CommunityTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		community.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setAddress(Community community, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String address = rs.getString(CommunityTable.COLUMN_ADDRESS);
		
		if(address == null){
			//do nothing when nothing found in database
			return;
		}
		
		community.setAddress(address);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(Community community, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CommunityTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		community.setVersion(version);
		}catch (SQLException e){

    }
	}
		


}


