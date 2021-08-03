package com.alibaba.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CBTInserter
 *
 * @author Frank Zhang
 * @date 2021-05-25 10:04 PM
 */
public class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root =  root;
        deque = new LinkedList<>();
        deque.offerLast(root);
    }

    public int insert(int v){
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        CBTInserter cbtInserter = new CBTInserter(root);

        cbtInserter.insert(3);
        cbtInserter.insert(4);
        cbtInserter.insert(5);
        cbtInserter.insert(6);

        TreeNode _root = cbtInserter.get_root();
        printNode(_root);
    }

    public static void printNode(TreeNode treeNode){
        System.out.println(treeNode.val + " Left:" + treeNode.left +" Right:"+treeNode.right);
        if(treeNode.left != null){
            printNode(treeNode.left);
        }
        if(treeNode.right !=null){
            printNode(treeNode.right);
        }
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      @Override
      public String toString(){
          return ""+val;
      }
}