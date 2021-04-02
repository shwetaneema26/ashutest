package ashutest;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms512M", "-Xmx512M"})
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class BenchmarkLoop {

    private List<String> DATA_FOR_TESTING;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
    }

    @Benchmark
    @OperationsPerInvocation(10)
    public void array_creation_va(Blackhole bh) {
        List<Integer> ll =Arrays.asList(1,2,3,4,5,6,7,8,9,10,12,13,14);
        bh.consume(ll);
    }
    @Benchmark
    @OperationsPerInvocation(10)
    public void array_creation(Blackhole bh) {
        List<Integer> ll = new ArrayList<>(14);
        for (int i = 1;i<15;i++) {
            ll.add(i);
        }
        bh.consume(ll);
    }


}