/**
 * Models an insurance policy for a single person.
 */
public class Policy
{
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double height;          // in inches
    private double weight;          // in pounds

    // Fee constants used by getPolicyPrice()
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final int AGE_THRESHOLD = 50;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_FEE_PER_UNIT = 20.0;

    /**
     * No-arg constructor. Sets all fields to default values.
     */
    public Policy()
    {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that fully initializes the Policy object.
     *
     * @param policyNumber  the policy number
     * @param providerName  the name of the insurance provider
     * @param firstName     the policyholder's first name
     * @param lastName      the policyholder's last name
     * @param age           the policyholder's age in years
     * @param smokingStatus "smoker" or "non-smoker"
     * @param height        the policyholder's height in inches
     * @param weight        the policyholder's weight in pounds
     */
    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // ----- Setters -----

    /**
     * Sets the policy number.
     *
     * @param policyNumber the policy number
     */
    public void setPolicyNumber(String policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    /**
     * Sets the name of the insurance provider.
     *
     * @param providerName the name of the insurance provider
     */
    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    /**
     * Sets the policyholder's first name.
     *
     * @param firstName the policyholder's first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Sets the policyholder's last name.
     *
     * @param lastName the policyholder's last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Sets the policyholder's age.
     *
     * @param age the policyholder's age in years
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * Sets the policyholder's smoking status.
     *
     * @param smokingStatus "smoker" or "non-smoker"
     */
    public void setSmokingStatus(String smokingStatus)
    {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Sets the policyholder's height.
     *
     * @param height the policyholder's height in inches
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * Sets the policyholder's weight.
     *
     * @param weight the policyholder's weight in pounds
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    // ----- Getters -----

    /**
     * Gets the policy number.
     *
     * @return the policy number
     */
    public String getPolicyNumber()
    {
        return policyNumber;
    }

    /**
     * Gets the name of the insurance provider.
     *
     * @return the name of the insurance provider
     */
    public String getProviderName()
    {
        return providerName;
    }

    /**
     * Gets the policyholder's first name.
     *
     * @return the policyholder's first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Gets the policyholder's last name.
     *
     * @return the policyholder's last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Gets the policyholder's age.
     *
     * @return the policyholder's age in years
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Gets the policyholder's smoking status.
     *
     * @return "smoker" or "non-smoker"
     */
    public String getSmokingStatus()
    {
        return smokingStatus;
    }

    /**
     * Gets the policyholder's height.
     *
     * @return the policyholder's height in inches
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Gets the policyholder's weight.
     *
     * @return the policyholder's weight in pounds
     */
    public double getWeight()
    {
        return weight;
    }

    // ----- Calculated values -----

    /**
     * Calculates the policyholder's BMI from the current height and weight.
     *
     * @return the BMI, or 0.0 if the height has not been set
     */
    public double getBMI()
    {
        if (height == 0.0)
        {
            return 0.0;
        }
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates the price of the policy from the current field values.
     *
     * @return the total price of the insurance policy
     */
    public double getPolicyPrice()
    {
        double price = BASE_FEE;

        if (age > AGE_THRESHOLD)
        {
            price += AGE_FEE;
        }

        if (smokingStatus.equalsIgnoreCase("smoker"))
        {
            price += SMOKER_FEE;
        }

        double bmi = getBMI();
        if (bmi > BMI_THRESHOLD)
        {
            price += (bmi - BMI_THRESHOLD) * BMI_FEE_PER_UNIT;
        }

        return price;
    }
}
