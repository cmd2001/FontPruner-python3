import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractionOperationUtil {

	/***
	 * 是否是汉字
	 */
	public static boolean isChineseCharacters(String str){
        boolean temp = false;
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
        Matcher m=p.matcher(str); 
        if(m.find()){ 
            temp =  true;
        }
        return temp;
	}
	
	/**
	 * 筛选有效字符
	 */
	public static String ExtractVaildString(String str) {
		return str.replaceAll( "\\s*|\t|\r|\n","");
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
	
	public static List<String> ExtractStringListFromFile(File file) {
		ArrayList<String> stringList =new ArrayList<String>();
		try {
			String encode =EncodingDetect.getJavaEncode(file.getAbsolutePath());
			BufferedReader bufReader = 
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(
								file),encode));

			for (String tmp = null; (tmp = bufReader.readLine()) != null; tmp = null) {
				stringList.add(tmp);
			}
			bufReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringList;
	}
	
	public static String ExtractStringFromFile(File file) {
		StringBuffer strBuf =null;
		try {
			String encode =EncodingDetect.getJavaEncode(file.getPath());
			BufferedReader bufReader = 
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(
								file),encode));

			strBuf = new StringBuffer();
			for (String tmp = null; (tmp = bufReader.readLine()) != null; tmp = null) {
				strBuf.append(tmp);
			}
			bufReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strBuf.toString();
	}
	
	public static void checkCharInMapNum(
			Map<Character, Integer> map, char c) {

		if(!map.containsKey(c))
		{
			map.put(c,1);
		}else{
			map.put(c,map.get(c)+1);	
		}
	}
	
	
}
