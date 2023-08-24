package edu.kh.io.run;

import edu.kh.io.service.IOService;

public class IORun {

	public static void main(String[] args) {
		IOService ios = new IOService(); 
	//	ios.byteOutput();
	//	ios.charOutput();\\
		//ios.byteInput();
	//	ios.charInput();
//		ios.fileCopy();
//		ios.objectOutput();
		ios.objectInput();
		}
	}

