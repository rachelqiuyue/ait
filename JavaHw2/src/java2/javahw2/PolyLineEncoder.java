/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.javahw2;
import java.math.BigDecimal;


/**
 *
 * @author rachelqiuyue
 */
//
//public class PolyLineEncoder {
//    public String PolyLine(Gps[] gpspoints){
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < gpspoints.length; ++i){
//            if ( i == 0){
//                result.append(PolyLineAlgorithm(0,gpspoints[i].getLatitude()));
//                result.append(PolyLineAlgorithm(0,gpspoints[i].getLongitude()));
//            }
//            result.append(PolyLineAlgorithm(gpspoints[i-1].getLatitude(),gpspoints[i].getLatitude()));
//            result.append(PolyLineAlgorithm(gpspoints[i-1].getLongitude(),gpspoints[i].getLongitude()));
//        }
//        return result.toString();
//    }
//    private static String PolyLineAlgorithm(double prev, double current){
//        long cur = Math.round(current * 100000);
//        long prevs = Math.round( prev * 100000);
//        long diff = cur - prevs;
//        long shift = diff << 1;
//        if (diff < 0)shift = ~shift;
//        //seperate in five chunks
//        //method 1, change diff to strings, uses slicing
//        //method 2, use casting shift the digits\
//        
//        StringBuilder charValueChunks = new StringBuilder();
//	long currentFiveBits = diff & 0x1F;
//	long nextFiveBits = (diff >> 5) & 0x1F;
//	while (nextFiveBits != 0) {
//		currentFiveBits |= 0x20;
//		currentFiveBits += 63;
//		charValueChunks.append((char)currentFiveBits);
//		//Convert backslash characters to double-backslashes
//		diff  = diff >> 5;
//		currentFiveBits = diff & 0x1F;
//		nextFiveBits = (diff >> 5) & 0x1F;
//		}
//		
//		//Deal with the last chunk
//		currentFiveBits += 63;
//		charValueChunks.append((char)currentFiveBits);
//		return charValueChunks.toString();
//    }
//    
//}


public class PolyLineEncoder {

    public String encodePolyline(Gps[] gpsPoints) {
    	//Check inputs, if the input value is invalid, then return a empty string
    	if (gpsPoints == null || gpsPoints.length == 0)
    		return "";
    	StringBuilder encodedResult = new StringBuilder();
    	
    	for (int i = 0; i < gpsPoints.length; i++) {
    		String latitude, longitude;
    		//Special case: If it's the first point, then calculate the distance from (0, 0)
    		if (i == 0) {
    			latitude = encodeProcess(0d, gpsPoints[i].getLatitude());
    			longitude = encodeProcess(0d, gpsPoints[i].getLongitude());
    		} else {
    			//Calculate the offset from the previous point if it's not the first point
    			latitude = encodeProcess(gpsPoints[i - 1].getLatitude(), gpsPoints[i].getLatitude());
    			longitude = encodeProcess(gpsPoints[i - 1].getLongitude(), gpsPoints[i].getLongitude());    			
    		}
    		
    		encodedResult.append(latitude);
    		encodedResult.append(longitude);
    	}
    	
    	return encodedResult.toString();
    	
    }
    
    
    //This function accepts two double point value, and encodes the diff by Encoded Polyline Algorithm, 
    //then return encoded string
    private String encodeProcess(double previousPointValue, double currentPointValue) {
    	BigDecimal bdCurrentPointValue = new BigDecimal(Double.toString(currentPointValue));
    	//Use BigDecimal to calculate
    	//Calculate the offset
    	BigDecimal bdValueToEncode = bdCurrentPointValue.subtract(new BigDecimal(Double.toString(previousPointValue)));
    	boolean isPositive = (bdValueToEncode.compareTo(BigDecimal.ZERO) >= 0) ? true : false;
    	
    	bdValueToEncode = bdValueToEncode.setScale(5, BigDecimal.ROUND_HALF_UP);				
    	bdValueToEncode = bdValueToEncode.multiply(new BigDecimal("100000"));
    	bdValueToEncode = bdValueToEncode.setScale(0, BigDecimal.ROUND_DOWN);
    	
    	StringBuilder charValueChunks;
    	int	iValueToEncode = 0;
    	try {
        	iValueToEncode = bdValueToEncode.intValueExact();
    	} catch (ArithmeticException e) {
    		System.out.println("Value Has Nonzero Fractional Part");
    	}
    	//Left-shift the binary value one bit
		iValueToEncode = iValueToEncode << 1;
		
		//If the original decimal value is negative, invert this encoding
		if (!isPositive) {
			iValueToEncode = ~iValueToEncode; 
		}
		
		//Break the binary value out into 5-bit chunks
		//Here we break the binary value from right to left and append to the result, 
		//so there is no need to reverse it
		charValueChunks = new StringBuilder();
		int currentFiveBits = iValueToEncode & 0x1F;
		int nextFiveBits = (iValueToEncode >> 5) & 0x1F;
		while (nextFiveBits != 0) {
			currentFiveBits |= 0x20;
			currentFiveBits += 63;
			charValueChunks.append((char)currentFiveBits);
			//Convert backslash characters to double-backslashes
			if (currentFiveBits == '\\')
				charValueChunks.append((char)currentFiveBits);
					
			iValueToEncode = iValueToEncode >> 5;
			currentFiveBits = iValueToEncode & 0x1F;
			nextFiveBits = (iValueToEncode >> 5) & 0x1F;
		}
		
		//Deal with the last chunk
		currentFiveBits += 63;
		charValueChunks.append((char)currentFiveBits);
		
		if (currentFiveBits == '\\')
			charValueChunks.append((char)currentFiveBits);
    	
		return charValueChunks.toString();
    }

}