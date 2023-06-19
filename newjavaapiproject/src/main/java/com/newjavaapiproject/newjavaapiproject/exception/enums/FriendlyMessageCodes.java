package com.newjavaapiproject.newjavaapiproject.exception.enums;

public enum FriendlyMessageCodes implements IFriendlyMessageCode {
    OK(1000),
    ERROR(1001),
    PRODUCT_NOT_CREATED_EXCEPTİON(1500);

    private final int value;

    FriendlyMessageCodes(int value) {
        this.value = value;
    }

    @Override
    public int getFriendlyMessageCode() {

        return value;
    }

}
