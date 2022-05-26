

import java.io.FileNotFoundException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class Main {

	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, FileNotFoundException {
	
		Sheet music = new Sheet("input.txt");
		
		TextPrintInstrument printer = new TextPrintInstrument();
		printer.loadMusic(music);
		printer.play();
		
		MIDIInstrument midi = new MIDIInstrument();
		midi.loadMusic(music);
		midi.play();
	}

}
