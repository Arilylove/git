package com.laison.common.shiro;



import org.apache.shiro.authc.UsernamePasswordToken;


public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {  
    //验证码字符串  
    private String captcha;  
    private String loginFor;  
    public CaptchaUsernamePasswordToken(String username, char[] password,  
            boolean rememberMe, String host, String captcha) {  
        super(username, password, rememberMe, host);  
        this.captcha = captcha;  
    }  
  
    public String getCaptcha() {  
        return captcha;  
    }  
  
    public void setCaptcha(String captcha) {  
        this.captcha = captcha;  
    }

	public String getLoginFor() {
		return loginFor;
	}

	public void setLoginFor(String loginFor) {
		this.loginFor = loginFor;
	}  
	
}  