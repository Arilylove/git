package com.laison.entity.companyinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInfoExample() {
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

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(Long value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(Long value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(Long value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(Long value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(Long value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<Long> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<Long> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(Long value1, Long value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(Long value1, Long value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNull() {
            addCriterion("currency_unit is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNotNull() {
            addCriterion("currency_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitEqualTo(String value) {
            addCriterion("currency_unit =", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotEqualTo(String value) {
            addCriterion("currency_unit <>", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThan(String value) {
            addCriterion("currency_unit >", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("currency_unit >=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThan(String value) {
            addCriterion("currency_unit <", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThanOrEqualTo(String value) {
            addCriterion("currency_unit <=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLike(String value) {
            addCriterion("currency_unit like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotLike(String value) {
            addCriterion("currency_unit not like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIn(List<String> values) {
            addCriterion("currency_unit in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotIn(List<String> values) {
            addCriterion("currency_unit not in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitBetween(String value1, String value2) {
            addCriterion("currency_unit between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotBetween(String value1, String value2) {
            addCriterion("currency_unit not between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitIsNull() {
            addCriterion("quantity_unit is null");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitIsNotNull() {
            addCriterion("quantity_unit is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitEqualTo(String value) {
            addCriterion("quantity_unit =", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotEqualTo(String value) {
            addCriterion("quantity_unit <>", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitGreaterThan(String value) {
            addCriterion("quantity_unit >", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitGreaterThanOrEqualTo(String value) {
            addCriterion("quantity_unit >=", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitLessThan(String value) {
            addCriterion("quantity_unit <", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitLessThanOrEqualTo(String value) {
            addCriterion("quantity_unit <=", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitLike(String value) {
            addCriterion("quantity_unit like", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotLike(String value) {
            addCriterion("quantity_unit not like", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitIn(List<String> values) {
            addCriterion("quantity_unit in", values, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotIn(List<String> values) {
            addCriterion("quantity_unit not in", values, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitBetween(String value1, String value2) {
            addCriterion("quantity_unit between", value1, value2, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotBetween(String value1, String value2) {
            addCriterion("quantity_unit not between", value1, value2, "quantityUnit");
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

        public Criteria andStsKeyIdIsNull() {
            addCriterion("sts_key_id is null");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdIsNotNull() {
            addCriterion("sts_key_id is not null");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdEqualTo(Integer value) {
            addCriterion("sts_key_id =", value, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdNotEqualTo(Integer value) {
            addCriterion("sts_key_id <>", value, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdGreaterThan(Integer value) {
            addCriterion("sts_key_id >", value, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sts_key_id >=", value, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdLessThan(Integer value) {
            addCriterion("sts_key_id <", value, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdLessThanOrEqualTo(Integer value) {
            addCriterion("sts_key_id <=", value, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdIn(List<Integer> values) {
            addCriterion("sts_key_id in", values, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdNotIn(List<Integer> values) {
            addCriterion("sts_key_id not in", values, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdBetween(Integer value1, Integer value2) {
            addCriterion("sts_key_id between", value1, value2, "stsKeyId");
            return (Criteria) this;
        }

        public Criteria andStsKeyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sts_key_id not between", value1, value2, "stsKeyId");
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