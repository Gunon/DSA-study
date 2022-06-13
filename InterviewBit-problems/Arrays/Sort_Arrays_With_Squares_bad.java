/*  First solution approach for https://www.interviewbit.com/problems/sort-array-with-squares/ started with an idea that 
    due to bad analysis although the solution work its suboptimal and in the worst case (most right value is either 0 or the positive) time complexity becomse (n^2)
    also this solution fails if all values are negative due to first assumption, need to correct this solution, leaving this as a self reminder of
    what went wrong while solving for self reflection.

    Problem description:
    Given a sorted array A containing N integers both positive and negative.
    You need to create another array containing the squares of all the elements in A and return it in non-decreasing order.
    Try to this in O(N) time.
*/
public class Solution {
    public int[] solve(int[] A) {
        int arraySize = A.length;
        int[] newArray = new int[arraySize];
        int i = 0;
        while(A[i]<0){
            i++;
        }
        int leftIterator = i-1;
        int rightIterator = i;
        i = 0;
        int rightValue = 0; 
        int leftValue=0;
        boolean justLeft=false;
        boolean justRight=false;
        while(leftIterator>=0 || rightIterator<arraySize){
            if(!justLeft){
                rightValue=A[rightIterator]*A[rightIterator];
            }
            if(!justRight){
                leftValue=A[leftIterator]*A[leftIterator];
            }
            if(justRight){
                newArray[i]=rightValue;
                rightIterator++;
            }else if(justLeft){
                newArray[i]=leftValue;
                leftIterator--;
            }else{
                if(rightValue<=leftValue){
                    newArray[i]=rightValue;
                    rightIterator++;
                }else if(leftValue<rightValue){
                    newArray[i]=leftValue;
                    leftIterator--;
                }
            }
            if(rightIterator>=arraySize){
                justLeft = true;
            }
            if(leftIterator<0){
                justRight = true;
            }
            i++;
        }
        return newArray;
    }
}

//Note for future self, start from the edges and add from end of array, instead of focusing on adding from the start of the array