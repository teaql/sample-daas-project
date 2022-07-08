
package com.doublechaintech.model.search;

import com.doublechaintech.model.BaseEntity;

import java.util.List;
import java.util.Set;

public interface IDRefine<T extends BaseEntity> {
  String refineId(T data);
}



