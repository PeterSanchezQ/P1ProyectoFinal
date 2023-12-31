package Controlador;

import Modelo.mod_Calificacion;
import Modelo.mod_Consultas;
import Vista.frm_calificacion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ctrl_calificacion implements ActionListener {

    private mod_Calificacion mod;
    private mod_Consultas modc;
    private frm_calificacion frm;
    DecimalFormat df = new DecimalFormat("#.0");

    public ctrl_calificacion(mod_Calificacion mod, mod_Consultas modc, frm_calificacion frm) {
        this.mod = mod;
        this.modc = modc;
        this.frm = frm;
        this.frm.btn_gua.addActionListener(this);
        this.frm.btn_mod.addActionListener(this);
        this.frm.btn_eli.addActionListener(this);
        this.frm.btn_bus.addActionListener(this);
        this.frm.btn_lim.addActionListener(this);
        this.frm.btn_cali.addActionListener(this);
        this.frm.btn_act.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("-Calificaciones-");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ///////////////////////////////////////Boton Guardar////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_gua) {

            try {
                if (frm.tx_cod.getText().equals("") || frm.tx_nom.getText().equals("") || frm.tx_ape.getText().equals("") || frm.tx_mat.getText().equals("") || frm.tx_n1.getText().equals("") || frm.tx_n2.getText().equals("") || frm.tx_n3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Existen campos vacios");
                } else {
                    if (Double.parseDouble(frm.tx_n1.getText()) <= 5.0 || Double.parseDouble(frm.tx_n2.getText()) <= 5.0 || Double.parseDouble(frm.tx_n3.getText()) <= 5.0) {

                        mod.setCod(Integer.parseInt(frm.tx_cod.getText()));
                        mod.setNom(frm.tx_nom.getText());
                        mod.setApe(frm.tx_ape.getText());
                        mod.setMat(frm.tx_mat.getText());
                        mod.setN1(Double.parseDouble(frm.tx_n1.getText()));
                        mod.setN2(Double.parseDouble(frm.tx_n2.getText()));
                        mod.setN3(Double.parseDouble(frm.tx_n3.getText()));
                        if (modc.registrar(mod)) {
                            JOptionPane.showMessageDialog(null, "Registro Guardado");
                            limpiar();
                        }//fin registrar consulta
                        else {
                            JOptionPane.showMessageDialog(null, "Error de Guardado");
                            limpiar();
                        }//fin else registrar consulta
                    }//fin if notas menor 5
                    else {
                        JOptionPane.showMessageDialog(null, "Notas mayores a 5");
                    }
                }//fin else validar campos vacios
            }//fin try
            catch (HeadlessException | NumberFormatException ex) {
                System.err.println(ex);
            }

        }//fin if guardar

        ///////////////////////////////////////Boton Modificar////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_mod) {
            try {
                if (frm.tx_cod.getText().equals("") || frm.tx_nom.getText().equals("") || frm.tx_ape.getText().equals("") || frm.tx_mat.getText().equals("") || frm.tx_n1.getText().equals("") || frm.tx_n2.getText().equals("") || frm.tx_n3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios");

                } else {

                    mod.setCod(Integer.parseInt(frm.tx_cod.getText()));
                    mod.setNom(frm.tx_nom.getText());
                    mod.setApe(frm.tx_ape.getText());
                    mod.setMat(frm.tx_mat.getText());
                    mod.setN1(Double.parseDouble(frm.tx_n1.getText()));
                    mod.setN2(Double.parseDouble(frm.tx_n2.getText()));
                    mod.setN3(Double.parseDouble(frm.tx_n3.getText()));
                    mod.setNp1(Double.parseDouble(frm.tx_np1.getText()));
                    mod.setNp2(Double.parseDouble(frm.tx_np2.getText()));
                    mod.setNp3(Double.parseDouble(frm.tx_np3.getText()));
                    mod.setNpf(Double.parseDouble(frm.tx_npf.getText()));
                    mod.setCali(frm.tx_cal.getText());

                    if (modc.modificar(mod)) {
                        JOptionPane.showMessageDialog(null, "Registro Modificado");
                        limpiar();
                    }//fin registrar consulta
                    else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar");
                        limpiar();
                    }//fin else registrar consulta
                }//fin else
            }//fin try
            catch (HeadlessException | NumberFormatException ex) {
                System.err.println(ex);
            }
        }//fin if modificar

        ///////////////////////////////////////Boton Eliminar////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_eli) {
            try {
                if (frm.tx_cod.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Ingrese un Codigo ");

                } else {
                    mod.setCod(Integer.parseInt(frm.tx_cod.getText()));

                    if (modc.eliminar(mod)) {
                        JOptionPane.showMessageDialog(null, "Registro Eliminado");
                        limpiar();
                    }//fin registrar consulta
                    else {
                        JOptionPane.showMessageDialog(null, "Error al Eliminar");
                        limpiar();
                    }//fin else registrar consulta
                }//fin else
            }//fin try
            catch (HeadlessException | NumberFormatException ex) {
                System.err.println(ex);
            }

        }//fin if elilminar

        ///////////////////////////////////////Boton Buscar////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_bus) {
            try {
                if (frm.tx_cod.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Ingrese un Codigo ");

                } else {

                    mod.setCod(Integer.parseInt(frm.tx_cod.getText()));

                    if (modc.buscar(mod)) {
                        frm.tx_cod.setText(String.valueOf(mod.getCod()));
                        frm.tx_nom.setText(mod.getNom());
                        frm.tx_ape.setText(mod.getApe());
                        frm.tx_mat.setText(mod.getMat());
                        frm.tx_n1.setText(String.valueOf(mod.getN1()));
                        frm.tx_n2.setText(String.valueOf(mod.getN2()));
                        frm.tx_n3.setText(String.valueOf(mod.getN3()));
                        frm.tx_np1.setText(String.valueOf(mod.getNp1()));
                        frm.tx_np2.setText(String.valueOf(mod.getNp2()));
                        frm.tx_np3.setText(String.valueOf(mod.getNp3()));
                        frm.tx_npf.setText(String.valueOf(mod.getNpf()));
                        frm.tx_cal.setText(mod.getCali());
                    }//fin registrar consulta
                    else {
                        JOptionPane.showMessageDialog(null, "No se encontro ningun resultado");
                        limpiar();
                    }//fin else registrar consulta
                }//fin else
            }//fin try
            catch (HeadlessException | NumberFormatException ex) {
                System.err.println(ex);
            }
        }//fin if buscar

        ///////////////////////////////////////Boton Limpiar////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_lim) {
            limpiar();
        }//fin if limpiar

        ///////////////////////////////////////Boton Calificar////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_cali) {
            try {
                if (frm.tx_cod.getText().equals("") || frm.tx_nom.getText().equals("") || frm.tx_ape.getText().equals("") || frm.tx_mat.getText().equals("") || frm.tx_n1.getText().equals("") || frm.tx_n2.getText().equals("") || frm.tx_n3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campos Vacios");

                } else {
                    Calificar();
                    mod.setCod(Integer.parseInt(frm.tx_cod.getText()));
                    mod.setNp1(Double.parseDouble(frm.tx_np1.getText()));
                    mod.setNp2(Double.parseDouble(frm.tx_np2.getText()));
                    mod.setNp3(Double.parseDouble(frm.tx_np3.getText()));
                    mod.setNpf(Double.parseDouble(frm.tx_npf.getText()));
                    mod.setCali(frm.tx_cal.getText());

                    if (modc.modificar(mod)) {
                        JOptionPane.showMessageDialog(null, "Registro Calificado");

                    }//fin registrar consulta
                    else {
                        JOptionPane.showMessageDialog(null, "Error al Calificar");

                    }//fin else registrar consulta
                }//fin else
            }//fin try
            catch (HeadlessException | NumberFormatException ex) {
                System.err.println(ex);
            }
        }//fin if calificar

        ///////////////////////////////////////Boton Actualizar tabla////////////////////////////////////////////////////
        if (e.getSource() == frm.btn_act) {
            frm.lim_list();
            frm.actualizar_lista();
        }//fin if buscar

        /////////////////////////////////////////////////////////////////////////////////////////
    }//fin clase action listener

    //////////////////////////////////////Funcion LImpiar////////////////////////////////////////////////////
    public void limpiar() {
        frm.tx_cod.setText(null);
        frm.tx_nom.setText(null);
        frm.tx_ape.setText(null);
        frm.tx_mat.setText(null);
        frm.tx_n1.setText(null);
        frm.tx_n2.setText(null);
        frm.tx_n3.setText(null);
        frm.tx_np1.setText(null);
        frm.tx_np2.setText(null);
        frm.tx_np3.setText(null);
        frm.tx_npf.setText(null);
        frm.tx_cal.setText("-");
        frm.tx_cod.requestFocus();
    }//fin limpiar

//////////////////////////////////////Funcion Calcular////////////////////////////////////////////////////
    public void Calificar() {
        double n1 = 0, n2 = 0, n3 = 0, np1 = 0, np2 = 0, np3 = 0, npf = 0;
        String cali;

        n1 = Double.parseDouble(frm.tx_n1.getText());
        n2 = Double.parseDouble(frm.tx_n2.getText());
        n3 = Double.parseDouble(frm.tx_n3.getText());

        np1 = (n1 / 5) * 15;
        np2 = (n2 / 5) * 35;
        np3 = (n3 / 5) * 50;
        frm.tx_np1.setText(String.valueOf(df.format(np1)));
        frm.tx_np2.setText(String.valueOf(df.format(np2)));
        frm.tx_np3.setText(String.valueOf(df.format(np3)));
        npf = (np1 + np2 + np3) * 5 / 100;
        if (npf
                >= 3.5) {
            cali = "Aprobado";
            frm.tx_npf.setText(String.valueOf(df.format(npf)));
            frm.tx_cal.setText(cali);
        } else {

            cali = "Reprobado";
            frm.tx_npf.setText(String.valueOf(df.format(npf)));
            frm.tx_cal.setText(cali);
        }
    }

}
