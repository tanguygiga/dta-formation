package fr.pizzeria.model;

public class Log {

	private String path;
	private long after;
	private long before;
	private long duration;

	public Log() {

		this.path = null;
		this.after = 0;
		this.before = 0;
		this.duration = after - before;
	}

	public String getPath() {
		return path;
	}

	public long getAfter() {
		return after;
	}

	public long getBefore() {
		return before;
	}

	public long getDuration() {
		return duration;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setAfter(long after) {
		this.after = after;
	}

	public void setBefore(long before) {
		this.before = before;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

}
