package com.laison.entity.scheme.price.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PriceSchemeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceSchemeDetailExample() {
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

        public Criteria andStepIndexIsNull() {
            addCriterion("step_index is null");
            return (Criteria) this;
        }

        public Criteria andStepIndexIsNotNull() {
            addCriterion("step_index is not null");
            return (Criteria) this;
        }

        public Criteria andStepIndexEqualTo(Integer value) {
            addCriterion("step_index =", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexNotEqualTo(Integer value) {
            addCriterion("step_index <>", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexGreaterThan(Integer value) {
            addCriterion("step_index >", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_index >=", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexLessThan(Integer value) {
            addCriterion("step_index <", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexLessThanOrEqualTo(Integer value) {
            addCriterion("step_index <=", value, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexIn(List<Integer> values) {
            addCriterion("step_index in", values, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexNotIn(List<Integer> values) {
            addCriterion("step_index not in", values, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexBetween(Integer value1, Integer value2) {
            addCriterion("step_index between", value1, value2, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andStepIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("step_index not between", value1, value2, "stepIndex");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeIsNull() {
            addCriterion("price_scheme_code is null");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeIsNotNull() {
            addCriterion("price_scheme_code is not null");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeEqualTo(Long value) {
            addCriterion("price_scheme_code =", value, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeNotEqualTo(Long value) {
            addCriterion("price_scheme_code <>", value, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeGreaterThan(Long value) {
            addCriterion("price_scheme_code >", value, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("price_scheme_code >=", value, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeLessThan(Long value) {
            addCriterion("price_scheme_code <", value, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeLessThanOrEqualTo(Long value) {
            addCriterion("price_scheme_code <=", value, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeIn(List<Long> values) {
            addCriterion("price_scheme_code in", values, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeNotIn(List<Long> values) {
            addCriterion("price_scheme_code not in", values, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeBetween(Long value1, Long value2) {
            addCriterion("price_scheme_code between", value1, value2, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeCodeNotBetween(Long value1, Long value2) {
            addCriterion("price_scheme_code not between", value1, value2, "priceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andEndValueIsNull() {
            addCriterion("end_value is null");
            return (Criteria) this;
        }

        public Criteria andEndValueIsNotNull() {
            addCriterion("end_value is not null");
            return (Criteria) this;
        }

        public Criteria andEndValueEqualTo(Integer value) {
            addCriterion("end_value =", value, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueNotEqualTo(Integer value) {
            addCriterion("end_value <>", value, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueGreaterThan(Integer value) {
            addCriterion("end_value >", value, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_value >=", value, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueLessThan(Integer value) {
            addCriterion("end_value <", value, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueLessThanOrEqualTo(Integer value) {
            addCriterion("end_value <=", value, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueIn(List<Integer> values) {
            addCriterion("end_value in", values, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueNotIn(List<Integer> values) {
            addCriterion("end_value not in", values, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueBetween(Integer value1, Integer value2) {
            addCriterion("end_value between", value1, value2, "endValue");
            return (Criteria) this;
        }

        public Criteria andEndValueNotBetween(Integer value1, Integer value2) {
            addCriterion("end_value not between", value1, value2, "endValue");
            return (Criteria) this;
        }

        public Criteria andStartValueIsNull() {
            addCriterion("start_value is null");
            return (Criteria) this;
        }

        public Criteria andStartValueIsNotNull() {
            addCriterion("start_value is not null");
            return (Criteria) this;
        }

        public Criteria andStartValueEqualTo(Integer value) {
            addCriterion("start_value =", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueNotEqualTo(Integer value) {
            addCriterion("start_value <>", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueGreaterThan(Integer value) {
            addCriterion("start_value >", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_value >=", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueLessThan(Integer value) {
            addCriterion("start_value <", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueLessThanOrEqualTo(Integer value) {
            addCriterion("start_value <=", value, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueIn(List<Integer> values) {
            addCriterion("start_value in", values, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueNotIn(List<Integer> values) {
            addCriterion("start_value not in", values, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueBetween(Integer value1, Integer value2) {
            addCriterion("start_value between", value1, value2, "startValue");
            return (Criteria) this;
        }

        public Criteria andStartValueNotBetween(Integer value1, Integer value2) {
            addCriterion("start_value not between", value1, value2, "startValue");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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