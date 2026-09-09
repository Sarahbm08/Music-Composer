import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ComposerPanel extends JPanel
{
	//assumptions:
	//	only a 4/4 time signature
	//	completely random notes
	//	smallest note value = 16th note
	//	largest note value = whole note
	
	private JLabel introLabel, rhythmLabel;
	private JButton generateRhythm;
	private MusicGenerator gen;
	private String rhythm;
	private JPanel topPanel;
	private SheetMusicPanel sheetMusicPanel;
	private int x, y, randRhythm;
	
	public ComposerPanel()
	{
		x = 10;
		y = 27;
		randRhythm = 0;
		gen = new MusicGenerator();
		rhythm = "";
		
		setLayout(new BorderLayout());
		topPanel = new JPanel();
		sheetMusicPanel = new SheetMusicPanel();
		introLabel = new JLabel("Welcome to the Computer Composer!");
		rhythmLabel = new JLabel("No rhythm generated yet.");
		
		generateRhythm = new JButton("Generate new Rhythm!");
		generateRhythm.addActionListener(new ButtonListener());
		
		topPanel.add(introLabel);
		topPanel.add(rhythmLabel);
		topPanel.add(generateRhythm);
		topPanel.setPreferredSize(new Dimension(100,65));
		
		add(topPanel, BorderLayout.NORTH);
		add(sheetMusicPanel, BorderLayout.CENTER);
	
		setBackground(Color.white);
		setPreferredSize(new Dimension(500,700));
	}
	
	private class SheetMusicPanel extends JPanel
	{
		private ImageIcon sheetMusic, wholeNote, halfNote, barLine;
		
		public SheetMusicPanel()
		{
			sheetMusic = new ImageIcon("blankSheetMusic.jpg");
			wholeNote = new ImageIcon("whole_note.gif");
			halfNote = new ImageIcon("half_down.gif");
			barLine = new ImageIcon("barline.jpg");
		}
		
		public void paintComponent(Graphics page)
		{
			super.paintComponent(page);			
			sheetMusic.paintIcon(this, page, 0, 0);
			if(randRhythm == 1) //half note
				halfNote.paintIcon(this, page, x, y);
			else if(randRhythm == 2) //whole note
				wholeNote.paintIcon(this, page, x, y);
			else if(randRhythm == -1)//barline
				barLine.paintIcon(this, page, x, 34);
				
			// WHOLE:
			// 5th space = 27 (G)
			// 5th line  = 31 (F)
			// 4th space = 35 (E)
			// 4th line  = 39 (D)
			// ...and so on?
		}
	}
	
	
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			
			if(source == generateRhythm)
			{
				int note = gen.generateNote() * 4;
				x += 5;
				y = 27 + note;
				randRhythm = gen.generateRhythm();
				sheetMusicPanel.repaint();
				/*while(gen.numMeasures() < 3)
				{
					rhythm += gen.generateNoteString() + " " + gen.rhythmToString(gen.generateRhythm()) + ", ";
				}
				rhythmLabel.setText(rhythm);
				gen = new MusicGenerator();
				rhythm = "";*/
			}
		}
	}
}
