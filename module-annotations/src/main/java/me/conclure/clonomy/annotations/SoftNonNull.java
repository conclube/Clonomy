package me.conclure.clonomy.annotations;

import java.lang.annotation.*;

@Target({
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE_USE,
        ElementType.METHOD,
        ElementType.CONSTRUCTOR,
})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SoftNonNull.Repeat.class)
public @interface SoftNonNull {

    @Target({
            ElementType.TYPE,
            ElementType.ANNOTATION_TYPE,
            ElementType.TYPE_PARAMETER,
            ElementType.TYPE_USE,
            ElementType.METHOD,
            ElementType.CONSTRUCTOR,
    })
    @Retention(RetentionPolicy.RUNTIME)
    @interface Repeat {
        SoftNonNull[] value();
    }
}
