
package com.doublechaintech.model.mobileapp;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.pagetype.PageType;
import com.doublechaintech.model.page.Page;

import com.doublechaintech.model.expression.Expression;
public abstract class MobileAppExpression<T> implements Expression<T, MobileApp> {
  
    public Expression<T, String> getId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return MobileAppExpression.this.$getRoot();
            }
           @Override
           public String eval(T mobileApp) {
              MobileApp parent = MobileAppExpression.this.eval(mobileApp);
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
              return MobileAppExpression.this.$getRoot();
            }
           @Override
           public String eval(T mobileApp) {
              MobileApp parent = MobileAppExpression.this.eval(mobileApp);
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
              return MobileAppExpression.this.$getRoot();
            }
           @Override
           public Integer eval(T mobileApp) {
              MobileApp parent = MobileAppExpression.this.eval(mobileApp);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getVersion();
           }
        };
      }
  

  

  
   public com.doublechaintech.model.page.PageSmartListExpression<T> getPageList() {
       return new com.doublechaintech.model.page.PageSmartListExpression<T>(){

         @Override
         public T $getRoot() {
           return MobileAppExpression.this.$getRoot();
         }

         public com.doublechaintech.model.SmartList<Page> eval(T mobileApp) {
           MobileApp parent = MobileAppExpression.this.eval(mobileApp);
           if (ObjectUtil.isEmpty(parent)) {
             return null;
           }
           return parent.getPageList();
         }
       };
   }

  
   public com.doublechaintech.model.pagetype.PageTypeSmartListExpression<T> getPageTypeList() {
       return new com.doublechaintech.model.pagetype.PageTypeSmartListExpression<T>(){

         @Override
         public T $getRoot() {
           return MobileAppExpression.this.$getRoot();
         }

         public com.doublechaintech.model.SmartList<PageType> eval(T mobileApp) {
           MobileApp parent = MobileAppExpression.this.eval(mobileApp);
           if (ObjectUtil.isEmpty(parent)) {
             return null;
           }
           return parent.getPageTypeList();
         }
       };
   }

  
}

