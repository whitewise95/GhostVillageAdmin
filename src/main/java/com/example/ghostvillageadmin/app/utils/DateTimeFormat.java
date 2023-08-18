package com.example.ghostvillageadmin.app.utils;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
@org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
public @interface DateTimeFormat {

}
