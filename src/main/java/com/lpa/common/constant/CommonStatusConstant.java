package com.lpa.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonStatusConstant {
    public static final Integer DELETED = -1;
    public static final Integer CREATED = 0;
    public static final Integer ACTIVE = 1;
    public static final Integer SUSPENDED = 2;
}
