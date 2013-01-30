package org.slc.sli.ingestion.parser;

public interface TypeProvider {
	public boolean isComplexType(String elementName);
	public boolean isReference(String elementName);
	public Object convertType(String elementName, String value);
	boolean existsInSchema(String parentName, String name);
}
