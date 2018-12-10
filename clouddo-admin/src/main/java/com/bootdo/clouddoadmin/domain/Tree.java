package com.bootdo.clouddoadmin.domain;

import java.util.*;


public class Tree<T>  {
	private static final long serialVersionUID = 1L;

	private String id;

	private String text;

	private Map<String, Object> state;

	private boolean checked = false;

	private Map<String, Object> attributes;

	private  Object object;


	private List<Tree<T>> children = new ArrayList<Tree<T>>();


	private String parentId;

	private boolean hasParent = false;


	private boolean hasChildren = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, Object> getState() {
		return state;
	}

	public void setState(Map<String, Object> state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}

	public boolean isHasParent() {
		return hasParent;
	}

	public void setHasParent(boolean isParent) {
		this.hasParent = isParent;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setChildren(boolean isChildren) {
		this.hasChildren = isChildren;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Tree(String id, String text, Map<String, Object> state, boolean checked, Map<String, Object> attributes,Object object,
                List<Tree<T>> children, boolean isParent, boolean isChildren, String parentID) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.setObject(object);
		this.children = children;
		this.hasParent = isParent;
		this.hasChildren = isChildren;
		this.parentId = parentID;
	}
	public Tree() {
		super();
	}
}