package java基础;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class testWriter {
public static void main(String[] args) {
    Writer writer = null;
    File a = new File("aaa.txt");
    try {
        writer = new FileWriter(a);
        String arr = "235461232" ;
        writer.append(arr).append(arr);
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
