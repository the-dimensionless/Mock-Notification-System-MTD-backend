package com.nagarro.nsys.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Configuration class for
 * <p>enabing Aysnchronous thread execution</p>
 * <p>using the ThreadPoolTaskExecutor</p>
 * @author sumitsingh
 *
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {
	
	private final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);

    @Bean (name = "taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        LOGGER.debug("Creating Async Task Executor");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("--- Testing Threads in Spring Boot --- ");
        executor.initialize();
        return executor;
    }
}
