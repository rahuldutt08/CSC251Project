import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo class for the Policy and PolicyHolder classes. Reads a set of
 * policies from PolicyInformation.txt, stores them in an ArrayList,
 * displays each one, and reports how many Policy objects were created and
 * how many policyholders are smokers and non-smokers.
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

            PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                   smokingStatus, height,
                                                   weight);

            policies.add(new Policy(policyNumber, providerName, holder));
        }

        inputFile.close();

        int smokerCount = 0;
        int nonSmokerCount = 0;

        for (Policy policy : policies)
        {
            // Implicitly calls policy.toString()
            System.out.println(policy);
            System.out.println();

            if (policy.getPolicyHolder().getSmokingStatus()
                      .equalsIgnoreCase("smoker"))
            {
                smokerCount++;
            }
            else
            {
                nonSmokerCount++;
            }
        }

        System.out.println("There were " + Policy.getPolicyCount()
                           + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: "
                           + smokerCount);
        System.out.println("The number of policies with a non-smoker is: "
                           + nonSmokerCount);
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
