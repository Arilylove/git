package com.laison.entity.scheme.price.detail;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.UpdateGroup;

public class PriceSchemeDetail extends PriceSchemeDetailKey {
	@Range(groups = { AddGroup.class,UpdateGroup.class }, min = 0, max = 999999999, message = "{endValue.range.error}")
	private Integer endValue;
	@Range(groups = { AddGroup.class,UpdateGroup.class }, min = 0, max = 999999999, message = "{startValue.range.error}")
	private Integer startValue;
	@Range(groups = { AddGroup.class,UpdateGroup.class }, min = 0, message = "{price.detail.range.error}")
	@NotNull(groups = { AddGroup.class,UpdateGroup.class }, message = "{price.detail.null}")
	private BigDecimal price;

	public Integer getEndValue() {
		return endValue;
	}

	public void setEndValue(Integer endValue) {
		this.endValue = endValue;
	}

	public Integer getStartValue() {
		return startValue;
	}

	public void setStartValue(Integer startValue) {
		this.startValue = startValue;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}