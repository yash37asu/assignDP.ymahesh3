package src;

public abstract class Person {

    private ProductMenu theProductMenu;

    public Person(ProductMenu productmenu) {
    }

    public abstract void showMenu();

    public void added() {
        System.out.print("\n Added to Menu.");
    }

    public void showAddButton() {
    }

    public void showViewButton() {
    }

    public void showRadioButton() {
    }

    public void showLabels() {
    }

    public abstract ProductMenu CreateProductMenu();
}
