import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {
    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 p1 = new Partie1();
    System.out.println("longs et chers : " + p1.longAndExpensiveTrips(trips));
    System.out.println("mauvais : " + p1.badTrips(trips));
    System.out.println("recents : " + p1.recentTrips(trips));

    Partie2 p2 = new Partie2();
    System.out.println("nb par ville : " + p2.countByCity(trips));
    System.out.println("revenu par chauffeur : " + p2.revenueByDriver(trips));
    System.out.println("duree moy par ville : " + p2.avgDurationByCity(trips));

    Partie3 p3 = new Partie3();
    System.out.println("top 10 chers : " + p3.top10ExpensiveTrips(trips));
    System.out.println("meilleur trajet : " + p3.bestTrip(trips));

    List<Trip> grandeList = TripFactory.generateTrips(1000000);
    Partie4 p4 = new Partie4();
    System.out.println("revenu sequentiel : " + p4.totalRevenueSequential(grandeList));
    System.out.println("revenu parallele : " + p4.totalRevenueParallel(grandeList));
    System.out.println("nb par ville parallel : " + p4.countByCityParallel(trips));
    System.out.println("trajets premium : " + p4.premiumTripsParallel(trips));
}
