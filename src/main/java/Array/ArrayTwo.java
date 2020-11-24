package Array;

import java.util.*;

public class ArrayTwo extends ArrayMain {

    private String name;
    private int number;

    //Инициализация строкового массива
    public String[] stringArray = new String[]{"я_Саша", "б_Маша", "ж_Коля", "а_Ваня", "в_Петя"};
    //Преобразование массива строк в список строк
    public List<String> listArray = Arrays.asList(stringArray);

    //Инициализация конструктора
    public ArrayTwo() {
        super("");
        String classInfo = getClass().getName();
        System.out.printf("Новый пустой экземпляр класса <%s>\n", classInfo);
    }

    public ArrayTwo(String name, int number) {
        super(name);
        this.name = name;
        this.number = number;
    }

    //установка список строк, печатающих каждый элемент списка с пробелом
    public void returnOtherArray(List<String> someString) {
        //Создать внутренние и результирующие переменные
        List<String> arrayInner = someString;
        ArrayList<String> resultArray = new ArrayList<String>();
        //Сортировка существующего массива
        Collections.sort(arrayInner);

        for (String s : arrayInner) {
            resultArray.add(s);
        }
        System.out.print(resultArray + " ");
    }
}