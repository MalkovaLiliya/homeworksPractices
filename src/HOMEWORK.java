import javax.swing.*;

public class HOMEWORK {

            public static void main(String[] args)
        {
            changeElementsOfArray();
            fillArrayElementPlusThree();
            multiplicationElementsOfArray();
            fillDiagonalOfArrayByOne();
            findMaxAndMin();

            int[] arr = {17,-6,2,2,4,1,1, 14, 3};
            boolean answer = balanceOfArray(arr);
            System.out.println("\nTask 6\n" + answer);

            int shift = -3;
            int[] arrayToChange  = {1, 2, 3, 4, 5};
            shiftElementsOfArray(arrayToChange, shift);

        }
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
