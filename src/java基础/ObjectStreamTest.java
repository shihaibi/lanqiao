package java基础;

import java.io.*;

public class ObjectStreamTest {
public static void main(String[] args) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(
            new BufferedOutputStream(
                    baos
            ));
    oos.writeInt(1);
    oos.writeObject(" 1234");
    oos.writeObject(new A(1,2));
    oos.flush();
    byte[] datas = baos.toByteArray();
    ObjectInputStream ois = new ObjectInputStream(
            new BufferedInputStream(
                    new ByteArrayInputStream(datas)
            )
    );
    int what = ois.readInt();
    String str = (String)ois.readObject();
    A a = (A)ois.readObject();
    System.out.println(str + " " + a.a + " " + a.b);
}
static class A implements java.io.Serializable {
    int a;
    int b;
    A(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
}
