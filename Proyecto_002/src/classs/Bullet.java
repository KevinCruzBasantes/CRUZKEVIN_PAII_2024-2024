package classs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import interfaces.IDiable;
import interfaces.IDrawable;
import interfaces.IMovable;
import interfaces.IShootable;

public class Bullet implements IDrawable, IMovable, IDiable{
	int x, y;
	private boolean isDead = false;
	private int width = 5;
    private int height = 5;
	public Bullet(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		
	}
	@Override
	public void move(String direction) {
	    if (direction.equals("UP")) {
	        y -= 50; // Mueve la bala hacia arriba
	    } else if (direction.equals("DOWN")) {
	        y += 5; // Mueve la bala hacia abajo
	    }
	}


	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		g.drawOval(x, y, 5, 5);
		
		// Dibuja el rectángulo de colisión
//	    g.setColor(Color.red);
//	    g.drawRect(x, y, width, height);
	}
	@Override
	public void die() {
		// TODO Auto-generated method stub
		isDead = true;
	}
	public boolean isDead() {
        return isDead; // Método para verificar si el enemigo está muerto
    }
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
