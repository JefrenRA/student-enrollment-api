package org.tap.enrollment.genericresponse;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericDetails<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Header")
	private Header header;

	@JsonProperty("Body")
	private T body;

	public GenericDetails(Integer statusCode, String status) {
		this.header = new Header(generateDate(), statusCode, status);
	}
	
	private String generateDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime currentDateTime = LocalDateTime.now();
		return currentDateTime.format(formatter);
	}
	
	class Header {
		@JsonProperty("DateTime")
		private String dateTime;

		@JsonProperty("StatusCode")
		private Integer statusCode;

		@JsonProperty("Status")
		private String status;

		public Header(String dateTime, Integer statusCode, String status) {
			super();
			this.dateTime = dateTime;
			this.statusCode = statusCode;
			this.status = status;
		}
	}
}
