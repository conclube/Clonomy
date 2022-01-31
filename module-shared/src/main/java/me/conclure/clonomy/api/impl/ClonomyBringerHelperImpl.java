package me.conclure.clonomy.api.impl;

import me.conclure.clonomy.api.Clonomy;
import me.conclure.clonomy.api.ClonomyBringer;

import java.lang.invoke.*;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ClonomyBringerHelperImpl implements ClonomyBringerHelper {
    static final Consumer<Clonomy> SET;
    static final Supplier<Optional<Clonomy>> BRING;
    static final Supplier<Optional<Clonomy>> ABORT;

    static {
        CallSite site;
        try {
            MethodHandles.Lookup caller = MethodHandles.publicLookup();
            site = LambdaMetafactory.metafactory(
                    caller,
                    "accept",
                    MethodType.methodType(Consumer.class),
                    MethodType.methodType(void.class,Object.class),
                    caller.findStatic(ClonomyBringer.class,"set",MethodType.methodType(void.class, Clonomy.class)),
                    MethodType.methodType(void.class,Clonomy.class)
            );
            SET = (Consumer<Clonomy>) site.getTarget();
            site = LambdaMetafactory.metafactory(
                    caller,
                    "get",
                    MethodType.methodType(Supplier.class),
                    MethodType.methodType(Object.class),
                    caller.findStatic(ClonomyBringer.class,"bring",MethodType.methodType(Optional.class)),
                    MethodType.methodType(Optional.class)
            );
            BRING = (Supplier<Optional<Clonomy>>) site.getTarget();
            site = LambdaMetafactory.metafactory(
                    caller,
                    "get",
                    MethodType.methodType(Supplier.class),
                    MethodType.methodType(Object.class),
                    caller.findStatic(ClonomyBringer.class,"abort",MethodType.methodType(Optional.class)),
                    MethodType.methodType(Optional.class)
            );
            ABORT = (Supplier<Optional<Clonomy>>) site.getTarget();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public void set(Clonomy clonomy) {
        SET.accept(clonomy);
    }

    @Override
    public Optional<Clonomy> abort() {
        return ABORT.get();
    }

    @Override
    public Optional<Clonomy> bring() {
        return BRING.get();
    }
}
