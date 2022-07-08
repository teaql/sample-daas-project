package com.doublechaintech.model;

public class CustomModelUserContextImpl extends ModelBizUserContextImpl {
    protected BaseEntity currentUserInfo;

    public BaseEntity getCurrentUserInfo() {
        return currentUserInfo;
    }

    public void setCurrentUserInfo(BaseEntity currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

}

