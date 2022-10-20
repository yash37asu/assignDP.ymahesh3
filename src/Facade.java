package src;

import java.io.IOException;

public class Facade {
    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePearson;

    UserInfoItem newUser = new UserInfoItem();
    private Login newPerson;

    public Facade() throws IOException{
        createProductList();
        newPerson =new Login();
    }

    public void login() throws  IOException{
        System.out.print("\n"+"FACADE PATTERN is implemented here"+"\n");
        newUser = newPerson.loginMethod();
    }

    public void Database() throws IOException{

    }
    public void addTrading() {
    }

    public void viewTrading() {
    }

    public void decideBidding() {
    }

    public void discussBidding() {
    }

    public void submitBidding() {
    }

    public void remind() {
    }

    public void createUser(UserInfoItem userinfoitem) {
    }

    public void createProductList() {
    }


    public void AttachProductToUser() {
    }

    public Product SelectProduct() {
        return null;
    }

    public void productOperation() {
    }
}
