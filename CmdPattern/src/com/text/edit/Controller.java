package com.text.edit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.BadLocationException;

public class Controller implements KeyListener {
	private List<CmdOperation> operations = new ArrayList<CmdOperation>();
	private View mParent;
	private boolean ctrlPressed = false;

	public Controller(View parent) {
		mParent = parent;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		try {
			if(!ctrlPressed) {
				String text = mParent.getTextArea().getDocument().getText(0
						, mParent.getTextArea().getDocument().getLength());
				operations.add(new CmdOperation(text, new String(text + e.getKeyChar())
						, operations.size()));
			}
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!ctrlPressed) {
			ctrlPressed = e.getKeyCode() == 17;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 17) {
			ctrlPressed = false;
		}
		if(ctrlPressed) {
			//ctrl+z
			if(e.getKeyCode() == 90) {
				CmdOperation operation = operations.get(operations.size() - 1);
				if(!operation.undone) {
					undoOperation(operation);
				} else {
					operation = findOperationToUndo();
					if(operation != null) {
						undoOperation(operation);
					}
				}
			}
			//ctrl+y
			if(e.getKeyCode() == 89) {
				CmdOperation operation = findOperationToRedo();
				if(operation != null)
					redoOperation(operation);
			}
		}
	}
	
	private void undoOperation(CmdOperation operation) {
		mParent.getTextArea().setText((String)operation.oldValue);
		operation.undone = true;
	}
	
	private void redoOperation(CmdOperation operation) {
		mParent.getTextArea().setText((String)operation.newValue);
		operation.undone = false;
	}
	
	private CmdOperation findOperationToUndo() {
		List<CmdOperation> revesedOperations = new ArrayList<CmdOperation>(operations);
		Collections.reverse(revesedOperations);
		for(CmdOperation operation : revesedOperations) {
			if(!operation.undone) {
				return operation;
			}
		}
		
		return null;
	}
	
	private CmdOperation findOperationToRedo() {
		for(CmdOperation operation : operations) {
			if(operation.undone) {
				return operation;
			}
		}
		
		return null;
	}
}
