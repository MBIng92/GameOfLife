import processing.core.PApplet;

public class Slider {
	private PApplet parent;
	private Game settings;

	private int posX;
	private int posY;
	private int sizeX;
	private int sizeY;
	private float value;
	private int color;
	private float minValue;
	private float maxValue;
	private Button button;
	private int buttonSizeX;
	private int buttonSizeY;
	private int textSize;
	private int correctionFactor;
	private float positionButtonY;
	private int round;

	public Slider(PApplet parent, Game settings, float value, int posX, int posY, int sizeX, int sizeY, int color,
			float minValue, float maxValue, int buttonSizeX, int buttonSizeY, int textSize, int correctionFactor,
			int round) {
		this.parent = parent;
		this.settings = settings;
		this.value = value;
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.buttonSizeX = buttonSizeX;
		this.buttonSizeY = buttonSizeY;
		this.textSize = textSize;
		this.correctionFactor = correctionFactor;
		this.round = round;
		positionButtonY = ((float) posY + (float) sizeY / 2)
				- (((float) value - (float) minValue) / ((float) maxValue - (float) minValue)) * (float) sizeY;
		button = new Button(parent, settings, String.valueOf(value), posX, (int) positionButtonY, buttonSizeX,
				buttonSizeY, textSize, correctionFactor);
	}

	public boolean mouseOverButton() {
		return button.mouseOverButton();
	}

	public void moveSlider() {
		positionButtonY = parent.mouseY;
		float value = (-positionButtonY + posY + sizeY / 2) / sizeY * (maxValue - minValue) + minValue;
		value = (float) roundAvoid((double) value, round);
		if (value > maxValue) {
			this.value = maxValue;
		} else if (value < minValue) {
			this.value = minValue;
		} else {
			this.value = value;
		}
		button.setButtonPositionY((int) positionButtonY);
	}

	// function to round values to n places
	private double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	public float getValue() {
		return value;
	}

	public void display() {
		// display the Slider
		parent.rectMode(parent.CENTER);
		parent.stroke(settings.getColor(3));
		parent.fill(color);
		parent.rect(posX, posY, sizeX, sizeY);
		// display the slider button
		button.display();
	}
}
