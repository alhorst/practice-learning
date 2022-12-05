package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    // these are going to be expected --
    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    private Park testPark;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
        testPark = new Park
                (0, "Test Park", LocalDate.now(), 900, true);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park actualPark = sut.getPark(1);
        assertParksMatch(PARK_1, actualPark);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park actualPark = sut.getPark(99);
        Assert.assertNull(actualPark);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> actualParks = sut.getParksByState("AA");
        Assert.assertEquals(2, actualParks.size());
        assertParksMatch(PARK_1, actualParks.get(0));
        assertParksMatch(PARK_3, actualParks.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> actualParks = sut.getParksByState("MM");
        Assert.assertEquals(0, actualParks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park actualPark = sut.createPark(testPark);

        Integer newId = actualPark.getParkId(); // getting the id back from DB
        Assert.assertTrue( newId > 0);  // assert that we got something back

        testPark.setParkId(newId); // set the id to what came back from db
        assertParksMatch(testPark, actualPark);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park actualPark = sut.createPark(testPark);

        Integer newId = actualPark.getParkId();
        Park retrievedPark = sut.getPark(newId);

        assertParksMatch(actualPark, retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        Assert.fail();
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.addParkToState(1, "BB");

        // how to we verify that park 1 was added to state BB?
        // by calling the getParksByState method and verifying it is in there
        List<Park> parkList = sut.getParksByState("BB");

        Assert.assertEquals(2, parkList.size());
        assertParksMatch(PARK_1, parkList.get(0));
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        sut.removeParkFromState(1, "AA");

        List<Park> parkList = sut.getParksByState("AA");
        Assert.assertEquals(1, parkList.size());
        assertParksMatch(PARK_3, parkList.get(0));
    }

    // helper method!
    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
