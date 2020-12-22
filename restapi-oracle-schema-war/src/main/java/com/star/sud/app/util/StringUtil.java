/**
 * 
 */
package com.star.sud.app.util;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author Sudarshan
 *
 */
public class StringUtil {

	public static Boolean isEmptyString(String string) {
		return string == null || string.isEmpty() || ObjectUtils.isEmpty(string);
	}

	public static Boolean isNotEmptyString(String string) {
		return !isEmptyString(string);
	}

	public static Boolean isEmptyObject(Object obj) {
		return null == obj || ObjectUtils.isEmpty(obj);
	}

	public static Boolean isNotEmptyObject(Object obj) {
		return !isEmptyObject(obj);
	}

	public static Boolean isNotNullOrEmptyDecimal(BigDecimal input) {
		return input != null && input.compareTo(BigDecimal.ZERO) != 0;
	}

	public static Boolean isNullOrEmptyDecimal(BigDecimal input) {
		return !isNotNullOrEmptyDecimal(input);
	}

	public static Boolean isEmptyBoolean(Boolean input) {
		return input == null;
	}

	public static Boolean isNotEmptyBoolean(Boolean input) {
		return !isEmptyBoolean(input);
	}

	public static Boolean isEmptyList(Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}

	public static Boolean isNotEmptyList(Collection<?> collection) {
		return !isEmptyList(collection);
	}

	public static Boolean isEmptyLong(Long value) {
		return value == null;
	}

	public static Boolean isNotEmptyLong(Long value) {
		return !isEmptyLong(value);
	}

}