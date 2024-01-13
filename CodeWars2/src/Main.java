import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        System.out.println(rgb(0, 0, 0)); //"000000"
//        System.out.println(rgb(1, 2, 3)); //"000000"
//        System.out.println(rgb(-20, 275, 125)); //00FF7D
//        System.out.println(sortArray(new int[]{ 5, 3, 1, 8, 0 })); // 1 3 5 8 0
//        System.out.println(Arrays.toString(solution("abc"))); // =>  ['ab', 'c_']
//        System.out.println(Arrays.toString(solution("abcdef"))); // =>  ['ab', 'cd', 'ef']
//        System.out.println(high("a bc c z")); // =>  z
//        System.out.println(high("man i need a taxi up to ubud")); //taxi
//        System.out.println(letterCount("ASHJGKLKFGKKJHKAJSGADAASKGAJKLAJDLGAKFGKALSJ"));
//        System.out.println(solve("coDEC")); // "CODEC"
//        System.out.println(solve("coDE")); // = "code". Upper == lowercase. Change all to lowercase.
//        System.out.println(solve("wmTnJEsESXdvmKFFaCJRHjLrl")); // = "code". Upper == lowercase. Change all to lowercase.
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        System.out.println(deleteDup(list));
//        int num = 2;
//        int step = 10;
//        System.out.println(func(num, step));
//        System.out.println("------------");
//        System.out.println("A");
//        String s = "a";
//        System.out.println(s);
//        System.out.println((char) (s.charAt(0) + 5));
//        System.out.println("A"+ (char) (32) + "B");
////        System.out.print("A"+ " " + "B");
//        System.out.print((char) (13));
//        System.out.print("------------");
//        System.out.println(isPalindrome(121)); //true
//        System.out.println(isPalindrome(-121)); //false
//        System.out.println(isPalindrome(12421)); //true
//        System.out.println(isPalindrome(123421)); //false

//        System.out.println(isPalindromeNotString(12421)); //true
//        System.out.println(isPalindromeNotString(123421)); //false
//        System.out.println(isPalindromeNotString(1410110141)); //true
//        System.out.println(isMatch("ab", "a."));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("aa", ".*"));
//        System.out.println(solutionArr(new int[]{1,2,3}, new int[]{4,5,6})); //9
//        System.out.println(solutionArr(new int[]{10, 20, 10, 2}, new int[]{10, 25, 5, -2})); // -16.5
//        System.out.println(addBig("000091", "0009")); // -> "1100");
//        System.out.println(addBig("101", "100")); // -> "201");
//        System.out.println(addBig("63829983432984289347293874", "90938498237058927340892374089")); // -> "91002328220491911630239667963");
//        System.out.println(incrementString("foo")); // -> "foo1");
//        System.out.println(incrementString("foo01")); // -> "foo02");
//        System.out.println(incrementString("foo0042")); // -> "foo0043");
//        System.out.println(incrementString("foo99")); // -> "foo100");
//        System.out.println(incrementString("foo099")); // -> "foo100");
//        System.out.println(incrementString("999")); // -> "1000");
//        System.out.println(singlePermutations("ab")); // ['ab', 'ba']
//        System.out.println(singlePermutations("abc")); // ['abc','acb','bac','bca','cab','cba']
//        System.out.println(singlePermutations("aabb")); // ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
//        System.out.println(singlePermutations("aaaab")); // ['aaaab', 'aaaba', 'aabaa', 'abaaa', 'baaaa']
        System.out.println(singlePermutations("abcd")); // ['aaaab', 'aaaba', 'aabaa', 'abaaa', 'baaaa']

    }

//    In this kata, your task is to create all permutations of a non-empty input string and remove duplicates, if present.
//    Create as many "shufflings" as you can!
//    With input 'a':
//    Your function should return: ['a']
//    With input 'ab':
//    Your function should return ['ab', 'ba']
//    With input 'abc':
//    Your function should return ['abc','acb','bac','bca','cab','cba']
//    With input 'aabb':
//    Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']

    public static List<String> singlePermutations(String s) {
        List<String> list = new ArrayList<>();
        if (s.length()==1) {
            list.add(s);
            return list;
        }
        Set<String> result = new HashSet<>();
        String[] arr = s.split("");
        int index = 0;
        while (index<=arr.length) {
//            result.add(Arrays.stream(arr).collect(Collectors.joining()));
            for (int j = 0; j < arr.length-1 ; j++) {
                for (int i = j+1; i < arr.length - 1; i = i + 1) {
                    String temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    result.add(Arrays.stream(arr).collect(Collectors.joining()));
                }
            }
            for (int i = 0; i < s.length(); i++) {
                arr[i] = String.valueOf(s.charAt(i));
            }
                index++;
            if (String.valueOf(s.charAt(index)).equals("d")) {
                System.out.println("d");
            }
            if (index < arr.length) {
                String temp1 = arr[0];
                arr[0] = String.valueOf(s.charAt(index));
                arr[index] = temp1;
            }
            result.add(Arrays.stream(arr).collect(Collectors.joining()));
        }
        return result.stream().toList();
    }
//    Your job is to write a function which increments a string, to create a new string.
//    If the string already ends with a number, the number should be incremented by 1.
//    If the string does not end with a number. the number 1 should be appended to the new string.
//
//    foo -> foo1
//    foo0042 -> foo0043
//    foo9 -> foo10
//    foo099 -> foo100

    public static String incrementString(String str) {
        if (str.equals("")) return "1";
        char chr = str.charAt(str.length()-1);
        if (chr < 48 || chr > 57) return str+1;
        int index = str.length()-1;
        StringBuilder result = new StringBuilder();
        char currChar = str.charAt(index);
        while (Character.isDigit(currChar)) {
            if (str.charAt(index) < 57)
                return str.substring(0,str.length()-1-result.length()) + (Character.getNumericValue(currChar) + 1) + result;
            else if (str.charAt(index) == 57 ) result.append(0);
            index--;
            if (index == -1) return  "1" + result;
            else currChar = str.charAt(index);
        }
        return str.substring(0,str.length()-result.length()) + 1 + result;
    }

//    public static String incrementString(String str) {
//        if (str.equals("")) return "1";
//        char chr = str.charAt(str.length()-1);
//        if (chr < 48 || chr > 57) return str+1;
//        if (str.charAt(str.length()-2) > 57) return str.substring(0,str.length()-1) +
//                (Character.getNumericValue(chr) + 1);
//        StringBuilder numSb = new StringBuilder();
//        int index = str.length()-1;
//        while (Character.isDigit(str.charAt(index))) numSb.append(str.charAt(index--));
//        String numberStr = numSb.reverse().toString();
//        int number = Integer.parseInt(numberStr);
//        int sumZero = numberStr.length() - String.valueOf(number).length();
//        if (String.valueOf(number).matches("9+") && sumZero < 2)
//            return str.substring(0, str.length()-numberStr.length()) + (number + 1);
//        StringBuilder resultSb = new StringBuilder();
//        for (int i = 0; i < sumZero; i++) {
//            resultSb.append("0");
//        }
//        return str.substring(0, str.length()-numberStr.length())+ resultSb +(number+1);
//    }

//    We need to sum big numbers and we require your help.
//    Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
//    add("123", "321"); -> "444"
//    add("11", "99");   -> "110"

    public static String addBig(String a, String b) {
//        return new BigInteger(a).add(new BigInteger(b)).toString(); // import java.math.BigInteger запрещен;
        StringBuilder result = new StringBuilder();
        int dop = 0;
        int max = Math.max(a.length(),b.length());
        for (int i = 0, aNum = 0, bNum = 0; i < max ; i++) {
            aNum = i < a.length() ? Character.getNumericValue(a.charAt(a.length()-1-i)) : 0;
            bNum = i < b.length() ? Character.getNumericValue(b.charAt(b.length()-1-i)) : 0;
            result.append((aNum + bNum + dop) % 10);
            dop = (aNum + bNum +dop) > 9 ? 1 : 0;
        }
        if (dop == 1) result.append(1);
        return result.reverse().toString().replaceFirst("^0+", "");
    }

//    DESCRIPTION:
//    Complete the function that
//    accepts two integer arrays of equal length
//    compares the value each member in one array to the corresponding member in the other
//    squares the absolute value difference between those two values
//    and returns the average of those squared absolute value difference between each member pair.
//    Examples
//    [1, 2, 3], [4, 5, 6]              -->   9   because (9 + 9 + 9) / 3
//    [10, 20, 10, 2], [10, 25, 5, -2]  -->  16.5 because (0 + 25 + 25 + 16) / 4
//    [-1, 0], [0, -1]                  -->   1   because (1 + 1) / 2
    public static double solutionArr(int[] arr1, int[] arr2) {
        double av = 0.0;
        for (int i=0; i<arr1.length; i++) {
            av+= (arr1[i]-arr2[i])*(arr1[i]-arr2[i]);
        }
        return av/arr1.length;
    }

//    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//            '.' Matches any single character
//            '*' Matches zero or more of the preceding element.

//    The matching should cover the entire input string (not partial).
//
//    Example 1:
//    Input: s = "aa", p = "a"
//    Output: false
//    Explanation: "a" does not match the entire string "aa".
//
//    Example 2:
//    Input: s = "aa", p = "a*"
//    Output: true
//    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//
//    Example 3:
//    Input: s = "ab", p = ".*"
//    Output: true
//    Explanation: ".*" means "zero or more (*) of any character (.)".
    public static boolean isMatch(String s, String p) {
        if (s.length()>20 || p.length()>20 || p.charAt(0) == 42) return false; //*
        for (int i = 0, j = 0; i < p.length(); i++) {
            if (s.charAt(i) != p.charAt(j) && p.charAt(j)!= 46 && p.charAt(j)!= 42) return false;
            else if (p.charAt(j) == 42 && s.charAt(i) != p.charAt(i-1)) return false;
            else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == 46) j++;
            }
        return true;
    }

//    Given an integer x, return true if x is a palindrome and false otherwise.
//    Follow up: Could you solve it without converting the integer to a string?
    public static boolean isPalindromeNotString(int x) {
        if (x<0) return false;
        int num = 1;
        int count = 0;
        while (x/num>0) {
            num*=10; count++;}
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = x % 10;
            x = x /10; }
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i]!=arr[arr.length-1-i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        String s = String.valueOf(x);
        char[] arr = String.valueOf(x).toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i]!=arr[arr.length-1-i]) return false;
        }
        return true;
    }

    public static String removeNum(String s, int k){
//        List<Integer> list = s.chars().mapToObj(x-> Integer.parseInt(String.valueOf(x))).toList();

        List<Character> list = s.chars().mapToObj(x->(char) x).collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < list.size()-1-i; j++) {
                if (list.get(j-1)<list.get(j) && list.get(j)>list.get(j+1)) {
                    list.remove(list.get(j));
                    break;
                } else if (list.get(j-1)>list.get(j)) {
                    list.remove(list.get(j-1));
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0)==0) list.remove(0);
        }
        String arr = list.stream().map(String::valueOf).collect(Collectors.joining());
        return  list.stream().map(x->String.valueOf(x)).collect(Collectors.joining());
    }

    public static int func(int num, int step) {
        if (step == 0) return 1;
        return num*func(num,step-1);
    }

//    public static List deleteDup(List<Integer> list) {
//        return list.stream().collect(Collectors.toSet()).stream().toList();
//    }

    public static List deleteDup(List<Integer> list) {
    return list.stream().distinct().toList();
    }

//    public static List deleteDup(List<Integer> list) {
//        for (int i = 0; i < list.size(); i++) {
//
//            for (int j = i+1; j < list.size(); j++) {
//                if (list.get(i) == list.get(j)) {
//                    list.remove(j--);
//                }
//            }
//        }
//    return list;
//    }
//  In this Kata, you will be given a string that may have mixed uppercase and lowercase letters
//  and your task is to convert that string to either lowercase only or uppercase only based on:
//  make as few changes as possible.
//  if the string contains equal number of uppercase and lowercase letters,
//  convert the string to lowercase.
//  For example:
//  solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
//  solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e" to uppercase.
//  solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
    public static String solve(final String str) {

        int[] arr = str.chars().toArray();
        StringBuilder sb = new StringBuilder();
        if (Arrays.stream(arr).filter(el-> el < 97).count()> arr.length/2) {
            for (int x: arr) {
                if (x > 96) x = x - 32;
                sb.append((char) x);
            }
        } else
            for (int x: arr) {
                if (x < 97) x = x + 32;
                sb.append((char) x);
            }
        return sb.toString();
    }

//        Сделать из строки "ASHJGKLKFGKKJHKAJSGADAASKGAJKLAJDLGAKFGKALSJ" => A9S4H2J6G6K9L4F2D2

    public static String letterCount(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i),1,Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((el,num)-> sb.append(el).append(num));
        return sb.toString();
    }


//    Given a string of words, you need to find the highest scoring word.
//    Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
//    For example, the score of abad is 8 (1 + 2 + 1 + 4).
//    You need to return the highest scoring word as a string.
//    If two words score the same, return the word that appears earliest in the original string.

    public static String high(String s) {
        String[] arr = s.split(" ");
        int maxSum = 1;
        int index = 0;
        for (int i=0, tempSum =0; i< arr.length; i++ ) {
            for (int j = 0; j < arr[i].length(); j++) {
                tempSum += (int) arr[i].charAt(j)-96;
            }
            if (tempSum>maxSum) {
                maxSum=tempSum;
                index = i;
            }
            tempSum=0;
        }
        return arr[index];
    }

//    public static String high(String s) {
//        return Arrays.stream(s.split(" "))
//                .max(Comparator.comparingInt(
//                        a -> a.chars().map(i -> i - 96).sum()
//                )).get();
//    }



//    All letters will be lowercase and all inputs will be valid.
//    Complete the solution so that it splits the string into pairs of two characters.
//    If the string contains an odd number of characters then it should replace the missing
//    second character of the final pair with an underscore ('_').
//            * 'abc' =>  ['ab', 'c_']
//            * 'abcdef' => ['ab', 'cd', 'ef']
    public static String[] solution(String s) {
        Boolean isOdd = s.length() % 2 == 1;
        String[] str = isOdd ? new String[s.length() / 2 + 1] : new String[s.length() / 2];
        for (int i = 0, j =0 ; i < s.length(); i=i+2) {
            if (isOdd && i == s.length()-1) str[j++]=s.charAt(s.length()-1)+"_";
            else str[j++] = s.substring(i,i+2);
        }
        return str;
    }

//    правильное решение
//    public static String[] solution(String s) {
//        s = (s.length() % 2 == 0)?s:s+"_";
//        return s.split("(?<=\\G.{2})");
//    }

//    You will be given an array of numbers. You have to sort the odd numbers in ascending
//    order while leaving the even numbers at their original positions.
    public static int[] sortArray(int[] array) {
        int[] oddArr = Arrays.stream(array).filter( x-> x % 2 != 0 ).sorted().toArray();
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) array[i] = oddArr[j++];
        }
        return array;
    }

//    The rgb function is incomplete. Complete it so that passing in RGB decimal values
//    will result in a hexadecimal representation being returned.
//    Valid decimal values for RGB are 0 - 255.
//    Any values that fall out of that range must be rounded to the closest valid value.
//    Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
    public static String rgb(int r, int g, int b) {
        return String.format("%02X%02X%02X", verify(r), verify(g), verify(b));
    }

    private static int verify(int i) {
        return i > 0 ? Math.min(255, i) : 0;
    }
    public static String rgbMy(int r, int g, int b) {
        StringBuilder sb = new StringBuilder();
        if (r<=0) sb.append("00");
        else if (r>=255) sb.append("FF");
        else if (r<16) sb.append("0").append((Integer.toHexString(r)));
        else sb.append((Integer.toHexString(r)));
        if (g<=0) sb.append("00");
        else if (g>=255) sb.append("FF");
        else if (g<16) sb.append("0").append((Integer.toHexString(g)));
        else sb.append((Integer.toHexString(g)));
        if (b<=0) sb.append("00");
        else if (b>=255) sb.append("FF");
        else {if (b<16) sb.append("0").append((Integer.toHexString(b)));
        else sb.append((Integer.toHexString(b)));}
        return sb.toString().toUpperCase();
    }
}