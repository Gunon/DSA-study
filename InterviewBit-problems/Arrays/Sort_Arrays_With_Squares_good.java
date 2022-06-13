//Better solution for Sort Arrays With Squares problem in comparison to the "bad" file in this same directory
public class Solution {
    public int[] solve(int[] A) {
        int arraySize = A.length;
        int[] newArray = new int[arraySize];
        int leftIndex = 0;
        int newArrayIndex = arraySize-1;
        int rightIndex = arraySize-1;
        int rightValue;
        int leftValue;
        while(rightIndex>=leftIndex){
            rightValue = A[rightIndex]*A[rightIndex];
            leftValue = A[leftIndex]*A[leftIndex];
            if(rightValue>=leftValue){
                newArray[newArrayIndex] = rightValue;
                rightIndex--;                
            }else{
                newArray[newArrayIndex] = leftValue;
                leftIndex++;
            }
            newArrayIndex--;
        } 
        return newArray;
    }
}
