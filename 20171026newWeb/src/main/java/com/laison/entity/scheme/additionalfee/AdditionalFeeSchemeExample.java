package com.laison.entity.scheme.additionalfee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdditionalFeeSchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdditionalFeeSchemeExample() {
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

        public Criteria andAdditionalFeeSchemeCodeIsNull() {
            addCriterion("additional_fee_scheme_code is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeIsNotNull() {
            addCriterion("additional_fee_scheme_code is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeEqualTo(Long value) {
            addCriterion("additional_fee_scheme_code =", value, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeNotEqualTo(Long value) {
            addCriterion("additional_fee_scheme_code <>", value, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeGreaterThan(Long value) {
            addCriterion("additional_fee_scheme_code >", value, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("additional_fee_scheme_code >=", value, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeLessThan(Long value) {
            addCriterion("additional_fee_scheme_code <", value, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeLessThanOrEqualTo(Long value) {
            addCriterion("additional_fee_scheme_code <=", value, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeIn(List<Long> values) {
            addCriterion("additional_fee_scheme_code in", values, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeNotIn(List<Long> values) {
            addCriterion("additional_fee_scheme_code not in", values, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeBetween(Long value1, Long value2) {
            addCriterion("additional_fee_scheme_code between", value1, value2, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeCodeNotBetween(Long value1, Long value2) {
            addCriterion("additional_fee_scheme_code not between", value1, value2, "additionalFeeSchemeCode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameIsNull() {
            addCriterion("additional_fee_scheme_name is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameIsNotNull() {
            addCriterion("additional_fee_scheme_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameEqualTo(String value) {
            addCriterion("additional_fee_scheme_name =", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameNotEqualTo(String value) {
            addCriterion("additional_fee_scheme_name <>", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameGreaterThan(String value) {
            addCriterion("additional_fee_scheme_name >", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameGreaterThanOrEqualTo(String value) {
            addCriterion("additional_fee_scheme_name >=", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameLessThan(String value) {
            addCriterion("additional_fee_scheme_name <", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameLessThanOrEqualTo(String value) {
            addCriterion("additional_fee_scheme_name <=", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameLike(String value) {
            addCriterion("additional_fee_scheme_name like", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameNotLike(String value) {
            addCriterion("additional_fee_scheme_name not like", value, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameIn(List<String> values) {
            addCriterion("additional_fee_scheme_name in", values, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameNotIn(List<String> values) {
            addCriterion("additional_fee_scheme_name not in", values, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameBetween(String value1, String value2) {
            addCriterion("additional_fee_scheme_name between", value1, value2, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeSchemeNameNotBetween(String value1, String value2) {
            addCriterion("additional_fee_scheme_name not between", value1, value2, "additionalFeeSchemeName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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