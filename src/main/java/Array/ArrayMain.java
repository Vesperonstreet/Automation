package Array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMain {

    protected Logger log;
    protected String name;

    public ArrayMain() {
        this.log = LogManager.getLogger(Application.class);
    }

    public ArrayMain(String name) {
        this.log = LogManager.getLogger(Application.class);
        this.name = name;
    }

    public void getName() {
        System.out.println("\n" + name + ": Выведен текст");
    }

    public void splitList(List<String> list) {
        ArrayList<String> myList = (ArrayList<String>) list;

        for (String symbol : myList) {
            try {
                if (symbol == null) {
                    throw new NullPointerException("It is custom null point exception");
                } else {
                    System.out.println(Arrays.toString(symbol.split("()")));
                }
            } catch (NullPointerException e) {
                log.error("Массив не определён. " +
                        "Пожалуйста проверьте корректность вводимых значений");
            } catch (Exception e) {
                log.debug("Произошла неизвестная ошибка. Подробнее: <содержимое ошибки>");
                System.out.println(e.getCause().toString());
            }
        }
    }
}