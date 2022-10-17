import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {

            for (Map.Entry<String, Account> entryFrom : accounts.entrySet()) {

                String entryNumFrom = entryFrom.getValue().getAccNumber();

                if (entryNumFrom.equals(fromAccountNum) &&
                        getBalance(fromAccountNum) > amount) {

                    for (Map.Entry<String, Account> entryTo : accounts.entrySet()) {

                        String entryNumTo = entryTo.getValue().getAccNumber();

                        if (entryNumTo.equals(toAccountNum)) {

                        if(amount > 50000 || !entryFrom.getValue().getBlocked()
                                || !entryTo.getValue().getBlocked()) {
                            try {
                                boolean solution = isFraud(fromAccountNum, toAccountNum, amount);
                                if (!solution) {
                                    System.out.println("Транзакция не проходит. Счета заблокированы.");
                                    entryFrom.getValue().setBlocked(false);
                                    entryTo.getValue().setBlocked(false);
                                    return;
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                            entryFrom.getValue().setMoney(getBalance(fromAccountNum) - amount);
                            entryTo.getValue().setMoney(getBalance(toAccountNum) + amount);
                            break;
                        }
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {

        long balance = 0;

        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            String entryNumber = entry.getValue().getAccNumber();
            if (entryNumber.equals(accountNum)) {
                balance = entry.getValue().getMoney();
            }
        }
        return balance;
    }

    public long getSumAllAccounts() {

        long sumAllAcounts = 0;

        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            sumAllAcounts += entry.getValue().getMoney();
        }
        return sumAllAcounts;
    }
}