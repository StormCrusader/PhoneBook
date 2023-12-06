// Programmer: Farshid Miri, Medet Karl
// Class: CS &145
// Date: 10/30/2023
// Assignment 2: Phone Book
// Purpose: Creating a searchable phone book. 

package PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBookManager {
    ListNode head;

    public PhoneBookManager() {
        this.head = null;
    }

    public void addEntry(String name, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(name, address, city, phoneNumber);

        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void sortAlphabetically() {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }

        Collections.sort(listNodes, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.name.compareTo(node2.name);
            }
        });

        ListNode sortedHead = null;
        ListNode sortedTail = null;

        for (ListNode node : listNodes) {
            if (sortedHead == null) {
                sortedHead = node;
                sortedTail = node;
            } else {
                sortedTail.next = node;
                sortedTail = node;
            }
        }

        sortedTail.next = null;
        head = sortedHead;

        System.out.println("The list is now sorted!");
        printList();
    }

    public void printList() {
        ListNode temp = head;
        if (temp == null)
            System.out.println("the list is currently empty, please add new entries");
        while (temp != null) {
            System.out.println("Name: " + temp.name);
            System.out.println("Address: " + temp.address);
            System.out.println("City: " + temp.city);
            System.out.println("Phone Number: " + temp.phoneNumber);
            System.out.println("---------------------------");
            temp = temp.next;
        }
    }

    public void removeEntry(String name) {
        if (head == null) {
            System.out.println("Phone book is empty. Cannot remove entry.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        ListNode temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Entry not found.");
        }
    }

    public void promptUserAdd() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        addEntry(name, address, city, phoneNumber);
    }

    public void promptUserRemove() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name you want to remove: ");
        String name = scanner.nextLine();

        removeEntry(name);
    }
}
