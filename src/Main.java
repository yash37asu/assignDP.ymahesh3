package src;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        System.out.println("Hello");
        Facade newFacade = new Facade();
        newFacade.login();
    }
}

