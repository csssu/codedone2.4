import java.util.Scanner;
import java.util.Stack;

/**
 * @file ProblemFour.java
 * @author amir aghazadeh (cssu.ama@gmail.com)
 * @brief Linked list problem
 * @version 1.0.0
 * @date 2022-08-26
 * @id 4code2
 *
 * @copyright Copyright (c) 2022
 *
 */

public class ProblemFour {
    // define linked list Nodes class (implementation linked list)
    // تعریف گره لیست پیوندی (پیاده سازی لیست پیوندی)
    static class Node {
        int val = 0;
        Node next = null;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        // define N, for take number of numbers
        // تعریف ان، برای دریافت تعداد اعداد
        int N = scanner.nextInt();

        // define first Node (head)
        // تعریف اولین گره (سر)
        Node head = new Node();

        // get first Node value
        // دریافت مقدار اولین گره
        head.val = scanner.nextInt();

        Node temp = head;
        for (int i = 1; i < N; i++) {
            // define a new Node
            // تعریف گره جدید
            Node newNode = new Node();
            newNode.val = scanner.nextInt();

            // link newNode to last Node
            // گره جدید رو به گره آخر وصل کن
            temp.next = newNode;

            // go to next Node (That's the newNode).
            // برو به گره بعدی (همان گره جدید)
            temp = temp.next;
        }

        // Back to the first node
        // برگرد به گره اول
        temp = head;

        // define stack
        // پشته تعریف کن
        Stack<Integer> stack = new Stack<Integer>();

        // define a variable for save first even and set head for default
        // یک متغیر تعریف کن برای ذخیره کردن اولین مقدار زوج و مقدار پیش فرض این متغیر
        // رو اولین گره در نظر بگیر
        Node firstEven = head;

        while (temp != null) {
            if (temp.val % 2 != 0) {
                // while stack not empty(Reverse the value of even back nodes)
                // تا هنگامی که پشته خالی نیست (مقدار گره های زوج را برعکس کن)
                while (!stack.empty()) {
                    // Rewrite the value first even number with the out value of the stack
                    // بازنویسی مقدار اولین زوج با مقدار خروجی پشته
                    firstEven.val = stack.peek();
                    stack.pop();
                    firstEven = firstEven.next;
                }

                // set first Even to next Node
                // مقدار دهی متغیر اولین زوج با گره بعدی
                firstEven = temp.next;

                // set temp to next node (To check the nodes in the loop)
                // مقدار دهی متغیر "موقت" با گره بعدی (برای بررسی شدن به ترتیب گره ها در حلقه)
                temp = temp.next;
            } else {
                // put even value in stack
                // قرار دادن مقدار زوج در پشته
                stack.push(temp.val);
                temp = temp.next;
            }
        }

        // if stack not empty mean last node was the even. Do it like line 57 to 64.
        // اگر پشته خالی نبود یعنی آخرین گره زوج بوده. مانند خط 57 تا 64 انجام بده.
        while (!stack.empty()) {
            firstEven.val = stack.peek();
            stack.pop();
            firstEven = firstEven.next;
        }

        // go to first Node and printing Nodes value
        // به گره اول برو و مقدار گره ها را به ترتیب چاپ کن
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        scanner.close();
    }
}