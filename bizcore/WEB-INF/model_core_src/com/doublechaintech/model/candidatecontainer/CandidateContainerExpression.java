package com.doublechaintech.model.candidatecontainer;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.candidateelement.CandidateElement;

import com.doublechaintech.model.expression.Expression;

public abstract class CandidateContainerExpression<T> implements Expression<T, CandidateContainer> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CandidateContainerExpression.this.$getRoot();
      }

      @Override
      public String eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
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
        return CandidateContainerExpression.this.$getRoot();
      }

      @Override
      public String eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
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
        return CandidateContainerExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.model.candidateelement.CandidateElementSmartListExpression<T>
      getCandidateElementList() {
    return new com.doublechaintech.model.candidateelement.CandidateElementSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return CandidateContainerExpression.this.$getRoot();
      }

      public com.doublechaintech.model.SmartList<CandidateElement> eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCandidateElementList();
      }
    };
  }
}
