
public class HalfNote extends Note{

	int key;
	
	public HalfNote(int key)
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
		return 8;
	}

}
