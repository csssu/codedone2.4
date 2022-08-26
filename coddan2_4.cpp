/**
 * @file coddan2_4.cpp
 * @author @mahdimma
 * @brief Linked list problem
 * @version 1.0.0
 * @date 2022-08-1823
 * @id 4code2
 *
 * @copyright Copyright (c) 2022
 *
 */


#include <iostream>
#include <stack>
using namespace std;

//define linked list Nodes class (implementation linked list)
//تعریف گره لیست پیوندی (پیاده سازی لیست پیوندی)
class Node
{
public:
    int val = 0;
    Node* next = NULL;
};

int main()
{
    //define N, for take number of numbers
    //تعریف ان، برای دریافت تعداد اعداد
    int N;
    cin >> N;
    //define first Node (head)
    //تعریف اولین گره (سر)
    Node* head = new Node();
    //get first Node value
    //دریافت مقدار اولین گره
    cin >> head->val;
    Node* temp = head;
    for (int i = 1; i < N; i++)
    {
        //define a new Node
        //
        Node* newNode = new Node();
        cin >> newNode->val;
        //linking newNode to last Node
        //
        temp->next = newNode;
        //goeing to next Node (That's the newNode).
        //
        temp = temp->next;
    }
    //Back to the first node
    //
    temp = head;
    //define stack
    //
    stack <int> stk;
    //define a variable for save first even and set head for default
    //
    Node* firstEven = head;
    //while temp defined
    //
    while (temp != NULL)
    {
        if (temp->val % 2 != 0)
        {
            //while stack not empty(Reverse the value of even back nodes)
            // تا هنگامی که پشته خالی نیست (مقدار گره های زوج را برعکس کن)
            while (!stk.empty())
            {
                // Rewrite the value first even number with the out value of the stack
                // بازنویسی مقدار اولین زوج با مقدار خروجی پشته
                firstEven->val = stk.top();
                stk.pop();
                firstEven = firstEven->next;
            }
            // set first Even to next Node
            // مقدار دهی متغیر اولین زوج با گره بعدی
            firstEven = temp->next;
            //set temp to next node (To check the nodes in the loop)
            //مقدار دهی متغیر "موقت" با گره بعدی (برای بررسی شدن به ترتیب گره ها در حلقه)
            temp = temp->next;
        }
        else
        {
            //puting even value in stack
            //قرار دادن مقدار زوج در پشته
            stk.push(temp->val);
            temp = temp->next;
        }
    }
    //if stack not empty mean last node was the even. Do it like line 57 to 64.
    //اگر پشته خالی نبود یعنی آخرین گره زوج بوده. مانند خط 57 تا 64 انجام بده.
    while (!stk.empty())
    {
        firstEven->val = stk.top();
        stk.pop();
        firstEven = firstEven->next;
    }
    // go to first Node and printing Nodes value
    // به گره اول برو و مقدار گره ها را به ترتیب چاپ کن
    temp = head;
    while (temp != NULL)
    {
        cout << temp->val << " ";
        temp = temp->next;
    }
    return 0;
}