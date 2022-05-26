//needs to take and return key
public abstract class Note {

	private int key;
	
	public Note()
	{
		
	}
	
	public Note(int key)
	{
		this.key = key;
	}
	
	public int getKey()
	{
		return key;	
	}
	
	public abstract int getDuration();
}
