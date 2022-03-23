package com.cbsingh.map;

import com.cbsingh.ModelClasses.Employee;
import com.cbsingh.ModelClasses.StoredEmployee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashtable;
    private int size;

    public ChainedHashTable() {
        hashtable = new LinkedList[10];

        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee emp) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, emp));
        size++;
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);

        StoredEmployee storedEmployee = null;
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();

        while (iterator.hasNext()) {
            storedEmployee = iterator.next();
            if(storedEmployee.getKey().equals(key)) {
                return storedEmployee.getEmployee();
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee storedEmployee = null;
        int index = -1;

        while (iterator.hasNext()) {
            storedEmployee = iterator.next();
            index++;
            if(storedEmployee.getKey().equals(key)) {
                break;
            }
        }

        if(storedEmployee == null || ! storedEmployee.getKey().equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return storedEmployee.getEmployee();
        }
    }
    
    public void printHashTable() {
        for (int i = 0; i < hashtable.length; i++) {
            if(hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": Empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().getEmployee() + "->");
                }
                System.out.println("null");
            }
            
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee markWilson = new Employee("Mark", "Wilson", 3245);

        ChainedHashTable chainedHashTable = new ChainedHashTable();
        chainedHashTable.put("Jones", janeJones);
        chainedHashTable.put("Doe", johnDoe);
        chainedHashTable.put("Wilson", markWilson);
        chainedHashTable.put("Smith", marySmith);

        chainedHashTable.printHashTable();

        System.out.println(chainedHashTable.get("Smith"));

        chainedHashTable.remove("Jones");
        chainedHashTable.printHashTable();
    }
}
