package tn.esprit.foyer.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.Entities.Reservation;
import tn.esprit.foyer.Service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final IReservationService ireservationService;

    public ReservationController(IReservationService ireservationService) {
        this.ireservationService = ireservationService;
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return ireservationService.addReservation(r);
    }

    @GetMapping("/retrieveAllReservations")
    public List<Reservation> retrieveAllReservations() {
        return ireservationService.retrieveAllReservations();
    }

    @GetMapping("/retrieveReservation/{id}")
    public Reservation retrieveReservation(@PathVariable("id") Long idReservation) {
        return ireservationService.retrieveReservation(idReservation);
    }

    @PutMapping("/modifyReservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return ireservationService.modifyReservation(reservation);
    }

    @DeleteMapping("/removeReservation/{id}")
    public void removeReservation(@PathVariable("id") Long idReservation) {
        ireservationService.removeReservation(idReservation);
    }
}
