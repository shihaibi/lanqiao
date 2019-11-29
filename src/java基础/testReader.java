package java基础;

import java.io.*;

public class testReader {
public static void main(String[] args) {
    File src = new File("lanqiao.iml");

    Reader reader = null;
    try {
        reader = new FileReader(src);
        char[] flush = new char[1024];
        int len = -1;
        while ((len = reader.read(flush))!= -1) {
            String str = new String(flush, 0, len);
            System.out.print(str);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
