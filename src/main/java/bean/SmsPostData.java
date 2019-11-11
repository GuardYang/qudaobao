package bean;

import java.io.Serializable;

/**
 * Package Name: com.feng.sms.sms.bean
 *
 * @author ysr
 * @Email yfeng1023@gmail.com
 * @Description:
 * @Create Date:
 */
public class SmsPostData implements Serializable {
    private String content;
    private String time;
    private String mobile;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
