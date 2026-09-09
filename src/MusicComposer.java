import javax.swing.JFrame;

public class MusicComposer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Computer Composer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new ComposerPanel());

		frame.pack();
		frame.setVisible(true);
	}
}