package Practice;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.lang.reflect.Field;

enum TextFormat {
    CAPITALIZE, LOWERCASE, PLAIN
}
enum CurrencyFormat {
    USD,EURO,INR
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFormat {
    TextFormat text_format() default TextFormat.PLAIN;
    CurrencyFormat currency_format() default CurrencyFormat.USD;
}

class Invoice{
    private Date invoiceDate;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String invoiceNumber;
    private int qtr;
    private int year;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String customerName;
    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double totalAmount;
    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double taxAmount;
    private double netAmount;

    public Invoice(InvoiceBuilder builder){
        this.invoiceDate = builder.invoiceDate;
        this.invoiceNumber = builder.invoiceNumber;
        this.qtr = builder.qtr;
        this.year = builder.year;
        this.customerName = builder.customerName;
        this.totalAmount = builder.totalAmount;
        this.taxAmount = builder.taxAmount;
        this.netAmount = builder.netAmount;
    }

    public Date getInvoiceDate(){
        return invoiceDate;
    }
    public String getInvoiceNumber(){
        return invoiceNumber;
    }
    public int getQtr(){
        return qtr;
    }
    public int getYear(){
        return year;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getTotalAmount(){
        return totalAmount;
    }
    public double getTaxAmount(){
        return taxAmount;
    }
    public double getNetAmount(){
        return netAmount;
    }
    public static class InvoiceBuilder{
        private Date invoiceDate;
        private String invoiceNumber;
        private int qtr;
        private int year;
        private String customerName;
        private double totalAmount;
        private double taxAmount;
        private double netAmount;

        public InvoiceBuilder(){

        }
        public InvoiceBuilder setInvoiceDate(Date invoiceDate){
            this.invoiceDate = invoiceDate;
            return this;
        }
        public InvoiceBuilder setInvoiceNumber(String invoiceNumber){
            this.invoiceNumber = invoiceNumber;
            return this;
        }
        public InvoiceBuilder setQtr(int qtr){
            this.qtr = qtr;
            return this;
        }
        public InvoiceBuilder setYear(int year){
            this.year = year;
            return this;
        }
        public InvoiceBuilder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }
        public InvoiceBuilder setTotalAmount(double totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }
        public InvoiceBuilder setTaxAmount(double taxAmount){
            this.taxAmount = taxAmount;
            return this;
        }
        public InvoiceBuilder setNetAmount(double netAmount){
            this.netAmount = netAmount;
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }
}

class InvalidInvoiceException extends RuntimeException{
    public InvalidInvoiceException(String message){
        super(message);
    }
    public InvalidInvoiceException(String message, Throwable cause){
        super(message, cause);
    }
}

class InvoiceProcessor{
    private List<Invoice> invoice = new ArrayList<>();

    public void prep2 (String filename){
        this.invoice = loadInvoices(filename);
    }

    public List<Invoice> getInvoices(){
        return invoice;
    }

    public static List<Invoice> loadInvoices(String filename){
        List<Invoice> invoices = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().collect(Collectors.toList());
            for(int i = 0; i < lines.size(); i++){
                String[] part = lines.get(i).split(";");
                if (part[0] == "" || part[1] == "" || part[5] == "") {
                    throw new InvalidInvoiceException("Missing required field", new ClassNotFoundException());
                }
                invoices.add(
                        new Invoice.InvoiceBuilder()
                                .setInvoiceDate(new SimpleDateFormat("yyyy/MM/dd").parse(part[0]))
                                .setInvoiceNumber(part[1])
                                .setCustomerName(part[2])
                                .setQtr(Integer.parseInt(part[3]))
                                .setYear(Integer.parseInt(part[4]))
                                .setTotalAmount(Double.parseDouble(part[5]))
                                .setTaxAmount(Double.parseDouble(part[6]))
                                .setNetAmount(Double.parseDouble(part[7]))
                                .build()
                );
            }

        } catch (FileNotFoundException e){
        } catch (ParseException e){
            e.printStackTrace();
        }
        return invoices;
    }
}

class CSVReportGenerator{
    public static void generateReport(String outputFilename, List<Invoice> invoices){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            writer.write("InvoiceDate,InvoiceNumber,CustomerName,Qtr,Year,TotalAmount,TaxAmount,NetAmount\n");

            Class clazz = Invoice.class;
            Field[] fields = clazz.getDeclaredFields();

            for (Invoice invoice : invoices){
                for(int i = 0; i < fields.length; i++){
                    fields[i].setAccessible(true);
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
