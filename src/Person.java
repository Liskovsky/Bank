public class Person implements Comparator<Person>{
    private String name;
    private String surname;
    private int yearOfBirth;
    private Adress adress;

    public Person(String name, String surname, int yearOfBirth, Adress adress) {
        if (name == null || surname == null)
            throw new NullPointerException("Name and surname cannot be null");
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.adress = new Adress(adress);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Adress getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", adress=" + adress +
                '}';
    }

    @Override
    public int compare(Person d) {
        int ret = this.surname.compareTo(d.surname);
        if (ret == 0)
            ret = this.name.compareTo(d.name);
        return ret;
    }

    public static Person fromTxt(String line) {
        String[] parts = line.split(";");
        String name = parts[0];
        String surname = parts[1];
        int yearOfBirth = Integer.parseInt(parts[2]);
        Adress address = Adress.fromTxt(parts[3]);
        return new Person(name, surname, yearOfBirth, address);
    }

    public String toTxt() {
        return String.format("%s;%s;%d;%s", name, surname, yearOfBirth, adress.toTxt());
    }

}
