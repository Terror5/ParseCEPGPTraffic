package data;

import sun.util.calendar.BaseCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TrafficObject {

    private String toPlayer; // "Raid", -- [1]
    private String fromPlayer; // "Krusell", -- [2]
    private String comment; // "Add Raid EP +5 - Prophet Skeram", -- [3]
    private String epBefore; // "", -- [4]
    private String epAfter; // "", -- [5]
    private String gpBefore; // "", -- [6]
    private String gpAfter; // "", -- [7]
    private String item; // "", -- [8]
    private String timestamp1; // 1597956809, -- [9]
    private String timestamp2; // 1597983994.852, -- [10]
    private String playerCode; // "Player-4440-010C88BF", -- [11]

    private Calendar calendar = Calendar.getInstance();

    public String getToPlayer() {
        return toPlayer;
    }

    public void setToPlayer(String toPlayer) {
        this.toPlayer = cutBetweenQuote(toPlayer);
    }

    public String getFromPlayer() {
        return fromPlayer;
    }

    public void setFromPlayer(String fromPlayer) {
        this.fromPlayer = cutBetweenQuote(fromPlayer);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = cutBetweenQuote(comment);
    }

    public String getEpBefore() {
        return epBefore;
    }

    public void setEpBefore(String epBefore) {
        this.epBefore = cutBetweenQuote(epBefore);
    }

    public String getEpAfter() {
        return epAfter;
    }

    public void setEpAfter(String epAfter) {
        this.epAfter = cutBetweenQuote(epAfter);
    }

    public String getGpBefore() {
        return gpBefore;
    }

    public void setGpBefore(String gpBefore) {
        this.gpBefore = cutBetweenQuote(gpBefore);
    }

    public String getGpAfter() {
        return gpAfter;
    }

    public void setGpAfter(String gpAfter) {
        this.gpAfter = cutBetweenQuote(gpAfter);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = cutBetweenQuote(item);
    }

    public String getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(String timestamp1) {
        this.timestamp1 = convertToDate(trimAndCutbeforeComma(timestamp1));
    }

    public String getTimestamp2() {
        return timestamp2;
    }

    public void setTimestamp2(String timestamp2) {
        this.timestamp2 = convertToDateTime(trimAndCutbeforeComma(timestamp2));
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = cutBetweenQuote(playerCode);
    }

    public String cutBetweenQuote(String input) {
        if(input.lastIndexOf("\"") == -1)
            return trimAndCutbeforeComma(input);
        return input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));
    }

    public String trimAndCutbeforeComma(String input) {
        String result = input.trim();
        return result.substring(0, result.lastIndexOf(","));
    }

    public String convertToDate(String timestamp) {
        long result = Long.parseLong(timestamp) * 1000L;
        calendar.setTimeInMillis(result + 900000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

    public String convertToDateTime(String timestamp) {
        long result = Long.parseLong(timestamp.replace(".", ""));
        calendar.setTimeInMillis(result);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }
}
