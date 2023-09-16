import java.util.Scanner;
import java.util.TreeSet;

public class sortWordSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String ");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        TreeSet<String> wordSet=new TreeSet<>();
        for (String token : tokens)
        {
            wordSet.add(token);
        }
        System.out.println("Word Set after Sorted ");
        for (String word :wordSet)
        {
            System.out.println(word);
        }
    }
}
