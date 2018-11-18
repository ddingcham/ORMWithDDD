package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableSpringConfigured
@EnableLoadTimeWeaving(aspectjWeaving=AspectJWeaving.AUTODETECT)
public class ApplicationConfiguration {

}