package separate;

public enum Separator {
	BASIC(",", ":"),		// 기본 구분자
	CUSTOM("//", "\\n");	// 커스텀 구분자
	
	private String sep1, sep2;
	
	Separator(String sep1, String sep2) {
		this.sep1 = sep1;
		this.sep2 = sep2;
	}
	
	public boolean hasAllSeparators(String str) {
		return str.contains(sep1) && str.contains(sep2);
	}
	
	public boolean hasOneSeparators(String str) {
		return str.contains(sep1) || str.contains(sep2);
	}
	
	public String[] getSeparators() {
		return new String[] {sep1, sep2};
	}
}
