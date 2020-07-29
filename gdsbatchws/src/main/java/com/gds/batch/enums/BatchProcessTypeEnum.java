package com.gds.batch.enums;

public enum BatchProcessTypeEnum {

    CANCEL_RESERVATION,
    MAIL,
    SMS,
    PAYBACK,
    INITIAL_VALUE;

    public static BatchProcessTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
