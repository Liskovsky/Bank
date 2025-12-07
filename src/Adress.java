import java.util.Objects;

public class Adress implements Comparator<Adress>{
    private String street;
    private int numberOfDesc;
    private String town;
    private int postCode;

    public Adress(){
        street = "Not entered";
        numberOfDesc = 0;
        town = "Not entered";
        postCode = 0;
    }
    public Adress(String street, int numberOfDesc, String town, int postCode) {
        this.street = street;
        this.numberOfDesc = numberOfDesc;
        this.town = town;
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }
    public int getNumberOfDesc() {
        return numberOfDesc;
    }
    public String getTown() {
        return town;
    }
    public int getPostCode() {
        return postCode;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumberOfDesc(int numberOfDesc) {
        this.numberOfDesc = numberOfDesc;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
    public Adress(Adress adr){
        this.setStreet(adr.getStreet());
        this.setNumberOfDesc(adr.getNumberOfDesc());
        this.setTown(adr.getTown());
        this.setPostCode(adr.getPostCode());
    }
    public void setAdress(Adress adr){
        this.setStreet(adr.getStreet());
        this.setNumberOfDesc(adr.getNumberOfDesc());
        this.setTown(adr.getTown());
        this.setPostCode(adr.getPostCode());
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", numberOfDesc=" + numberOfDesc +
                ", town='" + town + '\'' +
                ", postCode=" + postCode +
                '}';
    }

    @Override
    public int compare(Adress d) {
        int ret = this.town.compareTo(d.town);
        if (ret == 0)
            ret = this.street.compareTo(d.street);
        return ret;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Adress adress = (Adress) obj;
        return numberOfDesc == adress.numberOfDesc && postCode == adress.postCode
                && Objects.equals(street, adress.street) && Objects.equals(town, adress.town);
    }

    public static Adress fromTxt(String part) {
        String[] parts = part.split(",");
        String street = parts[0];
        int numberOfDesc = Integer.parseInt(parts[1]);
        String town = parts[2];
        int postCode = Integer.parseInt(parts[3]);
        return new Adress(street, numberOfDesc, town, postCode);
    }

    public String toTxt() {
        return street + "," + numberOfDesc + "," + town + "," + postCode;
    }
}
