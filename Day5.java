import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Day5 {

	public static void main(String[] args) throws IOException {
		solve1(readLine());
	}

	public static void solve1(String s) throws IOException {
		String[] spl = s.split(",");
		int[] arr = new int[spl.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(spl[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			String xd = "0000" + spl[i];
			int op = Integer.parseInt(xd.substring(xd.length() - 2));
			int first = Integer.parseInt(xd.charAt(xd.length() - 3) + "");
			int second = Integer.parseInt(xd.charAt(xd.length() - 4) + "");
			int third = Integer.parseInt(xd.charAt(xd.length() - 5) + "");
			if (op == 3) {
				int x = readInt();
				arr[arr[i + 1]] = x;
				i += 1;
			} else if (op == 4) {
				System.out.println(arr[arr[i + 1]]);
				i += 1;
			} else if (op == 1) {
				int a, b;
				if (first == 0) {
					a = arr[arr[i + 1]];
				} else {
					a = arr[i + 1];
				}
				if (second == 0) {
					b = arr[arr[i + 2]];
				} else {
					b = arr[i + 2];
				}
				if (third == 0) {
					arr[arr[i + 3]] = a + b;
				}
				i += 3;
			} else if (op == 2) {
				int a, b;
				if (first == 0) {
					a = arr[arr[i + 1]];
				} else {
					a = arr[i + 1];
				}
				if (second == 0) {
					b = arr[arr[i + 2]];
				} else {
					b = arr[i + 2];
				}
				if (third == 0) {
					arr[arr[i + 3]] = a * b;
				}
				i += 3;
			} else if (op == 99) {
				exit();
			}
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
