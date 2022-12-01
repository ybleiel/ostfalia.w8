package s0start;

public class Battery {
	
	int capacity;
	int ladestand;
	int ladezyklen;
	
	public Battery(int capacity){
		this.capacity = capacity;
		this.ladezyklen = 0;
		this.ladestand = 0;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public boolean isFull() {
		if (this.ladestand >= (capacity * 0.9)) {
			return true;
		}
		else
			return false;
	}
	
	public void load(int mAh) {
		this.ladezyklen++;
		if (this.capacity == 0) {
			
			return ;
		}
		if (mAh >= this.capacity) {
			this.ladestand = capacity;
		}
		else if (this.ladestand + mAh >= this.capacity) {
			this.ladestand = capacity;
		}
		else {
			this.ladestand += mAh;
		}
		this.capacity--;
	}
	
	public String consume() {
		String s = "";
		while (this.ladestand > 0) {
			if (this.ladestand % 20 == 0) {
				s += "*";
			}
			this.ladestand--;
		}
		this.ladestand = 0;
		return s;
	}
	
	public static void main(String[] args) {
		Battery b = new Battery(1000);
		int i = 0;
		String s = "0";
		
		while (s != "") {
			b.load(1000);
			s = b.consume();
			i++;
		}
		System.out.println(i);
		System.out.println(b.getCapacity());
		b.load(90);
		System.out.println(b.ladestand);
		System.out.println(b.getCapacity());
		System.out.println(b.isFull());
		System.out.println(b.consume());
		System.out.println(b.isFull());
	}
}

