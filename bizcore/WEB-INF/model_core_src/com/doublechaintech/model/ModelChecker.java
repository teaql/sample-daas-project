package com.doublechaintech.model;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;

public class ModelChecker extends BaseChecker {

  public ModelChecker() {
    this.messageList = new ArrayList<Message>();
  }

  public static final String ID_OF_COMMUNITY = "community.id";

  public ModelChecker checkIdOfCommunity(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_COMMUNITY);

    return this;
  }

  public static final String NAME_OF_COMMUNITY = "community.name";

  public ModelChecker checkNameOfCommunity(String name) {

    checkStringLengthRange(name, 4, 100, NAME_OF_COMMUNITY);

    return this;
  }

  public static final String ADDRESS_OF_COMMUNITY = "community.address";

  public ModelChecker checkAddressOfCommunity(String address) {

    checkStringLengthRange(address, 4, 100, ADDRESS_OF_COMMUNITY);

    return this;
  }

  public static final String VERSION_OF_COMMUNITY = "community.version";

  public ModelChecker checkVersionOfCommunity(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_COMMUNITY);

    return this;
  }

  public static final String ID_OF_FAMILY = "family.id";

  public ModelChecker checkIdOfFamily(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_FAMILY);

    return this;
  }

  public static final String NAME_OF_FAMILY = "family.name";

  public ModelChecker checkNameOfFamily(String name) {

    checkStringLengthRange(name, 4, 100, NAME_OF_FAMILY);

    return this;
  }

  public static final String COMMUNITY_OF_FAMILY = "family.community";

  public ModelChecker checkCommunityIdOfFamily(String communityId) {

    checkIdOfFamily(communityId);

    return this;
  }

  public static final String VERSION_OF_FAMILY = "family.version";

  public ModelChecker checkVersionOfFamily(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_FAMILY);

    return this;
  }

  public static final String ID_OF_KID = "kid.id";

  public ModelChecker checkIdOfKid(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_KID);

    return this;
  }

  public static final String NAME_OF_KID = "kid.name";

  public ModelChecker checkNameOfKid(String name) {

    checkStringLengthRange(name, 2, 10, NAME_OF_KID);

    return this;
  }

  public static final String AGE_OF_KID = "kid.age";

  public ModelChecker checkAgeOfKid(int age) {

    checkIntegerRange(age, 0, 12, AGE_OF_KID);

    return this;
  }

  public static final String FAMILY_OF_KID = "kid.family";

  public ModelChecker checkFamilyIdOfKid(String familyId) {

    checkIdOfKid(familyId);

    return this;
  }

  public static final String VERSION_OF_KID = "kid.version";

  public ModelChecker checkVersionOfKid(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_KID);

    return this;
  }

  public static final String ID_OF_MOBILE_APP = "mobile_app.id";

  public ModelChecker checkIdOfMobileApp(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_MOBILE_APP);

    return this;
  }

  public static final String NAME_OF_MOBILE_APP = "mobile_app.name";

  public ModelChecker checkNameOfMobileApp(String name) {

    checkStringLengthRange(name, 2, 20, NAME_OF_MOBILE_APP);

    return this;
  }

  public static final String VERSION_OF_MOBILE_APP = "mobile_app.version";

  public ModelChecker checkVersionOfMobileApp(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_MOBILE_APP);

    return this;
  }

  public static final String ID_OF_PAGE = "page.id";

  public ModelChecker checkIdOfPage(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_PAGE);

    return this;
  }

  public static final String PAGE_TITLE_OF_PAGE = "page.page_title";

  public ModelChecker checkPageTitleOfPage(String pageTitle) {

    checkStringLengthRange(pageTitle, 1, 10, PAGE_TITLE_OF_PAGE);

    return this;
  }

  public static final String LINK_TO_URL_OF_PAGE = "page.link_to_url";

  public ModelChecker checkLinkToUrlOfPage(String linkToUrl) {

    checkStringLengthRange(linkToUrl, 0, 512, LINK_TO_URL_OF_PAGE);

    return this;
  }

  public static final String PAGE_TYPE_OF_PAGE = "page.page_type";

  public ModelChecker checkPageTypeIdOfPage(String pageTypeId) {

    checkIdOfPage(pageTypeId);

    return this;
  }

  public static final String DISPLAY_ORDER_OF_PAGE = "page.display_order";

  public ModelChecker checkDisplayOrderOfPage(int displayOrder) {

    checkIntegerRange(displayOrder, 0, 10000, DISPLAY_ORDER_OF_PAGE);

    return this;
  }

  public static final String MOBILE_APP_OF_PAGE = "page.mobile_app";

  public ModelChecker checkMobileAppIdOfPage(String mobileAppId) {

    checkIdOfPage(mobileAppId);

    return this;
  }

  public static final String VERSION_OF_PAGE = "page.version";

  public ModelChecker checkVersionOfPage(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PAGE);

    return this;
  }

  public static final String ID_OF_PAGE_TYPE = "page_type.id";

  public ModelChecker checkIdOfPageType(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_PAGE_TYPE);

    return this;
  }

  public static final String NAME_OF_PAGE_TYPE = "page_type.name";

  public ModelChecker checkNameOfPageType(String name) {

    checkStringLengthRange(name, 1, 40, NAME_OF_PAGE_TYPE);

    return this;
  }

  public static final String CODE_OF_PAGE_TYPE = "page_type.code";

  public ModelChecker checkCodeOfPageType(String code) {

    checkStringLengthRange(code, 1, 40, CODE_OF_PAGE_TYPE);

    return this;
  }

  public static final String MOBILE_APP_OF_PAGE_TYPE = "page_type.mobile_app";

  public ModelChecker checkMobileAppIdOfPageType(String mobileAppId) {

    checkIdOfPageType(mobileAppId);

    return this;
  }

  public static final String FOOTER_TAB_OF_PAGE_TYPE = "page_type.footer_tab";

  public ModelChecker checkFooterTabOfPageType(boolean footerTab) {

    return this;
  }

  public static final String VERSION_OF_PAGE_TYPE = "page_type.version";

  public ModelChecker checkVersionOfPageType(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PAGE_TYPE);

    return this;
  }

  public static final String ID_OF_SLIDE = "slide.id";

  public ModelChecker checkIdOfSlide(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_SLIDE);

    return this;
  }

  public static final String NAME_OF_SLIDE = "slide.name";

  public ModelChecker checkNameOfSlide(String name) {

    checkStringLengthRange(name, 0, 40, NAME_OF_SLIDE);

    return this;
  }

  public static final String DISPLAY_ORDER_OF_SLIDE = "slide.display_order";

  public ModelChecker checkDisplayOrderOfSlide(int displayOrder) {

    checkIntegerRange(displayOrder, 0, 10000, DISPLAY_ORDER_OF_SLIDE);

    return this;
  }

  public static final String IMAGE_URL_OF_SLIDE = "slide.image_url";

  public ModelChecker checkImageUrlOfSlide(String imageUrl) {

    checkImage(imageUrl, 0, 512, IMAGE_URL_OF_SLIDE);

    return this;
  }

  public static final String VIDEO_URL_OF_SLIDE = "slide.video_url";

  public ModelChecker checkVideoUrlOfSlide(String videoUrl) {

    checkImage(videoUrl, 0, 512, VIDEO_URL_OF_SLIDE);

    return this;
  }

  public static final String LINK_TO_URL_OF_SLIDE = "slide.link_to_url";

  public ModelChecker checkLinkToUrlOfSlide(String linkToUrl) {
    if (linkToUrl == null) {
      return this;
    }

    checkStringLengthRange(linkToUrl, 0, 512, LINK_TO_URL_OF_SLIDE);

    return this;
  }

  public static final String PAGE_OF_SLIDE = "slide.page";

  public ModelChecker checkPageIdOfSlide(String pageId) {

    checkIdOfSlide(pageId);

    return this;
  }

  public static final String VERSION_OF_SLIDE = "slide.version";

  public ModelChecker checkVersionOfSlide(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SLIDE);

    return this;
  }

  public static final String ID_OF_UI_ACTION = "ui_action.id";

  public ModelChecker checkIdOfUiAction(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_UI_ACTION);

    return this;
  }

  public static final String CODE_OF_UI_ACTION = "ui_action.code";

  public ModelChecker checkCodeOfUiAction(String code) {

    checkStringLengthRange(code, 1, 40, CODE_OF_UI_ACTION);

    return this;
  }

  public static final String ICON_OF_UI_ACTION = "ui_action.icon";

  public ModelChecker checkIconOfUiAction(String icon) {

    checkStringLengthRange(icon, 1, 512, ICON_OF_UI_ACTION);

    return this;
  }

  public static final String TITLE_OF_UI_ACTION = "ui_action.title";

  public ModelChecker checkTitleOfUiAction(String title) {

    checkStringLengthRange(title, 1, 40, TITLE_OF_UI_ACTION);

    return this;
  }

  public static final String DISPLAY_ORDER_OF_UI_ACTION = "ui_action.display_order";

  public ModelChecker checkDisplayOrderOfUiAction(int displayOrder) {

    checkIntegerRange(displayOrder, 0, 10000, DISPLAY_ORDER_OF_UI_ACTION);

    return this;
  }

  public static final String BRIEF_OF_UI_ACTION = "ui_action.brief";

  public ModelChecker checkBriefOfUiAction(String brief) {

    checkStringLengthRange(brief, 0, 200, BRIEF_OF_UI_ACTION);

    return this;
  }

  public static final String IMAGE_URL_OF_UI_ACTION = "ui_action.image_url";

  public ModelChecker checkImageUrlOfUiAction(String imageUrl) {

    checkImage(imageUrl, 0, 512, IMAGE_URL_OF_UI_ACTION);

    return this;
  }

  public static final String LINK_TO_URL_OF_UI_ACTION = "ui_action.link_to_url";

  public ModelChecker checkLinkToUrlOfUiAction(String linkToUrl) {

    checkStringLengthRange(linkToUrl, 0, 512, LINK_TO_URL_OF_UI_ACTION);

    return this;
  }

  public static final String EXTRA_DATA_OF_UI_ACTION = "ui_action.extra_data";

  public ModelChecker checkExtraDataOfUiAction(String extraData) {

    checkLongtext(extraData, 0, 1048576, EXTRA_DATA_OF_UI_ACTION);

    return this;
  }

  public static final String PAGE_OF_UI_ACTION = "ui_action.page";

  public ModelChecker checkPageIdOfUiAction(String pageId) {

    checkIdOfUiAction(pageId);

    return this;
  }

  public static final String VERSION_OF_UI_ACTION = "ui_action.version";

  public ModelChecker checkVersionOfUiAction(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_UI_ACTION);

    return this;
  }

  public static final String ID_OF_SECTION = "section.id";

  public ModelChecker checkIdOfSection(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_SECTION);

    return this;
  }

  public static final String TITLE_OF_SECTION = "section.title";

  public ModelChecker checkTitleOfSection(String title) {

    checkStringLengthRange(title, 1, 40, TITLE_OF_SECTION);

    return this;
  }

  public static final String BRIEF_OF_SECTION = "section.brief";

  public ModelChecker checkBriefOfSection(String brief) {

    checkStringLengthRange(brief, 0, 200, BRIEF_OF_SECTION);

    return this;
  }

  public static final String ICON_OF_SECTION = "section.icon";

  public ModelChecker checkIconOfSection(String icon) {

    checkImage(icon, 0, 512, ICON_OF_SECTION);

    return this;
  }

  public static final String DISPLAY_ORDER_OF_SECTION = "section.display_order";

  public ModelChecker checkDisplayOrderOfSection(int displayOrder) {

    checkIntegerRange(displayOrder, 0, 10000, DISPLAY_ORDER_OF_SECTION);

    return this;
  }

  public static final String VIEW_GROUP_OF_SECTION = "section.view_group";

  public ModelChecker checkViewGroupOfSection(String viewGroup) {

    checkStringLengthRange(viewGroup, 0, 40, VIEW_GROUP_OF_SECTION);

    return this;
  }

  public static final String LINK_TO_URL_OF_SECTION = "section.link_to_url";

  public ModelChecker checkLinkToUrlOfSection(String linkToUrl) {

    checkStringLengthRange(linkToUrl, 0, 512, LINK_TO_URL_OF_SECTION);

    return this;
  }

  public static final String PAGE_OF_SECTION = "section.page";

  public ModelChecker checkPageIdOfSection(String pageId) {

    checkIdOfSection(pageId);

    return this;
  }

  public static final String VERSION_OF_SECTION = "section.version";

  public ModelChecker checkVersionOfSection(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SECTION);

    return this;
  }

  public static final String ID_OF_USER_DOMAIN = "user_domain.id";

  public ModelChecker checkIdOfUserDomain(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_USER_DOMAIN);

    return this;
  }

  public static final String NAME_OF_USER_DOMAIN = "user_domain.name";

  public ModelChecker checkNameOfUserDomain(String name) {

    checkStringLengthRange(name, 2, 16, NAME_OF_USER_DOMAIN);

    return this;
  }

  public static final String VERSION_OF_USER_DOMAIN = "user_domain.version";

  public ModelChecker checkVersionOfUserDomain(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_USER_DOMAIN);

    return this;
  }

  public static final String ID_OF_USER_ALLOW_LIST = "user_allow_list.id";

  public ModelChecker checkIdOfUserAllowList(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_USER_ALLOW_LIST);

    return this;
  }

  public static final String USER_IDENTITY_OF_USER_ALLOW_LIST = "user_allow_list.user_identity";

  public ModelChecker checkUserIdentityOfUserAllowList(String userIdentity) {

    checkChinaMobilePhone(userIdentity, 1, 40, USER_IDENTITY_OF_USER_ALLOW_LIST);

    return this;
  }

  public static final String USER_SPECIAL_FUNCTIONS_OF_USER_ALLOW_LIST =
      "user_allow_list.user_special_functions";

  public ModelChecker checkUserSpecialFunctionsOfUserAllowList(String userSpecialFunctions) {

    checkStringLengthRange(userSpecialFunctions, 1, 200, USER_SPECIAL_FUNCTIONS_OF_USER_ALLOW_LIST);

    return this;
  }

  public static final String DOMAIN_OF_USER_ALLOW_LIST = "user_allow_list.domain";

  public ModelChecker checkDomainIdOfUserAllowList(String domainId) {

    checkIdOfUserAllowList(domainId);

    return this;
  }

  public static final String VERSION_OF_USER_ALLOW_LIST = "user_allow_list.version";

  public ModelChecker checkVersionOfUserAllowList(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_USER_ALLOW_LIST);

    return this;
  }

  public static final String ID_OF_SEC_USER = "sec_user.id";

  public ModelChecker checkIdOfSecUser(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_SEC_USER);

    return this;
  }

  public static final String LOGIN_OF_SEC_USER = "sec_user.login";

  public ModelChecker checkLoginOfSecUser(String login) {

    checkStringLengthRange(login, 0, 256, LOGIN_OF_SEC_USER);

    return this;
  }

  public static final String MOBILE_OF_SEC_USER = "sec_user.mobile";

  public ModelChecker checkMobileOfSecUser(String mobile) {

    checkChinaMobilePhone(mobile, 0, 11, MOBILE_OF_SEC_USER);

    return this;
  }

  public static final String EMAIL_OF_SEC_USER = "sec_user.email";

  public ModelChecker checkEmailOfSecUser(String email) {

    checkEmail(email, 0, 256, EMAIL_OF_SEC_USER);

    return this;
  }

  public static final String PWD_OF_SEC_USER = "sec_user.pwd";

  public ModelChecker checkPwdOfSecUser(String pwd) {

    checkPassword(pwd, 3, 28, PWD_OF_SEC_USER);

    return this;
  }

  public static final String WEIXIN_OPENID_OF_SEC_USER = "sec_user.weixin_openid";

  public ModelChecker checkWeixinOpenidOfSecUser(String weixinOpenid) {

    checkStringLengthRange(weixinOpenid, 0, 128, WEIXIN_OPENID_OF_SEC_USER);

    return this;
  }

  public static final String WEIXIN_APPID_OF_SEC_USER = "sec_user.weixin_appid";

  public ModelChecker checkWeixinAppidOfSecUser(String weixinAppid) {

    checkStringLengthRange(weixinAppid, 0, 128, WEIXIN_APPID_OF_SEC_USER);

    return this;
  }

  public static final String ACCESS_TOKEN_OF_SEC_USER = "sec_user.access_token";

  public ModelChecker checkAccessTokenOfSecUser(String accessToken) {

    checkStringLengthRange(accessToken, 0, 128, ACCESS_TOKEN_OF_SEC_USER);

    return this;
  }

  public static final String VERIFICATION_CODE_OF_SEC_USER = "sec_user.verification_code";

  public ModelChecker checkVerificationCodeOfSecUser(int verificationCode) {

    checkIntegerRange(verificationCode, 0, 9999999, VERIFICATION_CODE_OF_SEC_USER);

    return this;
  }

  public static final String VERIFICATION_CODE_EXPIRE_OF_SEC_USER =
      "sec_user.verification_code_expire";

  public ModelChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire) {

    checkDateTime(
        verificationCodeExpire,
        parseTimestamp("1900-01-01T00:00:00"),
        parseTimestamp("2099-12-31T09:09:09"),
        VERIFICATION_CODE_EXPIRE_OF_SEC_USER);

    return this;
  }

  public static final String LAST_LOGIN_TIME_OF_SEC_USER = "sec_user.last_login_time";

  public ModelChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime) {
    if (lastLoginTime == null) {
      return this;
    }

    checkDateTime(
        lastLoginTime,
        parseTimestamp("1900-01-01T00:00:00"),
        parseTimestamp("2099-12-31T09:09:09"),
        LAST_LOGIN_TIME_OF_SEC_USER);

    return this;
  }

  public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";

  public ModelChecker checkDomainIdOfSecUser(String domainId) {

    checkIdOfSecUser(domainId);

    return this;
  }

  public static final String VERSION_OF_SEC_USER = "sec_user.version";

  public ModelChecker checkVersionOfSecUser(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SEC_USER);

    return this;
  }

  public static final String ID_OF_USER_APP = "user_app.id";

  public ModelChecker checkIdOfUserApp(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_USER_APP);

    return this;
  }

  public static final String TITLE_OF_USER_APP = "user_app.title";

  public ModelChecker checkTitleOfUserApp(String title) {

    checkStringLengthRange(title, 1, 300, TITLE_OF_USER_APP);

    return this;
  }

  public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";

  public ModelChecker checkSecUserIdOfUserApp(String secUserId) {

    checkIdOfUserApp(secUserId);

    return this;
  }

  public static final String APP_ICON_OF_USER_APP = "user_app.app_icon";

  public ModelChecker checkAppIconOfUserApp(String appIcon) {

    checkStringLengthRange(appIcon, 1, 20, APP_ICON_OF_USER_APP);

    return this;
  }

  public static final String FULL_ACCESS_OF_USER_APP = "user_app.full_access";

  public ModelChecker checkFullAccessOfUserApp(boolean fullAccess) {

    return this;
  }

  public static final String PERMISSION_OF_USER_APP = "user_app.permission";

  public ModelChecker checkPermissionOfUserApp(String permission) {

    checkStringLengthRange(permission, 1, 20, PERMISSION_OF_USER_APP);

    return this;
  }

  public static final String APP_TYPE_OF_USER_APP = "user_app.app_type";

  public ModelChecker checkAppTypeOfUserApp(String appType) {

    checkStringLengthRange(appType, 1, 100, APP_TYPE_OF_USER_APP);

    return this;
  }

  public static final String APP_ID_OF_USER_APP = "user_app.app_id";

  public ModelChecker checkAppIdOfUserApp(String appId) {

    checkStringLengthRange(appId, 1, 100, APP_ID_OF_USER_APP);

    return this;
  }

  public static final String CTX_TYPE_OF_USER_APP = "user_app.ctx_type";

  public ModelChecker checkCtxTypeOfUserApp(String ctxType) {

    checkStringLengthRange(ctxType, 1, 100, CTX_TYPE_OF_USER_APP);

    return this;
  }

  public static final String CTX_ID_OF_USER_APP = "user_app.ctx_id";

  public ModelChecker checkCtxIdOfUserApp(String ctxId) {

    checkStringLengthRange(ctxId, 1, 100, CTX_ID_OF_USER_APP);

    return this;
  }

  public static final String LOCATION_OF_USER_APP = "user_app.location";

  public ModelChecker checkLocationOfUserApp(String location) {

    checkStringLengthRange(location, 0, 200, LOCATION_OF_USER_APP);

    return this;
  }

  public static final String VERSION_OF_USER_APP = "user_app.version";

  public ModelChecker checkVersionOfUserApp(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_USER_APP);

    return this;
  }

  public static final String ID_OF_QUICK_LINK = "quick_link.id";

  public ModelChecker checkIdOfQuickLink(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_QUICK_LINK);

    return this;
  }

  public static final String NAME_OF_QUICK_LINK = "quick_link.name";

  public ModelChecker checkNameOfQuickLink(String name) {

    checkStringLengthRange(name, 1, 200, NAME_OF_QUICK_LINK);

    return this;
  }

  public static final String ICON_OF_QUICK_LINK = "quick_link.icon";

  public ModelChecker checkIconOfQuickLink(String icon) {

    checkStringLengthRange(icon, 1, 200, ICON_OF_QUICK_LINK);

    return this;
  }

  public static final String IMAGE_PATH_OF_QUICK_LINK = "quick_link.image_path";

  public ModelChecker checkImagePathOfQuickLink(String imagePath) {

    checkImage(imagePath, 0, 512, IMAGE_PATH_OF_QUICK_LINK);

    return this;
  }

  public static final String LINK_TARGET_OF_QUICK_LINK = "quick_link.link_target";

  public ModelChecker checkLinkTargetOfQuickLink(String linkTarget) {

    checkStringLengthRange(linkTarget, 1, 200, LINK_TARGET_OF_QUICK_LINK);

    return this;
  }

  public static final String APP_OF_QUICK_LINK = "quick_link.app";

  public ModelChecker checkAppIdOfQuickLink(String appId) {

    checkIdOfQuickLink(appId);

    return this;
  }

  public static final String VERSION_OF_QUICK_LINK = "quick_link.version";

  public ModelChecker checkVersionOfQuickLink(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_QUICK_LINK);

    return this;
  }

  public static final String ID_OF_LIST_ACCESS = "list_access.id";

  public ModelChecker checkIdOfListAccess(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_LIST_ACCESS);

    return this;
  }

  public static final String NAME_OF_LIST_ACCESS = "list_access.name";

  public ModelChecker checkNameOfListAccess(String name) {

    checkStringLengthRange(name, 1, 200, NAME_OF_LIST_ACCESS);

    return this;
  }

  public static final String INTERNAL_NAME_OF_LIST_ACCESS = "list_access.internal_name";

  public ModelChecker checkInternalNameOfListAccess(String internalName) {

    checkStringLengthRange(internalName, 1, 200, INTERNAL_NAME_OF_LIST_ACCESS);

    return this;
  }

  public static final String READ_PERMISSION_OF_LIST_ACCESS = "list_access.read_permission";

  public ModelChecker checkReadPermissionOfListAccess(boolean readPermission) {

    return this;
  }

  public static final String CREATE_PERMISSION_OF_LIST_ACCESS = "list_access.create_permission";

  public ModelChecker checkCreatePermissionOfListAccess(boolean createPermission) {

    return this;
  }

  public static final String DELETE_PERMISSION_OF_LIST_ACCESS = "list_access.delete_permission";

  public ModelChecker checkDeletePermissionOfListAccess(boolean deletePermission) {

    return this;
  }

  public static final String UPDATE_PERMISSION_OF_LIST_ACCESS = "list_access.update_permission";

  public ModelChecker checkUpdatePermissionOfListAccess(boolean updatePermission) {

    return this;
  }

  public static final String EXECUTION_PERMISSION_OF_LIST_ACCESS =
      "list_access.execution_permission";

  public ModelChecker checkExecutionPermissionOfListAccess(boolean executionPermission) {

    return this;
  }

  public static final String APP_OF_LIST_ACCESS = "list_access.app";

  public ModelChecker checkAppIdOfListAccess(String appId) {

    checkIdOfListAccess(appId);

    return this;
  }

  public static final String VERSION_OF_LIST_ACCESS = "list_access.version";

  public ModelChecker checkVersionOfListAccess(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LIST_ACCESS);

    return this;
  }

  public static final String ID_OF_LOGIN_HISTORY = "login_history.id";

  public ModelChecker checkIdOfLoginHistory(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_LOGIN_HISTORY);

    return this;
  }

  public static final String FROM_IP_OF_LOGIN_HISTORY = "login_history.from_ip";

  public ModelChecker checkFromIpOfLoginHistory(String fromIp) {

    checkStringLengthRange(fromIp, 5, 44, FROM_IP_OF_LOGIN_HISTORY);

    return this;
  }

  public static final String DESCRIPTION_OF_LOGIN_HISTORY = "login_history.description";

  public ModelChecker checkDescriptionOfLoginHistory(String description) {

    checkStringLengthRange(description, 2, 16, DESCRIPTION_OF_LOGIN_HISTORY);

    return this;
  }

  public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";

  public ModelChecker checkSecUserIdOfLoginHistory(String secUserId) {

    checkIdOfLoginHistory(secUserId);

    return this;
  }

  public static final String VERSION_OF_LOGIN_HISTORY = "login_history.version";

  public ModelChecker checkVersionOfLoginHistory(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LOGIN_HISTORY);

    return this;
  }

  public static final String ID_OF_CANDIDATE_CONTAINER = "candidate_container.id";

  public ModelChecker checkIdOfCandidateContainer(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_CANDIDATE_CONTAINER);

    return this;
  }

  public static final String NAME_OF_CANDIDATE_CONTAINER = "candidate_container.name";

  public ModelChecker checkNameOfCandidateContainer(String name) {

    checkStringLengthRange(name, 2, 28, NAME_OF_CANDIDATE_CONTAINER);

    return this;
  }

  public static final String VERSION_OF_CANDIDATE_CONTAINER = "candidate_container.version";

  public ModelChecker checkVersionOfCandidateContainer(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CANDIDATE_CONTAINER);

    return this;
  }

  public static final String ID_OF_CANDIDATE_ELEMENT = "candidate_element.id";

  public ModelChecker checkIdOfCandidateElement(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_CANDIDATE_ELEMENT);

    return this;
  }

  public static final String NAME_OF_CANDIDATE_ELEMENT = "candidate_element.name";

  public ModelChecker checkNameOfCandidateElement(String name) {

    checkStringLengthRange(name, 1, 200, NAME_OF_CANDIDATE_ELEMENT);

    return this;
  }

  public static final String TYPE_OF_CANDIDATE_ELEMENT = "candidate_element.type";

  public ModelChecker checkTypeOfCandidateElement(String type) {

    checkStringLengthRange(type, 1, 200, TYPE_OF_CANDIDATE_ELEMENT);

    return this;
  }

  public static final String IMAGE_OF_CANDIDATE_ELEMENT = "candidate_element.image";

  public ModelChecker checkImageOfCandidateElement(String image) {

    checkImage(image, 0, 512, IMAGE_OF_CANDIDATE_ELEMENT);

    return this;
  }

  public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";

  public ModelChecker checkContainerIdOfCandidateElement(String containerId) {

    checkIdOfCandidateElement(containerId);

    return this;
  }

  public static final String VERSION_OF_CANDIDATE_ELEMENT = "candidate_element.version";

  public ModelChecker checkVersionOfCandidateElement(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CANDIDATE_ELEMENT);

    return this;
  }

  public static final String ID_OF_WECHAT_WORKAPP_IDENTITY = "wechat_workapp_identity.id";

  public ModelChecker checkIdOfWechatWorkappIdentity(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_WECHAT_WORKAPP_IDENTITY);

    return this;
  }

  public static final String CORP_ID_OF_WECHAT_WORKAPP_IDENTITY = "wechat_workapp_identity.corp_id";

  public ModelChecker checkCorpIdOfWechatWorkappIdentity(String corpId) {

    checkStringLengthRange(corpId, 0, 100, CORP_ID_OF_WECHAT_WORKAPP_IDENTITY);

    return this;
  }

  public static final String USER_ID_OF_WECHAT_WORKAPP_IDENTITY = "wechat_workapp_identity.user_id";

  public ModelChecker checkUserIdOfWechatWorkappIdentity(String userId) {

    checkStringLengthRange(userId, 1, 100, USER_ID_OF_WECHAT_WORKAPP_IDENTITY);

    return this;
  }

  public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTITY =
      "wechat_workapp_identity.sec_user";

  public ModelChecker checkSecUserIdOfWechatWorkappIdentity(String secUserId) {

    checkIdOfWechatWorkappIdentity(secUserId);

    return this;
  }

  public static final String LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTITY =
      "wechat_workapp_identity.last_login_time";

  public ModelChecker checkLastLoginTimeOfWechatWorkappIdentity(DateTime lastLoginTime) {
    if (lastLoginTime == null) {
      return this;
    }

    checkDateTime(
        lastLoginTime,
        parseTimestamp("1900-01-01T00:00:00"),
        parseTimestamp("2100-01-01T00:00:00"),
        LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTITY);

    return this;
  }

  public static final String VERSION_OF_WECHAT_WORKAPP_IDENTITY = "wechat_workapp_identity.version";

  public ModelChecker checkVersionOfWechatWorkappIdentity(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_WECHAT_WORKAPP_IDENTITY);

    return this;
  }

  public static final String ID_OF_WECHAT_MINIAPP_IDENTITY = "wechat_miniapp_identity.id";

  public ModelChecker checkIdOfWechatMiniappIdentity(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_WECHAT_MINIAPP_IDENTITY);

    return this;
  }

  public static final String OPEN_ID_OF_WECHAT_MINIAPP_IDENTITY = "wechat_miniapp_identity.open_id";

  public ModelChecker checkOpenIdOfWechatMiniappIdentity(String openId) {

    checkStringLengthRange(openId, 5, 128, OPEN_ID_OF_WECHAT_MINIAPP_IDENTITY);

    return this;
  }

  public static final String APP_ID_OF_WECHAT_MINIAPP_IDENTITY = "wechat_miniapp_identity.app_id";

  public ModelChecker checkAppIdOfWechatMiniappIdentity(String appId) {

    checkStringLengthRange(appId, 5, 128, APP_ID_OF_WECHAT_MINIAPP_IDENTITY);

    return this;
  }

  public static final String UNION_ID_OF_WECHAT_MINIAPP_IDENTITY =
      "wechat_miniapp_identity.union_id";

  public ModelChecker checkUnionIdOfWechatMiniappIdentity(String unionId) {
    if (unionId == null) {
      return this;
    }

    checkStringLengthRange(unionId, 0, 128, UNION_ID_OF_WECHAT_MINIAPP_IDENTITY);

    return this;
  }

  public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTITY =
      "wechat_miniapp_identity.sec_user";

  public ModelChecker checkSecUserIdOfWechatMiniappIdentity(String secUserId) {

    checkIdOfWechatMiniappIdentity(secUserId);

    return this;
  }

  public static final String LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTITY =
      "wechat_miniapp_identity.last_login_time";

  public ModelChecker checkLastLoginTimeOfWechatMiniappIdentity(DateTime lastLoginTime) {
    if (lastLoginTime == null) {
      return this;
    }

    checkDateTime(
        lastLoginTime,
        parseTimestamp("1900-01-01T00:00:00"),
        parseTimestamp("2100-01-01T00:00:00"),
        LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTITY);

    return this;
  }

  public static final String VERSION_OF_WECHAT_MINIAPP_IDENTITY = "wechat_miniapp_identity.version";

  public ModelChecker checkVersionOfWechatMiniappIdentity(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_WECHAT_MINIAPP_IDENTITY);

    return this;
  }

  public static final String ID_OF_KEY_PAIR_IDENTITY = "key_pair_identity.id";

  public ModelChecker checkIdOfKeyPairIdentity(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_KEY_PAIR_IDENTITY);

    return this;
  }

  public static final String PUBLIC_KEY_OF_KEY_PAIR_IDENTITY = "key_pair_identity.public_key";

  public ModelChecker checkPublicKeyOfKeyPairIdentity(String publicKey) {

    checkLongtext(publicKey, 0, 1048576, PUBLIC_KEY_OF_KEY_PAIR_IDENTITY);

    return this;
  }

  public static final String KEY_TYPE_OF_KEY_PAIR_IDENTITY = "key_pair_identity.key_type";

  public ModelChecker checkKeyTypeIdOfKeyPairIdentity(String keyTypeId) {

    checkIdOfKeyPairIdentity(keyTypeId);

    return this;
  }

  public static final String SEC_USER_OF_KEY_PAIR_IDENTITY = "key_pair_identity.sec_user";

  public ModelChecker checkSecUserIdOfKeyPairIdentity(String secUserId) {

    checkIdOfKeyPairIdentity(secUserId);

    return this;
  }

  public static final String VERSION_OF_KEY_PAIR_IDENTITY = "key_pair_identity.version";

  public ModelChecker checkVersionOfKeyPairIdentity(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_KEY_PAIR_IDENTITY);

    return this;
  }

  public static final String ID_OF_PUBLIC_KEY_TYPE = "public_key_type.id";

  public ModelChecker checkIdOfPublicKeyType(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_PUBLIC_KEY_TYPE);

    return this;
  }

  public static final String KEY_ALG_OF_PUBLIC_KEY_TYPE = "public_key_type.key_alg";

  public ModelChecker checkKeyAlgOfPublicKeyType(String keyAlg) {

    checkStringLengthRange(keyAlg, 1, 10, KEY_ALG_OF_PUBLIC_KEY_TYPE);

    return this;
  }

  public static final String SIGN_ALG_OF_PUBLIC_KEY_TYPE = "public_key_type.sign_alg";

  public ModelChecker checkSignAlgOfPublicKeyType(String signAlg) {

    checkStringLengthRange(signAlg, 1, 50, SIGN_ALG_OF_PUBLIC_KEY_TYPE);

    return this;
  }

  public static final String DOMAIN_OF_PUBLIC_KEY_TYPE = "public_key_type.domain";

  public ModelChecker checkDomainIdOfPublicKeyType(String domainId) {

    checkIdOfPublicKeyType(domainId);

    return this;
  }

  public static final String VERSION_OF_PUBLIC_KEY_TYPE = "public_key_type.version";

  public ModelChecker checkVersionOfPublicKeyType(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PUBLIC_KEY_TYPE);

    return this;
  }

  public static final String ID_OF_TREE_NODE = "tree_node.id";

  public ModelChecker checkIdOfTreeNode(String id) {

    checkStringLengthRange(id, 2, 64, ID_OF_TREE_NODE);

    return this;
  }

  public static final String NODE_ID_OF_TREE_NODE = "tree_node.node_id";

  public ModelChecker checkNodeIdOfTreeNode(String nodeId) {

    checkStringLengthRange(nodeId, 3, 40, NODE_ID_OF_TREE_NODE);

    return this;
  }

  public static final String NODE_TYPE_OF_TREE_NODE = "tree_node.node_type";

  public ModelChecker checkNodeTypeOfTreeNode(String nodeType) {

    checkStringLengthRange(nodeType, 3, 32, NODE_TYPE_OF_TREE_NODE);

    return this;
  }

  public static final String LEFT_VALUE_OF_TREE_NODE = "tree_node.left_value";

  public ModelChecker checkLeftValueOfTreeNode(int leftValue) {

    checkIntegerRange(leftValue, 1, 10000000, LEFT_VALUE_OF_TREE_NODE);

    return this;
  }

  public static final String RIGHT_VALUE_OF_TREE_NODE = "tree_node.right_value";

  public ModelChecker checkRightValueOfTreeNode(int rightValue) {

    checkIntegerRange(rightValue, 2, 10000000, RIGHT_VALUE_OF_TREE_NODE);

    return this;
  }

  public static final String VERSION_OF_TREE_NODE = "tree_node.version";

  public ModelChecker checkVersionOfTreeNode(int version) {

    checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TREE_NODE);

    return this;
  }
}
