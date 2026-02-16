class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CustomLinkedList {
    public Node head = null;

    public void insert(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void insertAtMiddle(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        int count = nodeCount();
        int mid = count / 2;

        Node newNode = new Node(data);

        if (mid == 0) {   // Only one element
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < mid; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteFromMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {   // Only one element
            head = null;
            return;
        }

        int count = nodeCount();
        int mid = count / 2;

        if (mid == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; i < mid; i++) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    public int nodeCount() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
        }
    }

    public void delete() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }
}

public class LinkedListImpl {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.deleteFromMiddle();

        list.printList();
    }
}
