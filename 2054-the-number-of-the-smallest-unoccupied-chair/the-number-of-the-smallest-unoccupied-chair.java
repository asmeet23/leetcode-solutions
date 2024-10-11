import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // Create events as (time, type, friendIndex) where type 1 means arrival, -1 means leaving
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], 1, i}); // Arrival event
            events.add(new int[]{times[i][1], -1, i}); // Leaving event
        }
        
        // Sort events by time, if times are the same, process leaving (-1) first
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // PriorityQueue to keep track of available chairs
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeChairs.add(i); // Initialize with chair numbers 0, 1, 2, ..., n-1
        }

        // Map to track which chair each friend is sitting on
        int[] assignedChair = new int[n];

        for (int[] event : events) {
            int time = event[0];
            int type = event[1];
            int friend = event[2];
            
            if (type == 1) { // Arrival event
                // Assign smallest available chair to arriving friend
                int chair = freeChairs.poll();
                assignedChair[friend] = chair;

                // If this is the target friend, return the chair number
                if (friend == targetFriend) {
                    return chair;
                }
            } else { // Leaving event
                // When a friend leaves, add their chair back to the available chairs
                freeChairs.add(assignedChair[friend]);
            }
        }

        return -1; // This shouldn't be reached
    }
}
