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

    // Setting values

    public void setPolicyNumber(String policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setSmokingStatus(String smokingStatus)
    {
        this.smokingStatus = smokingStatus;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    // Getting values

    public String getPolicyNumber()
    {
        return policyNumber;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getAge()
    {
        return age;
    }

    public String getSmokingStatus()
    {
        return smokingStatus;
    }

    public double getHeight()
    {
        return height;
    }

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