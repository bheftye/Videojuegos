package fmat.gameframework.datain;

import java.util.List;

public interface Input {
	
	public boolean isKeyPressed(int keyCode);
	public boolean isTouchDown(int pointer);
	public int getTouchX(int pointer);
	public int getTouchY(int pointer);
	public float getAcce1X();
	public float getAcce1Y();
	public float getAcce1Z();
	
	public List<KeyEvent> getKeyEvents();
	public List<TouchEvent> getTouchEvents();
}
