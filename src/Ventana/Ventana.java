package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import clases.Logica;
import clases.PersonaVO;
import java.awt.SystemColor;

public class Ventana extends JFrame implements ActionListener{
    
    private JTextArea areaResultado;
    private JTextField txtDocumento;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPeso;
    private JTextField txtTalla;
    JButton btnCalcularIMC, btnRegistrar, btnCalcularPromedio, btnListaPersonas;
    private JScrollPane scrollPane;
    
    Logica miLogica;

    public Ventana() {
        setTitle("HOME");
        setSize(730, 540);
        setLocationRelativeTo(null);
        miLogica = new Logica();
        initialize();
        
    }

    private void initialize() {
        getContentPane().setBackground(SystemColor.activeCaption);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("CALCULAR IMC");
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
        lblTitulo.setBounds(300, 12, 140, 17);
        getContentPane().add(lblTitulo);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(12, 83, 81, 17);
        getContentPane().add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(99, 81, 140, 27);
        getContentPane().add(txtDocumento);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(247, 83, 110, 17);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(312, 83, 213, 27);
        getContentPane().add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(546, 78, 41, 27);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(597, 83, 65, 27);
        getContentPane().add(txtEdad);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(12, 162, 48, 17);
        getContentPane().add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(59, 162, 119, 27);
        getContentPane().add(txtPeso);

        JLabel lblTalla = new JLabel("Talla:");
        lblTalla.setBounds(247, 162, 41, 17);
        getContentPane().add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(300, 162, 71, 27);
        getContentPane().add(txtTalla);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setFont(new Font("Dialog", Font.BOLD, 14));
        lblResultado.setBounds(12, 206, 110, 17);
        getContentPane().add(lblResultado);

        areaResultado = new JTextArea();
        areaResultado.setBounds(1, 1, 694, 93);
        getContentPane().add(areaResultado);
        
        scrollPane = new JScrollPane(areaResultado);
        scrollPane.setBounds(12, 235, 696, 183);
        getContentPane().add(scrollPane);

        btnCalcularIMC = new JButton("Calcular IMC");
        btnCalcularIMC.setBounds(362, 448, 147, 27);
        btnCalcularIMC.addActionListener(this);
        getContentPane().add(btnCalcularIMC);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(210, 448, 147, 27);
        btnRegistrar.addActionListener(this);
        getContentPane().add(btnRegistrar);
        
        btnListaPersonas = new JButton("Consultar Lista");
        btnListaPersonas.setBounds(516, 448, 192, 27);
        btnListaPersonas.addActionListener(this);
        getContentPane().add(btnListaPersonas);

        btnCalcularPromedio = new JButton("Calcular Promedio IMC");
        btnCalcularPromedio.setBounds(12, 448, 192, 27);
        btnCalcularPromedio.addActionListener(this);
        getContentPane().add(btnCalcularPromedio);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnRegistrar) {
			
			PersonaVO miPersona = new PersonaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			
			
			String res = miLogica.registrarPersona(miPersona);
			areaResultado.setText(res);
			
			txtDocumento.setText("");
			txtNombre.setText("");
			txtEdad.setText("");
			txtPeso.setText("");
			txtTalla.setText("");
			
		}
		if(e.getSource()==btnListaPersonas) {
			String res = miLogica.consultarListaPersonas();
			areaResultado.setText(res);
		}
		if(e.getSource()==btnCalcularIMC) {
			String res=miLogica.consultarPromedio();
			areaResultado.setText(res);
		}
		if (e.getSource()==btnCalcularPromedio) {
			String res=miLogica.consultarPromedio();
			areaResultado.setText(res);	
		}
		
	}
}

