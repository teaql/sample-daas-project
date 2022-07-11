package com.doublechaintech.model.publickeytype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.userdomain.UserDomain;
import com.doublechaintech.model.keypairidentity.KeyPairIdentity;

import com.doublechaintech.model.expression.Expression;

public abstract class PublicKeyTypeExpression<T> implements Expression<T, PublicKeyType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PublicKeyTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicKeyType) {
        PublicKeyType parent = PublicKeyTypeExpression.this.eval(publicKeyType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getKeyAlg() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PublicKeyTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicKeyType) {
        PublicKeyType parent = PublicKeyTypeExpression.this.eval(publicKeyType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getKeyAlg();
      }
    };
  }

  public Expression<T, String> getSignAlg() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PublicKeyTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicKeyType) {
        PublicKeyType parent = PublicKeyTypeExpression.this.eval(publicKeyType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSignAlg();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PublicKeyTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T publicKeyType) {
        PublicKeyType parent = PublicKeyTypeExpression.this.eval(publicKeyType);
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
        return PublicKeyTypeExpression.this.$getRoot();
      }

      public UserDomain eval(T publicKeyType) {
        PublicKeyType parent = PublicKeyTypeExpression.this.eval(publicKeyType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDomain();
      }
    };
  }

  public com.doublechaintech.model.keypairidentity.KeyPairIdentitySmartListExpression<T>
      getKeyPairIdentityList() {
    return new com.doublechaintech.model.keypairidentity.KeyPairIdentitySmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PublicKeyTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<KeyPairIdentity> eval(T publicKeyType) {
        PublicKeyType parent = PublicKeyTypeExpression.this.eval(publicKeyType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getKeyPairIdentityList();
      }
    };
  }
}
