package com.laison.common.converter.nouse;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class MyBeanSerializerModifier extends BeanSerializerModifier {
	 private JsonSerializer<Object> _ArrayJsonSerializer = new MyArrayJsonSerializer();
	 private JsonSerializer<Object> _serializer =	new I18NStringJsonSerializer();
	    @Override
	    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
	        // 循环所有的beanPropertyWriter
	        for (int i = 0; i < beanProperties.size(); i++) {
	            BeanPropertyWriter writer = beanProperties.get(i);
	            // 判断字段的类型，如果是array，list，set则注册nullSerializer
	            if (isArrayType(writer)) {
	                 //给writer注册一个自己的nullSerializer
	                writer.assignNullSerializer(this.defaultArrayJsonSerializer());
	            }
	            if (isStringType(writer)) {
	                 //给writer注册一个自己的nullSerializer
	                writer.assignSerializer(this.defaultSerializer());
	            }
	        }
	        return beanProperties;
	    }

	    // 判断是什么类型
	    protected boolean isArrayType(BeanPropertyWriter writer) {
	        Class<?> clazz = writer.getPropertyType();
	        return clazz.isArray() || clazz.equals(List.class) || clazz.equals(Set.class);

	    }
	    protected boolean isStringType(BeanPropertyWriter writer) {
	        Class<?> clazz = writer.getPropertyType();
	        return clazz.equals(String.class);
	    }

	    protected JsonSerializer<Object> defaultArrayJsonSerializer() {
	        return _ArrayJsonSerializer;
	    }
	    protected JsonSerializer<Object> defaultSerializer() {
	        return _serializer;
	    }

}
