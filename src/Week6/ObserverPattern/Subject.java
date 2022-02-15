package Week6.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyUpdate(WeatherMessage m);
}

interface Observer{
    void update(WeatherMessage m);
}

class WeatherMessage{
    private boolean sunny, rainy, windy;
    public WeatherMessage(boolean sunny, boolean rainy, boolean windy){
        this.sunny = sunny;
        this.rainy = rainy;
        this.windy = windy;
    }

    public String toString(){
        String temp = "The weather is going to be ";
        if(sunny){
            temp += "sunny";
        }
        if(rainy){
            temp += "rainy";
        }
        if(windy){
            temp += "windy";
        }
        return temp;
    }

    public String content(){
        return this.toString();
    }
}

class WeatherChannel implements Subject{
    private List<Observer> observers = new ArrayList<>();
    public void attach(Observer o){
        observers.add(o);
    }
    public void detach(Observer o){
        observers.remove(o);
    }
    public void notifyUpdate(WeatherMessage m){
        for(Observer o: observers){
            o.update(m);
        }
    }
}

class ShortsPerson implements Observer{
    public void update(WeatherMessage m){
        if(m.content().contains("sunny")){
            System.out.println("Shorts person: I'm wearing shorts today");
        }
    }
}

class UmbrellaPerson implements Observer{
    public void update(WeatherMessage m){
        if(m.content().contains("rainy")){
            System.out.println("Umbrella person: I'm taking an umbrella with me today");
        }
    }
}

class GrumpyPerson implements Observer{
    public void update(WeatherMessage m){
        System.out.print("Grumpy person: ");
        if(m.content().contains("sunny")){
            System.out.println("It's too hot to go out");
        }
        else if(m.content().contains("rainy")){
            System.out.println("It's too wet to go out");
        }
        else if(m.content().contains("windy")){
            System.out.println("It's too windy to go out");
        }
        else{
            System.out.println("It's a boring grey day, better stay in");
        }
    }
}
