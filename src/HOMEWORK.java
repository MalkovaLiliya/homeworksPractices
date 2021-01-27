import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class HOMEWORK {

    static char[][] map;
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_0 = '0';
    static final char DOT_EMPTY = '.';

            public static void main(String[] args)
        {
            initMap();
            printMap();
            while (true)
            {
                humanTurn();
                printMap();
                if (checkWin(DOT_X))
                {
                    System.out.println("Победил человек!");
                    break;
                }
                if (isMapFull())
                {
                    System.out.println("Ничья");
                    break;
                }

                aiTurn();
                printMap();

                if (checkWin(DOT_0))
                {
                    System.out.println("Победил компьютер!");
                    break;
                }
                if (isMapFull())
                {
                    System.out.println("Ничья");
                    break;
                }
            }

        }
        static void initMap()
        {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map.length; j++)
                {
                    map[i][j] = DOT_EMPTY;
                }

            }
        }

    static void printMap()
    {
        for (int i = 0; i <= SIZE; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++)
        {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

        static void humanTurn()
        {
            Scanner scanner = new Scanner(System.in);
            int x;
            int y;

            do {
                System.out.println("Введите координаты в формате X Y");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            }
            while (!isCellValid(x, y));

            map[y][x] = DOT_X;
        }

        static void aiTurn()
        {
            Random random = new Random();
            int x;
            int y;

            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
            while (!isCellValid(x, y));

            map[y][x] = DOT_0;

            System.out.println("Компьютер сходил в точку " + (x +1) + " " + (y + 1));
        }

        static boolean isCellValid(int x, int y)
        {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            {
                return false;
            }
            if (map[y][x] == DOT_EMPTY)
            {
                return true;
            }
            return false;
        }

        static boolean checkWin(char sym)
        {
            //проверка по диагоналям
            int countL = 0;
            int countR = 0;
            int countColumn = 0;
            int countRow = 0;
            for (int i = 0; i < map.length; i++)
            {
                if (map[i][map.length - 1 - i] == sym)
                    countR++;
                //добавила везде else, т.к. без него выигрывает 4 фишки в ряд не стоящие рядом
                else countR =0;
                if (map[i][i] == sym)
                    countL++;
                else  countL = 0;
            }

            //строки и столбцы
            for (int i = 0; i < map.length; i++)
            {
                countColumn = 0;
                countRow = 0;
                for (int j = 0; j < map.length; j++)
                {
                    if (map[i][j] == sym)
                        countRow++;
                    else countRow = 0;
                    if (map[j][i] == sym)
                        countColumn++;
                    else countColumn = 0;
                    if (countColumn >= (SIZE - 1) || countRow >= (SIZE - 1))
                        return true;
                }

            }
            return countL >= (SIZE - 1) || countR >= (SIZE - 1);
        }

        static boolean isMapFull()
        {
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map.length; j++)
                {
                    if (map[i][j] == DOT_EMPTY)
                    {
                        return false;
                    }
                }

            }
            return true;
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
