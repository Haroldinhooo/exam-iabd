package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    Predicate<Trip> estLongEtCher = trip ->
            trip.distanceKm() > 10 && trip.price() > 20;

    Predicate<Trip> estMauvais = trip ->
            trip.rating() < 3;

    Predicate<Trip> estRecent = trip -> {
        LocalDate aujoudhui = LocalDate.now();
        LocalDate dateTrajet = trip.startTime().toLocalDate();
        return dateTrajet.equals(aujoudhui) || dateTrajet.equals(aujoudhui.minusDays(1));
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(estLongEtCher)
                .toList();
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(estMauvais)
                .toList();
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(estRecent)
                .toList();
    }
}
