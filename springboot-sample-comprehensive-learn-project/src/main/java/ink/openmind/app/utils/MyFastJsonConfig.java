package ink.openmind.app.utils;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;

import java.nio.charset.Charset;

/**
 * @Description: 配置fastjson的HttpMessageConverter
 * @Author: Wangzz
 * @Version: 1.0.0
 * @CreateDate: Created in 2021/9/28 22:21
 * @UpdateDate: [dateFormat:YYYY-MM-DD][modifier][description]
 */

public class MyFastJsonConfig {
    /**
     * 自定义MyFastJsonConfig, 完成对FastJsonHttpMessageConverterBean的提供
     * 设置JSON在进行解析的时候解析的规则
     * eg: 日期格式、数据编码、是否在生成的JSOn中输出类名、是否输出value为null的数据、生成的JSON格式化
     * 空集合输出[]为非null、空字符串输出""而非null等基本配置
     *
     * MyFastConfig配置完成后，还需要而配置以下响应编码，否则返回的JSON中文会乱码，在application.properties中添加如下:
     * spring.http.encoding.force-response=true
     * */
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
            FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
            FastJsonConfig config = new FastJsonConfig();
            config.setDateFormat("yyyy-MM-dd HH:mm:SS");
            config.setCharset(Charset.forName("UTF-8"));
            config.setSerializerFeatures(
                    SerializerFeature.WriteClassName,
                    SerializerFeature.WriteMapNullValue,
                    SerializerFeature.PrettyFormat,
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullListAsEmpty
            );
            converter.setFastJsonConfig(config);
            return converter;
    }


}
