import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank xMenu = new Bank();
        xMenu.mainMenu();
    }
}

class Bank {
    int x20, x50, x100;
    int y100, y50;
    int key;
    int sum = 0;

    Scanner scan = new Scanner(System.in);


    Bank() {
        x20 = 0;
        x50 = 0;
        x100 = 0;
    }

    void mainMenu() {

        Bank xMenu = new Bank();

        String mainMenuString = ("********ATM********\n1. Deposit money\n2. Withdraw money\nPress \"0\" to disconnect");
        System.out.println(mainMenuString);

        key = scan.nextInt();

        if (key == 1) {
            xMenu.depositMoney();
        }
        if (key == 2) {
            xMenu.takeMoney();
        }
    }

    private void depositMoney() {

        Bank xMenu = new Bank();

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
    }

    boolean checkValue(int c) {
        if ((key % 100 % 50 % 20 == 0) || (key % 100 % 20 == 0) ||
                (key % 50 % 20 == 0) || (key % 50 == 0) || (key % 20 == 0)) {return true}
                else false
    }

    private void takeMoney() {

        System.out.println("Enter the required amount of money");
        key = scan.nextInt();
        Bank xMenu = new Bank();
        xMenu.checkValue(key);
        {


            if (key % 100 == 0) {
                x100 = key / 100;
            } else {
                x100 = key / 100;
                y100 = key % 100;

                if (y100 % 20 == 0) {
                    x20 = y100 / 20;
                } else if (y100 % 50 == 0) {
                    x50 = y100 / 50;
                } else {
                    y50 = y100 / 50;
                    x20 = y50 / 20;
                }

            }

            System.out.println("100 dollars: " + x100 + "\n\n50 dollars: " + x50 + "\n\n20 dollars: " + x20);
        }
    }
}
