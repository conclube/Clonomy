package me.conclure.annotation;

import java.lang.annotation.Annotation;

public @interface NonNulls {
    NonNull[] value();
}
