package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Invoice;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
public interface InvoiceService {
    List<Invoice> findAll();
    Invoice findById(Long id);
    void insert(Invoice entity);
    void update(Long id,Invoice entity);
    void deleteById(Long id);
}
