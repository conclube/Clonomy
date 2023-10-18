import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Duration;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Cache<Integer,String> cache = Caffeine.newBuilder()
                .expireAfterAccess(Duration.ofSeconds(2))
                .expireAfterWrite(Duration.ofSeconds(2))
                .removalListener((key, value, cause) -> {
                    System.out.println("<%s=%s>".formatted(key,value));
                })
                .evictionListener((key, value, cause) -> {
                    System.out.println("<%s=%s>".formatted(key,value));
                })
                .build();
        cache.put(1,"hej");
        Thread.sleep(5_000);
        System.out.println(cache.getIfPresent(1));
    }
}
