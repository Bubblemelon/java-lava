import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Console;


public class Hangman {

    //variables
    List<Character> uniChars = new ArrayList<Character>(); // list containning unique characters
    List<Character> yay = new ArrayList<Character>(); // list of guessed correctly characters
    int tryNum =4; // set 4 to default tries
    int guessCharNum =0; // number of unique letters to guess
    int hintsUsed = 0;


    //finds the unique characters from word/phrase input;
    public int findCharNum(String s){
        int counter = 0;

        for(int i = 0; i < s.length(); i++){

            if(!uniChars.contains(s.charAt(i)) && s.charAt(i) != ' '){
                uniChars.add(s.charAt(i));
                counter++;
            }
        }
        // System.out.println(chars);

        return counter;
    }

    // prints the game status
    // takes the word/phrase to guess
    // and list of already guessed letters.
    public void printStatus( String s, List<Character> y){
        System.out.println();
        System.out.print("So far, the word is: ");


        for(int i = 0; i < s.length(); i++){

            // if not a space char
            if( s.charAt(i) != ' ' ){

                // if character at string in guessed right list
                if( y.contains(s.charAt(i))){
                    //show this letter
                    System.out.print(s.charAt(i)+ " ");

                }else{
                    // print underscore instead to hide char
                    System.out.print("_ ");
                }

            }else{
                System.out.print("# ");
            }

        }

        System.out.println();
        System.out.println("You have " + tryNum + " incorrect guesses left.");

    }
    // invoked when user wants to guess letter
    //
    public void guessing( String w ){
        Scanner k = new Scanner(System.in);
        String userInput;

        while(true){
            try{
                System.out.print("Enter your guess: ");
                userInput = k.nextLine();
                if(userInput.length() != 0)
                {
                    // Only one letter
                    if(!userInput.matches("[A-Za-z]")){
                        throw new IllegalArgumentException("Only one alphabet!\n");
                    }
                    break;
                }

            }catch(IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
       }
            // k.close();
        	// should not close here otherwise this closes all scanners InputStream
            // https://stackoverflow.com/questions/15443383/scanner-nosuchelementexception

        //check userInput value against guess word/phrase
        //
        // save to use charAt(0) since only one letter checked
        if(!yay.contains(userInput.charAt(0))){

            // since all letters in the guess word is saved in caps
            // convert lower case to caps
            // doesn't matter if userinput already caps
            String upperCase = userInput.toUpperCase();

            if (!w.contains(upperCase)) {
                System.out.println("Sorry, " + userInput + " isn't in the word.");
                tryNum--;
            }else{
                yay.add(upperCase.charAt(0));
                System.out.println("That's right! " + userInput + " is in the word.");
                guessCharNum--;
            }

        }else{
            System.out.println("Not valid input. You already guessed " + userInput + ".");
        }

    }

    // provides the user a hint letter for the word
    public void hint(String w){

        // keep going on to the next letter so that a new hint is shown
        while(yay.contains(w.charAt(hintsUsed))){
            hintsUsed++;
        }
        System.out.println("OK! The hint is " + w.charAt(hintsUsed) );

        //add hint letter to guessed correct list
        yay.add(w.charAt(hintsUsed));

        hintsUsed++;
        guessCharNum--;
        tryNum--;
        System.out.println("But since you used the hint, you can guess " + tryNum + " more times.");

    }


    //print out guess word in Caps and with spaces between each letter
    public void reveal(String w){

        for(int i = 0; i < w.length(); i++){
            if(w.charAt(i)== ' '){
                System.out.print("# ");
            } else{
                System.out.print(w.charAt(i) + " ");
            }

        }
        System.out.println();
        System.out.println();

    }


    public static void main(String[] args) {

        //variables
        Hangman h = new Hangman();
		    String word=null; // the word to guess!
        Scanner keyboard = new Scanner(System.in);
        int selection =0;

        // console object
        Console console = null;

		/*
		 * Try asking for a word/phrase
		 */
		while(true){

      try{
          // create console object
          console = System.console();


          System.out.print("Enter a word to guess: ");

          // reads word without showing it on the console
          char[] secret = console.readPassword();

          word = String.valueOf(secret);

          // Only letters and spaces
          if(!word.matches("[A-Z ]+")){
            throw new IllegalArgumentException("Only Capital Letters!\n");
          }

          break;

      } catch(IllegalArgumentException e){
            	// prints out the throw exception above ^^^
                System.out.println(e.getMessage());

      } catch(Exception e){
      	// prints out the throw exception above ^^^
          System.out.println(e.getMessage());
          e.printStackTrace();
      }


		} // while true


        h.guessCharNum = h.findCharNum(word);

        while(h.tryNum !=0){

            if(h.guessCharNum == 0){
                break;
            }

            //prints game status
            h.printStatus(word, h.yay);

            while(true){
                try{
                    System.out.print("Enter either 1 for guessing or 2 for hint: ");
                    selection = keyboard.nextInt();
                    if(selection == 1){
                        // call guess function
                        h.guessing(word);
                    }
                    if(selection == 2){
                        // call hint function
                        h.hint(word);
                    }
                    break;

                }catch(InputMismatchException e){
                    // e.printStackTrace();
                    System.out.println("Incorrect Input.");
                    keyboard.next(); // to stop infinite loop !
                }
            }

        }



        if(h.guessCharNum == 0){
            System.out.println();
            System.out.print("Congratulations! The word was ");
            // call word print
            h.reveal(word);
        }else{
            System.out.println();
            System.out.print("You failed. The word was ");
            // call word print
            h.reveal(word);
        }



        keyboard.close();
        }// main


}// class
