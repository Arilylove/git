package com.laison.common.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import com.laison.common.utils.I18NResourceBundleUtils;

/**
 * 
 * @author lihua
 *
 */
public class CustomException extends Exception {
	
	//默认的messageKey  
    public static final String DEFAULT_MESSAGE_KEY = "unkonwException";  
    //ResourceBundle实例  
    private static final ResourceBundle rb = ResourceBundle.getBundle("en_US");  
    private String messageKey = DEFAULT_MESSAGE_KEY;  
    //用于格式化输出message的数据  
    private Object[] args;  
	private String message;
	private int code = 500;
	public CustomException(String message){
		super(message);
		this.message = message;
	}
	public CustomException(int code,String message){
		super(message);
		this.code=code;
		this.message = message;
	}
	public String getMessage() {

		return I18NResourceBundleUtils.getLocalizedText(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public CustomException(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	@Override  
    public String getLocalizedMessage() {  
		String text = I18NResourceBundleUtils.getLocalizedText(message);  	  
		if (null == text || "".equals(text))
			return rb.getString(DEFAULT_MESSAGE_KEY);
		MessageFormat mf = new MessageFormat(text);
		return mf.format(args);
		
    }  

}
