package me.conclure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * Used to denote a nullable types.
 *
 * When used in inheritable scenarios the implementer is allowed to
 * break the contract in derivatives unlike {@link AbsoluteNullable}.
 *
 * @see Nullable
 * @see NonNull
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Repeatable(Nullables.class)
public @interface Nullable {
}
 