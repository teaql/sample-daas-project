package com.doublechaintech.model.utils;
import com.doublechaintech.model.ModelUserContext;
import java.util.HashMap;
import java.util.Map;
import com.doublechaintech.model.community.CommunityTable;
import com.doublechaintech.model.family.FamilyTable;
import com.doublechaintech.model.kid.KidTable;
import com.doublechaintech.model.mobileapp.MobileAppTable;
import com.doublechaintech.model.page.PageTable;
import com.doublechaintech.model.pagetype.PageTypeTable;
import com.doublechaintech.model.slide.SlideTable;
import com.doublechaintech.model.uiaction.UiActionTable;
import com.doublechaintech.model.section.SectionTable;
import com.doublechaintech.model.userdomain.UserDomainTable;
import com.doublechaintech.model.userallowlist.UserAllowListTable;
import com.doublechaintech.model.secuser.SecUserTable;
import com.doublechaintech.model.userapp.UserAppTable;
import com.doublechaintech.model.quicklink.QuickLinkTable;
import com.doublechaintech.model.listaccess.ListAccessTable;
import com.doublechaintech.model.loginhistory.LoginHistoryTable;
import com.doublechaintech.model.candidatecontainer.CandidateContainerTable;
import com.doublechaintech.model.candidateelement.CandidateElementTable;
import com.doublechaintech.model.wechatworkappidentity.WechatWorkappIdentityTable;
import com.doublechaintech.model.wechatminiappidentity.WechatMiniappIdentityTable;
import com.doublechaintech.model.keypairidentity.KeyPairIdentityTable;
import com.doublechaintech.model.publickeytype.PublicKeyTypeTable;
import com.doublechaintech.model.treenode.TreeNodeTable;

public class ModelAssurance {

    public static Map<String, Object> ensureModelsInDB(ModelUserContext ctx) throws Exception{
        Map<String, Object> result = new HashMap<>();
        CommunityTable.ensureTable(ctx, result);
        FamilyTable.ensureTable(ctx, result);
        KidTable.ensureTable(ctx, result);
        MobileAppTable.ensureTable(ctx, result);
        PageTable.ensureTable(ctx, result);
        PageTypeTable.ensureTable(ctx, result);
        SlideTable.ensureTable(ctx, result);
        UiActionTable.ensureTable(ctx, result);
        SectionTable.ensureTable(ctx, result);
        UserDomainTable.ensureTable(ctx, result);
        UserAllowListTable.ensureTable(ctx, result);
        SecUserTable.ensureTable(ctx, result);
        UserAppTable.ensureTable(ctx, result);
        QuickLinkTable.ensureTable(ctx, result);
        ListAccessTable.ensureTable(ctx, result);
        LoginHistoryTable.ensureTable(ctx, result);
        CandidateContainerTable.ensureTable(ctx, result);
        CandidateElementTable.ensureTable(ctx, result);
        WechatWorkappIdentityTable.ensureTable(ctx, result);
        WechatMiniappIdentityTable.ensureTable(ctx, result);
        KeyPairIdentityTable.ensureTable(ctx, result);
        PublicKeyTypeTable.ensureTable(ctx, result);
        TreeNodeTable.ensureTable(ctx, result);


        PageTypeTable.ensureData(ctx, result);

        return result;
    }

}

























































