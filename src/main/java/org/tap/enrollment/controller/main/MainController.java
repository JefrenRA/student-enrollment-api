package org.tap.enrollment.controller.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                                                     /* This annotation indicates that it's a controller for a RESTful web service and that
																	 * the methods in the class should be mapped to specific HTTP endpoints
																	 */
public class MainController {

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "Your account role don't have permission to access this site.";
	}
}