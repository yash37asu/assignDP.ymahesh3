package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Facade {
    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePearson;

    ArrayList<String>uName = new ArrayList<String>();
    ArrayList<String>pName = new ArrayList<String>();
    ArrayList<String>productLists = new ArrayList<String>();
    ArrayList<Integer>productType = new ArrayList<>();

    UserInfoItem newUser = new UserInfoItem();
    private Login newPerson;

    public Facade() throws IOException{
        Database();
        createProductList();
        newPerson =new Login();
    }

    public boolean login() throws  IOException{
        System.out.print("\n"+"FACADE PATTERN is implemented here"+"\n");
        newUser = newPerson.loginMethod();
        return true;
    }

    public void Database() throws IOException{
        File db = new File("src/Database.txt");
        if(db.createNewFile()){}
        else{}
    }
    public void addTrading(String user_name, int user_type, String product_name) throws IOException
    {
        int bidValue = decideBidding(user_type);
        if(user_type == 0)
        {
            boolean final_bid = discussBidding();
            if(final_bid)
            {
                submitBidding(user_name, user_type, product_name, bidValue);
            }
            else
            {
                System.out.print("\nThis bid was not accepted");
            }
        }
        else
        {
            System.out.print("\n The base value of bidding was added");
            submitBidding(user_name, user_type, product_name, bidValue);
        }
    }

    public void viewTrading() throws IOException {
        File file = new File("src/Database.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> userList = new ArrayList<>();
        ArrayList<Integer>userCategories = new ArrayList<>();
        ArrayList<String>productNames = new ArrayList<>();
        ArrayList<Integer>bidsRecieved = new ArrayList<>();

        String str;

        while((str = br.readLine())!=null)
        {
            String[] lines = str.split("---");
            userList.add(lines[0]);
            userCategories.add(Integer.parseInt(lines[1]));
            productNames.add(lines[2]);
            bidsRecieved.add(Integer.parseInt(lines[3]));
        }

        System.out.print("\n Trade info for "+((newUser.userCategory == 0)?" Buyer":" Seller"));


    }

    public int decideBidding(int userType) {
        Scanner scanner = new Scanner(System.in);
        int bid = 0;
        if (userType == 0) {
            System.out.print("\n Please enter your bid value : ");
            bid = scanner.nextInt();
        }
        if (userType == 1) {


            System.out.print("\n Enter the root value for product bidding : ");
            bid = scanner .nextInt();
        }
        return bid;
    }

    public boolean discussBidding(){
        boolean temp = true;
        System.out.print("\n Confirm your bidding? Please Enter Yes or No : \n");
        Scanner scanner = new Scanner(System.in);
        String v = scanner.nextLine();
        if(v.equalsIgnoreCase("NO"))
        {
            temp = false;
        }
        else if(v.equalsIgnoreCase("YES"))
        {
            temp = true;
        }
        else
        {
            System.out.print("It's not among given choice, so taking Yes.");
        }
        return temp;
    }


    public void submitBidding(String user_name, int user_type, String product_name, int bidValue) throws IOException{
        FileWriter fw = new FileWriter("src/Database.txt",true);
        String s = "\n"+user_name+" "+Integer.toString(user_type)+" "+product_name+" "+Integer.toString(bidValue);
        fw.flush();
        fw.write(s);
        fw.close();
    }

    public void remind() {
    }

    public void createUser(UserInfoItem userinfoitem) {
    }

    public void createProductList() throws IOException {
        File file = new File("src/ProductInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;

        while((str = br.readLine())!=null){
            productLists.add(str);
            String tempsplit[]=str.split(":");
            productType.add((tempsplit[0].equals("Meat"))?0:1);
            productLists.add(tempsplit[1]);
        }
    }


    public void AttachProductToUser()throws IOException {
        File file = new File("src/UserProduct.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;

        while((str = br.readLine())!=null)
        {
            String[] splitStr = str.split(":");
            uName.add(splitStr[0]);
            pName.add(splitStr[1]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Please enter product type: ");
        int pType = scanner.nextInt();

        System.out.print("\n Which trading option would you have: ");
        System.out.print("\n 1)Add Trading option");
        System.out.println("\n 2)View Trading option");
        int tradeType = scanner.nextInt();


        SelectProduct(productLists.get(pType-1));
        nProductCategory=productType.get(pType-1);

        if(tradeType == 1)
        {

            if(nProductCategory == 0)
            {
                ProductMenu p1 = new MeatProductMenu();
                p1.showAddButton();
                addTrading(newUser.userName, newUser.userCategory, productLists.get(pType-1));
            }
            else if(nProductCategory == 1)
            {
                ProductMenu p2 = new ProduceProductMenu();
                p2.showAddButton();
                addTrading(newUser.userName, newUser.userCategory, productLists.get(pType-1));
            }
        }
        else if(tradeType == 2)
        {

            if(nProductCategory == 0)
            {
                ProductMenu p1 = new MeatProductMenu();
                System.out.println("\n"+"FACTORY PATTERN helps in showing menu according to user & product");
                p1.showViewButton();
                viewTrading();
            }
            else if(nProductCategory == 1)
            {
                ProductMenu p2 = new ProduceProductMenu();
                System.out.println("\n"+"FACTORY PATTERN helps in showing menu according to user & product");
                p2.showViewButton();
                viewTrading();
            }
        }
    }

    public String SelectProduct(String product) {
        System.out.println("Selected Product : "+product);
        return product;
    }

    public void productOperation() {
    }
}
