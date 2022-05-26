import java.io.FileNotFoundException;

/**
 *TextPrintInstrument class will print all stored notes read from the sheet to the screen, 
 */

public class TextPrintInstrument extends Instrument {

	public TextPrintInstrument() throws FileNotFoundException 
	{

	}
	
	/**
	 *play()
	 *prints for each note: the start beat time, note duration, and the key for the note from the sheet
	 */
	public void play()
	{
		for (int i = 1; i <= music.lastTime(); i++)
		{
			for (Note n : music.getNotesAt(i))
			{
				System.out.println("Beat " + i);
								
				if (music.hasNoteAt(i))
				{
					System.out.println("" + n.getDuration() + " " + n.getKey());
				}

			}
		}
	}
}
