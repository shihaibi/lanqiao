package java基础;

/**
 * 证明了直接在源头syn很好用
 */
public class Happy {
    public static void main(String[] args) {
        movie a = new movie(2);
        new Thread(new people(1,a)).start();
        new Thread(new people(2, a)).start();


    }
}
class movie{
    int seat;
    movie(int seat){
        this.seat = seat;
    }
    synchronized void getTi(int num) {
        if (seat >= num) {
            System.out.println("good " + seat);
            seat -= num;

        } else {
            System.out.println("bad "+ seat);
        }

    }
}
class people implements Runnable{
    int num;
    movie a;
    people(int num, movie a) {
        this.num = num;
        this.a = a;
    }
    @Override
    public void run() {
        a.getTi(num);
    }
}