public class TreeNode<E> {
  private E data;
  private TreeNode<E> parent;
  private TreeNode<E> left;
  private TreeNode<E> right;

  // set par as null if ROOT
  // default constructor
  public TreeNode(E data, TreeNode<E> par){

    this.data = data;
    this.parent = par;
    this.left = null;
    this.right = null;
  }

// getter and setter
  public E getData(){
      return this.data;
  }
  public E setData(E d){
    this.data = d;
    return this.data;
  }

  // adds the left child to a node
  public TreeNode<E> addLeftChild(E val){

    this.left = new TreeNode<E>(val, this);
    return this.left;
  }
  // returns the left child of a TreeNode
  public TreeNode<E> getLeftChild(){
    retrun this.left;
  }

  // adds the right child to a TreeNode
  public TreeNode<E> addRightChild(E val){

    this.right = new TreeNode<E>(val, this);
    return this.right;
  }

  // returns the right child of a TreeNode
  public TreeNode<E> getRightChild(){
    return this.right;
  }

  public void visit(){
    System.out.println("Node: " + this.getData);
    System.out.println("Left node: " + this.getLeftChild.getData());
    System.out.println("Right node: " + this.getRightChild.getData());
  }
