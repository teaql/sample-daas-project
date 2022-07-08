
package com.doublechaintech.model.community;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.family.Family;

import com.doublechaintech.model.expression.Expression;
public abstract class CommunityExpression<T> implements Expression<T, Community> {
  
    public Expression<T, String> getId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return CommunityExpression.this.$getRoot();
            }
           @Override
           public String eval(T community) {
              Community parent = CommunityExpression.this.eval(community);
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
              return CommunityExpression.this.$getRoot();
            }
           @Override
           public String eval(T community) {
              Community parent = CommunityExpression.this.eval(community);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getName();
           }
        };
      }
  
    public Expression<T, String> getAddress() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return CommunityExpression.this.$getRoot();
            }
           @Override
           public String eval(T community) {
              Community parent = CommunityExpression.this.eval(community);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getAddress();
           }
        };
      }
  
    public Expression<T, Integer> getVersion() {
        return new Expression<T, Integer>(){
            @Override
            public T $getRoot() {
              return CommunityExpression.this.$getRoot();
            }
           @Override
           public Integer eval(T community) {
              Community parent = CommunityExpression.this.eval(community);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getVersion();
           }
        };
      }
  

  

  
   public com.doublechaintech.model.family.FamilySmartListExpression<T> getFamilyList() {
       return new com.doublechaintech.model.family.FamilySmartListExpression<T>(){

         @Override
         public T $getRoot() {
           return CommunityExpression.this.$getRoot();
         }

         public com.doublechaintech.model.SmartList<Family> eval(T community) {
           Community parent = CommunityExpression.this.eval(community);
           if (ObjectUtil.isEmpty(parent)) {
             return null;
           }
           return parent.getFamilyList();
         }
       };
   }

  
}

