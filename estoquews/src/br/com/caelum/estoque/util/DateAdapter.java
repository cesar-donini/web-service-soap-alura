package br.com.caelum.estoque.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private String pattern = "dd/MM/yyyy";

	@Override
	public Date unmarshal(String stringDate) throws Exception {
		return new SimpleDateFormat(pattern).parse(stringDate);
	}

	@Override
	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat(pattern).format(date);
	}
}
