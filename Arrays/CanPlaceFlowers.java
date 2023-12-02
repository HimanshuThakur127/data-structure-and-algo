// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

// Example 1:

// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: true

// Example 2:
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: false

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int f=0;f<flowerbed.length;f++){
            // element not available on both sides..
            if(f-1 < 0 && f+1 >= flowerbed.length){
                if(flowerbed[f] == 0){
                    n--;
                    flowerbed[f] = 1;
                }
            }
            // if element not available on left side..
            else if(f-1 < 0 && flowerbed[f+1] == 0 && flowerbed[f] == 0){
                flowerbed[f] = 1;
                n--;
            }
            // if element not available on right side..
            else if(f+1 >= flowerbed.length && flowerbed[f-1] == 0 && flowerbed[f] == 0){
               flowerbed[f] = 1;
               n--;
            }
            // available on both sides...
            else{
                if((f-1>=0 && f+1 < flowerbed.length && flowerbed[f-1] == 0 
                    && flowerbed[f] == 0 && flowerbed[f+1] == 0)){
                    flowerbed[f] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}