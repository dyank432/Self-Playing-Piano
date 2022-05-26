
public class WholeNote extends Note {
	
	private int key;
	
	public WholeNote(int key)
	{
		this.key = key;
	}
	
	@Override
	public int getKey()
	{
		return key;	
	}

	@Override
	public int getDuration() 
	{
		return 16;
	}

}
