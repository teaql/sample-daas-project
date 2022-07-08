
package com.doublechaintech.model.kid;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.family.Family;

import com.doublechaintech.model.expression.Expression;
public abstract class KidExpression<T> implements Expression<T, Kid> {
  
    public Expression<T, String> getId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return KidExpression.this.$getRoot();
            }
           @Override
           public String eval(T kid) {
              Kid parent = KidExpression.this.eval(kid);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getId();
           }
        };
      }
  
    public Expression<T, String> getName() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return KidExpression.this.$getRoot();
            }
           @Override
           public String eval(T kid) {
              Kid parent = KidExpression.this.eval(kid);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getName();
           }
        };
      }
  
    public Expression<T, Integer> getVersion() {
        return new Expression<T, Integer>(){
            @Override
            public T $getRoot() {
              return KidExpression.this.$getRoot();
            }
           @Override
           public Integer eval(T kid) {
              Kid parent = KidExpression.this.eval(kid);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getVersion();
           }
        };
      }
  

  
    public com.doublechaintech.model.family.FamilyExpression<T> getFamily() {
        return new com.doublechaintech.model.family.FamilyExpression<T>(){
          @Override
          public T $getRoot() {
            return KidExpression.this.$getRoot();
          }

          public Family eval(T kid) {
            Kid parent = KidExpression.this.eval(kid);
            if (ObjectUtil.isEmpty(parent)) {
              return null;
            }
            return parent.getFamily();
          }
        };
      }
  

  
}

