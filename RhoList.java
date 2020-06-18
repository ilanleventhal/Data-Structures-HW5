import java.util.Stack;
import java.util.Random;

class RhoList{
	Node genRhoList(int m, int n){
		Node head = new Node();
		Node u = head;
		Node loop = null;
		int count=0;
		if(m>=n){
			for(int i=0; i<n; i++){
				Node nx = new Node();
				u.next=nx;
				u=nx;
			}
			return head;
		}
		for(int i=0; i<n+m; i++){
			Node nx = new Node();
			u.next=nx;
			u=nx;
			count++;
			if(count==m+1) loop = u;
		}
		u.next=loop;
		return head;
	}
	int sizeRhoList(Node u){
		Node t = u;
		Node h = u;
		int k = 0;
		do{
			if(h.next==null) return k*2+1;
			if(h.next.next==null) return k*2;
			t=t.next;
			h=h.next.next;
			k++;
		}while(t!=h);
		return k;
	}

	public static void main(String[] args){
		int ss = (args.length>0)? Integer.valueOf(args[0]) : 111;
		int nn = (args.length>1)? Integer.valueOf(args[1]) : 10;
		int mm = (args.length>1)? Integer.valueOf(args[2]) : 4;
		
		RhoList r = new RhoList();
		Node u = r.genRhoList(mm, nn);
		int size = r.sizeRhoList(u);
		System.out.println("==> Testing RhoList");
		System.out.println("==> A rho list of size " + (mm+nn) + " has been created");
		System.out.println("Using method sizeRhoList(), the size of the rho list is estimated to be between " + size + " and " + size*2);
	}
}
