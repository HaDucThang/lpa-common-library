package com.lpa.common.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WalletResponse {
    Integer id;
    Integer userId;
    String currency;
    BigDecimal balance;
    Integer status;
    Timestamp createdTimestamp;
    Timestamp lastUpdatedTimestamp;
}
