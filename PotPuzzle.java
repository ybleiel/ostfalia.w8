package s0start;

import java.awt.Color;
import java.util.Scanner;

import std.ui.MiniApp;

public class PotPuzzle extends MiniApp{
	public static void main(String[] args) {
		int c, d;		
		char key1, key2;
		Scanner s = new Scanner(System.in);
		Pot p1 = new Pot(50,3000,0);
		Pot p2 = new Pot(150,5000,0);
		Pot p3 = new Pot(250,8000,8000);
		p1.show();
		p2.show();
		p3.show();
		key1 = 'o';
		key2 = 'o';
		while (true) {
//			key1 = getKey();
//			System.out.println(key1);
//			if (key1 == '3') {
//				key2 = getKey();
//				System.out.println(key2);
//				if (getKey() == '2')
//					p3.pourInto(p2);
//				}
			c = s.nextInt();
			d = s.nextInt();
			if (c == 1 && d == 2) {
				p1.pourInto(p2);
			}
			else if (c == 1 && d == 3) {
				p1.pourInto(p3);
			}
			else if (c == 2 && d == 1) {
				p2.pourInto(p1);
			}
			else if (c == 2 && d == 3) {
				p2.pourInto(p3);
			}
			else if (c == 3 && d == 1) {
				p3.pourInto(p1);			}
			else if (c == 3 && d == 2) {
				p3.pourInto(p2);
			}
			else if (c == 0 || d == 0) {
				break ;
			}
			p1.show();
			p2.show();
			p3.show();
		}
	}
}

class Pot {
	int x;
	int max;
	int cur;
	
	public Pot(int x, int max, int cur) {
		this.x = x;
		this.max = max;
		this.cur = cur;
	}
	
	public void pourInto(Pot a) {
		while (this.cur > 0 && a.cur < a.max) {
			this.cur--;
			a.cur++;
		}
	}
	
	public int getCurrent() {
		return cur;
	}
	
	public int getMaximum() {
		return max;
	}
	
	public void show() {
		int heightmax, heightcur, y;
		
		heightmax = max / 50;
		heightcur = cur / 50;
		y = 200 - heightmax;
		if (this.cur == 1000) {
			MiniApp.drawRectangle(""+max, x - 25, y, 50, heightmax, Color.green);
		}
		else {
			MiniApp.drawRectangle(""+max, x - 25, y, 50, heightmax, Color.black);
		}
		MiniApp.fillRectangle("Füllstand"+max, x - 25, 200 - heightcur, 50, heightcur, Color.blue);
	}
	
	
	
}