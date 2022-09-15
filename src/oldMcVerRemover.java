import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class oldMcVerRemover {

	public static void main(String[] args) throws IOException {
		
		//read location
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String loc = br.readLine();
		br.close();
		//in	
		String keep = "1.19.2";	
		String p = "";
		//timer
		double allTime = 0;	
		long startTime = System.nanoTime();
		//while
		int l = path(loc, "\\versions\\", keep).length-1;
		while (l != 0) {
			l = path(loc, "\\versions\\", keep).length-2;
			p = path(loc, "\\versions\\", keep)[l];
			path(loc, "\\versions\\"+p, keep);
		}
		//hex...
		

		//timer end
		double elapsedTime = ((System.nanoTime() - startTime)/10000);
		allTime = allTime + elapsedTime;
		System.out.println(elapsedTime/100+" millisecond");
	}
	
	static String[] path (String loc, String file, String keep) {
		String[] pathnames = {"0"};
	    File ver = new File(loc+file);
	    pathnames = ver.list();	    
	    for (String pathname : pathnames) {
	    	File path = new File(ver+"\\"+pathname);
	    	if (pathname.equals(keep) || pathname.equals(keep+".json") || pathname.equals(keep+".jar")) {}
	    	else {
	    		path.delete();
	    		System.out.println(path); 
	    	}
	    }
	    
	    return pathnames;
	}
	
	
}
