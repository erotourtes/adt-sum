import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var union = new SumFactory(List.of(
                IntegerType.Factory.getInstance(),
                BoolType.Factory.getInstance(),
                SomeType.Factory.getInstance(),
                NoneType.Factory.getInstance()));

        Stream.of(
                        union.create(42),
                        union.create(true),
                        union.create("Hello"),
                        union.create(null)
                )
                .map(AdtType::clone)
                .map(AdtType::toPrettyString)
                .forEach(System.out::println);
    }
}