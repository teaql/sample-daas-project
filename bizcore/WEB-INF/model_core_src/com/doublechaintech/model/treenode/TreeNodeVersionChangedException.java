package com.doublechaintech.model.treenode;

import com.doublechaintech.model.EntityNotFoundException;

public class TreeNodeVersionChangedException extends TreeNodeManagerException {
  private static final long serialVersionUID = 1L;

  public TreeNodeVersionChangedException(String string) {
    super(string);
  }
}
