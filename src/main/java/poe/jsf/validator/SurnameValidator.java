package poe.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class SurnameValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object surname) throws ValidatorException {
        System.out.println("validation de Surname: " + surname);

        UIInput surnameInput = (UIInput) uiComponent.getAttributes().get("attributeName");
        String name = (String) surnameInput.getValue();
        System.out.println("name: " + name);


        String nameValue = (String) surname;
        if (nameValue.length() < 2) {
            System.out.println("le nom est invalide");
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name Validation failed", "Invalid Name.");
            throw new ValidatorException(fmsg);
        }
    }
}
