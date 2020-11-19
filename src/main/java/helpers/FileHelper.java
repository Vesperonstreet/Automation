package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FileHelper {

    private final static Logger LOG = LogManager.getLogger("Помощник работы с файлами");

    public static List<String> readLinesFromFile(String path){
        try {
           return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            LOG.error(String.format("Проблема с файлом %s: %s", path, e.getMessage()));
            return new ArrayList<>();
        }
    }

    public static Collection<String[]> readAuthDataFromFile(String path){
        Collection<String[]> result = new ArrayList<>();
        List<String> lines = readLinesFromFile(path);
        for (String line : lines){
            result.add(line.split(", "));
        }
        return result;
    }

    public static Collection<Object[]> readDataFromFile(String path){
        Collection<Object[]> result = new ArrayList<>();
        List<String> lines = readLinesFromFile(path);
        for (String line : lines){
            String[] testData = line.split(", ");
            List<String> labels = new ArrayList<>();
            for (String label : testData){
                if (testData[0].equals(label) || !testData[1].equals(label)){
                    labels.add(label);
                }
            }
            result.add(new Object[]{testData[0], testData[1], labels});
        }
        return result;
    }
}