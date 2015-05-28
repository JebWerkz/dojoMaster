package com.jebwerkz.dojoMaster.attendance

import grails.transaction.Transactional
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.BaseColor
import com.itextpdf.text.pdf.BarcodeQRCode; 

@Transactional
class AttendanceService {

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

        document.open();

        PdfContentByte canvas = writer.getDirectContent();

        canvas.saveState()
        canvas.setColorStroke(BaseColor.BLACK)
        canvas.setColorFill(BaseColor.BLUE)
        canvas.roundRectangle(18, 18, 82.8, 576, 41.4)
        canvas.fillStroke()
        canvas.restoreState()

        canvas.saveState()
        canvas.setColorStroke(BaseColor.BLACK)
        canvas.setColorFill(BaseColor.WHITE)
        canvas.roundRectangle(35, 18, 49.68, 576, 24.84)
        canvas.fillStroke()
        canvas.restoreState()



        canvas.saveState();
        canvas.setColorStroke(new GrayColor(0.2f));
        canvas.setColorFill(new GrayColor(0.9f));
        //dpi:72
        //radius: 54
        //width:792
        //height:612
        canvas.circle(707.16f, 542.16f, 54);
        canvas.fillStroke();
        canvas.restoreState();
        
        canvas.saveState();
        canvas.setColorStroke(BaseColor.BLACK);
        canvas.setColorFill(BaseColor.WHITE);
        canvas.roundRectangle(653.16f, 515.16f, 108, 54, 27);
        canvas.fillStroke();
        canvas.restoreState()

        BarcodeQRCode qrcode = new BarcodeQRCode("attendanceCard:$attendanceCard.id", 1, 1, null);
        def img = qrcode.getImage();
        img.setAbsolutePosition(545,487.16);
        img.scaleAbsolute(108, 108)
        document.add(img);

        // step 5
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
}
