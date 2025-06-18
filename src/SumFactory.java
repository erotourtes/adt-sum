import java.util.ArrayList;
import java.util.List;

class SumFactory {
    private final List<AdtFactory> variants = new ArrayList<>();

    public SumFactory(List<AdtFactory> variants) {
        this.variants.addAll(variants);
    }

    public AdtType create(Object value) {
        for (var v : variants) {
            if (v.is(value)) {
                return v.create(value);
            }
        }
        throw new IllegalArgumentException("No matching variant for: " + value);
    }
}
