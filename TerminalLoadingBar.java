public class TerminalLoadingBar {

    public static void main(String[] args) throws InterruptedException {

        int totalBlocks = 20;   // length of bar
        int delay = 100;        // animation speed (ms)

        for (int percent = 0; percent <= 100; percent += 5) {

            int filled = (percent * totalBlocks) / 100;

            StringBuilder bar = new StringBuilder();
            bar.append("[");

            for (int i = 0; i < totalBlocks; i++) {
                if (i < filled) {
                    bar.append("█");   // filled pixel
                } else {
                    bar.append("░");   // empty pixel
                }
            }

            bar.append("] ");
            bar.append(String.format("%3d%%", percent));

            // \r returns cursor to line start
            System.out.print("\r" + bar);
            Thread.sleep(delay);
        }

        System.out.println("\nDone!");
    }
}

