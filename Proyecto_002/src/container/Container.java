package container;

import java.awt.Graphics;

import interfaces.IDiable;
import interfaces.IDrawable;
import interfaces.IMovable;
import interfaces.IShootable;

public class Container {

	
	
	 public void drawC(IDrawable drawable, Graphics g) {
	        drawable.draw(g);
	    }
	 public void moveC(IMovable movable, String direction) {
		 movable.move(direction);
	 }
	 public void shootC(IShootable shootable) {
		 shootable.shoot();
	 }
	 public void die(IDiable diable) {
		 diable.die();
	 }
}
