package Principal;

import Controlador.ctrl_calificacion;
import Modelo.mod_Calificacion;
import Modelo.mod_Consultas;
import Vista.frm_calificacion;

public class Main {

     public static void main(String[] args) {
        mod_Calificacion mod= new mod_Calificacion();
        mod_Consultas modc=new mod_Consultas();
        frm_calificacion frm=new frm_calificacion();
        
        ctrl_calificacion ctrl=new ctrl_calificacion(mod, modc, frm);
        ctrl.iniciar();
        frm.setVisible(true);
                
    }
    
}
