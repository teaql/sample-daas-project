
package com.doublechaintech.model.candidateelement;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.model.candidatecontainer.CandidateContainer;

import com.doublechaintech.model.expression.Expression;
public abstract class CandidateElementExpression<T> implements Expression<T, CandidateElement> {
  
    public Expression<T, String> getId() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return CandidateElementExpression.this.$getRoot();
            }
           @Override
           public String eval(T candidateElement) {
              CandidateElement parent = CandidateElementExpression.this.eval(candidateElement);
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
              return CandidateElementExpression.this.$getRoot();
            }
           @Override
           public String eval(T candidateElement) {
              CandidateElement parent = CandidateElementExpression.this.eval(candidateElement);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getName();
           }
        };
      }
  
    public Expression<T, String> getType() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return CandidateElementExpression.this.$getRoot();
            }
           @Override
           public String eval(T candidateElement) {
              CandidateElement parent = CandidateElementExpression.this.eval(candidateElement);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getType();
           }
        };
      }
  
    public Expression<T, String> getImage() {
        return new Expression<T, String>(){
            @Override
            public T $getRoot() {
              return CandidateElementExpression.this.$getRoot();
            }
           @Override
           public String eval(T candidateElement) {
              CandidateElement parent = CandidateElementExpression.this.eval(candidateElement);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getImage();
           }
        };
      }
  
    public Expression<T, Integer> getVersion() {
        return new Expression<T, Integer>(){
            @Override
            public T $getRoot() {
              return CandidateElementExpression.this.$getRoot();
            }
           @Override
           public Integer eval(T candidateElement) {
              CandidateElement parent = CandidateElementExpression.this.eval(candidateElement);
              if (ObjectUtil.isEmpty(parent)) {
                return null;
              }
              return parent.getVersion();
           }
        };
      }
  

  
    public com.doublechaintech.model.candidatecontainer.CandidateContainerExpression<T> getContainer() {
        return new com.doublechaintech.model.candidatecontainer.CandidateContainerExpression<T>(){
          @Override
          public T $getRoot() {
            return CandidateElementExpression.this.$getRoot();
          }

          public CandidateContainer eval(T candidateElement) {
            CandidateElement parent = CandidateElementExpression.this.eval(candidateElement);
            if (ObjectUtil.isEmpty(parent)) {
              return null;
            }
            return parent.getContainer();
          }
        };
      }
  

  
}

