package com.laison.entity.scheme.holiday.detail;

import java.util.ArrayList;
import java.util.List;

public class HolidayDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HolidayDetailExample() {
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

        public Criteria andHolidaySchemeCodeIsNull() {
            addCriterion("holiday_scheme_code is null");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeIsNotNull() {
            addCriterion("holiday_scheme_code is not null");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeEqualTo(Long value) {
            addCriterion("holiday_scheme_code =", value, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeNotEqualTo(Long value) {
            addCriterion("holiday_scheme_code <>", value, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeGreaterThan(Long value) {
            addCriterion("holiday_scheme_code >", value, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("holiday_scheme_code >=", value, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeLessThan(Long value) {
            addCriterion("holiday_scheme_code <", value, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeLessThanOrEqualTo(Long value) {
            addCriterion("holiday_scheme_code <=", value, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeIn(List<Long> values) {
            addCriterion("holiday_scheme_code in", values, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeNotIn(List<Long> values) {
            addCriterion("holiday_scheme_code not in", values, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeBetween(Long value1, Long value2) {
            addCriterion("holiday_scheme_code between", value1, value2, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeCodeNotBetween(Long value1, Long value2) {
            addCriterion("holiday_scheme_code not between", value1, value2, "holidaySchemeCode");
            return (Criteria) this;
        }

        public Criteria andYearOfDateIsNull() {
            addCriterion("year_of_date is null");
            return (Criteria) this;
        }

        public Criteria andYearOfDateIsNotNull() {
            addCriterion("year_of_date is not null");
            return (Criteria) this;
        }

        public Criteria andYearOfDateEqualTo(Integer value) {
            addCriterion("year_of_date =", value, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateNotEqualTo(Integer value) {
            addCriterion("year_of_date <>", value, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateGreaterThan(Integer value) {
            addCriterion("year_of_date >", value, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_of_date >=", value, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateLessThan(Integer value) {
            addCriterion("year_of_date <", value, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateLessThanOrEqualTo(Integer value) {
            addCriterion("year_of_date <=", value, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateIn(List<Integer> values) {
            addCriterion("year_of_date in", values, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateNotIn(List<Integer> values) {
            addCriterion("year_of_date not in", values, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateBetween(Integer value1, Integer value2) {
            addCriterion("year_of_date between", value1, value2, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andYearOfDateNotBetween(Integer value1, Integer value2) {
            addCriterion("year_of_date not between", value1, value2, "yearOfDate");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionIsNull() {
            addCriterion("holiday_version is null");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionIsNotNull() {
            addCriterion("holiday_version is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionEqualTo(Integer value) {
            addCriterion("holiday_version =", value, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionNotEqualTo(Integer value) {
            addCriterion("holiday_version <>", value, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionGreaterThan(Integer value) {
            addCriterion("holiday_version >", value, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("holiday_version >=", value, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionLessThan(Integer value) {
            addCriterion("holiday_version <", value, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionLessThanOrEqualTo(Integer value) {
            addCriterion("holiday_version <=", value, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionIn(List<Integer> values) {
            addCriterion("holiday_version in", values, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionNotIn(List<Integer> values) {
            addCriterion("holiday_version not in", values, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionBetween(Integer value1, Integer value2) {
            addCriterion("holiday_version between", value1, value2, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("holiday_version not between", value1, value2, "holidayVersion");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringIsNull() {
            addCriterion("holiday_hex_string is null");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringIsNotNull() {
            addCriterion("holiday_hex_string is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringEqualTo(String value) {
            addCriterion("holiday_hex_string =", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringNotEqualTo(String value) {
            addCriterion("holiday_hex_string <>", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringGreaterThan(String value) {
            addCriterion("holiday_hex_string >", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_hex_string >=", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringLessThan(String value) {
            addCriterion("holiday_hex_string <", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringLessThanOrEqualTo(String value) {
            addCriterion("holiday_hex_string <=", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringLike(String value) {
            addCriterion("holiday_hex_string like", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringNotLike(String value) {
            addCriterion("holiday_hex_string not like", value, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringIn(List<String> values) {
            addCriterion("holiday_hex_string in", values, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringNotIn(List<String> values) {
            addCriterion("holiday_hex_string not in", values, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringBetween(String value1, String value2) {
            addCriterion("holiday_hex_string between", value1, value2, "holidayHexString");
            return (Criteria) this;
        }

        public Criteria andHolidayHexStringNotBetween(String value1, String value2) {
            addCriterion("holiday_hex_string not between", value1, value2, "holidayHexString");
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