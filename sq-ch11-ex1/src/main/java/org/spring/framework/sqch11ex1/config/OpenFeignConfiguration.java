package org.spring.framework.sqch11ex1.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"org.spring.framework.sqch11ex1.proxies"})
public class OpenFeignConfiguration {
}
