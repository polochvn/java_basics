import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Account> accounts = new HashMap<String, Account>();
        for (int i = 100000; i < 1000000; i++) {
            long money = (long) (Math.random() * 900000) + 100000;
            accounts.put(String.valueOf(i),
                    new Account(money, String.valueOf(i), true));
        }

        Bank bank = new Bank(accounts);

        for (int i = 0; i < 3; i++) {

            long n = (long) (Math.random() * 900000) + 100000;
            String numN = String.valueOf(n);
            long j = (long) (Math.random() * 900000) + 100000;
            String numJ = String.valueOf(j);
            long amount = (long) (Math.random() * 159000) + 1000;
            System.out.println(amount);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("Деньги " + accounts.get(numN).getAccNumber() +
                                " до перевода - " + bank.getBalance(accounts.get(numN).getAccNumber()));
                        System.out.println("Деньги " + accounts.get(numJ).getAccNumber() +
                                " до перевода - " + bank.getBalance(accounts.get(numJ).getAccNumber()));

                        bank.transfer(accounts.get(numN).getAccNumber(),
                                accounts.get(numJ).getAccNumber(), amount);

                        System.out.println("Деньги " + accounts.get(numN).getAccNumber() +
                                " после перевода - " + bank.getBalance(accounts.get(numN).getAccNumber()));
                        System.out.println("Деньги " + accounts.get(numJ).getAccNumber() +
                                " после перевода - " + bank.getBalance(accounts.get(numJ).getAccNumber()));

                    }
                });
                thread.start();
            }
        }
    }