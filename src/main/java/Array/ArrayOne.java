package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOne extends ArrayMain {

    private String name;
    private int number;

    //Инициализация конструктора
    public ArrayOne() {
        super();

        String classInfo = getClass().getName();
        System.out.printf("Новый пустой экземпляр класса <%s>\n", classInfo);
    }

    public ArrayOne(String name, int number) {
        super(name);
        this.name = name;
        this.number = number;
    }

    //Инициализация строкового массива
    public String[] stringArray = {"Toyota", "BMW", "Audi", "Ford", "Mercedes", "Renault"};

    public List<String> returnArray(String[] someArray) {
        List<String> innerArray = Arrays.asList(someArray);
        List<String> resultArray = new ArrayList<>();
        int iterator = 0;

        while (!(iterator == 4)) {
            resultArray.add(innerArray.get(iterator));
            iterator++;
        }
        return resultArray;
    }
}
