package com.company;

public class Main{
    public static void main(String[] args){
        SparseMatrix testMatrix = new SparseMatrix();
        testMatrix.setSize(5);

        testMatrix.addElement(0 , 0, 4);
        testMatrix.addElement(0, 1, 6);
        testMatrix.addElement(0,2, 37);
        testMatrix.addElement(0,4,5);
        testMatrix.addElement(1,0,28);
        testMatrix.addElement(1,1,13);
        testMatrix.addElement(1,2,7);
        testMatrix.addElement(1,3,8);
        testMatrix.addElement(2,1,1);
        testMatrix.addElement(2,2,47);
        testMatrix.addElement(2,4,9);
        testMatrix.addElement(3,0,6);
        testMatrix.addElement(3,3,58);
        testMatrix.addElement(4,2,17);
        testMatrix.addElement(4,3,5);
        testMatrix.addElement(4,4,19);

        System.out.println(testMatrix.toString());
        SparseInterface testMinor = testMatrix.minor(0,0);

        System.out.println(testMatrix.minor(0,0).toString());
        System.out.println(testMatrix.minor(0,0).minor(0,0).getSize());


    }

}