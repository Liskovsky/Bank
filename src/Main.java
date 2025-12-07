import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Adress a1 = new Adress("Lipova", 241, "Prague", 18000);
        Person p1 = new Person("Filip", "Hudec", 1956, a1);
        Client c1 = new Client(p1,new Account(908797526, 0.0,
                new Card(908797526, false,TypeOfCard.BASIC)),1);

        ListImplement<Card> karta = new ListImplement<>();

        karta.add(new Card(89773379,false,TypeOfCard.VIPGOLD));
        karta.add(new Card(11222999,true,TypeOfCard.PREMIUM));
        karta.add(new Card(546435,true,TypeOfCard.BASIC));

        System.out.println(karta.getCount());

        ListImplement<Adress> adresa = new ListImplement<>();

        adresa.add(new Adress("Fialová",123,"Grygov",73514));
        adresa.add(new Adress("Růžová",456,"Hulín",70764));
        adresa.add(new Adress("Hnědá",789,"Přerov",76572));
        adresa.add(new Adress("Bílá",135,"Brodek",88814));
        adresa.add(new Adress("Červená",246,"Hradiště",99914));

        System.out.println(adresa.getCount());

        // ListImplement<Person> per = new ListImplement<>();

        //per.add(new Person("Jan","Horký",1987,a1));
        //per.add(new Person("Karel","Janoseč",1990,adresa.get(3)));
        //per.add(new Person("Zuzana","Lakomá",2000,adresa.get(4)));

        for (int i = 0; i < adresa.getCount(); i++) {
            Adress adr = adresa.get(i);
            System.out.println(adr);
            }
        //for (int i = 0; i < per.getCount(); i++) {
        //    Person pers = per.get(i);
        //    System.out.println(pers);
        //    per.createPersonsFile(per);
        //}

        ListImplement<Person> personal = new ListImplement<>();
        String directory = "C:\\Users\\hp\\IdeaProjects\\Bank\\";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(".txt")) {
                    String filePath = directory + fileName;
                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            Person person = Person.fromTxt(line);
                            personal.add(person);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        for (int i = 0; i < personal.getCount(); i++) {
            Person person = personal.get(i);
            System.out.println(person);
        }
    }
}