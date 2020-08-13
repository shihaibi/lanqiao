package CCF;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ans = null;
        int size = ans.size();

    }
    public boolean isAdditiveNumber(String num) {
        List<Integer> ans = null;
        int size = ans.size();
        return isIt(num, 0,0l, 0l, 0);

    }
    public boolean isIt(String str,int index, Long l1, Long l2, int k) {
        if (index == str.length()) {
            return k > 2;
        }
        for (int i = index + 1; i <= str.length(); i++) {
            if (str.charAt(index) == '0' && i != index + 1) {
                break;
            }
            Long curNum =  getNum(str, index, i);
            if (curNum < 0)
                continue;
            if (k >= 2 && curNum != l1 + l2)
                continue;
            if (isIt(str, i, l2, curNum, k + 1)) {
                return true;
            }
        }
        return false;
    }
    public Long getNum(String str, int i, int j) {
        Long ans = 0l;
        for (int k = i; k < j; k++) {
            ans = ans * 10 + (str.charAt(k) - '0');
        }
        return ans;
    }
}
class NumArray {
    int[] arr;
    int len;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        len = nums.length;
        arr = new int[4 * len];
        buildTree(nums, 1, 0, len - 1);
    }
    private void buildTree(int[] nums, int arrIndex, int numStart, int numEnd) {
        if (numStart == numEnd) {
            arr[arrIndex] = nums[numStart];
            return;
        }
        int mid = (numEnd + numStart) / 2;
        buildTree(nums, arrIndex * 2, numStart, mid);
        buildTree(nums, arrIndex * 2 + 1, mid + 1, numEnd);
        arr[arrIndex] = arr[arrIndex * 2 + 1] + arr[arrIndex * 2];
    }

    public void update(int i, int val) {
        if (arr == null) return;
        modify(0, len - 1, i, 1, val);
    }
    public void modify(int l, int r, int i, int index, int val) {
        if (l == r) {
            arr[index] = val;
            return;
        }
        int mid = (r + l) / 2;
        if (mid >= i)   modify(l, mid, i,index * 2, val);
        if (mid < i)   modify(mid + 1, r, i,index * 2 + 1, val);
        arr[index] = arr[index * 2] + arr[index * 2 + 1];
    }

    public int sumRange(int i, int j) {
        if (arr == null) return 0 ;
        return getSum(i, j, 0, len - 1, 1);
    }
    private int getSum(int i, int j, int m, int n, int index) {
        if (i <= m && j >= n) {
            return arr[index];
        }
        int sum = 0, mid = (n - m) / 2;
        if (i <= mid) sum += getSum(i, j, m, mid, index * 2);
        if (j > mid) sum += getSum(i, j, mid + 1,n, index * 2 + 1);
        return sum;
    }

}
