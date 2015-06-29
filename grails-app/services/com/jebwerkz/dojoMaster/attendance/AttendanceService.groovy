package com.jebwerkz.dojoMaster.attendance

import grails.transaction.Transactional
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.BaseColor
import com.itextpdf.text.pdf.BarcodeQRCode; 
import com.jebwerkz.dojoMaster.rank.Rank
import com.jebwerkz.dojoMaster.rank.Color

@Transactional
class AttendanceService {

	def grailsApplication

	private BaseColor white = BaseColor.WHITE
	private BaseColor yellow = new BaseColor(255,251,0)
	private BaseColor orange = new BaseColor(255,147,0)
	private BaseColor green = new BaseColor(142,250,0)
	private BaseColor blue = new BaseColor(0,150,255)
	private BaseColor brown = new BaseColor(148,82,0)
	private BaseColor purple = new BaseColor(148,55,255)
	private BaseColor red = new BaseColor(255,38,0)
	private BaseColor black = BaseColor.BLACK
	private BaseColor grey = BaseColor.GRAY
	
	// private BaseColor tan
	// private BaseColor lightGreen
	// private BaseColor lightBlue
	// private BaseColor navyBlue

    def serviceMethod() {

    }

    def generateAttendanceCard() {
        return  
    } 

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws DocumentException 
     * @throws IOException 
     * @throws    DocumentException 
     * @throws    IOException
     */
    def createPdf(attendanceCard) throws IOException, DocumentException {
        Document document = new Document(PageSize.LETTER.rotate());
        def baos = new ByteArrayOutputStream()
        PdfWriter writer = PdfWriter.getInstance(document,baos);

		Font bannerFont = new Font(FontFamily.HELVETICA, 36, Font.BOLD);
		Font circleFont = new Font(FontFamily.HELVETICA, 24);

        document.open();

        PdfContentByte canvas = writer.getDirectContent();
		
		def primaryColor = getPrimaryColor(attendanceCard)
		def secondaryColor = getSecondaryColor(attendanceCard)
		def nextColor = getNextColor(attendanceCard)
		

		//Left Vertical Bar
		String attendanceBanner = "${attendanceCard.rank.name} Attendance"
		def rankParts = attendanceCard.rank.name.tokenize(' ')
		String attendanceCircle = rankParts[0] + "\n" + rankParts[1]
		
		canvas.saveState()
        canvas.setColorStroke(black)
        canvas.setLineWidth(3)
        canvas.setColorFill(primaryColor)
        canvas.roundRectangle(18, 18, 82.8, 576, 41.4)
        canvas.fillStroke()
        canvas.restoreState()
		
		if(secondaryColor) {
	        canvas.saveState()
	        canvas.setColorStroke(black)
        	canvas.setLineWidth(0)
	        canvas.setColorFill(secondaryColor)
	        canvas.roundRectangle(35, 18, 49.68, 576, 24.84)
	        canvas.fillStroke()
	        canvas.restoreState()
		}

		Phrase banner = new Phrase(attendanceBanner, bannerFont)
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, banner, 70, 306, 90);

		//Upper Right Circle
		
        //dpi:72
        //radius: 54
        //width:792
        //height:612
        
        canvas.saveState();
        canvas.setColorStroke(black);
        canvas.setLineWidth(3)
        canvas.setColorFill(primaryColor);
        canvas.circle(707.16f, 542.16f, 54);
        canvas.fillStroke();
        canvas.restoreState();
        
        if(secondaryColor) {
	        canvas.saveState();
	        canvas.setColorStroke(black);
        	canvas.setLineWidth(0)
	        canvas.setColorFill(secondaryColor);
	        canvas.roundRectangle(653.16f, 515.16f, 108, 54, 27);
	        canvas.fillStroke();
	        canvas.restoreState()
        }

		Phrase circle = new Phrase(attendanceCircle, circleFont)
        ColumnText ct = new ColumnText(canvas)
        ct.setSimpleColumn(circle, 1210, 572, 200, 100,
    		24, Element.ALIGN_CENTER)
        ct.go()

        //QR Code
        
        BarcodeQRCode qrcode = new BarcodeQRCode("attendanceCard:$attendanceCard.id", 1, 1, null);
        def img = qrcode.getImage();
        img.setAbsolutePosition(545,487.16);
        img.scaleAbsolute(108, 108)
        document.add(img);

		//Student Info Block
		
		Font whiteText = new Font(FontFamily.HELVETICA, 10, Font.NORMAL, white);
		Font blackText = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
		
		PdfPTable studentInfo = new PdfPTable(2)
		def height = 30f
		def width  = 100f
		
		PdfPCell fNameLabel = new PdfPCell(new Phrase("FIRST NAME", whiteText))
		fNameLabel.setHorizontalAlignment(Element.ALIGN_CENTER)
		
		PdfPCell lNameLabel = new PdfPCell(new Phrase("LAST NAME", whiteText))
		lNameLabel.setHorizontalAlignment(Element.ALIGN_CENTER)

		studentInfo.addCell(fNameLabel)
		studentInfo.addCell(lNameLabel)
		
		studentInfo.setTotalWidth((float)(2 * width))
		studentInfo.setWidths([width, width] as float[])
		studentInfo.writeSelectedRows(0, -1, 20.28f, (float)(studentInfo.getTotalHeight() + 20.0f), canvas);
		//Attendance List
		
		//Five Areas of Testing

		//Stripe Block
		
		whiteText = new Font(FontFamily.HELVETICA, 14, Font.BOLD, white);
		blackText = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
		
		PdfPTable stripeTable = new PdfPTable(3)
		
		def side = 30f
		
		PdfPCell leftPrimaryBlank = new PdfPCell(new Phrase(" "))
		leftPrimaryBlank.setBackgroundColor(primaryColor)
		leftPrimaryBlank.setFixedHeight(side);
		if(secondaryColor == null) leftPrimaryBlank.setBorderWidthRight(0)
		
		PdfPCell rightPrimaryBlank = new PdfPCell(new Phrase(" "))
		rightPrimaryBlank.setBackgroundColor(primaryColor)
		rightPrimaryBlank.setFixedHeight(side);
		if(secondaryColor == null) rightPrimaryBlank.setBorderWidthLeft(0)
		
		
		PdfPCell secondaryBlank = new PdfPCell(new Phrase(" "))
		secondaryBlank.setBackgroundColor(secondaryColor?:primaryColor)
		secondaryBlank.setFixedHeight(side);
		secondaryBlank.setBorderWidthLeft(0)
		secondaryBlank.setBorderWidthRight(0)
		
		PdfPCell attitudeStripe = new PdfPCell(new Phrase("Attitude", whiteText))
		attitudeStripe.setBackgroundColor(black)
		attitudeStripe.setColspan(3);
		attitudeStripe.setVerticalAlignment(Element.ALIGN_MIDDLE)
		attitudeStripe.setHorizontalAlignment(Element.ALIGN_CENTER)
		attitudeStripe.setFixedHeight(side);
		
		PdfPCell applicationStripe = new PdfPCell(new Phrase("Application", blackText))
		applicationStripe.setBackgroundColor(nextColor)
		applicationStripe.setColspan(3);
		applicationStripe.setVerticalAlignment(Element.ALIGN_MIDDLE)
		applicationStripe.setHorizontalAlignment(Element.ALIGN_CENTER)
		applicationStripe.setFixedHeight(side);
		
		PdfPCell fundamentalsStripe = new PdfPCell(new Phrase("Fundamentals", blackText))
		fundamentalsStripe.setBackgroundColor(nextColor)
		fundamentalsStripe.setColspan(3);
		fundamentalsStripe.setVerticalAlignment(Element.ALIGN_MIDDLE)
		fundamentalsStripe.setHorizontalAlignment(Element.ALIGN_CENTER)
		fundamentalsStripe.setFixedHeight(side);
		
		stripeTable.addCell(leftPrimaryBlank)
		stripeTable.addCell(secondaryBlank)
		stripeTable.addCell(rightPrimaryBlank)
		
		stripeTable.addCell(attitudeStripe)
		
		stripeTable.addCell(leftPrimaryBlank)
		stripeTable.addCell(secondaryBlank)
		stripeTable.addCell(rightPrimaryBlank)
		
		stripeTable.addCell(applicationStripe)
		
		stripeTable.addCell(leftPrimaryBlank)
		stripeTable.addCell(secondaryBlank)
		stripeTable.addCell(rightPrimaryBlank)
		
		stripeTable.addCell(fundamentalsStripe)
		
		stripeTable.addCell(leftPrimaryBlank)
		stripeTable.addCell(secondaryBlank)
		stripeTable.addCell(rightPrimaryBlank)
		
		stripeTable.setTotalWidth((float)(3 * side))
		stripeTable.setWidths([side,side,side] as float[])
		stripeTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        stripeTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		stripeTable.writeSelectedRows(0, -1, 341.28f, (float)(stripeTable.getTotalHeight() + 20.0f), canvas);
		// document.add(stripeTable)
		
		//Finish Up
        document.close();
        return baos
    }
 
    /**
     * Draws a row of squares.
     * @param canvas the canvas to which the squares have to be drawn
     * @param x      X coordinate to position the row
     * @param y      Y coordinate to position the row
     * @param side   the side of the square
     * @param gutter the space between the squares
     */
    public void createSquares(PdfContentByte canvas,
        float x, float y, float side, float gutter) {
        canvas.saveState();
        canvas.setColorStroke(new GrayColor(0.2f));
        canvas.setColorFill(new GrayColor(0.9f));
        canvas.moveTo(x, y);
        canvas.lineTo(x + side, y);
        canvas.lineTo(x + side, y + side);
        canvas.lineTo(x, y + side);
        canvas.stroke();
        x = x + side + gutter;
        canvas.moveTo(x, y);
        canvas.lineTo(x + side, y);
        canvas.lineTo(x + side, y + side);
        canvas.lineTo(x, y + side);
        canvas.closePathStroke();
        x = x + side + gutter;
        canvas.moveTo(x, y);
        canvas.lineTo(x + side, y);
        canvas.lineTo(x + side, y + side);
        canvas.lineTo(x, y + side);
        canvas.fill();
        x = x + side + gutter;
        canvas.moveTo(x, y);
        canvas.lineTo(x + side, y);
        canvas.lineTo(x + side, y + side);
        canvas.lineTo(x, y + side);
        canvas.fillStroke();
        x = x + side + gutter;
        canvas.moveTo(x, y);
        canvas.lineTo(x + side, y);
        canvas.lineTo(x + side, y + side);
        canvas.lineTo(x, y + side);
        canvas.closePathFillStroke();
        canvas.restoreState();
    }
 
    /**
     * Draws a series of Bezier curves
     * @param cb the canvas to which the curves have to be drawn
     * @param x0 X coordinate of the start point
     * @param y0 Y coordinate of the start point
     * @param x1 X coordinate of the first control point
     * @param y1 Y coordinate of the first control point
     * @param x2 X coordinate of the second control point
     * @param y2 Y coordinate of the second control point
     * @param x3 X coordinate of the end point
     * @param y3 Y coordinate of the end point
     * @param distance the distance between the curves
     */
    public void createBezierCurves(PdfContentByte cb, float x0, float y0,
        float x1, float y1, float x2, float y2, float x3, float y3, float distance) {
        cb.moveTo(x0, y0);
        cb.lineTo(x1, y1);
        cb.moveTo(x2, y2);
        cb.lineTo(x3, y3);
        cb.moveTo(x0, y0);
        cb.curveTo(x1, y1, x2, y2, x3, y3);
        x0 += distance;
        x1 += distance;
        x2 += distance;
        x3 += distance;
        cb.moveTo(x2, y2);
        cb.lineTo(x3, y3);
        cb.moveTo(x0, y0);
        cb.curveTo(x2, y2, x3, y3);
        x0 += distance;
        x1 += distance;
        x2 += distance;
        x3 += distance;
        cb.moveTo(x0, y0);
        cb.lineTo(x1, y1);
        cb.moveTo(x0, y0);
        cb.curveTo(x1, y1, x3, y3);
        cb.stroke();
 
    }
 
    /**
     * Draws a row of stars and circles.
     * @param canvas the canvas to which the shapes have to be drawn
     * @param x      X coordinate to position the row
     * @param y      Y coordinate to position the row
     * @param radius the radius of the circles
     * @param gutter the space between the shapes
     */
    public static void createStarsAndCircles(PdfContentByte canvas,
        float x, float y, float radius, float gutter) {
        canvas.saveState();
        canvas.setColorStroke(new GrayColor(0.2f));
        canvas.setColorFill(new GrayColor(0.9f));
        createStar(canvas, x, y);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), radius.floatValue(), true);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), (radius / 2).floatValue(), true);
        canvas.fill();
        x += 2 * radius + gutter;
        createStar(canvas, x, y);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), radius.floatValue(), true);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), (radius / 2).floatValue(), true);
        canvas.eoFill();
        x += 2 * radius + gutter;
        createStar(canvas, x, y);
        canvas.newPath();
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), radius.floatValue(), true);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), (radius / 2).floatValue(), true);
        x += 2 * radius + gutter;
        createStar(canvas, x, y);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), radius.floatValue(), true);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), (radius / 2).floatValue(), false);
        canvas.fillStroke();
        x += 2 * radius + gutter;
        createStar(canvas, x, y);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), radius.floatValue(), true);
        createCircle(canvas, (x + radius).floatValue(), (y - 70).floatValue(), (radius / 2).floatValue(), true);
        canvas.eoFillStroke();
        canvas.restoreState();
    }
 
    /**
     * Creates a path for a five pointed star.
     * This method doesn't fill or stroke the star!
     * @param canvas the canvas for which the star is constructed
     * @param x      the X coordinate of the center of the star
     * @param y      the Y coordinate of the center of the star
     */
    public static void createStar(PdfContentByte canvas, float x, float y) {
        canvas.moveTo(x + 10, y);
        canvas.lineTo(x + 80, y + 60);
        canvas.lineTo(x, y + 60);
        canvas.lineTo(x + 70, y);
        canvas.lineTo(x + 40, y + 90);
        canvas.closePath();
    }
 
    /**
     * Creates a path for circle using Bezier curvers.
     * The path can be constructed clockwise or counter-clockwise.
     * This method doesn't fill or stroke the circle!
     * @param canvas    the canvas for which the path is constructed 
     * @param x         the X coordinate of the center of the circle
     * @param y         the Y coordinate of the center of the circle
     * @param r         the radius
     * @param clockwise true if the circle has to be constructed clockwise
     */
    public static void createCircle(PdfContentByte canvas, float x, float y,
        float r, boolean clockwise) {
        float b = 0.5523f;
        if (clockwise) {
            canvas.moveTo(x + r, y);
            canvas.curveTo(x + r, y - r * b, x + r * b, y - r, x, y - r);
            canvas.curveTo(x - r * b, y - r, x - r, y - r * b, x - r, y);
            canvas.curveTo(x - r, y + r * b, x - r * b, y + r, x, y + r);
            canvas.curveTo(x + r * b, y + r, x + r, y + r * b, x + r, y);
        } else {
            canvas.moveTo(x + r, y);
            canvas.curveTo(x + r, y + r * b, x + r * b, y + r, x, y + r);
            canvas.curveTo(x - r * b, y + r, x - r, y + r * b, x - r, y);
            canvas.curveTo(x - r, y - r * b, x - r * b, y - r, x, y - r);
            canvas.curveTo(x + r * b, y - r, x + r, y - r * b, x + r, y);
        }
    }
    
    private BaseColor getPrimaryColor(attendanceCard) {
    	return getColor(attendanceCard.rank.beltColor.id)
    }
    
    private BaseColor getSecondaryColor(attendanceCard) {
    	def color = attendanceCard?.rank?.beltStripeColor?.id?:0
    	return getColor(color)
    }
    
    private BaseColor getNextColor(attendanceCard) {
    	def color = attendanceCard?.rank?.skillStripeColor?.id?:0
    	return getColor(color)
    }
    
    private BaseColor getPrimaryTextColor(attendanceCard) {
    	return getTextColor(attendanceCard.rank.beltColor.id)
    }   
    
    private BaseColor getSecondaryTextColor(attendanceCard) {
    	def color = attendanceCard?.rank?.beltStripeColor?.id?:0
    	return getTextColor(color)
    }
    
    private BaseColor getNextTextColor(attendanceCard) {
    	def color = attendanceCard?.rank?.skillStripeColor?.id?:0
    	return getTextColor(color)
    }
    
    private BaseColor getColor(id) {
    	switch(id) {
    		case grailsApplication.config.color.white:
    			return white
    		case grailsApplication.config.color.yellow:
    			retrun yellow
    		case grailsApplication.config.color.orange:
    			return orange
    		case grailsApplication.config.color.green:
    			return green
    		case grailsApplication.config.color.blue:
    			return blue
    		case grailsApplication.config.color.brown:
    			return brown
    		case grailsApplication.config.color.purple:
    			return purple
    		case grailsApplication.config.color.red:
    			return red
    		case grailsApplication.config.color.black:
    			return black
    		default:
    			return null
    		
    	}
    }
    
    private BaseColor getTextColor(id) {
    	switch(id) {
    		case grailsApplication.config.color.white:
    			return black
    		case grailsApplication.config.color.yellow:
    			retrun black
    		case grailsApplication.config.color.orange:
    			return black
    		case grailsApplication.config.color.green:
    			return black
    		case grailsApplication.config.color.blue:
    			return black
    		case grailsApplication.config.color.brown:
    			return black
    		case grailsApplication.config.color.purple:
    			return black
    		case grailsApplication.config.color.red:
    			return black
    		case grailsApplication.config.color.black:
    			return white
    		default:
    			return black
    	}
    	
    }
}
