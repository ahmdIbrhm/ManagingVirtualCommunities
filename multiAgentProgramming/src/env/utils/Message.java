package utils;

import users.User;

public class Message {
	User userFrom;
	User userTo;
	String message;
	
	public Message(User userFrom, User userTo, String message) {
		super();
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.message = message;
	}
	public User getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}
	public User getUserTo() {
		return userTo;
	}
	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
