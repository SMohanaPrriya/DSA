package datastructures.Hashtables;

public class KeyValuePair {
    private String key;
    private int value;


    //getter methods
    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    //parameterized constructor
    public KeyValuePair(String key, int value) {
        this.key = key;
        this.value = value;
    }

}
