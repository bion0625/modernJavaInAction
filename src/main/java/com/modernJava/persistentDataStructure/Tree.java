package com.modernJava.persistentDataStructure;

public class Tree {
    private String key;
    private int val;
    private Tree left;
    private Tree right;
    public Tree(String k, int v, Tree l, Tree r) {
        key = k; val = v; left = l; right = r;
    }

    public String getKey() {
        return this.key;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Tree getLeft() {
        return this.left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return this.right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
