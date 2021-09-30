package module7functionalinterfaces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

/**
 * Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
 * и в конце выводящую 10 наиболее часто встречающихся слов.
 * Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например,
 * в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 * <p>
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 * Выводите слова в нижнем регистре.
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 * <p>
 * Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 * <p>
 * Пример ввода  1:
 * <p>
 * Мама мыла-мыла-мыла раму!
 * Пример вывода  1:
 * <p>
 * мыла
 * мама
 * раму
 * Пример ввода 2:
 * <p>
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus.
 * Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur.
 * Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem.
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
 * <p>
 * Пример вывода 2:
 * consectetur
 * faucibus
 * ipsum
 * lorem
 * adipiscing
 * amet
 * dolor
 * eget
 * elit
 * mi
 * Требования:
 * 1. Должен быть метод public static void main(String[] args)
 * 2. Программа должна читать данные с консоли
 * 2. Программа должна писать данные в консоль
 */
public class PracticalTask7_2_12 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                .map(w -> w.toLowerCase())
                .forEach(w -> {
                    if (map.containsKey(w)) {
                        map.put(w, map.get(w) + 1);
                    } else {
                        map.put(w, 1);
                    }
                });
        map.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue() == e2.getValue()) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
//        map.forEach((s, integer) -> System.out.printf("%s - %d\n", s, integer));
    }
}
