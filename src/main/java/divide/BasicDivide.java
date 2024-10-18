package divide;

public class BasicDivide implements Divide {
	@Override
	public void divide(final String str) {
		String[] arr = {};
		
		if (str.equals("")) {
			arr = new String[] {"0"};
		} else if (str.contains(",") || str.contains(":")) {
			arr = str.split("[,:]");
		}
	}
}
