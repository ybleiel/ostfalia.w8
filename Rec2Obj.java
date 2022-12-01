package s0start;

public class Rec2Obj {
	
	public static void windup(EggTimer et, int sec) {
		et.seconds = sec;
	}

	public static boolean tick(EggTimer et) {
		et.seconds--;
		if (et.seconds == 0) {
			alarm();
		}
		return et.seconds > 0;
	}

	public static void alarm() {
		System.out.println("Rrrrring");
	}

	public static void main(String[] args) {
		EggTimer ei = new EggTimer();
		ei.windup(30);
		while (ei.tick() == true) {
			ei.tick();
		}
	}
}

class EggTimer {
	int seconds;
	
	public void windup(int sec) {
		this.seconds = sec;
	}

	public boolean tick() {
		this.seconds--;
		if (this.seconds == 0) {
			alarm();
		}
		return this.seconds > 0;
	}

	public void alarm() {
		System.out.println("Rrrrring");
	}
}
