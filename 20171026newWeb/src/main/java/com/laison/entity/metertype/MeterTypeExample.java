package com.laison.entity.metertype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeterTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeterTypeExample() {
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

        public Criteria andMeterTypeNameIsNull() {
            addCriterion("meter_type_name is null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameIsNotNull() {
            addCriterion("meter_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameEqualTo(String value) {
            addCriterion("meter_type_name =", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotEqualTo(String value) {
            addCriterion("meter_type_name <>", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameGreaterThan(String value) {
            addCriterion("meter_type_name >", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("meter_type_name >=", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameLessThan(String value) {
            addCriterion("meter_type_name <", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameLessThanOrEqualTo(String value) {
            addCriterion("meter_type_name <=", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameLike(String value) {
            addCriterion("meter_type_name like", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotLike(String value) {
            addCriterion("meter_type_name not like", value, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameIn(List<String> values) {
            addCriterion("meter_type_name in", values, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotIn(List<String> values) {
            addCriterion("meter_type_name not in", values, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameBetween(String value1, String value2) {
            addCriterion("meter_type_name between", value1, value2, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeterTypeNameNotBetween(String value1, String value2) {
            addCriterion("meter_type_name not between", value1, value2, "meterTypeName");
            return (Criteria) this;
        }

        public Criteria andMeasureModeIsNull() {
            addCriterion("measure_mode is null");
            return (Criteria) this;
        }

        public Criteria andMeasureModeIsNotNull() {
            addCriterion("measure_mode is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureModeEqualTo(Integer value) {
            addCriterion("measure_mode =", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotEqualTo(Integer value) {
            addCriterion("measure_mode <>", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeGreaterThan(Integer value) {
            addCriterion("measure_mode >", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("measure_mode >=", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeLessThan(Integer value) {
            addCriterion("measure_mode <", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeLessThanOrEqualTo(Integer value) {
            addCriterion("measure_mode <=", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeIn(List<Integer> values) {
            addCriterion("measure_mode in", values, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotIn(List<Integer> values) {
            addCriterion("measure_mode not in", values, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeBetween(Integer value1, Integer value2) {
            addCriterion("measure_mode between", value1, value2, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotBetween(Integer value1, Integer value2) {
            addCriterion("measure_mode not between", value1, value2, "measureMode");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesIsNull() {
            addCriterion("pulse_decimal_places is null");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesIsNotNull() {
            addCriterion("pulse_decimal_places is not null");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesEqualTo(Integer value) {
            addCriterion("pulse_decimal_places =", value, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesNotEqualTo(Integer value) {
            addCriterion("pulse_decimal_places <>", value, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesGreaterThan(Integer value) {
            addCriterion("pulse_decimal_places >", value, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesGreaterThanOrEqualTo(Integer value) {
            addCriterion("pulse_decimal_places >=", value, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesLessThan(Integer value) {
            addCriterion("pulse_decimal_places <", value, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesLessThanOrEqualTo(Integer value) {
            addCriterion("pulse_decimal_places <=", value, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesIn(List<Integer> values) {
            addCriterion("pulse_decimal_places in", values, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesNotIn(List<Integer> values) {
            addCriterion("pulse_decimal_places not in", values, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesBetween(Integer value1, Integer value2) {
            addCriterion("pulse_decimal_places between", value1, value2, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPulseDecimalPlacesNotBetween(Integer value1, Integer value2) {
            addCriterion("pulse_decimal_places not between", value1, value2, "pulseDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesIsNull() {
            addCriterion("price_decimal_places is null");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesIsNotNull() {
            addCriterion("price_decimal_places is not null");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesEqualTo(Integer value) {
            addCriterion("price_decimal_places =", value, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesNotEqualTo(Integer value) {
            addCriterion("price_decimal_places <>", value, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesGreaterThan(Integer value) {
            addCriterion("price_decimal_places >", value, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_decimal_places >=", value, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesLessThan(Integer value) {
            addCriterion("price_decimal_places <", value, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesLessThanOrEqualTo(Integer value) {
            addCriterion("price_decimal_places <=", value, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesIn(List<Integer> values) {
            addCriterion("price_decimal_places in", values, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesNotIn(List<Integer> values) {
            addCriterion("price_decimal_places not in", values, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesBetween(Integer value1, Integer value2) {
            addCriterion("price_decimal_places between", value1, value2, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andPriceDecimalPlacesNotBetween(Integer value1, Integer value2) {
            addCriterion("price_decimal_places not between", value1, value2, "priceDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesIsNull() {
            addCriterion("measure_decimal_places is null");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesIsNotNull() {
            addCriterion("measure_decimal_places is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesEqualTo(Integer value) {
            addCriterion("measure_decimal_places =", value, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesNotEqualTo(Integer value) {
            addCriterion("measure_decimal_places <>", value, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesGreaterThan(Integer value) {
            addCriterion("measure_decimal_places >", value, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesGreaterThanOrEqualTo(Integer value) {
            addCriterion("measure_decimal_places >=", value, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesLessThan(Integer value) {
            addCriterion("measure_decimal_places <", value, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesLessThanOrEqualTo(Integer value) {
            addCriterion("measure_decimal_places <=", value, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesIn(List<Integer> values) {
            addCriterion("measure_decimal_places in", values, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesNotIn(List<Integer> values) {
            addCriterion("measure_decimal_places not in", values, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesBetween(Integer value1, Integer value2) {
            addCriterion("measure_decimal_places between", value1, value2, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andMeasureDecimalPlacesNotBetween(Integer value1, Integer value2) {
            addCriterion("measure_decimal_places not between", value1, value2, "measureDecimalPlaces");
            return (Criteria) this;
        }

        public Criteria andQ3IsNull() {
            addCriterion("q3 is null");
            return (Criteria) this;
        }

        public Criteria andQ3IsNotNull() {
            addCriterion("q3 is not null");
            return (Criteria) this;
        }

        public Criteria andQ3EqualTo(BigDecimal value) {
            addCriterion("q3 =", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotEqualTo(BigDecimal value) {
            addCriterion("q3 <>", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3GreaterThan(BigDecimal value) {
            addCriterion("q3 >", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("q3 >=", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3LessThan(BigDecimal value) {
            addCriterion("q3 <", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("q3 <=", value, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3In(List<BigDecimal> values) {
            addCriterion("q3 in", values, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotIn(List<BigDecimal> values) {
            addCriterion("q3 not in", values, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("q3 between", value1, value2, "q3");
            return (Criteria) this;
        }

        public Criteria andQ3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("q3 not between", value1, value2, "q3");
            return (Criteria) this;
        }

        public Criteria andMediumTypeIsNull() {
            addCriterion("medium_type is null");
            return (Criteria) this;
        }

        public Criteria andMediumTypeIsNotNull() {
            addCriterion("medium_type is not null");
            return (Criteria) this;
        }

        public Criteria andMediumTypeEqualTo(Integer value) {
            addCriterion("medium_type =", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeNotEqualTo(Integer value) {
            addCriterion("medium_type <>", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeGreaterThan(Integer value) {
            addCriterion("medium_type >", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("medium_type >=", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeLessThan(Integer value) {
            addCriterion("medium_type <", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeLessThanOrEqualTo(Integer value) {
            addCriterion("medium_type <=", value, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeIn(List<Integer> values) {
            addCriterion("medium_type in", values, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeNotIn(List<Integer> values) {
            addCriterion("medium_type not in", values, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeBetween(Integer value1, Integer value2) {
            addCriterion("medium_type between", value1, value2, "mediumType");
            return (Criteria) this;
        }

        public Criteria andMediumTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("medium_type not between", value1, value2, "mediumType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeIsNull() {
            addCriterion("communication_type is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeIsNotNull() {
            addCriterion("communication_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeEqualTo(Integer value) {
            addCriterion("communication_type =", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotEqualTo(Integer value) {
            addCriterion("communication_type <>", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeGreaterThan(Integer value) {
            addCriterion("communication_type >", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("communication_type >=", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeLessThan(Integer value) {
            addCriterion("communication_type <", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("communication_type <=", value, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeIn(List<Integer> values) {
            addCriterion("communication_type in", values, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotIn(List<Integer> values) {
            addCriterion("communication_type not in", values, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeBetween(Integer value1, Integer value2) {
            addCriterion("communication_type between", value1, value2, "communicationType");
            return (Criteria) this;
        }

        public Criteria andCommunicationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("communication_type not between", value1, value2, "communicationType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeIsNull() {
            addCriterion("lcd_type is null");
            return (Criteria) this;
        }

        public Criteria andLcdTypeIsNotNull() {
            addCriterion("lcd_type is not null");
            return (Criteria) this;
        }

        public Criteria andLcdTypeEqualTo(Integer value) {
            addCriterion("lcd_type =", value, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeNotEqualTo(Integer value) {
            addCriterion("lcd_type <>", value, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeGreaterThan(Integer value) {
            addCriterion("lcd_type >", value, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lcd_type >=", value, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeLessThan(Integer value) {
            addCriterion("lcd_type <", value, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("lcd_type <=", value, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeIn(List<Integer> values) {
            addCriterion("lcd_type in", values, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeNotIn(List<Integer> values) {
            addCriterion("lcd_type not in", values, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeBetween(Integer value1, Integer value2) {
            addCriterion("lcd_type between", value1, value2, "lcdType");
            return (Criteria) this;
        }

        public Criteria andLcdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("lcd_type not between", value1, value2, "lcdType");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolIsNull() {
            addCriterion("currency_symbol is null");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolIsNotNull() {
            addCriterion("currency_symbol is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolEqualTo(Integer value) {
            addCriterion("currency_symbol =", value, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolNotEqualTo(Integer value) {
            addCriterion("currency_symbol <>", value, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolGreaterThan(Integer value) {
            addCriterion("currency_symbol >", value, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolGreaterThanOrEqualTo(Integer value) {
            addCriterion("currency_symbol >=", value, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolLessThan(Integer value) {
            addCriterion("currency_symbol <", value, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolLessThanOrEqualTo(Integer value) {
            addCriterion("currency_symbol <=", value, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolIn(List<Integer> values) {
            addCriterion("currency_symbol in", values, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolNotIn(List<Integer> values) {
            addCriterion("currency_symbol not in", values, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolBetween(Integer value1, Integer value2) {
            addCriterion("currency_symbol between", value1, value2, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andCurrencySymbolNotBetween(Integer value1, Integer value2) {
            addCriterion("currency_symbol not between", value1, value2, "currencySymbol");
            return (Criteria) this;
        }

        public Criteria andKFlagIsNull() {
            addCriterion("k_flag is null");
            return (Criteria) this;
        }

        public Criteria andKFlagIsNotNull() {
            addCriterion("k_flag is not null");
            return (Criteria) this;
        }

        public Criteria andKFlagEqualTo(Boolean value) {
            addCriterion("k_flag =", value, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagNotEqualTo(Boolean value) {
            addCriterion("k_flag <>", value, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagGreaterThan(Boolean value) {
            addCriterion("k_flag >", value, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("k_flag >=", value, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagLessThan(Boolean value) {
            addCriterion("k_flag <", value, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("k_flag <=", value, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagIn(List<Boolean> values) {
            addCriterion("k_flag in", values, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagNotIn(List<Boolean> values) {
            addCriterion("k_flag not in", values, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("k_flag between", value1, value2, "kFlag");
            return (Criteria) this;
        }

        public Criteria andKFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("k_flag not between", value1, value2, "kFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagIsNull() {
            addCriterion("current_detection_flag is null");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagIsNotNull() {
            addCriterion("current_detection_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagEqualTo(Boolean value) {
            addCriterion("current_detection_flag =", value, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagNotEqualTo(Boolean value) {
            addCriterion("current_detection_flag <>", value, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagGreaterThan(Boolean value) {
            addCriterion("current_detection_flag >", value, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("current_detection_flag >=", value, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagLessThan(Boolean value) {
            addCriterion("current_detection_flag <", value, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("current_detection_flag <=", value, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagIn(List<Boolean> values) {
            addCriterion("current_detection_flag in", values, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagNotIn(List<Boolean> values) {
            addCriterion("current_detection_flag not in", values, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("current_detection_flag between", value1, value2, "currentDetectionFlag");
            return (Criteria) this;
        }

        public Criteria andCurrentDetectionFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("current_detection_flag not between", value1, value2, "currentDetectionFlag");
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