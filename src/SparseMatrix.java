import com.sun.xml.internal.bind.v2.TODO;

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

        if(this.head == null){/*If this is the first entry into this matrix*/
            this.head = new MatrixNode(row, column, data);
            this.tail = this.head;
        }

        if((this.head.getRow() > row) ||(this.head.getCol() > column && this.head.getRow() == row)){/*If the new node is of a higher row than the head or if they are in the same row and the newNode is farther to the left*/
            MatrixNode newNode = new MatrixNode(row, column,data);/*Initialize new node with correct position and value*/
            newNode.setNext(this.head);/*Set new nodes next to the previous head, making it the new head*/
            this.head = newNode;/*Set the head of the SparseMatrix to new node*/
        }
        else{/*If this matrix node is not becoming the new head of the list*/
            MatrixNode newNode = new MatrixNode(row, column, data);/*Initialize new node with correct position and values*/
            MatrixNode curNode = this.head;/*Set the curNode to the head so as to compare newNode with the next value in the list*/
            while(curNode != this.tail){/*While the curNode is not the end of the list*/
                if(newNode.getRow() < curNode.next().getRow()){/*If the row for the new entry is less than the row of the next entry (implying there is nothing in the new row for this node)*/
                    newNode.setNext(curNode.next());/*Set the newNode's next to the current node and remainder of list*/
                    curNode.setNext(newNode);/*Set the curNode's next to newNode*/
                }
                if(newNode.getRow() == curNode.next().getRow()){
                    if(column < curNode.next().getCol()){/*If newNode is farther to the left in the same row as curNode.next()*/
                        newNode.setNext(curNode.next());/*Set the newNode's next to the current node and remainder of list*/
                        curNode.setNext(newNode);/*Set the curNode's next to newNode*/
                    }
                    if (column > curNode.next().getCol()){/*If newNode is farther the right in the same row as cureNode.next()*/
                        newNode.setNext(curNode.next().next());/*Set newNode's next to the node after the curNode's next*/
                        curNode.next().setNext(newNode);/*Set curNode's next.next() to new Node*/

                    }
                }



            }
        }




    }
    public void removeElement(int row, int col){

    }
    public int getElement(int row, int col){
        return 2;
    }
    public int determinant(){
        return 2;
    }
    public SparseInterface minor(int row, int col) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public int getSize(){/*Returns the amount of rows and columns in the matrix*/
        return this.size;
    }
}


