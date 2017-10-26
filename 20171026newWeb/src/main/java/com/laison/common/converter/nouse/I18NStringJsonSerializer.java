package com.laison.common.converter.nouse;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.laison.common.utils.I18NResourceBundleUtils;
import com.laison.common.utils.StringUtils;

public class I18NStringJsonSerializer extends JsonSerializer<Object>{
	 @Override  
     public void serialize( Object value,   JsonGenerator jg,  SerializerProvider sp) throws IOException, JsonProcessingException  
     { 
		 if(value!=null) {
			 if(value instanceof String){
					String text = I18NResourceBundleUtils.getLocalizedText((String)value);
					if(text!=null&&StringUtils.isNotBlank(text)) {
						value=text;
					}
					
			}
		 }
     	
     	jg.writeObject(value);
     }  
}
