package com.lpa.common.constant;

import java.util.Optional;
import lombok.Getter;

@Getter
public enum UserStatusEnum {
    DELETED(-1),
    SUSPENDED(0),
    ACTIVE(1)
    ;

    private final Integer value;

    UserStatusEnum(int value) {
        this.value = value;
    }

    public static Optional<UserStatusEnum> fromValue(Integer value) {
        for (UserStatusEnum s : UserStatusEnum.values()) {
            if (s.getValue().equals(value)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}
