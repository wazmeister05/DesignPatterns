package Week6.PrototypePattern;

public class Main {
    public static void main(String[] args) {
        // make a prototypical instance of each employee type
        Employee prototypeJunior = new JuniorDeveloper();
        Employee prototypeDeveloper = new Developer();
        Employee prototypeSenior = new SeniorDeveloper();

        // every new employee is a clone of the prototypical instance
        Employee john = prototypeJunior.makeClone();
        // except with a few changes
        john.setName("John");
        john.setAccountNumber("12345");

        Employee frank = john.makeClone();
        // Frank does remember to update his name
        // but not his account number
        frank.setName("Frank");

        Employee jessica = prototypeDeveloper.makeClone();
        jessica.setName("Jessica");
        jessica.setAccountNumber("23456");

        Employee stuart = prototypeSenior.makeClone();
        stuart.setName("Stuart");
        stuart.setAccountNumber("34567");

        System.out.println(prototypeJunior);
        System.out.println(prototypeDeveloper);
        System.out.println(prototypeSenior);
        System.out.println();

        System.out.println(john);
        System.out.println(jessica);
        System.out.println(stuart);
        System.out.println();

        // poor Frank isn't getting paid
        // but the company receives his money
        System.out.println(frank);
    }
}
