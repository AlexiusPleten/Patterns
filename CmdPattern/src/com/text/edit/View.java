package com.text.edit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class View {
	private JFrame mFrame = new JFrame("Text Edit");
	private JTextArea mTextArea;
	private Controller mController = new Controller(this);
	
	public View() {
		createFrame();
	}
	
	private void createFrame() {
		JPanel panel = new JPanel();
		mFrame.add(panel);
		mTextArea = new JTextArea();
		panel.add(mTextArea);
		panel.revalidate();
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setSize(600, 500);
		mFrame.setVisible(true);
		mTextArea.addKeyListener(mController);
	}
	
	public JFrame getWindow() {
		return mFrame;
	}
	
	public JTextArea getTextArea() {
		return mTextArea;
	}
}
