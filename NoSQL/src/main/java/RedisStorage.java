import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.client.protocol.ScoredEntry;
import org.redisson.config.Config;

import java.util.Collection;
import java.util.Date;

import static java.lang.System.out;

public class RedisStorage {

    private RedissonClient redisson;

    private RKeys rKeys;

    private RScoredSortedSet<String> onlineUsers;

    private final static String KEY = "ONLINE_USERS";

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void activationUser (int user_id) {
        onlineUsers.add(getTs(), String.valueOf(user_id));
    }

    Collection<ScoredEntry<String>> users() {
        return onlineUsers.entryRange(0, 19);
    }

    String user(int user_id) {
        Collection<String> user = onlineUsers.valueRange(user_id, user_id);
        String userName = "";
        for (String name : user) {
            userName = name;
        }
        return userName;
    }
}
