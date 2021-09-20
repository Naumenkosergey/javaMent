package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    public static void main(String[] args) throws IOException, CalculateException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        CalculateManager calculateManager = new CalculateManager();
        try {
            if (splitLine.length > 3)
                throw new CalculateException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+,-,/,*)");
            else if (splitLine.length < 3)
                throw new CalculateException("//т.к. строка не является математической операцией");
            else
                System.out.println(calculateManager.checkOperation(splitLine));
        } catch (CalculateException ex) {
            System.err.println(ex);
        }

    }
}
