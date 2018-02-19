package clases;

import entidades.EstatusFacturaPagos;
import clases.util.JsfUtil;
import clases.util.JsfUtil.PersistAction;
import sesiones.EstatusFacturaPagosFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("estatusFacturaPagosController")
@SessionScoped
public class EstatusFacturaPagosController implements Serializable {

    @EJB
    private sesiones.EstatusFacturaPagosFacade ejbFacade;
    private List<EstatusFacturaPagos> items = null;
    private EstatusFacturaPagos selected;

    public EstatusFacturaPagosController() {
    }

    public EstatusFacturaPagos getSelected() {
        return selected;
    }

    public void setSelected(EstatusFacturaPagos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EstatusFacturaPagosFacade getFacade() {
        return ejbFacade;
    }

    public EstatusFacturaPagos prepareCreate() {
        selected = new EstatusFacturaPagos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EstatusFacturaPagosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EstatusFacturaPagosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EstatusFacturaPagosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EstatusFacturaPagos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public EstatusFacturaPagos getEstatusFacturaPagos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EstatusFacturaPagos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EstatusFacturaPagos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EstatusFacturaPagos.class)
    public static class EstatusFacturaPagosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstatusFacturaPagosController controller = (EstatusFacturaPagosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estatusFacturaPagosController");
            return controller.getEstatusFacturaPagos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EstatusFacturaPagos) {
                EstatusFacturaPagos o = (EstatusFacturaPagos) object;
                return getStringKey(o.getIdEstatusFacturaPagos());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EstatusFacturaPagos.class.getName()});
                return null;
            }
        }

    }

}
