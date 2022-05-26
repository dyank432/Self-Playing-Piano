import java.io.FileNotFoundException;

public abstract class Instrument {

	protected Sheet music;
	
	//constructor
	public Instrument()  throws FileNotFoundException 
	{
		Sheet music = new Sheet("input.txt");
		loadMusic(music);
	}
	
	public void loadMusic(Sheet music)
	{
		this.music = music;
	}
	
	public abstract void play();
}