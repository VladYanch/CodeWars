import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution("abc", "bc"));
//        System.out.println(solution("abc", "d"));
//        System.out.println("_".repeat(50));
//        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
//        System.out.println("_".repeat(50));
//        System.out.println(filterList(List.of(1, 2, "a", "b"))); // => List.of(1,2))
//        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231))); // => List.of(1, 2, 231)
//        System.out.println("_".repeat(50));
//        System.out.println(encode("din")); //"din"      =>  "((("
//        System.out.println(encode("recede")); //"recede"   =>  "()()()"
//        System.out.println(encode("Success")); //"Success"  =>  ")())())"
//        System.out.println(encode("(( @")); //"(( @"     =>  "))(("
//        System.out.println("_".repeat(50));
//        System.out.println(encode1("din")); //"din"      =>  "((("
//        System.out.println(encode1("recede")); //"recede"   =>  "()()()"
//        System.out.println(encode1("Success")); //"Success"  =>  ")())())"
//        System.out.println(encode1("(( @")); //"(( @"     =>  "))(("
//        System.out.println("_".repeat(50));
//        System.out.println(rowSumOddNumbers(1));
//        System.out.println(rowSumOddNumbers(4));
//        System.out.println("_".repeat(50));
//        Arrays.stream(towerBuilder(3)).forEach(str-> System.out.println(str));
//        System.out.println("_".repeat(50));
//        Arrays.stream(towerBuilder(70)).forEach(str-> System.out.println(str));
//        System.out.println(findShort("mama"));
//        System.out.println(findShort("mama sunday windy pot lotto")); //3
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps")); //3
        System.out.println(findShort("turns out random test cases are easier than writing out basic ones")); //3
        System.out.println(findShort("Let's travel abroad shall we")); //2
    }

//    Simple, given a string of words, return the length of the shortest word(s).
//    String will never be empty and you do not need to account for different data types.
    public static int findShort(String s) {
        int length = Integer.MAX_VALUE;
        if (s.indexOf(" ") == -1) return s.length();
        else length = s.indexOf(" ");
        int tmp = 1;
        int start = s.indexOf(" ");
        int last = s.lastIndexOf(" ");
        while ( start < last ) {
            tmp = s.indexOf(" ",start+1)-start-1;
            if (tmp < length) length = tmp;
            start = start + tmp + 1;
        }
        if (s.length() - last - 1 < length ) length = s.length() - last - 1;
        return length;
    }

//    public static int findShort(String s) {
//        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().getAsInt();
//
//    }

//    Build a pyramid-shaped tower, as an array/list of strings, given a positive integer number of floors.
//    A tower block is represented with "*" character.

    public static String[] towerBuilder(int nFloors) {
        String[] arr = new String[nFloors];
        for (int i = 1; i <= nFloors; i++) {
            arr[i-1]=" ".repeat(nFloors-i)+"*".repeat(i*2-1)+" ".repeat(nFloors-i);
        }
        return arr;
    }

//        Given the triangle of consecutive odd numbers:
//        Calculate the sum of the numbers in the nth row of this triangle (starting at index 1)
//        1 -->  1
//        2 --> 3 + 5 = 8
//        4 --> 64
    public static int rowSumOddNumbers(int n) {
        if ( n == 1 ) return 1;
        int start = 1;
        int sum = 0;
        for (int i = 2; i <n ; i++) {
            start = start + i;
        }
        start = start * 2 + 1;
        for (int i = 1; i <=n ; i++) {
            sum = sum + start;
            start = start + 2;
        }
        return sum;
    }


//    The goal of this exercise is to convert a string to a new string where each character
//    in the new string is "(" if that character appears only once in the original string,
//    or ")" if that character appears more than once in the original string.
//    Ignore capitalization when determining if a character is a duplicate.
    static String encode1(String word){
        StringBuilder str = new StringBuilder();
        char[] arr = word.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (word.indexOf(arr[i])<i || word.lastIndexOf(arr[i])>i) str.append(")");
            else str.append("(");
        }
        return str.toString();
    }
    static String encode(String word){
        StringBuilder str = new StringBuilder();
        char[] arr = word.toLowerCase().toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i],1,Integer::sum);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])>1) str.append(")");
            else str.append("(");
        }
        return str.toString();
    }


//    In this kata you will create a function that takes a list of non-negative integers
//    and strings and returns a new list with the strings filtered out.
    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(s -> s instanceof Integer).toList();
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder str = new StringBuilder();
        return str.append("(")
                .append(numbers[0])
                .append(numbers[1])
                .append(numbers[2])
                .append(") ")
                .append(numbers[3])
                .append(numbers[4])
                .append(numbers[5])
                .append("-")
                .append(numbers[6])
                .append(numbers[7])
                .append(numbers[8])
                .append(numbers[9]).toString();
    }

    public static boolean solution(String str, String ending) {
        if (str.endsWith(ending)) return true;
        return false;
    }
}

