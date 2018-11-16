/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team10_projectclient.viewreservations;

/**
 *
 * @author Patryk - 15178536
 * 
 * */


import team10_projectclient.view.MyTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ViewReservations extends JFrame implements ActionListener {

    
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
    
    public ViewReservations(String userID) {
        super("All open bookings");
        setSize(880,500);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        String[][] list = getReservations("");
        JLabel [] labels = new JLabel[2];
        labels[0] = new JLabel("All open reservations for user: ");
        labels[1] = new JLabel("Patryk");
        table = new JTable(new MyTableModel(list));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evnt) {
                if (evnt.getClickCount() == 1) {
                JTable source = (JTable)evnt.getSource();
                int row = source.rowAtPoint(evnt.getPoint());
                String s = (String) source.getModel().getValueAt(row, 0);
                System.out.println("Hello " + s);
                }
            }
    });
        scrollPane = new JScrollPane(table);
//        add(labels[0]);
//        add(labels[1]);
        add(scrollPane);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String[][] getReservations(String userID) {
        ArrayList<String[]> arraylist = new ArrayList<String[]>();
        String[] array1 = {"R1","Patryk","4","18:00","14-11-2018","T1","MilanosLmck"}; 
        String[] array2 = {"R2","Patryk","4","18:00","15-11-2018","T15","MilanosLmck"}; 
        String[] array3 = {"R3","Patryk","4","18:00","16-11-2018","T3","MilanosLmck"}; 
        String[] array4 = {"R4","Patryk","4","18:00","17-11-2018","T4","MilanosLmck"}; 
        String[] array5 = {"R5","Patryk","4","18:00","25-11-2018","T1","MilanosLmck"}; 
        arraylist.add(array1);
        arraylist.add(array2);
        arraylist.add(array3);
        arraylist.add(array4);
        arraylist.add(array5);
        
        
        String[][] array = new String[arraylist.size()][arraylist.get(0).length];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < arraylist.get(0).length; j++) {
                array[i][j] = arraylist.get(i)[j];
            }
        }
        // TODO get data from the WS
        return array;
    }
    
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewReservations("");
            }
        });
    }
}
