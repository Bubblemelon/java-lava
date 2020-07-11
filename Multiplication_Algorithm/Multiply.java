import java.util.*;

public class Multiply {

    // global variables
    // user inputs
    String option;
    String x = "x";
    String y = "y";

    final String caseInsensitiveYesNo = "[Nn][oO]|[yY][eE][sS]|[yY]|[nN]";
    final String caseInsensitiveYes = "[yY][eE][sS]|[yY]";

    // about this program
    public void intro(){

        System.out.println(
            "\n--------------------------------------------------------------------------------------\n"
            + "-                                                                                    -\n"
            + "- This program demonstrates the Multiplication Algorithm of two values in two ways:  -\n"
            + "-                                                                                    -\n"
            + "- Option (1): The Partial-Products Method                                            -\n"
            + "- Option (2): The Standard Multiplication Method                                     -\n"
            + "-             Also known as the shortcut method of option (1).                       -\n"
            + "--------------------------------------------------------------------------------------\n\n"
        );
    }

    public void aboutMultiplication(){

        System.out.println(
            "\n----------------------------------------------\n" +
            "- \uD83D\uDCDD  Know the terms:                         -\n" +
            "- Multiplication = Multiplicand x Multiplier -\n" +
            "-                                            -\n" +
            "- Let's begin!                               -\n" +
            "- Find the product of x and y.  \uD83E\uDD14            -\n" +
            "-                                            -\n" +
            "- This can be expressed as:                  -\n" +
            "- product = x * y                            -\n" +
            "----------------------------------------------"
        );
    }

    // queries the user for an input matching the inputCondition otherwise,
    // shows an errorMessage and repeat query.
    public String prompt(String query, String inputCondition, String errorMessage){

        Scanner s = new Scanner(System.in);
        String userInput = "";

        while(true){
            try{

                System.out.println(query);
                userInput = s.nextLine();

                if(userInput.length() != 0)
                {
                    // Only one letter
                    if(!userInput.matches(inputCondition)){
                        // \u26D4 No Entry Symbol
                        throw new IllegalArgumentException(errorMessage);
                    }
                    break;
                }

            }catch(IllegalArgumentException e){

                System.out.println(e.getMessage());
            }
        }

        return userInput;

    }

    // repeats the specified string in the number of desired repetitions
    public String stringRepeater(int numberOfRepeats, String str){

        String result = "";

        for(int i = 0; i < numberOfRepeats; i++){
            result += str;
        }

        return result;

    }

    // expands the digits in @param with respect to its place value
    // return the expanded terms as an array
    // e.g. 12 = 2, 10
    public int[] splitDigits(String stringValue){

        int value = Integer.parseInt(stringValue);
        int temp_v = value;
        int placeholder =  0; // primitives are zero by default; this is for my sake
        int placeValue = 1;

        // to determine the size of result array - not necessary if using ArrayList
        // I'm trying to challenge myself to not use ArrayLists
        while(temp_v != 0){
            temp_v /= 10;
            placeholder++;
        }

        int[] result = new int[placeholder];

        //reset local variables to reuse
        placeholder = 0;
        temp_v = value;

        while(temp_v != 0){
            result[placeholder] = (temp_v % 10) * placeValue;
            placeValue *= 10;
            placeholder++;
            temp_v /= 10;
        }

        return result;

    }

    /**
     * References:
     * Emoji List v13.0 - https://unicode.org/emoji/charts/full-emoji-list.html
     * To search for the corresponding "C/C++/Java source code" from Unicode -
     * http://www.fileformat.info/info/unicode/char/search.htm
     * e.g. Unicode U+26D4 == \u26D4
     */
    public void askUserOption(){

        Scanner s = new Scanner(System.in);
        String userInput;


        // requesting one number character between 1 and 2
        // \u26D4 is the No Entry Symbol
        userInput = prompt(
            "> Type \" 1 \" for Option (1) or Type \" 2 \" for Option (2):",
            "[1-2]",
            "\n\u26D4  Error: No other characters allowed, please input a single digit value between 1 and 2!\n"
            );

        // update chosen option
        // For sake of clarity. Alternatively, use "option" alone without a local variable.
        option = userInput;

    }

    public void askUserValues(){

        Scanner s = new Scanner(System.in);
        String userInput = "";

        if(!x.equals("x")){

            userInput = prompt(
                "\n> Do you want to change the current value of the multiplicand, x = " + x + " ?",
                caseInsensitiveYesNo,
                "\n\u26D4  Error: To proceed with the change, please enter \"yes\" or \"y\"." +
                "\n          To keep x as " + x + ", enter \"no\" or \"n\". Your response is case-insensitive."
                );

        }

        // evaluates user input first
        if(userInput.matches(caseInsensitiveYes) || x.equals("x")){

            // requesting any length of a number value
            userInput = prompt(
                "\n> Enter your value for the multiplicand i.e. value for x:",
                "[0-9]+",
                "\n\u26D4  Error: No other characters allowed, please input a numeric value!\n"
                );

            x = userInput;

        }

        // 12 chars of leading dashes
        // ends with 5 or more chars of " * y -", y is variable length
        System.out.println(
            "\n" + stringRepeater(12 + x.length() + 5 + y.length() , "-") + "\n" +
            "| product = " + x + " * "+ y + " |\n" +
            stringRepeater(12 + x.length() + 5 + y.length() , "-")
            );

        if(!y.equals("y")){

            userInput = prompt(
                "\n> Do you want to change the current value of the multiplier, y = " + y + " ?",
                caseInsensitiveYesNo,
                "\n\u26D4  Error: To proceed with the change, please enter \"yes\" or \"y\"." +
                "\n          To keep y as " + y + ", enter \"no\" or \"n\". Your response is case-insensitive."
                );
        }

        // evaluates user input first
        if(userInput.matches(caseInsensitiveYes) || y.equals("y")){

            // requesting any length of a number value
            userInput = prompt(
                "\n> Enter your value for the multiplier i.e. value for y:",
                "[0-9]+",
                "\n\u26D4  Error: No other characters allowed, please input a numeric value!\n"
                );

            y = userInput;
        }

        // 12 chars of leading dashes
        // in between 3 chars " * " before y value
        // ends with 2 chars " -"
        System.out.println(
            "\n" + stringRepeater(12 + x.length() + y.length() + 5 , "-") + "\n" +
            "| product = " + x + " * " + y + " |\n" +
            stringRepeater(12 + x.length() + y.length() + 5 , "-")
            );

    }

    // overview of this program
    public Multiply(){

        intro();
        askUserOption();
        aboutMultiplication();
        askUserValues();
    }


    public static void main(String[] args) {

    }
}
