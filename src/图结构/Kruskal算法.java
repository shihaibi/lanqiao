package 图结构;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Kruskal算法需要引入并查集union find set
 * find(x) -> 找出x所在集的标识
 * union(x, y) -> x, y放入同一个集
 */
public class Kruskal算法 {
    static class Union{
        String value;
        Union father;

        public Union(String value) {
            this.value = value;
        }

        Union find() {
            Union u = this;
            List<Union> list = new ArrayList<>();
            while(u.father != null) {
                list.add(u);
                u = u.father;
            }
            for (Union x : list) {
                x.father = u;
            }
            return u;
        }
        static void union(Union x, Union y) {
            x.find().father = y.find();
        }
    }
    static HashMap<String, Union> map= new HashMap<>();
    static List<Edge<String>> edgeList = build();
    static List<Edge<String>> resEdge = new ArrayList<>();

    public static void main(String[] args) {
        Collections.sort(edgeList);
        Kruskal(5);
        for (Edge<String> e : resEdge) {
            System.out.println(e);
        }
    }
    static void Kruskal(int size) {

        for (int i = 0; i < edgeList.size(); i++) {
            if (resEdge.size() == size - 1) {
                return;
            }
            String node1 = edgeList.get(i).getStart();
            String node2 = edgeList.get(i).getEnd();
            Union u1 = findUnion(node1);
            Union u2 = findUnion(node2);
            if (u1 != u2) {
                resEdge.add(edgeList.get(i));
                Union.union(u1, u2);
            }
        }

    }

    private static Union findUnion(String node) {
        if (!map.containsKey(node)) {
            Union u = new Union(node);
            map.put(node, u);
            return u;
        } else {
            Union u = map.get(node);
            return u.find();
        }
    }

    private static List<Edge<String>> build() {
        List<Edge<String>> l = new ArrayList<>();
        l.add(new Edge("C", "D", 1));
        l.add(new Edge("C", "A", 1));
        l.add(new Edge("C", "E", 8));
        l.add(new Edge("A", "B", 3));
        l.add(new Edge("D", "E", 3));
        l.add(new Edge("B", "C", 5));
        l.add(new Edge("B", "E", 6));
        l.add(new Edge("B", "D", 7));
        l.add(new Edge("A", "D", 2));
        l.add(new Edge("A", "E", 9));

        return l;
    }
}
