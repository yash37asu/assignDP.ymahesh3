package src;

public class Reminder extends NodeVisitor{

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
