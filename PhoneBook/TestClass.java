package PhoneBook;

import java.util.Scanner;

// TestClass.java
public class TestClass {
    public static void main(String[] args) {
        PhoneBookManager phonebook = new PhoneBookManager();
        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println();
            System.out.println("welcome to phonebook, here's the menu: ");
            System.out.println("Input S to print the list");
            System.out.println("Input A to add an entry");
            System.out.println("Input R to remove an entry");
            System.out.println("Input sort to sort the list");
            System.out.println("Input done if you're done");

            Scanner input = new Scanner(System.in);
            String userInput = input.next();

            switch (userInput.toLowerCase()) {
                case "s":
                    phonebook.printList();
                    System.out.println();
                    break;
                case "a":
                    phonebook.promptUserAdd();
                    break;
                case "r":
                    phonebook.promptUserRemove();
                    break;
                case "sort":
                    phonebook.sortAlphabetically();
                    break;
                case "done":
                    continueProgram = false;
                    break;

            }

        }
    }

}
