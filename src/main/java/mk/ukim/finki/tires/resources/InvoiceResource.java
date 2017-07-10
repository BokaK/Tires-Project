package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Invoice;
import mk.ukim.finki.tires.service.InvoiceService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */

@RestController
@RequestMapping(value = "/admin/invoice", produces = "application/json")
public class InvoiceResource implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InvoiceService bean = applicationContext.getBean(InvoiceService.class);
        System.out.println(bean);
    }
    private InvoiceService invoiceService;

    @Autowired
    public InvoiceResource(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Invoice invoice) {
        invoiceService.insert(invoice);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Invoice invoice) {
        invoiceService.update(id, invoice);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Invoice> getAll() {
        return invoiceService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getById(@PathVariable Long id) {
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        invoiceService.deleteById(id);
    }

}