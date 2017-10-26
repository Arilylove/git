package com.laison.entity.meterinfo;

import java.util.ArrayList;
import java.util.List;

public class MeterInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeterInfoExample() {
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

        public Criteria andMeterCodeIsNull() {
            addCriterion("meter_code is null");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIsNotNull() {
            addCriterion("meter_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeterCodeEqualTo(Long value) {
            addCriterion("meter_code =", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotEqualTo(Long value) {
            addCriterion("meter_code <>", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeGreaterThan(Long value) {
            addCriterion("meter_code >", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("meter_code >=", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLessThan(Long value) {
            addCriterion("meter_code <", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeLessThanOrEqualTo(Long value) {
            addCriterion("meter_code <=", value, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeIn(List<Long> values) {
            addCriterion("meter_code in", values, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotIn(List<Long> values) {
            addCriterion("meter_code not in", values, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeBetween(Long value1, Long value2) {
            addCriterion("meter_code between", value1, value2, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterCodeNotBetween(Long value1, Long value2) {
            addCriterion("meter_code not between", value1, value2, "meterCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeIsNull() {
            addCriterion("meter_num_code is null");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeIsNotNull() {
            addCriterion("meter_num_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeEqualTo(Long value) {
            addCriterion("meter_num_code =", value, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeNotEqualTo(Long value) {
            addCriterion("meter_num_code <>", value, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeGreaterThan(Long value) {
            addCriterion("meter_num_code >", value, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("meter_num_code >=", value, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeLessThan(Long value) {
            addCriterion("meter_num_code <", value, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeLessThanOrEqualTo(Long value) {
            addCriterion("meter_num_code <=", value, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeIn(List<Long> values) {
            addCriterion("meter_num_code in", values, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeNotIn(List<Long> values) {
            addCriterion("meter_num_code not in", values, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeBetween(Long value1, Long value2) {
            addCriterion("meter_num_code between", value1, value2, "meterNumCode");
            return (Criteria) this;
        }

        public Criteria andMeterNumCodeNotBetween(Long value1, Long value2) {
            addCriterion("meter_num_code not between", value1, value2, "meterNumCode");
            return (Criteria) this;
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

        public Criteria andTidBaseYearIsNull() {
            addCriterion("tid_base_year is null");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearIsNotNull() {
            addCriterion("tid_base_year is not null");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearEqualTo(Integer value) {
            addCriterion("tid_base_year =", value, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearNotEqualTo(Integer value) {
            addCriterion("tid_base_year <>", value, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearGreaterThan(Integer value) {
            addCriterion("tid_base_year >", value, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid_base_year >=", value, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearLessThan(Integer value) {
            addCriterion("tid_base_year <", value, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearLessThanOrEqualTo(Integer value) {
            addCriterion("tid_base_year <=", value, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearIn(List<Integer> values) {
            addCriterion("tid_base_year in", values, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearNotIn(List<Integer> values) {
            addCriterion("tid_base_year not in", values, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearBetween(Integer value1, Integer value2) {
            addCriterion("tid_base_year between", value1, value2, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andTidBaseYearNotBetween(Integer value1, Integer value2) {
            addCriterion("tid_base_year not between", value1, value2, "tidBaseYear");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyIsNull() {
            addCriterion("encrypt_key is null");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyIsNotNull() {
            addCriterion("encrypt_key is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyEqualTo(Integer value) {
            addCriterion("encrypt_key =", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyNotEqualTo(Integer value) {
            addCriterion("encrypt_key <>", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyGreaterThan(Integer value) {
            addCriterion("encrypt_key >", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("encrypt_key >=", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyLessThan(Integer value) {
            addCriterion("encrypt_key <", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyLessThanOrEqualTo(Integer value) {
            addCriterion("encrypt_key <=", value, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyIn(List<Integer> values) {
            addCriterion("encrypt_key in", values, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyNotIn(List<Integer> values) {
            addCriterion("encrypt_key not in", values, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyBetween(Integer value1, Integer value2) {
            addCriterion("encrypt_key between", value1, value2, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("encrypt_key not between", value1, value2, "encryptKey");
            return (Criteria) this;
        }

        public Criteria andEncryptWayIsNull() {
            addCriterion("encrypt_way is null");
            return (Criteria) this;
        }

        public Criteria andEncryptWayIsNotNull() {
            addCriterion("encrypt_way is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptWayEqualTo(Integer value) {
            addCriterion("encrypt_way =", value, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayNotEqualTo(Integer value) {
            addCriterion("encrypt_way <>", value, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayGreaterThan(Integer value) {
            addCriterion("encrypt_way >", value, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("encrypt_way >=", value, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayLessThan(Integer value) {
            addCriterion("encrypt_way <", value, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayLessThanOrEqualTo(Integer value) {
            addCriterion("encrypt_way <=", value, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayIn(List<Integer> values) {
            addCriterion("encrypt_way in", values, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayNotIn(List<Integer> values) {
            addCriterion("encrypt_way not in", values, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayBetween(Integer value1, Integer value2) {
            addCriterion("encrypt_way between", value1, value2, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andEncryptWayNotBetween(Integer value1, Integer value2) {
            addCriterion("encrypt_way not between", value1, value2, "encryptWay");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesIsNull() {
            addCriterion("soft_encrypt_states is null");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesIsNotNull() {
            addCriterion("soft_encrypt_states is not null");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesEqualTo(String value) {
            addCriterion("soft_encrypt_states =", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesNotEqualTo(String value) {
            addCriterion("soft_encrypt_states <>", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesGreaterThan(String value) {
            addCriterion("soft_encrypt_states >", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesGreaterThanOrEqualTo(String value) {
            addCriterion("soft_encrypt_states >=", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesLessThan(String value) {
            addCriterion("soft_encrypt_states <", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesLessThanOrEqualTo(String value) {
            addCriterion("soft_encrypt_states <=", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesLike(String value) {
            addCriterion("soft_encrypt_states like", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesNotLike(String value) {
            addCriterion("soft_encrypt_states not like", value, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesIn(List<String> values) {
            addCriterion("soft_encrypt_states in", values, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesNotIn(List<String> values) {
            addCriterion("soft_encrypt_states not in", values, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesBetween(String value1, String value2) {
            addCriterion("soft_encrypt_states between", value1, value2, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andSoftEncryptStatesNotBetween(String value1, String value2) {
            addCriterion("soft_encrypt_states not between", value1, value2, "softEncryptStates");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyIsNull() {
            addCriterion("lora_report_frequency is null");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyIsNotNull() {
            addCriterion("lora_report_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyEqualTo(String value) {
            addCriterion("lora_report_frequency =", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyNotEqualTo(String value) {
            addCriterion("lora_report_frequency <>", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyGreaterThan(String value) {
            addCriterion("lora_report_frequency >", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("lora_report_frequency >=", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyLessThan(String value) {
            addCriterion("lora_report_frequency <", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyLessThanOrEqualTo(String value) {
            addCriterion("lora_report_frequency <=", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyLike(String value) {
            addCriterion("lora_report_frequency like", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyNotLike(String value) {
            addCriterion("lora_report_frequency not like", value, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyIn(List<String> values) {
            addCriterion("lora_report_frequency in", values, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyNotIn(List<String> values) {
            addCriterion("lora_report_frequency not in", values, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyBetween(String value1, String value2) {
            addCriterion("lora_report_frequency between", value1, value2, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraReportFrequencyNotBetween(String value1, String value2) {
            addCriterion("lora_report_frequency not between", value1, value2, "loraReportFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyIsNull() {
            addCriterion("lora_work_frequency is null");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyIsNotNull() {
            addCriterion("lora_work_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyEqualTo(String value) {
            addCriterion("lora_work_frequency =", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyNotEqualTo(String value) {
            addCriterion("lora_work_frequency <>", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyGreaterThan(String value) {
            addCriterion("lora_work_frequency >", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("lora_work_frequency >=", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyLessThan(String value) {
            addCriterion("lora_work_frequency <", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyLessThanOrEqualTo(String value) {
            addCriterion("lora_work_frequency <=", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyLike(String value) {
            addCriterion("lora_work_frequency like", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyNotLike(String value) {
            addCriterion("lora_work_frequency not like", value, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyIn(List<String> values) {
            addCriterion("lora_work_frequency in", values, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyNotIn(List<String> values) {
            addCriterion("lora_work_frequency not in", values, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyBetween(String value1, String value2) {
            addCriterion("lora_work_frequency between", value1, value2, "loraWorkFrequency");
            return (Criteria) this;
        }

        public Criteria andLoraWorkFrequencyNotBetween(String value1, String value2) {
            addCriterion("lora_work_frequency not between", value1, value2, "loraWorkFrequency");
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