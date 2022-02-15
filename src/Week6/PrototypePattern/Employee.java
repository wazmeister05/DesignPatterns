package Week6.PrototypePattern;

class Defaults{
    public final static String NAME = "Company & Co.";
    // default account number is Company & Co.'s account
    public final static String ACCOUNT_NUMBER = "00000";
}

// Prototype object
abstract class Employee {
    private String name;
    private double salary;
    private String accountNumber;

    public Employee(double salary){
        this.name = Defaults.NAME;
        this.accountNumber = Defaults.ACCOUNT_NUMBER;
        this.salary = salary;
    }

    public String toString(){
        return "Name: " + name +
                "; Job: " + this.getClass().getSimpleName() +
                "; AccountNumber: " + accountNumber +
                "; Salary: " + salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    // already a clone method in Java...
    // which does what we are doing
    abstract Employee makeClone();
}

class JuniorDeveloper extends Employee{
    public JuniorDeveloper(){
        super(20000);
    }

    public Employee makeClone(){
        return new JuniorDeveloper();
    }
}

class Developer extends Employee{
    public Developer(){
        super(30000);
        }

    public Employee makeClone(){
        return new Developer();
        }
}

class SeniorDeveloper extends Employee{
    public SeniorDeveloper(){
        super(40000);
    }

    public Employee makeClone(){
        return new SeniorDeveloper();
    }
}
