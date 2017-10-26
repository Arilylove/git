package com.laison.entity.customertype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrepaymentCustomerParmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrepaymentCustomerParmExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCustomerTypeCodeIsNull() {
            addCriterion("customer_type_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeIsNotNull() {
            addCriterion("customer_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeEqualTo(Long value) {
            addCriterion("customer_type_code =", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeNotEqualTo(Long value) {
            addCriterion("customer_type_code <>", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeGreaterThan(Long value) {
            addCriterion("customer_type_code >", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_type_code >=", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeLessThan(Long value) {
            addCriterion("customer_type_code <", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeLessThanOrEqualTo(Long value) {
            addCriterion("customer_type_code <=", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeIn(List<Long> values) {
            addCriterion("customer_type_code in", values, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeNotIn(List<Long> values) {
            addCriterion("customer_type_code not in", values, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeBetween(Long value1, Long value2) {
            addCriterion("customer_type_code between", value1, value2, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeNotBetween(Long value1, Long value2) {
            addCriterion("customer_type_code not between", value1, value2, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagIsNull() {
            addCriterion("month_limit_flag is null");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagIsNotNull() {
            addCriterion("month_limit_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagEqualTo(Boolean value) {
            addCriterion("month_limit_flag =", value, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagNotEqualTo(Boolean value) {
            addCriterion("month_limit_flag <>", value, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagGreaterThan(Boolean value) {
            addCriterion("month_limit_flag >", value, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("month_limit_flag >=", value, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagLessThan(Boolean value) {
            addCriterion("month_limit_flag <", value, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("month_limit_flag <=", value, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagIn(List<Boolean> values) {
            addCriterion("month_limit_flag in", values, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagNotIn(List<Boolean> values) {
            addCriterion("month_limit_flag not in", values, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("month_limit_flag between", value1, value2, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthLimitFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("month_limit_flag not between", value1, value2, "monthLimitFlag");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitIsNull() {
            addCriterion("month_max_consume_limit is null");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitIsNotNull() {
            addCriterion("month_max_consume_limit is not null");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitEqualTo(Integer value) {
            addCriterion("month_max_consume_limit =", value, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitNotEqualTo(Integer value) {
            addCriterion("month_max_consume_limit <>", value, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitGreaterThan(Integer value) {
            addCriterion("month_max_consume_limit >", value, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_max_consume_limit >=", value, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitLessThan(Integer value) {
            addCriterion("month_max_consume_limit <", value, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("month_max_consume_limit <=", value, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitIn(List<Integer> values) {
            addCriterion("month_max_consume_limit in", values, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitNotIn(List<Integer> values) {
            addCriterion("month_max_consume_limit not in", values, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitBetween(Integer value1, Integer value2) {
            addCriterion("month_max_consume_limit between", value1, value2, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andMonthMaxConsumeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("month_max_consume_limit not between", value1, value2, "monthMaxConsumeLimit");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIsNull() {
            addCriterion("alarm_value is null");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIsNotNull() {
            addCriterion("alarm_value is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmValueEqualTo(BigDecimal value) {
            addCriterion("alarm_value =", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotEqualTo(BigDecimal value) {
            addCriterion("alarm_value <>", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueGreaterThan(BigDecimal value) {
            addCriterion("alarm_value >", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("alarm_value >=", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueLessThan(BigDecimal value) {
            addCriterion("alarm_value <", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("alarm_value <=", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIn(List<BigDecimal> values) {
            addCriterion("alarm_value in", values, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotIn(List<BigDecimal> values) {
            addCriterion("alarm_value not in", values, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alarm_value between", value1, value2, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alarm_value not between", value1, value2, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxIsNull() {
            addCriterion("purchase_max is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxIsNotNull() {
            addCriterion("purchase_max is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxEqualTo(BigDecimal value) {
            addCriterion("purchase_max =", value, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxNotEqualTo(BigDecimal value) {
            addCriterion("purchase_max <>", value, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxGreaterThan(BigDecimal value) {
            addCriterion("purchase_max >", value, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_max >=", value, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxLessThan(BigDecimal value) {
            addCriterion("purchase_max <", value, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_max <=", value, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxIn(List<BigDecimal> values) {
            addCriterion("purchase_max in", values, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxNotIn(List<BigDecimal> values) {
            addCriterion("purchase_max not in", values, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_max between", value1, value2, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andPurchaseMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_max not between", value1, value2, "purchaseMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxIsNull() {
            addCriterion("overdraft_max is null");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxIsNotNull() {
            addCriterion("overdraft_max is not null");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxEqualTo(BigDecimal value) {
            addCriterion("overdraft_max =", value, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxNotEqualTo(BigDecimal value) {
            addCriterion("overdraft_max <>", value, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxGreaterThan(BigDecimal value) {
            addCriterion("overdraft_max >", value, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overdraft_max >=", value, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxLessThan(BigDecimal value) {
            addCriterion("overdraft_max <", value, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overdraft_max <=", value, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxIn(List<BigDecimal> values) {
            addCriterion("overdraft_max in", values, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxNotIn(List<BigDecimal> values) {
            addCriterion("overdraft_max not in", values, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdraft_max between", value1, value2, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andOverdraftMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overdraft_max not between", value1, value2, "overdraftMax");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagIsNull() {
            addCriterion("buzzer_alarm_flag is null");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagIsNotNull() {
            addCriterion("buzzer_alarm_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagEqualTo(Boolean value) {
            addCriterion("buzzer_alarm_flag =", value, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagNotEqualTo(Boolean value) {
            addCriterion("buzzer_alarm_flag <>", value, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagGreaterThan(Boolean value) {
            addCriterion("buzzer_alarm_flag >", value, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("buzzer_alarm_flag >=", value, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagLessThan(Boolean value) {
            addCriterion("buzzer_alarm_flag <", value, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("buzzer_alarm_flag <=", value, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagIn(List<Boolean> values) {
            addCriterion("buzzer_alarm_flag in", values, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagNotIn(List<Boolean> values) {
            addCriterion("buzzer_alarm_flag not in", values, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("buzzer_alarm_flag between", value1, value2, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andBuzzerAlarmFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("buzzer_alarm_flag not between", value1, value2, "buzzerAlarmFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagIsNull() {
            addCriterion("alarm_close_valve_flag is null");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagIsNotNull() {
            addCriterion("alarm_close_valve_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagEqualTo(Boolean value) {
            addCriterion("alarm_close_valve_flag =", value, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagNotEqualTo(Boolean value) {
            addCriterion("alarm_close_valve_flag <>", value, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagGreaterThan(Boolean value) {
            addCriterion("alarm_close_valve_flag >", value, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("alarm_close_valve_flag >=", value, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagLessThan(Boolean value) {
            addCriterion("alarm_close_valve_flag <", value, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("alarm_close_valve_flag <=", value, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagIn(List<Boolean> values) {
            addCriterion("alarm_close_valve_flag in", values, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagNotIn(List<Boolean> values) {
            addCriterion("alarm_close_valve_flag not in", values, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("alarm_close_valve_flag between", value1, value2, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andAlarmCloseValveFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("alarm_close_valve_flag not between", value1, value2, "alarmCloseValveFlag");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeIsNull() {
            addCriterion("friendly_period_scheme_code is null");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeIsNotNull() {
            addCriterion("friendly_period_scheme_code is not null");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeEqualTo(Long value) {
            addCriterion("friendly_period_scheme_code =", value, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeNotEqualTo(Long value) {
            addCriterion("friendly_period_scheme_code <>", value, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeGreaterThan(Long value) {
            addCriterion("friendly_period_scheme_code >", value, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("friendly_period_scheme_code >=", value, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeLessThan(Long value) {
            addCriterion("friendly_period_scheme_code <", value, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeLessThanOrEqualTo(Long value) {
            addCriterion("friendly_period_scheme_code <=", value, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeIn(List<Long> values) {
            addCriterion("friendly_period_scheme_code in", values, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeNotIn(List<Long> values) {
            addCriterion("friendly_period_scheme_code not in", values, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeBetween(Long value1, Long value2) {
            addCriterion("friendly_period_scheme_code between", value1, value2, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeCodeNotBetween(Long value1, Long value2) {
            addCriterion("friendly_period_scheme_code not between", value1, value2, "friendlyPeriodSchemeCode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}