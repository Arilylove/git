package com.laison.common.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.laison.common.utils.R;

public abstract class BaseController {
	
	public R hasErrors(BindingResult result) {
		if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            R r = R.error();
            List<String> errorStrings=new ArrayList<String>();
    		for(ObjectError objectError:errors){
				errorStrings.add(objectError.getDefaultMessage());
			}
    		r.put("errors", errorStrings);
    		return r;
        }
		return null;
	}
	

}
