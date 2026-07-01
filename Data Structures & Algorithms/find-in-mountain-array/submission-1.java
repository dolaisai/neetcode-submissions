/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        //binary search 
        //calc mid
        //if mid - 1 > mid -> check left
        //if mid + 1 > mid -> check right
        //else we've found a mountain -> return mid

        int left = 0; 
        int right = mountainArr.length() - 1;

        int peak = findPeak(mountainArr,left, right); 
        System.out.println("peak index is: " + peak);
        int res = binarySearchAsc(mountainArr, left, peak, target);
        System.out.println("result of left side of peak check is: " + res);
        if(res == -1){
            res = binarySearchDesc(mountainArr, peak, right, target);
            System.out.println("result of right side of peak check is: " + res); 
        }
        return res;

         
    }
    public static int findPeak(MountainArray mountainArr, int left, int right){
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid); 
            if( mountainArr.get(mid - 1) < midVal && 
                mountainArr.get(mid + 1) < midVal){
                    return mid; 
                }
            else if(mountainArr.get(mid - 1) > midVal){
                right = mid - 1; 
            }
            else{
                left = mid + 1; 
            }
        } 
        return -1;
    }

    public int binarySearchAsc( MountainArray mountainArr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) == target){
                    return mid; 
                }
            else if(mountainArr.get(mid) > target){
                right = mid - 1; 
            }
            else{
                left = mid + 1; 
            }
        } 
        return -1;
    }
    public int binarySearchDesc( MountainArray mountainArr, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) == target){
                    return mid; 
                }
            else if(mountainArr.get(mid) < target){
                right = mid - 1; 
            }
            else{
                left = mid + 1; 
            }
        } 
        return -1;
    }
}