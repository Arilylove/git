package com.laison.entity.stationinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StationInfoExample() {
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

        public Criteria andStationCodeIsNull() {
            addCriterion("station_code is null");
            return (Criteria) this;
        }

        public Criteria andStationCodeIsNotNull() {
            addCriterion("station_code is not null");
            return (Criteria) this;
        }

        public Criteria andStationCodeEqualTo(Long value) {
            addCriterion("station_code =", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotEqualTo(Long value) {
            addCriterion("station_code <>", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThan(Long value) {
            addCriterion("station_code >", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("station_code >=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThan(Long value) {
            addCriterion("station_code <", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThanOrEqualTo(Long value) {
            addCriterion("station_code <=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeIn(List<Long> values) {
            addCriterion("station_code in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotIn(List<Long> values) {
            addCriterion("station_code not in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeBetween(Long value1, Long value2) {
            addCriterion("station_code between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotBetween(Long value1, Long value2) {
            addCriterion("station_code not between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationAddressIsNull() {
            addCriterion("station_address is null");
            return (Criteria) this;
        }

        public Criteria andStationAddressIsNotNull() {
            addCriterion("station_address is not null");
            return (Criteria) this;
        }

        public Criteria andStationAddressEqualTo(String value) {
            addCriterion("station_address =", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressNotEqualTo(String value) {
            addCriterion("station_address <>", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressGreaterThan(String value) {
            addCriterion("station_address >", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressGreaterThanOrEqualTo(String value) {
            addCriterion("station_address >=", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressLessThan(String value) {
            addCriterion("station_address <", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressLessThanOrEqualTo(String value) {
            addCriterion("station_address <=", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressLike(String value) {
            addCriterion("station_address like", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressNotLike(String value) {
            addCriterion("station_address not like", value, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressIn(List<String> values) {
            addCriterion("station_address in", values, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressNotIn(List<String> values) {
            addCriterion("station_address not in", values, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressBetween(String value1, String value2) {
            addCriterion("station_address between", value1, value2, "stationAddress");
            return (Criteria) this;
        }

        public Criteria andStationAddressNotBetween(String value1, String value2) {
            addCriterion("station_address not between", value1, value2, "stationAddress");
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