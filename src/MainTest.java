import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @DisplayName("Should create sum with Integer and Some")
    void test1() {
        var union = new SumFactory(List.of(IntegerType.Factory.getInstance(), SomeType.Factory.getInstance()));

        var integer = union.create(42);
        var some = union.create("Hello");

        assertInstanceOf(IntegerType.class, integer);
        assertInstanceOf(SomeType.class, some);
    }

    @Test
    @DisplayName("Should create the same None type")
    void test2() {
        var union = new SumFactory(List.of(NoneType.Factory.getInstance()));

        var none1 = union.create(null);
        var none2 = union.create(null);

        assertSame(none1, none2);
    }

    @Test
    @DisplayName("Should throw exception for unsupported type")
    void test3() {
        var union = new SumFactory(List.of(NoneType.Factory.getInstance()));

        assertThrows(IllegalArgumentException.class, () -> union.create("Unsupported type"));
    }
}