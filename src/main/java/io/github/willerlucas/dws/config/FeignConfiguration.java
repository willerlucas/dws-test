package io.github.willerlucas.dws.config;

import feign.Contract;
import feign.Logger;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    @Bean
    public OkHttpClient client(){
        return new OkHttpClient();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
