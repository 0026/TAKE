/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author Tomasz
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestFacadeLocal requestFacade;
    /**
     * Creates a new instance of RequestsList
     */
    
    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }
    public RequestsList() {
    }
    
}
