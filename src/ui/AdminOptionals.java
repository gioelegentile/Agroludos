/*
 * 
 */
package ui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;

import business.BusinessDelegate;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import presentation.FrontController;
import utility.PersonalizedJTextField;

import java.awt.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminOptionals.
 */
public class AdminOptionals extends JPanel {

	/** The combo box. */
	private JComboBox comboBox;
	
	/** The lbl new label. */
	private JLabel lblNewLabel;
	
	/** The panel. */
	private JPanel panel;
	
	/** The Constant DELETE_OPTIONAL. */
	private static final String DELETE_OPTIONAL = "Elimina Optional";
	
	/** The Constant CREATE_OPTIONAL. */
	private static final String CREATE_OPTIONAL = "Crea un nuovo Optional";
	
	/** The choice. */
	private String[] choice = {CREATE_OPTIONAL,DELETE_OPTIONAL};
	
	/** The business. */
	private BusinessDelegate business;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The list. */
	private JList list; 
	
	/** The list model. */
	private DefaultListModel listModel;
	
	/** The optional name. */
	private JTextField optionalName;
	
	/** The optional price. */
	private JTextField optionalPrice;
	
	/** The lbl inserisci i dati. */
	private JLabel lblInserisciIDati;
	
	/** The btn new button_2. */
	private JButton btnNewButton_2;
	
	/**
	 * Create the panel.
	 */
	public AdminOptionals() {
		
		frontController = new FrontController();
		business = new BusinessDelegate();
		
		lblNewLabel = new JLabel("GESTISCI OPTIONAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		comboBox = new JComboBox(choice);
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(-1);   
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(CREATE_OPTIONAL.equals(comboBox.getSelectedItem())) {
					panel.setLayout(null);
					panel.removeAll();
					
					
					optionalName = new JTextField();
					optionalName.setDocument(new PersonalizedJTextField(40));
					optionalName.setToolTipText("Può contenere solo lettere e l'apostrofo.");
					optionalName.setColumns(10);
					
					optionalPrice = new JTextField();
					optionalPrice.setDocument(new PersonalizedJTextField(10));
					optionalPrice.setToolTipText("Esempio: 10.50");
					optionalPrice.setColumns(10);
					
					JLabel lblNewLabel_2 = new JLabel("Nome:");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
					
					JLabel lblPrezzo = new JLabel("Prezzo:");
					lblPrezzo.setFont(new Font("Tahoma", Font.BOLD, 11));
					
					lblInserisciIDati = new JLabel("Inserisci i dati del nuovo Optional da creare:");
					lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
					lblInserisciIDati.setFont(new Font("Tahoma", Font.PLAIN, 14));
					
					btnNewButton_2 = new JButton("Crea Optional");
					
					
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(204)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblPrezzo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(optionalPrice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
												.addComponent(optionalName, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
												.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
											.addGap(205)))))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(129)
								.addComponent(lblInserisciIDati, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(347, Short.MAX_VALUE))
					);
					gl_panel.setVerticalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(26)
								.addComponent(lblInserisciIDati)
								.addGap(32)
								.addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(optionalName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblPrezzo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(optionalPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(36)
								.addComponent(btnNewButton_2)
								.addContainerGap(30, Short.MAX_VALUE))
					);
					
					btnNewButton_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(!optionalName.getText().isEmpty() && !optionalPrice.getText().isEmpty()) {
								boolean created = false;
								ArrayList<String> data = new ArrayList<String>();
								data.add(optionalName.getText());
								data.add(optionalPrice.getText());
								try {
									created = (boolean) business.execute("addOptional", data);
								} catch (SecurityException
										| NoSuchMethodException
										| ClassNotFoundException
										| InstantiationException
										| IllegalAccessException e) {
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if(created) {
									JOptionPane.showMessageDialog(null, "Tipo Optional creato correttamente", "Successo", 1);
									comboBox.setSelectedIndex(-1);
									panel.removeAll();
									panel.revalidate();
									panel.repaint();
								} else {
									JOptionPane.showMessageDialog(null, "Errore. Assicurati di aver inserito correttamente i dati.", "Attenzione", 0);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Creazione Optional annullata, inserire correttamente nome e prezzo", "Attenzione", 0);
							}
							
						}
						
					});
					
					panel.setLayout(gl_panel);
					panel.revalidate();
					
				} else if(DELETE_OPTIONAL.equals(comboBox.getSelectedItem())) {
					panel.setLayout(null);
					panel.removeAll();
					//inserire elementi grafici per l'eliminazione di un OPTIONAL
					ArrayList<ArrayList<String>> optionalList = new ArrayList<ArrayList<String>>();
					try {
						optionalList = (ArrayList<ArrayList<String>>) business.execute("getOptionals", null);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					list = new JList();
					JScrollPane scrollPane = new JScrollPane(list);
					JButton btnNewButton = new JButton("Elimina Optional Selezionato");
					
					
					
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(73)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
								.addGap(78)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(90, Short.MAX_VALUE))
					);
					gl_panel.setVerticalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(52)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(110)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(51, Short.MAX_VALUE))
					);
					
					listModel = new DefaultListModel();
					for (int i = 0; i < optionalList.size(); i++) {
						if(!optionalList.get(i).get(1).equals("None"))
							listModel.addElement(optionalList.get(i).toString());
					}
					list.setModel(listModel);
					list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					btnNewButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare " + (String)list.getSelectedValue() + "?" , "Attenzione",0) == 0){
							String selectedOptional = (String) list.getSelectedValue();
							int selectedOptionalIndex = list.getSelectedIndex();
							int index = 0;
							boolean found = false;
							for (; index < selectedOptional.length() && !found; index++) {
								if (selectedOptional.charAt(index) == ',') {
									found = true;
								}
							}
							boolean deleted = false;
							try {
								deleted = (boolean) business.execute("deleteOptional", selectedOptional.substring(1, index - 1));
							} catch (SecurityException | NoSuchMethodException
									| ClassNotFoundException
									| InstantiationException
									| IllegalAccessException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(deleted) {
								JOptionPane.showMessageDialog(null, "Tipo Optional eliminato correttamente", "Successo", 1);
								comboBox.setSelectedIndex(-1);
								listModel.remove(selectedOptionalIndex);
								list.setModel(listModel);
								
							} else {
								JOptionPane.showMessageDialog(null, "Eliminazione annullata, gara in corso con il tipo di optional selezionato", "Attenzione", 0);
							}
						}
						}
						
					});
					
					panel.setLayout(gl_panel);
					panel.revalidate();
					
				}
				
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("Seleziona Operazione da effettuare:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadLoginFrame();
			}
			
		});		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(56, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(263))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(307)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(307, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(lblNewLabel)
					.addGap(47)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		setLayout(groupLayout);

	}
	
	/**
	 * Load login frame.
	 */
	private void loadLoginFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("adminHome", frame, null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
