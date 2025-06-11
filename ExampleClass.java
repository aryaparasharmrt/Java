import java.math.BigInteger;

public class ExampleClass {
    private Holder holder;

    public ExampleClass(Certificate certificate) {
        holder = new Holder(
            new IssuerSerial(
                generateGeneralNames(certificate.getIssuerName()),
                new ASN1Integer(certificate.getSerialNumber())
            )
        );
    }

    private GeneralNames generateGeneralNames(String issuerName) {
        return new GeneralNames(issuerName); // Dummy implementation
    }
}

// Supporting Dummy Classes
class Holder {
    private IssuerSerial issuerSerial;

    public Holder(IssuerSerial issuerSerial) {
        this.issuerSerial = issuerSerial;
    }
}

class IssuerSerial {
    private GeneralNames generalNames;
    private ASN1Integer serial;

    public IssuerSerial(GeneralNames generalNames, ASN1Integer serial) {
        this.generalNames = generalNames;
        this.serial = serial;
    }
}

class GeneralNames {
    private String name;

    public GeneralNames(String name) {
        this.name = name;
    }
}

class ASN1Integer {
    private BigInteger value;

    public ASN1Integer(BigInteger value) {
        this.value = value;
    }
}

class Certificate {
    private String issuerName;
    private BigInteger serialNumber;

    public Certificate(String issuerName, BigInteger serialNumber) {
        this.issuerName = issuerName;
        this.serialNumber = serialNumber;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public BigInteger getSerialNumber() {
        return serialNumber;
    }
}
