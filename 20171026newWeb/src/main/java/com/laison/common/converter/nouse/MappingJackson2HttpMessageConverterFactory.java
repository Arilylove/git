package com.laison.common.converter.nouse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

public class MappingJackson2HttpMessageConverterFactory {

    public MappingJackson2HttpMessageConverter init() {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = converter.getObjectMapper();
        // 为mapper注册一个带有SerializerModifier的Factory，此modifier主要做的事情为：当序列化类型为array，list、set时，当值为空时，序列化成[]
        mapper.getSerializerFactory().withSerializerModifier(new  MyBeanSerializerModifier());
        

        converter.setSupportedMediaTypes(ImmutableList.of(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
        return converter;
    }
}


