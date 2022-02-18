package Week8.AdapterPattern;

public class Main {
    public static void main(String[] args) {

        USSocket usSocket = new USSocket();
        ThreeToTwoProngAdapter ukPlugWithWiresAttached = new ThreeToTwoProngAdapter();
        usSocket.acceptPlug(ukPlugWithWiresAttached);

        System.out.println("----------------------");
        UKSocket ukSocket = new UKSocket();
        TwoProngPlug usPlug = new TwoProngPlug();
        TwoToThreeProngAdapter usToUKAdapter = new TwoToThreeProngAdapter(usPlug);

        ukSocket.acceptPlug(usToUKAdapter);
        ukSocket.power();
    }
}
