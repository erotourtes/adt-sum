record SomeType(Object value) implements AdtType<SomeType> {
    @Override
    public String toPrettyString() {
        return String.format("SomeType{value=%s}", value);
    }

    @Override
    public SomeType clone() {
        return Factory.getInstance().create(this.value);
    }

    public static class Factory implements AdtFactory<SomeType> {
        private static Factory instance = null;

        private Factory() {
        }

        public static Factory getInstance() {
            if (instance == null) {
                instance = new Factory();
            }
            return instance;
        }

        @Override
        public boolean is(Object type) {
            return type != null;
        }

        @Override
        public SomeType create(Object value) {
            return new SomeType(value);
        }
    }
}
