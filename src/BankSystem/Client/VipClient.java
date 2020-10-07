package BankSystem.Client;

/*
 * Class for privileged clients
 */
public class VipClient extends Client implements IMakeClientVip{

    /*
     * Method makes a usual client a
     * privileged one
     */
    @Override
    public void MakeClientVip(Client client) {

        if (client instanceof VipClient){
            return;
        }

        Client vipClient = new VipClient();
        vipClient.name = client.name;
        vipClient.birthday = client.birthday;
        vipClient.accounts = client.accounts;

        int index = this.Bank.getClients().indexOf(client);
        this.Bank.getClients().set(index,vipClient);
    }
}
