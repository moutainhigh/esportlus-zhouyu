package com.kaihei.esportingplus.riskrating.declare.impl;

import com.kaihei.esportingplus.riskrating.api.enums.RiskEnum;
import com.kaihei.esportingplus.riskrating.declare.IncreaseAndPreventRiskDeclare;
import com.kaihei.esportingplus.riskrating.domain.entity.Recharge;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

/**
 * @author 谢思勇
 * @date 2018年10月19日 15:43:05
 */
@Component
public class UserDayRechargeRiskDeclare extends IncreaseAndPreventRiskDeclare {

    /**
     * 由子类实现
     *
     * 定义：Redis上的Key
     */
    @Override
    protected String getIncrKey(Recharge recharge) {
        return String.format("riskrating:ios:date:%s:user:%s",
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")), recharge.getUid());
    }


    /**
     * 字典：风控值阀值的 itemCode
     */
    @Override
    protected String getThresholdItemCode() {
        return "USER_DAY_MAX_RECHARGE";
    }

    /**
     * 有风险时，返回前端的View
     */
    @Override
    protected RiskEnum getOnRiskWarn() {
        return RiskEnum.USER_DAY_RECHARGE_AMOUNT_LIMIT;
    }

}
