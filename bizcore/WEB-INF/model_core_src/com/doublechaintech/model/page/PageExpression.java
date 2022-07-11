package com.doublechaintech.model.page;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.pagetype.PageType;
import com.doublechaintech.model.slide.Slide;
import com.doublechaintech.model.section.Section;
import com.doublechaintech.model.mobileapp.MobileApp;
import com.doublechaintech.model.uiaction.UiAction;

import com.doublechaintech.model.expression.Expression;

public abstract class PageExpression<T> implements Expression<T, Page> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public String eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getPageTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public String eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPageTitle();
      }
    };
  }

  public Expression<T, String> getLinkToUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public String eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLinkToUrl();
      }
    };
  }

  public Expression<T, Integer> getDisplayOrder() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDisplayOrder();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.model.pagetype.PageTypeExpression<T> getPageType() {
    return new com.doublechaintech.model.pagetype.PageTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public PageType eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPageType();
      }
    };
  }

  public com.doublechaintech.model.mobileapp.MobileAppExpression<T> getMobileApp() {
    return new com.doublechaintech.model.mobileapp.MobileAppExpression<T>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public MobileApp eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobileApp();
      }
    };
  }

  public com.doublechaintech.model.slide.SlideSmartListExpression<T> getSlideList() {
    return new com.doublechaintech.model.slide.SlideSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<Slide> eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSlideList();
      }
    };
  }

  public com.doublechaintech.model.uiaction.UiActionSmartListExpression<T> getUiActionList() {
    return new com.doublechaintech.model.uiaction.UiActionSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<UiAction> eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUiActionList();
      }
    };
  }

  public com.doublechaintech.model.section.SectionSmartListExpression<T> getSectionList() {
    return new com.doublechaintech.model.section.SectionSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<Section> eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSectionList();
      }
    };
  }
}
