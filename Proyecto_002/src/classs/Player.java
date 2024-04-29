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

public class Player implements IDrawable, IMovable, IShootable, IDiable{
    int x;
    int y;
    private List<Bullet> bullets; // Lista de balas
    private int width = 20;
    private int height = 20;
    //puntuacion y vida
    public int score = 0;
    public int life , maxLife;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.bullets = new ArrayList<>(); // Inicializa la lista de balas
        this.maxLife = 100;
        this.life=100;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.orange);
        int[] X = {x, x-10, x+10};
        int[] Y = {y, y+20, y+20};
        g.fillPolygon(X, Y, 3);
        
     // Dibuja el rectángulo de colisión
//        g.setColor(Color.red);
//        g.drawRect(x - 10, y, width, height);
    }

    @Override
    public void die() {
    	System.out.println("Has Muerto");
    }

    @Override
    public void shoot() {
        bullets.add(new Bullet(x, y)); // Crea una nueva bala en la posición del jugador
    }

    @Override
    public void move(String direction) {
        if (direction.equals("LEFT")) {
            if (x - 5 >= 12) { // Verifica que el jugador no se salga por la izquierda
                x -= 5; // Mueve el jugador a la izquierda
            }
        } else if (direction.equals("RIGHT")) {
            if (x + 5 <= 784 -12) { // Verifica que el jugador no se salga por la derecha
                x += 5; // Mueve el jugador a la derecha
            }
        }
    }

    public List<Bullet> getBullets() {
        return bullets; // Devuelve la lista de balas
    }
    public Rectangle getBounds() {
        return new Rectangle(x - 10, y, width, height);
    }

}
