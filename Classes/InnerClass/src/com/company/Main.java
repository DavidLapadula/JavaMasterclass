package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    /*
        Notes
            - Nest class in another class
                - Static: associated class with out class. Packaged with outer class, but cannot access non-static members without first making an instance of the class
                - Non static: inner class
                    - Like an engine with gearbox class and gear class
                    - Inner class is usually private so that it cannot be accessed.
                    - Public interface does not expose inner class. Only ever acccess through outer class
                    - Encapsualtion increased: only outer class knows details of inner class
                - Local: inner class inside scope block (method)
                    - Only available within that block
                    - Declared within box using them
                    - Never used in a shared method
                - Anonymous: nested inner class without a name
                    - Local class without a name
                    - Used for attaching on click method with multiple buttons as they all have different functionality
                    - All different functionality can be different instances of an inner class
     */

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);

        /*
            Nested Class
            Do not need if gears initialized in constructor
         */
         mcLaren.addGear(1, 5.3);
         mcLaren.addGear(2, 10.6);
         mcLaren.addGear(3, 15.9);
         mcLaren.operateClutch(true);
         mcLaren.changeGear(1);
         mcLaren.operateClutch(false);
         mcLaren.changeGear(2);


        /*
            Inner class
             - Implements interface of button instance
         */
        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("Attached");
            }

            @Override
            public void onClick (String title){
                System.out.println(title + " was clicked");
            }
        }

        /*
            Use of inner class
            - On click listener set, and calling onClick will fire the overridden onlick method initially created in the button class
         */
        btnPrint.setOnClickListener(new ClickListener());


        /*
            Use of anonymous class
            - No new class instantiated
            - Declared in expression passed to on click listener
         */
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });

        listen();
    }

        private static void listen() {
            boolean quit = false;
            while (!quit) {
                int choice = scanner.nextInt();
                switch(choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        btnPrint.onClick();
                }
            }
        }
}
