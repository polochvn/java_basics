import junit.framework.TestCase;
import java.util.HashMap;
import java.util.Map;

public class BankTest extends TestCase {

    Bank bank;
    Account account1;
    Account account2;

    @Override
    protected void setUp() throws Exception {

        account1 = new Account(624534, "8667575", true);
        account2 = new Account(629834, "8668875", true);

        Map<String, Account> accountMap = new HashMap<>();
        accountMap.put("8667575", account1);
        accountMap.put("8668875", account2);

        bank = new Bank(accountMap);

        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 33678);

    }

    public void testGetBalanceAccount1() {

        double actual = bank.getBalance(account1.getAccNumber());
        double expected = 590856;
        assertEquals(expected, actual);
    }

    public void testGetBalanceAccount2() {

        double actual = bank.getBalance(account2.getAccNumber());
        double expected = 663512;
        assertEquals(expected, actual);
    }

    public void testGetSumAllAccounts() {

        double actual = bank.getSumAllAccounts();
        double expected = 1254368;
        assertEquals(expected, actual);
    }
}