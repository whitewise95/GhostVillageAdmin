package com.example.ghostvillageadmin.app.utils;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.format.annotation.DateTimeFormat;

@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
@DateTimeFormat(pattern = "yyyy-MM-dd")
public @interface DateFormat {

}
