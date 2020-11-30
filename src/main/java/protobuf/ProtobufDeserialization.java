package protobuf;

import dto.ProtoDTO;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

public class ProtobufDeserialization {

    static byte[] data = ProtobufSerialization.dto.toByteArray();

    @Benchmark
    public ProtoDTO.DTO deserialize() throws IOException {
        return ProtoDTO.DTO.parseFrom(data);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ProtobufDeserialization.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
