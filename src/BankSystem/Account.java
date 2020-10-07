package BankSystem;
import BankSystem.Client.Client;
import BankSystem.Client.VipClient;

/*
 * Class for account behavior
 */
public class Account {

    /*
     * Field to store a logger of this account
     */
    protected Logger logger;

    /*
     * Field to store an ID of this account
     */
    protected String accountId;

    /*
     * Field to store amount of money on this account
     */
    protected double balance;

    /*
     * Field to store a type of the account
     * There can be several types with
     * different purposes and behavior
     */
    protected String accountType;

    /*
     * Field to store an owner of the account
     */
    protected Client accountClient;

    /*
     * Field to store a common ID counter
     * for all the accounts
     */
    private static int lastId = 0;

    /*
     * logger getter
     */
    public Logger getLogger() {
        return logger;
    }

    /*
     * logger setter
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /*
     * accountId getter
     */
    public String getAccountId() {
        return accountId;
    }

    /*
     * accountId setter
     */
    public void setAccointId(String accountId) {
        this.accountId = accountId;
    }

    /*
     * balance getter
     */
    public double getBalance() {
        return balance;
    }

    /*
     * balance setter
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
     * account type getter
     */
    public String getAccountType() {
        return accountType;
    }

    /*
     * account type setter
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /*
     * accountClient getter
     */
    public Client getAccountClient() {
        return accountClient;
    }

    /*
     * accountClient setter
     */
    public void setAccountClient(Client accountClient) {
        this.accountClient = accountClient;
    }

    /*
     * lastId getter
     */
    public static int getLastId() {
        return lastId;
    }

    /*
     * lastId setter
     */
    public static void setLastId(int lastId) {
        Account.lastId = lastId;
    }

    /*
     * Account constructor
     */
    public Account(Client client, String type){
        Account.lastId++;
        accountType = type;
        accountId = new Integer(Account.lastId).toString();
        accountClient = client;
        logger = new EventLogger();
    }

    /*
     * Method to deposit money
     * on the account balance
     */
    public void Deposit(double money){
        balance += money;
        this.logger.Log("Deposit");
    }

    /*
     * Method to withdraw a money
     * from the account
     */
    public boolean Withdraw(double money){
        if (accountType == "credit"){
            balance -= money;
            this.logger.Log("Withdraw");
            return true;
        }

        if (balance >= money){
            balance -= money;
            this.logger.Log("Withdraw");
            return true;
        }

        return false;
    }

    /*
     * Method to transfer money from
     * one account to another
     */
    public void Transfer(Account account, double money) {

        if (accountType == "business") {
            if (accountClient instanceof VipClient) {
                if (this.Withdraw(money)) {
                    account.Deposit(money);
                    logger.Log("Transfer");
                }
                return;
            } else {
                if (this.Withdraw(money * 1.02)) {
                    account.Deposit(money);
                    logger.Log("Transfer");
                }
            }

            return;
        }

        if (this.Withdraw(money)) {
            account.Deposit(money);
            logger.Log("Transfer");
        }
    }

}
