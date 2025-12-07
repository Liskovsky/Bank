import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListImplement<T extends Comparator<T>> implements List<T>{

    private int count = 0;
    private T[] data;
    private boolean sorted = false;

    public ListImplement() {
        this.data = (T[]) Array.newInstance(Comparator.class, 50);
    }

    @Override
    public void add(T segment) {
        if(count > data.length - 1)
            throw new RuntimeException("List is already full!");
        data[count] = segment;
        count++;
        sorted = false;
    }

    @Override
    public void clear() {
        data = (T[]) new Object[50];
        count = 0;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > data.length - 1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        if(!sorted) sortData();
        return data[index];
    }

    @Override
    public void createPersonFile(Person per) {
        String fileName = per.getName() + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(per.toTxt());
            writer.close();
            System.out.println("File " + fileName + " succesfully created.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the: " + e.getMessage());
        }
    }

    private void sortData() {
        sortArray();
        sorted = true;
    }

    private void sortArray() {
        for (int i = 0; i < count -1; i++) {
            for (int j = i + 1; j < count; j++) {
                if(data[i].compare(data[j]) > 0){
                    T pom = data[i];
                    data[i] = data[j];
                    data[j] = pom;
                }
            }
        }
    }
    public void createPersonsFile(ListImplement<Person> persons) {
        String fileName = "persons.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < persons.getCount(); i++) {
                writer.write(persons.get(i).toTxt() + "\n");
            }
            writer.close();
            System.out.println("File " + fileName + " succesfully created.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the: " + e.getMessage());
        }
    }

    public String toTxt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(data[i].toTxt());
            if (i < count - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
