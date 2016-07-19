package com.whc.dictionary;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewGUI {
	private Frame mainFrame;
	private Panel searchPanel;
	private Label statusLabel0;
	private Label statusLabel1;
	private Label statusLabel2;
	private Label statusLabel3;
	private Label statusLabel4;
	private Panel controlPanel;
	private TextField textField;
	private TextArea resultArea;
	private Button button;
	private SearchIndex index;
	private ArrayList<String> results;

	public NewGUI(SearchIndex index) {
		this.index = index;
		prepareGUI();
	}
	
	private void prepareGUI() {
		mainFrame = new Frame("My Dictionary");
		mainFrame.setSize(400, 600);
		mainFrame.setLayout(new GridLayout(2, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		controlPanel = new Panel();
		controlPanel.setLayout(new GridLayout(6, 1));
		mainFrame.setVisible(true);
		resultArea = new TextArea(5, 30);
		resultArea.setEditable(false);
		button = new Button("Search");	
	}

	public void showTextAreaDemo() {
		searchPanel = new Panel();
		searchPanel.setLayout(new FlowLayout());
		textField = new TextField(20);
		searchPanel.add(textField);
		searchPanel.add(button, BorderLayout.EAST);
		mainFrame.add(controlPanel);
		controlPanel.add(searchPanel);
		mainFrame.add(resultArea);
	}
	
	public void processWord(){
		textField.addTextListener(new CustomTextListener());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultArea.setText(index.exactSearch(textField.getText()));
			}
		});
		
		statusLabel0 = new Label();
		statusLabel0.setAlignment(Label.CENTER);
		statusLabel0.setSize(40, 10);
		statusLabel1 = new Label();
		statusLabel1.setAlignment(Label.CENTER);
		statusLabel1.setSize(40, 50);
		statusLabel2 = new Label();
		statusLabel2.setAlignment(Label.CENTER);
		statusLabel2.setSize(40, 50);
		statusLabel3 = new Label();
		statusLabel3.setAlignment(Label.CENTER);
		statusLabel3.setSize(40, 50);
		statusLabel4 = new Label();
		statusLabel4.setAlignment(Label.CENTER);
		statusLabel4.setSize(40, 50);
		
		
		controlPanel.add(statusLabel0);
		controlPanel.add(statusLabel1);
		controlPanel.add(statusLabel2);
		controlPanel.add(statusLabel3);
		controlPanel.add(statusLabel4);
	}

	class CustomTextListener implements TextListener {
		public void textValueChanged(TextEvent e) {
			results = index.getQuery(textField.getText());
			statusLabel0.setText(results.get(0));
			statusLabel1.setText(results.get(1));
			statusLabel2.setText(results.get(2));
			statusLabel3.setText(results.get(3));
			statusLabel4.setText(results.get(4));
		}
		
	}

}