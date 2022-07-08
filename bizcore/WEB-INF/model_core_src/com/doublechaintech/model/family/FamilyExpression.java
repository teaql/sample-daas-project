
package com.doublechaintech.model.family;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.community.Community;
import com.doublechaintech.model.kid.Kid;

import com.doublechaintech.model.expression.Expression;
public abstract class FamilyExpression<T> implements Expression<T, Family> {
  
    public Expression<T, String> getId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return FamilyExpression.this.$getRoot();
            }
           @Override
           public String eval(T family) {
              Family parent = FamilyExpression.this.eval(family);
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
              return FamilyExpression.this.$getRoot();
            }
           @Override
           public String eval(T family) {
              Family parent = FamilyExpression.this.eval(family);
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
              return FamilyExpression.this.$getRoot();
            }
           @Override
           public Integer eval(T family) {
              Family parent = FamilyExpression.this.eval(family);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getVersion();
           }
        };
      }
  

  
    public com.doublechaintech.model.community.CommunityExpression<T> getCommunity() {
        return new com.doublechaintech.model.community.CommunityExpression<T>(){
          @Override
          public T $getRoot() {
            return FamilyExpression.this.$getRoot();
          }

          public Community eval(T family) {
            Family parent = FamilyExpression.this.eval(family);
            if (ObjectUtil.isEmpty(parent)) {
              return null;
            }
            return parent.getCommunity();
          }
        };
      }
  

  
   public com.doublechaintech.model.kid.KidSmartListExpression<T> getKidList() {
       return new com.doublechaintech.model.kid.KidSmartListExpression<T>(){

         @Override
         public T $getRoot() {
           return FamilyExpression.this.$getRoot();
         }

         public com.doublechaintech.model.SmartList<Kid> eval(T family) {
           Family parent = FamilyExpression.this.eval(family);
           if (ObjectUtil.isEmpty(parent)) {
             return null;
           }
           return parent.getKidList();
         }
       };
   }

  
}

