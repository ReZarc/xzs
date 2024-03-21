package com.xzs.exam.configuration.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import com.xzs.exam.configuration.property.WxConfig;
import java.util.List;
/**
 配置SpringBoot程序的类
 *
 */
@ConfigurationProperties(prefix = "system")
public class SystemConfig {

    private PasswordKeyConfig pwdKey;
    private List<String> securityIgnoreUrls;
    private QnConfig qn;
    private WxConfig wx;

    /**
     * @return pwd key
     */
    public PasswordKeyConfig getPwdKey() {
        return pwdKey;
    }

    /**
     * @param pwdKey
     */
    public void setPwdKey(PasswordKeyConfig pwdKey) {
        this.pwdKey = pwdKey;
    }

    /**
     * 返回安全忽略的 url 列表
     * @return security ignore urls
     */
    public List<String> getSecurityIgnoreUrls() {
        return securityIgnoreUrls;
    }

    /**
     * @param securityIgnoreUrls security ignore urls
     */
    public void setSecurityIgnoreUrls(List<String> securityIgnoreUrls) {
        this.securityIgnoreUrls = securityIgnoreUrls;
    }

    /**
     * 七牛云
     * @return qn
     */
    public QnConfig getQn() {
        return qn;
    }

    /**
     * @param qn 七牛云配置
     */
    public void setQn(QnConfig qn) {
        this.qn = qn;
    }

    /**
     * Gets wx.
     *
     * @return the wx
     */
    public WxConfig getWx() {
        return wx;
    }

    /**
     * Sets wx.
     *
     * @param wx the wx
     */
    public void setWx(WxConfig wx) {
        this.wx = wx;
    }
}
