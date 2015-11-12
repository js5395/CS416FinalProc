/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.validators;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.sql.DataSource;

/**
 *
 * @author steve
 */
@FacesValidator(value = "bookValidator")
public class BookValidator implements Validator {

    @Resource(name = "jdbc/HW3DB")
    DataSource datasource;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int isbn = (int) value;
        HtmlInputText htmlInputText = (HtmlInputText) component;
        try (Connection connect = datasource.getConnection()) {
            String sql = "select isbn from books";
            PreparedStatement getISBN = connect.prepareStatement(sql);
            ResultSet isbnList = getISBN.executeQuery();
            while (isbnList.next()) {
                if (isbn == isbnList.getInt("ISBN")) {
                    FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + "ISBN already exists");
                    throw new ValidatorException(facesMessage);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(BookValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
