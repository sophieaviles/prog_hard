/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.Controlador;
import sv.edu.ufg.Mysqlconector.Cconexion;
import java.sql.*;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sofya
 */

@ManagedBean(name = "clogin")
@SessionScoped

public class Clogin {
    
   private int nAcceso;
  
   public void login(String user, String pwd)
   {
        Connection cnn = null;
        PreparedStatement psta=null;
        
        try {
            
            cnn = Cconexion.conectar_ds();
            psta = cnn.prepareStatement("SELECT id_rol FROM usuario WHERE usuario= ? and contraseña= ? ");
            
            psta.setString(1, user);
            psta.setString(2,pwd);

            ResultSet rs= psta.executeQuery();
            
            if (rs.next()) // found
            {    
                nAcceso=rs.getInt("id_rol");
                
                switch(nAcceso)
                {
                    case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Vista_usuarioEdit.xhtml");
                    break;   
                    
                    case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Vista_usurioEdit.xhtml");
                    break;
                    
                }
               
          
            }
            else
            {
            RequestContext.getCurrentInstance().update("growlLogin");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CREDENCIALES NO VALIDAS", "¡INVALID CREDENTIALS!"));
            
            }
            
        }
            catch (Exception e) 
            {
            
            
            }
           

       
    }
}
            
        
      