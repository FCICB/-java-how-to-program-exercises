import java.util.*;
public class DuplicateWordCounter {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase();
        }
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word :tokens) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        int duplicateCount = 0;
        for (int count : wordCountMap.values()) {
            if (count > 1) {
                duplicateCount++;
            }
        }

        System.out.println("Number of duplicate words: " + duplicateCount);

    }
}

