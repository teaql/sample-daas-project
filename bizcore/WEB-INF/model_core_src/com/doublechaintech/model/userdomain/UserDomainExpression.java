package com.doublechaintech.model.userdomain;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.secuser.SecUser;
import com.doublechaintech.model.userallowlist.UserAllowList;
import com.doublechaintech.model.publickeytype.PublicKeyType;

import com.doublechaintech.model.expression.Expression;

public abstract class UserDomainExpression<T> implements Expression<T, UserDomain> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserDomainExpression.this.$getRoot();
      }

      @Override
      public String eval(T userDomain) {
        UserDomain parent = UserDomainExpression.this.eval(userDomain);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserDomainExpression.this.$getRoot();
      }

      @Override
      public String eval(T userDomain) {
        UserDomain parent = UserDomainExpression.this.eval(userDomain);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return UserDomainExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T userDomain) {
        UserDomain parent = UserDomainExpression.this.eval(userDomain);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.model.userallowlist.UserAllowListSmartListExpression<T>
      getUserAllowListList() {
    return new com.doublechaintech.model.userallowlist.UserAllowListSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return UserDomainExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<UserAllowList> eval(T userDomain) {
        UserDomain parent = UserDomainExpression.this.eval(userDomain);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUserAllowListList();
      }
    };
  }

  public com.doublechaintech.model.secuser.SecUserSmartListExpression<T> getSecUserList() {
    return new com.doublechaintech.model.secuser.SecUserSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return UserDomainExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<SecUser> eval(T userDomain) {
        UserDomain parent = UserDomainExpression.this.eval(userDomain);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSecUserList();
      }
    };
  }

  public com.doublechaintech.model.publickeytype.PublicKeyTypeSmartListExpression<T>
      getPublicKeyTypeList() {
    return new com.doublechaintech.model.publickeytype.PublicKeyTypeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return UserDomainExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<PublicKeyType> eval(T userDomain) {
        UserDomain parent = UserDomainExpression.this.eval(userDomain);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPublicKeyTypeList();
      }
    };
  }
}
