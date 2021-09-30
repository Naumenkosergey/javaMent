package module6generics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class PrakticalTask6_2_15 {

    public static void main(String[] args) throws FileNotFoundException {

        Reader reader = new FileReader("src/module6generics/reader.txt");
        Map<String, Long> map = getSalesMap(reader);
        for (Map.Entry pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }


    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> map = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] splitLine = s.split("\\s+");
//            if (!map.containsKey(splitLine[0])) {
//                map.put(splitLine[0], Long.parseLong(splitLine[1]));
//            } else {
////
//                map.put(splitLine[0], map.get(splitLine[0])+Long.parseLong(splitLine[1]));
//            }
//            BiFunction<? super Long, ? super Long, Long> amount = (oldValue, addValue) -> oldValue + addValue ;
            map.merge(splitLine[0], Long.parseLong(splitLine[1]), (oldValue, addValue) -> oldValue + addValue);
        }
        return map;
    }
}
