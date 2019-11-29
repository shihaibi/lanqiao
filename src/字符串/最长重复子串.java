package 字符串;

import java.util.Arrays;

/**
 * 通过后缀子串的最长前缀找到
 * 重复的最长重复字串
 * 不重复的最长前缀字串
 */
public class 最长重复子串 {
    public static void main(String[] args) {
        String str = "123232323";
        Sa[] sa = getSa(str);
        int[] height = getHeight(sa);
        System.out.println(getMaxLong(height));
        System.out.println(getUnrepeatedMaxLong(sa,height));
    }
    static class Sa implements Comparable<Sa>{
        char c;
        String subStr;
        int index;
        Sa(char c, String subStr, int index) {
            this.c = c;
            this.subStr = subStr;
            this.index = index;
        }
        @Override
        public int compareTo(Sa sa) {
            return this.c - sa.c;
        }
        @Override
        public String toString() {
            return "Sa{" + "String=" + subStr +
                    " "+", char=" + c + " " +
                    ", index=" + index +
                    '}';
        }
    }
    public static Sa[] getSa(String str) {
        Sa[] sa = new Sa[str.length()];
        int n = sa.length;
        for (int i = 0; i < n; i++) {
            sa[i] = new Sa(str.charAt(i), str.substring(i), i);
        }
        Arrays.sort(sa);
        int[] rank = new int[n];
        rank[sa[0].index] = 1;
        for (int i = 1; i < n; i++) {
            if (sa[i].c == sa[i - 1].c) {
                rank[sa[i].index] = rank[sa[i - 1].index];
            } else {
                rank[sa[i].index] = rank[sa[i - 1].index] + 1;
            }
        }
        for (int k = 2; rank[sa[n - 1].index] < n; k*=2) {
            final int kk = k;
            Arrays.sort(sa, (o1, o2) -> {
                if (rank[o1.index] != rank[o2.index]) {
                    return rank[o1.index] - rank[o2.index];
                } else if (Math.max(o1.index, o2.index) + kk/2 >= n) {
                    return o2.index - o1.index;
                } else {
                    return rank[o1.index + kk/2] - rank[o2.index + kk/2];
                }
            });
            rank[sa[0].index] = 1;
            for (int i = 1; i < n; i++) {
                int i1 = sa[i - 1].index;
                int i2 = sa[i].index;
                if (str.substring(i1, i1 + kk <= n ? i1 + kk : n).equals(
                        str.substring(i2, i2 + kk <= n ? i2 + kk : n)
                )) {
                    rank[i2] = rank[i1];
                } else {
                    rank[i2] = rank[i1] + 1;
                }
            }
        }
        return sa;
    }
    //主要是height[sa[i].index] = height[sa[i].index - 1] - 1
    public static int[] getHeight(Sa[] sa){
        int[] height = new int[sa.length];
        int[] rank = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            rank[sa[i].index] = i;
        }
        int k = 0;
        for (int i = 0; i < sa.length; i++) {
            if (rank[i] != 0) {
                int rk_i = rank[i];
                if (k > 0) k--;
                String s1 = sa[rank[i]].subStr;
                String s2 = sa[rank[i] - 1].subStr;
                while (k < s1.length() && k < s2.length() &&
                        s1.charAt(k) == s2.charAt(k)) {
                    k++;
                }
                height[rank[i]] = k;
            }
        }
        return height;
    }
    public static int getMaxLong(int[] height) {
        return Arrays.stream(height).max().getAsInt();
    }
    public static int getUnrepeatedMaxLong(Sa[] sa, int[] height) {
        int maxLong = Integer.MIN_VALUE;
        int l = 0, r = height.length, mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (check(sa, height, mid)) {
                maxLong = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return maxLong;
    }

    private static boolean check(Sa[] sa, int[] height, int mid) {
        int maxIndex = sa[0].index;
        int minIndex = sa[0].index;
        for (int i = 1; i < height.length; i++) {
            int index = sa[i].index;
            if (height[i] >= mid) {
                maxIndex = Math.max(maxIndex, index);
                minIndex = Math.min(minIndex, index);
                if (maxIndex - minIndex >= mid)
                    return true;
            } else {
                maxIndex = index;
                minIndex = index;
            }
        }
        return false;
    }

}
