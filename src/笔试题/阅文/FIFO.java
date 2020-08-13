package 笔试题.阅文;
import java.util.*;
public class FIFO {
    public String doQueue (ArrayList<String> ops) {
        Queue queue = new LinkedList();
        StringBuilder res = new StringBuilder();
        for(String s : ops) {
            String[] arr = s.split(" ");
            if (arr.length == 1) {
                if (queue.isEmpty()) {
                    res.append(',').append("null");
                } else {
                    res.append(',').append(queue.poll());
                }
            }else {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[1]);
                for (int i = 2; i < arr.length; i++) {
                    sb.append(' ').append(arr[i]);
                }
                queue.offer(sb.toString());
            }
        }
        return res.substring(1);
    }
}
