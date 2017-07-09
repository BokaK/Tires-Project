package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Invoice;
import mk.ukim.finki.tires.persistence.InvoiceRepository;
import mk.ukim.finki.tires.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService{
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findOne(id);
    }

    @Override
    public void insert(Invoice entity) {
        invoiceRepository.save(entity);
    }

    @Override
    public void update(Long id, Invoice entity) {
        invoiceRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        invoiceRepository.delete(id);
    }
}
