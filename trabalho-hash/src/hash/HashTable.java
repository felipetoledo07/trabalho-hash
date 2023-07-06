package hash;

import tree.Tree;

public class HashTable {

    private Tree[] buckets;

    public HashTable() {
        this.buckets = new Tree[3];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new Tree();
        }
    }

    private int hash(int key) {
        return key % this.buckets.length;
    }


    public void put(int key, Object value) {
        int b = hash(key);
        this.buckets[b].insert(key, value);
    }

    public Object get(int key) {
        int b = hash(key);
        return this.buckets[b].get(key);
    }

    public void set(int key, String value) {
        int b = hash(key);
        Object currentValue = this.buckets[b].get(key);

        if (currentValue != null) {
            this.buckets[b].remove(key);
        }
        this.put(key, value);

    }

    @Override
    public String toString() {
        String out = "{\n";
        for (int i = 0; i < this.buckets.length; i++) {
            out += this.buckets[i].toString() + "\n";
        }
        return out + "}";
    }

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        System.out.println(hashTable);

        hashTable.put(3, "a");
        hashTable.put(1, "b");
        hashTable.put(2, "c");
        hashTable.put(23, "d");
        hashTable.put(4, "e");
        hashTable.put(5, "f");
        hashTable.put(9, "g");
        hashTable.put(6, "h");
        hashTable.put(12, "j");
        hashTable.put(8, "k");
        hashTable.put(21, "l");
        hashTable.put(98, "m");
        hashTable.put(24, "n");
        hashTable.put(0, "o");

        System.out.println(hashTable);

        hashTable.set(0, "p");

        System.out.println(hashTable);

        System.out.println(hashTable.get(0));

    }
}
