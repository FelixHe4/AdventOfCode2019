import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Day4 {

	public static void main(String[] args) throws IOException {
		System.out.println(solve(359282, 820401));
		System.out.println(solve2(359282, 820401));
	}

	public static int solve(int start, int end) {
		int counter = 0;
		for (int i = start; i <= end; i++) {
			String s = i + "";
			boolean flag = true;
			for (int j = 0; j < s.length() - 1; j++) {
				if (Integer.parseInt(s.charAt(j) + "") > Integer.parseInt(s.charAt(j + 1) + "")) {
					flag = false;
				}
			}
			if (!flag) {
				continue;
			} else {
				flag = false;
				for (int j = 0; j < s.length() - 1; j++) {
					if (Integer.parseInt(s.charAt(j) + "") == Integer.parseInt(s.charAt(j + 1) + "")) {
						flag = true;
					}
				}
			}
			if (flag) {
				counter++;
			}
		}
		return counter;
	}

	public static int solve2(int start, int end) {
		int counter = 0;
		for (int i = start; i <= end; i++) {
			String s = i + "";
			boolean flag = true;
			for (int j = 0; j < s.length() - 1; j++) {
				if (Integer.parseInt(s.charAt(j) + "") > Integer.parseInt(s.charAt(j + 1) + "")) {
					flag = false;
				}
			}
			if (!flag) {
				continue;
			} else {
				flag = false;
				int[] freq = new int[10];
				for (int j = 0; j < s.length(); j++) {
					freq[Integer.parseInt(s.charAt(j) + "")]++;
				}
				// System.out.println(Arrays.toString(freq));
				for (int j = 0; j < freq.length; j++) {
					if (freq[j] == 2) {
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				System.out.println(s);
				counter++;
			}
		}
		return counter;
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
