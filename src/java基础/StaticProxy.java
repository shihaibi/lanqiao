package java基础;

public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }

}
interface Marry{
    void happyMarry();
}
class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("和丑甜");
    }
}
class WeddingCompany implements Marry {
    private Marry target;
    public WeddingCompany(Marry target) {
        this.target =target;
    }

    @Override
    public void happyMarry() {
        target.happyMarry();
    }
}
