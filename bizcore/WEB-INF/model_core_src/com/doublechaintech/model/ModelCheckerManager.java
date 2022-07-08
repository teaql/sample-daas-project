package com.doublechaintech.model;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ModelCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(ModelUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}

	protected Object daoOf(ModelUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}


	public Object queryCandidates(ModelUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidates(userContext, query);
	}

	public Object queryCandidatesForAssign(ModelUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForAssign(userContext, query);
	}

	public Object queryCandidatesForSearch(ModelUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForSearch(userContext, query);
	}

	protected ModelObjectChecker checkerOf(ModelUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}

		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}

	public static void cacheVerifyCode(ModelUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		ctx.putToCache(cacheKey, verifyCode, ModelBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	public static String getVerifyCodeFromCache(ModelUserContext ctx, String mobile) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	public static void checkVerifyCode(ModelUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}

	public com.doublechaintech.model.community.CommunityManager communityManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getCommunityManager();
	}
	public com.doublechaintech.model.community.CommunityDAO communityDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getCommunityDAO();
	}
	public com.doublechaintech.model.family.FamilyManager familyManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getFamilyManager();
	}
	public com.doublechaintech.model.family.FamilyDAO familyDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getFamilyDAO();
	}
	public com.doublechaintech.model.kid.KidManager kidManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getKidManager();
	}
	public com.doublechaintech.model.kid.KidDAO kidDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getKidDAO();
	}
	public com.doublechaintech.model.mobileapp.MobileAppManager mobileAppManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getMobileAppManager();
	}
	public com.doublechaintech.model.mobileapp.MobileAppDAO mobileAppDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getMobileAppDAO();
	}
	public com.doublechaintech.model.page.PageManager pageManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getPageManager();
	}
	public com.doublechaintech.model.page.PageDAO pageDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getPageDAO();
	}
	public com.doublechaintech.model.pagetype.PageTypeManager pageTypeManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getPageTypeManager();
	}
	public com.doublechaintech.model.pagetype.PageTypeDAO pageTypeDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getPageTypeDAO();
	}
	public com.doublechaintech.model.slide.SlideManager slideManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getSlideManager();
	}
	public com.doublechaintech.model.slide.SlideDAO slideDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getSlideDAO();
	}
	public com.doublechaintech.model.uiaction.UiActionManager uiActionManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getUiActionManager();
	}
	public com.doublechaintech.model.uiaction.UiActionDAO uiActionDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getUiActionDAO();
	}
	public com.doublechaintech.model.section.SectionManager sectionManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getSectionManager();
	}
	public com.doublechaintech.model.section.SectionDAO sectionDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getSectionDAO();
	}
	public com.doublechaintech.model.userdomain.UserDomainManager userDomainManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.doublechaintech.model.userdomain.UserDomainDAO userDomainDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.doublechaintech.model.userallowlist.UserAllowListManager userAllowListManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getUserAllowListManager();
	}
	public com.doublechaintech.model.userallowlist.UserAllowListDAO userAllowListDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getUserAllowListDAO();
	}
	public com.doublechaintech.model.secuser.SecUserManager secUserManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.doublechaintech.model.secuser.SecUserDAO secUserDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.doublechaintech.model.userapp.UserAppManager userAppManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.doublechaintech.model.userapp.UserAppDAO userAppDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.doublechaintech.model.quicklink.QuickLinkManager quickLinkManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.doublechaintech.model.quicklink.QuickLinkDAO quickLinkDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.doublechaintech.model.listaccess.ListAccessManager listAccessManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.doublechaintech.model.listaccess.ListAccessDAO listAccessDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.doublechaintech.model.loginhistory.LoginHistoryManager loginHistoryManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.doublechaintech.model.loginhistory.LoginHistoryDAO loginHistoryDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.doublechaintech.model.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.doublechaintech.model.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.doublechaintech.model.candidateelement.CandidateElementManager candidateElementManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.doublechaintech.model.candidateelement.CandidateElementDAO candidateElementDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityManager wechatWorkappIdentityManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentityManager();
	}
	public com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityDAO wechatWorkappIdentityDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentityDAO();
	}
	public com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityManager wechatMiniappIdentityManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentityManager();
	}
	public com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityDAO wechatMiniappIdentityDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentityDAO();
	}
	public com.doublechaintech.model.keypairidentity.KeyPairIdentityManager keyPairIdentityManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getKeyPairIdentityManager();
	}
	public com.doublechaintech.model.keypairidentity.KeyPairIdentityDAO keyPairIdentityDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getKeyPairIdentityDAO();
	}
	public com.doublechaintech.model.publickeytype.PublicKeyTypeManager publicKeyTypeManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getPublicKeyTypeManager();
	}
	public com.doublechaintech.model.publickeytype.PublicKeyTypeDAO publicKeyTypeDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getPublicKeyTypeDAO();
	}
	public com.doublechaintech.model.treenode.TreeNodeManager treeNodeManagerOf(ModelUserContext userContext){
		return userContext.getManagerGroup().getTreeNodeManager();
	}
	public com.doublechaintech.model.treenode.TreeNodeDAO treeNodeDaoOf(ModelUserContext userContext){
		return userContext.getDAOGroup().getTreeNodeDAO();
	}





	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {


	}

	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, ModelException exception) {


	}


	protected Object now() {

		return null;
	}

	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);

	}

	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;

	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {

	}

}



















