package 图结构;

import java.util.*;

public class 分酒问题 {
    static int[] size = new int[]{9,7,4,2};
    static int[] wine = new int[]{9,0,0,0};
    static int getKey(int[] arr) {
        return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] res = new int[size.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = sc.nextInt();
        }
        fenjiu(res);
    }
    private static void fenjiu(int[] res) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(getKey(wine),0);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(Arrays.copyOf(wine,wine.length));
        while (!queue.isEmpty()) {
            int[] curArr = queue.poll();
            int curDepth = map.get(getKey(curArr));
            if (getKey(curArr) == getKey(res)) {
                System.out.println(curDepth);
            }
            for (int i = 0; i < curArr.length; i++) {
                if (curArr[i] == 0) continue;
                for (int j = 0; j < curArr.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (curArr[i] + curArr[j] < size[j]) {
                        int[] nextArr = Arrays.copyOf(curArr,curArr.length);
                        nextArr[j] += nextArr[i];
                        nextArr[i] = 0;
                        if (!map.containsKey(getKey(nextArr))) {
                            queue.offer(nextArr);
                            map.put(getKey(nextArr),curDepth + 1);
                        }


                    } else {
                        int[] nextArr = Arrays.copyOf(curArr,curArr.length);
                        nextArr[i] -= size[j] - nextArr[j];
                        nextArr[j] = size[j];

                        if (!map.containsKey(getKey(nextArr))) {
                            queue.offer(nextArr);
                            map.put(getKey(nextArr),curDepth + 1);
                        }
                    }

                }
            }

        }
        System.out.println(-1);
    }
}
