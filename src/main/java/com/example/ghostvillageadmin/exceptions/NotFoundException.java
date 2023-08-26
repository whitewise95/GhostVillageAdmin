package com.example.ghostvillageadmin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private final String message;

	public NotFoundException() {
		this.message = ("Not found Records.");
	}

	public NotFoundException(String message) {
		this.message = message;
	}

	public NotFoundException(String message, Boolean isDefault) {
		if (Boolean.TRUE.equals(isDefault)) {
			this.message = getPostWord(message, "이", "가") + " 존재하지 않습니다.";
		} else {
			this.message = message;
		}
	}

	/**
	 * 한글 조사 (이,가) 붙여주는 서비스 한글 조사 연결 (을/를,이/가,은/는,로/으로) 1. 종성에 받침이 있는 경우 '을/이/은/으로/과' 2. 종성에 받침이 없는 경우 '를/가/는/로/와' 3. '로/으로'의 경우 종성의 받침이 'ㄹ' 인경우 '로'
	 */
	public static String getPostWord(String str, String firstVal, String secondVal) {

		try {
			char laststr = str.charAt(str.length() - 1);
			// 한글의 제일 처음과 끝의 범위밖일 경우는 오류
			if (laststr < 0xAC00 || laststr > 0xD7A3) {
				return str;
			}

			int lastCharIndex = (laststr - 0xAC00) % 28;

			// 종성인덱스가 0이상일 경우는 받침이 있는경우이며 그렇지 않은경우는 받침이 없는 경우
			if (lastCharIndex > 0) {
				// 받침이 있는경우
				// 조사가 '로'인경우 'ㄹ'받침으로 끝나는 경우는 '로' 나머지 경우는 '으로'
				if (firstVal.equals("으로") && lastCharIndex == 8) {
					str += secondVal;
				} else {
					str += firstVal;
				}
			} else {
				// 받침이 없는 경우
				str += secondVal;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return str;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
