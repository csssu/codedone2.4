"""
  @file coddan2_4.py
  @author @mahdimma
  @brief Linked list problem
  @version 1.0.0
  @date 2022-08-1823
  @id 4code2
 
  @copyright Copyright (c) 2022
"""

from collections import deque


class Node:
    val = 0
    next = None


N = int(input())
listInput = [int(x) for x in input().split()]

head = Node()
temp = head
for x in listInput:
    temp.val = x
    newNode = Node()
    temp.next = newNode
    temp = temp.next

stk = deque()
temp = head
firstEven = head
while(temp.next != None):
    if(temp.val % 2 == 0):
        stk.append(temp.val)
        temp = temp.next
    else:
        while(len(stk) != 0):
            firstEven.val = stk.pop()
            firstEven = firstEven.next
        firstEven = temp.next
        temp = temp.next

while(len(stk) != 0):
    firstEven.val = stk.pop()
    firstEven = firstEven.next

temp = head
while(temp.next != None):
    print(temp.val, end=" ")
    temp = temp.next
