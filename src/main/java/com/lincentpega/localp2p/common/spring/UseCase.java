package com.lincentpega.localp2p.common.spring;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Service
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    @AliasFor(annotation = Component.class)
    String value() default "";
}
