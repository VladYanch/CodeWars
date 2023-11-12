import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("abc", "bc"));
        System.out.println(solution("abc", "d"));
        System.out.println("_".repeat(80));
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println("_".repeat(80));
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // => List.of(1,2))
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 231))); // => List.of(1, 2, 231)
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

