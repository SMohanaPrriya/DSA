package datastructures.Arrays;

public class ReverseString {

    public String reverseStringWithSB(String str) {
        //Edge: empty string, null string, one word string
        if (str == null || str.isEmpty() || str.length()==1) {
            return str;
        }

        //not necessary to store? remove temp and print the reverse
        StringBuilder temp = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            temp.append(str.charAt(i));
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        String testString = "Hello, let's prep for the interview!";
        System.out.println(new ReverseString().reverseStringWithSB(testString));
        //type 2: convert string to char array and use the charAt function for the same.
    }

}
