package module5stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticalTask5_4_7 {

    public static final String FILE_NAME_SERIALIZE = "src\\module5stream\\AnimalSerialize.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Animal cat = new Animal("Кот Барсик");
//        Animal dog = new Animal("Пес Полкан");
//        Animal lion = new Animal("Лев Муфаса");
//        Animal gipo = new Animal("Бегемот Глория");
//
//        List<Animal> animals = new ArrayList<>();
//        List<Animal> animalsNew = new ArrayList<>();
//        animals.add(cat);
//        animals.add(dog);
//        animals.add(lion);
//        animals.add(gipo);
//
//        Animal.serializable(animals, FILE_NAME_SERIALIZE);
        FileInputStream input = new FileInputStream(FILE_NAME_SERIALIZE);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int byteRead;
        while ((byteRead = input.read()) != -1) {
            out.write(byteRead);
        }
        byte data[] = out.toByteArray();
//        System.out.println(Arrays.toString(data));
        Animal[] animals = Animal.deserialieAnimalArray(data);
        printArray(animals);

//        System.out.println(data.length);
//        animalsNew = Animal.deserialieAnimalArray(FILE_NAME_SERIALIZE);
    }

    private static void printArray(Animal[] animals) {
        for (Animal animal : animals)
            System.out.println(animal);
    }
}
