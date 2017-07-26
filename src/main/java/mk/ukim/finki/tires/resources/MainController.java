package mk.ukim.finki.tires.resources;

import com.twilio.type.PhoneNumber;
import mk.ukim.finki.tires.config.SmsNotification;
import mk.ukim.finki.tires.enums.CheckoutStatus;
import mk.ukim.finki.tires.models.jpa.*;
import mk.ukim.finki.tires.service.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 08.7.2017.
 */

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class MainController implements ApplicationContextAware {

    private TireService service;

    private SeasonTypeService seasonTypeService;

    private BrandService brandService;

    private WidthService widthService;

    private HeightService heightService;

    private InchesService inchesService;

    private TireImageService tireImageService;

    private final CartItemService cartItemService;

    private final CartService cartService;

    private final CheckoutService checkoutService;

    @Autowired
    public MainController(TireService service, SeasonTypeService seasonTypeService, BrandService brandService,
                          WidthService widthService, HeightService heightService, InchesService inchesService,
                          TireImageService tireImageService, CartItemService cartItemService, CartService cartService, CheckoutService checkoutService) {
        this.brandService = brandService;
        this.service = service;
        this.seasonTypeService = seasonTypeService;
        this.widthService = widthService;
        this.heightService = heightService;
        this.inchesService = inchesService;
        this.tireImageService = tireImageService;
        this.cartItemService = cartItemService;
        this.cartService = cartService;
        this.checkoutService = checkoutService;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TireService bean = applicationContext.getBean(TireService.class);
        System.out.println(bean);
    }

    @RequestMapping(value = "/tires", method = RequestMethod.GET)
    public List<Tire> getAllTires() {
        return service.findAll();
    }

    @RequestMapping(value = "/seasonTypes", method = RequestMethod.GET)
    public List<SeasonType> getAllSeasonTypes() {
        return seasonTypeService.findAll();
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public List<Brand> getAllBrands() {
        return brandService.findAll();
    }

    @RequestMapping(value = "/widths", method = RequestMethod.GET)
    public List<Width> getAllWidths() {
        return widthService.findAll();
    }

    @RequestMapping(value = "/heights", method = RequestMethod.GET)
    public List<Height> getAllHeights() {
        return heightService.findAll();
    }

    @RequestMapping(value = "/inches", method = RequestMethod.GET)
    public List<Inches> getAllInches() {
        return inchesService.findAll();
    }

    @RequestMapping(value = "/tireImage/tire/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void getTireImageByTireId(@PathVariable Long id, HttpServletResponse response) throws IOException, SQLException {
        TireImage tireImage = tireImageService.getByTireId(id);
        InputStream in = null;
        OutputStream out = null;

        File file = new File(tireImage.getImageUrl());
        String contentDisposition = String.format("inline;filename=\"%s\"",
                file.getName() + "?tireId=" + id);
        byte fileContent[] = new byte[(int) file.length()];

        try {

            in = new FileInputStream(file);
            out = response.getOutputStream();


            in.read(fileContent);
            ByteArrayInputStream bin = new ByteArrayInputStream(fileContent);

            response.setHeader("Content-Disposition", contentDisposition);
            response.setContentType(Files.probeContentType(file.toPath()));
            response.setContentLength((int) file.length());

            IOUtils.copy(bin, out);

        } catch (IOException e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        }

    }

    @RequestMapping(value = "/cartItem/{quantity}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Tire tire, @PathVariable int quantity) {
        int flag =0;
        Cart shoppingCart = cartService.getShoppingCartInSession();
        List<CartItem> items = cartItemService.findByCartId(shoppingCart.id);
        if(items.size()>0) {
            for (CartItem i : items) {
                if (i.getTire().id == tire.id) {
                    shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + tire.getPrice() * quantity);
                    i.setQuantity(i.getQuantity() + quantity);
                    cartService.update(shoppingCart.id, shoppingCart);
                    cartItemService.update(i.id, i);
                    flag =1;
                }
            }
        }
        if(flag ==0) {
            CartItem cartItem = new CartItem();
            cartItem.setTire(tire);
            shoppingCart.setTotalPrice(shoppingCart.getTotalPrice() + tire.getPrice() * quantity);
            cartService.update(shoppingCart.id, shoppingCart);
            cartItem.setCart(shoppingCart);
            cartItem.setQuantity(quantity);
            cartItemService.insert(cartItem);
        }


    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public Cart getCart() {
        return cartService.getShoppingCartInSession();
    }

    @RequestMapping(value = "/cartItem/{id}", method = RequestMethod.GET)
    public List<CartItem> getCartItems(@PathVariable Long id) {
        return cartItemService.findByCartId(id);
    }

    @RequestMapping(value = "/deleteCartItem/{id}", method = RequestMethod.DELETE)
    public void deleteCartItem(@PathVariable Long id) {
        CartItem cartItem = cartItemService.findById(id);
        Cart cart = cartService.getShoppingCartInSession();
        cart.setTotalPrice(cart.getTotalPrice() - (cartItem.getQuantity() * cartItem.getTire().getPrice()));
        cartService.update(cart.id, cart);
        cartItemService.deleteById(id);
    }

    @RequestMapping(value = "/cartItemPlus", method = RequestMethod.PUT)
    public void updateCartItemPlus(@RequestBody CartItem cartItem){
        Cart cart = cartService.getShoppingCartInSession();
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getTire().getPrice());
        cartItem.setQuantity(cartItem.getQuantity()+1);
        cartItemService.update(cartItem.id,cartItem);
    }
    @RequestMapping(value = "/cartItemMinus", method = RequestMethod.PUT)
    public void updateCartItemMinus(@RequestBody CartItem cartItem){
        Cart cart = cartService.getShoppingCartInSession();
        cart.setTotalPrice(cart.getTotalPrice() - cartItem.getTire().getPrice());
        cartItem.setQuantity(cartItem.getQuantity()-1);
        cartItemService.update(cartItem.id,cartItem);
    }

    @RequestMapping(value = "/checkout/{cartId}", method = RequestMethod.POST)
    public void checkout(@PathVariable Long cartId, @RequestBody User user){
        Cart cart = cartService.getShoppingCartInSession();
        Checkout checkout = new Checkout();
        checkout.setCart(cart);
        checkout.setContactInfo(user.contactInfo);
        checkout.setDeliveryInfo(user.deliveryInfo);
        checkout.status = CheckoutStatus.ISSUED;
        checkoutService.insert(checkout);
        cartService.updateCartInSession();
        //SmsNotification smsNotification = new SmsNotification();
        //smsNotification.SendNotification(new PhoneNumber(checkout.getContactInfo().getPhone()));
    }

}
