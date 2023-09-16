import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines
{
    public static void main(String[] args) throws IOException
    {

        Map<Character, Long> charCounts = Files.lines(Paths.get("Chapter2Paragraph.txt"))
                .flatMap(line -> line.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Character::toLowerCase,
                        TreeMap::new, Collectors.counting()));

        // display the character counts
        charCounts.forEach((character, count) ->
                System.out.printf("%c: %d%n", character, count));

    }
}
