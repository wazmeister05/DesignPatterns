package Week8.StatePattern;

// The state 'interface'
// default implementations assume you aren't in the correct state
abstract class DoorState{
    void close(Door d){
        System.out.println("You can't close a door when it is " + currently());
    }

    void open(Door d){
        System.out.println("You can't open a door when it is " + currently());
    }

    void lock(Door d){
        System.out.println("You can't lock a door when it is " + currently());
    }

    void unlock(Door d){
        System.out.println("You can't unlock a door when it is " + currently());
    }

    // not to be overridden but used after setting a state
    String currently(){
        return this.getClass().getSimpleName().toLowerCase();
    }
}

// the context that makes requests
class Door{
    private DoorState state = new Closed();

    // this should only be used by DoorState subclasses
    void setState(DoorState s){
        this.state = s;
        System.out.println("The door is " + state.currently());
    }

    public void close(){
        state.close(this);
    }
    public void open(){
        state.open(this);
    }
    public void lock(){
        state.lock(this);
    }
    public void unlock(){
        state.unlock(this);
    }

}

// State subclasses only implementing the methods that apply to that state

// Closed doors can be unlocked or opened
class Closed extends DoorState{
    public void open(Door d){
        d.setState(new Opened());
    }
    public void lock(Door d){
        d.setState(new Locked());
    }
}

// Locked doors can only be unlocked
class Locked extends DoorState{
    public void unlock(Door d){
        d.setState(new Closed());
    }
}

// open doors can only be closed
class Opened extends DoorState{
    public void close(Door d){
        d.setState(new Closed());
    }
}