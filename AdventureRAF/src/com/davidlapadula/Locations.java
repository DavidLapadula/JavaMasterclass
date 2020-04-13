package com.davidlapadula;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("locations_rand.dat", "rwd")) {
            raf.writeInt(locations.size());
            // Each index record has 3 ints: location ID, offset, and length of record
            int indexSize = locations.size() * 3 * Integer.BYTES;
            // Start location after index and allocate space on file
            int locationStart = (int) (indexSize + raf.getFilePointer() + Integer.BYTES);
            raf.writeInt(locationStart);

            long indexStart = raf.getFilePointer();
            int startPointer = locationStart;
            raf.seek(startPointer);

            // Write values to RAF
            for (Location location: locations.values()) {
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction: location.getExits().keySet()){
                    if (!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                raf.writeUTF(builder.toString());

                // Create index record and store it, and change start pointer to wherever it is
                IndexRecord record = new IndexRecord(startPointer, (int) raf.getFilePointer() - startPointer);
                index.put(location.getLocationID(), record);
                startPointer = (int) raf.getFilePointer();
            }

            // Go to where index starts, and for each index record, write to file
            raf.seek(indexStart);
            for (Integer locationID: index.keySet()) {
                raf.writeInt(locationID);
                raf.writeInt(index.get(locationID).getStartByte());
                raf.writeInt(index.get(locationID).getLength());
            }
        }

    }

//    Reading data from RAF
    static {
      try {
        ra = new RandomAccessFile("locations_rand.dat", "rwd");
        int numLocations = ra.readInt();
        long locationStartPoint = ra.readInt();

        while(ra.getFilePointer() < locationStartPoint) {
            int locationId = ra.readInt();
            int locationStart = ra.readInt();
            int locationLength = ra.readInt();

            IndexRecord record = new IndexRecord(locationStart, locationLength);
            index.put(locationId, record);
        }
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    public void close() throws IOException {
        ra.close();
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        // Use index start byte to put pointer at the start of the location record in the file
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);
        if (locationId != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return locations.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return locations.containsValue(o);
    }

    @Override
    public Location get(Object o) {
        return locations.get(o);
    }

    @Override
    public Location put(Integer key, Location location) {
        return locations.put(key, location);
    }

    @Override
    public Location remove(Object o) {
        return locations.remove(o);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> map) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
