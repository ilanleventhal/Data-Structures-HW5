/* CircList.java
 *  An implementation of Circular Lists.
 *  
 *		Please implement those methods that says
 *					"IMPLEMENT ME"
 *		This class depends on
 *					--InterfaceCircList.java,
 *					--Node.java
 *		DO NOT MODIFY THE MAIN METHOD.
 *
 *  Fall 2019, CS102
 *  Chee Yap
 **************************************************/ 

import java.util.Random;

class CircList
		implements InterfaceCircList {
////////////////////////////////MEMBERS:
		Node head;	// arbitrary node in circular list
////////////////////////////////CONSTRUCTORS:
		CircList(){
			head=null;
		}
		CircList(int v){
			head=new Node(v);
			head.next=head; 
		}
////////////////////////////////METHODS:
	public void add(Node u){	// Notice that we add a Node, not an int.
		if(head==null){
			head=u;
			u.next=head;
			return;
		}
		int s = size()-1;
		Node n = head;
		for(int i=0;i<s;i++){
			n=n.next;
		}
		n.next=u;
		u.next=head;
	}
	public void remove(){
		Node i=head;
		if(head==null) return;
		while(i.next.next!=head){
			i=i.next;
		}
		i.next=head;
	}
	public int size(){
		Node i=head;
		int n=1;
		if(head==null) return 0;
		while(i.next!=head){
			i=i.next;
			n++;
		}
		return n;
	}
	public static CircList gen(int n){
		CircList cl = new CircList();
		for (int i=0; i<n; i++)
			cl.add(new Node());		// Adding Node with random int values
		return cl;
	}
	public static void show(CircList cl, String msg){
		if (cl==null) return;
		cl.show(msg);
	}
	public void show(String msg){
		System.out.println(msg);
		if (head==null) return;
		Node u = head;
		do{
			System.out.printf("%d ", u.val);
			u = u.next;
		} while (u!=head);
		System.out.println("");
	}
	public void rot(){
		if(head != null)
			head = head.next;
	}
	public void rot(int n){ // note that n may be negative!
		int s = size()-1;
		if(head==null) return;
		if(n>=0){
			for(int i=0; i<n; i++){
				rot();
			}
		}
		if(n<0){
			for(int i=0; i>n; i--){
				for(int j=0; j<s; j++){
					rot();
				}
			}
		}
	}
	public void rev(){ // reverse list
		if (head == null) return;
		rev(head); 	// call helper method
	}
	public void rev(Node u){ // TRICKY!
		if(head==null) return;
		u = head;
		Node prev = null;
    	Node next;
    	do{  
        	next = u.next;
        	u.next = prev;
        	prev = u;
       		u = next;
    	}while(u!=head);
  
   		head.next = prev;
    	head = prev;
		}
////////////////////////////////MAIN:
// DO NOT MODIFY THE MAIN METHOD !!!
	public static void main(String[] args){
		int ss = (args.length>0)? Integer.valueOf(args[0]) : 111;
		int nn = (args.length>1)? Integer.valueOf(args[1]) : 8;
		Node.rg = (ss==0)? new Random() : new Random(ss);
	
		System.out.printf("==> Testing CircList\n");
		CircList cl = gen(nn);
		if (cl!=null) {
			cl.show("==> Random Circular list:");
				System.out.printf("==> Size = %d \n", cl.size());
			cl.rot(1);
				cl.show("==> Rot(1):");
			cl.rot(nn+1);
				cl.show("==> Rot("+ (nn+1) + "):");
			cl.rot(-2);
				cl.show("==> Rot(-2):");
			cl.rev();
				cl.show("==> Reversed list:");
			cl.remove(); cl.remove();
				cl.show("==> After two removes:");
		}
	}//main
}//class

