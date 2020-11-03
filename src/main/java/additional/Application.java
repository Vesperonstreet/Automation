package additional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.*;


public class Application {

    static int a = 25 + 25;

    private final static Logger LOG = LogManager.getLogger("Class_Application");

    public static void main(String[] args) {


/*
        LOG.fatal("fatal info");
        LOG.error("error info");
        LOG.warn("warn info");
        LOG.info("info info");
        LOG.debug("debug info");
        LOG.trace("trace info");
 */

        Map<String, User> userMap = new TreeMap<>();


        User admin = new User("admin", "admin");
        User power = new User("power", "1333qaz");
        User regular = new User("regular", "1q2w3e");

        int[] ints = new int[1];

        try{
            LOG.info(ints[2]);
        } catch (IndexOutOfBoundsException e){
            LOG.error("Обращение за пределами массива:", e);
        }

        for (String username : userMap.keySet()){
            User cycleUser = userMap.get(username);
            String builder = "\nUser data: {" +
                    "\n" +
                    "Id: " +
                    cycleUser.getId() +
                    "\n" +
                    "Hidden Password: " +
                    cycleUser.getPassword(true) +
                    "\n}";
            LOG.info(builder);
        }
/*

/*
// -----------------------------------------------------------------------
        int[][] ints = new int[3][2];  // 3 - колличество строк, 2 - колличество столбцов

        ints[0][0] = 1;
        ints[0][1] = 2;

        ints[1][0] = 3;
        ints[1][1] = 4;

        ints[2][0] = 5;
        ints[2][1] = 6;

        for (int i = 0; i < 3; i++){
            for (int a = 0; a < 2; a++){
               System.out.println("Current value: "+ ints[i][a]);
           }
        }
// -----------------------------------------------------------------------
        List<List<String>> strings = new ArrayList<>();

        List<String> ListOne = new ArrayList<>();
        ListOne.add("String 1");
        ListOne.add("String 2");
        ListOne.add("String 3");
        ListOne.add("String 4");

        strings.add(ListOne);

 */
// -----------------------------------------------------------------------

/*
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");

        User businessA = new User();
        businessA.setUsername("businessA");
        businessA.setPassword("1333qaz");

        User customer = new User();
        customer.setUsername("customer");
        customer.setPassword("1q2w3e");

        userMap.put("admin", admin);
        userMap.put("businessA", businessA);
        userMap.put("customer", customer);
*/
// -----------------------------------------------------------------------
/*
        for (String username : userMap.keySet()){
            System.out.println(username.toUpperCase());
            System.out.println("Current user data: ");
            System.out.println("Login: " + userMap.get(username).getUsername());
            System.out.println("Password: " + userMap.get(username).getPassword(true));
            System.out.println("True Password: " + userMap.get(username).getPassword());

            System.out.println("User Id: ");
            userMap.get(username).printId();
            userMap.get(username).printCurrentDate();

            System.out.println("- - -");
        }


        users.add(admin);
        users.add(businessA);
        users.add(customer);

        for (User user : users){
            System.out.println("Current user data: ");
            System.out.println("Login: " + user.getUsername());
            System.out.println("Password: " + user.getPassword(true));
            System.out.println("True Password: " + user.getPassword());
            System.out.println("- - -");
        }

*/
/*
        int[] intArray = new int[]{2, 4, 5, 6};

        System.out.println("Element:" + intArray[1]);

// -----------------------------------------------------------------------
        int[] ints = new int[5];
        ints[0] = 5;

        System.out.println("Element:" + ints[0]);
// -----------------------------------------------------------------------
        int b = 0;
        while (b != 6) {
            System.out.println("Some value of b: " + b);
            ++b;
        }
        System.out.println("= = = =");
// -----------------------------------------------------------------------
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Some value of i: " + intArray[i]);
        }
        System.out.println("= = = =");
// -----------------------------------------------------------------------
        for (int element : intArray) {
            System.out.println("Some value of i: " + element);
        }
        System.out.println("= = = =");
// -----------------------------------------------------------------------
        do {
            System.out.println("Some value of b: " + b);
            b++;
        } while (b < 6) ;
        System.out.println("= = = =");
// -----------------------------------------------------------------------

        Calc calc = new Calc();
        for (int element : intArray) {
            System.out.println("Some value of calc: " + calc.sum(element, 4));
        }
        System.out.println("= = = =");
// -----------------------------------------------------------------------

        List<Integer> intList = new ArrayList<>();
        intList.add(6);
        intList.add(4);
        intList.add(5);
        intList.add(2);

        for (int element : intList) {
            System.out.println("Some value of calc: " + calc.sum(element, 4));
*/
/*
        Calc calc = new Calc();
*/
/*
        System.out.println("===Start===");
        System.out.println(calc.sum(2.6, 4));
        System.out.println("===Finish===");
 */

    }
}