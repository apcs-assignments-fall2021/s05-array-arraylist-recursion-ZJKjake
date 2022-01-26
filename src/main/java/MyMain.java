import java.util.ArrayList;

public class MyMain {
    // ********************
    // Examples From Class:
    // ********************

    // Use tail recursion to find the largest number in an array

    // Wrapper Method:
    public static int maxArray(int[] arr) {
        // Call tail recursive method, with i starting at 0
        return maxArrayTR(arr, 0, Integer.MIN_VALUE);
    }

    // Tail Recursive Method:
    public static int maxArrayTR(int[] arr, int i, int max) {
        // Base case
        if (i == arr.length) {
            return max;
        }
        // Recursive call
        else if (arr[i] > max) {
            return maxArrayTR(arr, i + 1, arr[i]);
        }
        else {
            return maxArrayTR(arr, i + 1, max);
        }
    }


    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to add up all the
    // values in an array

    // The tail recursive method is provided and wrapper method
    // is already set up for this problem

    // Examples:
    // sum([1, 2, 3, 4]) => 10
    // sum([4, 3, 2, 1]) => 10
    // sum([7, 3, 2, 8, 2, 3, 4]) => 29

    // Wrapper Method (Provided for you):
    public static int sum(int[] arr) {

        return sumTR(arr,0, 0);
    }

    // Tail Recursive Method:
    public static int sumTR(int[] arr, int i, int sum) {
        if (arr.length == 0) {
            return 0;
        }
        if (i>arr.length-1){
            return sum;
        }
        else{
            return sumTR(arr,i+1,sum+arr[i]);
        }

    }


    // Write a method that uses recursion to search to see
    // if an **ArrayList** contains a given value x

    // The tail recursive method is provided and wrapper method
    // is already set up for this problem

    // Examples:
    // search([1, 2, 3, 4], 1) => true
    // search([1, 2, 3, 4], 7) => false
    // search([7, 3, 2, 8, 2, 3, 4], 3) => true

    // Wrapper Method (Provided for you):
    public static boolean search(ArrayList<Integer> list, int x) {
        // YOUR CODE HERE
        return searchTR(list,0,x);
    }

    // Tail Recursive Method:
    public static boolean searchTR(ArrayList<Integer> list, int x, int i) {
        if (list.size() == 0) {
            return false;
        }
        if (x>list.size()-1){
            return false;
        }
        if (list.get(x)==i){
            return true;
        }
        if (list.size() == 1 &&list.get(0)==i){
            return true;
        }
        if (list.size() == 1 &&list.get(0)!=i){
            return true;
        }
        else{
            return searchTR(list,x+1,i);
        }
    }


    // Write a method that uses recursion to check if every number
    // in an **array** is even
    // Examples:
    // allEven([1, 2, 3, 4]) => false
    // allEven([0, 2, 6, 4]) => true
    // allEven([7, 3, 2, 8, 2, 3, 4]) => false

    // Wrapper Method (Provided for you):
    public static boolean allEven(int[] arr) {
        // YOUR CODE HERE
        return allEvenTR(arr,0);
    }
    public static boolean allEvenTR(int[] arr, int i) {
        if (arr.length == 0) {
            return false;
        }
        if (i>arr.length-1){
            return true;
        }
        if (arr[i]%2!=0){
            return false;
        }
        else{
            return allEvenTR(arr,i+1);
        }
    }
    // Tail Recursive Method:
    // You should write this yourself!


    // ********************
    // Examples From Class:
    // ********************
    public static void floodFill(char[][] mat, int row, int col) {
        // Check out of bounds, return
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length){
            return;
        }
        // If we're at wall, don't do anything
        else if (mat[row][col] == 'w') {
            return;
        }
        // If we've already visited there, let's return early
        else if (mat[row][col] == '*') {
            return;
        }
        else {
            // Leave "breadcrumbs"
            mat[row][col] = '*';

            // Visit our neighbors (left, up, right, down)
            floodFill(mat, row, col-1);
            floodFill(mat, row-1, col);
            floodFill(mat, row, col+1);
            floodFill(mat, row+1, col);
        }
    }



    // ********************
    // Methods for homework:
    // ********************

    // This recursive method checks if the array contains exactly
    // count copies of the integer x

    // Wrapper method
    public static boolean hasCountCopies(int[] arr, int x, int count) {
        // YOUR CODE HERE
        return hasCountCopiesTR(arr,x,count,0,0);
    }
    public static boolean hasCountCopiesTR(int[] arr, int x, int count, int num, int i) {
        if (arr.length==0){
            return false;
        }
        if (i>arr.length-1&&num==count){
            return true;
        }
        else if(i>arr.length-1&&num!=count){
            return false;
        }
        if(arr[i]==x){
            return (hasCountCopiesTR(arr, x, count, num+1,i+1));
        }
        else{
            return (hasCountCopiesTR(arr, x, count, num,i+1));
        }
    }
    // You may want a tail recursive method


    // This recursive method checks if the array is sorted in
    // non-decreasing order

    // Wrapper method
    public static boolean isSorted(ArrayList<Integer> list) {
        return isSortedTR(list,1,0);
    }
    public static boolean isSortedTR(ArrayList<Integer> list,int i, int count) {
        if (i>list.size()-1&&count==list.size()-1){
            return true;
        }
        else if(i>list.size()-1&&count!=list.size()-1){
            return false;
        }
        if(list.size()<=1){
            return true;
        }
        else{
            if(list.get(i)>=list.get(i-1)){
                return isSortedTR(list,i+1,count+1);
            }
            else{
                return isSortedTR(list,i+1,count);
            }
        }
    }
    // You may want a tail recursive method




    // Modify the flood fill algorithm to write an algorithm that looks for
    // the finish line in a maze
    // We’ll consider a 2D char array, where the character 'w'
    // represents a wall, the space character ' ' represents an empty hallway,
    // and the 'f' represents the finish line
    // For example:
    //                                                        row coordinates:
    //  char[][] mat = { {'w', 'w', ' ', 'w', 'w', 'w'},      // 0
    //                   {'w', ' ', ' ', 'w', 'f', 'w'},      // 1
    //                   {'w', ' ', 'w', 'w', ' ', 'w'},      // 2
    //                   {'w', ' ', ' ', ' ', ' ', 'w'},      // 3
    //                   {'w', 'w', 'w', ' ', 'w', 'w'},      // 4
    //                   {'w', ' ', ' ', ' ', 'w', ' '},      // 5
    //                   {'w', 'w', 'w', 'w', 'w', ' '} };    // 6
    // col coordinates:    0    1    2    3    4    5

    // We'll be given some starting coordinates (row, col) of where we start
    // in the maze
    // Examples:
    // escape(mat, 0, 0) => false because (0, 0) is a wall
    // escape(mat, 0, 2) => true because we should be able to make it to f at (1, 4)
    // escape(mat, 5, 1) => true because we should be able to make it to f at (1, 4)
    // escape(mat, 6, 5) => false because we get stuck

    // No tail recursion necessary!
    public static boolean escape(char[][] mat, int row, int col) {
        if(row>mat[0].length-1||col>mat.length-1){
            return false;
        }
        else if(mat[row][col] =='w'){
            return false;
        }
        else if(mat[row][col] =='f'){
            return true;
        }
        else if(mat[row][col] =='*'){
            return true;
        }
        else {
            mat[row][col]='*';
            return(escape(mat, row, col));
        }

    }






    public static void main(String[] args) {
        // Optional: Write some code here to test your methods!

        // row coordinates:
        char[][] mat = {   {'w', 'w', ' ', 'w', 'w', 'w'},      // 0
                           {'w', ' ', ' ', 'w', 'f', 'w'},      // 1
                           {'w', ' ', 'w', 'w', ' ', 'w'},      // 2
                           {'w', ' ', ' ', ' ', ' ', 'w'},      // 3
                           {'w', 'w', 'w', ' ', 'w', 'w'},      // 4
                           {'w', ' ', ' ', ' ', 'w', ' '},      // 5
                           {'w', 'w', 'w', 'w', 'w', ' '} };    // 6
        // col coordinates:  0    1    2    3    4    5
        System.out.println(escape(mat, 5, 1));
    }
}
