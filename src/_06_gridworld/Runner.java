package _06_gridworld;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Runner {
	public static void main(String[] args) {
		Runner a = new Runner();
		a.GUI();
		
	}
	void GUI() {

		
		
		World a = new World();
		Bug b = new Bug();
		Flower c = new Flower();
		Location d = new Location(1, 1);
		a.show();
		a.add(d, b);
		
		Color blue = new Color(0,0,255);
		
		Bug b1 = new Bug();
		Location d1 = new Location(4, 2);
		b1.setColor(blue);
		b1.turn();
		b1.turn();
		a.add(d1, b1);
		
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println("I: "+i+" j:"+j);
				Flower flower = new Flower();
				Location loc = new Location(i, j);
				//a.getGrid().
				System.out.println(a.getGrid().getOccupiedLocations());
				//d.getCol() 
				if(a.getGrid().get(loc) != a.getGrid().get(d) && a.getGrid().get(loc) != a.getGrid().get(d1)) {
					a.add(loc, flower);
				}
				
			}
		}
		
	}
}
