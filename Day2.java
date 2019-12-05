import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Day2 {

	public static void main(String[] args) throws IOException {
		// System.out.println(solve1(readLine()));
		System.out.println(solve2(readLine()));
	}

	public static long solve1(String s) {
		String[] arr = s.split(",");
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = Integer.valueOf(arr[i]);
		}
		a[1] = 12;
		a[2] = 2;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 99) {
				System.out.println(Arrays.toString(a));
				return a[0];
			} else if (a[i] == 1) {
				a[a[i + 3]] = a[a[i + 1]] + a[a[i + 2]];
				i += 3;
			} else if (a[i] == 2) {
				a[a[i + 3]] = a[a[i + 1]] * a[a[i + 2]];
				i += 3;
			}
		}
		return 0;
	}

	public static long solve2(String s) {
		String[] arr = s.split(",");
		int[] a = new int[arr.length];
		int[] b = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = Integer.valueOf(arr[i]);
			b[i] = a[i];
		}
		for (int j = 0; j <= 99; j++) {
			for (int k = 0; k <= 99; k++) {
				a[1] = j;
				a[2] = k;
				for (int i = 0; i < a.length; i++) {
					if (a[i] == 99) {
						// System.out.println(Arrays.toString(a));
						if (a[0] == 19690720) {
							System.out.println(a[1] + " " + a[2]);
						}
						// return a[0];
					} else if (a[i] == 1) {
						a[a[i + 3]] = a[a[i + 1]] + a[a[i + 2]];
						i += 3;
					} else if (a[i] == 2) {
						a[a[i + 3]] = a[a[i + 1]] * a[a[i + 2]];
						i += 3;
					}
				}

				for (int i = 0; i < arr.length; i++) {
					a[i] = b[i];
				}
				// System.out.println(Arrays.toString(a));
			}
			for (int i = 0; i < arr.length; i++) {
				a[i] = b[i];
			}
			// System.out.println(Arrays.toString(a));
		}
		return 0;
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
