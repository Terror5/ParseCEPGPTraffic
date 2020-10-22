package test;

import data.TrafficObject;
import org.junit.jupiter.api.BeforeAll;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TrafficObjectTest {

    private static TrafficObject trafficObject;

    @BeforeAll
    static void beforeAll() {
        trafficObject = new TrafficObject();
    }

    @org.junit.jupiter.api.Test
    void setToPlayer() {
        String input = "\"Raid\", -- [1]";
        trafficObject.setToPlayer(input);
        assertEquals("Raid", trafficObject.getToPlayer());
    }

    @org.junit.jupiter.api.Test
    void setFromPlayer() {
        String input = "\"Krusell\", -- [2]";
        trafficObject.setFromPlayer(input);
        assertEquals("Krusell", trafficObject.getFromPlayer());
    }

    @org.junit.jupiter.api.Test
    void setComment() {
        String input = "\"Add Raid EP +5 - Prophet Skeram\", -- [3]";
        trafficObject.setComment(input);
        assertEquals("Add Raid EP +5 - Prophet Skeram", trafficObject.getComment());
    }

    @org.junit.jupiter.api.Test
    void setEpBefore() {
        String input = "\"123\", -- [4]";
        trafficObject.setEpBefore(input);
        assertEquals("123", trafficObject.getEpBefore());
    }

    @org.junit.jupiter.api.Test
    void setEpAfter() {
        String input = "\"13\", -- [5]";
        trafficObject.setEpAfter(input);
        assertEquals("13", trafficObject.getEpAfter());
    }

    @org.junit.jupiter.api.Test
    void setGpBefore() {
        String input = "\"23\", -- [6]";
        trafficObject.setGpBefore(input);
        assertEquals("23", trafficObject.getGpBefore());
    }

    @org.junit.jupiter.api.Test
    void setGpAfter() {
        String input = "\"12\", -- [7]";
        trafficObject.setGpAfter(input);
        assertEquals("12", trafficObject.getGpAfter());
    }

    @org.junit.jupiter.api.Test
    void setItem() {
        String input = "\"3\", -- [8]";
        trafficObject.setItem(input);
        assertEquals("3", trafficObject.getItem());
    }

    @org.junit.jupiter.api.Test
    void setTimestamp1() {
        String input = "1602800629, -- [9]";
        trafficObject.setTimestamp1(input);
        assertEquals("16.10.2020 00:38:49", trafficObject.getTimestamp1());
    }

    @org.junit.jupiter.api.Test
    void setTimestamp2() {
        String input = "1602911244.404, -- [10]";
        trafficObject.setTimestamp2(input);
        assertEquals("17.10.2020 07:07:24", trafficObject.getTimestamp2());
    }

    @org.junit.jupiter.api.Test
    void setPlayerCode() {
        String input = "\"Player-4440-010C88BF\", -- [11]";
        trafficObject.setPlayerCode(input);
        assertEquals("Player-4440-010C88BF", trafficObject.getPlayerCode());
    }
}