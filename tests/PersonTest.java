import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testPersonToString() {
        Person p = new Person("John", "Doe", 1990, new Adress("Main St", 123, "Anytown", 78787));
        String expected = "Person{name='John', surname='Doe', yearOfBirth=1990, adress=Adress{street='Main St', numberOfDesc=123, town='Anytown', postCode=78787}}";
        assertEquals(expected, p.toString());
    }

    @Test
    public void testPersonFromTxt() {
        String line = "John;Doe;1990;Main St,123,Anytown,78787";
        Person p = Person.fromTxt(line);
        assertEquals("John", p.getName());
        assertEquals("Doe", p.getSurname());
        assertEquals(1990, p.getYearOfBirth());
        Adress expected = new Adress("Main St", 123, "Anytown", 78787);
        assertEquals(expected, p.getAdress());
    }

    @Test
    public void testPersonToTxt() {
        Person p = new Person("John", "Doe", 1990, new Adress("Main St", 123, "Anytown", 78787));
        String expected = "John;Doe;1990;Main St,123,Anytown,78787";
        assertEquals(expected, p.toTxt());
    }

    @Test(expected = NullPointerException.class)
    public void testPersonConstructorNullName() {
        Person p = new Person(null, "Doe", 1990, new Adress("Main St", 123, "Anytown", 78787));
    }

    @Test(expected = NullPointerException.class)
    public void testPersonConstructorNullSurname() {
        Person p = new Person("John", null, 1990, new Adress("Main St", 123, "Anytown", 78787));
    }

}