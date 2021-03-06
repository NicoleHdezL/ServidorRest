/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Nicol
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(API.ClienteResource.class);
        resources.add(API.EliminaRutinaResource.class);
        resources.add(API.EliminarClienteResource.class);
        resources.add(API.EmpleadoResource.class);
        resources.add(API.InfoResource.class);
        resources.add(API.InicioResource.class);
        resources.add(API.LoginResource.class);
        resources.add(API.ModClienteResource.class);
        resources.add(API.NormalUserResource.class);
        resources.add(API.RutinaResource.class);
    }
    
}
