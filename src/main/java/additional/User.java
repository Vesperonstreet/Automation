package additional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class User extends Record {

    private final static Logger LOG = LogManager.getLogger("Class_User");

    private String username;
    private String password;
    private Date created;

    private static int countOfUsers = 0;

    public User(String username, String password) {
        super(countOfUsers);
        this.username = username;
        this.password = password;
        this.created = new Date();
        countOfUsers++;
        LOG.debug(String.format("%n Created user: %s%n created at: %s%n current count of users: %s%n", username, created, countOfUsers));
//      или так
//      System.out.printf("Created user: %S. created at: %S. current count of users: %S%n", username, created, countOfUsers);
    }

    public User(){
        super(countOfUsers); //указатель на конструктор родителя
        LOG.debug("Created new empty user: ");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword(boolean isForReporting){
        if (isForReporting){
            return getSecretField(this.password);
        } else {
            return password;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void printId() {
        LOG.info("Id: " + this.getId());
    }
}