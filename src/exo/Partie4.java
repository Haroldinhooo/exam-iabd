package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie4 {

    Function<Trip, String> parVille = trip -> trip.city();

    ToDoubleFunction<Trip> getPrix = trip -> trip.price();

    Predicate<Trip> estPremium = trip ->
            trip.price() > 30 && trip.rating() > 4;

    public double totalRevenueSequential(List<Trip> trips) {
        return trips.stream()
                .mapToDouble(getPrix)
                .sum();
    }

    public double totalRevenueParallel(List<Trip> trips) {
        return trips.parallelStream()
                .mapToDouble(getPrix)
                .sum();
    }

    public Map<String, Long> countByCityParallel(List<Trip> trips) {
        return trips.parallelStream()
                .collect(Collectors.groupingByConcurrent(parVille, Collectors.counting()));
    }

    public List<Trip> premiumTripsParallel(List<Trip> trips) {
        return trips.parallelStream()
                .filter(estPremium)
                .toList();
    }
}
