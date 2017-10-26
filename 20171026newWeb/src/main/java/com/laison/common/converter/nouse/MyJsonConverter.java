package com.laison.common.converter.nouse;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.laison.common.utils.I18NResourceBundleUtils;
import com.laison.common.utils.StringUtils;

public class MyJsonConverter extends MappingJackson2HttpMessageConverter {

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		return super.readInternal(clazz, inputMessage);
	}
	@Override  
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {  
        if (o!=null&&o instanceof String) {  
        	
				String text = I18NResourceBundleUtils.getLocalizedText((String)o);
				if(text!=null&&StringUtils.isNotBlank(text)) {
					o=text;
				}
				
		}
       
        super.writeInternal(o, outputMessage);  
    }  

}
