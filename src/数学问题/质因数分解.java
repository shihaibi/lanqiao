package 数学问题;

import java.util.HashMap;
import java.util.Map;

public class 质因数分解 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = primeFactor(100);
        System.out.println(isPrime(100));
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static boolean isPrime(long num) {
        for (int i = 2; i * i <= num; i++) {
            if (num %i == 0) {
                return false;
            }
        }
        return true;
    }
    public static HashMap<Integer, Integer> primeFactor(int num) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        while (num > 1) {
            for (int i = 2; i <= num; i++) {
                if (num%i == 0) {
                    if (hashmap.containsKey(i)) {
                        hashmap.put(i, hashmap.get(i) + 1);
                    } else {
                        hashmap.put(i, 1);
                    }
                    num /= i;
                    break;
                }
            }
        }
        return hashmap;

    }
}

