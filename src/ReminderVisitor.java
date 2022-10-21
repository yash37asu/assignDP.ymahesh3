package src;

public class ReminderVisitor extends NodeVisitor {
    private Reminder m_Reminder;

    @Override
    public void visitProduct(Product product) {
        System.out.println("Product visited");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Trade visited");
    }

    @Override
    public void visitFacade(Facade facade) {

    }
}
