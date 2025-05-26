package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.DocumentDto;
import abdumalik.dev.indigo.model.Address;
import abdumalik.dev.indigo.model.Document;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.AddressRepo;
import abdumalik.dev.indigo.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    DocumentRepo repo;

    @Autowired
    AddressRepo addressRepo;

    public List<Document> getAll() {
        return repo.findAll();
    }

    public Document getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(DocumentDto dto) {
        boolean b = repo.existsBySeriaNumber(dto.getSeriaNumber());
        if (b) {
            return new Result("This seria number is already exists", false);
        }

        Document document = new Document();
        document.setDocumentType(dto.getDocumentType());
        document.setSeriaNumber(dto.getSeriaNumber());
        document.setNumber(dto.getNumber());
        document.setCode(dto.getCode());
        document.setDate(dto.getDate());
        document.setIssuedBy(dto.isIssuedBy());

        Optional<Address> byId = addressRepo.findById(dto.getAddressId());
        Address address = byId.get();
        document.setAddress(address);

        repo.save(document);
        return new Result("Document successfully created", true);
    }

    public Result update(UUID id, DocumentDto dto) {
        Optional<Document> document = repo.findById(id);
        if (document.isPresent()) {
            Document doc = document.get();
            doc.setDocumentType(dto.getDocumentType());
            doc.setSeriaNumber(dto.getSeriaNumber());
            doc.setNumber(dto.getNumber());
            doc.setCode(dto.getCode());
            doc.setDate(dto.getDate());
            doc.setIssuedBy(dto.isIssuedBy());

            Optional<Address> byId = addressRepo.findById(dto.getAddressId());
            Address address = byId.get();
            doc.setAddress(address);

            repo.save(doc);
            return new Result("Document successfully updated", true);
        }
        return new Result("Document not found", false);
    }

    public Result delete(UUID id) {
        Optional<Document> document = repo.findById(id);
        if (document.isPresent()) {
            repo.delete(document.get());
            return new Result("Document successfully deleted", true);
        }
        return new Result("Document not found", false);
    }

}