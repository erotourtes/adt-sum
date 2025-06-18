record IntegerType(int value) implements AdtType<IntegerType> {
    @Override
    public String toPrettyString() {
        return String.format("IntegerType{value=%d}", value);
    }

    @Override
    public IntegerType clone() {
        return Factory.getInstance().create(this.value);
    }

    public static class Factory implements AdtFactory<IntegerType> {
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
            return type instanceof Integer;
        }

        @Override
        public IntegerType create(Object value) {
            return new IntegerType((Integer) value);
        }
    }
}
