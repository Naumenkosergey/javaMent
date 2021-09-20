package module4exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test, залогируйте им
 два сообщения: первое "Все хорошо" с уровнем INFO и второе "Произошла ошибка" с уровнем WARNING.

java.util.logging.* импортирован за вас*/
public class PracticalTask4_3_6 {


    public static void main(String[] args) {
        logging();
    }

    public static void logging() {
        final Logger LOGGER = Logger.getLogger("com.javamentor.logging.Test");
        //Твой код здесь
        LOGGER.log(Level.INFO, "Все хорошо");
//        LOGGER.info("Все хорошо");
        LOGGER.log(Level.WARNING, "Произошла ошибка");
//        LOGGER.warning("Произошла ошибка");
    }
}

