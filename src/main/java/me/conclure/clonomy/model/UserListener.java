package me.conclure.clonomy.model;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Scheduler;
import me.conclure.clonomy.misc.util.Identifier;
import me.conclure.clonomy.misc.util.UUIDIdentifier;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class UserListener implements Listener {
    private final UserRepository userRepository;
    private final Cache<UUIDIdentifier,User> connectionCache;
    private final Set<User> onlineUsers;

    public UserListener(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.connectionCache = Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofSeconds(20))
                .executor(ForkJoinPool.commonPool())
                .scheduler(Scheduler.systemScheduler())
                .build();
        this.onlineUsers = Collections.newSetFromMap(new IdentityHashMap<>());
    }

    @EventHandler
    public void onConnect(AsyncPlayerPreLoginEvent event) {
        var uniqueId = Identifier.uuid(event.getUniqueId());
        var user = this.userRepository.get(uniqueId);
        //load user data
        this.connectionCache.put(uniqueId,user);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        var uniqueId = Identifier.uuid(event.getPlayer().getUniqueId());
        var user = this.connectionCache.getIfPresent(uniqueId);

        if (user == null) {
            event.disallow(PlayerLoginEvent.Result.KICK_FULL, event.kickMessage());
            return;
        }

        this.onlineUsers.add(user);
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        var uniqueId = Identifier.uuid(event.getPlayer().getUniqueId());
        var user = this.userRepository.get(uniqueId);
        this.onlineUsers.remove(user);
    }

}
