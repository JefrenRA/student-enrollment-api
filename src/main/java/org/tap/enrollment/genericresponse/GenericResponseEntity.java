package org.tap.enrollment.genericresponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericResponseEntity {

	private static final HttpStatus OK = HttpStatus.OK;
	private static final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
	private static final HttpStatus FORBIDDEN = HttpStatus.FORBIDDEN;

	public final static <T> ResponseEntity<?> createSuccessEntity(T body) {
		GenericDetails<T> details = new GenericDetails<>(OK.value(), OK.getReasonPhrase());
		details.setBody(body);

		return new ResponseEntity<>(details, OK);
	}

	public final static <T> ResponseEntity<?> notFoundEntity(T body) {
		GenericDetails<T> details = new GenericDetails<>(NOT_FOUND.value(), NOT_FOUND.getReasonPhrase());
		details.setBody(body);

		return new ResponseEntity<>(details, NOT_FOUND);
	}

	public final static <T> ResponseEntity<?> forbiddenEntity(T body) {
		GenericDetails<T> details = new GenericDetails<>(FORBIDDEN.value(), FORBIDDEN.getReasonPhrase());
		details.setBody(body);

		return new ResponseEntity<>(details, FORBIDDEN);
	}

}
