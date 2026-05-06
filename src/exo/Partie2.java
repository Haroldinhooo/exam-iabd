package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    Function<Trip, String> parVille = trip -> trip.city();

    Function<Trip, String> parChauffeur = trip -> trip.driverId();

    ToDoubleFunction<Trip> getPrix = trip -> trip.price();

    ToDoubleFunction<Trip> getDuree = trip -> trip.durationMin();

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(parVille, Collectors.counting()));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(parChauffeur, Collectors.summingDouble(getPrix)));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(parVille, Collectors.averagingDouble(getDuree)));
    }
}
