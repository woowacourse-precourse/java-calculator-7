package delimiter.custom;

public enum CustomDelimiter {

	START("//"),
	END("\\n");

	private final String descripton;

	CustomDelimiter(String descripton) {
		this.descripton = descripton;
	}

	public String getDescripton() {
		return descripton;
	}
}
