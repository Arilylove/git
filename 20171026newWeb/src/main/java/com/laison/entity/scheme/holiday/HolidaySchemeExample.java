package com.laison.entity.scheme.holiday;

import java.util.ArrayList;
import java.util.List;

public class HolidaySchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HolidaySchemeExample() {
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

        public Criteria andHolidaySchemeNameIsNull() {
            addCriterion("holiday_scheme_name is null");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameIsNotNull() {
            addCriterion("holiday_scheme_name is not null");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameEqualTo(String value) {
            addCriterion("holiday_scheme_name =", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameNotEqualTo(String value) {
            addCriterion("holiday_scheme_name <>", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameGreaterThan(String value) {
            addCriterion("holiday_scheme_name >", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_scheme_name >=", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameLessThan(String value) {
            addCriterion("holiday_scheme_name <", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameLessThanOrEqualTo(String value) {
            addCriterion("holiday_scheme_name <=", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameLike(String value) {
            addCriterion("holiday_scheme_name like", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameNotLike(String value) {
            addCriterion("holiday_scheme_name not like", value, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameIn(List<String> values) {
            addCriterion("holiday_scheme_name in", values, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameNotIn(List<String> values) {
            addCriterion("holiday_scheme_name not in", values, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameBetween(String value1, String value2) {
            addCriterion("holiday_scheme_name between", value1, value2, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andHolidaySchemeNameNotBetween(String value1, String value2) {
            addCriterion("holiday_scheme_name not between", value1, value2, "holidaySchemeName");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagIsNull() {
            addCriterion("enable_holiday_scheme_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagIsNotNull() {
            addCriterion("enable_holiday_scheme_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagEqualTo(Boolean value) {
            addCriterion("enable_holiday_scheme_flag =", value, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagNotEqualTo(Boolean value) {
            addCriterion("enable_holiday_scheme_flag <>", value, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagGreaterThan(Boolean value) {
            addCriterion("enable_holiday_scheme_flag >", value, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_holiday_scheme_flag >=", value, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagLessThan(Boolean value) {
            addCriterion("enable_holiday_scheme_flag <", value, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_holiday_scheme_flag <=", value, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagIn(List<Boolean> values) {
            addCriterion("enable_holiday_scheme_flag in", values, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagNotIn(List<Boolean> values) {
            addCriterion("enable_holiday_scheme_flag not in", values, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_holiday_scheme_flag between", value1, value2, "enableHolidaySchemeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidaySchemeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_holiday_scheme_flag not between", value1, value2, "enableHolidaySchemeFlag");
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