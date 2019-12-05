import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class Day3 {

	static HashSet<String> hs;
	static HashMap<String, Long> hm;

	public static void main(String[] args) throws IOException {
		String s = readLine(), s2 = readLine();
		hs = new HashSet<String>();
		hm = new HashMap<String, Long>();
		solve(s, true);
		println(solve(s2, false));
		solve2(s, true);
		println(solve2(s2, false));
		exit();
	}

	public static long solve(String s, boolean uhh) {
		if (uhh) {
			String[] arr = s.split(",");
			int curX = 7000, curY = 7000;
			long mindist = 0;
			for (int i = 0; i < arr.length; i++) {
				char cur = arr[i].charAt(0);
				int x = Integer.parseInt(arr[i].substring(1));
				if (cur == 'R') {
					for (int j = 0; j < x; j++) {
						curX++;
						hs.add(curX + " " + curY);
					}
				} else if (cur == 'L') {
					for (int j = 0; j < x; j++) {
						curX--;
						hs.add(curX + " " + curY);
					}
				} else if (cur == 'D') {
					for (int j = 0; j < x; j++) {
						curY--;
						hs.add(curX + " " + curY);
					}
				} else if (cur == 'U') {
					for (int j = 0; j < x; j++) {
						curY++;
						hs.add(curX + " " + curY);
					}
				}
				// System.out.println(mindist);
				// System.out.println(curX + " " + curY);
			}
			return mindist;
		} else {
			String[] arr = s.split(",");
			int curX = 7000, curY = 7000;
			long mindist = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				char cur = arr[i].charAt(0);
				int x = Integer.parseInt(arr[i].substring(1));
				if (cur == 'R') {
					for (int j = 0; j < x; j++) {
						curX++;
						if (hs.contains(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							mindist = Math.min(Math.abs(7000 - curY) + Math.abs(7000 - curX), mindist);
						}
					}
				} else if (cur == 'L') {
					for (int j = 0; j < x; j++) {
						curX--;
						if (hs.contains(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							mindist = Math.min(Math.abs(7000 - curY) + Math.abs(7000 - curX), mindist);
						}
					}
				} else if (cur == 'D') {
					for (int j = 0; j < x; j++) {
						curY--;
						if (hs.contains(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							mindist = Math.min(Math.abs(7000 - curY) + Math.abs(7000 - curX), mindist);
						}
					}
				} else if (cur == 'U') {
					for (int j = 0; j < x; j++) {
						curY++;
						if (hs.contains(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							mindist = Math.min(Math.abs(7000 - curY) + Math.abs(7000 - curX), mindist);
						}
					}
				}

				// System.out.println(curX + " " + curY);
			}
			return mindist;
		}
	}

	public static long solve2(String s, boolean uhh) {
		if (uhh) {
			String[] arr = s.split(",");
			int curX = 7000, curY = 7000;
			long counter = 0;
			for (int i = 0; i < arr.length; i++) {
				char cur = arr[i].charAt(0);
				int x = Integer.parseInt(arr[i].substring(1));
				if (cur == 'R') {
					for (int j = 0; j < x; j++) {
						curX++;
						counter++;
						hm.put(curX + " " + curY, counter);
					}
				} else if (cur == 'L') {
					for (int j = 0; j < x; j++) {
						curX--;
						counter++;
						hm.put(curX + " " + curY, counter);
					}
				} else if (cur == 'D') {
					for (int j = 0; j < x; j++) {
						curY--;
						counter++;
						hm.put(curX + " " + curY, counter);
					}
				} else if (cur == 'U') {
					for (int j = 0; j < x; j++) {
						curY++;
						counter++;
						hm.put(curX + " " + curY, counter);
					}
				}
				// System.out.println(mindist);
				// System.out.println(curX + " " + curY);
			}
			return 0;
		} else {
			String[] arr = s.split(",");
			int curX = 7000, curY = 7000;
			long walkdist = Integer.MAX_VALUE;
			long counter = 0;
			for (int i = 0; i < arr.length; i++) {
				char cur = arr[i].charAt(0);
				int x = Integer.parseInt(arr[i].substring(1));
				if (cur == 'R') {
					for (int j = 0; j < x; j++) {
						curX++;
						counter++;
						if (hm.containsKey(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							walkdist = Math.min(walkdist, hm.get(curX + " " + curY) + counter);
						}
					}
				} else if (cur == 'L') {
					for (int j = 0; j < x; j++) {
						curX--;
						counter++;
						if (hm.containsKey(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							walkdist = Math.min(walkdist, hm.get(curX + " " + curY) + counter);
						}
					}
				} else if (cur == 'D') {
					for (int j = 0; j < x; j++) {
						curY--;
						counter++;
						if (hm.containsKey(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							walkdist = Math.min(walkdist, hm.get(curX + " " + curY) + counter);
						}
					}
				} else if (cur == 'U') {
					for (int j = 0; j < x; j++) {
						curY++;
						counter++;
						if (hm.containsKey(curX + " " + curY)) {
							// System.out.println(curX + " " + curY);
							walkdist = Math.min(walkdist, hm.get(curX + " " + curY) + counter);
						}
					}
				}

				// System.out.println(curX + " " + curY);
			}
			return walkdist;
		}
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public static String read() throws IOException {
		byte[] ret = new byte[1024];
		int idx = 0;
		byte c = Read();
		while (c <= ' ') {
			c = Read();
		}
		do {
			ret[idx++] = c;
			c = Read();
		} while (c != -1 && c != ' ' && c != '\n' && c != '\r');
		return new String(ret, 0, idx);
	}

	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		din.close();
		pr.close();
		System.exit(0);
	}
}
