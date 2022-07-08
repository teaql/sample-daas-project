package com.doublechaintech.model.community;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.model.expression.SmartListExpression;

import java.util.List;

public abstract class CommunitySmartListExpression<T> extends SmartListExpression<T, Community> {
  public CommunityExpression<T> first() {
    return new CommunityExpression<T>() {
      @Override
      public Community eval(T l) {
        List<Community> list = CommunitySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

       @Override
       public T $getRoot() {
         return CommunitySmartListExpression.this.$getRoot();
       }
    };
  }

  public CommunityExpression<T> get(int index) {
    return new CommunityExpression<T>() {
      @Override
      public Community eval(T l) {
        List<Community> list = CommunitySmartListExpression.this.eval(l);
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
         return CommunitySmartListExpression.this.$getRoot();
       }
    };
  }
}


