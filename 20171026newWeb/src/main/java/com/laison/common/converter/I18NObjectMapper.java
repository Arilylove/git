package com.laison.common.converter;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


public class I18NObjectMapper extends ObjectMapper{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public I18NObjectMapper(){  
       super();  
       this.setSerializationInclusion(Include.NON_NULL); 
      //this.setSerializerFactory(this.getSerializerFactory().withSerializerModifier(new MyBeanSerializerModifier()));
       SimpleModule module = new SimpleModule();
       module.addSerializer(String.class, new StringSerializer());//翻译字符串
       module.addSerializer(Long.class, ToStringSerializer.instance);
       module.addSerializer(Long.TYPE, ToStringSerializer.instance);//解决long精度丢失问题
       this.registerModule(module);
    }  
}
