public class Laptop {

    public String edition;
    public int version;
    public String productID;
    public double osBuild;
    public String modal;
    public String ram;
    public String processor;
    public String compName;

    public Laptop(LaptopBuilder laptopBuilder) {
        this.edition = laptopBuilder.edition;
        this.version = laptopBuilder.version;
        this.productID = laptopBuilder.productID;
        this.osBuild = laptopBuilder.osBuild;
        this.modal = laptopBuilder.modal;
        this.ram = laptopBuilder.ram;
        this.processor = laptopBuilder.processor;
        this.compName = laptopBuilder.compName;
    }

    public static LaptopBuilder builder() {
        return new LaptopBuilder();
    }

    static class LaptopBuilder {

        private String edition;
        private int version;
        private String productID;
        private double osBuild;
        private String modal;
        private String ram;
        private String processor;
        private String compName;

        public LaptopBuilder edition(String edition) {
            this.edition = edition;
            return this;
        }

        public LaptopBuilder version(int version) {
            this.version = version;
            return this;
        }

        public LaptopBuilder productID(String productID) {
            this.productID = productID;
            return this;
        }

        public LaptopBuilder osBuild(double osBuild) {
            this.osBuild = osBuild;
            return this;
        }

        public LaptopBuilder modal(String modal) {
            this.modal = modal;
            return this;
        }

        public LaptopBuilder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public LaptopBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public LaptopBuilder compName(String compName) {
            this.compName = compName;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }

    }

    @Override
    public String toString() {
        return "ClassName{"
                + "edition='" + edition + '\''
                + ", version=" + version
                + ", productID='" + productID + '\''
                + ", osBuild=" + osBuild
                + ", modal='" + modal + '\''
                + ", ram='" + ram + '\''
                + ", processor='" + processor + '\''
                + ", compName=" + compName
                + '}';
    }

    public static void main(String[] args) {

        Laptop laptop = Laptop.builder() //Got the Empty object of Laptopbuild, from next line properties will get set
                .edition("Windows 10 Home")
                .version(1703)
                .productID("00232-10001-00000-AA725")
                .osBuild(15063.1232)
                .modal("X54OLA")
                .ram("4.00GB")
                .processor("Intell(R)Core(TM)i5-4210U@1.70GHz")
                .compName("DESKTOP-V6183IG")
                .build();

        System.out.println(laptop.toString());

    }
}
