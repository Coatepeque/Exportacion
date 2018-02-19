/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.EstatusFacturaPagos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josue
 */
@Stateless
public class EstatusFacturaPagosFacade extends AbstractFacade<EstatusFacturaPagos> {

    @PersistenceContext(unitName = "ExportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstatusFacturaPagosFacade() {
        super(EstatusFacturaPagos.class);
    }
    
}
