/**
 * @file ProblemThree.cs
 * @author Amir khaksar (ah_khaksar@yahoo.com)
 * @brief count letters
 * @version 0.1.0
 * @date 2022-08-26
 * @id 2code2
 * @Compailer dot net
 * @copyright Copyright (c) 2022
 *
 */

using System;

namespace FourthWeek
{
    internal class Program
    {
        public static int PrintMaxActivities(int[] s, int[] f, int size)
        {
            int i = 0, j;
            int Counter;
            Counter = 1;


            for (j = 1; j < size; j++)
            {
                if (s[j] >= f[i])
                {
                    Counter++;
                    i = j;
                }
            }
            return Counter;
        }

        private static void Main(string[] args)
        {
            #region define
            int Size = Convert.ToInt16(Console.ReadLine());
            int[] FirstArray = new int[Size];
            int[] SecondArray = new int[Size];
            int Output;
            #endregion

            string[] Numbers = Console.ReadLine().Split();
            for (int i = 0; i < Size; i++)
            {
                FirstArray[i] = int.Parse(Numbers[i]);
            }

            Numbers = Console.ReadLine().Split();
            for (int i = 0; i < Size; i++)
            {
                SecondArray[i] = int.Parse(Numbers[i]);
            }



            Output = PrintMaxActivities(FirstArray, SecondArray, Size);
            Console.Write(Output);
        }
    }
}
