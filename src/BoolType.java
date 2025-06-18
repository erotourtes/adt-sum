record BoolType(boolean value) implements AdtType<BoolType> {
    @Override
    public String toPrettyString() {
        return String.format("BoolType{value=%b}", value);
    }

    @Override
    public BoolType clone() {
        return Factory.getInstance().create(this.value);
    }

    public static class Factory implements AdtFactory<BoolType> {
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
            return type instanceof Boolean;
        }

        @Override
        public BoolType create(Object value) {
            return new BoolType((boolean) value);
        }
    }
}
