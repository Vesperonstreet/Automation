package additional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Record implements Printer{

    private final static Logger LOG = LogManager.getLogger("Class_Record");

    private int id;

    public Record(int id) {
        this.id = id;
        LOG.debug("Record: " + id);
    }

    public int getId() {
        return id;
    }
}