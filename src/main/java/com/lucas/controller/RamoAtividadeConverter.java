package com.lucas.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.lucas.model.RamoAtividade;

public class RamoAtividadeConverter implements Converter<Object> {

	private List<RamoAtividade> listaRamoAtividade;

	public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividade) {
		this.listaRamoAtividade = listaRamoAtividade;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		Long id = Long.valueOf(value);

		for (RamoAtividade ramo : listaRamoAtividade) {
			if (id.equals(ramo.getId())) {
				return ramo;

			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		RamoAtividade ramoAtividade = (RamoAtividade) value;

		return ramoAtividade.getId().toString();
	}

}
