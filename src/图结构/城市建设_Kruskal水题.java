package 图结构;

import java.util.*;

public class 城市建设_Kruskal水题 {
    private static List<Edge<Integer>> build() {
        List<Edge<Integer>> l = new ArrayList<>();
        l.add(new Edge(1, 2, 4));
        l.add(new Edge(1, 3, -1));
        l.add(new Edge(2,3,3));
        l.add(new Edge(2,4,5));
        l.add(new Edge(4,5,10));
        l.add(new Edge(0,2,10));
        l.add(new Edge(0,3,10));
        l.add(new Edge(0,4,1));
        l.add(new Edge(0,5,1));
        return l;
    }
    static class Union<T>{
        T value;
        Union father;

        public Union(T value) {
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
    private static Union findUnion(HashMap<Integer, Union<Integer>> map,Integer node) {
        if (!map.containsKey(node)) {
            Union u = new Union(node);
            map.put(node, u);
            return u;
        } else {
            Union u = map.get(node);
            return u.find();
        }
    }
    public static void main(String[] args) {
        List<Edge<Integer>> list = build();

        Collections.sort(list, Comparator.comparingInt(Edge::getDistance));

        kruskal(list, 6);
    }



    private static void kruskal(List<Edge<Integer>> list, int num) {


        int curDis = 0;
        int curSize = 0;
        HashMap<Integer, Union<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (curSize == num - 1) {
                break;
            }

            Integer node1 = list.get(i).getStart();
            Integer node2 = list.get(i).getEnd();
            Union u1 = findUnion(map, node1);
            Union u2 = findUnion(map, node2);
            if (u1 != u2) {
                curSize++;
                curDis += list.get(i).getDistance();
                Union.union(u1,u2);
            }


        }
        System.out.println(curDis);
    }




}
