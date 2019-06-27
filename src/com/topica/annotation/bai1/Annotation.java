package com.topica.annotation.bai1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Target(value = { ElementType.FIELD, ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface getNameFieldMethod {
	String value() default "";
}

public class Annotation {
	public static void getNameFieldMethod(Object obj) {
		Class<?> newClass = obj.getClass();
		Field[] fields = newClass.getDeclaredFields();
		Method[] methods = newClass.getDeclaredMethods();

		// get Name of Field
		for (Field field : fields) {
			getNameFieldMethod checkAnno = field.getAnnotation(getNameFieldMethod.class);
			if (checkAnno != null) {
				field.setAccessible(true);
				System.out.println("Field placed Annotation: " + field.getName());
			}
		}

		// get Name of Method
		for (Method method : methods) {
			getNameFieldMethod checkAnno = method.getAnnotation(getNameFieldMethod.class);
			if (checkAnno != null) {
				method.setAccessible(true);
				System.out.println("Method placed Annotation: " + method.getName());
			}
		}

		// get value of field STATIC FINAL
		for (Field field : fields) {
			int getModifier = field.getModifiers();
			if (Modifier.isStatic(getModifier) && Modifier.isFinal(getModifier)) {
				getNameFieldMethod checkAnno = field.getAnnotation(getNameFieldMethod.class);
				if (checkAnno != null) {
					try {
						System.out.println("Value of Field Static Final " + field.getName() + " : " + field.get(obj));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
