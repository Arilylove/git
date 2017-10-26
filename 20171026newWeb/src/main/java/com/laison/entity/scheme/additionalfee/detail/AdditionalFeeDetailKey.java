package com.laison.entity.scheme.additionalfee.detail;

import javax.validation.constraints.NotNull;

import com.laison.common.validategroup.AddGroup;
import com.laison.common.validategroup.FindGroup;
import com.laison.common.validategroup.UpdateGroup;

public class AdditionalFeeDetailKey {
	@NotNull(groups = {UpdateGroup.class ,FindGroup.class}, message = "{additional.fee.index.null}")
    private Long additionalFeeIndex;
	@NotNull(groups = {UpdateGroup.class ,FindGroup.class}, message = "{additional.fee.scheme.code.null}")
    private Long additionalFeeSchemeCode;

    public Long getAdditionalFeeIndex() {
        return additionalFeeIndex;
    }

    public void setAdditionalFeeIndex(Long additionalFeeIndex) {
        this.additionalFeeIndex = additionalFeeIndex;
    }

    public Long getAdditionalFeeSchemeCode() {
        return additionalFeeSchemeCode;
    }

    public void setAdditionalFeeSchemeCode(Long additionalFeeSchemeCode) {
        this.additionalFeeSchemeCode = additionalFeeSchemeCode;
    }
}