package com.serge.cv.email;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HttpStringResponseWrapper extends HttpServletResponseWrapper {

	private CharArrayWriter output;
	
	public HttpStringResponseWrapper(HttpServletResponse response) {
		super(response);
		 output = new CharArrayWriter();
	}

    public String toString() {
        return output.toString();
    }
      
    

    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }
}
