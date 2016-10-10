package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import mazeGenerator.Maze;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JLabel;

public class HomeGUI {

	private JFrame frame;
	private MazeGUI mazeGUI;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGUI window = new HomeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public HomeGUI() throws IOException, URISyntaxException {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	private void initialize() throws IOException, URISyntaxException 
	{
		// Creating frame
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 14));
		frame.setBounds(500, 200, 800, 450);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	
		// Creating panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 478);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// Importing image to be inserted in panel
		ImageIcon pic = new ImageIcon("/Users/farrahabulkhair/Documents/pokemonAI.png");
		//ImageIcon pic = new ImageIcon("pokemonAI.png");
		
		
		// Creating label to add image on
		JLabel lblTitle = new JLabel(pic);
		lblTitle.setBounds(6, 61, 788, 237);
		panel.add(lblTitle);
		
		// Creating Start button
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnStart.setForeground(new Color(0, 0, 102));
		btnStart.setBounds(350, 349, 101, 41);
		btnStart.setBorderPainted(false);
			// Hovering effect
		btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnStart.setForeground(new Color(0,0,240));
		        btnStart.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnStart.setForeground(new Color(0, 0, 102));
		        btnStart.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		    }
		});

		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 MazeGUI mazeGUI = new MazeGUI();
				 mazeGUI.NewScreen();
				 frame.setVisible(false);
			}
		});
		panel.add(btnStart);
	}
	
}
