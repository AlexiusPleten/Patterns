package com.text.edit;

public class CmdOperation {
	public int id;
	public Object oldValue;
	public Object newValue;
	public boolean undone = false;
	
	public CmdOperation(Object oldVal, Object newVal, int id) {
		this.id = id;
		oldValue = oldVal;
		newValue = newVal;
	}
}
