import processing.core.PApplet;

public class Button {
	private PApplet parent;
	private Game settings;

	private String text;
	private int buttonSizeX = 300;
	private int buttonSizeY = 120;

	private int positionX;
	private int positionY;

	private int textSize;
	private int correctionFactor;

	private boolean activated;
	private boolean nonActive; // if this is true, then this button do nothing (it is just a text field)

	// Constructor for using the button
	public Button(PApplet parent, Game settings, String text, int posX, int posY, int buttonSizeX, int buttonSizeY,
			int textSize, int correctionFactor) {
		this.parent = parent;
		this.settings = settings;
		this.text = text;
		positionX = posX;
		positionY = posY;
		this.buttonSizeY = buttonSizeY;
		this.buttonSizeX = buttonSizeX;
		this.textSize = textSize;
		this.correctionFactor = correctionFactor;
		this.activated = false;
		this.nonActive = false;
	}

	// returns the activated state
	public boolean getState() {
		return activated;
	}

	// sets the "activated" state to false or true
	public void setState(boolean state) {
		this.activated = state;
	}

	// sets the "nonActive" state to false or true
	public void setNonActive(boolean state) {
		this.nonActive = state;
	}

	public boolean mouseOverButton() {
		if (nonActive == false && parent.mouseX >= positionX - buttonSizeX / 2
				&& parent.mouseX <= positionX + buttonSizeX / 2 && parent.mouseY >= positionY - buttonSizeY / 2
				&& parent.mouseY <= positionY + buttonSizeY / 2) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		if (mouseOverButton() == true) {
			displayBright();
		} else {
			if (activated == false) {
				displayDark();
			} else if (activated == true) {
				displayActivated();
			}
		}
	}

	public void displayDark() {
		parent.rectMode(parent.CENTER);
		parent.noStroke();
		parent.textSize(textSize);
		parent.textAlign(parent.CENTER, parent.CENTER);
		parent.fill(settings.getColor(1));
		parent.rect(positionX, positionY, buttonSizeX, buttonSizeY);
		parent.fill(settings.getColor(4));
		parent.text(text, positionX, positionY - correctionFactor);
	}

	public void displayBright() {
		parent.rectMode(parent.CENTER);
		parent.noStroke();
		parent.textSize(textSize);
		parent.textAlign(parent.CENTER, parent.CENTER);
		parent.fill(settings.getColor(3));
		parent.rect(positionX, positionY, buttonSizeX, buttonSizeY);
		parent.fill(settings.getColor(2));
		parent.text(text, positionX, positionY - correctionFactor);
	}

	public void displayActivated() {
		parent.rectMode(parent.CENTER);
		parent.noStroke();
		parent.textSize(textSize);
		parent.textAlign(parent.CENTER, parent.CENTER);
		parent.fill(settings.getColor(5));
		parent.rect(positionX, positionY, buttonSizeX, buttonSizeY);
		parent.fill(settings.getColor(4));
		parent.text(text, positionX, positionY - correctionFactor);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getButtonSizeX() {
		return buttonSizeX;
	}

	public void setButtonSizeX(int sizeX) {
		this.buttonSizeX = sizeX;
	}

	public int getButtonSizeY() {
		return buttonSizeY;
	}

	public void setButtonSizeY(int sizeY) {
		this.buttonSizeY = sizeY;
	}

	public int getButtonPositionX() {
		return positionX;
	}

	public void setButtonPositionX(int posX) {
		this.positionX = posX;
	}

	public int getButtonPositionY() {
		return positionY;
	}

	public void setButtonPositionY(int posY) {
		this.positionY = posY;
	}
}
