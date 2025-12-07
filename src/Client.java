public class Client implements Comparator<Client>{
    private Person person;
    private Account account;
    private int bankID;


    public Client(Person person, Account account, int bankID) {
        this.person = person;
        this.account = account;
        this.bankID = bankID;
    }
    public void setAccount(){
        this.account = account;
    }
    public void deposit(double amount){
        account.deposit(amount);
    }
    public void cashOut(double amount){
        account.cashOut(amount);
    }

    public Person getPerson() {
        return person;
    }

    public Account getAccount() {
        return account;
    }

    public int getBankID() {
        return bankID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "person=" + person +
                ", account=" + account +
                ", bankID=" + bankID +
                '}';
    }

    @Override
    public int compare(Client d) {
        if(this.bankID < d.bankID)
            return -1;
        else if (this.bankID == d.bankID)
            return 0;
        else
            return 1;
    }
    public String toTxt() {
        String txt = person.toTxt() + "\n";
        txt += account.toTxt() + "\n";
        txt += bankID + "\n";
        return txt;
    }
    public static Client fromTxt(String txt) {
        String[] lines = txt.split("\n");
        Person person = Person.fromTxt(lines[0]);
        Account account = Account.fromTxt(lines[1]);
        int bankID = Integer.parseInt(lines[2]);
        return new Client(person, account, bankID);
    }
}
