import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordSummary
{
    public static void main(String[] args) throws IOException
    {
        Path filePath=Path.of("Chapter2Paragraph.txt");
        Instant start= Instant.now();
        Map<String, Long> wordCountSequential = Files.lines(filePath)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        Instant end=Instant.now();
        Duration sequentialDuration=Duration.between(start,end);
        System.out.println("Sequential Time: " + sequentialDuration.toMillis() + " milliseconds");
        start=Instant.now();
        Map<String, Long> wordCountParallel = Files.lines(filePath).parallel()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
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