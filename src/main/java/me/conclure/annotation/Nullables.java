package me.conclure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface Nullables {
    Nullable[] value();
}