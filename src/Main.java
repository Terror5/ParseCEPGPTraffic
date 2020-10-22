import data.TrafficObject;

import java.io.*;
import java.util.ArrayList;


public class Main
{
    public static void main(String[] args)
    {
        String path = "C:\\Users\\Florian\\Desktop\\Raid\\";

        try (FileReader reader = new FileReader(path + "CEPGP.lua"))

        {
            ArrayList<TrafficObject> data = new ArrayList<>(1000);
            TrafficObject trafficObject = new TrafficObject();

            BufferedReader br = new BufferedReader(reader);
            int lineCount = 0;
            String line = br.readLine();
            boolean inTraffic = false;

            while(line != null) {

                if(inTraffic) {
                    switch (lineCount) {
                        case 1:
                            trafficObject.setToPlayer(line);
                            break;
                        case 2:
                            trafficObject.setFromPlayer(line);
                            break;
                        case 3:
                            trafficObject.setComment(line);
                            break;
                        case 4:
                            trafficObject.setEpBefore(line);
                            break;
                        case 5:
                            trafficObject.setEpAfter(line);
                            break;
                        case 6:
                            trafficObject.setGpBefore(line);
                            break;
                        case 7:
                            trafficObject.setGpAfter(line);
                            break;
                        case 8:
                            trafficObject.setItem(line);
                            break;
                        case 9:
                            trafficObject.setTimestamp1(line);
                            break;
                        case 10:
                            trafficObject.setTimestamp2(line);
                            break;
                        case 11:
                            trafficObject.setPlayerCode(line);
                            break;
                        case 12:
                            lineCount = -1;
                            data.add(trafficObject);
                            trafficObject = new TrafficObject();
                            break;
                    }
                    ++lineCount;
                }

                if(line.contains("[\"Traffic\"] = {")) {
                    inTraffic = true;
                } else if (inTraffic && "},".equals(line.trim())) {
                    break;
                }
                line = br.readLine();

            }
            br.close();

            System.out.println("Count of Traffic Entries: " + data.size());

            FileWriter writer = new FileWriter(path + "CEPGPTraffic.csv");
            String DELIMITER = ",";

            // Header:
            writer.write("toPlayer,");
            writer.write("fromPlayer,");
            writer.write("comment,");
            writer.write("epBefore,");
            writer.write("epAfter,");
            writer.write("gpBefore,");
            writer.write("gpAfter,");
            writer.write("item,");
            writer.write("timestamp1,");
            writer.write("timestamp2,");
            writer.write("playerCode,");
            writer.write("\r\n");

            // Lines:
            for (TrafficObject to: data) {
                writer.write(to.getToPlayer() + DELIMITER);
                writer.write(to.getFromPlayer() + DELIMITER);
                writer.write(to.getComment() + DELIMITER);
                writer.write(to.getEpBefore() + DELIMITER);
                writer.write(to.getEpAfter() + DELIMITER);
                writer.write(to.getGpBefore() + DELIMITER);
                writer.write(to.getGpAfter() + DELIMITER);
                writer.write(to.getItem() + DELIMITER);
                writer.write(to.getTimestamp1() + DELIMITER);
                writer.write(to.getTimestamp2() + DELIMITER);
                writer.write(to.getPlayerCode() + DELIMITER);
                writer.write("\r\n");

            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}