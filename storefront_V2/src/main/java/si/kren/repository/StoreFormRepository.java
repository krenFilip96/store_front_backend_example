package si.kren.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import si.kren.models.StoreForm;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StoreFormRepository implements PanacheRepository<StoreForm> {
}
