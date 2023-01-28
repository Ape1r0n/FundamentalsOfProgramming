class TreeNode {
        int val;
       treenode left;
       treenode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, treenode left, treenode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
}

class ValidBST{
    public boolean checkBST(treenode root, long minimum, long maximum) {
        if(root == null) return true;
        if(!(root.val < maximum && root.val > minimum)) return false;
        return checkBST(root.left, minimum, root.val) && checkBST(root.right, root.val, maximum);
    }

    public boolean isValidBST(treenode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
