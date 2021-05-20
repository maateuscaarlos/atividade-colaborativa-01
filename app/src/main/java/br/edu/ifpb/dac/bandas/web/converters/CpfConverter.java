package br.edu.ifpb.dac.bandas.web.converters;

import br.edu.ifpb.dac.bandas.domain.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

@FacesConverter(value = "converter.cpf", forClass = CPF.class)
public class CpfConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        }
        CPF cpf = new CPF(value);
        return cpf;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if(value == null){
            return null;
        }
        CPF cpf = (CPF) value;
        return cpf.valor();
    }

}
