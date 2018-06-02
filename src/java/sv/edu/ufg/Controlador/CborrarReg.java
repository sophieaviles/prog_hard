/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Medrano
 */
@ManagedBean(name="s")
public class CborrarReg 
{
    


public void delete(int id_dato)
{
    PreparedStatement ps = null;
    Connection con = null;
    if(id_dato !=0)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbd", "root", "12345");
            String sql = "DELETE FROM datos WHERE id_dato="+id_dato;
            ps= con.prepareStatement(sql); 
            int i = ps.executeUpdate();
            if(i >0)
            { 
                System.out.println("Row deleted successfully");
                
                RequestContext.getCurrentInstance().update("growlBorrar");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO!", "Registro Borrado con Éxito."));
    

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
        try
        {
            con.close();
            ps.close();
        }
        catch(SQLException e)
        {
            Logger.getLogger(CborrarReg.class.getName()).log(Level.SEVERE,null,e);

            e.printStackTrace();
        }
        }
    }
} 
    
    
    
    
}

