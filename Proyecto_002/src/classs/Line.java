package classs;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.IDrawable;

public class Line implements IDrawable{

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(0, 420, 784, 420);
		
	}

}
