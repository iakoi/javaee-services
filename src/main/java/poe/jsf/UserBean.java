package poe.jsf;

import javax.faces.bean.ManagedBean;

/**
 * correspond aux paramètres saisi dans la vue signup.xhtml.
 */
@ManagedBean
public class UserBean {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
