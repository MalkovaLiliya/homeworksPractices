import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class HOMEWORK {

            public static void main(String[] args)
        {
            System.out.println("What game do you want to play?\n" +
                    "0 - \"Guess the number\" or 1 - \"Guess the word\"");

            System.out.print("Enter number ");
            int answer = replayAnswer();
            if (answer == 0)
                gameGuessNumber();
            else if (answer == 1)
                guessTheWord();

        }

    //Practice Lesson Three
    // Task One
    static void gameGuessNumber()
    {
        Random rand = new Random();
        int secret = rand.nextInt(10);
        int count = 3;
        int answer;
        int enteredNumber;
        System.out.println("Welcome to the game 'Guess the number'!\n" +
                "You've " + count + " tries to guess random number from 0 to 9!");
        do {
            System.out.println("Let's GO! Guess the number, enter it:");
            for (int i = 0; i < count; i++)
            {
                System.out.println("");
                int tries =  count - 1 - i;
                enteredNumber = enterInteger();
                if (enteredNumber > secret && i < count - 1)
                    System.out.println("The hidden number is less!\nAvailable tries: " + tries);
                else if (enteredNumber < secret && i < count - 1)
                    System.out.println("The hidden number is bigger!\nAvailable tries: " + tries);
                else if (enteredNumber == secret)
                {
                    System.out.println("Congratulations! You win");
                    break;
                }
                else
                    System.out.println("Sorry, you've fail. Right number = " + secret);
            }
            System.out.println("\nDo you wanna play the game again?\n" +
                    "Yes - 1, Exit - 0");
            answer = replayAnswer();
        }
        while (answer == 1);
    }

    static int enterInteger()
    {
        Scanner sc = new Scanner(System.in);
        int enteredNumber;
        do {
            if (sc.hasNextInt())
            {
                return sc.nextInt();
            }
            System.out.println("Enter the integer number!");
            sc.nextLine();
        }
        while (true);
    }

    static int replayAnswer()
    {
        int answer;
        do
        {
            answer = enterInteger();
            if (answer == 1 || answer == 0)
                break;
            else
                System.out.println("Enter 0 or 1.");

        }
        while (answer != 0 || answer != 1);
        return answer;
    }
        static void guessTheWord()
        {
            String[] words =
                    {
                    "apple", "orange", "lemon", "banana", "apricot",
                            "avocado", "broccoli", "carrot", "cherry",
                            "garlic", "grape", "melon", "leek", "kiwi", "mango",
                            "mushroom", "nut", "olive", "pea", "peanut", "pear",
                            "pepper", "pineapple", "pumpkin", "potato"
                    };
            Random rand = new Random();
            String secret = words[rand.nextInt(words.length)];
            System.out.println("Welcome to the game \"Guess the word\"!\n" +
                    "The game chose one of these words:" +
                    "\n\napple, orange, lemon, banana, apricot, " +
                    "avocado, broccoli, carrot, cherry, " +
                    "garlic, grape, melon,\nleek, kiwi, mango, " +
                    "mushroom, nut, olive, pea, peanut, pear, " +
                    "pepper, pineapple, pumpkin, potato");
                System.out.println("\nEnter your word to guess");
                comparingTwoWords(secret);

        }

        static void  comparingTwoWords(String hiddenWord)
        {
            Scanner scan = new Scanner(System.in);
            do {
                String entered = scan.nextLine();
                if(entered.equals(hiddenWord))
                {
                    System.out.println("Right! You WIN");
                    break;
                }
                else
                {
                    tip(hiddenWord, entered);
                }
            }while (true);
        }

        static void tip(String hiddenWord, String entered)
        {
            char hWChar;
            char eChar;
            String tip = "";
            for (int i = 0; i < 15; i++)
                {
                    if(hiddenWord.length() <= entered.length() && i < hiddenWord.length()
                            || hiddenWord.length() >= entered.length() && i < entered.length())
                        {
                            hWChar = hiddenWord.charAt(i);
                            eChar = entered.charAt(i);
                            if (hWChar == eChar)
                                tip += eChar;
                            else
                                tip += "#";
                         }
                    else tip += "#";
                }
            if (tip.charAt(0) == entered.charAt(0))
                {
                    System.out.println("You've a letter match! Try again. Here are your tip: ");
                    System.out.println(tip);
                }
            else
                {
                    System.out.println("You haven't a letter match! Try again.");
                }
        }
        //Practice lesson two
        //Task 1
        static void changeElementsOfArray()
        {
            System.out.println("Task 1");
            int[] oneNull = {0, 0, 1, 0, 1, 1, 0, 1, 0};

            for (int i = 0; i < oneNull.length; i++) {
                if (oneNull[i] == 0)
                    oneNull[i]++;
                else
                    oneNull[i]--;
                System.out.print(oneNull[i] + " ");
            }
        }

        //Task 2
        static void fillArrayElementPlusThree()
        {
            System.out.println("\n\nTask 2");
            int[] fillArray = new int[8];
            for (int i = 0; i < fillArray.length; i++)
            {
                fillArray[i] = 3 * i;
                System.out.print(fillArray[i] + " ");
            }
        }

        //Task 3
        static void multiplicationElementsOfArray()
        {
            System.out.println("\n\nTask 3");
            int[] mArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int i = 0; i < mArray.length; i++) {
                if (mArray[i] < 6) {
                    mArray[i] *= 2;
                    System.out.print(mArray[i] + " ");
                } else
                    System.out.print(mArray[i] + " ");
            }
        }

        //Task 4
        static void fillDiagonalOfArrayByOne()
        {
            System.out.println("\n\nTask 4");
            int[][] diagonal = new int[5][5];
            for (int i = 0; i < diagonal.length; i++)
            {
                for (int j = 0; j < diagonal.length; j++)
                {
                    if (i == j)
                        diagonal[i][j] = 1;
                    diagonal[i][diagonal.length - 1 - i] = 1;
                    System.out.print(diagonal[i][j] + " ");
                }
                System.out.println();
            }
        }
        //Task 5
        static void findMaxAndMin()
        {
            System.out.println("\nTask 5");
            int[] maxMin = {-63, 12, -156, 0, 789, 100, 2021, 11, -9955, 2 };
            int max = 0;
            int min = 0;
            for (int i = 0; i < maxMin.length; i++)
            {
                if (maxMin[i] > max)
                    max = maxMin[i];
                else if (maxMin[i] < min)
                    min = maxMin[i];
            }
            System.out.println("The maximum of array = " + max);
            System.out.println("The minimum of array = " + min);
        }

        //Task 6
        static boolean balanceOfArray(int[] a)
        {
            int sumLeft = a[0];
            int sumRight = 0;
            for (int i = 1; i < a.length; i++)
            {
                sumRight = sumRight + a[i];
            }
            for (int i = 1; i < a.length; i++)
            {
                if (sumRight == sumLeft)
                    break;
                else {
                    sumLeft = sumLeft + a[i];
                    sumRight = sumRight - a[i];
                }
            }

            return sumRight == sumLeft;
        }
        //Task 7
        static void shiftElementsOfArray(int doShift[], int shift)
        {
            int storage;
            int c = 0;
            System.out.print("\nTask 7\nShift = " + shift +"\nBefore: ");
            for (int j = 0; j < doShift.length; j++)
            {
                System.out.print(doShift[j] + " ");
            }
            if (shift>=0)
            {
                while (c < shift)
                {
                    storage = doShift[doShift.length - 1];
                    for (int i = doShift.length - 1; i > 0; i--)
                    {
                        doShift[i] = doShift[i - 1];
                    }
                    c++;
                    doShift[0] = storage;
                }
                for (int j = 0; j < doShift.length; j++)
                {
                    System.out.print(" " + doShift[j]);
                }
            }
            else
            {
                while (c > shift)
                {
                    storage = doShift[0];
                    for (int i = 0; i < doShift.length - 1; i++)
                    {
                        doShift[i] = doShift[i + 1];
                    }
                    c--;
                    doShift[doShift.length - 1] = storage;
                }
                System.out.print("\nAfter: ");
                for (int j = 0; j < doShift.length; j++)
                {
                    System.out.print(doShift[j] + " ");
                }
            }
        }

            }
