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
        this.head = null;/*This matrix will point to nothing and effectively have all values read as zero*/
    }

    public void setSize(int size){
        this.size = size;
        this.head = null;/*This matrix will point to nothing and effectively have all values read as zero*/
    }
    public void addElement(int row, int column, int data){
        if(row > this.getSize() || column > this.getSize()){/*If user attempts to input data at a position greater than the size of the matrix*/
            throw new IndexOutOfBoundsException("The position of the matrix value you are attempting to add is out of bounds");
        }

        if(this.head == null){/*If this is the first entry into this matrix*/
            this.head = new MatrixNode(row, column, data);
            this.tail = this.head;
        }
        if(this.head.getRow() > row){/*If the new node is of a higher row than the head*/
            MatrixNode newNode = new MatrixNode(row, column,data);/*Initialize new node with correct position and value*/
            newNode.setNext(this.head);/*Set new nodes next to the previous head, making it the newNode the new head*/
            this.head = newNode;/*Set the head of the SparseMatrix to new node*/

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


