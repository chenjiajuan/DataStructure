package com.chenjiajuan.datastructure.avl;

/**
 *
 *平衡二叉树
 */
public class AvlBinarySearchTree<AnyType extends  Comparable<? super AnyType>> {

    public static class AvlNode<AnyType>{
        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;
        AvlNode(AnyType theElement){
            this(theElement,null,null);
        }
        AvlNode(AnyType theElement,AvlNode<AnyType> left,AvlNode<AnyType> right){
            this.element=theElement;
            this.left=left;
            this.right=right;
            height=0;
        }
    }

    private AvlNode<AnyType> insert(AnyType x,AvlNode<AnyType> t){
        if (t==null)
            return null;
        int compareResult=x.compareTo(t.element);
        if (compareResult>0){
            t.right=insert(x,t.right);
        }else if (compareResult<0){
            t.left=insert(x,t.left);
        }else
            ;
        return  balance(t);
    }

    private AvlNode<AnyType> balance(AvlNode<AnyType> t){
        if (t==null)
            return  null;
        if (height(t.right)-height(t.left)>1){
            //如果右边比左边深，需要旋转右边的节点
            if (height(t.right.right)>=height(t.right.left)){
                //如果其右子树比左子树深，需要双旋转
                t=doubleWidthRightChild(t);
            }else {
                t=rotateWidthRightChild(t);
            }
        }else {
            //左子树，右边比左边深
            if (height(t.left.right)>=height(t.left.left)){
                t=doubleWidthLeftChild(t);
            }else {
                rotateWidthLeftChild(t);
            }
        }
        t.height=Math.max(height(t.right),height(t.left))+1;
        return t;
    }

    private  int height(AvlNode<AnyType> t){
        return  t==null? -1:t.height;
    }

    /**
     *
     * @param t
     * @return
     */
    private AvlNode<AnyType> rotateWidthRightChild(AvlNode<AnyType> t){
        if (t==null)
        return null;
        AvlNode<AnyType> k1=t.right;
        t.right=k1.left;
        k1.left=t;
        t.height=Math.max(height(t.left),height(t.right))+1;
        k1.height=Math.max(height(t.right),height(t.left))+1;
        return k1;
    }

    /**
     * 先旋转右子节点，再旋转节点
     * @param t
     * @return
     */
    private AvlNode<AnyType> doubleWidthRightChild(AvlNode<AnyType> t){
        t.right=rotateWidthLeftChild(t.right);
        return rotateWidthRightChild(t);
    }

    /**
     * 左树深，且左子树比右子树深
     * @param t
     * @return  返回根节点
     */
    private AvlNode<AnyType> rotateWidthLeftChild(AvlNode<AnyType> t){
        if (t==null)
        return null;

        AvlNode<AnyType> k1=t.left;
        t.left=k1.right;
        k1.right=t;
        t.height=Math.max(height(t.left),height(t.right))+1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        return k1;
    }

    //TODO 为什么旋转两次就正好调节完成
    /**
     *先旋转左子节点，对其进行右旋转，再对节点进行左旋转
     * @param t
     * @return
     */
    private AvlNode<AnyType> doubleWidthLeftChild(AvlNode<AnyType> t){
          t.left=rotateWidthRightChild(t.left);
        return rotateWidthLeftChild(t);
    }

}
