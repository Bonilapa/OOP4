package BankSystem;

import BankSystem.Client.Client;
import BankSystem.Client.VipClient;

public class Account {
    protected Logger logger;
    protected String accountId;
    protected double balance;
    protected String accountType;
    protected Client accountClient;

    private static int lastId = 0;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccointId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Client getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(Client accountClient) {
        this.accountClient = accountClient;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Account.lastId = lastId;
    }

    public Account(Client client, String type){
        Account.lastId++;
        accountType = type;
        accountId = new Integer(Account.lastId).toString();
        accountClient = client;
        logger = new EventLogger();
    }

    public void Deposit(double money){
        balance += money;

        /*
         * not nesessary change, but more conventional
         * to rename the field
         */
        this.logger.Log("Deposit");
    }

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
