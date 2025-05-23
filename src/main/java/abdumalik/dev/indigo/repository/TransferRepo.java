package abdumalik.dev.indigo.repository;

import abdumalik.dev.indigo.model.Group;
import abdumalik.dev.indigo.model.ProfileKids;
import abdumalik.dev.indigo.model.TransferBaby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransferRepo extends JpaRepository<TransferBaby, UUID> {
    Optional<TransferBaby> findByProfileKidsId(ProfileKids profileKids);
    Optional<TransferBaby> findByGroup(Group group);
}