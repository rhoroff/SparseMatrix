package com.company;
public class MatrixNode {
    private int row;
    private int col;
    private int entryValue;
    private MatrixNode next;

    public MatrixNode(){
        next = null;

    }
    public MatrixNode(int newRow, int newCol, int newValue){
        this.row = newRow;
        this.col = newCol;
        this.entryValue = newValue;

    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public MatrixNode next(){
        return this.next;
    }
    public void setNext(MatrixNode nextNode){
        this.next = nextNode;
    }
    public int getEntryValue(){
        return this.entryValue;
    }
}
