package Modelo;

import Vista.frm_calificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mod_Consultas extends mod_Conexion {
    frm_calificacion frm= new frm_calificacion();
    ///////////////////////////////////////Guardar Registro////////////////////////////////////////////////////
    public boolean registrar(mod_Calificacion cal) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        //consulta
        String sql = "INSERT INTO calificacion (Codigo,Nombre,Apellido,Materia,Nota1,Nota2,Nota3) VALUES (?,?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1,cal.getCod());
            ps.setString(2, cal.getNom());
            ps.setString(3, cal.getApe());
            ps.setString(4, cal.getMat());
            ps.setDouble(5, cal.getN1());
            ps.setDouble(6, cal.getN2());
            ps.setDouble(7, cal.getN3());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    ///////////////////////////////////////Modificar Registro////////////////////////////////////////////////////
    public boolean modificar(mod_Calificacion cal) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        //consulta
        String sql = "update calificacion  set Nombre=?,Apellido=?,Materia=?,Nota1=?,Nota2=?,Nota3=?,Notap1=?,Notap2=?,Notap3=?,NotaFinal=?,Calificacion=? where Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, cal.getNom());
            ps.setString(2, cal.getApe());
            ps.setString(3, cal.getMat());
            ps.setDouble(4, cal.getN1());
            ps.setDouble(5, cal.getN2());
            ps.setDouble(6, cal.getN3());
            ps.setDouble(7, cal.getNp1());
            ps.setDouble(8, cal.getNp2());
            ps.setDouble(9, cal.getNp3());
            ps.setDouble(10, cal.getNpf());
            ps.setString(11, cal.getCali());
            ps.setInt(12, cal.getCod());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    ///////////////////////////////////////Eliminar Registro////////////////////////////////////////////////////
    public boolean eliminar(mod_Calificacion cal) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        //consulta
        String sql = "delete from calificacion where Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cal.getCod());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    ///////////////////////////////////////Buscar Registro////////////////////////////////////////////////////
    public boolean buscar(mod_Calificacion cal) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        //consulta
        String sql = "select Codigo,Nombre,Apellido,Materia,Nota1,Nota2,Nota3,Notap1,Notap2,Notap3,NotaFinal,Calificacion from calificacion where Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cal.getCod());
            rs = ps.executeQuery();

            if (rs.next()) {
                cal.setCod(Integer.parseInt(rs.getString("Codigo")));
                cal.setNom(rs.getString("Nombre"));
                cal.setApe(rs.getString("Apellido"));
                cal.setMat(rs.getString("Materia"));
                cal.setN1(Double.parseDouble(rs.getString("Nota1")));
                cal.setN2(Double.parseDouble(rs.getString("Nota2")));
                cal.setN3(Double.parseDouble(rs.getString("Nota3")));
                cal.setNp1(Double.parseDouble(rs.getString("Notap1")));
                cal.setNp2(Double.parseDouble(rs.getString("Notap2")));
                cal.setNp3(Double.parseDouble(rs.getString("Notap3")));
                cal.setNpf(Double.parseDouble(rs.getString("NotaFinal")));
                cal.setCali(rs.getString("Calificacion"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    ///////////////////////////////////////Calificar Registro////////////////////////////////////////////////////

    public boolean calificar(mod_Calificacion cal) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        //consulta
        String sql = "update calificacion  set Notap1=?,Notap2=?,Notap3=?,NotaFinal=?,Calificacion=? where Codigo=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setDouble(1, cal.getNp1());
            ps.setDouble(2, cal.getNp2());
            ps.setDouble(3, cal.getNp3());
            ps.setDouble(4, cal.getNpf());
            ps.setString(5, cal.getCali());
            ps.setInt(6, cal.getCod());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }



}//fin clase
