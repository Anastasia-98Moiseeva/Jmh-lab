package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DTO;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONDeserialization {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static byte[] data;

    static {
        try {
            data = Files.readAllBytes(Paths.get("/home/anastasia/Documents/mipt/optimization/Jmh-lab/src/main/java/data/dto.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public DTO deserialize() throws IOException {
        return objectMapper.readValue(data, DTO.class);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JSONSerialization.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
