package fmat.gameframework.pix;

import fmat.gameframework.datain.Input;
import fmat.gameframework.io.FileIO;
import fmat.gameframework.sound.Audio;

public interface Game {
	public Input getInput();
	public FileIO getFileIO();
	public Graphics getGraphics();
	public Audio getAudio();
	public void setScreen(Screen screen);
	public Screen getCurrentScreen();
	public Screen getStartScreen();
}
