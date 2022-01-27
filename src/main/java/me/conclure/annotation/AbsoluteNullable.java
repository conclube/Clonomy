package me.conclure.annotation;

/**
 * Used to denote a nullable types.
 *
 * When used in inheritable scenarios the implementer must NOT
 * break the contract in derivatives.
 * The example below does NOT follow the contract:
 *
 * <pre> {@code
 * class SuperClass {
 *   String convertToString(@AbsoluteNullable Object o) {
 *       return o == null ? "null" : o.toString();
 *   }
 * }
 *
 * class SubClass extends SuperClass {
 *   String convertToString(Object o) {
 *       if (o == null) {
 *         throw new NullPointerException();
 *       }
 *       return o.toString();
 *   }
 * }
 * }</pre>
 */
public @interface AbsoluteNullable {
}
