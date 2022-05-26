import java.io.FileNotFoundException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * MIDIInstrument class
 * creates the MIDISequencePlayer that will actually play the stored notes.
 * loads the sheet containing the note information and times, then passes off this information to the Sequence player
 * catches errors in reading notes or in creating a new sequencer
 *
 */

public class MIDIInstrument extends Instrument {

	private MIDISequencePlayer player;
	
	public MIDIInstrument() throws FileNotFoundException 
	{
		try 
		{
			player = new MIDISequencePlayer(14,220);
		}
		catch (MidiUnavailableException e)
		{
			e.printStackTrace();
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * play()
	 * loads the notes and adds each note to the sequencePlayer to actually play the music 
	 */
	
	@Override
	public void play()
	{
				for (int i = 1; i <= music.lastTime(); i++)
				{
					for (Note n : music.getNotesAt(i))
					{
						try
						{
							player.addNote(n.getKey(), 100, i, n.getDuration());
						}
						catch (InvalidMidiDataException e)
						{
							System.out.println("failed at " + i);
						}
					}
				}
	
				try {
					player.play();
				} catch (InvalidMidiDataException e) {
					e.printStackTrace();
				}
	}
	
}
