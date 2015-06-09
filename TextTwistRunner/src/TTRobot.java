import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class TTRobot extends Robot {

	public TTRobot() throws AWTException {
		super();
	}

	public String toString() {
		return super.toString();
	}
	
	public void pressAndRelease(int keycode) {
		this.keyPress(keycode);
		this.keyRelease(keycode);
	}
	
	public void moveMouseAndClick(int x, int y) {
		this.mouseMove(x, y);
		this.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		this.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void pressShift() {
		this.keyPress(KeyEvent.VK_SHIFT);
	}
	
	public void releaseShift() {
		this.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	public void typeString(String string)
	{
		for (char letter : string.toCharArray())
		{
			if (letter != '\n') {
				boolean isuppercase = ((letter >> 5) & 0x1) == 0;
				
				if (isuppercase) this.pressShift();
				
				this.pressAndRelease(letter & ~0x20);
				
				if (isuppercase) this.releaseShift();
				
			} else {
				this.pressAndRelease(KeyEvent.VK_ENTER);
			}
		}
	}
}
