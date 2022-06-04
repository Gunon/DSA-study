/*Problem URL: https://www.interviewbit.com/problems/minimum-lights-to-activate/
Problem Description:
There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
*/
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int i = 0;
        int lightsCount = 0;
        int arraySize = A.size();
        while (i < arraySize-1){
            int leftMost = Math.max(i-B+1,0);
            int rightMost = Math.min(i+B-1,arraySize-1);
            for(int x = rightMost;x>=leftMost;x--){
                if(A.get(x) == 1){
                    lightsCount++;
                    i=x+B;
                    break;
                }else if(A.get(x) == 0 && x == leftMost){
                    return -1;
                }
            }
        }
        return lightsCount;
    }
}
