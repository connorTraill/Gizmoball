package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Model;
import controller.RunListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunGui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private Board board;
	
	String[] circleButtons = { "Circle", "Triangle", "Square",
			"Left Flipper", "Right Flipper", "Absorber" };

	public RunGui(Model m) {
		model = m;

		// RunListener catches all GUI events. In reality might have many
		// listeners.
		listener = new RunListener(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Gizmo Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Board is passed the Model so it can act as Observer
		board = new Board(500, 500, model);

		Container cp = frame.getContentPane();

		Font gf = new Font("Arial", Font.BOLD, 12);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		JMenuItem MenuItemNew = new JMenuItem("New", KeyEvent.VK_N);
		fileMenu.add(MenuItemNew);
		
		JMenuItem MenuItemClear = new JMenuItem("Clear", KeyEvent.VK_N);
		fileMenu.add(MenuItemClear);
		JMenuItem MenuItemLoad = new JMenuItem("Load", KeyEvent.VK_N);
		fileMenu.add(MenuItemLoad);
		JMenuItem MenuItemSave = new JMenuItem("Save", KeyEvent.VK_N);
		fileMenu.add(MenuItemSave);
		fileMenu.addSeparator();
		JMenuItem MenuItemQuit = new JMenuItem("Quit", KeyEvent.VK_N);
		fileMenu.add(MenuItemQuit);
		
		frame.setJMenuBar(menuBar);
		frame.setSize(400, 250);
		frame.setVisible(true);

		// Buttons
		JPanel buttons1 = new JPanel();
		buttons1.setLayout(new GridLayout(6, 2));
		buttons1.setPreferredSize(new Dimension(200,200));

		JButton addButton = new JButton("Add gizmo");
		addButton.setFont(gf);
		addButton.addActionListener(listener);
		addButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(addButton);
		
		JComboBox circleButton = new JComboBox(circleButtons);
		String displayValue="Add Gizmo";
		circleButton.setPrototypeDisplayValue(displayValue);
		circleButton.setFont(gf);
		circleButton.addActionListener(listener);
		circleButton.setPreferredSize(new Dimension(200,200));
		buttons1.add(circleButton);

		JButton rotateButton = new JButton("Rotate Left");
		rotateButton.setFont(gf);
		rotateButton.addActionListener(listener);
		rotateButton.setSize(10,10);
		rotateButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(rotateButton);

		JButton leftButton = new JButton("Rotate Right");
		leftButton.setFont(gf);
		leftButton.addActionListener(listener);
		leftButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(leftButton);

		JButton connectButton = new JButton("Connect");
		connectButton.setFont(gf);
		connectButton.addActionListener(listener);
		connectButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(connectButton);

		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.setFont(gf);
		disconnectButton.addActionListener(listener);
		disconnectButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(disconnectButton);
		
		JButton deleteButton = new JButton("Delete Gizmo");
		deleteButton.setFont(gf);
		deleteButton.addActionListener(listener);
		deleteButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(deleteButton);

		JButton moveButton = new JButton("Move Gizmo");
		moveButton.setFont(gf);
		moveButton.addActionListener(listener);
		moveButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(moveButton);


		JButton editButton = new JButton("Edit Ball");
		editButton.setFont(gf);
		editButton.addActionListener(listener);
		editButton.setMaximumSize(new Dimension(50, 50));
		buttons1.add(editButton);

		
		JPanel buttons2 = new JPanel();
		buttons2.setLayout(new GridLayout (1, 2));
		buttons1.setPreferredSize(new Dimension(200,200));
		
		JButton buildButton = new JButton("Build");
		buildButton.setFont(gf);
		buildButton.addActionListener(listener);
		buildButton.setMaximumSize(new Dimension(50, 50));
		buttons2.add(buildButton);
		
		JButton playButton = new JButton("Play");
		playButton.setFont(gf);
		playButton.addActionListener(listener);
		playButton.setMaximumSize(new Dimension(50, 50));
		buttons2.add(playButton);

		/**
		 * MIT Demo buttons
		 * 
		 * JButton button1 = new JButton("Start"); button1.setFont(gf);
		 * button1.addActionListener(listener); button1.setMaximumSize(new
		 * Dimension(100, 100)); buttons.add(button1);
		 * 
		 * JButton button2 = new JButton("Stop"); button2.setFont(gf);
		 * button2.addActionListener(listener); button2.setMaximumSize(new
		 * Dimension(100, 100)); buttons.add(button2);
		 * 
		 * JButton button4 = new JButton("Tick"); button4.setFont(gf);
		 * button4.addActionListener(listener); button4.setMaximumSize(new
		 * Dimension(100, 100)); buttons.add(button4);
		 * 
		 * JButton button3 = new JButton("Quit"); button3.setFont(gf);
		 * button3.addActionListener(listener); button3.setMaximumSize(new
		 * Dimension(100, 100)); buttons.add(button3);
		 */
		cp.add(buttons1, BorderLayout.LINE_START);
		cp.add(buttons2, BorderLayout.PAGE_END);

		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


}
