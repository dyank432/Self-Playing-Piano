import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class SheetTests {

	
	@Test
	void NoteTests() {
		Note note1 = new WholeNote(64);
		Note note2 = new WholeNote(65);

		Note note3 = new HalfNote(66);
		Note note4 = new HalfNote(67);
		
		Note note5 = new QuarterNote(68);
		Note note6 = new QuarterNote(69);
		
		assertEquals("Whole notes have different keys", 64, note1.getKey());
		assertEquals("whole notes have different keys", 65, note2.getKey());
		assertEquals("Whole notes duration is 16", 16, note1.getDuration());


		assertEquals("Half notes have different keys", 66, note3.getKey());
		assertEquals("Half notes have different keys", 67, note4.getKey());
		assertEquals("Whole notes duration is 8", 8, note3.getDuration());

		
		assertEquals("Quarter notes have different keys", 68, note5.getKey());
		assertEquals("Quarter notes have different keys", 69, note6.getKey());
		assertEquals("Whole notes duration is 4", 4, note5.getDuration());


	}

	
	@Test
	void retrievesNoteKeyFromSheetTest() throws FileNotFoundException {
		Sheet sheet = new Sheet("input.txt");
				
		assertEquals("note key at 1", 64 , sheet.getNotesAt(1).get(0).getKey());
	}

}
