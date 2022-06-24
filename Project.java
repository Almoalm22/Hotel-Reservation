package project;

import java.util.Scanner;

public class Project {

    public static void main(String[] args) {

        Scanner keyborad = new Scanner(System.in);

        String[][] Costumers = new String[5][4];
        System.out.println("-- -- The Costumer -- --");

// ID
        Costumers[0][0] = "1";
        Costumers[1][0] = "2";
        Costumers[2][0] = "3";
        Costumers[3][0] = "4";
        Costumers[4][0] = "5";
// Name
        Costumers[0][1] = "Sami";
        Costumers[1][1] = "Mohamed";
        Costumers[2][1] = "Khaled";
        Costumers[3][1] = "Nasser";

// Address 
        Costumers[0][2] = "Riyadh";
        Costumers[1][2] = "Jeddah";
        Costumers[2][2] = "Madinah";
        Costumers[3][2] = "Makkah";

// Account balance 
        Costumers[0][3] = "1000";
        Costumers[1][3] = "500";
        Costumers[2][3] = "2000";
        Costumers[3][3] = "1000";

        System.out.print("Enter your ID: ");
        int ID = keyborad.nextInt();
        if (ID == 5) {
            System.out.println("-- 5th uesr --");
            Scanner keyborad5 = new Scanner(System.in);
            System.out.print("Enter the 5th user name: ");
            Costumers[4][1] = keyborad5.nextLine();
            System.out.print("Enter the 5th user address: ");
            Costumers[4][2] = keyborad5.nextLine();
            System.out.print("Enter the 5th user account balance: ");
            Costumers[4][3] = keyborad5.nextLine();
        } else {
            System.out.println("Welcom Mr. " + Costumers[ID - 1][1]);
        }
        System.out.println("-- -- Rooms -- --");
        String[][] Room = new String[5][10];
        for (int matx = 0; matx < Room.length; matx++) {
            for (int maty = 0; maty < Room[matx].length; maty++) {
                if (9 == maty) {
                    Room[matx][maty] = (matx + 1) + "" + (maty + 1);
                } else {
                    Room[matx][maty] = (matx + 1) + "0" + (maty + 1);
                }
                System.out.println(Room[matx][maty]);
            }
        }
        System.out.println("-- -- Rooms preferences -- --");
        String[][] P_Room = new String[5][10];
        for (int matx = 0; matx < 5; matx++) {
            for (int maty = 0; maty < P_Room[matx].length; maty++) {
                if (9 == maty || 8 == maty) {
                    P_Room[matx][maty] = "Suit";
                } else if (7 == maty) {
                    P_Room[matx][maty] = "view, Double";
                } else if (6 == maty || 5 == maty) {
                    P_Room[matx][maty] = "view, Single";
                } else if (4 == maty || 3 == maty || 2 == maty) {
                    P_Room[matx][maty] = "Double";
                } else {
                    P_Room[matx][maty] = "Single";
                }
                System.out.println(Room[matx][maty] + ": " + P_Room[matx][maty]);
            }
        }
        System.out.println("-- -- booked room -- --");
        String[][] Booking = new String[5][10];
        for (int matx = 0; matx < 5; matx++) {
            for (int maty = 0; maty < Room[matx].length; maty++) {
                Booking[matx][maty] = "Available";
            }
        }
        for (int i = 0; i < 5; i++) {
            int x = (int) (Math.random() * 4);
            int y = (int) (Math.random() * 9);
            Booking[x][y] = "Unavailable";
            System.out.println(Room[x][y] + ": Unavailable");
        }
        System.out.println("-- -- Number of room(s) -- --");
        System.out.print("Desire room(s): ");
        int n_Room = keyborad.nextInt();
        int c_Room = 0, v_Room = 0;
        for (int i = 1; i <= n_Room; i++) {
            System.out.println("Choose your room(s) preferences:");
            System.out.println("1- Suit\n" + "2- Double\n" + "3- Single");
            c_Room = keyborad.nextInt();

            if (c_Room == 2 || c_Room == 3) {
                System.out.println("view?");
                System.out.println("1- Yes\n" + "2- No");
                v_Room = keyborad.nextInt();
            }
            System.out.println("-- -- booking room(s) -- --");

            System.out.print("Flour: ");
            int F_Room = keyborad.nextInt();
            F_Room = (F_Room - 1);
            System.out.print("Room: ");
            int R_Room = keyborad.nextInt();
            R_Room = (R_Room - 1);

            if ("Available".equals(Booking[F_Room][R_Room])) {
                Booking[F_Room][R_Room] = "Unavailable";
                System.out.println(Room[F_Room][R_Room] + ": will be unavailable");
            } else {
                System.out.println(Room[F_Room][R_Room] + ": unavailable");
                System.out.println("Try again");
            }
        }
        System.out.println("-- -- Financial -- --");
        int B_s = 100;
        int B_D = 150;
        int B_V = 75;
        int B_S = 300;
        double T = 0;
        double VAT = 0.05;

        System.out.print("Enter the night(s): ");
        int n = keyborad.nextInt();
        if (c_Room == 1) {
            T = ((n * B_S) + ((n * B_S) * VAT));
            System.err.println(T);
        } else if (c_Room == 2 && v_Room == 1) {
            T = ((n * (B_D + B_V)) + (n * (B_D + B_V)) * VAT);
            System.err.println(T);
        } else if (c_Room == 2 && v_Room == 2) {
            T = ((n * (B_D)) + (n * (B_D)) * VAT);
            System.err.println(T);
        } else if (c_Room == 3 && v_Room == 1) {
            T = ((n * (B_s + B_V)) + (n * (B_s + B_V) * VAT));
            System.err.println(T);
        } else if (c_Room == 3 && v_Room == 2) {
            T = ((n * (B_s)) + (n * (B_s)) * VAT);
            System.err.println(T);
        }
        double[] AC = new double[5];
        AC[0] = 1000;
        AC[1] = 500;
        AC[2] = 2000;
        AC[3] = 1000;
        
        
        if (ID == 5) {
            System.out.print("Enter the 5th user account balance: ");
            AC[4] = keyborad.nextDouble();
        }
        if (T <= AC[ID - 1]) {
            AC[ID - 1] = AC[ID - 1] - T;
            Costumers[ID - 1][3] = Double.toString(AC[ID - 1]);
            System.out.println("New account balance: " + Costumers[ID - 1][3]);
            System.out.println("Booking confirmed");
        } else {
            System.out.println("Not enough money");
            System.err.println("Booking cancelled");
        }
                    System.out.println("-- -- Summary -- --");
            System.out.println("ID: " + Costumers [ID - 1][0] );
            System.out.println("Name: " + Costumers [ID - 1][1] );
            System.out.println("Address: " + Costumers [ID - 1][2] );
            System.out.println("Main Account Balance: " + AC[ID - 1] + T);
            System.out.println("Number of Room(s): " + n_Room);
            System.out.println("New Account Balance: " + Costumers[ID - 1][3]);
            System.out.println("The booking value: " + T);
    }
}
