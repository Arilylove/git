package com.laison.entity.coderecord;

import java.util.ArrayList;
import java.util.List;

public class CodeRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CodeRecordExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodePrefixIsNull() {
            addCriterion("code_prefix is null");
            return (Criteria) this;
        }

        public Criteria andCodePrefixIsNotNull() {
            addCriterion("code_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andCodePrefixEqualTo(Integer value) {
            addCriterion("code_prefix =", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotEqualTo(Integer value) {
            addCriterion("code_prefix <>", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixGreaterThan(Integer value) {
            addCriterion("code_prefix >", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_prefix >=", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixLessThan(Integer value) {
            addCriterion("code_prefix <", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixLessThanOrEqualTo(Integer value) {
            addCriterion("code_prefix <=", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixIn(List<Integer> values) {
            addCriterion("code_prefix in", values, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotIn(List<Integer> values) {
            addCriterion("code_prefix not in", values, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixBetween(Integer value1, Integer value2) {
            addCriterion("code_prefix between", value1, value2, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotBetween(Integer value1, Integer value2) {
            addCriterion("code_prefix not between", value1, value2, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCurrentNoIsNull() {
            addCriterion("current_no is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNoIsNotNull() {
            addCriterion("current_no is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNoEqualTo(Integer value) {
            addCriterion("current_no =", value, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoNotEqualTo(Integer value) {
            addCriterion("current_no <>", value, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoGreaterThan(Integer value) {
            addCriterion("current_no >", value, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_no >=", value, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoLessThan(Integer value) {
            addCriterion("current_no <", value, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoLessThanOrEqualTo(Integer value) {
            addCriterion("current_no <=", value, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoIn(List<Integer> values) {
            addCriterion("current_no in", values, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoNotIn(List<Integer> values) {
            addCriterion("current_no not in", values, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoBetween(Integer value1, Integer value2) {
            addCriterion("current_no between", value1, value2, "currentNo");
            return (Criteria) this;
        }

        public Criteria andCurrentNoNotBetween(Integer value1, Integer value2) {
            addCriterion("current_no not between", value1, value2, "currentNo");
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