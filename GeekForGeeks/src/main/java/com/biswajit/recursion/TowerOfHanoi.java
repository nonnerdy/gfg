package com.biswajit.recursion;

/*
The tower of Hanoi is a famous puzzle where we have three rods and N disks.
The objective of the puzzle is to move the entire stack to another rod.
You are given the number of discs N. Initially,
 these discs are in the rod 1.
 You need to print all the steps of discs movement so that all the discs reach the 3rd rod.
 Also, you need to find the total moves.
Note: The discs are arranged such that the top disc is numbered 1 and the bottom-most disc is numbered N.
Also, all the discs have different sizes and a bigger disc cannot be put on the top of a smaller disc.
Refer the provided link to get a better clarity about the puzzle.


Example 1:

Input:
N = 2
Output:
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3
3
Explanation: For N=2 , steps will be
as follows in the example and total
3 steps will be taken.

Example 2:

Input:
N = 3
Output:
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3
7
Explanation: For N=3 , steps will be
as follows in the example and total
7 steps will be taken
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 24; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');
    }
    static void towerOfHanoi(int n, char from_rod,
                             char to_rod, char aux_rod)
    {
        if (n == 0)
        {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk "+ n + " from rod " +
                from_rod +" to rod " + to_rod );
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }
}
