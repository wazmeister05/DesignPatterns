package Week7.StrategyDesignPattern;

// The Strategy
interface SaveStrategy {
    void save(Object data);
}

// Concrete Strategies
class ZipCompression implements SaveStrategy{
    public void save(Object data) {
        System.out.println("Performing zip compression on " + data);
    }
}

class FlacCompression implements SaveStrategy{
    public void save(Object data){
        System.out.println("Performing FLAC compression on " + data);
    }
}

class PngCompression implements SaveStrategy{
    public void save(Object data){
        System.out.println("Performing PNG compression on " + data);
    }
}

// The context that can use the strategies
class Application{

    private SaveStrategy strategy;

    public void saveAs(SaveStrategy strategy){
        this.strategy = strategy;
    }

    public void save(Object data){
        strategy.save(data);
    }
}
