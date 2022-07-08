package com.doublechaintech.model.utils;

import com.doublechaintech.model.ModelUserContext;

public class CustomModelPropertyMapper extends ModelPropertyMapper{
    static {
    //    registerCreator(目标类, 场景?, 字段?, 自定义creator);
    }
    public static CustomModelPropertyMapper of(ModelUserContext ctx){
      String key = "thread_lvl_helper_" + CustomModelPropertyMapper.class.getName();
      CustomModelPropertyMapper rst = (CustomModelPropertyMapper) ctx.getFromContextLocalStorage(key);
      if (rst != null) {
        return rst;
      }
      rst = new CustomModelPropertyMapper();
      rst.setUserContext(ctx);
      ctx.putIntoContextLocalStorage(key, rst);
      return rst;
    }
}

















