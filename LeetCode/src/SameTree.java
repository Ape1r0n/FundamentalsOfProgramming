class treenode {
      int val;
      treenode left;
      treenode right;
      treenode() {}
      treenode(int val) { this.val = val; }
      treenode(int val, treenode left, treenode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class Solution {
    public boolean isSameTree(treenode p, treenode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}