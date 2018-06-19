package com.chenjiajuan.datastructure;

public class BinarySearchTest {

    public static void main(String [] args){
        BinarySearchTree<String>binarySearchTree=new BinarySearchTree<String>();
        binarySearchTree.insert("Aoe");
        binarySearchTree.insert("Tom");
        binarySearchTree.insert("Amy");
        binarySearchTree.insert("Rose");
        binarySearchTree.insert("Crystal");
        binarySearchTree.insert("Elven");
        binarySearchTree.insert("Alian");
        binarySearchTree.printTree();
        binarySearchTree.printRoot();
        binarySearchTree.remove("Crystal");
        System.out.println();
        binarySearchTree.printTree();
        binarySearchTree.printRoot();
    }
}
