package module5stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Животное: " + name;
    }

    public static void serializable(List<Animal> animals, String fileNAme) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileNAme))) {
            objectOutputStream.writeObject(animals);
            System.out.println("Serialize completed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Animal[] deserialieAnimalArray(byte[] data) {
        int coutAnimal = 0;
        Animal[] animals = new Animal[0];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            coutAnimal = objectInputStream.readInt();
            animals = new Animal[coutAnimal];
            for (int i = 0; i < animals.length; i++) {
                Animal animal = (Animal) objectInputStream.readObject();
                animals[i] = animal;
            }
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }
        return animals;
//        int countOfAnimals = 0;
//        Animal[] animals = new Animal[0];
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
//        try(ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
//            countOfAnimals = objectInputStream.readInt();
//            animals = new Animal[countOfAnimals];
//            for (int i = 0; i < countOfAnimals; i++) {
//                Animal a = (Animal) objectInputStream.readObject();
//                animals[i] = a;
//            }
//
//        } catch (Exception e) {
//            throw new java.lang.IllegalArgumentException();
//        }
//
//        return animals;
    }

    public static List<Animal> deserialieAnimalArray(String fileName) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            animals = (List<Animal>) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }
}
