import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class oldMcVerRemover {

	public static void main(String[] args) throws IOException {
		File floc = new File(".minecraft file location.txt");
		BufferedReader br = new BufferedReader(new FileReader(floc));
		String loc = br.readLine();
		br.close();
		
		File manifest = new File(loc+"\\versions\\version_manifest_v2.json");
		manifest.delete();
		
		int lc = 1000;
		
		while (lc != 0) {
			
		
			
		String p = "";
		int l = path(loc, "\\versions\\").length;
		//System.out.println(l);
		if (lc==1000) {
			lc=l;
		}
		lc--;
		while (l != 0) {
			l--;
			p = path(loc, "\\versions\\")[l];
			//System.out.println(p);
			path(loc, "\\versions\\"+p);
		}
		}
	}
	
	static String[] path (String loc, String file) {
		String[] pathnames;
	    File ver = new File(loc+file);
	    pathnames = ver.list();
	    for (String pathname : pathnames) {
	    	//System.out.println(pathname);
	    	File path = new File(ver+"\\"+pathname);
	    	if (pathname.equals("1.19.2") || pathname.equals("1.19.2.json") || pathname.equals("1.19.2.jar")) {}
	    	else {
	    		path.delete();
	    		System.out.println(ver+"\\"+pathname);
	    	}
	    }
	    return pathnames;
	}
	
	

}
