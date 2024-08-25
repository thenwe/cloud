package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pattern")//自动刷新所读取的配置文件
public class PatternProperties {
    private String dateformat;
    private String envSharedValue;

    public String getEnvSharedValue() {
        return envSharedValue;
    }

    public void setEnvSharedValue(String envSharedValue) {
        this.envSharedValue = envSharedValue;
    }

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }
}
