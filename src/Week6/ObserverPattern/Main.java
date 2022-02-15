package Week6.ObserverPattern;

public class Main {
    public static void main(String[] args) {
        WeatherChannel metOffice = new WeatherChannel();

        ShortsPerson shortsPerson = new ShortsPerson();
        UmbrellaPerson umbrellaPerson = new UmbrellaPerson();

        metOffice.attach(shortsPerson);
        metOffice.attach(umbrellaPerson);

        System.out.println("Day 1");
        metOffice.notifyUpdate(new WeatherMessage(true, false, false));

        System.out.println("Day 2");
        metOffice.notifyUpdate(new WeatherMessage(true, true, false));

        GrumpyPerson grumpyPerson = new GrumpyPerson();
        metOffice.attach(grumpyPerson);

        System.out.println("Day 3");
        metOffice.notifyUpdate(new WeatherMessage(false, true, true));

        System.out.println("Day 4");
        metOffice.notifyUpdate(new WeatherMessage(false, false, false));
    }
}
