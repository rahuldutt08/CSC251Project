/**
 * Models an insurance policy. Each Policy has a PolicyHolder.
 */
public class Policy
{
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;  // aggregation: a Policy has a PolicyHolder

    // Keeps track of how many Policy objects have been created
    private static int policyCount = 0;

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
        policyHolder = new PolicyHolder();
        policyCount++;
    }

    /**
     * Constructor that fully initializes the Policy object.
     *
     * @param policyNumber the policy number
     * @param providerName the name of the insurance provider
     * @param policyHolder the person associated with this policy
     */
    public Policy(String policyNumber, String providerName,
                  PolicyHolder policyHolder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        // Store a copy so outside code cannot change this policy's holder
        this.policyHolder = new PolicyHolder(policyHolder);
        policyCount++;
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
     * Sets the policyholder. A copy of the argument is stored.
     *
     * @param policyHolder the person associated with this policy
     */
    public void setPolicyHolder(PolicyHolder policyHolder)
    {
        this.policyHolder = new PolicyHolder(policyHolder);
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
     * Gets a copy of the policyholder, so the caller cannot change
     * this policy's PolicyHolder object.
     *
     * @return a copy of the policyholder
     */
    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(policyHolder);
    }

    /**
     * Gets the number of Policy objects that have been created.
     *
     * @return the number of Policy objects created
     */
    public static int getPolicyCount()
    {
        return policyCount;
    }

    // ----- Calculated values -----

    /**
     * Calculates the price of the policy from the policyholder's information.
     *
     * @return the total price of the insurance policy
     */
    public double getPolicyPrice()
    {
        double price = BASE_FEE;

        if (policyHolder.getAge() > AGE_THRESHOLD)
        {
            price += AGE_FEE;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
        {
            price += SMOKER_FEE;
        }

        double bmi = policyHolder.getBMI();
        if (bmi > BMI_THRESHOLD)
        {
            price += (bmi - BMI_THRESHOLD) * BMI_FEE_PER_UNIT;
        }

        return price;
    }

    /**
     * Returns a String describing the policy and its policyholder.
     *
     * @return a String containing the policy's information
     */
    @Override
    public String toString()
    {
        return "Policy Number: " + policyNumber
               + "\nProvider Name: " + providerName
               + "\n" + policyHolder
               + String.format("\nPolicy Price: $%.2f", getPolicyPrice());
    }
}
