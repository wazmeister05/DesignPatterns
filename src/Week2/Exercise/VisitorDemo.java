package Week2.Exercise;

import java.util.List;

interface CarElement {
    void accept(CarElementVisitor visitor);
}

interface CarElementVisitor {
    void visit(Body body);
    void visit(Car car);
    void visit(Engine engine);
    void visit(Wheel wheel);
}

class Wheel implements CarElement {
    private final String name;
    private int pressure;

    public Wheel(final String name, int pressure) {
        this.name = name;
        this.pressure = pressure;
    }

    public String getName() {
        return name;
    }

    public int getPressure(){
        return pressure;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        /*
         * accept(CarElementVisitor) in Wheel implements
         * accept(CarElementVisitor) in CarElement, so the call
         * to accept is bound at run time. This can be considered
         * the *first* dispatch. However, the decision to call
         * visit(Wheel) (as opposed to visit(Engine) etc.) can be
         * made during compile time since 'this' is known at compile
         * time to be a Wheel. Moreover, each implementation of
         * CarElementVisitor implements the visit(Wheel), which is
         * another decision that is made at run time. This can be
         * considered the *second* dispatch.
         */
        visitor.visit(this);
    }
}

class Body implements CarElement {
    private BodyType body;

    public Body(BodyType body){
        this.body = body;
    }

    public BodyType getBody(){
        return body;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

enum BodyType{
    SALOON,
    HATCHBACK,
    SPORTS,
    TOURER,
    SUV
}

class Engine implements CarElement {
    private String oilLevel;
    private double engineSize;

    public Engine(final String oilLevel, double engineSize){
        this.oilLevel = oilLevel;
        this.engineSize = engineSize;
    }

    public String getOilLevel(){
        return oilLevel;
    }

    public double getEngineSize(){
        return engineSize;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }


}

class Car implements CarElement {
    private final List<CarElement> elements;

    public Car() {
        this.elements = List.of(
                new Wheel("front left", 30), new Wheel("front right", 30),
                new Wheel("back left", 30), new Wheel("back right", 20),
                new Body(BodyType.HATCHBACK), new Engine("Low", 1.6)
        );
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        for (CarElement element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}

class CarElementDoVisitor implements CarElementVisitor {
    @Override
    public void visit(Body body) {
        System.out.println("Moving my body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Starting my car");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
}

class CarElementPrintVisitor implements CarElementVisitor {
    @Override
    public void visit(Body body) {
        System.out.println("Visiting body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Visiting car");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }
}

public class VisitorDemo {
    public static void main(final String[] args) {
        Car car = new Car();

        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
        car.accept(new MechanicVisitor());
        car.accept(new SalesVisitor());
    }
}

class MechanicVisitor implements CarElementVisitor{

    @Override
    public void visit(Body body) {

    }

    @Override
    public void visit(Car car) {

    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Oil level: " + engine.getOilLevel());
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Tyre Pressure: " + wheel.getPressure());
    }
}

class SalesVisitor implements CarElementVisitor{

    @Override
    public void visit(Body body) {
        System.out.println("Body type: " + body.getBody());
    }

    @Override
    public void visit(Car car) {

    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Engine size: " + engine.getEngineSize());
    }

    @Override
    public void visit(Wheel wheel) {

    }
}