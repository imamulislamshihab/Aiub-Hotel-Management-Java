package GUI;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import db.dbConfig.DbConfig;

public class CustomerManagerFrame extends JFrame implements ActionListener {
	JPanel panel;

	JLabel label;

	JTextField name, age, number, ID, days, searchField;

	JButton add, delete, clear, update, search, back;

	DefaultTableModel model;
	JTable table;

	Font font2 = new Font("cambria", Font.BOLD, 35);
	Font font = new Font("cambria", Font.BOLD, 20);
	Font font3 = new Font("cambria", Font.BOLD, 16);
	Font font1 = new Font("cambria", Font.BOLD, 25);

	public CustomerManagerFrame() {
		super("Guest Manager");
		initializeFrame();

		createTable();
		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

	public void initializeFrame() {
		this.setSize(1200, 700);
		this.setLocation(150, 70);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creating a Panel Container
		panel = new JPanel();
		panel.setBounds(0, 0, 1200, 700);

		panel.setOpaque(false);
		panel.setLayout(null);
		this.add(panel);

		// BackGround Example
		ImageIcon image = new ImageIcon("Resources/guest.png");
		JLabel background = new JLabel();
		background.setBounds(0, 0, 1200, 700);
		background.setIcon(image);
		this.add(background);

		// Creating Labels
		label = new JLabel("Add Guest Information");
		label.setBounds(90, 90, 400, 70);
		label.setForeground(new Color(35, 56, 99));
		label.setFont(font2);

		JLabel nameLable = new JLabel("Guest Name");
		nameLable.setFont(font);
		nameLable.setForeground(new Color(35, 56, 99));
		nameLable.setBounds(30, 190, 200, 40);

		JLabel ageLable = new JLabel("Guest Age");
		ageLable.setFont(font);
		ageLable.setForeground(new Color(35, 56, 99));
		ageLable.setBounds(30, 270, 200, 40);

		JLabel numberLable = new JLabel("Contact Number");
		numberLable.setFont(font);
		numberLable.setForeground(new Color(35, 56, 99));
		numberLable.setBounds(30, 350, 200, 40);

		JLabel IDLable = new JLabel("Room ID");
		IDLable.setFont(font);
		IDLable.setForeground(new Color(35, 56, 99));
		IDLable.setBounds(30, 430, 200, 40);

		JLabel daysLable = new JLabel("Days Staying");
		daysLable.setFont(font);
		daysLable.setForeground(new Color(35, 56, 99));
		daysLable.setBounds(30, 510, 200, 40);

		// TextFields
		name = new JTextField();
		name.setFont(font);
		name.setBounds(210, 190, 250, 40);

		age = new JTextField();
		age.setFont(font);
		age.setBounds(210, 270, 250, 40);

		number = new JTextField();
		number.setFont(font);
		number.setBounds(210, 350, 250, 40);

		ID = new JTextField();
		ID.setFont(font);
		ID.setBounds(210, 430, 250, 40);

		days = new JTextField();
		days.setFont(font);
		days.setBounds(210, 510, 250, 40);

		searchField = new JTextField();
		searchField.setFont(font1);
		searchField.setBounds(580, 100, 320, 40);

		// Search button
		search = new JButton("Search");
		search.setFont(font);
		search.setBounds(930, 100, 150, 40);
		search.addActionListener(this);

		// Creating Buttons
		add = new JButton("Add Guest");
		add.setFont(font);
		add.setBounds(50, 600, 150, 40);
		add.addActionListener(this);

		clear = new JButton("Clear");
		clear.setFont(font);
		clear.setBounds(310, 600, 150, 40);
		clear.addActionListener(this);

		delete = new JButton("Delete");
		delete.setFont(font);
		delete.setBounds(610, 600, 150, 40);
		delete.addActionListener(this);

		update = new JButton("Update");
		update.setFont(font);
		update.setBounds(920, 600, 150, 40);
		update.addActionListener(this);

		back = new JButton("Back");
		back.setFont(font);
		back.setBounds(1000, 45, 130, 40);
		back.addActionListener(this);

		// adding components to Panel
		panel.add(label);
		panel.add(nameLable);
		panel.add(ageLable);
		panel.add(numberLable);
		panel.add(IDLable);
		panel.add(daysLable);
		panel.add(name);
		panel.add(age);
		panel.add(number);
		panel.add(ID);
		panel.add(days);
		panel.add(add);
		panel.add(clear);
		panel.add(delete);
		panel.add(update);
		panel.add(search);
		panel.add(searchField);
		panel.add(back);

	}

	public void createTable() {
		// Create Model For Table
		model = new DefaultTableModel();
		model.addColumn("Room ID");
		model.addColumn("Name");
		model.addColumn("Age");
		model.addColumn("Number");
		model.addColumn("Days Staying");
		model.addColumn("Bill");

		// Create Table with model
		table = new JTable(model);
		table.setFont(font3);

		table.setBounds(0, 0, 600, 400);
		table.setRowHeight(30);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.getTableHeader().setFont(font);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(520, 180, 640, 400);
		table.setBackground(new Color(174, 247, 255));

		Customer[] customers = new DbConfig().getAllCustomers();

		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null) {
				model.addRow(new Object[] {
						customers[i].getCustomerId(),
						customers[i].getName(),
						customers[i].getAge(),
						customers[i].getContactNum(),
						customers[i].getTotalDays(),
						customers[i].getTotalPrice()
				});
			}
		}

		// add the scrollPane to panel
		panel.add(scrollPane);
	}

	public void actionPerformed(ActionEvent e) {
		if (add == e.getSource()) {
			String tID = ID.getText();
			String tname = name.getText();
			String tage = age.getText();
			String tnumber = number.getText();
			String tdays = days.getText();
			int tdays1 = Integer.parseInt(tdays);
			double totalPrice = Double.parseDouble(tdays) * 2500.0;

			if (tID.isEmpty() || tname.isEmpty() || tnumber.isEmpty() || days.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide All Information", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (tdays1 < 0) {
						JOptionPane.showMessageDialog(this, "Invalid Number Format", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Customer c = new Customer(tname, tage, tnumber, tID, tdays);

						model.addRow(new Object[] {
								c.getCustomerId(),
								c.getName(),
								c.getAge(),
								c.getContactNum(),
								c.getTotalDays(),
								c.getTotalPrice()
						});

						new DbConfig(c).saveCustomer();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid Number Format", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		else if (clear == e.getSource()) {
			name.setText("");
			age.setText("");
			number.setText("");
			ID.setText("");
			days.setText("");
		}

		else if (delete == e.getSource()) {

			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				String cusID = (String) model.getValueAt(selectedRow, 0);

				if (new DbConfig().deleteCustomer(cusID)) {
					model.removeRow(selectedRow);
				}
			}
		}

		else if (update == e.getSource()) {
			// Update button action
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				String cusID = (String) model.getValueAt(selectedRow, 0);
				String cusName = (String) model.getValueAt(selectedRow, 1);
				String cusAge = (String) model.getValueAt(selectedRow, 2);
				String cusNumber = (String) model.getValueAt(selectedRow, 3);
				String cusDays = (String) model.getValueAt(selectedRow, 4);

				Customer c = new Customer(cusName, cusAge, cusNumber, cusID, cusDays);
				new DbConfig(c).updateCustomer();

				model.setValueAt(cusID, selectedRow, 0);
				model.setValueAt(cusName, selectedRow, 1);
				model.setValueAt(cusAge, selectedRow, 2);
				model.setValueAt(cusNumber, selectedRow, 3);
				model.setValueAt(cusDays, selectedRow, 4);
				model.setValueAt(c.getTotalPrice(), selectedRow, 5);

				JOptionPane.showMessageDialog(this, "Guest Updated");
			}

		}

		else if (search == e.getSource()) {
			String searchText = searchField.getText();
			if (searchText.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter a search query.", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			boolean found = false;
			for (int i = 0; i < model.getRowCount(); i++) {
				String cusID = (String) model.getValueAt(i, 0);
				if (cusID.equals(searchText)) {
					table.setRowSelectionInterval(i, i);
					found = true;
					break;
				}
			}

			if (!found) {
				JOptionPane.showMessageDialog(this, "Not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		else if (back == e.getSource()) {
			Dashboard dashboard = new Dashboard();
			this.setVisible(false);
		}

	}

}