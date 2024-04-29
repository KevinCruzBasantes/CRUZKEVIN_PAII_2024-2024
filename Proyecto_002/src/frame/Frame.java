package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import classs.Enemy;
import classs.Line;
import classs.Player;
import classs.Bullet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import container.Container;

public class Frame extends JFrame {
	private JPanel contentPane;
	private Container container;
	private List<Enemy> enemies;
	private Random rand;
	private int lineY = 400;
	private Player player;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		enemies = new ArrayList<>();
		rand = new Random();
		player = new Player(392, 450);

		JPanel panelTablero = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (Enemy enemy : enemies) {
					container.drawC(enemy, g);
					for (Bullet bullet : enemy.getBullets()) { // Dibuja las balas del enemigo
						container.drawC(bullet, g);
					}
				}
				for (Bullet bullet : player.getBullets()) { // Dibuja las balas del jugador
					container.drawC(bullet, g);
				}
				container.drawC(new Line(), g);
				container.drawC(player, g);
			}
		};
		panelTablero.setBackground(Color.BLACK);
		panelTablero.setForeground(Color.BLACK);
		panelTablero.setBounds(0, 0, 784, 528);
		contentPane.add(panelTablero);

		JPanel panelPlayer = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				// Crea una nueva fuente
				Font myFont = new Font("Futura", Font.BOLD, 26); // Cambia  la fuente 
				// Establece la fuente
				g.setFont(myFont);

				// Dibuja el texto
				g.drawString("SCORE: " + player.score, 70, 24);

				// Dibuja la barra de vida
				int lifeBarWidth = 100; // Ancho de la barra de vida
				int lifeBarHeight = 20; // Altura de la barra de vida
				int lifeBarX = 600; // Posición x de la barra de vida
				int lifeBarY = 5; // Posición y de la barra de vida

				// Dibuja la vida total
				g.setColor(Color.RED);
				g.fillRect(lifeBarX, lifeBarY, lifeBarWidth, lifeBarHeight);

				// Dibuja la vida actual
				g.setColor(Color.GREEN);
				int currentLifeWidth = (int) (lifeBarWidth * ((double) player.life / player.maxLife)); // Calcula el
																										// ancho de la
																										// vida actual
				g.fillRect(lifeBarX, lifeBarY, currentLifeWidth, lifeBarHeight);

			}
		};
		panelPlayer.setBackground(Color.GRAY);
		panelPlayer.setBounds(0, 529, 784, 32);
		contentPane.add(panelPlayer);

		container = new Container();

		final Timer[] timer = new Timer[1];
		timer[0] = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Enemy enemy : enemies) {
					container.moveC(enemy, "DOWN");
					if (enemy.getY() >= lineY) {
						timer[0].stop();
						System.out.println("Game Over");
						break;
					}
					// Detecta colisiones entre las balas del enemigo y el jugador
					List<Bullet> enemyBulletsToRemove = new ArrayList<>();
					for (Bullet bullet : enemy.getBullets()) { // Mueve las balas del enemigo
					    container.moveC(bullet, "DOWN");
					 // Detecta colisiones entre las balas del enemigo y el jugador
					    if (bullet.getBounds().intersects(player.getBounds())) {
					        player.life -= 10; // Reduce la vida del jugador en 10.
					        enemyBulletsToRemove.add(bullet); // Marca la bala para su eliminación
					        panelPlayer.repaint(); // Actualiza la barra de vida
					        if (player.life <= 0) { // Si la vida del jugador es 0 o menos
					            container.die(player); // Llama al método die del contenedor pasando el jugador
					            timer[0].stop(); // Detener el juego
					            System.out.println("Game Over");
					            break;
					        }
					    }
					}
					enemy.getBullets().removeAll(enemyBulletsToRemove); // Elimina las balas marcadas para su eliminación

					if (rand.nextInt(100) < 3) { // 3% de probabilidad de disparar
						enemy.shoot();
					}
				}
				for (Bullet bullet : player.getBullets()) { // Mueve las balas del jugador
					container.moveC(bullet, "UP");
				}
				if (rand.nextInt(100) < 3) {// 3% de probabilidad de aparecer un nuevo enemigo
					enemies.add(new Enemy());
				}

				// Detecta colisiones entre las balas y los enemigos
				List<Bullet> bulletsToRemove = new ArrayList<>();
				List<Enemy> enemiesToRemove = new ArrayList<>();
				for (Bullet bullet : player.getBullets()) {
					for (Enemy enemy : enemies) {
						if (bullet.getBounds().intersects(enemy.getBounds())) {
							container.die(enemy); // El enemigo "muere"
							container.die(bullet); // La bala "muere"
							enemiesToRemove.add(enemy); // Marca el enemigo para su eliminación
							bulletsToRemove.add(bullet); // Marca la bala para su eliminación
							player.score += 10; // Incrementa el score del jugador
							panelPlayer.repaint(); // Actualiza la interfaz gráfica
							break;
						}
					}
				}

				// Elimina las balas y los enemigos marcados para su eliminación
				player.getBullets().removeAll(bulletsToRemove);
				enemies.removeAll(enemiesToRemove);

				panelTablero.repaint();
			}
		});
		timer[0].start();

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					container.moveC(player, "LEFT");
					break;
				case KeyEvent.VK_RIGHT:
					container.moveC(player, "RIGHT");
					break;
				case KeyEvent.VK_SPACE:
					player.shoot(); // El jugador dispara
					break;
				}
			}
		});
		setFocusable(true);
	}

}
