package com.vonzhou.example;

import com.vonzhou.example.config.YamlConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.Assert;

@SpringBootApplication
public class SpringBootMultiYamlDemoApplication {

    public static void main(String[] args) {
        String[] newArgs = args;
        int newLen = args.length + 1;
        newArgs = new String[newLen];
        System.arraycopy(args, 0, newArgs, 0, newLen - 1);
        // 明确指定YAML配置文件，使用逗号分隔
        String yamlConfigLocations = String.join(",", YamlConfig.getYamlResources().values());
        newArgs[newLen - 1] = String.format("--spring.config.location=%s", yamlConfigLocations);
        // 设置app启动参数
        SpringApplication application = new SpringApplicationBuilder().sources(SpringBootMultiYamlDemoApplication.class)
                        .addCommandLineProperties(true).registerShutdownHook(true).bannerMode(Banner.Mode.OFF).build(args);
        // 是否是web应用
        application.setWebEnvironment(true);
        application.run(newArgs);
    }
}
