import java.util.Random;
import javax.swing.ImageIcon;

public class MusicGenerator
{
	private Random rand;
	private int measureLength, measureLengthLeft, numMeasures;
	private ImageIcon wholeNote;
	private ImageIcon halfNote;

	public MusicGenerator()//int givenMeasureLength//double smallest)
	{
		rand = new Random();
		numMeasures = 0;
		measureLength = 2; //givenMeasureLength
		measureLengthLeft = measureLength; //how much of the measure do we still have to fill up?
		wholeNote = new ImageIcon("whole_note.gif");
		halfNote = new ImageIcon("half.gif");
		//smallestRhythm = 1.0/16.0;//smallest;
	}
	
	public int numMeasures()
	{
		return numMeasures;
	}
	
	//For random generation of rhythm:
	//	1 = 16th (1/16)
	//	2 = 8th (1/8)
	//	3 = dotted 8th (1/8 + 1/16)
	//	4 = quarter (1/4)
	//	5 = quarter tied to 16th (1/4 + 1/16)
	//	6 = dotted quarter (1/4 + 1/8)
	//	7 = double dotted quarter (1/4 + 1/8 + 1/16)
	//	8 = half (1/2)
	//	9 = half tied to 16th (1/2 + 1/16)
	//	10 = half tied to 8th (1/2 + 1/8)
	//	11 = half tied to dotted 8th (1/2 + 1/8 + 1/16)
	//	12 = dotted half (1/2 + 1/4)
	//	13 = dotted half tied to 16th (1/2 + 1/4 + 1/16)
	//	14 = dotted half tied to 8th (1/2 + 1/4 + 1/8)
	//	15 = dotted half tied to dotted 8th (1/2 + 1/4 + 1/8 + 1/16)
	//	16 = whole (1)
	public int generateRhythm()
	{
		if(measureLengthLeft == 0) //we've finished a measure, let's start a new one
		{
			measureLengthLeft = measureLength;
			numMeasures++;
			return -1; //-1 denotes a bar line
		}
		else
		{
			int randNum = rand.nextInt(measureLengthLeft) + 1; //random number generator
			measureLengthLeft -= randNum;
			return randNum;
		}
		//double decRhythm = randNum * smallestRhythm;

		/*for(int i = 1; i < 17; i++)
		{
			decRhythm = i * smallestRhythm;
			System.out.println(i + ": " + decRhythm);
		}*/
	}
	
	public String rhythmToString(int intRhythm)
	{
		String rhythm = "";
	
		if(intRhythm == -1) //bar line
			rhythm = "|";
		else if(intRhythm == 1)//.0625)		//1
			rhythm = "16th";
		else if(intRhythm == 2)//.125)	//2
			rhythm = "8th";
		else if(intRhythm == 3)//.1875)	//3
			rhythm = "dotted 8th";
		else if(intRhythm == 4)//.25)	//4
			rhythm = "quarter";
		else if(intRhythm == 5)//.3125)	//5
			rhythm = "quarter tied to 16th";
		else if(intRhythm == 6)//.375)	//6
			rhythm = "dotted quarter";
		else if(intRhythm == 7)//.4375)	//7
			rhythm = "double dotted quarter";
		else if(intRhythm == 8)//.5)	//8
			rhythm = "half";
		else if(intRhythm == 9)//.5625)	//9
			rhythm = "half tied to 16th";
		else if(intRhythm == 10)//.625)	//10
			rhythm = "half tied to 8th";
		else if(intRhythm == 11)//.6875)	//11
			rhythm = "half tied to dotted 8th";
		else if(intRhythm == 12)//.75)	//12
			rhythm = "dotted half";
		else if(intRhythm == 13)//.8125)	//13
			rhythm = "dotted half tied to 16th";
		else if(intRhythm == 14)//.875)	//14
			rhythm = "dotted half tied to 8th";
		else if(intRhythm == 15)//.9375)	//15
			rhythm = "dotted half tied to dotted 8th";
		else if(intRhythm == 16)//1.0)	//16
			rhythm = "whole";
		else
			rhythm = "unrecognizable... " + intRhythm;
	
		return rhythm;
	}
		
	//Random generation of notes:
	//	0 = G
	//	1 = Ab
	//	2 = A
	//	3 = Bb
	//	4 = B
	//	5 = C
	//	6 = C#
	//	7 = D
	//	8 = Eb
	//	9 = E
	//	10 = F
	//	11 = F#
	
	//	0 = C
	//	1 = C#
	//	2 = D
	//	3 = Eb
	//	4 = E
	//	5 = F
	//	6 = F#
	//	7 = G
	//	8 = Ab
	//	9 = A
	//	10 = Bb
	//	11 = B
	public int generateNote()
	{
		return rand.nextInt(12);
	}

	public String generateNoteString()
	{
		return noteToString(generateNote());
	}

	public String noteToString(int intNote)
	{
		String note = "";

		switch(intNote)
		{
			case 0: note = "C";
				break;
			case 1: note = "C#";
				break;
			case 2: note = "D";
				break;
			case 3: note = "Eb";
				break;
			case 4: note = "E";
				break;
			case 5: note = "F";
				break;
			case 6: note = "F#";
				break;
			case 7: note = "G";
				break;
			case 8: note = "Ab";
				break;
			case 9: note = "A";
				break;
			case 10: note = "Bb";
				 break;
			case 11: note = "B";
				 break;
			default: note = "invalid int given";
		}

		return note;
	}
}
