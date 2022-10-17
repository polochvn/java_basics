import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> flight = airport.getTerminals().stream()
                .map(s -> s.getFlights())
                .flatMap(s -> s.stream())
                .filter(s -> s.getDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().minusHours(2).isBefore(LocalDateTime.now()))
                .filter(s -> s.getDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime().isAfter(LocalDateTime.now()))
                .filter(s -> s.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());

        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return flight;
    }

}