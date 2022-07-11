package com.doublechaintech.model.secuser;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.model.loginhistory.LoginHistory;
import com.doublechaintech.model.userapp.UserApp;
import com.doublechaintech.model.userdomain.UserDomain;
import com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.model.keypairidentity.KeyPairIdentity;

import com.doublechaintech.model.expression.Expression;

public abstract class SecUserExpression<T> implements Expression<T, SecUser> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getLogin() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLogin();
      }
    };
  }

  public Expression<T, String> getMobile() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobile();
      }
    };
  }

  public Expression<T, String> getEmail() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmail();
      }
    };
  }

  public Expression<T, String> getPwd() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPwd();
      }
    };
  }

  public Expression<T, String> getWeixinOpenid() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWeixinOpenid();
      }
    };
  }

  public Expression<T, String> getWeixinAppid() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWeixinAppid();
      }
    };
  }

  public Expression<T, String> getAccessToken() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccessToken();
      }
    };
  }

  public Expression<T, Integer> getVerificationCode() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVerificationCode();
      }
    };
  }

  public Expression<T, DateTime> getVerificationCodeExpire() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVerificationCodeExpire();
      }
    };
  }

  public Expression<T, DateTime> getLastLoginTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastLoginTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.model.userdomain.UserDomainExpression<T> getDomain() {
    return new com.doublechaintech.model.userdomain.UserDomainExpression<T>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public UserDomain eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDomain();
      }
    };
  }

  public com.doublechaintech.model.userapp.UserAppSmartListExpression<T> getUserAppList() {
    return new com.doublechaintech.model.userapp.UserAppSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<UserApp> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUserAppList();
      }
    };
  }

  public com.doublechaintech.model.loginhistory.LoginHistorySmartListExpression<T>
      getLoginHistoryList() {
    return new com.doublechaintech.model.loginhistory.LoginHistorySmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<LoginHistory> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLoginHistoryList();
      }
    };
  }

  public com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentitySmartListExpression<T>
      getWechatWorkappIdentityList() {
    return new com.doublechaintech.model.wechatworkappidentity
            .WechatWorkappIdentitySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<WechatWorkappIdentity> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWechatWorkappIdentityList();
      }
    };
  }

  public com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentitySmartListExpression<T>
      getWechatMiniappIdentityList() {
    return new com.doublechaintech.model.wechatminiappidentity
            .WechatMiniappIdentitySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<WechatMiniappIdentity> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWechatMiniappIdentityList();
      }
    };
  }

  public com.doublechaintech.model.keypairidentity.KeyPairIdentitySmartListExpression<T>
      getKeyPairIdentityList() {
    return new com.doublechaintech.model.keypairidentity.KeyPairIdentitySmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<KeyPairIdentity> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getKeyPairIdentityList();
      }
    };
  }
}
