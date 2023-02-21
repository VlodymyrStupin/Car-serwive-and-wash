package com.stupin.carServiceAndWash.controller;

import com.stupin.carServiceAndWash.dto.Booking;
import com.stupin.carServiceAndWash.dto.Email;
import com.stupin.carServiceAndWash.dto.User;
import com.stupin.carServiceAndWash.service.BookingService;
import com.stupin.carServiceAndWash.service.EmailSenderService;
import com.stupin.carServiceAndWash.service.ProductService;
import com.stupin.carServiceAndWash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BookingUIController {
    private final EmailSenderService emailSenderService;
    private final ProductService productService;
    private final UserService userService;
    private final BookingService bookingService;

    @Autowired
    public BookingUIController(EmailSenderService emailSenderService, ProductService productService, UserService userService, BookingService bookingService) {
        this.emailSenderService = emailSenderService;
        this.productService = productService;
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("ui/users/{id}/booking")
    public String viewUserAppointmentPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("products", productService.getAll());
        model.addAttribute("booking", new Booking());
        return "booking/user_booking_page";
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("ui/users/{id}/booking")
    public RedirectView createUserAppointment(@ModelAttribute Booking booking,
                                              @RequestParam String email,
                                              @RequestParam String service,
                                              @RequestParam String date,
                                              @RequestParam String description) {
        User user = userService.getByEmail(email);
        booking.setEmail(email);
        booking.setService(service);
        booking.setDate(date);
        booking.setDescription(description);
        booking.setUser(user);
        Email emailObject = new Email();
        emailObject.setTo("rav.elbud@gmail.com");
        emailObject.setSubject("Confirmation reservation date for service " + "service");
        emailObject.setText("Dear user your car have been successfully booked for "
                + "service" + ". Appointment date is " + date);

//        emailSenderService.sendConfirmationBookingMail(emailObject);
        bookingService.save(booking);
        return new RedirectView("");
    }
}
