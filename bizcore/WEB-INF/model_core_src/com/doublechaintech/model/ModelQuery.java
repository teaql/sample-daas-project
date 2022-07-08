package com.doublechaintech.model;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ModelQuery extends BaseQuery {
	
	public ModelQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("model");
  }

  public ModelQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}
























