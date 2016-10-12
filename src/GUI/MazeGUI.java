package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mazeGenerator.Maze;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MazeGUI {

	private JFrame frame;
//	private static Maze maze;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeGUI window = new MazeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MazeGUI() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
//						maze = m;
						MazeGUI window = new MazeGUI();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 200, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 778);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(10, 10, 1, 1));
		
//		String s = Integer.toString(maze.getI());
		
		JButton btnNewButton = new JButton("s");
		panel.add(btnNewButton);
		
		//JButton btnNewButton_1 = new JButton("New button");
		//panel.add(btnNewButton_1, 1, 1);
		
		 
		
	}

}
