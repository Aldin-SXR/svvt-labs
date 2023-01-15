package ibu.svvt_lab14.exam2;

public class Error {
	String message;
	String fileName;
	int lineNumber;
	int severityLevel;
	String dateTime;
	double occurenceAverage;
	
	public Error(String message, String fileName, int lineNumber, int severityLevel, String dateTime,
			double occurenceAverage) {
		super();
		this.message = message;
		this.fileName = fileName;
		this.lineNumber = lineNumber;
		this.severityLevel = severityLevel;
		this.dateTime = dateTime;
		this.occurenceAverage = occurenceAverage;
	}
	
	public String errorType() {
		if (severityLevel <= 1) {
			return "notice";
		}
		if (severityLevel <= 4) {
			return "warning";
		}
		if (severityLevel <= 6) {
			return "error";
		}
		return "critical failure";
	}
	
	public boolean isUrgent() {
		if (severityLevel >= 5 && occurenceAverage > 5) {
			return true;
		}
		return false;
	}
	
	public String format() {
		return dateTime + " | " + severityLevel + " | " + fileName
				+ " | " + lineNumber + " | " + message;
	}
}
