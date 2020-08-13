package 笔试题.阅文;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MD5 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(createToken(new ArrayList<String>() {{
            add("arr=123");
            add("crr=123");
            add("brr=123");
        }}));
    }
    public static String createToken (ArrayList<String> querys) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // write code here
        Union[] u = new Union[querys.size()];
        int i = 0;
        for (String s : querys) {
            u[i] = new Union();
            String[] arr = s.split("\\=");
            u[i].s1 = arr[0];
            u[i].s2 = arr[1];
            i++;
        }
        Arrays.sort(u, new Comparator<Union>() {
            @Override
            public int compare(Union o1, Union o2) {
                return o1.s1.compareTo(o2.s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < u.length; j++) {
            sb.append("&").append(u[j].s1).append("=").append(u[j].s2);
        }
        String res = sb.substring(1);
        byte[] a = res.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] it = md.digest(a);
        return bytesToHex(it);

    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

}
class Union {
    String s1;
    String s2;
}
