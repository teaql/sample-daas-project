package com.doublechaintech.model.kid;

import com.doublechaintech.model.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.model.BaseRowMapper;
import com.doublechaintech.model.family.Family;

public class KidMapper extends BaseRowMapper<Kid> {

  public static KidMapper mapperForClass(Class<?> clazz) {

    KidMapper mapperForOverride = new KidMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected Kid internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    Kid kid = getKid();

    setId(kid, rs, rowNumber);
    setName(kid, rs, rowNumber);
    setAge(kid, rs, rowNumber);
    setFamily(kid, rs, rowNumber);
    setVersion(kid, rs, rowNumber);

    return kid;
  }

  protected Kid getKid() {
    if (null == clazz) {

      Kid entity = new Kid();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(Kid kid, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(KidTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      kid.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(Kid kid, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(KidTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      kid.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setAge(Kid kid, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer age = rs.getInt(KidTable.COLUMN_AGE);

      if (age == null) {
        // do nothing when nothing found in database
        return;
      }

      kid.setAge(age);
    } catch (SQLException e) {

    }
  }

  protected void setFamily(Kid kid, ResultSet rs, int rowNumber) throws SQLException {
    String familyId;
    try {
      familyId = rs.getString(KidTable.COLUMN_FAMILY);
    } catch (SQLException e) {
      return;
    }
    if (familyId == null) {
      return;
    }
    if (familyId.isEmpty()) {
      return;
    }
    Family family = kid.getFamily();
    if (family != null) {
      // if the root object 'kid' already have the property, just set the id for it;
      family.setId(familyId);

      return;
    }
    kid.setFamily(createEmptyFamily(familyId));
  }

  protected void setVersion(Kid kid, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(KidTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      kid.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected Family createEmptyFamily(String familyId) {

    Family family = new Family();

    family.setId(familyId);
    family.setVersion(Integer.MAX_VALUE);
    return family;
  }
}
