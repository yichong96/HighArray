public class MatrixLinkedList<T> {

  /**
   * Implements a matrix using a linkedList data structure.
   */
  private Link<T> upperLeft;

  /**
   * number of rows for this matrix
   */
  private int rows;
  /**
   * number of cols for this matrix.
   */
  private int cols;

  /**
   * constructs a matrix using a linked list.
   * @param rows number of rows
   * @param cols number of cols
   */
    public MatrixLinkedList(int rows, int cols) {

      this.upperLeft = new Link<T>();
      upperLeft.row = 2;
      upperLeft.col = 2;
      this.rows = rows;
      this.cols = cols;
      constructMatrix(upperLeft,rows);
    }


  /**
   * Construct matrix by first initializing the upperleft link.
   * Creates the number of links corresponding to each row. As the links are
   * created for each row. A concurrent link is created below which will set
   * up a link from the current link to the right and down. Continues until
   * the whole row is filled. Recursively apply the same step to the bottom row.
   * @param initLink the upperLeft link in the matrix.(0 0)
   * @param rows the number of rows to construct.
   */
    public void constructMatrix(Link<T> initLink, int rows) {
      if (rows == 0) {
        return;
      } else {
        Link<T> current = initLink;
        Link<T> nextInitLink = initLink;
        for (int i = 0; i < cols - 1; i++) {
          Link<T> newLeftLink = new Link<T>();
          current.left = newLeftLink;
          // checks to see whether last row is in creation. Dont want to
          // create bottom links when the last row is created.
          if (rows != 1) {
            Link<T> newDownLink = new Link<T>();
            current.down = newDownLink;
          }
          current = newLeftLink;
        }
        constructMatrix(nextInitLink.down, rows - 1);
      }
    }


  /**
   * displays the matrix.
   */
  public void displayMatrix() {
      Link<T> downLink = upperLeft;
      while (downLink != null) {
        displayRow(downLink);
        downLink = downLink.down;
      }
    }

  /**
   * method to add a new row above the matrix.
   */
  public void addTopRow() {
      Link<T> newLink = new Link<T>();
      Link<T> newUpperLeft = newLink;
      Link<T> current = upperLeft;
      for (int i = 0; i < cols - 1; i++) {
        Link<T> nextLink = new Link<T>();
        newLink.left = nextLink;
        newLink.down = current;
        current = current.left;
        newLink = nextLink;
      }
      upperLeft = newUpperLeft;
    }

  /**
   * inserts element into specified row and col of matrix.
   * @param data the data to be insertd.
   * @param row the row to insert data in.
   * @param col the col to insert data.
   */
    public void insertElement(T data, int row, int col) {
      Link<T> toInsert = upperLeft;
      for (int i = 0; i < row; i++) {
        toInsert = toInsert.down;
      }
      for (int j = 0; j < col; j++) {
        toInsert = toInsert.left;
      }
      toInsert.setData(data);
    }


  /**
   * helper method that is used in the displayMatrix method.
   * @param rowLink the 1st link of every row.
   */
  public void displayRow(Link<T> rowLink) {
      while (rowLink != null) {
        rowLink.display();
        rowLink = rowLink.left;
      }
      System.out.println();
    }


  /**
   * inner class Link that is only useful to the Matrix.
   * @param <T> the generic data type that the link stores.
   */
  public class Link<T> {


      protected Link<T> left;
      protected Link<T> down;
      protected T data;
      public int row;
      public int col;


      public Link(T data) {
        this.data = data;
      }

      public Link(){

      }

      public void setData(T data) {
        this.data = data;
      }


      public void display() {
        if (data == null) {
          System.out.print(0 + " ");
        } else {
          System.out.print(data.toString() + " ");
        }
      }

      public T getData() {
        return this.data;
      }
    }
  }

