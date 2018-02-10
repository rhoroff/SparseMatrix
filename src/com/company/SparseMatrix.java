package com.company;

public class SparseMatrix implements SparseInterface {
    private MatrixNode head;
    private MatrixNode tail;
    private int size;

    public SparseMatrix(){/*This constructor points the SparseMatrix to nothing, conveying an empty sparse matrix*/
        this.size = 5;
        this.head=null;
        this.tail=null;
    }
    public void clear(){
        this.head = null;/*This matrix will point to nothing and effectively have all values read as zero, garbage collection will take care of the rest*/
    }

    public void setSize(int size){
        this.size = size;
        this.head = null;/*This matrix will point to nothing and effectively have all values read as zero*/
    }
    public void addElement(int row, int column, int data){
        if(row > this.getSize() || column > this.getSize()){/*If user attempts to input data at a position greater than the size of the matrix*/
            throw new IndexOutOfBoundsException("The position that you entered does not fit in a matrix of this size");
        }
        if(this.head == null) {/*If this is the first entry into this matrix*/
            this.head = new MatrixNode(row, column, data);
            return;
        }
        if(this.head.getRow() == row && this.head.getCol()==column){/*If head is being overwritten*/
            MatrixNode newNode = new MatrixNode(row, column, data);
            newNode.setNext(this.head.next());
            this.head = newNode;
            return;
        }
        if((this.head.getRow() > row) ||(this.head.getCol() > column && this.head.getRow() == row)){/*If the new node is of a higher row than the head or if they are in the same row and the newNode is farther to the left*/
            MatrixNode newNode = new MatrixNode(row, column,data);/*Initialize new node with correct position and value*/
            newNode.setNext(this.head);/*Set new nodes next to the previous head, making it the new head*/
            this.head = newNode;/*Set the head of the SparseMatrix to new node*/
            return;
        }else{/*If this matrix node is not becoming the new head of the list*/
            MatrixNode newNode = new MatrixNode(row, column, data);/*Initialize new node with correct position and values*/
            MatrixNode curNode = this.head;/*Set the curNode to the head so as to compare newNode with the next value in the list*/
            if(curNode.next() == null){/*If the curNode is the tail of the matrix*/
                if(row < curNode.getRow() || (newNode.getRow() == curNode.getRow()) && (column < curNode.getCol())){
                    newNode.setNext(curNode);
                    this.head = newNode;
                }
                else{
                    curNode.setNext(newNode);
                }
                return;
            }
            while(curNode.next() != null) {/*While the curNode is not the end of the list or there isn't just one value in the matrix*/
                if (row < curNode.next().getRow()) {/*If the row for the new entry is less than the row of the next entry (implying there is nothing in the new row for this node)*/
                    newNode.setNext(curNode.next());/*Set the newNode's next to the current node and remainder of list*/
                    curNode.setNext(newNode);/*Set the curNode's next to newNode*/
                    return;
                }
                if (row == curNode.next().getRow() && column == curNode.next().getCol()) {/*If data is being overwritten*/
                    newNode.setNext(curNode.next().next());
                    curNode.setNext(newNode);
                    return;
                }
                if (row == curNode.next().getRow()) {/*If the newNode is in the same row as the next node*/
                    if (column < curNode.next().getCol()) {/*If newNode is farther to the left in the same row as curNode.next()*/
                        newNode.setNext(curNode.next());/*Set the newNode's next to the current node and remainder of list*/
                        curNode.setNext(newNode);/*Set the curNode's next to newNode*/
                        return;
                    }
                    if (column > curNode.next().getCol()) {/*If newNode is farther the right in the same row as cureNode.next()*/
                        if(curNode.next().next() == null) {
                            curNode.next().setNext(newNode);
                            return;
                        }else if (curNode.next().next().getCol() < column) {
                            curNode = curNode.next();
                            continue;
                        }else{
                            newNode.setNext(curNode.next().next());
                            curNode.next().setNext(newNode);
                            return;
                        }
                    }
                }
                if(curNode.next().next() == null){/*If the curNode is the tail of the matrix*/
                    if(row < curNode.next().getRow() || (newNode.getRow() == curNode.next().getRow()) && (column < curNode.next().getCol())){
                        newNode.setNext(curNode.next());
                        curNode.setNext(newNode);
                    }
                    else{
                        curNode.next().setNext(newNode);
                    }
                    return;
                }
                curNode = curNode.next();
            }
        }
    }
    public void removeElement(int row, int column){
        if(row > this.getSize() || column > this.getSize()){/*If user attempts to input data at a position greater than the size of the matrix*/
            throw new IndexOutOfBoundsException("The position that you entered does not fit in a matrix of this size");
        }
        MatrixNode curNode = this.head;
        if(row == this.head.getRow() && column == this.head.getCol()){/*If the element being removed is the first element in the matrix*/
            if(this.head.next() == null){
                this.head = null;
                return;
            }else
                this.head = this.head.next();/*set the head to the next of the head*/
            return;
        }else{
            while (curNode.next()!= null){
                if (row == curNode.next().getRow() && column == curNode.next().getCol()){/*If the next element is the element for deletion*/
                    if(curNode.next().next() == null){/*If the element for deletion is the last item in the list*/
                        curNode.setNext(null);/*Delete everything after the curNode*/
                        return;
                    }else{
                        curNode.setNext(curNode.next().next());/*Remove the designated element from the list*/
                        return;
                    }
                }
                curNode = curNode.next();
            }
        }
    }
    public int getElement(int row, int column){
        if(row > this.getSize() || column > this.getSize()){/*If user attempts to input data at a position greater than the size of the matrix*/
            throw new IndexOutOfBoundsException("The position that you entered does not fit in a matrix of this size");
        }
        if(this.head ==null){/*An empty matrix will return zero for any value that is in the bounds of the matrix*/
            return 0;
        }
        MatrixNode curNode = this.head;
        if(curNode.next() == null){/*If this is the tail of the matrix*/
            if(curNode.getRow() == row && curNode.getCol() == column){/*If curNode is the right entry*/
                return curNode.getEntryValue();
            }else{/*The only entry is not the value*/
                return 0;
            }
        }

        while(curNode.next()!= null){/*While there are still entries that are not zero*/
            if(curNode.getRow() == row && curNode.getCol() == column){/*If curNode is the right entry*/
                return curNode.getEntryValue();
            }else{/*Loop continuation and curNode is tail edge conditions*/
                curNode = curNode.next();
                if (curNode.next() == null){/*If curNode is now the tail*/
                    if (curNode.getRow() == row && curNode.getCol() == column){/*If the tail is the right entry*/
                        return curNode.getEntryValue();
                    }else{/*If the entry has not been found in the linked list, then the value of that entry is zero*/
                        return 0;
                    }
                }
            }
        }
        return 0;
    }
    public int determinant(){
        return 2;
    }
    public SparseInterface minor(int row, int col) {
        return null;
    }

    public String toString() {
        MatrixNode curNode = this.head;
        if(curNode == null){
            return ("");
        }
        StringBuilder matrix = new StringBuilder();
        while(curNode.next() != null){
            matrix.append(Integer.toString(curNode.getRow()) + " "  +Integer.toString(curNode.getCol()) + " " + Integer.toString(curNode.getEntryValue()) +"\n");
            curNode = curNode.next();
            if (curNode.next() == null){
                matrix.append(Integer.toString(curNode.getRow()) + " "  +Integer.toString(curNode.getCol()) + " " + Integer.toString(curNode.getEntryValue()) +"\n");
            }
        }
        return matrix.toString();
    }
    public int getSize(){/*Returns the amount of rows and columns in the matrix*/
        return this.size;
    }
}


