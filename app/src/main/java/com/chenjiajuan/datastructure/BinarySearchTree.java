package com.chenjiajuan.datastructure;


import java.util.Comparator;

/**
 * Created by chenjiajuan on 2018/6/19.
 */

public class BinarySearchTree<AnyType extends Comparator<? super AnyType>> {
    private  static class  BinaryNode<AnyType>{
        BinaryNode leftNode;
        BinaryNode rightNode;

    }
    private BinaryNode<AnyType> root;
    public BinarySearchTree(){
        root=null;
    }


}
