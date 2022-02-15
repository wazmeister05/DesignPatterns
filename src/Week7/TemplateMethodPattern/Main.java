package Week7.TemplateMethodPattern;

public class Main {
    public static void main(String[] args) {
        TemplateHouse houseType = new WoodenHouse();

        // call template method
        houseType.buildHouse();

        System.out.println("------------------------");
        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
