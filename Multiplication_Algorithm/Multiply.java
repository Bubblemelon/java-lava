import java.util.*;

public class Multiply {

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

    // overview of this program
    public Multiply(){

        intro();
    }


    public static void main(String[] args) {

    }
}
