package com.lucas.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

//Define que a anotação pode ser aplicada em métodos e classes.
@Target({ ElementType.METHOD, ElementType.TYPE })
//Define que a anotação estará disponível em tempo de execução.
@Retention(RetentionPolicy.RUNTIME)
//Indica que esta anotação será usada para interceptar chamadas.
@InterceptorBinding
public @interface Transacional {

}