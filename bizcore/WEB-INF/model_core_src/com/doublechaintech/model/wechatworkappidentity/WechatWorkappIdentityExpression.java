
package com.doublechaintech.model.wechatworkappidentity;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.model.secuser.SecUser;

import com.doublechaintech.model.expression.Expression;
public abstract class WechatWorkappIdentityExpression<T> implements Expression<T, WechatWorkappIdentity> {
  
    public Expression<T, String> getId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return WechatWorkappIdentityExpression.this.$getRoot();
            }
           @Override
           public String eval(T wechatWorkappIdentity) {
              WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getId();
           }
        };
      }
  
    public Expression<T, String> getCorpId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return WechatWorkappIdentityExpression.this.$getRoot();
            }
           @Override
           public String eval(T wechatWorkappIdentity) {
              WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getCorpId();
           }
        };
      }
  
    public Expression<T, String> getUserId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return WechatWorkappIdentityExpression.this.$getRoot();
            }
           @Override
           public String eval(T wechatWorkappIdentity) {
              WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getUserId();
           }
        };
      }
  
    public Expression<T, DateTime> getCreateTime() {
        return new Expression<T, DateTime>(){
            @Override
            public T $getRoot() {
              return WechatWorkappIdentityExpression.this.$getRoot();
            }
           @Override
           public DateTime eval(T wechatWorkappIdentity) {
              WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getCreateTime();
           }
        };
      }
  
    public Expression<T, DateTime> getLastLoginTime() {
        return new Expression<T, DateTime>(){
            @Override
            public T $getRoot() {
              return WechatWorkappIdentityExpression.this.$getRoot();
            }
           @Override
           public DateTime eval(T wechatWorkappIdentity) {
              WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getLastLoginTime();
           }
        };
      }
  
    public Expression<T, Integer> getVersion() {
        return new Expression<T, Integer>(){
            @Override
            public T $getRoot() {
              return WechatWorkappIdentityExpression.this.$getRoot();
            }
           @Override
           public Integer eval(T wechatWorkappIdentity) {
              WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getVersion();
           }
        };
      }
  

  
    public com.doublechaintech.model.secuser.SecUserExpression<T> getSecUser() {
        return new com.doublechaintech.model.secuser.SecUserExpression<T>(){
          @Override
          public T $getRoot() {
            return WechatWorkappIdentityExpression.this.$getRoot();
          }

          public SecUser eval(T wechatWorkappIdentity) {
            WechatWorkappIdentity parent = WechatWorkappIdentityExpression.this.eval(wechatWorkappIdentity);
            if (ObjectUtil.isEmpty(parent)) {
              return null;
            }
            return parent.getSecUser();
          }
        };
      }
  

  
}

