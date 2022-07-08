package com.doublechaintech.model.utils;

import com.doublechaintech.model.ModelUserContext;
import com.terapico.caf.ThrowingFunction;

import java.util.List;

public interface ModelBeanCreator<T> {
    default T create(
              ModelUserContext userContext, CreationScene scene,
              ThrowingFunction<T, T, Exception> postHandler,
              List<Object> inputs) throws Exception {
        throw new UnsupportedOperationException("如果你注册了全局或者"+scene.getName()+"场景下的BeanCreator,请实现此方法");
      }

      default <P> P tryToGet(
              CreationScene scene,
              Class beanClass,
              String propertyName,
              Class<P> propertyType,
              int indexInType,
              boolean onlyOneInType,
              P defaultValue,
              List<Object> inputs) {
        throw new UnsupportedOperationException("如果你注册了全局或者"+scene.getName()+"场景下字段"+propertyName+"BeanCreator,请实现此方法");
      }
}



















