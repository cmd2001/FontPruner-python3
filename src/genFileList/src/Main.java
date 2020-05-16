import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class Main {
	public static String result="" ;
	public static String outputPath ;
	public static void main(String[] args) {
		//最后一个路径为fileList输出路径，前面的为需要提取文件列表的输入路径
		if(args.length<2)
		{
			System.out.println("para error");
			System.exit(1);
		}
		
		outputPath = args[args.length-1];
		for (int i =0 ;i<args.length-1;i++){
			String path = args[i];
			File file = new File(path);
			if(!file.exists()){
				System.out.println("文本路径列表不存在"+file.toString());
				continue;
			}
			WriteStr2File(listFile(file),new File(outputPath),"UTF-8");
		}
	}
	
	public static void  WriteStr2File(String str,File file,String encode){
		try {
			FileOutputStream writerStream = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream,encode));
			writer.write(str);
			writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String listFile (File f){
		if(f.isFile()){
			String path =f.getPath();
			String afterFix =path.substring(path.lastIndexOf("."),path.length());
			if(afterFix.equals(".txt") ||afterFix.equals(".lua"))
			{
				result+=f.getPath()+"\r\n";
				System.out.println(f.getPath());
			}
		}else{
			if(f.isDirectory()){
				for(File file :f.listFiles()){
					listFile(file);
				}
			}
		}
		return result;
	}
}
