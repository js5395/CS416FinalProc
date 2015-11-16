/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.validators;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.sql.DataSource;

/**
 *
 * @author james
 */
@FacesValidator(value = "passwordValidator")
public class PasswordValidator implements Validator {

    @Resource(name = "jdbc/HW3DB")
    DataSource datasource;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String pass = (String)value;
        
        UIInput uiInputConfirmPassword = (UIInput) component.getAttributes().get("confirmPassword");
	String confirmPassword = uiInputConfirmPassword.getSubmittedValue().toString();
          
        if(!pass.equals(confirmPassword))
        {
            FacesMessage facesMessage = new FacesMessage("Passwords do not match.");
            throw new ValidatorException(facesMessage);
        }

    }
}
