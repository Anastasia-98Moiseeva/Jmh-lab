package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.DTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


public class JSONSerialization {

    private static DTO dto = new DTO();
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Benchmark
    public String serialize() throws JsonProcessingException {
        return objectMapper.writeValueAsString(dto);
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
