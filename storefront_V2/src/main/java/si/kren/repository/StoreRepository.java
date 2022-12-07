package si.kren.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import si.kren.models.Store;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class StoreRepository implements PanacheRepository<Store> {
}
