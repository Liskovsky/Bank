public class Account implements Comparator<Account>{
    private long accountID;
    private double balance;
    private Card card;

    public Account(){
        this(0, 0.0, new Card());
    }
    public Account(long accountID, double balance, Card card) {
        this.accountID = accountID;
        this.balance = balance;
        this.card = new Card(card);
    }

    public void setCard(Card crd){
        card.setCard(crd);
    }
    public void deposit(double amount){
        balance =+ amount;
    }
    public double cashOut(double amount){
        balance =- amount;
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", balance=" + balance +
                ", card=" + card +
                '}';
    }

    @Override
    public int compare(Account d) {
        if(this.accountID < d.accountID)
                return -1;
        else if (this.accountID == d.accountID)
            return 0;
        else
            return 1;
    }

    public static Account fromTxt(String line) {
        String[] parts = line.split(",");
        long accountID = Long.parseLong(parts[0]);
        double balance = Double.parseDouble(parts[1]);
        Card card = Card.fromTxt(parts[2]);
        return new Account(accountID, balance, card);
    }

    public String toTxt() {
        return (accountID + "," + balance + "," + card.toTxt());
    }
}
