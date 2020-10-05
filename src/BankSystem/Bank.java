package BankSystem;
import BankSystem.Client.Client;
import java.util.ArrayList;
import java.util.List;

/*
 * Class describes a bank
 * behavior
 */
public class Bank {

    protected String name;
    protected int totalAmountOfMoney;
    protected List<Client> Clients;
    protected List<Account> Accounts;

    /*
     * name setter
     */
    public String getName() {
        return name;
    }

    /*
     * name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * totalAmountOfMoney getter
     */
    public int getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }

    /*
     * totalAmountOfMoney setter
     */
    public void setTotalAmountOfMoney(int totalAmountOfMoney) {
        this.totalAmountOfMoney = totalAmountOfMoney;
    }

    /*
     * Clients list getter
     */
    public List<Client> getClients() {
        return Clients;
    }

    /*
     * Clients list setter
     */
    public void setClients(List<Client> clients) {
        Clients = clients;
    }


    /*
     * Accounts list getter
     */
    public List<Account> getAccounts() {
        return Accounts;
    }

    /*
     * Accounts list setter
     */
    public void setAccounts(List<Account> accounts) {
        Accounts = accounts;
    }

    /*
     * Default class constructor.
     * Initializes instance lists
     */
    public Bank (){
        Clients = new ArrayList<>();
        Accounts = new ArrayList<>();
    }

    /*
     * Method removes a certain client
     * from clients list
     */
    public void RemoveClient(Client client){
        Clients.remove(client);
    }

    /*
     * Method creates new account
     * and adds it into account list
     */
    public Account CreateAccount(Client client, String type){
        Account account = new Account(client, type);
        Accounts.add(account);

        return account;
    }

    /*
     * Method creates a new logger
     */
    public Logger CreateLogger(){
        return new EventLogger();
    }

}
