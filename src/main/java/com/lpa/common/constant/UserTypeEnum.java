package com.lpa.common.constant;

import java.util.Optional;
import lombok.Getter;

@Getter
public enum UserTypeEnum {
    ADMIN(1,"admin"),
    CUSTOMER(2,"customer"),
    AGENT(3, "agent"),
    ;

    private final Integer id;
    private final String value;

    UserTypeEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public boolean isValid(String userType) {
        return fromValue(userType).isPresent();
    }

    public static Optional<UserTypeEnum> fromValue(String value) {
        for (UserTypeEnum s : UserTypeEnum.values()) {
            if (s.getValue().equals(value)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public static Optional<UserTypeEnum> fromId(Integer id) {
        for (UserTypeEnum s : UserTypeEnum.values()) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return this.value;
    }
}
