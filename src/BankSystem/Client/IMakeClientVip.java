package BankSystem.Client;

/*
 * Interface responsible for
 * contract on transforming
 * a usual client into previleged
 * one.
 */
public interface IMakeClientVip {

    /*
     * Method makes a usual client a
     * privileged one
     */
    void MakeClientVip(Client client);
}
