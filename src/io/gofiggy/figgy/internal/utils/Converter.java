package io.gofiggy.figgy.internal.utils;

import java.awt.TextComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Converter {
	
	// VALUE CONVERTER
	
	// The value converter is an internal utility, but
	// feel free to use it in your project if you'd like!
	
	Object realValue = null;
	@SuppressWarnings("rawtypes")
	Class realValueOrigin = null;
	
	public Converter() {}
	public Converter(Object value) {
		setValue(value);
	}
	
	// EQUALS METHODS
	
	// There are many methods here, so choose wisely. The
	// equals methods are just like your standard java equals
	// methods but they actually work and change dynamically
	// depending on your input source.
	
	public boolean equals(Object content) {
		if(realValue.equals(content)) return true;
		return false;
	}
	
	public boolean equals(String content) {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(TextComponent.class) || realValueOrigin.equals(UUID.class)) {
			if(("" + realValue + "").equals(content)) return true;
			if(realValue.toString().equals(content)) return true;
		}
		return false;
	}
	
	public boolean equals(Integer content) {
		if(realValueOrigin.equals(int.class) || realValueOrigin.equals(Integer.class) || realValueOrigin.equals(float.class)  || realValueOrigin.equals(double.class)) {
			try {
				if(realValue.equals(content)) return true;
				if(content.equals(Integer.parseInt("" + realValue + ""))) return true;
				if(content.equals((Integer) realValue)) return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean equals(UUID content) {
		if(realValueOrigin.equals(UUID.class) || realValueOrigin.equals(String.class)) {
			if(realValue.equals(content)) return true;
			if(content.equals(UUID.fromString((String) realValue))) return true;
			if(content.equals((UUID) realValue)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(HashMap content) {
		if(realValueOrigin.equals(HashMap.class) || realValueOrigin.equals(Map.class)) {
			Map contentAsMap = (Map) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsMap)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(Map content) {
		if(realValueOrigin.equals(HashMap.class) || realValueOrigin.equals(Map.class)) {
			HashMap contentAsMap = (HashMap) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsMap)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(ArrayList content) {
		if(realValueOrigin.equals(ArrayList.class) || realValueOrigin.equals(List.class)) {
			List contentAsList = (List) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsList)) return true;
			if(realValue.equals(content.toArray())) return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean equals(List content) {
		if(realValueOrigin.equals(ArrayList.class) || realValueOrigin.equals(List.class)) {
			ArrayList contentAsArrayList = (ArrayList) content;
			if(realValue.equals(content)) return true;
			if(realValue.equals(contentAsArrayList)) return true;
			if(realValue.equals(content.toArray())) return true;
		}
		return false;
	}
	
	public boolean equals(Boolean content) {
		if(realValueOrigin.equals(Boolean.class)) {
			if(realValue.equals(content)) return true;
		}
		if(realValueOrigin.equals(String.class)) {
			if(content) {
				if(realValue.equals("true")) return true;
			}
			if(!content) {
				if(realValue.equals("false")) return true;
			}
		}
		return false;
	}
	
	// TO(*) METHODS
	
	// These methods can be used to convert similar variable
	// types to other variables easily, these are still in the
	// works; so use with caution.
	
	public String toString() {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(UUID.class) || realValueOrigin.equals(Integer.class) || realValueOrigin.equals(int.class) || realValueOrigin.equals(float.class) || realValueOrigin.equals(double.class)) {
			return "" + realValue + "";
		} else {
			return null;
		}
	}
	
	public int toInt() {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(Integer.class) || realValueOrigin.equals(int.class) || realValueOrigin.equals(float.class) || realValueOrigin.equals(double.class)) {
			try {
				return (int) Integer.parseInt("" + realValue + "");
			} catch (Exception e) {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	public Integer toInteger() {
		return (Integer) toInt();
	}
	
	public void setValue(Object value) {
		realValue = value;
		realValueOrigin = value.getClass();
	}
	
	public Object getValue() {
		return realValue;
	}
	
	@SuppressWarnings("rawtypes")
	public Class getValueType() {
		return realValueOrigin;
	}
	
	// CAN/IS METHODS
	
	// These methods check if the value is considered or
	// available to be a specified other type.
	
	@SuppressWarnings("unused")
	public boolean canIsString() {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(UUID.class)) {
			if(("" + realValue + "") != null) return true;
		} else return false;
		return false;
	}
	
	public boolean canIsInteger() {
		if(realValueOrigin.equals(Integer.class) || realValueOrigin.equals(int.class) || realValueOrigin.equals(float.class) || realValueOrigin.equals(double.class)) {
			try {
				if(Integer.parseInt("" + realValue + "") >= (int) 999999999) return true;
			} catch (Exception e) { return false; };
		} else {
			return false;
		}
		return false;
	}
	
	// CAN BE MEATHODS
	
	// These are just like Can Is meathods except they do
	// not allow for converting, and just simular variable
	// types.
	
	@SuppressWarnings("unused")
	public boolean canBeString() {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(UUID.class) || realValueOrigin.equals(Integer.class) || realValueOrigin.equals(int.class) || realValueOrigin.equals(float.class) || realValueOrigin.equals(double.class)) {
			if(("" + realValue + "") != null) return true;
		} else return false;
		return false;
	}
	
	public boolean canBeInteger() {
		if(realValueOrigin.equals(String.class) || realValueOrigin.equals(Integer.class) || realValueOrigin.equals(int.class) || realValueOrigin.equals(float.class) || realValueOrigin.equals(double.class)) {
			try {
				if(Integer.parseInt("" + realValue + "") >= (int) 999999999) return true;
			} catch (Exception e) { return false; }
		} else {
			return false;
		}
		return false;
	}
}
