import org.redisson.client.protocol.ScoredEntry;

import java.util.Collection;
import java.util.Random;

import static java.lang.System.out;

public class Main {

    private static final int SLEEP = 1000;

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        String userPay = "";
        redis.init();

        for (int i = 1; i < 21; i++) {
            redis.activationUser(i);
        }

        while (true) {
            Collection<ScoredEntry<String>> users = redis.users();
            Object[] us = users.toArray();

            for (ScoredEntry<String> userName : users) {
                if (userName.getValue().equals(userPay)) {
                    continue;
                }

                if (userName.getValue().equals(String.valueOf(users.size() / 2)) ||
                        userName.getValue().equals(String.valueOf(users.size()))) {
                    int user_id = new Random().nextInt(20);
                    userPay = redis.user(user_id);
                    out.println("Пользователь " + userPay  + " оплатил платную услугу");
                    out.println("Пользователь " + userPay);
                    Thread.sleep(SLEEP);
                }

                out.println("Пользователь " + userName.getValue());
                Thread.sleep(SLEEP);
            }
        }
    }
}