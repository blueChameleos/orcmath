package maple_gacha;

import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class TestMusic {

	private static boolean play;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		JButton button = new JButton("Click me");
		frame.add(button);
		button.addActionListener(new AL());
		frame.setVisible(true);
	}

	public static class AL implements ActionListener {
		
		public final void actionPerformed(ActionEvent e) {
			music();
		}
	}

	public static void music() {
			AudioPlayer MGP = AudioPlayer.player;
			AudioStream BGM;
			AudioData MD;

			ContinuousAudioDataStream loop = null;

			try {
				InputStream test = new FileInputStream("resources/khalid.wav");
				BGM = new AudioStream(test);
				AudioPlayer.player.start(BGM);
				// MD = BGM.getData();
				// loop = new ContinuousAudioDataStream(MD);

			} catch (FileNotFoundException e) {
				System.out.print(e.toString());
			} catch (IOException error) {
				System.out.print(error.toString());
			}
			MGP.start(loop);

	}
}
