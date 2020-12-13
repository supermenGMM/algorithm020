学习笔记
# 深度优先模板
## 递归法
	`
	//Java
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> allResults = new ArrayList<>();
	        if(root==null){
	            return allResults;
	        }
	        travel(root,0,allResults);
	        return allResults;
	    }


	    private void travel(TreeNode root,int level,List<List<Integer>> results){
	        if(results.size()==level){
	            results.add(new ArrayList<>());
	        }
	        results.get(level).add(root.val);
	        if(root.left!=null){
	            travel(root.left,level+1,results);
	        }
	        if(root.right!=null){
	            travel(root.right,level+1,results);
	        }
	    }
	`
## 迭代法
	`
	//C/C++
	//非递归写法：
	void dfs(Node* root) {
	  map<int, int> visited;
	  if(!root) return ;

	  stack<Node*> stackNode;
	  stackNode.push(root);

	  while (!stackNode.empty()) {
	    Node* node = stackNode.top();
	    stackNode.pop();
	    if (visited.count(node->val)) continue;
	    visited[node->val] = 1;


	    for (int i = node->children.size() - 1; i >= 0; --i) {
	        stackNode.push(node->children[i]);
	    }
	  }

	  return ;
	}
	`
# 广度优先模板
	`
	//Java
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int x) {
	        val = x;
	    }
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
	    List<List<Integer>> allResults = new ArrayList<>();
	    if (root == null) {
	        return allResults;
	    }
	    Queue<TreeNode> nodes = new LinkedList<>();
	    nodes.add(root);
	    while (!nodes.isEmpty()) {
	        int size = nodes.size();
	        List<Integer> results = new ArrayList<>();
	        for (int i = 0; i < size; i++) {
	            TreeNode node = nodes.poll();
	            results.add(node.val);
	            if (node.left != null) {
	                nodes.add(node.left);
	            }
	            if (node.right != null) {
	                nodes.add(node.right);
	            }
	        }
	        allResults.add(results);
	    }
	    return allResults;
	}`

# 二分模板
// Java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}


# 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
   //搜索旋转排序数组
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1,mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            //如果mid左边为递增，mid到right为递增，则返回mid
            if(nums[mid-1]>nums[left]&&nums[mid]<nums[right]){
                return mid;
            }else if(nums[mid]>nums[left]&&nums[mid+1]<nums[right]){
                return mid+1;
            }
            else if(nums[mid]<nums[left]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }