package com.laison.common.converter.nouse;

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

public class MapSerializer extends StdSerializer<Map> {
     
    public MapSerializer() {
        this(null);
    }
   
    public MapSerializer(Class<Map> t) {
        super(t);
    }
 
    

	@Override
	public void serialize(Map value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonGenerationException {
		
		Set<Entry> entrySet = value.entrySet();
		for (Entry entry : entrySet) {
			if(entry.getValue() instanceof String) {
				String text = I18NResourceBundleUtils.getLocalizedText((String)entry.getValue());
				if(text!=null&&StringUtils.isNotBlank(text)) {
					jgen.writeStringField((String) entry.getKey(), text);	
				}
			}else {
				jgen.writeObject(entry);
			}
		}
		
	}
}