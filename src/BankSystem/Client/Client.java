package BankSystem.Client;
import BankSystem.Account;
import BankSystem.Bank;
import java.util.ArrayList;
import java.util.List;

/*
 * Class describes a bank
 * clients behavior
 */
public class Client {

    /*
     * Field to store a name
     * of a certain client
     */
    protected String name;

    /*
     * Field to store a birth date
     * of a certain client
     */
    protected  String birthday;

    /*
     * Field to store a gender
     * of a certain client
     */
    protected String gender;

    /*
     * Field to store a bank
     * that certain client
     * belongs to
     */
    protected Bank Bank;

    /*
     * A list of accounts of a certain client
     */
    protected List<Account> accounts;

    /*
     * name getter
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
     * birthday getter
     */
    public String getBirthday() {
        return birthday;
    }

    /*
     * birthday setter
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /*
     * gender getter
     */
    public String getGender() {
        return gender;
    }

    /*
     * gender setter
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /*
     * Bank getter
     */
    public Bank getBank() {
        return Bank;
    }

    /*
     * Bank setter
     */
    public void setBank(Bank Bank) {
        this.Bank = Bank;
    }

    /*
     * List of accounts getter
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /*
     * List of accounts setter
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /*
     * Default client constructor
     * initializes an accounts list
     */
    public Client(){
        this.accounts = new ArrayList<>();
    }

    /*
     * Method creates a new account
     * for this client
     */
    public Account CreateAccount(String type){
        Account account = new Account(this, type);
        accounts.add(account);

        return  account;
    }
}
