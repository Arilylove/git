package com.laison.entity.scheme.price;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceSchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceSchemeExample() {
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

        public Criteria andPriceSchemeNameIsNull() {
            addCriterion("price_scheme_name is null");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameIsNotNull() {
            addCriterion("price_scheme_name is not null");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameEqualTo(String value) {
            addCriterion("price_scheme_name =", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameNotEqualTo(String value) {
            addCriterion("price_scheme_name <>", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameGreaterThan(String value) {
            addCriterion("price_scheme_name >", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameGreaterThanOrEqualTo(String value) {
            addCriterion("price_scheme_name >=", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameLessThan(String value) {
            addCriterion("price_scheme_name <", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameLessThanOrEqualTo(String value) {
            addCriterion("price_scheme_name <=", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameLike(String value) {
            addCriterion("price_scheme_name like", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameNotLike(String value) {
            addCriterion("price_scheme_name not like", value, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameIn(List<String> values) {
            addCriterion("price_scheme_name in", values, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameNotIn(List<String> values) {
            addCriterion("price_scheme_name not in", values, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameBetween(String value1, String value2) {
            addCriterion("price_scheme_name between", value1, value2, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andPriceSchemeNameNotBetween(String value1, String value2) {
            addCriterion("price_scheme_name not between", value1, value2, "priceSchemeName");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagIsNull() {
            addCriterion("enable_min_consumed_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagIsNotNull() {
            addCriterion("enable_min_consumed_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagEqualTo(Boolean value) {
            addCriterion("enable_min_consumed_flag =", value, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagNotEqualTo(Boolean value) {
            addCriterion("enable_min_consumed_flag <>", value, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagGreaterThan(Boolean value) {
            addCriterion("enable_min_consumed_flag >", value, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_min_consumed_flag >=", value, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagLessThan(Boolean value) {
            addCriterion("enable_min_consumed_flag <", value, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_min_consumed_flag <=", value, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagIn(List<Boolean> values) {
            addCriterion("enable_min_consumed_flag in", values, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagNotIn(List<Boolean> values) {
            addCriterion("enable_min_consumed_flag not in", values, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_min_consumed_flag between", value1, value2, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andEnableMinConsumedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_min_consumed_flag not between", value1, value2, "enableMinConsumedFlag");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityIsNull() {
            addCriterion("mouth_min_consumed_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityIsNotNull() {
            addCriterion("mouth_min_consumed_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_quantity =", value, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityNotEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_quantity <>", value, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityGreaterThan(BigDecimal value) {
            addCriterion("mouth_min_consumed_quantity >", value, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_quantity >=", value, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityLessThan(BigDecimal value) {
            addCriterion("mouth_min_consumed_quantity <", value, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_quantity <=", value, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityIn(List<BigDecimal> values) {
            addCriterion("mouth_min_consumed_quantity in", values, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityNotIn(List<BigDecimal> values) {
            addCriterion("mouth_min_consumed_quantity not in", values, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mouth_min_consumed_quantity between", value1, value2, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mouth_min_consumed_quantity not between", value1, value2, "mouthMinConsumedQuantity");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountIsNull() {
            addCriterion("mouth_min_consumed_amount is null");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountIsNotNull() {
            addCriterion("mouth_min_consumed_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_amount =", value, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountNotEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_amount <>", value, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountGreaterThan(BigDecimal value) {
            addCriterion("mouth_min_consumed_amount >", value, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_amount >=", value, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountLessThan(BigDecimal value) {
            addCriterion("mouth_min_consumed_amount <", value, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mouth_min_consumed_amount <=", value, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountIn(List<BigDecimal> values) {
            addCriterion("mouth_min_consumed_amount in", values, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountNotIn(List<BigDecimal> values) {
            addCriterion("mouth_min_consumed_amount not in", values, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mouth_min_consumed_amount between", value1, value2, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andMouthMinConsumedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mouth_min_consumed_amount not between", value1, value2, "mouthMinConsumedAmount");
            return (Criteria) this;
        }

        public Criteria andSectionModeIsNull() {
            addCriterion("section_mode is null");
            return (Criteria) this;
        }

        public Criteria andSectionModeIsNotNull() {
            addCriterion("section_mode is not null");
            return (Criteria) this;
        }

        public Criteria andSectionModeEqualTo(Integer value) {
            addCriterion("section_mode =", value, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeNotEqualTo(Integer value) {
            addCriterion("section_mode <>", value, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeGreaterThan(Integer value) {
            addCriterion("section_mode >", value, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("section_mode >=", value, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeLessThan(Integer value) {
            addCriterion("section_mode <", value, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeLessThanOrEqualTo(Integer value) {
            addCriterion("section_mode <=", value, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeIn(List<Integer> values) {
            addCriterion("section_mode in", values, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeNotIn(List<Integer> values) {
            addCriterion("section_mode not in", values, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeBetween(Integer value1, Integer value2) {
            addCriterion("section_mode between", value1, value2, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andSectionModeNotBetween(Integer value1, Integer value2) {
            addCriterion("section_mode not between", value1, value2, "sectionMode");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagIsNull() {
            addCriterion("enable_vat_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagIsNotNull() {
            addCriterion("enable_vat_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagEqualTo(Boolean value) {
            addCriterion("enable_vat_flag =", value, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagNotEqualTo(Boolean value) {
            addCriterion("enable_vat_flag <>", value, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagGreaterThan(Boolean value) {
            addCriterion("enable_vat_flag >", value, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_vat_flag >=", value, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagLessThan(Boolean value) {
            addCriterion("enable_vat_flag <", value, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_vat_flag <=", value, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagIn(List<Boolean> values) {
            addCriterion("enable_vat_flag in", values, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagNotIn(List<Boolean> values) {
            addCriterion("enable_vat_flag not in", values, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_vat_flag between", value1, value2, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andEnableVatFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_vat_flag not between", value1, value2, "enableVatFlag");
            return (Criteria) this;
        }

        public Criteria andVatIsNull() {
            addCriterion("vat is null");
            return (Criteria) this;
        }

        public Criteria andVatIsNotNull() {
            addCriterion("vat is not null");
            return (Criteria) this;
        }

        public Criteria andVatEqualTo(BigDecimal value) {
            addCriterion("vat =", value, "vat");
            return (Criteria) this;
        }

        public Criteria andVatNotEqualTo(BigDecimal value) {
            addCriterion("vat <>", value, "vat");
            return (Criteria) this;
        }

        public Criteria andVatGreaterThan(BigDecimal value) {
            addCriterion("vat >", value, "vat");
            return (Criteria) this;
        }

        public Criteria andVatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vat >=", value, "vat");
            return (Criteria) this;
        }

        public Criteria andVatLessThan(BigDecimal value) {
            addCriterion("vat <", value, "vat");
            return (Criteria) this;
        }

        public Criteria andVatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vat <=", value, "vat");
            return (Criteria) this;
        }

        public Criteria andVatIn(List<BigDecimal> values) {
            addCriterion("vat in", values, "vat");
            return (Criteria) this;
        }

        public Criteria andVatNotIn(List<BigDecimal> values) {
            addCriterion("vat not in", values, "vat");
            return (Criteria) this;
        }

        public Criteria andVatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vat between", value1, value2, "vat");
            return (Criteria) this;
        }

        public Criteria andVatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vat not between", value1, value2, "vat");
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