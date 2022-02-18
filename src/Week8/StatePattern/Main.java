package Week8.StatePattern;

public class Main {
    public static void main(String[] args) {
        Door d = new Door();

        d.close();
        d.lock();
        System.out.println("-----------------");

        d.close();
        d.open();
        d.unlock();
        System.out.println("-----------------");

        d.open();
        d.lock();
        System.out.println("-----------------");

        d.close();
        d.lock();
    }
}
