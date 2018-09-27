package com.ecity.java.json;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * JSON打印器
 * @author jiujie
 * @version $Id: JSONPrinter.java, v 0.1 2016年7月28日 下午5:08:41 jiujie Exp $
 */
public class JSONPrinter {

    private Object jsonObj;

    /** 
     * JSON文件打印器
     * constructor
     * @author jiujie
     * 2016年7月28日 下午5:08:59
     * @param jsonFile
     */
    public JSONPrinter(File jsonFile) {
        this.jsonObj = jsonFile;
    }

    /** 
     * JSON字符串打印器
     * constructor
     * @author jiujie
     * 2016年7月28日 下午5:08:59
     * @param jsonString
     */
    public JSONPrinter(String jsonString) {
        this.jsonObj = jsonString;
    }

    public void print() {
        if (jsonObj instanceof File) {
            try {
                print(new FileInputStream((File) jsonObj));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jsonObj instanceof String) {
            try {
                print(new ByteArrayInputStream(((String) jsonObj).getBytes()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void print(InputStream inputStream) throws IOException {

        InputStreamReader in = new InputStreamReader(inputStream);
        int read = 0;
        int indent = 0;
        while ((read = in.read()) > 0) {
            char ch = (char) read;
            switch (ch) {
                case '{': {
                    indent = printAndRightMove(indent, ch);
                    break;
                }
                case '}': {
                    indent = printAndLeftMove(indent, ch);
                    break;
                }
                case '[': {
                    indent = printAndRightMove(indent, ch);
                    break;
                }
                case ']': {
                    indent = printAndLeftMove(indent, ch);
                    break;
                }
                case ',': {
                    System.out.println(ch);
                    System.out.print(getBlankString(indent));
                    break;
                }
                default: {
                    System.out.print(ch);
                    break;
                }
            }
        }
        in.close();
    }

    private int printAndLeftMove(int indent, char ch) {
        System.out.println();
        indent -= 2;
        System.out.print(getBlankString(indent) + ch);
        return indent;
    }

    private int printAndRightMove(int indent, char ch) {
        System.out.println();
        System.out.println(getBlankString(indent) + ch);
        indent += 2;
        System.out.print(getBlankString(indent));
        return indent;
    }

    private String getBlankString(int length) {
        if (length <= 0) {
            return "";
        }
        String blankString = "";
        for (int i = 0; i < length; i++) {
            blankString += " ";
        }
        return blankString;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	
        JSONPrinter stringJsonPrinter = new JSONPrinter("{score:100,age:30}");
        stringJsonPrinter.print();
    }

}
