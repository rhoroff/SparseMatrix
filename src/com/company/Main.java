package com.company;

public class Main{
    public static void main(String[] args){
        SparseMatrix testMatrix = new SparseMatrix();
        /*The Matrix is empty*/
        testMatrix.setSize(3);
        testMatrix.addElement(0,0,1);
        testMatrix.addElement(0,1,4);
        testMatrix.addElement(2,2,5);
        testMatrix.addElement(1,1,3);
        testMatrix.addElement(1,1,9);
        testMatrix.addElement(0,0,5);
        System.out.println(testMatrix.toString());
        System.out.println(testMatrix.getElement(0,0));
        System.out.println(testMatrix.getElement(0,1));
        System.out.println(testMatrix.getElement(1,1));
        System.out.println(testMatrix.getElement(2,2));









    }
}