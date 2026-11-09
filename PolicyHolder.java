/**
 * Models a person who is associated with an insurance policy.
 */
public class PolicyHolder
{
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double height;          // in inches
    private double weight;          // in pounds

    /**
     * No-arg constructor. Sets all fields to default values.
     */
    public PolicyHolder()
    {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that fully initializes the PolicyHolder object.
     *
     * @param firstName     the policyholder's first name
     * @param lastName      the policyholder's last name
     * @param age           the policyholder's age in years
     * @param smokingStatus "smoker" or "non-smoker"
     * @param height        the policyholder's height in inches
     * @param weight        the policyholder's weight in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Copy constructor. Creates a new PolicyHolder that is a copy of
     * another PolicyHolder object.
     *
     * @param other the PolicyHolder object to copy
     */
    public PolicyHolder(PolicyHolder other)
    {
        firstName = other.firstName;
        lastName = other.lastName;
        age = other.age;
        smokingStatus = other.smokingStatus;
        height = other.height;
        weight = other.weight;
    }

    // ----- Setters -----

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
     * Returns a String describing the policyholder.
     *
     * @return a String containing the policyholder's information
     */
    @Override
    public String toString()
    {
        return "Policyholder's First Name: " + firstName
               + "\nPolicyholder's Last Name: " + lastName
               + "\nPolicyholder's Age: " + age
               + "\nPolicyholder's Smoking Status (Y/N): " + smokingStatus
               + String.format("\nPolicyholder's Height: %.1f inches", height)
               + String.format("\nPolicyholder's Weight: %.1f pounds", weight)
               + String.format("\nPolicyholder's BMI: %.2f", getBMI());
    }
}
