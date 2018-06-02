/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.modelo;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author sofya
 * @ManagedBean
 */
@ManagedBean(name = "Mlogin")
@Dependent

public class Mlogin {

    //private static final long serialVersionUID = 1L;
    private String name;
    private String pass;
   


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

 
 

   

}
