package 计算机能力挑战赛Java语言;


import java.util.*;

public class 编程五 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Character, wuzi> hashMap = new HashMap<Character, wuzi>();
        for (int i = 0; i < n; i++) {
            char m = sc.findInLine(".").charAt(0);
            int a = sc.nextInt();
            double b = sc.nextDouble();
            sc.nextLine();
            wuzi cur = new wuzi(m, a * b);
            if (hashMap.containsKey(m)) {
                hashMap.put(m, new wuzi(m, hashMap.get(m).value + a * b));
            } else {
                hashMap.put(m, new wuzi(m, a * b));
            }


        }
        wuzi[] res = new wuzi[hashMap.size()];
        int aasdf = 0;
        for (Map.Entry<Character, wuzi> entry : hashMap.entrySet()) {
            res[aasdf++] = entry.getValue();
        }
        Arrays.sort(res, new Comparator<wuzi>() {
            @Override
            public int compare(wuzi o1, wuzi o2) {
                if (o2.value - o1.value < 0){
                    return -1;
                } else if (o2.value - o1.value == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i].toString());
        }
    }
    static class wuzi implements Comparable<wuzi>{
        char c;
        double value;
        wuzi(char c, double value) {
            this.c = c;
            this.value = value;
        }

        @Override
        public int compareTo(wuzi o) {
            return this.c - o.c;
        }
        @Override
        public String toString() {
            return c + " " +String.format("%.2f", value);
        }
    }
}
