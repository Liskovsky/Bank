public class Card implements Comparator<Card>{
    private long cardID;
    private boolean creditCard;
    private TypeOfCard typeOfCard;

    public Card(){
        cardID = 0;
        creditCard = false;
        typeOfCard = TypeOfCard.BASIC;
    }
    public Card(long cardID, boolean creditCard, TypeOfCard typeOfCard) {
        this.cardID = cardID;
        this.creditCard = creditCard;
        this.typeOfCard = typeOfCard;
    }

    public long getCardID() {
        return cardID;
    }
    public void setCardID(long cardID) {
        this.cardID = cardID;
    }
    public TypeOfCard getTypeOfCard() {
        return typeOfCard;
    }
    public void setTypeOfCard(TypeOfCard typeOfCard) {
        this.typeOfCard = typeOfCard;
    }
    public Card(Card crd){
        this.setCardID(crd.getCardID());
        this.setTypeOfCard(crd.getTypeOfCard());
    }
    public void setCard(Card crd){
        this.setCardID(crd.getCardID());
        this.setTypeOfCard(crd.getTypeOfCard());
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardID=" + cardID +
                ", creditCard=" + creditCard +
                ", typeOfCard=" + typeOfCard +
                '}';
    }

    @Override
    public int compare(Card d) {
        if(this.cardID < d.cardID)
            return -1;
        else if (this.cardID == d.cardID)
            return 0;
        else
            return 1;
    }
    public static Card fromTxt(String part) {
        String[] parts = part.split(";");
        long cardID = Long.parseLong(parts[0]);
        boolean creditCard = Boolean.parseBoolean(parts[1]);
        TypeOfCard typeOfCard = TypeOfCard.valueOf(parts[2]);
        return new Card(cardID, creditCard, typeOfCard);
    }
    public String toTxt() {
        return (cardID + ";" + creditCard + ";" + typeOfCard);
    }

}
