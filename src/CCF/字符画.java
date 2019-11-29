package CCF;

import java.util.Scanner;

public class 字符画 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        String[][] data= new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextLine();
            }
        }
        sc.close();
        int[][][] pdata = process1(data, p, q);
        String str = process2(pdata);
        String res = make16(str);
        System.out.print(res);
    }

    private static String process2(int[][][] pdata) {
        StringBuilder sb = new StringBuilder();
        int pastr = 0, pastg = 0, pastb = 0;
        String curReset = (char)27 + "[0";
        String change = (char)27 + "[48;2" ;
        String curPut = "m ";
        int y = pdata[0].length - 1;
        for (int i = 0; i < pdata.length; i++) {
            for (int j = 0; j < pdata[0].length; j++) {

                if (pdata[i][j][0] == pastr && pdata[i][j][1] == pastg && pdata[i][j][2] == pastb) {
                    sb.append(' ');
                    continue;
                } else if (pdata[i][j][0] == 0 && pdata[i][j][1] == 0 && pdata[i][j][2] == 0) {
                    sb.append(curReset);
                } else {
                    sb.append(change);
                    for (int k = 0; k < pdata[0][0].length; k++) {
                        char[] nanguo = String.valueOf(pdata[i][j][k]).toCharArray();
                        sb.append(';');
                        for (char m : nanguo) {
                            sb.append(m);
                        }

                    }
                }
                pastr = pdata[i][j][0];
                pastg = pdata[i][j][1];
                pastb = pdata[i][j][2];
                sb.append(curPut);
            }
            if (pdata[i][y][0] == 0 && pdata[i][y][1] == 0 && pdata[i][y][2] == 0) {

            }else {
                sb.append(curReset).append("m");
                pastb = 0;
                pastg = 0;
                pastr = 0;
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private static int[][][] process1(String[][] data, int p, int q) {
        int xTime = data.length/q;
        int yTime = data[0].length/p;
        int[][][] pdata = new int[xTime][yTime][3];
        for (int i = 0; i < xTime; i++) {
            for (int j = 0; j < yTime; j++) {
                for (int k = i * q; k < (i + 1) * q; k++) {
                    for (int m = j * p; m < (j + 1) * p; m++) {
                        data[k][m] = font(data[k][m]);
                        pdata[i][j][0] += Integer.parseInt(data[k][m].substring(1, 3), 16);
                        pdata[i][j][1] += Integer.parseInt(data[k][m].substring(3, 5), 16);
                        pdata[i][j][2] += Integer.parseInt(data[k][m].substring(5, 7), 16);
                    }
                }
                pdata[i][j][0] /= p*q;
                pdata[i][j][1] /= p*q;
                pdata[i][j][2] /= p*q;

            }
        }
        return pdata;
    }

    private static String make16(String str) {
        char[] arr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            String curNum = Integer.toString(arr[i], 16);
            if (curNum.length() == 1) {
                sb.append("\\x0").append(curNum.toUpperCase());
            } else {
                sb.append("\\x").append(curNum.toUpperCase());
            }
        }
        return sb.toString();

    }
    private static String font(String str) {
        if (str.length() == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append('#');
            for (int n = 0; n < 6; n++) {
                sb.append(str.charAt(1));
            }
            return sb.toString();
        } else if (str.length() == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append('#');
            for (int n = 0; n < 6; n++) {
                sb.append(str.charAt(n/2 + 1));
            }
            return sb.toString();
        } else {
            return str;
        }
    }
}
