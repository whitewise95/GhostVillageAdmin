package com.example.ghostvillageadmin.app.account.dto;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class PrincipalDto {

	@Getter
	@Setter
	@ApiResponse(description = "PrincipalDto BasePrincipal")
	public static class BasePrincipal {

		private Long accountId;

		private String name;

		private LocalDateTime createdAt;
	}

	@Getter
	@Setter
	@ApiResponse(description = "")
	public static class UserPrincipalResponse extends BasePrincipal {

	}
}
