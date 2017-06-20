import java.util.*;
import java.util.regex.Pattern;
import java.lang.*;

public class Methods 
{
	
	public static void main (String[] args)
	{
		System.out.println(calculateSubnetAddress("192.168.1.54", 1, "255.255.255.0"));
		System.out.println(calculateBroadcastAddress(calculateSubnetAddress("192.168.1.54", 1, "255.255.255.0"), "255.255.255.0"));
	}
	
	
	public static String binaryAddition(String s1, String s2) {
	    if (s1 == null || s2 == null) return "";
	    int first = s1.length() - 1;
	    int second = s2.length() - 1;
	    StringBuilder outputSum = new StringBuilder();
	    int carry = 0;
	    while (first >= 0 || second >= 0) {
	        int sum = carry;
	        if (first >= 0) {
	            sum += s1.charAt(first) - '0';
	            first--;
	        }
	        if (second >= 0) {
	            sum += s2.charAt(second) - '0';
	            second--;
	        }
	        carry = sum >> 1;
	        sum = sum & 1;
	        outputSum.append(sum == 0 ? '0' : '1');
	    }
	    if (carry > 0)
	        outputSum.append('1');

	    outputSum.reverse();
	    return String.valueOf(outputSum);
	}

	public static String calculateSubnetAddress(String inputAddress, int parameter, String subnetMask)
	{
	
		
		if (parameter == 0)
		{
			return inputAddress;
		}
		else
		{
			String[] splittedAddress = inputAddress.split(Pattern.quote("."));
			Integer[] splittedIntAddress = new Integer[4];
			for (int i = 0; i < splittedAddress.length; i++)
			{
				splittedIntAddress[i] = Integer.parseInt(splittedAddress[i]);
			}
			
			String[] splittedMask = subnetMask.split(Pattern.quote("."));
			Integer[] splittedIntMask = new Integer[4];
			for (int i = 0; i < splittedMask.length; i++)
			{
				splittedIntMask[i] = Integer.parseInt(splittedMask[i]);
			}
			
			
			
			StringBuilder[] splittedBinaryAddress = new StringBuilder[4];
			StringBuilder[] splittedBinaryMask = new StringBuilder[4];
			
			for (int i = 0; i < 4; i++)
			{
				splittedBinaryAddress[i] = new StringBuilder("");
				splittedBinaryMask[i] = new StringBuilder("");
				
			}
			
			
			for (int i = 0; i < 4; i++)
			{
				splittedBinaryAddress[i].append(Integer.toBinaryString(splittedIntAddress[i]));
				splittedBinaryMask[i].append(Integer.toBinaryString(splittedIntMask[i]));
				
				if(splittedBinaryMask[i].length()<8)
				{
					splittedBinaryMask[i].reverse();
					for (int j = splittedBinaryMask[i].length(); j<8;j++)
					{
						
						splittedBinaryMask[i].append('0');
					}
					splittedBinaryMask[i].reverse();
				}
				
				if(splittedBinaryAddress[i].length()<8)
				{
					splittedBinaryAddress[i].reverse();
					for (int j = splittedBinaryAddress[i].length(); j<8;j++)
					{
						
						splittedBinaryAddress[i].append('0');
					}
					splittedBinaryAddress[i].reverse();
				}
			}
			
			
			StringBuilder[] outputBinary = new StringBuilder[4];
			for (int  i = 0; i < 4; i++)
			{
				outputBinary[i] = new StringBuilder("");
			}
			
			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < splittedBinaryAddress[i].length(); j++)
				{
					if (splittedBinaryMask[i].charAt(j)=='1')
					{
						outputBinary[i].append(splittedBinaryAddress[i].charAt(j));
					}
					else
					{
						outputBinary[i].append("0");
					}
				}
			}
			
			Integer[] outputInt = new Integer[4];
			for (int  i = 0; i < 4; i++)
			{
				outputInt[i] = Integer.parseInt(outputBinary[i].toString(), 2);
			}
			
			StringBuilder outputSubnetAddress = new StringBuilder("");
		
			for (int i = 0; i < 4; i++)
			{
				outputSubnetAddress.append(Integer.toString(outputInt[i]));
				outputSubnetAddress.append(".");
			}
			return outputSubnetAddress.toString();
		}
		
	
		
		
		
	}
	
	public static String calculateBroadcastAddress(String subnetAddress, String subnetMask)
	{
		
		String[] splittedAddress = subnetAddress.split(Pattern.quote("."));
		Integer[] splittedIntAddress = new Integer[4];
		for (int i = 0; i < splittedAddress.length; i++)
		{
			splittedIntAddress[i] = Integer.parseInt(splittedAddress[i]);
		}
		
		String[] splittedMask = subnetMask.split(Pattern.quote("."));
		Integer[] splittedIntMask = new Integer[4];
		for (int i = 0; i < splittedMask.length; i++)
		{
			splittedIntMask[i] = Integer.parseInt(splittedMask[i]);
		}
		
		
		
		StringBuilder[] choppedAddress = new StringBuilder[4];
		StringBuilder[] choppedMask = new StringBuilder[4];
		
		for (int i = 0; i < 4; i++)
		{
			choppedAddress[i] = new StringBuilder("");
			choppedMask[i] = new StringBuilder("");
	
		}
		
		for (int i = 0; i < 4; i++)
		{
			choppedAddress[i].append(Integer.toBinaryString(splittedIntAddress[i]));
			choppedMask[i].append(Integer.toBinaryString(splittedIntMask[i]));
			
			
			if(choppedMask[i].length()<8)
			{
				choppedMask[i].reverse();
				for (int j = choppedMask[i].length(); j<8;j++)
				{
					
					choppedMask[i].append('0');
				}
				choppedMask[i].reverse();
			}
			
			if(choppedAddress[i].length()<8)
			{
				choppedAddress[i].reverse();
				for (int j = choppedAddress[i].length(); j<8;j++)
				{
					
					choppedAddress[i].append('0');
				}
				choppedAddress[i].reverse();
			}
			
		}
		
		
		StringBuilder address = new StringBuilder("");
		StringBuilder mask = new StringBuilder("");
		StringBuilder newMask = new StringBuilder("");
	
		
		
		for (int i = 0; i < 4; i++)
		{
			address.append(choppedAddress[i]);
			mask.append(choppedMask[i]);
			
		}
		
		for (int i = 0; i < mask.length(); i++)
		{
			if(mask.charAt(i)=='0')
			{
				newMask.append('1');
			}
			else if (mask.charAt(i)=='1')
			{
				newMask.append('0');
			}
		}
		
		System.out.println(mask);
		System.out.println(newMask);
		System.out.println(address);
		
		
		
		String outputBinary = Methods.binaryAddition(address.toString(), newMask.toString());
		System.out.println(outputBinary);
		StringBuilder[] chopped = new StringBuilder[4];
		for (int j = 0; j < 4; j++)
		{
			chopped[j] = new StringBuilder("");
		}
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				chopped[i].append(outputBinary.charAt(i*8+j));
			}
		}
		
		Integer[] choppedInt = new Integer[4];
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				choppedInt[i] = Integer.parseInt(chopped[i].toString(),2);
			}
		}
		
		StringBuilder output = new StringBuilder("");
		
		for (int i = 0; i < 4; i++)
		{
			
			output.append(Integer.toString(choppedInt[i]));
			
			output.append(".");
		}
		
		
		return output.toString();
		
	}
	
}
