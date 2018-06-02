package sv.edu.ufg.Controlador;

import sv.edu.ufg.modelo.MdatosEnvio;
import sv.edu.ufg.Mysqlconector.Cconexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class dataFillTable implements Serializable {

    private List<MdatosEnvio> datosF;

    public List<MdatosEnvio> getDatosF() {
        return datosF;
    }

    public void setDatosF(List<MdatosEnvio> datosF) {
        this.datosF = datosF;
        
        
        
        
    }

    @PostConstruct
    public void init() {
        datosF = getData();
    }

    public List getData() {
        //Extrallendo la data
        Connection cnn = Cconexion.conectar_ds();
        ResultSet rset = null;
        Statement sta;
        datosF = new ArrayList<>();
        try {
            sta = cnn.createStatement();
            rset = sta.executeQuery("SELECT\n"
                    + "    `datos`.`id_dato`\n"
                    + "    , `datos`.`humedad`\n"
                    + "    , `datos`.`fecha`\n"

                    + "FROM\n"
                    + "    `dbbd`.`datos`\n");
                   
            
            while (rset.next()) {
                MdatosEnvio datosFill = new MdatosEnvio();
                datosFill.setId_dato(rset.getInt("id_dato"));
                datosFill.setHumedad(rset.getDouble("humedad"));
                datosFill.setFecha(rset.getString("fecha"));
               
                datosF.add(datosFill);
            }
            rset.close();
            sta.close();
            cnn.close();
            return datosF;
        } catch (SQLException ex) {
            return null;
        }
    }

}
