package me.conclure.clonomy;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Scheduler;
import org.checkerframework.checker.units.qual.A;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Blah {

    public static void main(String[] args) throws InterruptedException {
        Instant first = Instant.now();
        Cache<Integer,String> cache = Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofSeconds(5))
                .removalListener((key, value, cause) -> {
                    System.out.println("R <%s=%s> %s".formatted(key,value,Duration.between(first,Instant.now())));
                })
                .evictionListener((key, value, cause) -> {
                    System.out.println("E <%s=%s> %s".formatted(key,value,Duration.between(first,Instant.now())));
                })
                .executor(Executors.newCachedThreadPool())
                .scheduler(Scheduler.systemScheduler())
                .build();
        cache.put(1,"hej");
        Thread.sleep(3_000);
        cache.put(1,"hej");
    }
}
