package protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.googlecode.protobuf.format.XmlFormat;
import dto.ProtoDTO;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class ProtobufSerialization {

    static ProtoDTO.User user = ProtoDTO.User.newBuilder()
            .setId(2)
            .setLogin("Alex")
            .addBirthday("29-06-2001")
            .addBirthplace("Canada")
            .addAllHobbies(new ArrayList<>(Arrays.asList("skating", "skiing", "swimming")))
            .build();

    static ProtoDTO.DTO dto = ProtoDTO.DTO.newBuilder()
            .setId(10)
            .setUser(user)
            .addDate("27-02-2019")
            .addPrice(150)
            .build();

    @Benchmark
    public String serialize() throws JsonProcessingException {
        return XmlFormat.printToString(dto);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ProtobufSerialization.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
