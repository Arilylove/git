package com.laison.entity.meterinfo.detail;

import java.util.ArrayList;
import java.util.List;

public class MeterInfoDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeterInfoDetailExample() {
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

        public Criteria andMeterNumIsNull() {
            addCriterion("meter_num is null");
            return (Criteria) this;
        }

        public Criteria andMeterNumIsNotNull() {
            addCriterion("meter_num is not null");
            return (Criteria) this;
        }

        public Criteria andMeterNumEqualTo(String value) {
            addCriterion("meter_num =", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumNotEqualTo(String value) {
            addCriterion("meter_num <>", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumGreaterThan(String value) {
            addCriterion("meter_num >", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumGreaterThanOrEqualTo(String value) {
            addCriterion("meter_num >=", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumLessThan(String value) {
            addCriterion("meter_num <", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumLessThanOrEqualTo(String value) {
            addCriterion("meter_num <=", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumLike(String value) {
            addCriterion("meter_num like", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumNotLike(String value) {
            addCriterion("meter_num not like", value, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumIn(List<String> values) {
            addCriterion("meter_num in", values, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumNotIn(List<String> values) {
            addCriterion("meter_num not in", values, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumBetween(String value1, String value2) {
            addCriterion("meter_num between", value1, value2, "meterNum");
            return (Criteria) this;
        }

        public Criteria andMeterNumNotBetween(String value1, String value2) {
            addCriterion("meter_num not between", value1, value2, "meterNum");
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