package controller;

import inventory.Item;
import vendingMachine.VendingMachine;

import java.util.Scanner;

public class VendingMachineController {
    private final VendingMachine vendingMachine;
    private Scanner scanner;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean runWhile = true;

        while (runWhile) {
            if (vendingMachine.getTransactionComplete()) {
                runWhile = false;
                vendingMachine.setTransactionComplete(false);
                continue;
            }

            displayInventory();
            System.out.println();

            switch (vendingMachine.getMachineStateType()) {
                case Idle -> {
                    System.out.println("Insert Money");
                    System.out.println("Cash/UPI/Card");
                    System.out.println("Enter amount through keypad");

                    int moneyEntered = scanner.nextInt();
                    if (moneyEntered <= 0) {
                        System.out.println("Please enter valid amount!!");
                        continue;
                    }
                    vendingMachine.getMachineState().insertMoney(moneyEntered);
                }
                case HasMoney -> {
                    System.out.println("Choose from the following.");
                    System.out.println("1. Add more money");
                    System.out.println("2. Select item");
                    System.out.println("3. Cancel transaction");

                    int input = scanner.nextInt();
                    while (input < 1 || input > 3) {
                        System.out.println("Wrong input!!");
                        System.out.println("Please choose from options: 1, 2 & 3");
                        input = scanner.nextInt();
                    }

                    switch (input) {
                        case 1 -> {
                            System.out.println("Enter amount through keypad");
                            int moneyEntered = scanner.nextInt();
                            if (moneyEntered <= 0) {
                                System.out.println("Please enter valid amount!!");
                                continue;
                            }
                            vendingMachine.getMachineState().insertMoney(moneyEntered);
                        }
                        case 2 -> {
                            System.out.println("Enter item code");
                            int itemCode = scanner.nextInt();
                            vendingMachine.getMachineState().selectItem(itemCode);
                        }
                        case 3 -> {
                            System.out.println("Cancelling the transaction and processing your refund");
                            vendingMachine.getMachineState().cancelTransaction();
                            runWhile = false;
                        }
                    }

                }
                case OutOfService -> {
                    System.out.println("Out of service");
                    runWhile = false;
                }
                default -> {
                    System.out.println("No user interaction for this state!!");
                    runWhile = false;
                }
            }
        }
    }

    public void fillInventory() {
        // 4 rows, 5 column, 3 items in each itemcolumn

        int itemCode;
        for (int i = 1; i <= 2; i++) {
            itemCode = 100 * i;
            for (int j = 1; j <= 3; j++) {
                itemCode = itemCode + 1;
                int price = (int) (Math.random() * 10);
                price = (price + 1) * 10;
                Item item = new Item(itemCode, "", price);
                vendingMachine.insertItem(itemCode, item, 3);
            }
        }
    }

    public void displayInventory() {
        vendingMachine.displayInventory();
    }
}
