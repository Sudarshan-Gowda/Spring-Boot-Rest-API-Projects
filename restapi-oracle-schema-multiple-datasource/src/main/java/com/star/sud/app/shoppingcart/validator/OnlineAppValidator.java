package com.star.sud.app.shoppingcart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.star.sud.app.common.ErrorCode;
import com.star.sud.app.shoppingcart.dto.ShoppingCartDto;
import com.star.sud.app.shoppingcart.entity.ShoppingCart;
import com.star.sud.app.util.StringUtil;

@Component
public class OnlineAppValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShoppingCart.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ShoppingCartDto request = (ShoppingCartDto) target;

		if (StringUtil.isEmptyObject(request)) {
			errors.reject(ErrorCode.EC001.getCode(), "Unable to process due to empty request");
			return;
		}

		ValidationUtils.rejectIfEmpty(errors, "userId", ErrorCode.EC001.getCode(), "userId identifier is required");

	}

}