class NoneType implements AdtType<NoneType> {
    private NoneType() {
    }

    @Override
    public String toPrettyString() {
        return "NoneType{value=null}";
    }

    @Override
    public NoneType clone() {
        return Factory.getInstance().create(null);
    }

    public static class Factory implements AdtFactory<NoneType> {
        private static Factory instance = null;
        private static final NoneType none = new NoneType();

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
            return type == null;
        }

        @Override
        public NoneType create(Object value) {
            return Factory.none;
        }
    }
}
