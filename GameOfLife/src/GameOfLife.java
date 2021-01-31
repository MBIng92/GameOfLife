import processing.core.PApplet;

public class GameOfLife extends PApplet {
	public static void main(String[] args) {
		PApplet.main("GameOfLife");
	}

	Game game;

	// setting window size
	public void settings() {
		game = new Game(this);
		size(game.getWidth(), game.getHeight());
	}

	public void setup() {
		surface.setTitle("Game of Life");
		frameRate(140); // try to create a high framerate of about 140
	}

	public void draw() {
		game.display();
	}

	// mouse operations
	public void mouseClicked() {
		if (mouseButton == LEFT) {
			game.action();
		}
	}

	public void mouseDragged() {
		if (mouseButton == LEFT) {
			game.actionSlider();
		}
	}
}
