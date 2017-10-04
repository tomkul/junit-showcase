package extensions;

import java.util.Date;

public class CustomType {

	private final Date date = new Date();

	@Override
	public String toString() {
		return "CustomType: " + this.date;
	}

}
