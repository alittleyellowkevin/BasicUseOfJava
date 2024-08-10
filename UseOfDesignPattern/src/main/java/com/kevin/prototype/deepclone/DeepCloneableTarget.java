package com.kevin.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String cloneName;

	private String cloneClass;

	public DeepCloneableTarget(String cloneName, String cloneClass) {
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
