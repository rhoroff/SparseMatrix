package com.company;

public class Main{
    public static void main(String[] args){
        SparseMatrix testMatrix = new SparseMatrix();
        testMatrix.setSize(3);
        testMatrix.addElement(0,0,1);
        testMatrix.addElement(0,1,2);
        testMatrix.addElement(0,2,3);
        testMatrix.addElement(1,0,4);
        testMatrix.addElement(1,1,5);
        testMatrix.addElement(1,2,6);
        testMatrix.addElement(2,0,7);
        testMatrix.addElement(2,1,8);
        testMatrix.addElement(2,2,9);
        System.out.println(testMatrix.determinant());
    }

}