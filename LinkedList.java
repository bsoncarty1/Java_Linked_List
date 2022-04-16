//Brandon Soncarty

package lab6.cscd211linkedlist;
import java.util.*;

public class LinkedList<T extends Comparable <? super T>>
{
	/**
	 * The private Node class as discussed in class
	 */
   private class Node
   {
	   /**
	    * The Node class data element as T which is a generic that is Comparable
	    */
      public T data;
      
      /**
       * The Node class next reference for the singly linked list
       */
      public Node next;
      
      /**
       * The node class constructor that only takes the data item
       * @param data Representing the data
       */
      public Node(final T data)
      {
    	  this.data = data;
    	  this.next = null;

      }
      
      /**
       * The node class constructor that takes the data item and the next
       * reference
       * @param data Representing the data
       * @param next Representing the next reference
       */
      public Node(final T data, final Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   /**
    * The Class Level Head reference that allows us access to the list
    */
   private Node head;
   
   /**
    * The variable size that is a convenience for us
    */
   private int size;
   
   /**
    * Constructs an empty list.<br>
    * Dummy Head Node
    */
   public LinkedList()
   {
      this.head = new Node(null,null);
   }
   

   public int size()
   {
      return this.size;
   }
   

   public void clear()
   {
      head.next = null;
      size = 0;
   }
   

   public void addFirst(final T item)
   {
      //throw if item is null
     if(item == null) {
        throw new IllegalArgumentException("The item is null.");
     }

     //for size of 0
     if(size == 0) {
        head.next = new Node(item);
        size++;
     //all other sizes
     }else{
        Node temp = head.next;
        head.next = new Node(item);
        head.next.next = temp;
        size++;
     }

   }


   public int indexOf(final T item)
   {
      //throw if item is null
      if(item == null){
         throw new IllegalArgumentException("The item is null.");
      }
      //go through the list
      Node curr = head.next;
      for(int i = 0; i < size; i++){
         if(curr.data.equals(item)){
            return i;
         }
         curr = curr.next;
      }
      //return -1 if not found
      return -1;
   }
   

   public T removeFirst()
   {
      //throw if size is 0
      if(size == 0){
         throw new NoSuchElementException("The list is empty.");
      }
      //for if size is 1
      if(size == 1){
         Node temp = head.next;
         head.next = null;
         size--;
         return temp.data;
      //for all other sizes
      }else {
         Node temp = head.next;
         head.next = (head.next).next;
         size--;
         return temp.data;
      }
   }


   public T removeLast()
   {
      //throw if size is 0
      if(size == 0){
         throw new NoSuchElementException("The list is empty.");
      }

      //if only element in the list call removeFirst
      if(size == 1){
         removeFirst();
      //else go through list and remove the last item
      }else {
         Node curr = head.next;
         for (int i = 0; i < size - 2; i++) {
            curr = curr.next;
         }
         Node temp = curr.next;
         curr.next = null;
         size--;
         return temp.data;
      }
      return null;
   }
   

   public T remove(final int index)
   {
      //throws for out of bounds
      if(index < 0 || index >= size){
         throw new IndexOutOfBoundsException("The index is out of the range.");
      }
      //for if index is 0
      if(index == 0){
         removeFirst();
      //for if index is the last
      }else if(index == size - 1){
         removeLast();
      //for everything else
      }else {
         Node curr = head.next;
         for (int i = 1; i < index; i++) {
            curr = curr.next;
         }
         Node temp = curr.next;
         curr.next = curr.next.next;
         size--;
         return temp.data;
      }
      return null;
   }
   

   public void add(final int index, final T item)
   {
      //throws for null item and out of bounds
      if(item == null){
         throw new IllegalArgumentException("The item is null.");
      }
      if(index < 0 || index > size){
         throw new IndexOutOfBoundsException("The index is out of bounds.");
      }
      //add it to the index
      Node curr = head;
      for(int i = 0; i < index; i++){
         curr = curr.next;
      }
      Node temp = curr.next;
      Node newNode = new Node(item);
      curr.next = newNode;
      curr.next.next = temp;
      size++;

   }
   

   public boolean removeLastOccurrence(final T item)
   {
      //throw if item is null
      if(item == null){
         throw new IllegalArgumentException("The item is null.");
      }

      //go through list and remove last if it is found. return true or false
      Node curr = head.next;
      boolean changed = false;
      int index = 0;
      for(int i = 0; i < size; i++){
         if(curr.data.equals(item)){
            changed = true;
            index = i;
            curr = curr.next;
         }else {
            curr = curr.next;
         }
      }
      if(changed){
         remove(index);
      }
      return changed;
   }


   public boolean removeFirstOccurrence(final T item)
   {
      //throw if item is null
      if(item == null){
         throw new IllegalArgumentException("The item is null.");
      }

      //walk list and remove the index of the item if found
      Node curr = head.next;
      for(int i = 0; i < size; i++){
         if(curr.data.equals(item)){
            remove(i);
            return true;
         }
         curr = curr.next;
      }

      return false;
   }


   public void addLast(final T item)
   {
      //throw if item is null
      if(item == null){
         throw new IllegalArgumentException("The item is null.");
      }
      //addFirst if the size of the list is 0
      if(size == 0){
         addFirst(item);
      //if size is bigger than 0
      }else{
         Node curr = head.next;
         while (curr.next != null) {
            curr = curr.next;
         }
         Node newNode = new Node(item);
         curr.next = newNode;
         size++;
      }
   }


   public String toString()
   {
      //for if the list is empty
      if(size == 0){
         return "The list is empty.";
      }

      StringBuilder result = new StringBuilder("[");
      Node curr = head.next;
      for(int i = 0; i < size; i++){
         result.append(curr.data);
         curr = curr.next;
         if(i != size - 1){
            result.append(", ");
         }else{
            result.append("]");
         }
      }
      return result.toString();
   }
   

   public boolean contains(final T item)
   {
      //throw if item is null
      if(item == null){
         throw new IllegalArgumentException("The item is null.");
      }
      //go through list and return if found or not
      Node curr = head.next;
      for(int i = 0; i < size; i++){
         if(curr.data.equals(item)){
            return true;
         }
         curr = curr.next;
      }
      return false;
   }
   
   

}