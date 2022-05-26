import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File; 
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

/**
 * Sheet Class
 * reads the text file containing the note information and time to play those notes.
 * converts text file info into values the MIDISequencer understands.
 */

public class Sheet {

	/**
	 * map: store the beat time in the key, and the notes to play in the value.
	 */
	private HashMap <Integer, ArrayList<Note>> map = new HashMap<>();
		
	//input
	//1 Q 64
	//beat,type,key
	//type converts into duration.
	//beat is also known as time

	/**
	 * 
	 * @param fileName: name of the file to be read.
	 * @throws FileNotFoundException
	 * 
	 * Sheet
	 * constructor that reads in the file and stores notes into the map at the correct time
	 */

	public Sheet(String fileName) throws FileNotFoundException
	{
		
		try
	    {
	    Scanner fileReader = new Scanner (new File(fileName));
	    
	    while (fileReader.hasNext())
	    {
	    	int noteTime = fileReader.nextInt();
	    	char noteType = fileReader.next().charAt(0);
 	    	int noteKey = fileReader.nextInt();
	    	
	    	if (noteType == 'W' || noteType == 'w')
	    	{
		    	Note note = new WholeNote(noteKey);
		    	addNote(noteTime,note);

	    	}

	    	else if (noteType == 'H' || noteType == 'h')
	    	{
		    	Note note = new HalfNote(noteKey);
		    	addNote(noteTime,note);

	    	}
	    	else
	    	{
		    	Note note = new QuarterNote(noteKey); // Note may have to be changed to QuarterNote
		    	addNote(noteTime,note);

	    	}

	    }
	    
	    fileReader.close();		    
	    }
	    catch (FileNotFoundException exception)
	    {
	    	System.out.println("could not open file.");
	    }
	}

	/**
	 * 
	 * @param time: the desired starting beat for the note.
	 * @param note: the note to play at the given time.
	 */
	
	public void addNote(int time, Note note)
	{
		ArrayList<Note> notes;
		
		if(!hasNoteAt(time))
		{
		    notes = new ArrayList<>();
			
			notes.add(note);
			map.put(time, notes);
		}
		
		else
		{
		    notes = getNotesAt(time);
			notes.add(note);
			map.put(time, notes);
		}
	}
	
	/**
	 * LastTime()
	 * returns the last stored value for the key in the map
	 * 
	 * Bugs: has a hard coded value instead of the actual last stored value.
	 */
	
	public int lastTime()
	{
		return 20; // no idea how to get the actual value from a map
	}
	
	/**
	 * hasNoteAt(int time)
	 * @param time: the time to check whether or not there are notes stored there.
	 * @return hasNote: true if there is at least one note, false if there is no note.
	 */
	
	public boolean hasNoteAt(int time)
	{
		boolean hasNote = false;
		
		if (map.get(time) != null)
			{
				hasNote = true;
			}
		
		return hasNote;
	}
	
	/**
	 * GetNotesAt(int time)
	 * retrieves the list of notes at a given time.
	 * @param time: the time to retrieve note list at
	 * @return list of notes at the given time
	 */
	ArrayList<Note> getNotesAt(int time)
	{
		if (hasNoteAt(time))
		{
			return map.get(time);
		}
		else
		{
			ArrayList<Note> empty = new ArrayList<>();
			return empty;
		}
	}
	
}
