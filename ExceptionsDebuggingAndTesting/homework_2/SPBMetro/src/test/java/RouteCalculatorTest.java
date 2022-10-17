import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
    List<Station> route = new ArrayList<>();

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(3,"Третья");


    Station station1 = new Station("Александровская", line1);
    Station station2 = new Station("Петровская", line1);
    Station station3 = new Station("Николаевская", line2);
    Station station4 = new Station("Павловская", line2);
    Station station5 = new Station("Свердловская", line3);
    Station station6 = new Station("Ленинская", line3);

    List<Station> connect1 = new ArrayList<>();
    List<Station> connect2 = new ArrayList<>();

    public void setUp() throws Exception {

        line1.addStation(station1);
        line1.addStation(station2);
        line2.addStation(station3);
        line2.addStation(station4);
        line3.addStation(station5);
        line3.addStation(station6);

        connect1.add(station2);
        connect1.add(station3);

        connect2.add(station4);
        connect2.add(station5);

        stationIndex.addConnection(connect1);
        stationIndex.addConnection(connect2);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);
    }

    public void tearDown() throws Exception {
    }

    public void testGetShortestRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(station1, station2);
        List<Station> expected = List.of(station1, station2);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(station1, station4);
        List<Station> expected = List.of(station1, station2, station3, station4);
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(station1, station6);
        List<Station> expected = List.of(station1, station2, station3, station4, station5, station6);
        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }
}