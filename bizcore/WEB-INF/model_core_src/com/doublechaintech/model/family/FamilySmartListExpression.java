package com.doublechaintech.model.family;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.model.expression.SmartListExpression;

import java.util.List;

public abstract class FamilySmartListExpression<T> extends SmartListExpression<T, Family> {
  public FamilyExpression<T> first() {
    return new FamilyExpression<T>() {
      @Override
      public Family eval(T l) {
        List<Family> list = FamilySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

       @Override
       public T $getRoot() {
         return FamilySmartListExpression.this.$getRoot();
       }
    };
  }

  public FamilyExpression<T> get(int index) {
    return new FamilyExpression<T>() {
      @Override
      public Family eval(T l) {
        List<Family> list = FamilySmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

       @Override
       public T $getRoot() {
         return FamilySmartListExpression.this.$getRoot();
       }
    };
  }
}


