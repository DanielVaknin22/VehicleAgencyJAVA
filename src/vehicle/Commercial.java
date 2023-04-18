package vehicle;
enum licenseType {
    MINI,
    LIMIT,
    UNLIMIT
}

public interface Commercial {
    public void setLicenseType(licenseType license);
    public licenseType getLicenseType();
}
