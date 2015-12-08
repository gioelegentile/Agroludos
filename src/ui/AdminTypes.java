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

import java.awt.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminTypes.
 */
public class AdminTypes extends JPanel {
	
	/** The combo box. */
	private JComboBox comboBox;
	
	/** The lbl new label. */
	private JLabel lblNewLabel;
	
	/** The panel. */
	private JPanel panel;
	
	/** The Constant DELETE_TYPE. */
	private static final String DELETE_TYPE = "Elimina Tipo di Competizione";
	
	/** The Constant CREATE_TYPE. */
	private static final String CREATE_TYPE = "Crea un nuovo Tipo di Competizione";
	
	/** The choice. */
	private String[] choice = {CREATE_TYPE, DELETE_TYPE};
	
	/** The business. */
	private BusinessDelegate business;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The list. */
	private JList list; 
	
	/** The list model. */
	private DefaultListModel listModel;
	
	/** The type name. */
	private JTextField typeName;
	
	/** The lbl inserisci i dati. */
	private JLabel lblInserisciIDati;
	
	/** The btn new button_2. */
	private JButton btnNewButton_2;
	
	/**
	 * Instantiates a new admin types.
	 */
	public AdminTypes() {
		
		frontController = new FrontController();
		business = new BusinessDelegate();
		
		lblNewLabel = new JLabel("GESTISCI TIPI DI COMPETIZIONE");
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
				if(CREATE_TYPE.equals(comboBox.getSelectedItem())) {
					panel.setLayout(null);
					panel.removeAll();
					
					
					typeName = new JTextField();
					typeName.setToolTipText("Può contenere solo lettere e l'apostrofo.");
					typeName.setColumns(10);
					
					JLabel lblNewLabel_2 = new JLabel("Nome:");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
					
					lblInserisciIDati = new JLabel("Inserisci il nome del nuovo tipo di Competizione da creare:");
					lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
					lblInserisciIDati.setFont(new Font("Tahoma", Font.PLAIN, 14));
					
					btnNewButton_2 = new JButton("Crea Tipo");
					
					
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(
						gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(204)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addContainerGap())
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(typeName, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
												.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
											.addGap(205)))))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(82)
								.addComponent(lblInserisciIDati, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(typeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGap(36)
								.addComponent(btnNewButton_2)
								.addContainerGap(30, Short.MAX_VALUE))
					);
					
					btnNewButton_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(!typeName.getText().isEmpty()) {
								boolean created = false;
								try {
									created = (boolean) business.execute("addType", typeName.getText());
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
									JOptionPane.showMessageDialog(null, "Tipo Competizione creato correttamente", "Successo", 1);
									comboBox.setSelectedIndex(-1);
									panel.removeAll();
									panel.revalidate();
									panel.repaint();
								
								} else {
									JOptionPane.showMessageDialog(null, "Creazione tipo di Competizione annullata", "Attenzione", 0);
								}
								
							} else {
								JOptionPane.showMessageDialog(null, "Creazione tipo di Competizione annullata, inserire correttamente il nome", "Attenzione", 0);
							}
							
						}
						
					});
					
						
					
					panel.setLayout(gl_panel);
					panel.revalidate();
					
				} else if(DELETE_TYPE.equals(comboBox.getSelectedItem())) {
					panel.setLayout(null);
					panel.removeAll();
					//inserire elementi grafici per l'eliminazione di un OPTIONAL
					ArrayList<ArrayList<String>> optionalList = new ArrayList<ArrayList<String>>();
					try {
						optionalList = (ArrayList<ArrayList<String>>) business.execute("getTypes", null);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					list = new JList();
					JScrollPane scrollPane = new JScrollPane(list);
					JButton btnNewButton = new JButton("Elimina Tipo Selezionato");
					
					
					
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
						listModel.addElement(optionalList.get(i).toString());
					}
					list.setModel(listModel);
					list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					btnNewButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare " + (String)list.getSelectedValue() + "?" , "Attenzione",0) == 0) {
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
								deleted = (boolean) business.execute("deleteType", selectedOptional.substring(1, index - 1));
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
								JOptionPane.showMessageDialog(null, "Tipo di Competizione eliminato correttamente", "Successo", 1);
								comboBox.setSelectedIndex(-1);
								listModel.remove(selectedOptionalIndex);
								list.setModel(listModel);
								
							} else {
								JOptionPane.showMessageDialog(null, "Eliminazione annullata, gara in corso con il tipo selezionato", "Attenzione", 0);
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
				loadAdminFrame();
			}
			
		});		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(307)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(243)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(56, Short.MAX_VALUE))
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
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		setLayout(groupLayout);	
		
		
	}
	
	/**
	 * Load admin frame.
	 */
	private void loadAdminFrame() {

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
