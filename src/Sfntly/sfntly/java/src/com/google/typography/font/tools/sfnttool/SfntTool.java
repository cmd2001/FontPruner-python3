/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.typography.font.tools.sfnttool;

import com.google.typography.font.sfntly.Font;
import com.google.typography.font.sfntly.FontFactory;
import com.google.typography.font.sfntly.Tag;
import com.google.typography.font.sfntly.data.WritableFontData;
import com.google.typography.font.sfntly.table.core.CMapTable;
import com.google.typography.font.tools.conversion.eot.EOTWriter;
import com.google.typography.font.tools.conversion.woff.WoffWriter;
import com.google.typography.font.tools.subsetter.HintStripper;
import com.google.typography.font.tools.subsetter.RenumberingSubsetter;
import com.google.typography.font.tools.subsetter.Subsetter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Raph Levien
 */
public class SfntTool {
  private boolean strip = false;
  private String subsetString = null;
  private List<String> fileListString = new ArrayList<String>();
  private boolean woff = false;
  private boolean eot = false;
  private boolean mtx = false;

  public static void main(String[] args) throws Exception {
    SfntTool tool = new SfntTool();
    File fontFile = null;
    File outputFile = null;
    boolean bench = false;
    int nIters = 1;

    for (int i = 0; i < args.length; i++) {
      String option = null;
      if (args[i].charAt(0) == '-') {
        option = args[i].substring(1);
      }

      if (option != null) {
        if (option.equals("help") || option.equals("?")) {
          printUsage();
          System.exit(0);
        } else if (option.equals("b") || option.equals("bench")) {
          nIters = 10000;
        } else if (option.equals("h") || option.equals("hints")) {
          tool.strip = true;
        } else if (option.equals("s") || option.equals("string")) {
          tool.subsetString = args[i + 1];
          i++;
        }else if (option.equals("c") || option.equals("customer")) {
          if(args.length<2)
          {
            throw new Exception("error args count");
          }
          for(int j = i+1 ;j<args.length-2;j++)
          {
            System.out.println("extracted file :" +args[j]);
            tool.fileListString.add(args[j]);
            i++;
          }
        } else if (option.equals("w") || option.equals("woff")) {
          tool.woff = true;
        } else if (option.equals("e") || option.equals("eot")) {
          tool.eot = true;
        } else if (option.equals("x") || option.equals("mtx")) {
          tool.mtx = true;
        } else {
          printUsage();
          System.exit(1);
        }
      } else {
        if (fontFile == null) {
          fontFile = new File(args[i]);
        } else {
          outputFile = new File(args[i]);
          break;
        }
      }
    }
    
  StringBuffer strBuf = new StringBuffer();
    for(String filePath :tool.fileListString)
    {
      File f = new File(filePath);  
      if(!f.exists() ||!f.isFile()){
        System.out.println("文本不存在或者无效"+f.toString());
        continue;
      }
      strBuf.append(ExtractionOperationUtil.ExtractStringFromFile(f));
    }
    tool.subsetString =strBuf.toString();
    
    if (tool.woff && tool.eot) {
      System.out.println("WOFF and EOT options are mutually exclusive");
      System.exit(1);
    }

    if (fontFile != null && outputFile != null) {
      tool.subsetFontFile(fontFile, outputFile, nIters);
    } else {
      printUsage();
    }
//    tool.subsetString =" 我要";
//    tool.subsetFontFile(new File("C:\\Users\\zhangzhengtong\\Desktop\\testTTF\\PublicFonts.ttf")
//    ,new File("C:\\Users\\zhangzhengtong\\Desktop\\testExtractFix\\testOut.ttf"),1);
    
  }

  private static final void printUsage() {
    System.out.println("Subset [-?|-h|-help] [-b] [-s string] fontfile outfile");
    System.out.println("Prototype font subsetter");
    System.out.println("\t-?,-help\tprint this help information");
    System.out.println("\t-s,-string\t String to subset");
    System.out.println("\t-c,-customer\t fileList... fontFile outFile");
    System.out.println("\t-b,-bench\t Benchmark (run 10000 iterations)");
    System.out.println("\t-h,-hints\t Strip hints");
    System.out.println("\t-w,-woff\t Output WOFF format");
    System.out.println("\t-e,-eot\t Output EOT format");
    System.out.println("\t-x,-mtx\t Enable Microtype Express compression for EOT format");
    System.out.println("\t-f,file load");
  }

  public void subsetFontFile(File fontFile, File outputFile, int nIters)
      throws IOException {
    FontFactory fontFactory = FontFactory.getInstance();
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(fontFile);
      byte[] fontBytes = new byte[(int)fontFile.length()];
      fis.read(fontBytes);
      Font[] fontArray = null;
      fontArray = fontFactory.loadFonts(fontBytes);
      Font font = fontArray[0];
      
//      DataDisplayTable unmappedGlyphs = FontInfo.listUnmappedGlyphs(font);
//
//      System.out.println(String.format("Total hinting size: %s", FontInfo.hintingSize(font)));
//      System.out.println(String.format(
//          "Number of unmapped glyphs: %d / %d", unmappedGlyphs.getNumRows(),
//          FontInfo.numGlyphs(font)));
//      System.out.println();
//      System.out.println("Unmapped glyphs:");
//      System.out.println(
//          prependDataAndBuildCsv(unmappedGlyphs.csvStringArray(),fileName,i));
//      System.out.println();
//      System.out.println("Subglyphs used by characters in the font:");
//      System.out.println(prependDataAndBuildCsv(
//          FontInfo.listSubglyphFrequency(font).csvStringArray(),fileName,i));
//      System.out.println();
//      
//      if (options.csv) {
//        System.out.println(String.format("Total hinting size: %s", FontInfo.hintingSize(font)));
//        System.out.println(String.format(
//            "Number of unmapped glyphs: %d / %d", unmappedGlyphs.getNumRows(),
//            FontInfo.numGlyphs(font)));
//        System.out.println();
//        if (options.detailed) {
//          System.out.println("Unmapped glyphs:");
//          System.out.println(
//              prependDataAndBuildCsv(unmappedGlyphs.csvStringArray(), fileName, i));
//          System.out.println();
//        }
//        System.out.println("Subglyphs used by characters in the font:");
//        System.out.println(prependDataAndBuildCsv(
//            FontInfo.listSubglyphFrequency(font).csvStringArray(), fileName, i));
//        System.out.println();
//      } else {
//        System.out.println(String.format("Total hinting size: %s", FontInfo.hintingSize(font)));
//        System.out.println(String.format(
//            "Number of unmapped glyphs: %d / %d", unmappedGlyphs.getNumRows(),
//            FontInfo.numGlyphs(font)));
//        System.out.println();
//        if (options.detailed) {
//          System.out.println("Unmapped glyphs:");
//          unmappedGlyphs.prettyPrint();
//          System.out.println();
//        }
//        System.out.println("Subglyphs used by characters in the font:");
//        FontInfo.listSubglyphFrequency(font).prettyPrint();
//        System.out.println();
//      }
//    }
      
//      LocaTable locaTable = font.getTable(Tag.loca);
//      GlyphTable glyphTable = font.getTable(Tag.glyf);
//
//      int count = 0;
//      HashSet<Integer> contourMap=new HashSet<Integer>();
//      for (int glyphId = 0; glyphId < locaTable.numGlyphs(); glyphId++) {
//        int offset = locaTable.glyphOffset(glyphId);
//        int length = locaTable.glyphLength(glyphId);
//        Glyph glyph = glyphTable.glyph(offset, length);
//        if (glyph.glyphType() == GlyphType.Composite) {
//          CompositeGlyph composite= (CompositeGlyph)glyph;
//          for (int i = 0; i < composite.numGlyphs(); i++) {
//            int num =composite.glyphIndex(i);
//          }
//          contourMap.addAll(composite.getContourList());
//        }
//        if (glyph instanceof SimpleGlyph) {
//          SimpleGlyph simple = (SimpleGlyph) glyph;
//          count++;
//          if (simple.numberOfContours() != 2) {
//            continue;
//          }
//          if ((simple.numberOfPoints(0) != 1) && (simple.numberOfPoints(1) != 1)) {
//            continue;
//          }
//        }
//      }
//      System.out.println("contourSize = "+count);
      
      List<CMapTable.CMapId> cmapIds = new ArrayList<CMapTable.CMapId>();
      cmapIds.add(CMapTable.CMapId.WINDOWS_BMP);
      byte[] newFontData = null;
      for (int i = 0; i < nIters; i++) {
        Font newFont = font;
        if (subsetString != null) {
          Subsetter subsetter = new RenumberingSubsetter(newFont, fontFactory);
          subsetter.setCMaps(cmapIds, 1);
          List<Integer> glyphs = GlyphCoverage.getGlyphCoverage(font, subsetString);
//          glyphs.clear();
//          glyphs.add(0);
//          glyphs.add(1770);
//          glyphs.add(2685);
          subsetter.setGlyphs(glyphs);
          Set<Integer> removeTables = new HashSet<Integer>();
          // Most of the following are valid tables, but we don't renumber them yet, so strip
          removeTables.add(Tag.GDEF);
          removeTables.add(Tag.GPOS);
          removeTables.add(Tag.GSUB);
          removeTables.add(Tag.kern);
          removeTables.add(Tag.hdmx);
          removeTables.add(Tag.vmtx);
          removeTables.add(Tag.VDMX);
          removeTables.add(Tag.LTSH);
          removeTables.add(Tag.DSIG);
          // AAT tables, not yet defined in sfntly Tag class
          removeTables.add(Tag.intValue(new byte[]{'m', 'o', 'r', 't'}));
          removeTables.add(Tag.intValue(new byte[]{'m', 'o', 'r', 'x'}));
          subsetter.setRemoveTables(removeTables);
          newFont = subsetter.subset().build();
        }
        if (strip) {
          Subsetter hintStripper = new HintStripper(newFont, fontFactory);
          Set<Integer> removeTables = new HashSet<Integer>();
          removeTables.add(Tag.fpgm);
          removeTables.add(Tag.prep);
          removeTables.add(Tag.cvt);
          removeTables.add(Tag.hdmx);
          removeTables.add(Tag.VDMX);
          removeTables.add(Tag.LTSH);
          removeTables.add(Tag.DSIG);
          hintStripper.setRemoveTables(removeTables);
          newFont = hintStripper.subset().build();
        }

        FileOutputStream fos = new FileOutputStream(outputFile);
        if (woff) {
          WritableFontData woffData = new WoffWriter().convert(newFont);
          woffData.copyTo(fos);
        } else if (eot) {
          WritableFontData eotData = new EOTWriter(mtx).convert(newFont);
          eotData.copyTo(fos);
        } else {
          fontFactory.serializeFont(newFont, fos);
        }
      }
    } finally {
      if (fis != null) {
        fis.close();
      }
    }
  }
}
