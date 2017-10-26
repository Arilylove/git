package com.laison.entity.customertype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerTypeExample() {
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

        public Criteria andCustomerTypeCodeIsNull() {
            addCriterion("customer_type_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeIsNotNull() {
            addCriterion("customer_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeEqualTo(Long value) {
            addCriterion("customer_type_code =", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeNotEqualTo(Long value) {
            addCriterion("customer_type_code <>", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeGreaterThan(Long value) {
            addCriterion("customer_type_code >", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_type_code >=", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeLessThan(Long value) {
            addCriterion("customer_type_code <", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeLessThanOrEqualTo(Long value) {
            addCriterion("customer_type_code <=", value, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeIn(List<Long> values) {
            addCriterion("customer_type_code in", values, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeNotIn(List<Long> values) {
            addCriterion("customer_type_code not in", values, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeBetween(Long value1, Long value2) {
            addCriterion("customer_type_code between", value1, value2, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeCodeNotBetween(Long value1, Long value2) {
            addCriterion("customer_type_code not between", value1, value2, "customerTypeCode");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameIsNull() {
            addCriterion("customer_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameIsNotNull() {
            addCriterion("customer_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameEqualTo(String value) {
            addCriterion("customer_type_name =", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameNotEqualTo(String value) {
            addCriterion("customer_type_name <>", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameGreaterThan(String value) {
            addCriterion("customer_type_name >", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_type_name >=", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameLessThan(String value) {
            addCriterion("customer_type_name <", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameLessThanOrEqualTo(String value) {
            addCriterion("customer_type_name <=", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameLike(String value) {
            addCriterion("customer_type_name like", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameNotLike(String value) {
            addCriterion("customer_type_name not like", value, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameIn(List<String> values) {
            addCriterion("customer_type_name in", values, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameNotIn(List<String> values) {
            addCriterion("customer_type_name not in", values, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameBetween(String value1, String value2) {
            addCriterion("customer_type_name between", value1, value2, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNameNotBetween(String value1, String value2) {
            addCriterion("customer_type_name not between", value1, value2, "customerTypeName");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeIsNull() {
            addCriterion("meter_type_code is null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeIsNotNull() {
            addCriterion("meter_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeEqualTo(Long value) {
            addCriterion("meter_type_code =", value, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeNotEqualTo(Long value) {
            addCriterion("meter_type_code <>", value, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeGreaterThan(Long value) {
            addCriterion("meter_type_code >", value, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("meter_type_code >=", value, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeLessThan(Long value) {
            addCriterion("meter_type_code <", value, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeLessThanOrEqualTo(Long value) {
            addCriterion("meter_type_code <=", value, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeIn(List<Long> values) {
            addCriterion("meter_type_code in", values, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeNotIn(List<Long> values) {
            addCriterion("meter_type_code not in", values, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeBetween(Long value1, Long value2) {
            addCriterion("meter_type_code between", value1, value2, "meterTypeCode");
            return (Criteria) this;
        }

        public Criteria andMeterTypeCodeNotBetween(Long value1, Long value2) {
            addCriterion("meter_type_code not between", value1, value2, "meterTypeCode");
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

        public Criteria andReservePriceSchemeCodeIsNull() {
            addCriterion("reserve_price_scheme_code is null");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeIsNotNull() {
            addCriterion("reserve_price_scheme_code is not null");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeEqualTo(Long value) {
            addCriterion("reserve_price_scheme_code =", value, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeNotEqualTo(Long value) {
            addCriterion("reserve_price_scheme_code <>", value, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeGreaterThan(Long value) {
            addCriterion("reserve_price_scheme_code >", value, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("reserve_price_scheme_code >=", value, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeLessThan(Long value) {
            addCriterion("reserve_price_scheme_code <", value, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeLessThanOrEqualTo(Long value) {
            addCriterion("reserve_price_scheme_code <=", value, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeIn(List<Long> values) {
            addCriterion("reserve_price_scheme_code in", values, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeNotIn(List<Long> values) {
            addCriterion("reserve_price_scheme_code not in", values, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeBetween(Long value1, Long value2) {
            addCriterion("reserve_price_scheme_code between", value1, value2, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeCodeNotBetween(Long value1, Long value2) {
            addCriterion("reserve_price_scheme_code not between", value1, value2, "reservePriceSchemeCode");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeIsNull() {
            addCriterion("reserve_price_scheme_start_time is null");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeIsNotNull() {
            addCriterion("reserve_price_scheme_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeEqualTo(Date value) {
            addCriterion("reserve_price_scheme_start_time =", value, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeNotEqualTo(Date value) {
            addCriterion("reserve_price_scheme_start_time <>", value, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeGreaterThan(Date value) {
            addCriterion("reserve_price_scheme_start_time >", value, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reserve_price_scheme_start_time >=", value, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeLessThan(Date value) {
            addCriterion("reserve_price_scheme_start_time <", value, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("reserve_price_scheme_start_time <=", value, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeIn(List<Date> values) {
            addCriterion("reserve_price_scheme_start_time in", values, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeNotIn(List<Date> values) {
            addCriterion("reserve_price_scheme_start_time not in", values, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeBetween(Date value1, Date value2) {
            addCriterion("reserve_price_scheme_start_time between", value1, value2, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andReservePriceSchemeStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("reserve_price_scheme_start_time not between", value1, value2, "reservePriceSchemeStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeIsNull() {
            addCriterion("open_account_fee is null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeIsNotNull() {
            addCriterion("open_account_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeEqualTo(BigDecimal value) {
            addCriterion("open_account_fee =", value, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeNotEqualTo(BigDecimal value) {
            addCriterion("open_account_fee <>", value, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeGreaterThan(BigDecimal value) {
            addCriterion("open_account_fee >", value, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("open_account_fee >=", value, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeLessThan(BigDecimal value) {
            addCriterion("open_account_fee <", value, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("open_account_fee <=", value, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeIn(List<BigDecimal> values) {
            addCriterion("open_account_fee in", values, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeNotIn(List<BigDecimal> values) {
            addCriterion("open_account_fee not in", values, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("open_account_fee between", value1, value2, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andOpenAccountFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("open_account_fee not between", value1, value2, "openAccountFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeIsNull() {
            addCriterion("replace_meter_fee is null");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeIsNotNull() {
            addCriterion("replace_meter_fee is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeEqualTo(BigDecimal value) {
            addCriterion("replace_meter_fee =", value, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeNotEqualTo(BigDecimal value) {
            addCriterion("replace_meter_fee <>", value, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeGreaterThan(BigDecimal value) {
            addCriterion("replace_meter_fee >", value, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("replace_meter_fee >=", value, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeLessThan(BigDecimal value) {
            addCriterion("replace_meter_fee <", value, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("replace_meter_fee <=", value, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeIn(List<BigDecimal> values) {
            addCriterion("replace_meter_fee in", values, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeNotIn(List<BigDecimal> values) {
            addCriterion("replace_meter_fee not in", values, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("replace_meter_fee between", value1, value2, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andReplaceMeterFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("replace_meter_fee not between", value1, value2, "replaceMeterFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeIsNull() {
            addCriterion("cancel_purchase_fee is null");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeIsNotNull() {
            addCriterion("cancel_purchase_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeEqualTo(BigDecimal value) {
            addCriterion("cancel_purchase_fee =", value, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeNotEqualTo(BigDecimal value) {
            addCriterion("cancel_purchase_fee <>", value, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeGreaterThan(BigDecimal value) {
            addCriterion("cancel_purchase_fee >", value, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cancel_purchase_fee >=", value, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeLessThan(BigDecimal value) {
            addCriterion("cancel_purchase_fee <", value, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cancel_purchase_fee <=", value, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeIn(List<BigDecimal> values) {
            addCriterion("cancel_purchase_fee in", values, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeNotIn(List<BigDecimal> values) {
            addCriterion("cancel_purchase_fee not in", values, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cancel_purchase_fee between", value1, value2, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andCancelPurchaseFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cancel_purchase_fee not between", value1, value2, "cancelPurchaseFee");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageIsNull() {
            addCriterion("max_normal_water_usage is null");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageIsNotNull() {
            addCriterion("max_normal_water_usage is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageEqualTo(Integer value) {
            addCriterion("max_normal_water_usage =", value, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageNotEqualTo(Integer value) {
            addCriterion("max_normal_water_usage <>", value, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageGreaterThan(Integer value) {
            addCriterion("max_normal_water_usage >", value, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_normal_water_usage >=", value, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageLessThan(Integer value) {
            addCriterion("max_normal_water_usage <", value, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageLessThanOrEqualTo(Integer value) {
            addCriterion("max_normal_water_usage <=", value, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageIn(List<Integer> values) {
            addCriterion("max_normal_water_usage in", values, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageNotIn(List<Integer> values) {
            addCriterion("max_normal_water_usage not in", values, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageBetween(Integer value1, Integer value2) {
            addCriterion("max_normal_water_usage between", value1, value2, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMaxNormalWaterUsageNotBetween(Integer value1, Integer value2) {
            addCriterion("max_normal_water_usage not between", value1, value2, "maxNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageIsNull() {
            addCriterion("min_normal_water_usage is null");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageIsNotNull() {
            addCriterion("min_normal_water_usage is not null");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageEqualTo(Integer value) {
            addCriterion("min_normal_water_usage =", value, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageNotEqualTo(Integer value) {
            addCriterion("min_normal_water_usage <>", value, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageGreaterThan(Integer value) {
            addCriterion("min_normal_water_usage >", value, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_normal_water_usage >=", value, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageLessThan(Integer value) {
            addCriterion("min_normal_water_usage <", value, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageLessThanOrEqualTo(Integer value) {
            addCriterion("min_normal_water_usage <=", value, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageIn(List<Integer> values) {
            addCriterion("min_normal_water_usage in", values, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageNotIn(List<Integer> values) {
            addCriterion("min_normal_water_usage not in", values, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageBetween(Integer value1, Integer value2) {
            addCriterion("min_normal_water_usage between", value1, value2, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andMinNormalWaterUsageNotBetween(Integer value1, Integer value2) {
            addCriterion("min_normal_water_usage not between", value1, value2, "minNormalWaterUsage");
            return (Criteria) this;
        }

        public Criteria andReezeDayIsNull() {
            addCriterion("reeze_day is null");
            return (Criteria) this;
        }

        public Criteria andReezeDayIsNotNull() {
            addCriterion("reeze_day is not null");
            return (Criteria) this;
        }

        public Criteria andReezeDayEqualTo(Integer value) {
            addCriterion("reeze_day =", value, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayNotEqualTo(Integer value) {
            addCriterion("reeze_day <>", value, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayGreaterThan(Integer value) {
            addCriterion("reeze_day >", value, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("reeze_day >=", value, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayLessThan(Integer value) {
            addCriterion("reeze_day <", value, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayLessThanOrEqualTo(Integer value) {
            addCriterion("reeze_day <=", value, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayIn(List<Integer> values) {
            addCriterion("reeze_day in", values, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayNotIn(List<Integer> values) {
            addCriterion("reeze_day not in", values, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayBetween(Integer value1, Integer value2) {
            addCriterion("reeze_day between", value1, value2, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andReezeDayNotBetween(Integer value1, Integer value2) {
            addCriterion("reeze_day not between", value1, value2, "reezeDay");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagIsNull() {
            addCriterion("event_func_flag is null");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagIsNotNull() {
            addCriterion("event_func_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagEqualTo(String value) {
            addCriterion("event_func_flag =", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagNotEqualTo(String value) {
            addCriterion("event_func_flag <>", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagGreaterThan(String value) {
            addCriterion("event_func_flag >", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagGreaterThanOrEqualTo(String value) {
            addCriterion("event_func_flag >=", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagLessThan(String value) {
            addCriterion("event_func_flag <", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagLessThanOrEqualTo(String value) {
            addCriterion("event_func_flag <=", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagLike(String value) {
            addCriterion("event_func_flag like", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagNotLike(String value) {
            addCriterion("event_func_flag not like", value, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagIn(List<String> values) {
            addCriterion("event_func_flag in", values, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagNotIn(List<String> values) {
            addCriterion("event_func_flag not in", values, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagBetween(String value1, String value2) {
            addCriterion("event_func_flag between", value1, value2, "eventFuncFlag");
            return (Criteria) this;
        }

        public Criteria andEventFuncFlagNotBetween(String value1, String value2) {
            addCriterion("event_func_flag not between", value1, value2, "eventFuncFlag");
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