package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Bank xMenu = new Bank(50, 20, 10);
        xMenu.mainMenu();
    }
}

class Bank {
    int n20, n50, n100, sum, key;
    int mod100, mod50, mod20;
    int modX100, modX50, modX20;
    int comp100, comp50, comp20;
    int res100, res50, res20;
    Scanner scan = new Scanner(System.in);

    public Bank(int n20, int n50, int n100) {
        this.n20 = n20;
        this.n50 = n50;
        this.n100 = n100;
        this.sum = n20 * 20 + n50 * 50 + n100 * 100;
    }

    public int getN20() {
        return n20;
    }

    public void setN20(int n20) {
        this.n20 = n20;
    }

    public int getN50() {
        return n50;
    }

    public void setN50(int n50) {
        this.n50 = n50;
    }

    public int getN100() {
        return n100;
    }

    public void setN100(int n100) {
        this.n100 = n100;
    }

    public void mainMenu() {
        System.out.println("********ATM********\n1. Deposit money\n2. Withdraw money\n3. Check balance\nPress \"0\" to disconnect");
        key = scan.nextInt();
        switch (key) {
            case 1:
                depositMoney();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                checkMoney();
        }
    }

    public void depositMoney() {
        System.out.println("********ATM********\nChoose banknotes:\n1.20 dollars\n2.50 dollars\n3.100 dollars\nPress \"0\" to return");
        key = scan.nextInt();
        switch (key) {
            case 1: {
                System.out.println("How much?");
                key = scan.nextInt();
                n20 += key;
                sum += key * 20;
                depositMoney();
                break;
            }
            case 2: {
                System.out.println("How much?");
                key = scan.nextInt();
                n50 += key;
                sum += key * 50;
                depositMoney();
                break;
            }
            case 3: {
                System.out.println("How much?");
                key = scan.nextInt();
                n100 += key;
                sum += key * 100;
                depositMoney();
                break;
            }
            case 0: {
                mainMenu();
            }
        }
    }

    public boolean checkMoney() {
        return ((key <= sum)
                &&
                ((key % 100 % 50 % 20 == 0) || (key % 100 % 20 == 0) || (key % 50 % 20 == 0) || (key % 50 == 0) || (key % 20 == 0) || ((key - 50) % 20) == 0));
    }

    public void withdrawMoney() {

        System.out.println("Enter the requared amount of money");
        key = scan.nextInt();
        checkMoney();

        if (checkMoney() == true) {
            System.out.println("********ATM********\nTRANSACTION SUCCESFULL!");

            if (key % 100 == 0) {
                comp100 = key / 100;
                checkN100();

            } else {
                comp100 = key / 100;
                modX100 = key % 100;

                if (modX100 % 20 == 0) {
                    checkN20();

                } else if (modX100 % 50 == 0) {
                    checkN50();

                } else {
                    checkN20N50();
                }
            }
            int sumTransaction=0;
            sumTransaction+=res20*20+res50*50+res100*100;
            System.out.println("Amount of money: " + sumTransaction + " dollars\n20 dollars: " + res20 + "\n50 dollars: " + res50 + " \n100 dollars: " + res100);
            sum -= res20 * 20 + res50 * 50 + res100 * 100;
            this.n20 -= res20;
            this.n50 -= res50;
            this.n100 -= res100;
            mainMenu();

        } else System.out.println("Wrong amount of money!");
        mainMenu();
    }

    public void checkN100() {
        if (comp100 <= n100) {
            res100 = key / 100;

        } else {
            mod100 = comp100 - n100;
            res100 = comp100 - mod100;
            comp50 = (mod100 * 2);

            if (comp50 <= n50) {
                res50 = comp50;

            } else {
                mod50 = comp50 - n50;
                res50 = comp50 - mod50;
                comp20 = (mod50 * 5 / 2);

                if (comp20 <= n20) {
                    res20 = (mod50 * 5 / 2);

                } else {
                    System.out.println("Wrong amount of money. Restart ATM");
                }
            }
        }
    }

    public void checkN50() {
        if (comp100 <= n100) {
            res100 = key / 100;

        } else {
            mod100 = comp100 - n100;
            res100 = comp100 - mod100;
            comp50 = (mod100 * 2);

            if (comp50 <= n50) {
                res50 = comp50;

            } else {
                mod50 = comp50 - n50;
                res50 = comp50 - mod50;
                comp20 = (mod50 * 5 / 2);

                if (comp20 <= n20) {
                    res20 = (mod50 * 5 / 2);

                } else {
                    System.out.println("Wrong amount of money. Restart ATM");
                }
            }
        }
        int compx50;
        compx50 = modX100 / 50;
        res50 += compx50;

        if (res50 <= n50) {
            res50 = res50;

        } else {
            res20 += 5;

            if (res20 <= n20) {
                res50 -= 2;
            } else System.out.println("Wrong amount of money. Restart ATM");
        }
    }

    public void checkN20() {
        if (comp100 <= n100) {
            res100 = key / 100;

        } else {
            mod100 = comp100 - n100;
            res100 = comp100 - mod100;
            comp50 = (mod100 * 2);

            if (comp50 <= n50) {
                res50 = comp50;

            } else {
                mod50 = comp50 - n50;
                res50 = comp50 - mod50;
                comp20 = (mod50 * 5 / 2);

                if (comp20 <= n20) {
                    res20 = (mod50 * 5 / 2);

                } else {
                    checkMoney();
                }
            }
        }
        int compx20;
        compx20 = modX100 / 20;
        res20 += compx20;

        if (compx20 <= n20) {
            res20 = res20;

        } else {
            res50 += 2;

            if (res50 <= n50) {
                res20 -= 5;

            } else System.out.println("Wrong amount of money. Restart ATM");
        }
    }

    public void checkN20N50() {
        int compX100;
        if ((key - 50) % 20 == 0) {
            compX100 = key - 50;
            comp100 = compX100 / 100;
            if (comp100 <= n100) {
                res100 = comp100;
            } else {
                mod100 = comp100 - n100;
                res100 = comp100 - mod100;
                comp50 = (mod100 * 2);

                if (comp50 <= n50) {
                    res50 = comp50;
                } else {
                    mod50 = comp50 - n50;
                    res50 = comp50 - mod50;
                    comp20 = (mod50 * 5 / 2);

                    if (comp20 <= n20) {
                        res20 = (mod50 * 5 / 2);
                    } else {
                        System.out.println("Wrong amount of money. Restart ATM");
                    }
                }
            }
            modX20 = compX100 % 100;
            res50 += 1;
            if (res50 <= n50) {
                res20 += modX20 / 20;

                if (res20 <= n20) {
                    res20 = res20;

                } else {
                    res50 += 2;

                    if (res50 <= n50) {
                        res20 -= 5;

                    } else {
                        System.out.println("Wrong amount of money. Restart ATM");
                    }
                }
            } else {
                res20 += 5;
                if (res20 <= n20) {
                    res50 -= 2;
                    res20 += modX20 / 20;

                    if (res20 <= n20) {
                        res20 = res20;

                    } else {
                        res50 += 2;

                        if (res50 <= n50) {
                            res20 -= 5;

                        } else {
                            System.out.println("Wrong amount of money. Restart ATM");
                        }
                    }

                } else System.out.println("Wrong amount of money. Restart ATM");
            }

        } else System.out.println("Wrong amount of money. Restart ATM");
    }

    public void checkBalance() {
        System.out.println("********ATM********\nYour balance is " + sum + " dollars\nAmount of banknotes:" + "\n20 dollars: " + getN20() + "\n50 dollars: " + getN50() + "\n100 dollars: " + getN100() + "\nPress \"0\" to return");
        key = scan.nextInt();
        if (key == 0) {
            mainMenu();
        }
    }

}
