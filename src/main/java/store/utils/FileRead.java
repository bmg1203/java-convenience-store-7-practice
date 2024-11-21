package store.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRead {

    public static List<String> fileReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> content = new ArrayList<>();

        while (reader.readLine() != null) {
            content.add(reader.readLine());
        }
        reader.close();
        return content;
    }
}
