package src;

import java.io.*;
import java.util.*;

public class Login {

    ArrayList<String> buyersName = new ArrayList<>();
    ArrayList<String> buyersPassword = new ArrayList<>();
    ArrayList<String> sellersName = new ArrayList<>();
    ArrayList<String> sellersPassword = new ArrayList<>();


    public UserInfoItem loginMethod() throws IOException {

        UserInfoItem newUser = new UserInfoItem();

        File file1 = new File("src/BuyerInfo.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));

        File file2 = new File("src/SellerInfo.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));

        String str;

        boolean allow_user = true;
        boolean is_buyer = false;
        boolean is_seller = false;

        while ((str = br1.readLine()) != null) {
            String[] buyers = str.split(":");
            buyersName.add(buyers[0]);
            buyersPassword.add(buyers[1]);
        }

        while ((str = br2.readLine()) != null) {
            String[] sellers = str.split(":");
            sellersName.add(sellers[0]);
            sellersPassword.add(sellers[1]);
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please Enter Your Username : ");
        String user_name = scanner1.next();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please Enter Your Password : ");
        String user_pass= scanner2.next();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("\n" + "Enter the category of User " + "(For Buyer enter 0, For Seller enter 1)  : ");
        int user_cat = scanner3.nextInt();

        newUser.userName = user_name;
        newUser.userCategory = user_cat;

        for (int i = 0; i < buyersName.size(); i++) {
            if (user_name.equals(buyersName.get(i)) && user_pass.equals(buyersPassword.get(i))) {
                is_buyer = true;
            }
        }

        for (int i = 0; i < sellersName.size(); i++) {
            if (user_name.equals(sellersName.get(i)) && user_pass.equals(sellersPassword.get(i))) {
                is_seller = true;
            }
        }


        if (user_cat == 0) {
            if (is_buyer) {
                System.out.print("\n The Entered user is a : Buyer");
            } else {
                System.out.print("\n User does not exist!");
                System.exit(0);
            }
            Person newBuyer = new Buyer(new MeatProductMenu());
            System.out.print("\n" + "BRIDGE PATTERN is implemented here" + "\n");
            newBuyer.added();
            newBuyer.showMenu();
        } else if (user_cat == 1) {
            if (is_seller == true) {
                System.out.print("\n The Entered User is a : Seller");
            } else {
                System.out.print("\n User does not exist!");
                allow_user = false;
                System.exit(0);
            }
            Person newSeller = new Seller(new MeatProductMenu());
            System.out.print("\n" + "BRIDGE PATTERN is implemented here" + "\n");
            newSeller.showMenu();
        }
        return newUser;

    }
}
