import java.util.*;

public class DuplicateWordRemoval {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Sentence ");
        String sentence = scanner.nextLine();
        Set<String> uniqueWord=  Arrays.stream(sentence.toLowerCase(Locale.ROOT).split(" "))
                .distinct().collect(TreeSet::new,Set::add,Set::addAll);
        System.out.println("Unique words in alphabetical order:");
        uniqueWord.forEach(System.out::println);
    }
}
