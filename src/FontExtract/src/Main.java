import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int argLength = args.length;
		if(argLength!=2){
			System.out.println("输入参数有误，[0]需要抽取的文本路径列表   [1]输出路径");
			System.exit(0);
		}

		String fileListString =args[0];
		File file = new File(fileListString);
		if(!file.exists()){
			System.out.println("文本路径列表不存在"+file.toString());
			System.exit(1);
		}
		if(!file.isFile()){
			System.out.println("文本路径列表不是文件"+file.toString());
			System.exit(1);
		}
		
		
		StringBuffer strBuf = new StringBuffer();
		List<String> filePathList =ExtractionOperationUtil.ExtractStringListFromFile(file);
		for(String filePath :filePathList)
		{
			File f = new File(filePath);	
			if(!f.exists() ||!f.isFile()){
				System.out.println("文本不存在或者无效"+f.toString());
				continue;
			}
			strBuf.append(ExtractionOperationUtil.ExtractStringFromFile(f));
		}
		
		String outputPath =args[1];
		File outputFile = new File(outputPath);
		if(!outputFile.exists()){
			outputFile.mkdirs();
		}
		if(outputFile.isFile()){
			System.out.println("路径是文件"+outputFile.toString());
			System.exit(1);
		}
		ExtractResult result =ExtractionOperationUtil.ExtractUnrepeatedWordsFromString(strBuf.toString());
		ExtractionOperationUtil.WriteStr2File(result.chineseCharString,new File(outputPath+"\\ChineseOutPut.txt"),"UTF-8");
		ExtractionOperationUtil.WriteStr2File(result.unChineseCharString,new File(outputPath+"\\unChineseOutPut.txt"),"UTF-8");
		
		System.out.println("提取完成");
	}
}



