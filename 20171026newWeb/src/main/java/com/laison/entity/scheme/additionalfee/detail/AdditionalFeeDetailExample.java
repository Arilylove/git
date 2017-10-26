package com.laison.entity.scheme.additionalfee.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdditionalFeeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdditionalFeeDetailExample() {
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

        public Criteria andAdditionalFeeIndexIsNull() {
            addCriterion("additional_fee_index is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexIsNotNull() {
            addCriterion("additional_fee_index is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexEqualTo(Long value) {
            addCriterion("additional_fee_index =", value, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexNotEqualTo(Long value) {
            addCriterion("additional_fee_index <>", value, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexGreaterThan(Long value) {
            addCriterion("additional_fee_index >", value, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("additional_fee_index >=", value, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexLessThan(Long value) {
            addCriterion("additional_fee_index <", value, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexLessThanOrEqualTo(Long value) {
            addCriterion("additional_fee_index <=", value, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexIn(List<Long> values) {
            addCriterion("additional_fee_index in", values, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexNotIn(List<Long> values) {
            addCriterion("additional_fee_index not in", values, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexBetween(Long value1, Long value2) {
            addCriterion("additional_fee_index between", value1, value2, "additionalFeeIndex");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeIndexNotBetween(Long value1, Long value2) {
            addCriterion("additional_fee_index not between", value1, value2, "additionalFeeIndex");
            return (Criteria) this;
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

        public Criteria andAdditionalFeeNameIsNull() {
            addCriterion("additional_fee_name is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameIsNotNull() {
            addCriterion("additional_fee_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameEqualTo(String value) {
            addCriterion("additional_fee_name =", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameNotEqualTo(String value) {
            addCriterion("additional_fee_name <>", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameGreaterThan(String value) {
            addCriterion("additional_fee_name >", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("additional_fee_name >=", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameLessThan(String value) {
            addCriterion("additional_fee_name <", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameLessThanOrEqualTo(String value) {
            addCriterion("additional_fee_name <=", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameLike(String value) {
            addCriterion("additional_fee_name like", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameNotLike(String value) {
            addCriterion("additional_fee_name not like", value, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameIn(List<String> values) {
            addCriterion("additional_fee_name in", values, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameNotIn(List<String> values) {
            addCriterion("additional_fee_name not in", values, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameBetween(String value1, String value2) {
            addCriterion("additional_fee_name between", value1, value2, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeNameNotBetween(String value1, String value2) {
            addCriterion("additional_fee_name not between", value1, value2, "additionalFeeName");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeIsNull() {
            addCriterion("additional_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeIsNotNull() {
            addCriterion("additional_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeEqualTo(Integer value) {
            addCriterion("additional_fee_type =", value, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeNotEqualTo(Integer value) {
            addCriterion("additional_fee_type <>", value, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeGreaterThan(Integer value) {
            addCriterion("additional_fee_type >", value, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("additional_fee_type >=", value, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeLessThan(Integer value) {
            addCriterion("additional_fee_type <", value, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("additional_fee_type <=", value, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeIn(List<Integer> values) {
            addCriterion("additional_fee_type in", values, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeNotIn(List<Integer> values) {
            addCriterion("additional_fee_type not in", values, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("additional_fee_type between", value1, value2, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("additional_fee_type not between", value1, value2, "additionalFeeType");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeIsNull() {
            addCriterion("additional_fee_deduction_mode is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeIsNotNull() {
            addCriterion("additional_fee_deduction_mode is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_mode =", value, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeNotEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_mode <>", value, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeGreaterThan(Integer value) {
            addCriterion("additional_fee_deduction_mode >", value, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_mode >=", value, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeLessThan(Integer value) {
            addCriterion("additional_fee_deduction_mode <", value, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeLessThanOrEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_mode <=", value, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeIn(List<Integer> values) {
            addCriterion("additional_fee_deduction_mode in", values, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeNotIn(List<Integer> values) {
            addCriterion("additional_fee_deduction_mode not in", values, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeBetween(Integer value1, Integer value2) {
            addCriterion("additional_fee_deduction_mode between", value1, value2, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionModeNotBetween(Integer value1, Integer value2) {
            addCriterion("additional_fee_deduction_mode not between", value1, value2, "additionalFeeDeductionMode");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateIsNull() {
            addCriterion("additional_fee_deduction_rate is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateIsNotNull() {
            addCriterion("additional_fee_deduction_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_rate =", value, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateNotEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_rate <>", value, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateGreaterThan(BigDecimal value) {
            addCriterion("additional_fee_deduction_rate >", value, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_rate >=", value, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateLessThan(BigDecimal value) {
            addCriterion("additional_fee_deduction_rate <", value, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_rate <=", value, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateIn(List<BigDecimal> values) {
            addCriterion("additional_fee_deduction_rate in", values, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateNotIn(List<BigDecimal> values) {
            addCriterion("additional_fee_deduction_rate not in", values, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_deduction_rate between", value1, value2, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_deduction_rate not between", value1, value2, "additionalFeeDeductionRate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesIsNull() {
            addCriterion("additional_fee_deduction_times is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesIsNotNull() {
            addCriterion("additional_fee_deduction_times is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_times =", value, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesNotEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_times <>", value, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesGreaterThan(Integer value) {
            addCriterion("additional_fee_deduction_times >", value, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_times >=", value, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesLessThan(Integer value) {
            addCriterion("additional_fee_deduction_times <", value, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesLessThanOrEqualTo(Integer value) {
            addCriterion("additional_fee_deduction_times <=", value, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesIn(List<Integer> values) {
            addCriterion("additional_fee_deduction_times in", values, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesNotIn(List<Integer> values) {
            addCriterion("additional_fee_deduction_times not in", values, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesBetween(Integer value1, Integer value2) {
            addCriterion("additional_fee_deduction_times between", value1, value2, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("additional_fee_deduction_times not between", value1, value2, "additionalFeeDeductionTimes");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountIsNull() {
            addCriterion("additional_fee_deduction_amount is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountIsNotNull() {
            addCriterion("additional_fee_deduction_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_amount =", value, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountNotEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_amount <>", value, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountGreaterThan(BigDecimal value) {
            addCriterion("additional_fee_deduction_amount >", value, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_amount >=", value, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountLessThan(BigDecimal value) {
            addCriterion("additional_fee_deduction_amount <", value, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_amount <=", value, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountIn(List<BigDecimal> values) {
            addCriterion("additional_fee_deduction_amount in", values, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountNotIn(List<BigDecimal> values) {
            addCriterion("additional_fee_deduction_amount not in", values, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_deduction_amount between", value1, value2, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_deduction_amount not between", value1, value2, "additionalFeeDeductionAmount");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceIsNull() {
            addCriterion("additional_fee_deduction_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceIsNotNull() {
            addCriterion("additional_fee_deduction_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_unit_price =", value, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_unit_price <>", value, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("additional_fee_deduction_unit_price >", value, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_unit_price >=", value, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceLessThan(BigDecimal value) {
            addCriterion("additional_fee_deduction_unit_price <", value, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_deduction_unit_price <=", value, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceIn(List<BigDecimal> values) {
            addCriterion("additional_fee_deduction_unit_price in", values, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("additional_fee_deduction_unit_price not in", values, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_deduction_unit_price between", value1, value2, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeDeductionUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_deduction_unit_price not between", value1, value2, "additionalFeeDeductionUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatIsNull() {
            addCriterion("additional_fee_vat is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatIsNotNull() {
            addCriterion("additional_fee_vat is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatEqualTo(BigDecimal value) {
            addCriterion("additional_fee_vat =", value, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatNotEqualTo(BigDecimal value) {
            addCriterion("additional_fee_vat <>", value, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatGreaterThan(BigDecimal value) {
            addCriterion("additional_fee_vat >", value, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_vat >=", value, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatLessThan(BigDecimal value) {
            addCriterion("additional_fee_vat <", value, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_fee_vat <=", value, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatIn(List<BigDecimal> values) {
            addCriterion("additional_fee_vat in", values, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatNotIn(List<BigDecimal> values) {
            addCriterion("additional_fee_vat not in", values, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_vat between", value1, value2, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeVatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_fee_vat not between", value1, value2, "additionalFeeVat");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateIsNull() {
            addCriterion("additional_fee_start_date is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateIsNotNull() {
            addCriterion("additional_fee_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateEqualTo(Date value) {
            addCriterion("additional_fee_start_date =", value, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateNotEqualTo(Date value) {
            addCriterion("additional_fee_start_date <>", value, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateGreaterThan(Date value) {
            addCriterion("additional_fee_start_date >", value, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("additional_fee_start_date >=", value, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateLessThan(Date value) {
            addCriterion("additional_fee_start_date <", value, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateLessThanOrEqualTo(Date value) {
            addCriterion("additional_fee_start_date <=", value, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateIn(List<Date> values) {
            addCriterion("additional_fee_start_date in", values, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateNotIn(List<Date> values) {
            addCriterion("additional_fee_start_date not in", values, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateBetween(Date value1, Date value2) {
            addCriterion("additional_fee_start_date between", value1, value2, "additionalFeeStartDate");
            return (Criteria) this;
        }

        public Criteria andAdditionalFeeStartDateNotBetween(Date value1, Date value2) {
            addCriterion("additional_fee_start_date not between", value1, value2, "additionalFeeStartDate");
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