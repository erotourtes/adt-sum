interface AdtType<T extends AdtType<T>> {
    String toPrettyString();

    T clone();
}

interface AdtFactory<T extends AdtType<T>> {
    T create(Object value);

    boolean is(Object type);
}

