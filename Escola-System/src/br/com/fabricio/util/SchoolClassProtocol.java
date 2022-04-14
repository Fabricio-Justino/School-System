package br.com.fabricio.util;

public interface SchoolClassProtocol extends Comparable<SchoolClassProtocol>, Identifiable<String> {
	
	@Override
	default int compareTo(SchoolClassProtocol other) {
		return this.getId().compareTo(other.getId());
	}
}
