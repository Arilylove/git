package com.laison.common.utils;

import java.util.ResourceBundle;
import com.laison.common.enumerate.Constant;
public class I18NResourceBundleUtils {
	private static final ResourceBundle rb = ResourceBundle.getBundle(Constant.ZH_CN);  
	 public static String getLocalizedText(String text) {  
			if(rb!=null) {
				if(rb.containsKey(text)) {
					 String i18nText = rb.getString(text);  
					  if(i18nText!=null&&StringUtils.isNotBlank(i18nText)) {
						  text=i18nText;
					  }
				}
				 
			}
			return text;
	 }  

}
