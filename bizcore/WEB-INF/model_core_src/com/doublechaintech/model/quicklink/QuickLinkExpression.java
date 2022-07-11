package com.doublechaintech.model.quicklink;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.model.userapp.UserApp;

import com.doublechaintech.model.expression.Expression;

public abstract class QuickLinkExpression<T> implements Expression<T, QuickLink> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
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
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getIcon() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getIcon();
      }
    };
  }

  public Expression<T, String> getImagePath() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getImagePath();
      }
    };
  }

  public Expression<T, String> getLinkTarget() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLinkTarget();
      }
    };
  }

  public Expression<T, DateTime> getCreateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCreateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.model.userapp.UserAppExpression<T> getApp() {
    return new com.doublechaintech.model.userapp.UserAppExpression<T>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      public UserApp eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getApp();
      }
    };
  }
}
