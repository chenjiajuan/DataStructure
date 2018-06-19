package com.chenjiajuan.datastructure;


import java.nio.BufferUnderflowException;

/**
 * Created by chenjiajuan on 2018/6/19.
 *
 * 二叉树，包含、删除、插入、寻找最大最小值。
 */

public class BinarySearchTree<AnyType extends Comparable< ? super AnyType>> {

    private  static class  BinaryNode<AnyType>{
        BinaryNode(AnyType theElement){
        }
        BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
            element=theElement;
            leftNode=lt;
            rightNode=rt;
        }
        BinaryNode leftNode;
        BinaryNode rightNode;
        AnyType element;
    }
    private BinaryNode<AnyType> root;
    public BinarySearchTree(){
        root=null;
    }
    public void  makeEmpty(){
        root=null;
    }
    public boolean isEmpey(){
        return root==null;
    }
    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public AnyType finMin(){
        if (isEmpey()) throw  new BufferUnderflowException();
        return finMin(root).element;
    }

    public AnyType finMax(){
        if (isEmpey()) throw  new BufferUnderflowException();
        return finMax(root).element;
    }

    public void insert(AnyType x){
        root=insert(x,root);
    }

    public void remove(AnyType x){
        root=remove(x,root);
    }

    public void printTree(){

    }

    //TODO
    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if (t==null)
        return  false;
        int compareResult=x.compareTo(t.element);
        if (compareResult<0){
            return contains(x,t.leftNode);
        }else if (compareResult>0){
            return contains(x,t.rightNode);
        }else {
            return true;
        }
    }
    //TODO
    private BinaryNode<AnyType> finMin(BinaryNode<AnyType> t){
        if (t==null)
        return null;
        else if (t.leftNode==null)
            return t;
        return finMin(t.leftNode);
    }
    //TODO
    private BinaryNode<AnyType> finMax(BinaryNode<AnyType> t){
        if (t==null)
        return null;
        else if (t.rightNode==null)
            return t;
        return finMax(t.rightNode);
    }
    //TODO
    public BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if (t==null)
        return new BinaryNode<AnyType>(x,null,null);
        int compareResult=x.compareTo(t.element);
        if (compareResult<0){
            t.leftNode=insert(x,t.leftNode);
        }else if (compareResult>0){
            t.rightNode=insert(x,t.rightNode);
        }else
            ;
        return t;
    }
    //TODO
    public BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
        if (t==null)
        return null;
        int compareResult=x.compareTo(t.element);
        if (compareResult<0){
            t.leftNode=remove(x,t.leftNode);
        }else if (compareResult>0){
            t.rightNode=remove(x,t.rightNode);
        }else if (t.leftNode!=null&&t.rightNode!=null){
            //若该节点有两个节点，则需要处理其子节点
            //寻找其子节点中较小的一项，成为父节点。
            t.element= (AnyType) finMin(t.rightNode).element;
            t.rightNode=remove(t.element,t.rightNode);
        }else {
            //若该节少于一个孩子节点，判断其左节点是否不为空，
            t=(t.leftNode!=null)?t.leftNode:t.rightNode;
        }
        return t;
    }


}
