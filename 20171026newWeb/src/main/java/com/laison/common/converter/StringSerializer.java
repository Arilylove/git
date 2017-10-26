package com.laison.common.converter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.laison.common.utils.I18NResourceBundleUtils;
import com.laison.common.utils.StringUtils;
public class StringSerializer extends StdSerializer<String> {
     
    public StringSerializer() {
        this(null);
    }
   
    public StringSerializer(Class<String> t) {
        super(t);
    }
 
    

    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonGenerationException {
        
       if(value!=null && value instanceof String) {
    	   value = I18NResourceBundleUtils.getLocalizedText((String)value);   
       }      
       jgen.writeString(value);
    }
}