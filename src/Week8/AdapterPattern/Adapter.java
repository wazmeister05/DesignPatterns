package Week8.AdapterPattern;

class USSocket{
    private void power(){
        System.out.println("Powering electrical item");
    }

    public void acceptPlug(TwoProng plug){
        plug.black();
        plug.white();
        power();
    }
}

class UKSocket{
    public boolean plugIn;

    public void power(){
        if (plugIn) {
            System.out.println("Powering electical item");
        }
    }

    public void acceptPlug(ThreeProng plug){
        plug.brown();
        plug.blue();
        plug.green();
        plugIn = true;
    }
}

interface TwoProng{
    void black(); // live
    void white(); // neutral
}

interface ThreeProng{
    void brown(); // live
    void blue(); // neutral
    void green(); // earth
}

class TwoProngPlug implements TwoProng{
    public void black(){
        System.out.println("Live Connected");
    }
    public void white(){
        System.out.println("Neutral Connected");
    }
}

class ThreeProngPlug implements ThreeProng{
    public void brown(){
        System.out.println("Live Connected");
    }
    public void blue(){
        System.out.println("Neutral Connected");
    }
    public void green(){
        System.out.println("Earth Connected");
    }
}

// object adapter
// we delegate the calls to the stored object
// TwoProngPlug is the adaptee here
class TwoToThreeProngAdapter implements ThreeProng{
    private TwoProngPlug plug;

    public TwoToThreeProngAdapter(TwoProngPlug plug){
        this.plug = plug;
    }

    public void brown(){
        plug.black();
    }
    public void blue(){
        plug.white();
    }
    public void green(){
        System.out.println("A bit of plastic will do for the earth...");
    }
}

// class adapter
// This IS a three prong plug and we are making it work with the two prong interface
// ThreeProngPlus is the adaptee here
class ThreeToTwoProngAdapter extends ThreeProngPlug implements TwoProng{
    public void black(){
        System.out.println("Connecting some wire from brown into black");
        brown();
    }
    public void white(){
        System.out.println("Connecting some wire from blue into white");
        blue();
    }
}