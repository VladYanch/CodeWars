import java.util.*;
import java.util.stream.Collectors;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
//        System.out.println(deleteDup(list));
        int num = 2;
        int step = 10;
        System.out.println(func(num, step));
    }

    public static int func(int num, int step) {
        if (step == 0) return 1;
        return num*func(num,step-1);
    }

//    public static List deleteDup(List<Integer> list) {
//        return list.stream().collect(Collectors.toSet()).stream().toList();
//    }


    public static List deleteDup(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {

            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j--);
                }
            }
        }
    return list;
    }
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