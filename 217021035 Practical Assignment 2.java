// *****************************************
// *** 217021035 Practical Assignment 2  ***                             
// *****************************************




import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class gui extends JFrame implements ActionListener, ItemListener {
	JTextArea displayTextArea;
	JButton clearButton, fillButton, randomButton;
	JRadioButton multipicationButton, divisionButton;
	JTextField enterTextField, sumTextField;

	private ButtonGroup gbutton; 

	// public void multiply (int multiplier, int sum) {
	// 	int product = 0;

	// 	for (int i = 1; i <= sum; i++) {
	// 			product = i * multiplier;
	// 			System.out.printf("%d x %d = %d\n", i, multiplier, product);
	// 	}

		
	// }

	public static void main (String[] args) {
		gui c = new gui();
		c.setVisible(true);
	}

	public gui() {
		JPanel inputPanel, textPanel, selectPanel, fillClearPanel, nestedPanel;
		JLabel enterLabel, sumLabel;

		//setting up the frame
		setSize(950,660);
		setResizable(false);
		setTitle("Multiplication and Division practice");
		setLocation(100,50);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 

		// getting and setting up the content pane
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		// create and setup text panel
		textPanel = new JPanel(new FlowLayout());
		displayTextArea = new JTextArea(50 ,70);
		textPanel.add(displayTextArea); 

		// create and setup input panel 
		inputPanel = new JPanel(new FlowLayout());
		enterLabel = new JLabel("Enter the multiplier/divisior: ");
		enterTextField = new JTextField(5);
		enterTextField.setPreferredSize(new Dimension(100, 50));
		sumLabel = new JLabel("Enter number of sums: ");
		sumTextField = new JTextField(5);
		sumTextField.setPreferredSize(new Dimension(100, 50));
		randomButton = new JButton("Randomise");
		randomButton.setPreferredSize(new Dimension(100,50));
		randomButton.addActionListener(this);


		inputPanel.add(enterLabel);
		inputPanel.add(enterTextField);
		inputPanel.add(sumLabel);
		inputPanel.add(sumTextField);
		inputPanel.add(randomButton);

		var bag = new GridBagConstraints();
		// bag.insets = new Insets(10,10,10,10);

		// create and setup the selection panel
		nestedPanel = new JPanel(new BorderLayout());  /*nested panel to center the selection panel (division and multiplication buttons)*/ 
		selectPanel = new JPanel(new GridBagLayout()); 
		gbutton = new ButtonGroup(); 
		multipicationButton = new JRadioButton("Multiplication");
		multipicationButton.setPreferredSize(new Dimension(150, 50));
		multipicationButton.addItemListener(this);
		bag.gridx = 0;
		bag.gridy = 0;
		gbutton.add(multipicationButton);
		selectPanel.add(multipicationButton, bag);

		divisionButton = new JRadioButton("Division");
		divisionButton.setPreferredSize(new Dimension(150, 50));
		divisionButton.addItemListener(this);
		bag.gridx = -1;
		bag.gridy = 2;
		gbutton.add(divisionButton);
		selectPanel.add(divisionButton, bag);
		nestedPanel.add(selectPanel, BorderLayout.WEST);

		// create and setup the fill and clear panel
		fillClearPanel = new  JPanel();
		fillButton = new JButton("Fill Table");
		fillButton.setPreferredSize(new Dimension(100,50));
		fillButton.addActionListener(this);
		clearButton = new JButton("Clear Table");
		clearButton.setPreferredSize(new Dimension(100,50));
		clearButton.addActionListener(this);

		fillClearPanel.add(fillButton);
		fillClearPanel.add(clearButton);

		contentPane.add(textPanel, BorderLayout.WEST);
		contentPane.add(inputPanel, BorderLayout.NORTH);
		contentPane.add(nestedPanel, BorderLayout.EAST);
		contentPane.add(fillClearPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed (ActionEvent event){
		if (event.getSource() instanceof JButton) {

			if (event.getSource() == randomButton) {
			/*first check if the any of the operation is selected (multiplication or division) if not prompt the user to do so!*/
			if (multipicationButton.isSelected() || divisionButton.isSelected()) {
										/*run the random function take the generated values and display them on the text field area */
						Random random = new Random();
						Integer randSum = 1 + random.nextInt(20);
						Integer randEnter = 1 + random.nextInt(20);
						String enter = Integer.toString(randEnter);
						String sum = Integer.toString(randSum);
						enterTextField.setText(enter);
						sumTextField.setText(sum);
			} else {
				/*first ensure that the operation (multiplication or division is selected or not) */
				 JOptionPane.showMessageDialog(null, "select the operation first multiplication or division", "OPERATION NOT SELECTED!", JOptionPane.ERROR_MESSAGE);
			}
		
			
		} else if (event.getSource() == fillButton) {
			/*ensure that all fields are not empty before filling up the text area*/
			if ((enterTextField.getText().isEmpty() && sumTextField.getText().isEmpty()) || (enterTextField.getText().isEmpty() || sumTextField.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "enter multiplier and divisor", "MULTIPLIER AND DIVISOR NOT ENTERED", JOptionPane.ERROR_MESSAGE);
			}else {
 				if (event.getSource() == multipicationButton) {
					multiply (Integer.parseInt(multipicationButton.getText()), Integer.parseInt(sumTextField.getText()));
				}
			displayTextArea.setText("Skhindi");
				
			}

		} else if (event.getSource() == clearButton) {
			displayTextArea.setText(" ");
		 }
	 }
	}

	public void itemStateChanged(ItemEvent event){
		if(event.getSource() instanceof JRadioButton){
			if(event.getSource() == multipicationButton) {
				// I don't know what to add here

			} else if (event.getSource() == divisionButton) {
				// I don't know what to add here
			}
		}
		
	}




	public string multiply (int multiplier, int sum) {
		int product = 0;
		String s = "";

		for (int i = 1; i <= sum; i++) {
				product = i * multiplier;
			s = s + "" 
		}

		return s;
	}

	public  void divide (int diviser, int sum) {
		int quotient = 0;
		for (int i = 1; i <= sum; i++ ){
			quotient = (diviser * i)/ diviser;
			System.out.printf("%d / %d = %d \n", (diviser * i), diviser, quotient);
		}
		
	}

}