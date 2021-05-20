package br.edu.ifpb.dac.bandas.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@FacesConverter(value = "converter.Date", forClass = LocalDate.class)
public class DateConverter implements Converter {

    private DateTimeFormatter formmater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        if (value == null) return null;

        return LocalDate.parse(value, formmater);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        if (value == null) return "";

        return formmater.format((LocalDate) value);
    }
}
