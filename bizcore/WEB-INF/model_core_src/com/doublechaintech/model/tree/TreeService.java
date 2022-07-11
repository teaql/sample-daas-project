package com.doublechaintech.model.tree;

import com.doublechaintech.model.ModelUserContext;
import com.doublechaintech.model.BaseEntity;

public interface TreeService {
  // load the subtree which root is node id/node type, and only one tree found.
  Node loadTree(ModelUserContext ctx, String nodeId, String nodeType) throws Exception;

  default Node loadTree(ModelUserContext ctx, BaseEntity pEntity) throws Exception {
    return loadTree(ctx, pEntity.getId(), pEntity.getInternalType());
  }

  default Node loadTree(ModelUserContext ctx, String nodeId, Class nodeClass) throws Exception {
    return loadTree(ctx, nodeId, nodeClass.getSimpleName());
  }

  Node loadAncestors(ModelUserContext ctx, String nodeId, String nodeType) throws Exception;

  default Node loadAncestors(ModelUserContext ctx, BaseEntity pEntity) throws Exception {
    return loadAncestors(ctx, pEntity.getId(), pEntity.getInternalType());
  }

  default Node loadAncestors(ModelUserContext ctx, String nodeId, Class nodeClass)
      throws Exception {
    return loadAncestors(ctx, nodeId, nodeClass.getSimpleName());
  }

  default Node addChild(ModelUserContext ctx, Node tree, BaseEntity pEntity) throws Exception {
    return addChild(ctx, tree, pEntity.getId(), pEntity.getInternalType());
  }

  // add child in the tree as current node's last son, returns the parent
  Node addChild(ModelUserContext ctx, Node tree, String childId, String childType) throws Exception;

  default Node addChild(ModelUserContext ctx, Node tree, String childId, Class childType)
      throws Exception {
    return addChild(ctx, tree, childId, childType.getSimpleName());
  }
}
