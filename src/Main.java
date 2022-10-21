package src;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        boolean loop = true;
        @SuppressWarnings("resource")
        Scanner stayLoop = new Scanner(System.in);
        while (loop) {
            System.out.println("\nHello, Yashkumar Maheshwari's PBTS system begins");
            Facade newFacade = new Facade();
            newFacade.login();

            ProductIterator newPIter = new ProductIterator();
            System.out.println("\nITERATOR PATTERN implementation begins here" + "\n");
            System.out.println("Select any product: ");

            ListIterator LisIter;

            int temp = 1;

            for (LisIter = newPIter; LisIter.hasNext(); ) {
                String item = (String) LisIter.Next();
                System.out.println(temp + ". " + item);
                temp += 1;
            }

            newFacade.AttachProductToUser();

            System.out.print("\n" + "VISITOR PATTERN implementation begins here" + "\n");
            NodeVisitor nv = new Reminder();

            nv.visitProduct(new Product());
            nv.visitTrading(new Trading());

            System.out.print("\n Now: \n To login again PRESS:- 1\n To exit PRESS:- 2 \n");
            int choice = stayLoop.nextInt();

            if (choice == 2) {
                System.out.print("\n You have exited the system!");
                System.exit(0);
            }
        }
    }
}

