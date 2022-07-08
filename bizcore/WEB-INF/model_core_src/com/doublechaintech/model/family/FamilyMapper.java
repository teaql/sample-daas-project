
package com.doublechaintech.model.family;
import com.doublechaintech.model.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.model.BaseRowMapper;
import com.doublechaintech.model.community.Community;

public class FamilyMapper extends BaseRowMapper<Family>{


  public static FamilyMapper mapperForClass(Class<?> clazz){

    FamilyMapper mapperForOverride=new FamilyMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }


	protected Family internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Family family = getFamily();
		
 		setId(family, rs, rowNumber);
 		setName(family, rs, rowNumber);
 		setCommunity(family, rs, rowNumber);
 		setVersion(family, rs, rowNumber);

    
		return family;
	}

	protected Family getFamily(){
    if(null==clazz){
      
      Family entity = new Family();
      
      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
	}
		
	protected void setId(Family family, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(FamilyTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		family.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(Family family, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(FamilyTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		family.setName(name);
		}catch (SQLException e){

    }
	}
		
 	protected void setCommunity(Family family, ResultSet rs, int rowNumber) throws SQLException{
 		String communityId;
 		try{
 		  communityId = rs.getString(FamilyTable.COLUMN_COMMUNITY);
 		}catch(SQLException e){
 		  return;
 		}
 		if( communityId == null){
 			return;
 		}
 		if( communityId.isEmpty()){
 			return;
 		}
 		Community community = family.getCommunity();
 		if( community != null ){
 			//if the root object 'family' already have the property, just set the id for it;
 			community.setId(communityId);

 			return;
 		}
 		family.setCommunity(createEmptyCommunity(communityId));
 	}
 	
	protected void setVersion(Family family, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(FamilyTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		family.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected Community  createEmptyCommunity(String communityId){
 	  
 		  Community community = new Community();
 		
 		community.setId(communityId);
 		community.setVersion(Integer.MAX_VALUE);
 		return community;
 	}
 	
}


