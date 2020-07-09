import java.util.*;

public class Multiply {

    // global variables
    // user inputs
    String option;

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

    // overview of this program
    public Multiply(){

        intro();
        askUserOption();
        aboutMultiplication();
    }


    public static void main(String[] args) {

    }
}
