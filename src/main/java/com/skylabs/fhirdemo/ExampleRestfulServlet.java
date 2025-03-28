package com.skylabs.fhirdemo;

import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import com.skylabs.fhirdemo.provider.PatientProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * In this example, we are using Servlet 3.0 annotations to define
 * the URL pattern for this servlet, but we could also
 * define this in a web.xml file.
 */
@WebServlet(
      urlPatterns = {"/fhir/*"},
      displayName = "FHIR Server")
public class ExampleRestfulServlet extends RestfulServer {

   private static final long serialVersionUID = 1L;

   /**
    * The initialize method is automatically called when the servlet is starting up, so it can
    * be used to configure the servlet to define resource providers, or set up
    * configuration, interceptors, etc.
    */
   @Override
   protected void initialize() throws ServletException {
      /*
       * The servlet defines any number of resource providers, and
       * configures itself to use them by calling
       * setResourceProviders()
       */
      List<IResourceProvider> resourceProviders = new ArrayList<IResourceProvider>();
      resourceProviders.add(new PatientProvider());
      setResourceProviders(resourceProviders);
   }
}
