package classs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.IDiable;
import interfaces.IDrawable;
import interfaces.IMovable;
import interfaces.IShootable;

public class Enemy implements IDrawable, IMovable, IDiable, IShootable {
    private int x;
    private int y;
    private boolean isDead = false;
    private int width = 20;
    private int height = 20;
    
    private List<Bullet> bullets; // Lista de balas
    public Enemy() {
        Random rand = new Random();
        
        // Restamos el tamaño del polígono para asegurarnos de que se dibuje completamente dentro del área.
        this.x = rand.nextInt(784 - 20);
        this.y = 0;
        
        this.bullets = new ArrayList<>(); // Inicializa la lista de balas
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        int[] X = {x, x, x+10, x+20, x+20};
        int[] Y = {y, y+20, y+10, y+20, y};
        g.fillPolygon(X, Y, 5);
        
     // Dibuja el rectángulo de colisión
//        g.setColor(Color.red);
//        g.drawRect(x, y , width, height);
    }

    @Override
    public void move(String direction) {
        if (direction.equals("DOWN")) {
            y += 1; // Mueve el enemigo hacia abajo
        }
    }
	 public int getY() {
	        return y;
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
	    return new Rectangle(x, y + 10, width, height);
	}


	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		bullets.add(new Bullet(x,y )); // Crea una nueva bala en la posición del enemigo
	}
	
	public List<Bullet> getBullets() {
        return bullets; // Devuelve la lista de balas
    }
}
