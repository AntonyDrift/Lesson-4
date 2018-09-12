import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank xMenu = new Bank();
        xMenu.mainMenu();

    }
}


class Bank {
    int a = 0;


    void mainMenu() {

        String mainMenuString = ("********ATM********\n1. Deposit money\n2. Withdraw money\nPress \"0\" to disconnect");
        System.out.println(mainMenuString);
        Bank xMenu = new Bank();
        Scanner scan = new Scanner(System.in);
        int key = 0;
        key = scan.nextInt();


        if (key == 1) {
            xMenu.depositMoney();
        }
        if (key == 2) {
            xMenu.takeMoney();
        }
    }

    private int depositMoney() {
        int sum = 0;
        Bank xMenu = new Bank();
        Scanner scan = new Scanner(System.in);
        int key = 0;
        String depositMoneyString = ("********ATM********\nChoose banknotes:\n1.20 dollars\n2.50 dollars\n3.100 dollars\n4.Check balance\n9.Return to main menu");

        do {
            System.out.println(depositMoneyString);
            key = scan.nextInt();
            switch (key) {
                case 1:
                    System.out.println("How much?");
                    key = scan.nextInt();
                    sum += key * 20;
                    System.out.println("You put " + key * 20 + " dollars to the ATM");
                    break;
                case 2:
                    System.out.println("How much?");
                    key = scan.nextInt();
                    sum += key * 50;
                    System.out.println("You put " + key * 50 + " dollars to the ATM");
                    break;
                case 3:
                    System.out.println("How much?");
                    key = scan.nextInt();
                    sum += key * 100;
                    System.out.println("You put " + key * 100 + " dollars to the ATM");
                    break;
                case 4:
                    System.out.println("Your balance is " + sum + " dollars");
                    break;
                case 9:
                    xMenu.mainMenu();
            }
        } while (key != 9);
        return sum;
    }

    int takeMoney() {

        Bank xMenu = new Bank();
        Scanner scan = new Scanner(System.in);
        int key = 0;
        int x20 = 0;
        int x50 = 0;
        int x100 = 0;
        int sum = 0;

        System.out.println("Enter the required amount of money");
        key=scan.nextInt();
      
        System.out.println("");

    }
}
