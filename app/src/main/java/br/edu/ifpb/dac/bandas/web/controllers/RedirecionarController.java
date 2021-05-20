package br.edu.ifpb.dac.bandas.web.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class RedirecionarController implements Serializable {

    public static void redirecionarPagina(String pagina) {
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        try {
            context.getExternalContext().redirect(url + "/" + pagina);
        } catch (IOException ex) {
            Logger.getLogger(RedirecionarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
