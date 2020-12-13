//搜索旋转排序数组
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1,mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            //如果mid左边为递增，mid到right为递增，则返回mid
            if (nums[mid] == target) {
                return mid;
            } else if (target<nums[mid] ) {
                //左边有序，且target在左边范围内
                if(nums[left]<=target||nums[mid]<nums[right]){//&&nums[left]<nums[mid]  因为target已经<mid，在left<target成立下，left肯定小于mid
                    right = mid - 1;    
                }else{
                    left = mid + 1;    
                }
            } else {
                if(nums[left]<nums[mid]||nums[right]>=target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
    target<mid,
        如果左边有序，left<mid,
            left<=target,则查左边.
            left>target,查右边
        否则mid<right,
            肯定不在右边，右边更大，只能查左边

    ---------------------------------
        由于left<=target时必然有left<mid。所以可总结为
            left<=target或者mid<right，则查左边
            否则查右边
    ================================================
    mid<target
        如果左边有序，left<mid,
            肯定不在左边，左边更小，查右边
        否则mid<right
            target<=right,则查右边
            target>right,则查左边
    ------------------------------------
        由于target<=right,肯定有mid<right,则总结为
            target<=right或left<mid，则查右边
            否则查左边
    */