package com.laison.entity.regioninfo;

import java.util.ArrayList;
import java.util.List;

public class RegionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegionInfoExample() {
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

        public Criteria andRegionCodeIsNull() {
            addCriterion("region_code is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("region_code is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(Long value) {
            addCriterion("region_code =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(Long value) {
            addCriterion("region_code <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(Long value) {
            addCriterion("region_code >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("region_code >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(Long value) {
            addCriterion("region_code <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(Long value) {
            addCriterion("region_code <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<Long> values) {
            addCriterion("region_code in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<Long> values) {
            addCriterion("region_code not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(Long value1, Long value2) {
            addCriterion("region_code between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(Long value1, Long value2) {
            addCriterion("region_code not between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdIsNull() {
            addCriterion("parent_region_id is null");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdIsNotNull() {
            addCriterion("parent_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdEqualTo(Long value) {
            addCriterion("parent_region_id =", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdNotEqualTo(Long value) {
            addCriterion("parent_region_id <>", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdGreaterThan(Long value) {
            addCriterion("parent_region_id >", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_region_id >=", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdLessThan(Long value) {
            addCriterion("parent_region_id <", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_region_id <=", value, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdIn(List<Long> values) {
            addCriterion("parent_region_id in", values, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdNotIn(List<Long> values) {
            addCriterion("parent_region_id not in", values, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdBetween(Long value1, Long value2) {
            addCriterion("parent_region_id between", value1, value2, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andParentRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_region_id not between", value1, value2, "parentRegionId");
            return (Criteria) this;
        }

        public Criteria andPathsIsNull() {
            addCriterion("paths is null");
            return (Criteria) this;
        }

        public Criteria andPathsIsNotNull() {
            addCriterion("paths is not null");
            return (Criteria) this;
        }

        public Criteria andPathsEqualTo(String value) {
            addCriterion("paths =", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsNotEqualTo(String value) {
            addCriterion("paths <>", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsGreaterThan(String value) {
            addCriterion("paths >", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsGreaterThanOrEqualTo(String value) {
            addCriterion("paths >=", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsLessThan(String value) {
            addCriterion("paths <", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsLessThanOrEqualTo(String value) {
            addCriterion("paths <=", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsLike(String value) {
            addCriterion("paths like", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsNotLike(String value) {
            addCriterion("paths not like", value, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsIn(List<String> values) {
            addCriterion("paths in", values, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsNotIn(List<String> values) {
            addCriterion("paths not in", values, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsBetween(String value1, String value2) {
            addCriterion("paths between", value1, value2, "paths");
            return (Criteria) this;
        }

        public Criteria andPathsNotBetween(String value1, String value2) {
            addCriterion("paths not between", value1, value2, "paths");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("region_name is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("region_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("region_name =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("region_name <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("region_name >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("region_name >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("region_name <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("region_name <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("region_name like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("region_name not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("region_name in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("region_name not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("region_name between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("region_name not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionTypeIsNull() {
            addCriterion("region_type is null");
            return (Criteria) this;
        }

        public Criteria andRegionTypeIsNotNull() {
            addCriterion("region_type is not null");
            return (Criteria) this;
        }

        public Criteria andRegionTypeEqualTo(Integer value) {
            addCriterion("region_type =", value, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeNotEqualTo(Integer value) {
            addCriterion("region_type <>", value, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeGreaterThan(Integer value) {
            addCriterion("region_type >", value, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("region_type >=", value, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeLessThan(Integer value) {
            addCriterion("region_type <", value, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("region_type <=", value, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeIn(List<Integer> values) {
            addCriterion("region_type in", values, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeNotIn(List<Integer> values) {
            addCriterion("region_type not in", values, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeBetween(Integer value1, Integer value2) {
            addCriterion("region_type between", value1, value2, "regionType");
            return (Criteria) this;
        }

        public Criteria andRegionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("region_type not between", value1, value2, "regionType");
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