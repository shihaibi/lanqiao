package 计算机能力挑战赛Java语言;


import java.util.Scanner;

public class 编程三 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(get(str));
    }

    private static String get(String str) {
        boolean[] index = new boolean[str.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (index[i]) {
                continue;
            }
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    index[i] = true;
                    index[j] = true;

                }
            }
            if (!index[i]) {
                sb.append(str.charAt(i));
            }

        }
        return sb.length() != 0 ? sb.toString() : "YES";
    }
}
