import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
public class RandomLetterS {
    public static void main(String[] args) {
        List<Character> letters=generateRandomLetters(30);
        System.out.println("Original List:");
        System.out.println(letters);
        System.out.println("\nSorted List (Ascending Order):");
        List<Character> sortedAscending=letters.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedAscending);

        System.out.println("\nSorted List (Descending Order):");
        List<Character> sortesDesceingding=letters.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortesDesceingding);
        System.out.println("\nSorted List Distinct (Ascending Order):");
        List<Character> distinctAscending=letters.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(distinctAscending);


    }

    private static List<Character> generateRandomLetters(int count) {
        Random random=new Random();
        List<Character> letters=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            char randomLetter = (char) (random.nextInt(26) + 'A');
            letters.add(randomLetter);
        }
        return letters;
    }
}
