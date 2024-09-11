import java.util.*;

class CustomArrayList {
    private int[] data;
    private int size;

    public CustomArrayList() {
        data = new int[10];  // Initial capacity
        size = 0;
    }

    // Add an element to the ArrayList
    public void add(int value) {
        if (size >= data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = value;
    }

    // Remove an element from a specific index
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
    }

    // Check if an element exists in the ArrayList
    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Retrieve the size of the ArrayList
    public int size() {
        return size;
    }

    // Iterate through the ArrayList and print its elements
    public void printElements() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public void sort() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(data[i]);
        }
        Collections.sort(arrayList);

        // Copy back the sorted elements to the data array
        for (int i = 0; i < size; i++) {
            data[i] = arrayList.get(i);
        }
    }
}

class CustomHashMap {
    private class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] data;
    private int size;

    public CustomHashMap() {
        data = new Entry[10];  // Initial capacity
        size = 0;
    }

    // Add key-value pairs to the HashMap
    public void put(String key, int value) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                data[i].value = value;
                return;
            }
        }


        if (size >= data.length) {
            Entry[] newData = new Entry[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = new Entry(key, value);
    }

    // Retrieve the value associated with a specific key
    public Integer get(String key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                return data[i].value;
            }
        }
        return null;  // Key not found
    }

    // Check if a key exists in the HashMap
    public boolean exists(String key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Iterate through the HashMap and print its key-value pairs
    public void printElements() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i].key + ": " + data[i].value);
        }
    }
}

class CustomLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    // Add a node to the beginning of the list
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add a node to the end of the list
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Delete a node with a specific value
    public void delete(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    // Search for a node with a specific value
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Print the elements in the LinkedList
    public void printElements() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class CustomStack {
    private ArrayList<Integer> data;

    public CustomStack() {
        data = new ArrayList<>();
    }

    // Push an element onto the stack
    public void push(int value) {
        data.add(value);
    }

    // Pop an element from the stack
    public int pop() {
        if (data.size() == 0) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return data.size() == 0;
    }

    // Peek at the top element of the stack without removing it
    public int peek() {
        if (data.size() == 0) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    // Print the stack elements
    public void printElements() {
        System.out.println(data);
    }
}

class CustomQueue {
    private LinkedList<Integer> data;

    public CustomQueue() {
        data = new LinkedList<>();
    }

    // Enqueue (add) an element to the queue
    public void enqueue(int value) {
        data.addLast(value);
    }

    // Dequeue (remove) an element from the queue
    public int dequeue() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        }
        return data.removeFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Retrieve the size of the queue
    public int size() {
        return data.size();
    }

    // Print the queue elements
    public void printElements() {
        System.out.println(data);
    }
}

public class Main {
    public static void main(String[] args) {
        // ArrayList Operations
        CustomArrayList arrList = new CustomArrayList();
        arrList.add(30);
        arrList.add(10);
        arrList.add(20);

        arrList.remove(1);
        System.out.println("ArrayList contains 20? " + arrList.exists(20));
        System.out.println("ArrayList size: " + arrList.size());
        arrList.printElements();

        System.out.println("Before sorting:");
        arrList.printElements();

        // Sort the ArrayList
        arrList.sort();

        System.out.println("After sorting:");
        arrList.printElements();

        // HashMap Operations
        CustomHashMap map = new CustomHashMap();
        map.put("John", 100);
        map.put("Jane", 200);
        System.out.println("Value for 'Jane': " + map.get("Jane"));
        System.out.println("HashMap contains key 'John'? " + map.exists("John"));
        map.printElements();

        // LinkedList Operations
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.addFirst(100);
        linkedList.addLast(200);
        linkedList.addLast(300);
        linkedList.delete(200);
        System.out.println("LinkedList contains 200? " + linkedList.search(200));
        linkedList.printElements();

        // Stack Operations
        CustomStack stack = new CustomStack();
        stack.push(5);
        stack.push(10);
        stack.pop();
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack top: " + stack.peek());
        stack.printElements();

        // Queue Operations
        CustomQueue queue = new CustomQueue();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.dequeue();
        System.out.println("Queue is empty? " + queue.isEmpty());
        System.out.println("Queue size: " + queue.size());
        queue.printElements();
    }
}
