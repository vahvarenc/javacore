package util;

import dynamicarray.DynamicArray;
import dynamicarray.DynamicArrayImpl;

public class StringUtil {

    /**
     * Parses the specified inputText and divides it into tokens by the specified delimiter.
     *
     * @param inputText  the string to be splited by the specified delimiter
     * @param delimiter  the delimiter by which the specified inputText  will be splitted.
     * @return the array of strings computed by splitting this string
     *          around matches of the given regular expression.
     */
    public static String[] split(String inputText, char delimiter) {
        DynamicArray<String> dynamicArray = new DynamicArrayImpl<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = 0, m = 0;
        lab:
        while(i < inputText.length()){
            while(inputText.charAt(i) == delimiter){
                i++;
                if(i >= inputText.length()){
                    break lab;
                }
            }
            n = i;
            lab1:
            while(inputText.charAt(i) != delimiter) {
                i++;
                if(i >= inputText.length()){
                    break lab1;
                }
            }
            m = i;
            dynamicArray.add(subString(inputText, n, m-n));
        }

        String [] stringArray = new String[dynamicArray.size()];
        for (int j = 0; j < dynamicArray.size(); j++) {
            stringArray[j] = dynamicArray.get(j);
        }
        return stringArray;
    }

    /**
    * Returns a new string that is a substring of the spcified inputText. The
    * substring begins at the specified <code>beginIndex and
    * extends to the character at index <code>endIndex - 1.
    * Thus the length of the substring is <code>endIndex-beginIndex.
    * Examples:
    * <blockquote><pre>
    * "hamburger".substring(4, 8) returns "urge"
    * "smiles".substring(1, 5) returns "mile"
    *
    * @param      inputText    the string substring of wich must be returned
    * @return     the specified substring.
    * @exception IndexOutOfBoundsException  if the
    *             beginIndex is negative, or
    *             endIndex is larger than the length of
    *             this String object, or
    *             beginIndex is larger than
    *             endIndex.
    */
    public static String subString(String inputText, int startIndex, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < startIndex + length; i++) {
            char ch = inputText.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * Returns a copy of the specified str, with leading and trailing whitespace
     * omitted.
     * @param str the String will be trimmed.
     * @return  A copy of the string with leading and trailing white
     *          space removed, or this string if it has no leading or
     *          trailing white space.
     */
    public String trim(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        char ch = str.charAt(0);
        while(str.charAt(0) == ' '){

            sb.deleteCharAt(0);
            str = sb.toString();
        }

        while(str.charAt(str.length()-1) == ' '){

            sb.deleteCharAt(str.length()-1);
            str = sb.toString();
        }

        return str;
    }

    /**
     * Parses the string argument as a signed decimal integer. The
     * characters in the string must all be decimal digits, except
     * that the first character may be an ASCII minus sign.
     *
     * @param s a String containing the int representation to be parsed
     * @return     the integer value represented by the argument in decimal.
     * @exception NumberFormatException  if the string does not contain a
     *               parsable integer.
     */
    public static int parseInt(String s) throws NumberFormatException{
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch <= 57 && ch >= 48){
                number = number * 10 + ch - 48;
            }else{
                throw new NumberFormatException();
            }

        }

        return number;
    }

    public static int parseExpression(String s) {
        s = skipSymbol(s, ' ');
        String[] a, b;
        a = split(s, '+');
        int partialSum, totalSum = 0;
        for (int i = 0; i < a.length; i++) {
            b = split(a[i], '-');
            if (s.charAt(0) == '-' && i == 0) {
                partialSum = -parseInt(b[0]);
            } else {
                partialSum = parseInt(b[0]);
            }
            for (int j = 1; j < b.length; j++) {
                partialSum -= parseInt(b[j]);
            }
            totalSum += partialSum;
        }
        return totalSum;
    }

    public static String skipSymbol(String s, char ch) {
        String result = "";
        String[] split = split(s, ch);
        for (String item : split) {
            result += item;
        }
        return result;
    }

    public String toLowerCase(String text){
        StringBuilder sb = new StringBuilder();
        String string;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(ch <= 90 && ch >= 65) {
                ch ^= 32;
            }
            sb.append(ch);
        }
        string =  sb.toString();
        return string;
    }

    public String toUpperCase(String text){
        StringBuilder sb = new StringBuilder();
        String string;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            sb.append((ch >= 'a' && ch <= 'z') ? ch ^ 32 : ch);
        }
        string =  sb.toString();
        return string;
    }

    private String changeCase(String text, char startIndex, char endIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            char ch = text.charAt(i);
            ch ^= 32;
            sb.append(ch);
        }
        return sb.toString();
    }
}