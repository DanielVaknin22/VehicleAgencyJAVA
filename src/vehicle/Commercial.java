package vehicle;
/**

 The Commercial interface represents a type of vehicle that can be used for commercial purposes.
 It includes methods for setting and getting the license type of the vehicle.
 */
enum licenseType {
    /**

     An enumeration representing the different types of licenses for commercial vehicles.
     It includes MINI, LIMIT, and UNLIMIT.
     */
    MINI,
    LIMIT,
    UNLIMIT
}

public interface Commercial {
    /**
     * Sets the license type of the commercial vehicle.
     *
     * @param license the license type to set
     */

    public void setLicenseType(licenseType license);
    /**
     * Gets the license type of the commercial vehicle.
     *
     * @return the license type of the vehicle
     */
    public licenseType getLicenseType();
}
