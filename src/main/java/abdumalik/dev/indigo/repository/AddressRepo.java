package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {
}