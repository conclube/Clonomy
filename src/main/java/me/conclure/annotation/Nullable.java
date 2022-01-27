package me.conclure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Target({
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE_USE,
        ElementType.METHOD,
        ElementType.CONSTRUCTOR,
})
@Repeatable(Nullable.Repeat.class)
public @interface Nullable {
    @Target({
            ElementType.TYPE,
            ElementType.ANNOTATION_TYPE,
            ElementType.TYPE_PARAMETER,
            ElementType.TYPE_USE,
            ElementType.METHOD,
            ElementType.CONSTRUCTOR,
    })
    @interface Repeat {
        Nullable[] value();
    }
}
