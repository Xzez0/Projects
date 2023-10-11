package imagetransform;

import java.awt.Color;

public class ImageTransforms {
	private static int getRowCount(Color[][] pixelMatrix) {
		return pixelMatrix.length;
	}

	private static int getColCount(Color[][] pixelMatrix) {
		if(pixelMatrix.length>0) {
			return pixelMatrix[0].length;
		} else {
			return 0;
		}
	}

	public static Color[][] copy(Color[][] source) {
		int rowCount = getRowCount(source);
		int colCount = getColCount(source);
		Color[][] destination = new Color [rowCount][colCount]; // TODO: replace null with a new rowCount X colCount matrix (2D array)

		for (int i = 0; i < (rowCount) ; i++) {
			for (int j = 0; j < (colCount) ; j++) {

				Color a = source[i][j];
				destination[i][j] = a;

			}
		}


		// NOTE: do NOT mutate (change) the values of the passed in source

		// TODO:
		// fill destination with values from source


		return destination;
	}

	public static Color[][] flipHorizontal(Color[][] source) {
		int rowCount = getRowCount(source);
		int colCount = getColCount(source);
		Color[][] destination = new Color [rowCount][colCount]; // TODO: replace null with a new rowCount X colCount matrix (2D array)

		
		
		for (int i = 0; i < (rowCount) ; i++) {
			for (int j = 0; j < (colCount) ; j++) {

				Color a = source[i][j];
				destination[i][(colCount - j) - 1] = a;
				
			}
			
		}

		// NOTE: do NOT mutate (change) the values of the passed in source

		// TODO:
		// fill destination with values from source
		// but flipped horizontally


		return destination;
	}

	public static Color[][] flipVertical(Color[][] source) {
		int rowCount = getRowCount(source);
		int colCount = getColCount(source);
		Color[][] destination = new Color [rowCount][colCount]; // TODO: replace null with a new rowCount X colCount matrix (2D array)


		// NOTE: do NOT mutate (change) the values of the passed in source

		// TODO:
		// fill destination with values from source
		// but flipped vertically

		for (int i = 0; i < (rowCount) ; i++) {
			for (int j = 0; j < (colCount) ; j++) {

				Color a = source[i][j];
				destination[(rowCount - i) - 1][j] = a;
			}
		}

		return destination;
	}

	public static Color[][] mirrorLeftOntoRight(Color[][] source) {
		int rowCount = getRowCount(source);
		int colCount = getColCount(source);
		Color[][] destination = new Color [rowCount][colCount]; // TODO: replace null with a new rowCount X colCount matrix (2D array)


		// NOTE: do NOT mutate (change) the values of the passed in source

		// TODO:
		// fill destination with values from source
		// but mirror the left pixels onto the right side
		
		for (int i = 0; i < (rowCount) ; i++) {
			for (int j = 0; j < colCount; j++) {

				Color a = source[i][j];
			
				destination[i][j] = a;
				
			}
		}

		for (int i = 0; i < (rowCount) ; i++) {
			for (int j = colCount/2; j < colCount; j++) {
				
				destination[i][j] = destination[i][colCount - j-1];
			
			}
		}

		return destination;
	}

	public static Color[][] rotateRight(Color[][] source) {
		int srcRowCount = getRowCount(source);
		int srcColCount = getColCount(source);
		int dstRowCount = srcColCount; // TODO: replace -1 to the correct (rotated) value for destination
		int dstColCount = srcRowCount; // TODO: replace -1 to the correct (rotated) value for destination
		Color[][] destination = new Color [dstRowCount][dstColCount]; // TODO: replace null with a new dstRowCount X dstColCount matrix (2D array)


	for (int i = 0; i < srcRowCount ; i++) {
			for (int j = 0; j < srcColCount ; j++) {

				Color a = source[i][j];
			destination[j][(srcRowCount - 1) - i] = a;
			}
	}

		// NOTE: do NOT mutate (change) the values of the passed in source

		// TODO:
		// fill destination with values from source
		// but rotate each pixel to the right


		return destination;
	}
}
