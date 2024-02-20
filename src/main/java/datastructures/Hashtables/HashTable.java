package datastructures.Hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable {

    int length;
    int itemCount;
    int capacityOfHashtable;
    //similar to int[] a;
    ArrayList<KeyValuePair>[] hashtable;

    //hash computation as given in the course
    private int _hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % hashtable.length;
        }
        return hash;
    }

    //what we need - constructor, put, get

    //constructor
    HashTable(int capacity) {
        length = 0;
        capacityOfHashtable = capacity;
        hashtable = new ArrayList[capacity];
    }

    public int getHashTableSize() {
        return length;
    }

    public void put(String key, int value) {
        int hashValue = _hash(key);
        if(hashtable[hashValue] == null) {
            ArrayList<KeyValuePair> arrayAtHash = new ArrayList<>();
            hashtable[hashValue] = arrayAtHash;
            length++;
        }
        KeyValuePair newPair = new KeyValuePair(key, value);
        hashtable[hashValue].add(newPair);
        itemCount++;
    }


    public Integer get(String key) {
        int hashValue = _hash(key);
        List<KeyValuePair> bucket = hashtable[hashValue];
        if(bucket!=null) {
            for(KeyValuePair keyval : bucket) {
                if(keyval.getKey().equals(key)) {
                    return keyval.getValue();
                }
            }
        }
        return null;
    }

    public String[] getKeySet() {
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < capacityOfHashtable; i++) {
            if(hashtable[i] != null) {
                for( int j = 0; j < hashtable[i].size(); j++) {
                    temp.add(hashtable[i].get(j).getKey());
                }
            }
        }
        return temp.toArray(new String[0]);

    }

    public static void main(String[] args) {
        HashTable newHashTable = new HashTable(10);
        newHashTable.put("Ottawa", 1);
        newHashTable.put("Toronto", 100);
        // following - overflow entry - Size 2 - same hash as toronto.
        // newHashTable.put("Montreal", 80);
        newHashTable.put("Montreal!", 80); //Size 3
        System.out.println(newHashTable.get("Toronto"));
        System.out.println("Size of hashtable: "+ newHashTable.getHashTableSize());
        System.out.println("Keys present: "+ Arrays.toString(newHashTable.getKeySet()));
    }

}
