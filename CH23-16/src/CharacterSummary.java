import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterSummary
{
    public static void main(String[] args) throws IOException
    {
        Path filePath=Path.of("Chapter2Paragraph.txt");
        Instant start= Instant.now();
        Map<Character, Long> charCountSequential = Files.lines(filePath)
                .flatMapToInt((String s) -> s.chars())
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));
        Instant end=Instant.now();
        Duration sequentialDuration=Duration.between(start,end);
        System.out.println("Sequential Time: " + sequentialDuration.toMillis() + " milliseconds");
        start=Instant.now();
        Map<Character, Long> charCountPaeallel = Files.lines(filePath).parallel()
                .flatMapToInt((String s) -> s.chars())
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));
        end=Instant.now();
        Duration parallelDuration=Duration.between(start,end);
        System.out.println("Parallel Time: " + parallelDuration.toMillis() + " milliseconds");
        if (sequentialDuration.compareTo(parallelDuration) < 0) {
            System.out.println("Sequential version is faster.");
        } else if (sequentialDuration.compareTo(parallelDuration) > 0) {
            System.out.println("Parallel version is faster.");
        } else {
            System.out.println("Both versions have the same execution time.");
        }





    }
}