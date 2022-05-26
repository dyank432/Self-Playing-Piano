
public class QuarterNote extends Note{

	private int key;
	
	public QuarterNote(int key)
	{
		this.key = key;
	}
	
	@Override
	public int getKey()
	{
		return key;	
	}
	
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 4;
	}

}
