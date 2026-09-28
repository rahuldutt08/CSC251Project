import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo class for the Policy class. Reads a set of policies from
 * PolicyInformation.txt, stores them in an ArrayList, and displays
 * each one by iterating over the list.
 */
public class Project_Rahul_Dutt
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Policy> policies = new ArrayList<>();

        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        // Each policy is 8 lines. Blank lines between records are skipped.
        while (inputFile.hasNext())
        {
            String policyNumber = nextNonBlankLine(inputFile);
            String providerName = nextNonBlankLine(inputFile);
            String firstName = nextNonBlankLine(inputFile);
            String lastName = nextNonBlankLine(inputFile);
            int age = Integer.parseInt(nextNonBlankLine(inputFile));
            String smokingStatus = nextNonBlankLine(inputFile);
            double height = Double.parseDouble(nextNonBlankLine(inputFile));
            double weight = Double.parseDouble(nextNonBlankLine(inputFile));

            policies.add(new Policy(policyNumber, providerName, firstName,
                                    lastName, age, smokingStatus,
                                    height, weight));
        }

        inputFile.close();

        for (Policy policy : policies)
        {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: "
                               + policy.getFirstName());
            System.out.println("Policyholder's Last Name: "
                               + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status "
                               + "(smoker/non-smoker): "
                               + policy.getSmokingStatus());
            System.out.printf("Policyholder's Height: %.1f inches%n",
                              policy.getHeight());
            System.out.printf("Policyholder's Weight: %.1f pounds%n",
                              policy.getWeight());
            System.out.printf("Policyholder's BMI: %.2f%n", policy.getBMI());
            System.out.printf("Policy Price: $%.2f%n",
                              policy.getPolicyPrice());
            System.out.println();
        }
    }

    /**
     * Reads lines from the file until a non-blank one is found.
     *
     * @param inputFile the Scanner reading the policy file
     * @return the next non-blank line, with surrounding whitespace removed
     */
    private static String nextNonBlankLine(Scanner inputFile)
    {
        String line = inputFile.nextLine().trim();
        while (line.isEmpty())
        {
            line = inputFile.nextLine().trim();
        }
        return line;
    }
}
