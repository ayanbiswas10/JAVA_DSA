import java.util.Scanner;

public class LearningWithClock2 {

    // Helper method to calculate the movement cost
    public static int calculateCost(double degrees, int costClockwise, int costAnticlockwise, int firstCost, int secondCost) {
        double absDegrees = Math.abs(degrees);
        if (absDegrees <= 90) {
            return (int) (absDegrees * firstCost);
        } else {
            return (int) (90 * firstCost + (absDegrees - 90) * secondCost);
        }
    }

    public static int calculateMinCost(double targetAngle, double currentHourAngle, double currentMinuteAngle,
                                       int costClockwiseHour, int costAnticlockwiseHour,
                                       int costClockwiseMinute, int costAnticlockwiseMinute,
                                       int P, int Q, int X, int Y) {
        // Determine the movement of the hands required to achieve the target angle
        double hourMoveClockwise = 0, hourMoveAnticlockwise = 0;
        double minuteMoveClockwise = 0, minuteMoveAnticlockwise = 0;

        // Calculate the current angle between the hour and minute hands
        double currentAngle = Math.abs(currentHourAngle - currentMinuteAngle);
        if (currentAngle > 180) currentAngle = 360 - currentAngle;

        // Find the minimum movement to achieve the target angle
        double clockwiseMovement = (targetAngle - currentAngle + 360) % 360;
        double anticlockwiseMovement = (currentAngle - targetAngle + 360) % 360;

        // Cost for clockwise movement
        int costClockwise = calculateCost(clockwiseMovement, costClockwiseHour, costAnticlockwiseHour, P, Q) +
                calculateCost(clockwiseMovement, costClockwiseMinute, costAnticlockwiseMinute, X, Y);

        // Cost for anticlockwise movement
        int costAnticlockwise = calculateCost(anticlockwiseMovement, costClockwiseHour, costAnticlockwiseHour, P, Q) +
                calculateCost(anticlockwiseMovement, costClockwiseMinute, costAnticlockwiseMinute, X, Y);

        // Return the minimum cost
        return Math.min(costClockwise, costAnticlockwise);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the initial time
        String[] initialTime = scanner.nextLine().split(":");
        int hour = Integer.parseInt(initialTime[0]) % 12;
        int minute = Integer.parseInt(initialTime[1]);

        // Input number of queries
        int queries = scanner.nextInt();

        // Input the cost factors
        int A = scanner.nextInt(); // Clockwise movement cost
        int B = scanner.nextInt(); // Anticlockwise movement cost
        int P = scanner.nextInt(); // Hour hand first 90 degrees
        int Q = scanner.nextInt(); // Hour hand beyond 90 degrees
        int X = scanner.nextInt(); // Minute hand first 90 degrees
        int Y = scanner.nextInt(); // Minute hand beyond 90 degrees

        // Calculate initial angles
        double currentHourAngle = (hour * 30) + (minute * 0.5);
        double currentMinuteAngle = minute * 6;

        // Total cost
        int totalCost = 0;

        // Process each query
        for (int i = 0; i < queries; i++) {
            int targetAngle = scanner.nextInt();

            // Calculate the minimum cost for this query
            int cost = calculateMinCost(targetAngle, currentHourAngle, currentMinuteAngle, A, B, A, B, P, Q, X, Y);

            // Update the total cost
            totalCost += cost;

            // Update the clock angles to reflect the final position after achieving the target angle
            currentHourAngle = (currentHourAngle + 360) % 360;
            currentMinuteAngle = (currentMinuteAngle + 360) % 360;
        }

        // Output the total cost
        System.out.println(totalCost);
    }
}
