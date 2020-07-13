import java.util.*;

public class Multiply {

    // global variables
    // user inputs
    String option;
    String x = "x";
    String y = "y";
    String dashLine = "";
    String setupBase = ""; //shows the x and y over a horizontal line

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

    // prints the setup of the desired multiplication
    public void methodSetup(){

        int product = Integer.parseInt(x) * Integer.parseInt(y);


        // lead with 3 spaces
        int numberOfLeadingSpaces = 3;
        String projectedLine = "   " + Integer.toString(product);

        // easier to read approach
        // optimized alternative is to use 1 loop with if statements
        // forms the horizontal line below the Multiplicand and multiplier
        dashLine = stringRepeater(projectedLine.length(), "-");

        // find the difference in space characters needed between dash line and input values x and y

        String spaceGapTop = stringRepeater( Math.abs(x.length() - (dashLine.length()
                                            - numberOfLeadingSpaces) ), " ");
        String spaceGapBottom = stringRepeater( Math.abs(y.length() - (dashLine.length()
                                                - numberOfLeadingSpaces) ), " ");

        setupBase = "\n" + "   " + spaceGapTop + x +
                    "\n" + " X " + spaceGapBottom + y +
                    "\n" + dashLine;

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

    // to print the method for option 2
    public void printShortCutMethod(int[] intermediateValues){

        System.out.println(setupBase);

        for(int i = 0; i < intermediateValues.length; i++){

            String element = Integer.toString(intermediateValues[i]);
            String tempConcat = "";

            /*
            * the final element stores the result or product value
            * see Multiplication() function:
            * intermediateValues[intermediateValues.length - 1] = result;
            */
            if( i == intermediateValues.length - 1){
                System.out.println(dashLine); // print the dash line before animating the final value
            }

            for(int j = element.length() - 1 ; j >= 0 ; j--){

                try{

                    tempConcat = element.charAt(j) + tempConcat; // insert to the front of string

                    // when dealing with the element before the result value, add plus sign
                    // when final character of this element is printed
                    if( i == (intermediateValues.length - 2) && j == 0 ){

                        System.out.print(
                            // account for the 3 leading characters
                            " + " +
                            stringRepeater(
                                ( (dashLine.length() - 3 )- tempConcat.length() ), " ") + tempConcat
                                + "\r"
                            );

                    }else{

                        System.out.print(
                            stringRepeater( ( dashLine.length() - tempConcat.length() ), " ") + tempConcat +
                            "\r"
                            );
                    }

                    // to simulate an animation
                    Thread.sleep(400);

                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }


            }

            /*
            * To make sure the next line after the completed one
            * doesn't override the printed out characters.
            *
            * inspiration from:
            * https://stackoverflow.com/questions/852665/command-line-progress-bar-in-java
            */
            System.out.println();

        }

    }

     // Multiplication = Multiplier x Multiplicand
    // product = x * y
    public void multiplication(String x, String y){

        int[] multiplier = splitDigits(y);
        int[] multiplicand = splitDigits(x);

     /*
      * if user selects shortcut method
      * the number of values correspond to the number of digits in the multiplier
      * + 1 to include final result or product value
     */
        int[] intermediateValues = new int[y.length() + 1];
        int intermediate; // elements of the intermediateValues array

        int result = 0;

        // intermediate values for partial-products method
         int partial = 0;

         methodSetup();

         if(option.equals("1")){
         System.out.println( setupBase );
         }

         // partial-product
         // O(n^2) when without getting the number of spaces needed to left-align values
         for(int i = 0; i < multiplier.length; i++){

         intermediate = 0;

             for(int j = 0; j < multiplicand.length; j++){

                 partial = (multiplicand[j] * multiplier[i]);

                 result += partial;
                 intermediate += partial;

                 if(option.equals("1")){

                     try{

                         /*
                         * add the plus sign on the line with the last partial value
                         * alternatively, find x.length * y.length to get the last nth partial value,
                         * then use counter to keep track of iterations
                         */
                         if(j == (multiplicand.length - 1 ) && i == (multiplier.length - 1) ){

                             // minus 3 for the 3 leading chars
                             System.out.println(
                                 " + " + stringRepeater(
                                     (dashLine.length() - 3) - Integer.toString(partial).length(), " ")
                                     + partial);

                         }else{
                             System.out.println(
                                 stringRepeater(
                                     dashLine.length() - Integer.toString(partial).length(), " ")
                                     + partial);
                         }

                         // to simulate an animation
                         Thread.sleep(400);

                     }catch(InterruptedException e){
                         Thread.currentThread().interrupt();
                     }

                 } // if

             }

             intermediateValues[i] = intermediate;


         }

         intermediateValues[intermediateValues.length - 1] = result;

         // short-cut method
         if(option.equals("2")){

             printShortCutMethod(intermediateValues);
             System.out.println(dashLine); // complete the workings with the final dash line

         }
         // otherwise complete the final prints for option 1
         else{

             System.out.println(
                 dashLine +
                 "\n" + stringRepeater( dashLine.length() - Integer.toString(result).length(), " ")
                 + result
             );
             System.out.println(dashLine); // complete the workings with the final dash line
         }

     }

    // overview of this program
    public Multiply(){

        intro();
        askUserOption();
        aboutMultiplication();
        askUserValues();
        multiplication(x, y);
    }


    public static void main(String[] args) {

    }
}
