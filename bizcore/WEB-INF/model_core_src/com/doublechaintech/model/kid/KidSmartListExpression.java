package com.doublechaintech.model.kid;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.model.expression.SmartListExpression;

import java.util.List;

public abstract class KidSmartListExpression<T> extends SmartListExpression<T, Kid> {
  public KidExpression<T> first() {
    return new KidExpression<T>() {
      @Override
      public Kid eval(T l) {
        List<Kid> list = KidSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return KidSmartListExpression.this.$getRoot();
      }
    };
  }

  public KidExpression<T> get(int index) {
    return new KidExpression<T>() {
      @Override
      public Kid eval(T l) {
        List<Kid> list = KidSmartListExpression.this.eval(l);
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
        return KidSmartListExpression.this.$getRoot();
      }
    };
  }
}
