package Week4.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        MobilePhonePlan plan = Plan.planFor(Customer.BUSINESS);
        plan.calculateBill(600);

        plan = Plan.planFor(Customer.RESIDENTIAL);
        plan.calculateBill(600);

        plan = Plan.planFor(Customer.COMBINED);
        plan.calculateBill(600);
    }
}
