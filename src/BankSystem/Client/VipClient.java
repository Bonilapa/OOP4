package BankSystem.Client;

public class VipClient extends Client implements IMakeClientVip{

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
