package com.doublechaintech.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.doublechaintech.model.tree.Node;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.BaseCandidatesUtil;

public class ModelCandidatesUtil extends BaseCandidatesUtil{
	static {
		_for("candidate_container").usedIn("candidate_element").withRole("container");
		_for("candidate_container").isTree("false");
		_for("candidate_container").hasFields(";id;name;version;");
		_for("candidate_container").targetType("candidate_container");
		_for("sec_user").referTo("user_domain").withRole("domain");
		_for("sec_user").usedIn("key_pair_identity").withRole("sec_user");
		_for("sec_user").usedIn("login_history").withRole("sec_user");
		_for("sec_user").usedIn("wechat_miniapp_identity").withRole("sec_user");
		_for("sec_user").usedIn("wechat_workapp_identity").withRole("sec_user");
		_for("sec_user").usedIn("user_app").withRole("sec_user");
		_for("sec_user").isTree("false");
		_for("sec_user").hasFields(";id;login;mobile;email;pwd;weixin_openid;weixin_appid;access_token;verification_code;verification_code_expire;last_login_time;version;");
		_for("sec_user").targetType("sec_user");
		_for("sec_user").anchorColumn("domain");
		_for("page_type").referTo("mobile_app").withRole("mobile_app");
		_for("page_type").usedIn("page").withRole("page_type");
		_for("page_type").isTree("false");
		_for("page_type").hasFields(";id;name;code;footer_tab;version;");
		_for("page_type").targetType("page_type");
		_for("page_type").anchorColumn("mobile_app");
		_for("user_domain").usedIn("user_allow_list").withRole("domain");
		_for("user_domain").usedIn("sec_user").withRole("domain");
		_for("user_domain").usedIn("public_key_type").withRole("domain");
		_for("user_domain").isTree("false");
		_for("user_domain").hasFields(";id;name;version;");
		_for("user_domain").targetType("user_domain");
		_for("page").referTo("page_type").withRole("page_type");
		_for("page").referTo("mobile_app").withRole("mobile_app");
		_for("page").usedIn("ui_action").withRole("page");
		_for("page").usedIn("slide").withRole("page");
		_for("page").usedIn("section").withRole("page");
		_for("page").isTree("false");
		_for("page").hasFields(";id;page_title;link_to_url;display_order;version;");
		_for("page").targetType("page");
		_for("page").anchorColumn("page_type");
		_for("community").usedIn("family").withRole("community");
		_for("community").isTree("false");
		_for("community").hasFields(";id;name;address;version;");
		_for("community").targetType("community");
		_for("family").referTo("community").withRole("community");
		_for("family").usedIn("kid").withRole("family");
		_for("family").isTree("false");
		_for("family").hasFields(";id;name;version;");
		_for("family").targetType("family");
		_for("family").anchorColumn("community");
		_for("public_key_type").referTo("user_domain").withRole("domain");
		_for("public_key_type").usedIn("key_pair_identity").withRole("key_type");
		_for("public_key_type").isTree("false");
		_for("public_key_type").hasFields(";id;key_alg;sign_alg;version;");
		_for("public_key_type").targetType("public_key_type");
		_for("public_key_type").anchorColumn("domain");
		_for("mobile_app").usedIn("page_type").withRole("mobile_app");
		_for("mobile_app").usedIn("page").withRole("mobile_app");
		_for("mobile_app").isTree("false");
		_for("mobile_app").hasFields(";id;name;version;");
		_for("mobile_app").targetType("mobile_app");
		_for("user_app").referTo("sec_user").withRole("sec_user");
		_for("user_app").usedIn("quick_link").withRole("app");
		_for("user_app").usedIn("list_access").withRole("app");
		_for("user_app").isTree("false");
		_for("user_app").hasFields(";id;title;app_icon;full_access;permission;app_type;app_id;ctx_type;ctx_id;location;version;");
		_for("user_app").targetType("user_app");
		_for("user_app").anchorColumn("sec_user");

	}

	protected ModelBaseDAOImpl currentDAO = null;

	public Object queryCandidates(ModelUserContext userContext, CandidateQuery query) throws Exception {
		if (CandidateQuery.FOR_SEARCH.equals(query.getScenceCode())) {
			return queryCandidatesForSearch(userContext, query);
		}
		return queryCandidatesForAssign(userContext, query);
	}

	public Object queryCandidatesForAssign(ModelUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_ASSIGN);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForAssign(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}

	public Object queryCandidatesForSearch(ModelUserContext userContext, CandidateQuery query) throws Exception {
		query.setScenceCode(CandidateQuery.FOR_SEARCH);
		query = prepareQueryInput(query);
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlForSearch(query, params);
		BaseCandidateEntity<? extends BaseEntity> candidates = executeQuery(userContext, query, sql, params);
		enhanceGroupByValues(userContext, query, candidates);
		return wrapperCandidates(userContext, candidates);
	}

	protected Object wrapperCandidates(ModelUserContext userContext, BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
		SmartList<BaseEntity> cs = (SmartList<BaseEntity>) candidates.getCandidates();

		List<Object> rList = new ArrayList<>();
		cs.forEach(v->{
			Map<String, Object> data = new HashMap<>();
			data.put("id",v.getId());
			data.put("name",v.getDisplayName());
			data.put("valuesOfGroupBy",v.valueByKey("valuesOfGroupBy"));
			rList.add(data);
		});
		return rList;
	}

  protected String normalizeModelName(String name) throws Exception {
    if (name == null) {
      return null;
    }
    if (!isValidFieldName(name)) {
      throw new Exception(name + "不是一个合法的字段名");
    }
    return new ModelNamingServiceDAO().mapToInternalColumn(name);
  }


	protected String getDisplayNameColumn(String typeName) {
		String displayNameColumn = ModelNamingServiceDAO.getDisplayNameColumnName(getJavaClassName(typeName));
		return displayNameColumn;
	}

	protected BaseCandidateEntity<? extends BaseEntity> executeQuery(ModelUserContext userContext, CandidateQuery query, String sql,
			List<Object> params) throws Exception{
		switch (query.getTargetType()) {
		case "community":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getCommunityDAO();
			return userContext.getDAOGroup().getCommunityDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "family":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getFamilyDAO();
			return userContext.getDAOGroup().getFamilyDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "kid":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getKidDAO();
			return userContext.getDAOGroup().getKidDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "mobile_app":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getMobileAppDAO();
			return userContext.getDAOGroup().getMobileAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getPageDAO();
			return userContext.getDAOGroup().getPageDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "page_type":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getPageTypeDAO();
			return userContext.getDAOGroup().getPageTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "slide":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getSlideDAO();
			return userContext.getDAOGroup().getSlideDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "ui_action":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getUiActionDAO();
			return userContext.getDAOGroup().getUiActionDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "section":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getSectionDAO();
			return userContext.getDAOGroup().getSectionDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_domain":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getUserDomainDAO();
			return userContext.getDAOGroup().getUserDomainDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_allow_list":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getUserAllowListDAO();
			return userContext.getDAOGroup().getUserAllowListDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "sec_user":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getSecUserDAO();
			return userContext.getDAOGroup().getSecUserDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "user_app":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getUserAppDAO();
			return userContext.getDAOGroup().getUserAppDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "quick_link":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getQuickLinkDAO();
			return userContext.getDAOGroup().getQuickLinkDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "list_access":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getListAccessDAO();
			return userContext.getDAOGroup().getListAccessDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "login_history":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getLoginHistoryDAO();
			return userContext.getDAOGroup().getLoginHistoryDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "candidate_container":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getCandidateContainerDAO();
			return userContext.getDAOGroup().getCandidateContainerDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "candidate_element":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getCandidateElementDAO();
			return userContext.getDAOGroup().getCandidateElementDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "wechat_workapp_identity":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getWechatWorkappIdentityDAO();
			return userContext.getDAOGroup().getWechatWorkappIdentityDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "wechat_miniapp_identity":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getWechatMiniappIdentityDAO();
			return userContext.getDAOGroup().getWechatMiniappIdentityDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "key_pair_identity":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getKeyPairIdentityDAO();
			return userContext.getDAOGroup().getKeyPairIdentityDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "public_key_type":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getPublicKeyTypeDAO();
			return userContext.getDAOGroup().getPublicKeyTypeDAO().executeCandidatesQuery(query, sql, params.toArray());
		case "tree_node":
			currentDAO = (ModelBaseDAOImpl)userContext.getDAOGroup().getTreeNodeDAO();
			return userContext.getDAOGroup().getTreeNodeDAO().executeCandidatesQuery(query, sql, params.toArray());

		default:
			throw new Exception("OOTB不支持"+query.getTargetType()+"的候选值查询");
		}
	}

	protected void enhanceGroupByValues(ModelUserContext userContext, CandidateQuery query,
			BaseCandidateEntity<? extends BaseEntity> candidates) throws Exception {
		if (query.getGroupBy() == null) {
			return; // 没有group by就直接返回
		}
		if (!isGroupByObject(query)) {
			// 用字段 group by
			for(BaseEntity cv : candidates.getCandidates()) {
				appendGroupByInfo(cv, String.valueOf(cv.propertyOf(this.getJavaMemberName(query.getGroupBy()))));
			}
			// 收集了数据就OK了
			return;
		}

		List<BaseEntity> list = new ArrayList<>();
		for(BaseEntity cv : candidates.getCandidates()) {
			Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
			if (x instanceof BaseEntity) {
				list.add((BaseEntity) x);
			}
		}

		currentDAO.alias(list);
		if (!isGroupByTree(query)) {
			for(BaseEntity cv : candidates.getCandidates()) {
				Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
				if (x instanceof BaseEntity) {
					appendGroupByInfo(cv, ((BaseEntity) x).getDisplayName());
				}
			}
			return;
		}

		String gbTypeName = this.getGroupByTypeName(query);
		Map<String, String[]> groupByNames = new HashMap<>();
		for(BaseEntity cv : candidates.getCandidates()) {
			Object x = cv.propertyOf(this.getJavaMemberName(query.getGroupBy()));
			if (x instanceof BaseEntity) {
				if (groupByNames.containsKey(((BaseEntity) x).getId())) {
					appendGroupByInfo(cv, groupByNames.get(((BaseEntity) x).getId()));
					continue;
				}
				Node<BaseEntity> rootNode = userContext.getTreeService().loadAncestors(userContext, (BaseEntity) x);
				List<String> names = new ArrayList<>();
				rootNode.visit((node)->{
					BaseEntity value = node.value();
					if (value == null) {
						return;
					}
					names.add(String.valueOf(value.getDisplayName()));
				});
				names.add(String.valueOf(((BaseEntity) x).getDisplayName()));
				appendGroupByInfo(cv, names.toArray(new String[] {}));
				groupByNames.put(((BaseEntity) x).getId(),names.toArray(new String[] {}));
			}
		}
	}

	protected void appendGroupByInfo(BaseEntity cv, String ... groupBy) {
		if (groupBy == null || groupBy.length == 0){
		    return;
		}
		if (groupBy.length > 1) {
		    cv.addItemToValueMap("valuesOfGroupBy", groupBy);
		    return;
		}
		cv.addItemToValueMap("valuesOfGroupBy", groupBy[0].split("/"));
	}
}





















