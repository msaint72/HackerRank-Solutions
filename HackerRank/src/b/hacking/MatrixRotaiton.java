package b.hacking;

import java.util.Scanner;

public class MatrixRotaiton {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int R = in.nextInt();
		int[][] matrix = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		rotateMatrix(matrix, M, N, R);
	}

	private static void rotateMatrix(int[][] matrix, int M, int N, int R) {
		int minSide = Math.min(M, N);

		int[] layers = new int[minSide / 2];
		int index = 0;
		for (int l = 0; l < minSide / 2; l++) {
			// how many times each layer should be rotated
			layers[index++] = R % ((M - l*2) * 2 + (N - l*2) * 2 - 4);
		}

		returnMatrix(matrix, M, N, layers);
		printMatrix(matrix);

	}

	private static void returnMatrix(int[][] matrix, int M, int N, int[] layerRotationAmounts) {
		int maxRotation = 0;
		for (int i = 0; i < layerRotationAmounts.length; i++) {
			if (maxRotation < layerRotationAmounts[i])
				maxRotation = layerRotationAmounts[i];
		}
		int minSide = Math.min(M, N);
		int[] layerCounts = new int[layerRotationAmounts.length];
		for (int rotationCount = 0; rotationCount < maxRotation; rotationCount++) {
			for (int l = 0; l < minSide / 2; l++) {// layers
				if (layerCounts[l] < layerRotationAmounts[l]) {
					int leftBottom = matrix[M - 1 - l][l];
					int rightTop = matrix[l][N - 1 - l];
					int leftCol = l;
					int rightCol = N - 1 - l;
					for (int r = l; r < M - l - 1; r++) {
						// left
						matrix[M - r - 1][leftCol] = matrix[M - 2 - r][leftCol];
						// right
						matrix[r][rightCol] = matrix[r + 1][rightCol];
					}
					int topRow = l;
					int bottomRow = M - 1 - l;
					int topLeft = matrix[topRow][l];
					int bottomRight = matrix[bottomRow][N - l - 1];
					for (int c = l; c < N - l - 1; c++) {
						// top
						if (c == N - 2 - l)
							matrix[topRow][c] = rightTop;
						else
							matrix[topRow][c] = matrix[topRow][c + 1];
						// bottom
						if (c == N - 2 - l)
							matrix[bottomRow][N - 1 - c] = leftBottom;
						else
							matrix[bottomRow][N - 1 - c] = matrix[bottomRow][N - c - 2];
					}
					layerCounts[l]++;
				}
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
