
package com.doublechaintech.model.treenode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.model.ModelUserContext;
import com.doublechaintech.model.BaseEntity;
import com.doublechaintech.model.BaseManager;
import com.doublechaintech.model.SmartList;




public interface TreeNodeManager extends BaseManager{

		

  List<TreeNode> searchTreeNodeList(ModelUserContext ctx, TreeNodeRequest pRequest);
  TreeNode searchTreeNode(ModelUserContext ctx, TreeNodeRequest pRequest);
	public TreeNode createTreeNode(ModelUserContext userContext, String nodeId,String nodeType,int leftValue,int rightValue) throws Exception;
	public TreeNode updateTreeNode(ModelUserContext userContext,String treeNodeId, int treeNodeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TreeNode loadTreeNode(ModelUserContext userContext, String treeNodeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(ModelUserContext ctx) throws Exception ;
	public TreeNode internalSaveTreeNode(ModelUserContext userContext, TreeNode treeNode) throws Exception;
	public TreeNode internalSaveTreeNode(ModelUserContext userContext, TreeNode treeNode,Map<String,Object>option) throws Exception;





	public void onNewInstanceCreated(ModelUserContext userContext, TreeNode newCreated)throws Exception;
	public default void onUpdated(ModelUserContext userContext, TreeNode updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/







}






















