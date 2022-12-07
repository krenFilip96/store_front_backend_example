package si.kren.resources;

import si.kren.models.Store;
import si.kren.repository.StoreRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;

@Path("/api")
public class StoreResource {
    private static final Logger LOGGER = Logger.getLogger(StoreResource.class);
    @Inject
    StoreRepository storeRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreNames() {
        LOGGER.info("getStoreNames - ENTER");
        List<Store> stores = storeRepository.listAll();
        if (stores == null || stores.isEmpty()) {
            LOGGER.error("getStoresName - something went wrong. Try again later. ");
            return Response.status(404, "No data found").build();
        }
        LOGGER.info("getStoreNames - Returning data mapped data, for dropdown.");
        return Response.ok(stores).build();
    }

}