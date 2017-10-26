package com.laison.entity.scheme.friendlyperiod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendlyPeriodSchemeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendlyPeriodSchemeExample() {
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

        public Criteria andFriendlyPeriodSchemeNameIsNull() {
            addCriterion("friendly_period_scheme_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameIsNotNull() {
            addCriterion("friendly_period_scheme_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameEqualTo(String value) {
            addCriterion("friendly_period_scheme_name =", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameNotEqualTo(String value) {
            addCriterion("friendly_period_scheme_name <>", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameGreaterThan(String value) {
            addCriterion("friendly_period_scheme_name >", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameGreaterThanOrEqualTo(String value) {
            addCriterion("friendly_period_scheme_name >=", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameLessThan(String value) {
            addCriterion("friendly_period_scheme_name <", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameLessThanOrEqualTo(String value) {
            addCriterion("friendly_period_scheme_name <=", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameLike(String value) {
            addCriterion("friendly_period_scheme_name like", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameNotLike(String value) {
            addCriterion("friendly_period_scheme_name not like", value, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameIn(List<String> values) {
            addCriterion("friendly_period_scheme_name in", values, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameNotIn(List<String> values) {
            addCriterion("friendly_period_scheme_name not in", values, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameBetween(String value1, String value2) {
            addCriterion("friendly_period_scheme_name between", value1, value2, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodSchemeNameNotBetween(String value1, String value2) {
            addCriterion("friendly_period_scheme_name not between", value1, value2, "friendlyPeriodSchemeName");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountIsNull() {
            addCriterion("friendly_period_use_count is null");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountIsNotNull() {
            addCriterion("friendly_period_use_count is not null");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountEqualTo(Integer value) {
            addCriterion("friendly_period_use_count =", value, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountNotEqualTo(Integer value) {
            addCriterion("friendly_period_use_count <>", value, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountGreaterThan(Integer value) {
            addCriterion("friendly_period_use_count >", value, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("friendly_period_use_count >=", value, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountLessThan(Integer value) {
            addCriterion("friendly_period_use_count <", value, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountLessThanOrEqualTo(Integer value) {
            addCriterion("friendly_period_use_count <=", value, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountIn(List<Integer> values) {
            addCriterion("friendly_period_use_count in", values, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountNotIn(List<Integer> values) {
            addCriterion("friendly_period_use_count not in", values, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountBetween(Integer value1, Integer value2) {
            addCriterion("friendly_period_use_count between", value1, value2, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andFriendlyPeriodUseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("friendly_period_use_count not between", value1, value2, "friendlyPeriodUseCount");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagIsNull() {
            addCriterion("enable_offduty_time_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagIsNotNull() {
            addCriterion("enable_offduty_time_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagEqualTo(Boolean value) {
            addCriterion("enable_offduty_time_flag =", value, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagNotEqualTo(Boolean value) {
            addCriterion("enable_offduty_time_flag <>", value, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagGreaterThan(Boolean value) {
            addCriterion("enable_offduty_time_flag >", value, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_offduty_time_flag >=", value, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagLessThan(Boolean value) {
            addCriterion("enable_offduty_time_flag <", value, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_offduty_time_flag <=", value, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagIn(List<Boolean> values) {
            addCriterion("enable_offduty_time_flag in", values, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagNotIn(List<Boolean> values) {
            addCriterion("enable_offduty_time_flag not in", values, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_offduty_time_flag between", value1, value2, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableOffdutyTimeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_offduty_time_flag not between", value1, value2, "enableOffdutyTimeFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagIsNull() {
            addCriterion("enable_weekend_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagIsNotNull() {
            addCriterion("enable_weekend_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagEqualTo(Boolean value) {
            addCriterion("enable_weekend_flag =", value, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagNotEqualTo(Boolean value) {
            addCriterion("enable_weekend_flag <>", value, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagGreaterThan(Boolean value) {
            addCriterion("enable_weekend_flag >", value, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_weekend_flag >=", value, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagLessThan(Boolean value) {
            addCriterion("enable_weekend_flag <", value, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_weekend_flag <=", value, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagIn(List<Boolean> values) {
            addCriterion("enable_weekend_flag in", values, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagNotIn(List<Boolean> values) {
            addCriterion("enable_weekend_flag not in", values, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_weekend_flag between", value1, value2, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableWeekendFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_weekend_flag not between", value1, value2, "enableWeekendFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagIsNull() {
            addCriterion("enable_holiday_flag is null");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagIsNotNull() {
            addCriterion("enable_holiday_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagEqualTo(Boolean value) {
            addCriterion("enable_holiday_flag =", value, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagNotEqualTo(Boolean value) {
            addCriterion("enable_holiday_flag <>", value, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagGreaterThan(Boolean value) {
            addCriterion("enable_holiday_flag >", value, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_holiday_flag >=", value, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagLessThan(Boolean value) {
            addCriterion("enable_holiday_flag <", value, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_holiday_flag <=", value, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagIn(List<Boolean> values) {
            addCriterion("enable_holiday_flag in", values, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagNotIn(List<Boolean> values) {
            addCriterion("enable_holiday_flag not in", values, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_holiday_flag between", value1, value2, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andEnableHolidayFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_holiday_flag not between", value1, value2, "enableHolidayFlag");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartIsNull() {
            addCriterion("offduty_time_start is null");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartIsNotNull() {
            addCriterion("offduty_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartEqualTo(String value) {
            addCriterion("offduty_time_start =", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartNotEqualTo(String value) {
            addCriterion("offduty_time_start <>", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartGreaterThan(String value) {
            addCriterion("offduty_time_start >", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartGreaterThanOrEqualTo(String value) {
            addCriterion("offduty_time_start >=", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartLessThan(String value) {
            addCriterion("offduty_time_start <", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartLessThanOrEqualTo(String value) {
            addCriterion("offduty_time_start <=", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartLike(String value) {
            addCriterion("offduty_time_start like", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartNotLike(String value) {
            addCriterion("offduty_time_start not like", value, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartIn(List<String> values) {
            addCriterion("offduty_time_start in", values, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartNotIn(List<String> values) {
            addCriterion("offduty_time_start not in", values, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartBetween(String value1, String value2) {
            addCriterion("offduty_time_start between", value1, value2, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeStartNotBetween(String value1, String value2) {
            addCriterion("offduty_time_start not between", value1, value2, "offdutyTimeStart");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndIsNull() {
            addCriterion("offduty_time_end is null");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndIsNotNull() {
            addCriterion("offduty_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndEqualTo(String value) {
            addCriterion("offduty_time_end =", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndNotEqualTo(String value) {
            addCriterion("offduty_time_end <>", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndGreaterThan(String value) {
            addCriterion("offduty_time_end >", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndGreaterThanOrEqualTo(String value) {
            addCriterion("offduty_time_end >=", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndLessThan(String value) {
            addCriterion("offduty_time_end <", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndLessThanOrEqualTo(String value) {
            addCriterion("offduty_time_end <=", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndLike(String value) {
            addCriterion("offduty_time_end like", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndNotLike(String value) {
            addCriterion("offduty_time_end not like", value, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndIn(List<String> values) {
            addCriterion("offduty_time_end in", values, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndNotIn(List<String> values) {
            addCriterion("offduty_time_end not in", values, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndBetween(String value1, String value2) {
            addCriterion("offduty_time_end between", value1, value2, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andOffdutyTimeEndNotBetween(String value1, String value2) {
            addCriterion("offduty_time_end not between", value1, value2, "offdutyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringIsNull() {
            addCriterion("weekend_day_string is null");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringIsNotNull() {
            addCriterion("weekend_day_string is not null");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringEqualTo(String value) {
            addCriterion("weekend_day_string =", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringNotEqualTo(String value) {
            addCriterion("weekend_day_string <>", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringGreaterThan(String value) {
            addCriterion("weekend_day_string >", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringGreaterThanOrEqualTo(String value) {
            addCriterion("weekend_day_string >=", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringLessThan(String value) {
            addCriterion("weekend_day_string <", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringLessThanOrEqualTo(String value) {
            addCriterion("weekend_day_string <=", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringLike(String value) {
            addCriterion("weekend_day_string like", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringNotLike(String value) {
            addCriterion("weekend_day_string not like", value, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringIn(List<String> values) {
            addCriterion("weekend_day_string in", values, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringNotIn(List<String> values) {
            addCriterion("weekend_day_string not in", values, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringBetween(String value1, String value2) {
            addCriterion("weekend_day_string between", value1, value2, "weekendDayString");
            return (Criteria) this;
        }

        public Criteria andWeekendDayStringNotBetween(String value1, String value2) {
            addCriterion("weekend_day_string not between", value1, value2, "weekendDayString");
            return (Criteria) this;
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