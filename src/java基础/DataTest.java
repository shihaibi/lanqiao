package java基础;

import java.io.*;

/**
 * DataInputStream
 */
public class DataTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(15);
        dos.writeBoolean(true);
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        DataInputStream dis = new DataInputStream(
                new ByteArrayInputStream(datas));
        int msg = dis.readInt();
        boolean a = dis.readBoolean();
        System.out.println(msg + " " + a);
    }
}
