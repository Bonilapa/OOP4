package BankSystem.Client;

import BankSystem.Account;
import BankSystem.Bank;

import java.util.ArrayList;
import java.util.List;

public class Client {

    protected String name;
    protected  String birthday;
    protected String gender;
    protected Bank Bank;
    protected List<Account> accounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Bank getBank() {
        return Bank;
    }

    public void setBank(Bank Bank) {
        this.Bank = Bank;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Client(){
        this.accounts = new ArrayList<>();
    }

    public Account CreateAccount(String type){
        Account account = new Account(this, type);
        accounts.add(account);

        return  account;
    }
}
